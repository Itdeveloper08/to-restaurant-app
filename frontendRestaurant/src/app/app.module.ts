import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponentComponent } from './navbar-component/navbar-component.component';

import { RouterModule, Routes } from '@angular/router';
import { MesasComponentComponent } from './mesas-component/mesas-component.component';
import { ErrorPersonalizadoComponentComponent } from './error-personalizado-component/error-personalizado-component.component';
import { InicioComponentComponent } from './inicio-component/inicio-component.component';
import { ReservacionesComponentComponent } from './reservaciones-component/reservaciones-component.component';
import { DataServices } from './Services/data.services';
import { MesasService } from './Services/mesas.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

const appRoutes:Routes=[
  {path:'', component:InicioComponentComponent},
  {path:'mesas', component:MesasComponentComponent},
  {path:'reservaciones', component:ReservacionesComponentComponent},
  {path:'**', component:ErrorPersonalizadoComponentComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponentComponent,
    MesasComponentComponent,
    InicioComponentComponent,
    ReservacionesComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [DataServices,MesasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
