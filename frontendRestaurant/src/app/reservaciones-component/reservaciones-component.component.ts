import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReservacionesService } from '../Services/reservaciones.service';
import { reservacion } from '../Models/reservacion';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reservaciones-component',
  templateUrl: './reservaciones-component.component.html',
  styleUrls: ['./reservaciones-component.component.css']
})
export class ReservacionesComponentComponent implements OnInit{
  reservaciones:reservacion[]=[];
  constructor(private router:Router, private reservacionesService:ReservacionesService){}
  ngOnInit(): void {
    this.reservacionesService.obtenerReservaciones().subscribe(misReservaciones=>{
      try{
        this.reservaciones=Object.values(misReservaciones);
        this.reservacionesService.setReservaciones(this.reservaciones);
        console.log(this.reservaciones);
      }
      catch{
        this.reservaciones = [];
      }
    });
  }

  parseDate(fecha:string){
    return fecha.substring(0, 10);
  }

  nuevaReservacion(){
    this.router.navigate(['/reservacion']);
  }
  inspeccionarReservacion(id:number){}
  modificarReservacion(id:number){}
  eliminarReservacion(pos:number){
    Swal.fire({
      title: '¿Deseas borrar la reservacion?',
      text: "Esta accion no se podrá revertir!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: '¡Sí, agregar!'
    }).then((result) => {
      if (result.isConfirmed) {
        let num = this.reservaciones[pos].id;
        if(num){
          this.reservacionesService.EliminarReservacion(num);
        }
      }
    })
  }
}
