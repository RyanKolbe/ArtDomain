package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Sculpture;
import com.ryankolbe.factory.SculptureFactory;
import com.ryankolbe.repository.SculptureRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SculptureRepositoryImplTest {
    private static SculptureRepository sculptureRepository = SculptureRepositoryImpl.getSculptureRepository();
    private static Sculpture sculpture;
    private static Set<Sculpture> sculptures = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        sculpture = SculptureFactory.createSculpture("0012", "Venetian Goddess",
                "Marble");
        sculptures.add(sculptureRepository.create(sculpture));
    }

    @Test
    public void getSculptureRepository() {
        Assert.assertNotNull(sculptureRepository);
    }

    @Test
    public void create() {
        Sculpture createSculpture = SculptureFactory.createSculpture("0364", "Twisted Metal",
                "Recycle Iron");
        sculptures.add(sculptureRepository.create(createSculpture));
        Assert.assertEquals(createSculpture, sculptureRepository.read(createSculpture.getSculptureId()));
    }

    @Test
    public void read() {
        Sculpture readSculpture = sculptureRepository.read(sculpture.getSculptureId());
        Assert.assertEquals(readSculpture, sculptureRepository.read(readSculpture.getSculptureId()));
    }

    @Test
    public void update() {
        String newSculptureType = "Lime Stone";
        Sculpture updateSculpture = new Sculpture.Builder().copy(sculpture).sculpureType(newSculptureType).build();
        sculptures.add(sculptureRepository.update(updateSculpture));
        Assert.assertEquals(updateSculpture, sculptureRepository.read(updateSculpture.getSculptureId()));
    }

    @Test
    public void delete() {
        Sculpture deleteSculpture = SculptureFactory.createSculpture("0156", "Ravaging Wolves",
                "Clay Pottery");
        sculptures.add(sculptureRepository.create(deleteSculpture));
        sculptures.remove(deleteSculpture);
        sculptureRepository.delete(deleteSculpture.getSculptureId());
        Assert.assertEquals(sculptures.size(), sculptureRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Sculpture> sculptureSet = sculptureRepository.getAll();
        Assert.assertEquals(sculptureSet.size(), sculptureRepository.getAll().size());
    }
}