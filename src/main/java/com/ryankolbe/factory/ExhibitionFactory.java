package com.ryankolbe.factory;

import com.ryankolbe.domain.Exhibition;

import java.time.LocalDate;

public class ExhibitionFactory {

    public static Exhibition createExhibition(String exhibitionId, String exhibitionName,
                                              LocalDate exhibitionStartDate, LocalDate exhibitionEndDate) {
        return new Exhibition.Builder()
                .exhibitionId(exhibitionId)
                .exhibitionName(exhibitionName)
                .exhibitionStartDate(exhibitionStartDate)
                .exhibitionEndDate(exhibitionEndDate)
                .build();
    }
}