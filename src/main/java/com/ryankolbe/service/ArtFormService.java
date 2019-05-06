package com.ryankolbe.service;

import com.ryankolbe.model.ArtForm;

import java.util.Set;

public interface ArtFormService extends IService<ArtForm, String> {
    Set<ArtForm> getAll();
}
