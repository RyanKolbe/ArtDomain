package com.ryankolbe.factory;

import com.ryankolbe.domain.ArtCourse;

public class ArtCourseFactory {

    public static ArtCourse createArtCourse(String artCourseId, String artCourseName,
                                            boolean artCourseAvailable) {
        return new ArtCourse.Builder()
                .artCourseId(artCourseId)
                .artCourseName(artCourseName)
                .artCourseAvailable(artCourseAvailable)
                .build();
    }
}