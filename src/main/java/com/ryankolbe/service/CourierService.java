package com.ryankolbe.service;

import com.ryankolbe.domain.Courier;

import java.util.List;

public interface CourierService extends IService<Courier, String> {
    List<Courier> getAll();
}