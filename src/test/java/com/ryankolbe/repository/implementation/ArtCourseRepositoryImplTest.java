/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.factory.ArtCourseFactory;
import com.ryankolbe.repository.ArtCourseRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtCourseRepositoryImplTest {
    private static ArtCourseRepository artCourseRepository = ArtCourseRepositoryImpl.getArtCourseRepository();
    private static ArtCourse artCourse;
    private static Set<ArtCourse> artCourses = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        artCourse = ArtCourseFactory.createArtCourse("0001", "Painting 101", true);
        artCourses.add(artCourseRepository.create(artCourse));
    }

    @Test
    public void getArtCourseRepository() {
        Assert.assertNotNull(artCourseRepository);
    }

    @Test
    public void create() {
        ArtCourse createArtCourse = ArtCourseFactory.createArtCourse("0002", "Sculpting 101", true);
        artCourses.add(artCourseRepository.create(createArtCourse));
        Assert.assertEquals(createArtCourse, artCourseRepository.read(createArtCourse.getArtCourseId()));
    }

    @Test
    public void read() {
        ArtCourse readArtCourse = artCourseRepository.read(artCourse.getArtCourseId());
        Assert.assertEquals(readArtCourse, artCourseRepository.read(readArtCourse.getArtCourseId()));
    }

    @Test
    public void update() {
        String newCourseName = "Oil Painting 222";
        ArtCourse updateArtCourse = new ArtCourse.Builder().copy(artCourse).
                artCourseName(newCourseName).build();
        artCourses.add(artCourseRepository.update(updateArtCourse));
        Assert.assertEquals(updateArtCourse, artCourseRepository.read(updateArtCourse.getArtCourseId()));
    }

    @Test
    public void delete() {
        ArtCourse deleteArtCourse = ArtCourseFactory.createArtCourse("0004","Fabric Art 234",
                false);
        artCourses.add(artCourseRepository.create(deleteArtCourse));
        artCourses.remove(deleteArtCourse);
        artCourseRepository.delete(deleteArtCourse.getArtCourseId());
        Assert.assertEquals(artCourses.size(), artCourseRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<ArtCourse> artCourseSet = artCourseRepository.getAll();
        Assert.assertEquals(artCourseSet, artCourseRepository.getAll());
    }
}*/
