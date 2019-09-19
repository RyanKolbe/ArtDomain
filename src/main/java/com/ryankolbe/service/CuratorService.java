package com.ryankolbe.service;

import com.ryankolbe.domain.Curator;

import java.util.List;

public interface CuratorService extends IService<Curator, String> {
    List<Curator> getAll();
}