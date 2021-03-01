package com.dhtbank.service.impl;

import com.dhtbank.model.TKTinDung;
import com.dhtbank.repository.TKTinDungRepository;
import com.dhtbank.service.TKTinDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TKTinDungServiceImpl implements TKTinDungService {
    private final TKTinDungRepository tkTinDungRepository;
    @Autowired
    public TKTinDungServiceImpl(TKTinDungRepository tkTinDungRepository) {
        this.tkTinDungRepository = tkTinDungRepository;
    }

    @Override
    public boolean editTKTinDung(TKTinDung tkTinDung) {
        try {
            tkTinDungRepository.save(tkTinDung);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean saveTKTinDung(TKTinDung tkTinDung) {
        try {
            tkTinDungRepository.save(tkTinDung);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean deleteTKTinDung(TKTinDung tkTinDung) {
        try {
            tkTinDungRepository.delete(tkTinDung);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public TKTinDung findById(Long id) {
        try {
            Optional<TKTinDung> tkTinDung = tkTinDungRepository.findById(id);
            if (tkTinDung.isPresent()) {
                return tkTinDung.get();
            }
        }catch (Exception e){
            return null; }
        return null;
    }
}
