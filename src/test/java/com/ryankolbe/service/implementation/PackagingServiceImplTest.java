package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.factory.PackagingFactory;
import com.ryankolbe.service.PackagingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PackagingServiceImplTest {
    @Autowired
    @Qualifier("PackagingServiceImpl")
    private PackagingService packagingService;
    private Packaging packaging;
    private Set<Packaging> packagings = new HashSet<>();

    @Before
    public void setUp() {
        packaging = packagingService.create(PackagingFactory.createPackaging("0001", "150",
                "200", "123"));
        packagings.add(packaging);
    }

    @Test
    public void create() {
        Packaging createPackaging = packagingService.create(PackagingFactory.createPackaging("0002",
                "254", "165", "154"));
        packagings.add(createPackaging);
        Assert.assertEquals(createPackaging, packagingService.read(createPackaging.getPackagingId()));
    }

    @Test
    public void read() {
        Packaging readPackaging = packagingService.read(packaging.getPackagingId());
        Assert.assertEquals(readPackaging, packagingService.read(readPackaging.getPackagingId()));
    }

    @Test
    public void update() {
        String newPackagingWidth = "325";
        Packaging updatePackaging = packagingService.update(new Packaging.Builder().copy(packaging)
                .packagingWidth(newPackagingWidth).build());
        packagings.add(updatePackaging);
        Assert.assertEquals(updatePackaging, packagingService.read(updatePackaging.getPackagingId()));
    }

    @Test
    public void delete() {
        packagings.addAll(packagingService.getAll());
        Packaging deletePackaging = packagingService.create(PackagingFactory.createPackaging("0023",
                "213", "432", "321"));
        packagings.add(deletePackaging);
        packagings.remove(deletePackaging);
        packagingService.delete(deletePackaging.getPackagingId());
        Assert.assertEquals(packagings.size(), packagingService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Packaging> packagingSet = packagingService.getAll();
        Assert.assertEquals(packagingSet.size(), packagingService.getAll().size());
    }
}