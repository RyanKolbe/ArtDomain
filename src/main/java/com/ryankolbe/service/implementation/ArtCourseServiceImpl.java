package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.repository.ArtCourseRepository;
import com.ryankolbe.repository.implementation.ArtCourseRepositoryImpl;
import com.ryankolbe.service.ArtCourseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ArtCourseServiceImpl")
public class ArtCourseServiceImpl implements ArtCourseService {
    private final ArtCourseRepository artCourseRepository;

    private ArtCourseServiceImpl() {
        this.artCourseRepository = ArtCourseRepositoryImpl.getArtCourseRepository();
    }

    @Override
    public ArtCourse create(ArtCourse artCourse) {
        return this.artCourseRepository.create(artCourse);
    }

    @Override
    public ArtCourse read(String artCourseId) {
        return this.artCourseRepository.read(artCourseId);
    }

    @Override
    public ArtCourse update(ArtCourse artCourse) {
        return this.artCourseRepository.update(artCourse);
    }

    @Override
    public void delete(String artCourseId) {
        this.artCourseRepository.delete(artCourseId);
    }

    @Override
    public Set<ArtCourse> getAll() {
        return this.artCourseRepository.getAll();
    }
}