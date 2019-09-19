package com.ryankolbe.service;

import com.ryankolbe.domain.Exhibition;

import java.util.List;

public interface ExhibitionService extends IService<Exhibition, String> {
    List<Exhibition> getAll();
}