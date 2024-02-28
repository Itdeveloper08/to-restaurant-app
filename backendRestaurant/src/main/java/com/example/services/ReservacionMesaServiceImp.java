package com.example.services;

import com.example.models.ReservacionMesaModel;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.ReservacionMesaDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservacionMesaServiceImp implements ReservacionMesaService{
    @Autowired
    ReservacionMesaDao reservacionMesaDao;
    
    @Transactional(readOnly=true)
    public ArrayList<ReservacionMesaModel> obtenerReservacionMesas(){
        return (ArrayList<ReservacionMesaModel>) reservacionMesaDao.findAll();
    }
    
    @Transactional
    public ReservacionMesaModel guardarReservacionMesa(ReservacionMesaModel ReservacionMesaM){
        return reservacionMesaDao.save(ReservacionMesaM);
    }
    
    @Transactional(readOnly=true)
    public Optional<ReservacionMesaModel> obtenerPorId(Long id){
        return reservacionMesaDao.findById(id);
    }
    
    @Transactional
    public boolean eliminarReservacionMesa(Long id){
        try{
            reservacionMesaDao.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
