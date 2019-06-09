package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.factory.LocalityFactory;
import com.ryankolbe.service.LocalityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LocalityServiceImplTest {
    @Autowired
    @Qualifier("LocalityServiceImpl")
    private LocalityService localityService;
    private Locality locality;
    private Set<Locality> localities = new HashSet<>();

    @Before
    public void setUp() {
        locality = localityService.create(LocalityFactory.createLocality("0001",
                "Steenberg", "Western Cape", "South Africa", "7984"));
        localities.add(locality);
    }

    @Test
    public void create() {
        Locality createLocality = localityService.create(LocalityFactory.createLocality("0002",
                "Hillfox", "Gauteng", "South Africa", "6589"));
        localities.add(createLocality);
        Assert.assertEquals(createLocality, localityService.read(createLocality.getLocalizationId()));
    }

    @Test
    public void read() {
        Locality readLocality = localityService.read(locality.getLocalizationId());
        Assert.assertEquals(readLocality, localityService.read(readLocality.getLocalizationId()));
    }

    @Test
    public void update() {
        String newLocalityProvince = "Mpumalanga";
        Locality updateLocality = localityService.update(new Locality.Builder().copy(locality)
                .province(newLocalityProvince).build());
        localities.add(updateLocality);
        Assert.assertEquals(updateLocality, localityService.read(updateLocality.getLocalizationId()));
    }

    @Test
    public void delete() {
        localities.addAll(localityService.getAll());
        Locality deleteLocality = localityService.create(LocalityFactory.createLocality("0056",
                "Mitchell's Plain", "Western Cape", "South Africa", "6954"));
        localities.add(deleteLocality);
        localities.remove(deleteLocality);
        localityService.delete(deleteLocality.getLocalizationId());
        Assert.assertEquals(localities.size(), localityService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Locality> localitySet = localityService.getAll();
        Assert.assertEquals(localitySet.size(), localityService.getAll().size());
    }
}