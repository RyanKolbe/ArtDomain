package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.factory.ExhibitionFactory;
import com.ryankolbe.repository.ExhibitionRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExhibitionRepositoryImplTest {
    private static ExhibitionRepository exhibitionRepository = ExhibitionRepositoryImpl.getExhibitionRepository();
    private static Exhibition exhibition;
    private static Set<Exhibition> exhibitions = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        exhibition = ExhibitionFactory.createExhibition("0001", "Modern Art Exhibition",
                LocalDate.parse("2018-11-10"), LocalDate.parse("2018-11-12"));
        exhibitions.add(exhibitionRepository.create(exhibition));
    }

    @Test
    public void getExhibitionRepository() {
        Assert.assertNotNull(exhibitionRepository);
    }

    @Test
    public void create() {
        Exhibition createExhibition = ExhibitionFactory.createExhibition("0002", "New Age Sculptures",
                LocalDate.parse("2018-05-16"), LocalDate.parse("2018-05-20"));
        exhibitions.add(exhibitionRepository.create(createExhibition));
        Assert.assertEquals(createExhibition, exhibitionRepository.read(createExhibition.getExhibitionId()));
    }

    @Test
    public void read() {
        Exhibition readExhibition = exhibitionRepository.read(exhibition.getExhibitionId());
        Assert.assertEquals(readExhibition, exhibitionRepository.read(readExhibition.getExhibitionId()));
    }

    @Test
    public void update() {
        String newExhibitionName = "Woven Futures";
        Exhibition updateExhibition = new Exhibition.Builder().copy(exhibition).exhibitionName(newExhibitionName).build();
        exhibitions.add(exhibitionRepository.update(updateExhibition));
        Assert.assertEquals(updateExhibition, exhibitionRepository.read(updateExhibition.getExhibitionId()));
    }

    @Test
    public void delete() {
        Exhibition deleteExhibition = ExhibitionFactory.createExhibition("0024", "Intricate Vases",
                LocalDate.parse("2018-05-16"), LocalDate.parse("2018-05-20"));
        exhibitions.add(exhibitionRepository.create(deleteExhibition));
        exhibitions.remove(deleteExhibition);
        exhibitionRepository.delete(deleteExhibition.getExhibitionId());
        Assert.assertEquals(exhibitions.size(), exhibitionRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Exhibition> exhibitionSet = exhibitionRepository.getAll();
        Assert.assertEquals(exhibitionSet, exhibitionRepository.getAll());
    }
}