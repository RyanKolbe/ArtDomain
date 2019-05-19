package com.ryankolbe.factory;

import com.ryankolbe.domain.ArtCourse;
import org.junit.Assert;
import org.junit.Test;

public class ArtCourseFactoryTest {

    @Test
    public void createArtCourse() {
        ArtCourse artCourse = ArtCourseFactory.createArtCourse("0001", "Modern Art",
                true);
        Assert.assertEquals(true, artCourse.isArtCourseAvailable());
    }
}