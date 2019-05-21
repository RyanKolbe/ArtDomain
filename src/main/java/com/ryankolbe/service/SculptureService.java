package com.ryankolbe.service;

import com.ryankolbe.domain.Sculpture;

import java.util.Set;

public interface SculptureService extends IService<Sculpture, String> {
    Set<Sculpture> getAll();
}