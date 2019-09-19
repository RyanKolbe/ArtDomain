/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.repository.ArtCourseRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ArtCourseRepository")
public class ArtCourseRepositoryImpl implements ArtCourseRepository {
    private static ArtCourseRepositoryImpl artCourseRepository = null;
    private Set<ArtCourse> artCourses;


    private ArtCourseRepositoryImpl() {
        this.artCourses = new HashSet<>();
    }

    public static ArtCourseRepositoryImpl getArtCourseRepository() {
        if (artCourseRepository == null) artCourseRepository = new ArtCourseRepositoryImpl();
        return artCourseRepository;
    }

    @Override
    public ArtCourse create(ArtCourse artCourse) {
        this.artCourses.add(artCourse);
        return artCourse;
    }

    @Override
    public ArtCourse read(String artCourseId) {
        return search(artCourseId);
    }

    @Override
    public ArtCourse update(ArtCourse artCourse) {
        ArtCourse artCourseTemp = search(artCourse.getArtCourseId());
        if (artCourseTemp != null) {
            artCourses.remove(artCourseTemp);
            return create(artCourse);
        }
        return null;
    }

    @Override
    public void delete(String artCourseId) {
        ArtCourse artCourseDelete = search(artCourseId);
        if (artCourseDelete != null) this.artCourses.remove(artCourseDelete);
    }

    private ArtCourse search(final String artCourseId) {
        for (ArtCourse artCourseSearch : this.artCourses) {
            if (artCourseSearch.getArtCourseId().equals(artCourseId))
                return artCourseSearch;
        }
        return null;
    }

    @Override
    public Set<ArtCourse> getAll() {
        return this.artCourses;
    }
}*/
