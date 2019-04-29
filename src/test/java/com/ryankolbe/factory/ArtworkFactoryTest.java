package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import org.junit.Assert;
import org.junit.Test;
import java.time.*;

public class ArtworkFactoryTest {

    @Test
    public void createArtwork() {
        LocalDate localDate = LocalDate.parse("2019-07-26");
        LocalTime localTime = LocalTime.parse("10:00:00");
        Year year = Year.parse("2019");
        ArtForm artForm = ArtFormFactory.createArtForm("Painting", "Modern");
        Dimension dimension = DimensionFactory.createDimension("1.5", "1.0",
                "0.8");
        Calendar calendar = CalendarFactory.createCalendar(localDate, localTime, year);
        Artwork artwork = ArtworkFactory.createArtwork(artForm, dimension, calendar);

        Assert.assertEquals("Painting",artwork.getArtForm().getArtFormType());
        Assert.assertEquals("1.5", artwork.getDimension().getHeight());
        Assert.assertEquals(Year.parse("2019"), artwork.getCalendar().getYear());
    }
}