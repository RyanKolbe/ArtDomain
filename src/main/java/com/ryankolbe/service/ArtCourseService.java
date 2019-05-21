package com.ryankolbe.service;

import com.ryankolbe.domain.ArtCourse;

import java.util.Set;

public interface ArtCourseService extends IService<ArtCourse, String> {
    Set<ArtCourse> getAll();
}