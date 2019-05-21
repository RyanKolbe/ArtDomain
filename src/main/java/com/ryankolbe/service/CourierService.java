package com.ryankolbe.service;

import com.ryankolbe.domain.Courier;

import java.util.Set;

public interface CourierService extends IService<Courier, String> {
    Set<Courier> getAll();
}