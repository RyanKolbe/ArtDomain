package com.ryankolbe.service;

import com.ryankolbe.domain.Services;

import java.util.Set;

public interface ServicesService extends IService<Services, String> {
    Set<Services> getAll();
}