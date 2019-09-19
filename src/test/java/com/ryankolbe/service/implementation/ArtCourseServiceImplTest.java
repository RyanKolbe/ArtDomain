package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.factory.ArtCourseFactory;
import com.ryankolbe.service.ArtCourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArtCourseServiceImplTest {
    @Autowired
    @Qualifier("ArtCourseServiceImpl")
    private ArtCourseService artCourseService;
    private ArtCourse artCourse;
    private Set<ArtCourse> artCourses = new HashSet<>();

    @Before
    public void setUp() {
        artCourse = artCourseService.create(ArtCourseFactory.createArtCourse("0001",
                "Painting 101", true));
        artCourses.add(artCourse);
    }

    @Test
    public void create() {
        ArtCourse createArtCourse = artCourseService.create(ArtCourseFactory.
                createArtCourse("0025", "Sculpting 101", true));
        artCourses.add(createArtCourse);
        Assert.assertEquals(createArtCourse, artCourseService.read(createArtCourse.getArtCourseId()));
    }

    @Test
    public void read() {
        ArtCourse readArtCourse = artCourseService.read(artCourse.getArtCourseId());
        Assert.assertEquals(readArtCourse, artCourseService.read(readArtCourse.getArtCourseId()));
    }

    @Test
    public void update() {
        String newArtCourseName = "Potter 101";
        ArtCourse updateArtCourse = artCourseService.update(new ArtCourse.Builder().copy(artCourse).
                artCourseName(newArtCourseName).build());
        artCourses.add(updateArtCourse);
        Assert.assertEquals(updateArtCourse, artCourseService.read(updateArtCourse.getArtCourseId()));
    }

    @Test
    public void delete() {
        artCourses.addAll(artCourseService.getAll());
        ArtCourse deleteArtCourse = artCourseService.create(ArtCourseFactory.
                createArtCourse("0025", "Basket Weaving", false));
        artCourses.add(deleteArtCourse);
        artCourses.remove(deleteArtCourse);
        artCourseService.delete(deleteArtCourse.getArtCourseId());
        Assert.assertEquals(artCourses.size(), artCourseService.getAll().size());
    }

    @Test
    public void getAll() {
        List<ArtCourse> artCourseSet = artCourseService.getAll();
        Assert.assertEquals(artCourseSet.size(), artCourseService.getAll().size());
    }
}