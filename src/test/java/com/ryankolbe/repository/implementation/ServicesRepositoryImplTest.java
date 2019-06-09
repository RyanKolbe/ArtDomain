package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Services;
import com.ryankolbe.factory.ServicesFactory;
import com.ryankolbe.repository.ServicesRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicesRepositoryImplTest {
    private static ServicesRepository servicesRepository = ServicesRepositoryImpl.getServicesRepository();
    private static Services services;
    private static Set<Services> servicesSet = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        services = ServicesFactory.createServices("0001", "Restoration",
                "Restore Artwork", 4000.00);
        servicesSet.add(servicesRepository.create(services));
    }

    @Test
    public void getServicesRepository() {
        Assert.assertNotNull(servicesRepository);
    }

    @Test
    public void create() {
        Services createService = ServicesFactory.createServices("0254", "Framing",
                "Picture Framing", 250.00);
        servicesSet.add(servicesRepository.create(createService));
        Assert.assertEquals(createService, servicesRepository.read(createService.getServiceId()));
    }

    @Test
    public void read() {
        Services readServices = servicesRepository.read(services.getServiceId());
        Assert.assertEquals(readServices, servicesRepository.read(readServices.getServiceId()));
    }

    @Test
    public void update() {
        String newServiceName = "Replications";
        Services updateServices = new Services.Builder().copy(services).serviceName(newServiceName).build();
        servicesSet.add(servicesRepository.update(updateServices));
        Assert.assertEquals(updateServices, servicesRepository.read(updateServices.getServiceId()));
    }

    @Test
    public void delete() {
        Services deleteServices = ServicesFactory.createServices("0035", "Exhibitions",
                "Host Exhibitions", 400.00);
        servicesSet.add(servicesRepository.create(deleteServices));
        servicesSet.remove(deleteServices);
        servicesRepository.delete(deleteServices.getServiceId());
        Assert.assertEquals(servicesSet.size(), servicesRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Services> servicesSetGetAll = servicesRepository.getAll();
        Assert.assertEquals(servicesSetGetAll.size(), servicesRepository.getAll().size());
    }
}