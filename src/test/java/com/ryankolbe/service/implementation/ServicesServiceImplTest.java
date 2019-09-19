package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Services;
import com.ryankolbe.factory.ServicesFactory;
import com.ryankolbe.service.ServicesService;
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
public class ServicesServiceImplTest {
    @Autowired
    @Qualifier("ServicesServiceImpl")
    private ServicesService servicesService;
    private Services services;
    private Set<Services> servicesSet = new HashSet<>();

    @Before
    public void setUp() {
        services = servicesService.create(ServicesFactory.createServices("0001",
                "Picture Restoration", "Art Restoration", 500.00));
        servicesSet.add(services);
    }

    @Test
    public void create() {
        Services createService = servicesService.create(ServicesFactory.createServices("0006",
                "Picture Framing", "Framing", 250.00));
        servicesSet.add(createService);
        Assert.assertEquals(createService, servicesService.read(createService.getServiceId()));
    }

    @Test
    public void read() {
        Services readService = servicesService.read(services.getServiceId());
        Assert.assertEquals(readService, servicesService.read(readService.getServiceId()));
    }

    @Test
    public void update() {
        String newServiceName = "Image Revitalization";
        Services updateService = servicesService.update(new Services.Builder().copy(services)
                .serviceName(newServiceName).build());
        servicesSet.add(updateService);
        Assert.assertEquals(updateService, servicesService.read(updateService.getServiceId()));
    }

    @Test
    public void delete() {
        servicesSet.addAll(servicesService.getAll());
        Services deleteService = servicesService.create(ServicesFactory.createServices("0027",
                "Photo Editing", "Photography", 100.00));
        servicesSet.add(deleteService);
        servicesSet.remove(deleteService);
        servicesService.delete(deleteService.getServiceId());
        Assert.assertEquals(servicesSet.size(), servicesService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Services> servicesSetGetAll = servicesService.getAll();
        Assert.assertEquals(servicesSetGetAll.size(), servicesService.getAll().size());
    }
}