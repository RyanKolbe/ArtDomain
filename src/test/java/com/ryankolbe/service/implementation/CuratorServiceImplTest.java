package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Curator;
import com.ryankolbe.factory.CuratorFactory;
import com.ryankolbe.service.CuratorService;
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
public class CuratorServiceImplTest {
    @Autowired
    @Qualifier("CuratorServiceImpl")
    private CuratorService curatorService;
    private Curator curator;
    private Set<Curator> curators = new HashSet<>();

    @Before
    public void setUp() {
        curator = curatorService.create(CuratorFactory.createCurator("0001", "Lindi",
                "Vos"));
        curators.add(curator);
    }

    @Test
    public void create() {
        Curator createCurator = curatorService.create(CuratorFactory.createCurator("0026", "Jacques",
                "Theron"));
        curators.add(createCurator);
        Assert.assertEquals(createCurator, curatorService.read(createCurator.getCuratorId()));
    }

    @Test
    public void read() {
        Curator readCurator = curatorService.read(curator.getCuratorId());
        Assert.assertEquals(readCurator, curatorService.read(readCurator.getCuratorId()));
    }

    @Test
    public void update() {
        String newCuratorName = "Rhea";
        Curator updateCurator = curatorService.update(new Curator.Builder().copy(curator)
                .curatorName(newCuratorName).build());
        curators.add(updateCurator);
        Assert.assertEquals(updateCurator, curatorService.read(updateCurator.getCuratorId()));
    }

    @Test
    public void delete() {
        curators.addAll(curatorService.getAll());
        Curator deleteCurator = curatorService.create(CuratorFactory.createCurator("0058",
                "Kaylene", "Meiring"));
        curators.add(deleteCurator);
        curators.remove(deleteCurator);
        curatorService.delete(deleteCurator.getCuratorId());
        Assert.assertEquals(curators.size(), curatorService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Curator> curatorSet = curatorService.getAll();
        Assert.assertEquals(curatorSet.size(), curatorService.getAll().size());
    }
}