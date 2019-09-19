/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.factory.PackagingFactory;
import com.ryankolbe.repository.PackagingRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PackagingRepositoryImplTest {
    private static PackagingRepository packagingRepository = PackagingRepositoryImpl.getPackagingRepository();
    private static Packaging packaging;
    private static Set<Packaging> packagings = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        packaging = PackagingFactory.createPackaging("0015", "100", "25",
                "921");
        packagings.add(packagingRepository.create(packaging));
    }

    @Test
    public void getPackagingRepository() {
        Assert.assertNotNull(packagingRepository);
    }

    @Test
    public void create() {
        Packaging createPackaging = PackagingFactory.createPackaging("0012", "245,",
                "165", "745");
        packagings.add(packagingRepository.create(createPackaging));
        Assert.assertEquals(createPackaging, packagingRepository.read(createPackaging.getPackagingId()));
    }

    @Test
    public void read() {
        Packaging readPackaging = packagingRepository.read(packaging.getPackagingId());
        Assert.assertEquals(readPackaging, packagingRepository.read(readPackaging.getPackagingId()));
    }

    @Test
    public void update() {
        String newPackagingWidth = "400";
        Packaging updatePackaging = new Packaging.Builder().copy(packaging).packagingWidth(newPackagingWidth).build();
        packagings.add(packagingRepository.update(updatePackaging));
        Assert.assertEquals(updatePackaging, packagingRepository.read(updatePackaging.getPackagingId()));
    }

    @Test
    public void delete() {
        Packaging deletePackaging = PackagingFactory.createPackaging("0679", "468",
                "135", "700");
        packagings.add(packagingRepository.create(deletePackaging));
        packagings.remove(deletePackaging);
        packagingRepository.delete(deletePackaging.getPackagingId());
        Assert.assertEquals(packagings.size(), packagingRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Packaging> packagingSet = packagingRepository.getAll();
        Assert.assertEquals(packagingSet.size(), packagingRepository.getAll().size());
    }
}*/
