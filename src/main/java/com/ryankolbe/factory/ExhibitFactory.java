package com.ryankolbe.factory;

import com.ryankolbe.model.Exhibit;
import com.ryankolbe.util.Misc;

public class ExhibitFactory {

    public static Exhibit createExhibit(String startDate, String endDate) {
        return new Exhibit.Builder()
                .id(Misc.generateId())
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}