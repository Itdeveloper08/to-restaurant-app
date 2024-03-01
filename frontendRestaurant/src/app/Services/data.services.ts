import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { mesa } from "../Models/mesa";
import { Observable } from "rxjs";
import { reservacion } from "../Models/reservacion";
import { reservacionMesa } from "../Models/reservacionMesa";

@Injectable()
export class DataServices{
    constructor(private HttpClient:HttpClient){}
    cargarMesas(){
        return this.HttpClient.get('http://localhost:8080/mesas');
    }
    guardarMesa(mesa: mesa): Observable<boolean> {
        return new Observable<boolean>((observer) => {
            this.HttpClient.post('http://localhost:8080/mesas', mesa).subscribe({
                next: (response) => {
                    console.log('Se ha guardado la mesa ' + response);
                    observer.next(true);
                    observer.complete();
                },
                error: (error) => {
                    console.log('Error' + error);
                    observer.next(false);
                    observer.complete();
                },
            });
        });
    }

    cargarReservaciones(){
        return this.HttpClient.get('http://localhost:8080/reservacion');
    }
    cargarReservacionesPorFecha(fecha:string){
        return this.HttpClient.get('http://localhost:8080/reservacion/'+fecha);
    }
    EliminarReservacion(id:number){
        return this.HttpClient.delete('http://localhost:8080/reservacion/'+id);
    }

    guardarReservacion(reservacion: reservacion): Observable<boolean> {
        return new Observable<boolean>((observer) => {
            this.HttpClient.post('http://localhost:8080/reservacion', reservacion).subscribe({
                next: (response) => {
                    console.log('Se ha guardado la reservacion ' + response);
                    observer.next(true);
                    observer.complete();
                },
                error: (error) => {
                    console.log('Error' + error);
                    observer.next(false);
                    observer.complete();
                },
            });
        });
    }
    agregarMesaAReservacion(reservacionesMesa: reservacionMesa): Observable<boolean> {
        return new Observable<boolean>((observer) => {
            this.HttpClient.post('http://localhost:8080/reservacionMesa', reservacionesMesa).subscribe({
                next: (response) => {
                    console.log('Se agregó la mesa exitosamente ' + response);
                    observer.next(true);
                    observer.complete();
                },
                error: (error) => {
                    console.log('Error' + error);
                    observer.next(false);
                    observer.complete();
                },
            });
        });
    }
}