package com.ryankolbe.service;

import com.ryankolbe.domain.Services;

import java.util.List;

public interface ServicesService extends IService<Services, String> {
    List<Services> getAll();
}