import { Component, OnInit } from '@angular/core';
import { MesasService } from '../Services/mesas.service';
import { mesa } from '../Models/mesa';

@Component({
  selector: 'app-mesas-component',
  templateUrl: './mesas-component.component.html',
  styleUrls: ['./mesas-component.component.css']
})
export class MesasComponentComponent implements OnInit{
  numeroPiso = 1;
  mesas:mesa[]=[];
  seleccion=0;
  mensajeConexion='No se pudieron cargar los recursos, compruebe la conexion a la base de datos';
  listaDeImagenes:string[]=[
    'assets/mesa5.png',
    'assets/mesa2.png',
    'assets/mesa2.png',
    'assets/mesa2.png',
    'assets/mesa2.png',
    'assets/mesa5.png',
    'assets/mesa6.png',
    'assets/mesa6.png',
    'assets/mesa6.png',
    'assets/mesa6.png',
    'assets/mesa5.png',
    'assets/mesa2.png',
    'assets/mesa2.png',
    'assets/mesa2.png',
    'assets/mesa2.png',
    'assets/mesa5.png'
  ];
  constructor(private mesasService:MesasService){}
  ngOnInit(): void {
    this.mesasService.obtenerMesas().subscribe(misMesas=>{
        try{
          this.mesas=Object.values(misMesas);
          this.mesasService.setMesas(this.mesas);
          console.log(this.mesas);
        }catch{
          this.mesas = [];
        }
      });
  }
  ver(id:number){
    this.seleccion=id;
  }
  
}
