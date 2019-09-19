package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.factory.ExhibitionFactory;
import com.ryankolbe.service.ExhibitionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExhibitionServiceImplTest {
    @Autowired
    @Qualifier("ExhibitionServiceImpl")
    private ExhibitionService exhibitionService;
    private Exhibition exhibition;
    private Set<Exhibition> exhibitions = new HashSet<>();

    @Before
    public void setUp() {
        exhibition = exhibitionService.create(ExhibitionFactory.createExhibition("0001",
                "Art Of Life", LocalDate.parse("2018-07-21"), LocalDate.parse("2018-07-28")));
        exhibitions.add(exhibition);
    }

    @Test
    public void create() {
        Exhibition createExhibition = exhibitionService.create(ExhibitionFactory.createExhibition("0026",
                "Paints and Dyes", LocalDate.parse("2018-07-21"), LocalDate.parse("2018-07-28")));
        exhibitions.add(createExhibition);
        Assert.assertEquals(createExhibition, exhibitionService.read(createExhibition.getExhibitionId()));
    }

    @Test
    public void read() {
        Exhibition readExhibition = exhibitionService.read(exhibition.getExhibitionId());
        Assert.assertEquals(readExhibition, exhibitionService.read(readExhibition.getExhibitionId()));
    }

    @Test
    public void update() {
        String newExhibitionName = "Marble Myths";
        Exhibition updateExhibition = exhibitionService.update(new Exhibition.Builder().copy(exhibition)
                .exhibitionName(newExhibitionName).build());
        exhibitions.add(updateExhibition);
        Assert.assertEquals(updateExhibition, exhibitionService.read(updateExhibition.getExhibitionId()));
    }

    @Test
    public void delete() {
        exhibitions.addAll(exhibitionService.getAll());
        Exhibition deleteExhibition = exhibitionService.create(ExhibitionFactory.createExhibition("0045",
                "Muddied Memories", LocalDate.parse("2018-07-21"), LocalDate.parse("2018-07-28")));
        exhibitions.add(deleteExhibition);
        exhibitions.remove(deleteExhibition);
        exhibitionService.delete(deleteExhibition.getExhibitionId());
        Assert.assertEquals(exhibitions.size(), exhibitionService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Exhibition> exhibitionSet = exhibitionService.getAll();
        Assert.assertEquals(exhibitionSet.size(), exhibitionService.getAll().size());
    }
}