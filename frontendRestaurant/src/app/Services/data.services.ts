import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { mesa } from "../Models/mesa";
import { Observable } from "rxjs";

@Injectable()
export class DataServices{
    constructor(private HttpClient:HttpClient){}
    cargarMesas(){
        return this.HttpClient.get('http://localhost:8080/mesas');
    }
    guardarMesa(mesa: mesa): Observable<boolean> {
        return new Observable<boolean>((observer) => {
            this.HttpClient.put('http://localhost:8080/mesas', mesa).subscribe({
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
 
}