package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.repository.ArtCourseRepository;
import com.ryankolbe.service.ArtCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ArtCourseServiceImpl")
public class ArtCourseServiceImpl implements ArtCourseService {
    @Autowired
    private ArtCourseRepository artCourseRepository;

    @Override
    public ArtCourse create(ArtCourse artCourse) {
        return this.artCourseRepository.save(artCourse);
    }

    @Override
    public ArtCourse read(String artCourseId) {
        Optional<ArtCourse> byId = this.artCourseRepository.findById(artCourseId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public ArtCourse update(ArtCourse artCourse) {
        return this.artCourseRepository.save(artCourse);
    }

    @Override
    public void delete(String artCourseId) {
        this.artCourseRepository.deleteById(artCourseId);
    }

    @Override
    public List<ArtCourse> getAll() {
        return this.artCourseRepository.findAll();
    }
}