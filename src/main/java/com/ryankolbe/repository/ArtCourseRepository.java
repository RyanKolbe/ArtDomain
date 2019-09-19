package com.ryankolbe.repository;

import com.ryankolbe.domain.ArtCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtCourseRepository extends JpaRepository<ArtCourse, String> {
}
