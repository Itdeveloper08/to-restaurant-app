package com.example.services;

import com.example.models.MesaModel;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.MesaDao;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesaService {
    @Autowired
    MesaDao mesaDao;
    
    @Transactional(readOnly=true)
    public ArrayList<MesaModel> obtenerMesas(){
        return (ArrayList<MesaModel>) mesaDao.findAll();
    }
    
    @Transactional
    public MesaModel guardarMesa(MesaModel MesaM){
        return mesaDao.save(MesaM);
    }
    
    @Transactional(readOnly=true)
    public Optional<MesaModel> obtenerPorId(Long id){
        return mesaDao.findById(id);
    }
    
    @Transactional
    public boolean eliminarMesa(Long id){
        try{
            mesaDao.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}