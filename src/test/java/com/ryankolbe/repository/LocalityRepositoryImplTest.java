package com.ryankolbe.repository;

import com.ryankolbe.factory.LocalityFactory;
import com.ryankolbe.model.Locality;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalityRepositoryImplTest {
    private static LocalityRepository localityRepository = LocalityRepositoryImpl.getLocalityRepository();
    private static Locality locality;
    private static Set<Locality> localities = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        locality = LocalityFactory.createLocality("Brackenfell", "Western Cape",
                "South Africa", "7561");
        localities.add(localityRepository.create(locality));
    }

    @Test
    public void create() {
        locality = LocalityFactory.createLocality("Steenberg", "Western Cape",
                "South Africa", "7945");
        localities.add(localityRepository.create(locality));
        Assert.assertEquals(localities.size(), localityRepository.getAll().size());
    }

    @Test
    public void read() {
        String localizationId = Objects.requireNonNull(localityRepository.getAll().stream().findFirst().orElse(null)).getLocalizationId();
        String localityIdCheck = localityRepository.read(localizationId).getLocalizationId();
        Assert.assertEquals(localizationId, localityIdCheck);
    }

    @Test
    public void update() {
        String newLocalityId = Misc.generateId();
        Locality newLocality = new Locality.Builder()
                .copy(locality).localizationId(newLocalityId).build();
        Assert.assertEquals(newLocalityId, newLocality.getLocalizationId());
    }

    @Test
    public void delete() {
        localityRepository.delete(locality.getLocalizationId());
        localities.remove(locality);
        Assert.assertEquals(localities.size(), localityRepository.getAll().size());
    }
}