package com.example.services;

import com.example.dao.MesaDao;
import com.example.models.ReservacionModel;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.ReservacionDao;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservacionServiceImp implements ReservacionService{
    @Autowired
    ReservacionDao reservacionesDao;
    
    @Autowired
    MesaDao mesaDao;
    
    @Transactional(readOnly=true)
    public ArrayList<ReservacionModel> obtenerReservaciones(){
        return (ArrayList<ReservacionModel>) reservacionesDao.findAll();
    }
  
    @Transactional
    public ReservacionModel guardarReservacion(ReservacionModel ReservacionM){
        return reservacionesDao.save(ReservacionM);
    }
    
    
    @Transactional(readOnly=true)
    public Optional<ReservacionModel> obtenerPorId(Long id){
        return reservacionesDao.findById(id);
    }
    
    @Transactional
    @Override
    public boolean eliminarReservacion(Long id){
        try{
            reservacionesDao.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @Transactional(readOnly=true)
    public ArrayList<ReservacionModel> obtenerPorPersona(String persona){
        return reservacionesDao.findByPersona(persona);
    }
    
    @Transactional(readOnly=true)
    public ArrayList<ReservacionModel> obtenerPorDuiPersona(String duiPersona){
        return reservacionesDao.findByDuiPersona(duiPersona);
    }
    
    @Transactional(readOnly=true)
    public ArrayList<ReservacionModel> obtenerPorFechaReserva(String fechaReserva){
        return reservacionesDao.findByFechaReserva(fechaReserva);
    }
}
