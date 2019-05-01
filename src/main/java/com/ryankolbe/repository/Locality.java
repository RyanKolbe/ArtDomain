package com.ryankolbe.repository;

import java.util.Set;

public interface Locality extends IRepository<Locality, String> {
    Set<Locality> getAll();
}
