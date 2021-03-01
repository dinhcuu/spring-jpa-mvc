package com.dhtbank.service;

import com.dhtbank.model.TKTinDung;

public interface TKTinDungService {
    boolean editTKTinDung ( TKTinDung tkTinDung);
    boolean saveTKTinDung (TKTinDung tkTinDung);
    boolean deleteTKTinDung ( TKTinDung tkTinDung);
    TKTinDung findById(Long id);
}
