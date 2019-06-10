package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Sculpture;
import com.ryankolbe.factory.SculptureFactory;
import com.ryankolbe.service.SculptureService;
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
public class SculptureServiceImplTest {
    @Autowired
    @Qualifier("SculptureServiceImpl")
    private SculptureService sculptureService;
    private Sculpture sculpture;
    private Set<Sculpture> sculptures = new HashSet<>();

    @Before
    public void setUp() {
        sculpture = sculptureService.create(SculptureFactory.createSculpture("0001",
                "Divided Grace", "Porcelain"));
        sculptures.add(sculpture);
    }

    @Test
    public void create() {
        Sculpture createSculpture = sculptureService.create(SculptureFactory.createSculpture("0002",
                "Death In Costume", "Ceramic"));
        sculptures.add(createSculpture);
        Assert.assertEquals(createSculpture, sculptureService.read(createSculpture.getSculptureId()));
    }

    @Test
    public void read() {
        Sculpture readSculpture = sculptureService.read(sculpture.getSculptureId());
        Assert.assertEquals(readSculpture, sculptureService.read(readSculpture.getSculptureId()));
    }

    @Test
    public void update() {
        String newSculptureName = "Immortalized";
        Sculpture updateSculpture = sculptureService.update(new Sculpture.Builder().copy(sculpture).
                sculptureName(newSculptureName).build());
        sculptures.add(updateSculpture);
        Assert.assertEquals(updateSculpture, sculptureService.read(updateSculpture.getSculptureId()));
    }

    @Test
    public void delete() {
        sculptures.addAll(sculptureService.getAll());
        Sculpture deleteSculpture = sculptureService.create(SculptureFactory.createSculpture("0046",
                "Forgotten Memories", "Aztec Timber"));
        sculptures.add(deleteSculpture);
        sculptures.remove(deleteSculpture);
        sculptureService.delete(deleteSculpture.getSculptureId());
        Assert.assertEquals(sculptures.size(), sculptureService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Sculpture> sculptureSetGetAll = sculptureService.getAll();
        Assert.assertEquals(sculptureSetGetAll.size(), sculptureService.getAll().size());
    }
}