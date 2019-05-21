package com.ryankolbe.service;

import com.ryankolbe.domain.Painting;

import java.util.Set;

public interface PaintingService extends IService<Painting, String> {
    Set<Painting> getAll();
}