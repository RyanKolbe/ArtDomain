package com.ryankolbe.service;

import com.ryankolbe.domain.Exhibition;

import java.util.Set;

public interface ExhibitionService extends IService<Exhibition, String> {
    Set<Exhibition> getAll();
}