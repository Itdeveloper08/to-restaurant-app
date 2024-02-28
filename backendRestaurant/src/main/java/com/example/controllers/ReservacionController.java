package com.example.controllers;

import com.example.dtos.reservacionDto;
import com.example.models.MesaModel;
import com.example.models.ReservacionMesaModel;
import com.example.models.ReservacionModel;
import com.example.services.MesaService;
import com.example.services.ReservacionMesaService;
import com.example.services.ReservacionService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservacion")
public class ReservacionController {

    @Autowired
    ReservacionService reservacionS;
    
    @Autowired
    ReservacionMesaService reservaMesaS;

    @Autowired
    MesaService mesaS;

    @GetMapping()
    public ArrayList<ReservacionModel> obtenerReservaciones() {
        return (ArrayList<ReservacionModel>) reservacionS.obtenerReservaciones();
    }

    @PostMapping()
    public ResponseEntity<?> guardarReservacion(@RequestBody reservacionDto reservacion) {
        ReservacionModel retorno = convertirDtoAReservacion(reservacion);
        //Si no vienen mesas en la reservacion
        if(reservacion.getMesas()==null){
            ReservacionModel retornoReservacionModel = this.reservacionS.guardarReservacion(retorno);
            if (retornoReservacionModel == null) {
                return ResponseEntity.badRequest().body("La reservacion no pudo guardarse, revise la estructura del json");
            }
            return ResponseEntity.ok(retornoReservacionModel);
        }
        //todas las mesas en la lista deben tener id
        if (!reservacion.getMesas().stream().allMatch(mesa -> mesa.getId() != null)) {
            return ResponseEntity.badRequest().body("Las mesas no se proporcionaron correctamente en la reservación.");
        }
        //Revisar si los id en la lista de mesas que se reciben, existen en la lista de mesas almacenadas
        ArrayList<MesaModel> mesasEnBd = mesaS.obtenerMesas();
        ArrayList<MesaModel> mesasEnPost = (ArrayList<MesaModel>) reservacion.getMesas();

        for (MesaModel mesaPost : mesasEnPost) {
            boolean existeEnBd = false;
            for (MesaModel mesaBd : mesasEnBd) {
                if (mesaPost.getId() != null && mesaPost.getId().equals(mesaBd.getId())) {
                    // La mesa en la solicitud POST existe en la base de datos
                    existeEnBd = true;
                    break;
                }
            }
            if (!existeEnBd) {
                return ResponseEntity.badRequest().body("Las mesas proporcionadas no se econtraron en los registros");
            }
        }
        //En este punto, verificamos que la reservacion y las mesas si son validas
        ReservacionModel retornoR = this.reservacionS.guardarReservacion(retorno);
        if (retornoR == null) {
            return ResponseEntity.badRequest().body("La reservacion no pudo guardarse, revise la estructura del json");
        }
        //guardando todas las mesas en la reservacion
        
        boolean mesasGuardadas = true;
        for (MesaModel mesaPost : mesasEnPost) {
            ReservacionMesaModel reservacionMesaModel = new ReservacionMesaModel();
            reservacionMesaModel.setReservacion(retornoR);
            reservacionMesaModel.setMesa(mesaPost);
            try {
                ReservacionMesaModel savedReservacionMesa = reservaMesaS.guardarReservacionMesa(reservacionMesaModel);
            } catch (IllegalArgumentException e) {
                mesasGuardadas = false;
            }
        }
        if(!mesasGuardadas){
            return ResponseEntity.badRequest().body("Las mesas presentaron error");
        }
        return ResponseEntity.ok("Reservacion guardada correctamente");
    }

    private ReservacionModel convertirDtoAReservacion(reservacionDto reservacion) {
        ReservacionModel retorno = new ReservacionModel();
        retorno.setId(reservacion.getId());
        retorno.setPersona(reservacion.getPersona());
        retorno.setDuiPersona(reservacion.getDuiPersona());
        retorno.setFechaReservacion(reservacion.getFechaReservacion());
        retorno.setFechaReserva(reservacion.getFechaReserva());
        retorno.setHoraReserva(reservacion.getHoraReserva());
        retorno.setNumPersonas(reservacion.getNumPersonas());
        retorno.setActiva(reservacion.isActiva());
        return retorno;
    }

}
