package com.dhtbank.service.impl;

import com.dhtbank.model.TKGui;
import com.dhtbank.repository.TKGuiRepository;
import com.dhtbank.service.TKGuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TKGuiServiceImpl implements TKGuiService {
    private final  TKGuiRepository tkGuiRepository;
     @Autowired
    public TKGuiServiceImpl(TKGuiRepository tkGuiRepository) {
        this.tkGuiRepository = tkGuiRepository;
    }

    @Override
    public boolean editTKGui(TKGui tkGui) {
        try {
            tkGuiRepository.save(tkGui);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean saveTKGui(TKGui tkGui) {
        try {
            tkGuiRepository.save(tkGui);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean deleteTKGui(TKGui tkGui) {
        try {
            tkGuiRepository.delete(tkGui);
        }catch (Exception e){
            return false;}
        return true;
    }
}
