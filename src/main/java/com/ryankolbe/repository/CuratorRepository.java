package com.ryankolbe.repository;

import com.ryankolbe.domain.Curator;

import java.util.Set;

public interface CuratorRepository extends IRepository<Curator, String> {
    Set<Curator> getAll();
}
