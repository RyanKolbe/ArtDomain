/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Curator;
import com.ryankolbe.factory.CuratorFactory;
import com.ryankolbe.repository.CuratorRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CuratorRepositoryImplTest {
    private static CuratorRepository curatorRepository = CuratorRepositoryImpl.getCuratorRepository();
    private static Curator curator;
    private static Set<Curator> curators = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        curator = CuratorFactory.createCurator("0001", "John", "Vos");
        curators.add(curatorRepository.create(curator));
    }

    @Test
    public void getCuratorRepository() {
        Assert.assertNotNull(curatorRepository);
    }

    @Test
    public void create() {
        Curator createCurator = CuratorFactory.createCurator("0002", "Lindi", "Vos");
        curators.add(curatorRepository.create(createCurator));
        Assert.assertEquals(createCurator, curatorRepository.read(createCurator.getCuratorId()));
    }

    @Test
    public void read() {
        Curator readCurator = curatorRepository.read(curator.getCuratorId());
        Assert.assertEquals(readCurator, curatorRepository.read(readCurator.getCuratorId()));
    }

    @Test
    public void update() {
        String newCuratorName = "Rhea";
        Curator updateCurator = new Curator.Builder().copy(curator).curatorName(newCuratorName).build();
        curators.add(curatorRepository.update(updateCurator));
        Assert.assertEquals(updateCurator, curatorRepository.read(updateCurator.getCuratorId()));
    }

    @Test
    public void delete() {
        Curator deleteCurator = CuratorFactory.createCurator("0356", "Kim", "Barnard");
        curators.add(curatorRepository.create(deleteCurator));
        curators.remove(deleteCurator);
        curatorRepository.delete(deleteCurator.getCuratorId());
        Assert.assertEquals(curators.size(), curatorRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Curator> curatorSet = curatorRepository.getAll();
        Assert.assertEquals(curatorSet, curatorRepository.getAll());
    }
}*/
