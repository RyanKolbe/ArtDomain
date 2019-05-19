package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.repository.ArtCourseRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ArtCourseRepository")
public class ArtCourseRepositoryImp implements ArtCourseRepository {
    private static ArtCourseRepository artCourseRepository = null;
    private Set<ArtCourse> artCourses;

    private ArtCourseRepositoryImp() {
        this.artCourses = new HashSet<>();
    }

    public static ArtCourseRepository getArtCourseRepository() {
        if (artCourseRepository == null) artCourseRepository = new ArtCourseRepositoryImp();
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
            ArtCourse artCourseNew = new ArtCourse.Builder()
                    .copy(artCourseTemp)
                    .build();
            return artCourseNew;
        }
        return null;
    }

    @Override
    public void delete(String artCourseId) {
        ArtCourse artCourseDelete = search(artCourseId);
        if (artCourseDelete != null) this.artCourses.remove(artCourseDelete);
    }

    @Override
    public Set<ArtCourse> getAll() {
        return null;
    }

    private ArtCourse search(final String artCourseId) {
        for (ArtCourse artCourseSearch : this.artCourses) {
            if (artCourseSearch.getArtCourseId().equals(artCourseId))
                return artCourseSearch;
        }
        return null;
    }
}