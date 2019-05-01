package com.ryankolbe.repository;

import com.ryankolbe.model.ArtForm;

import java.util.Set;

public interface ArtFormRepository extends IRepository<ArtForm, String> {
    Set<ArtForm> getAll();
}