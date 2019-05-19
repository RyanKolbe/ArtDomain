package com.ryankolbe.repository;

import com.ryankolbe.domain.ArtCourse;

import java.util.Set;

public interface ArtCourseRepository extends IRepository<ArtCourse, String> {
    Set<ArtCourse> getAll();
}
