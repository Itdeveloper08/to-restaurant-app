package com.example.services;

import com.example.dao.MesaDao;
import com.example.models.MesaModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesaServiceImpl implements MesaService {

    private final MesaDao mesaDao;

    @Autowired
    public MesaServiceImpl(MesaDao mesaDao) {
        this.mesaDao = mesaDao;
    }

    @Override
    public Optional<MesaModel> obtenerPorId(Long id) {
        return mesaDao.findById(id);
    }

    @Override
    public List<MesaModel> getAllMesas() {
        return mesaDao.findAll();
    }

    @Override
    public MesaModel saveMesa(MesaModel mesa) {
        return mesaDao.save(mesa);
    }

    @Override
    public void deleteMesa(Long id) {
        mesaDao.deleteById(id);
    }
}
