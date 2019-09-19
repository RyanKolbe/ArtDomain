package com.ryankolbe.service;

import com.ryankolbe.domain.Sculpture;

import java.util.List;

public interface SculptureService extends IService<Sculpture, String> {
    List<Sculpture> getAll();
}