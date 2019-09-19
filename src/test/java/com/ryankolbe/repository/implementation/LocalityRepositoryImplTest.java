/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.factory.LocalityFactory;
import com.ryankolbe.repository.LocalityRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalityRepositoryImplTest {
    private static LocalityRepository localityRepository = LocalityRepositoryImpl.getLocalityRepository();
    private static Locality locality;
    private static Set<Locality> localities = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        locality = LocalityFactory.createLocality("0001", "Steenberg",
                "Western Cape", "South Africa", "7945");
        localities.add(localityRepository.create(locality));
    }

    @Test
    public void getLocalityRepository() {
        Assert.assertNotNull(localityRepository);
    }

    @Test
    public void create() {
        Locality createLocality = LocalityFactory.createLocality("0002", "Bellville",
                "Western Cape", "South Africa", "5975");
        localities.add(localityRepository.create(createLocality));
        Assert.assertEquals(createLocality, localityRepository.read(createLocality.getLocalizationId()));
    }

    @Test
    public void read() {
        Locality readLocality = localityRepository.read(locality.getLocalizationId());
        Assert.assertEquals(readLocality, localityRepository.read(readLocality.getLocalizationId()));
    }

    @Test
    public void update() {
        String newProvince = "Gauteng";
        Locality updateLocality = new Locality.Builder().copy(locality).province(newProvince).build();
        localities.add(localityRepository.update(updateLocality));
        Assert.assertEquals(updateLocality, localityRepository.read(updateLocality.getLocalizationId()));
    }

    @Test
    public void delete() {
        Locality deleteLocality = LocalityFactory.createLocality("0045", "Wynberg",
                "Western Cape", "South Africa", "4568");
        localities.add(localityRepository.create(deleteLocality));
        localities.remove(deleteLocality);
        localityRepository.delete(deleteLocality.getLocalizationId());
        Assert.assertEquals(localities.size(), localityRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Locality> localitySet = localityRepository.getAll();
        Assert.assertEquals(localitySet, localityRepository.getAll());
    }
}*/
