import { Injectable } from "@angular/core";
import { reservacion } from "../Models/reservacion";
import { DataServices } from "./data.services";
import Swal from 'sweetalert2';

@Injectable()
export class ReservacionesService{
    reservaciones:reservacion[]=[];
    constructor(private dataService:DataServices){}
    
    obtenerReservaciones(){
        return this.dataService.cargarReservaciones();
    }
    obtenerReservacionesPorFecha(fecha:string){
        return this.dataService.cargarReservacionesPorFecha(fecha);
    }
    EliminarReservacion(id:number){
        return this.dataService.EliminarReservacion(id);
    }
    setReservaciones(misReservaciones:reservacion[]){
        this.reservaciones=misReservaciones;
    }
    agregarReservacion(r:reservacion){
        const listaReservaciones = this.reservaciones;
        this.reservaciones.push(r);
        this.dataService.guardarReservacion(r).subscribe(resultado=>{
            if(resultado){
                Swal.fire(
                    'Reservacion',
                    'guardada correctamente',
                    'success'
                  ).then((result) => {
                    
                  })
            }else{
                this.reservaciones = listaReservaciones;
                  Swal.fire(
                    'Error!',
                    'Ocurrio un error al intentar guardar la reservacion',
                    'success'
                  )
            }
        });
    }
}