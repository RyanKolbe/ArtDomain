package com.ryankolbe.service;

import com.ryankolbe.domain.Curator;

import java.util.Set;

public interface CuratorService extends IService<Curator, String> {
    Set<Curator> getAll();
}