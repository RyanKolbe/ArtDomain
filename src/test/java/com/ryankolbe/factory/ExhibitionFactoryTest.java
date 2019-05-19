package com.ryankolbe.factory;

import com.ryankolbe.domain.Exhibition;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ExhibitionFactoryTest {

    @Test
    public void createExhibition() {
        Exhibition exhibition = ExhibitionFactory.createExhibition("00010", "Modern Sculptures",
                LocalDate.parse("2018-10-01"), LocalDate.parse("2018-10-03"));
        Assert.assertEquals(LocalDate.parse("2018-10-01"), exhibition.getExhibitionStartDate());
    }
}