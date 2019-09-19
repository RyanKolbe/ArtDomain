package com.ryankolbe.service;

import com.ryankolbe.domain.Painting;

import java.util.List;

public interface PaintingService extends IService<Painting, String> {
    List<Painting> getAll();
}