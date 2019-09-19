package com.ryankolbe.service;

import com.ryankolbe.domain.ArtCourse;

import java.util.List;

public interface ArtCourseService extends IService<ArtCourse, String> {
    List<ArtCourse> getAll();
}