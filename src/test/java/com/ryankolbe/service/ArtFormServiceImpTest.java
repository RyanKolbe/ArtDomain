package com.ryankolbe.service;

import com.ryankolbe.factory.ArtFormFactory;
import com.ryankolbe.model.ArtForm;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtFormServiceImpTest {
    private static ArtFormService artFormService;
    private static ArtForm artForm;

    @BeforeClass
    public static void setUp() {
        artFormService = ArtFormServiceImp.getArtFormService();
        artForm = ArtFormFactory.createArtForm("Painting", "Modern");
        artFormService.create(artForm);
    }

    @Test
    public void getArtFormService() {
        Assert.assertNotNull(artFormService);
    }

    @Test
    public void create() {
        ArtForm artFormTemp = ArtFormFactory.createArtForm("Drawing", "Chalk");
        artFormService.create(artFormTemp);
        Assert.assertEquals(artFormTemp, artFormService.read(artFormTemp.getArtFormId()));
    }

    @Test
    public void read() {
        ArtForm artFormReadTemp = artFormService.read(artForm.getArtFormId());
        Assert.assertSame(artFormReadTemp, artFormService.read(artFormReadTemp.getArtFormId()));
    }

    @Test
    public void update() {
        String artFormId = Misc.generateId();
        ArtForm newArtForm = new ArtForm.Builder().copy(artForm).artFormId(artFormId).build();
        artFormService.create(newArtForm);
        Assert.assertSame(artFormId, artFormService.read(newArtForm.getArtFormId()).getArtFormId());
    }

    @Test
    public void delete() {
        ArtForm deleteArtForm = artFormService.getAll().stream().findFirst().orElse(null);
        int size = artFormService.getAll().size();
        assert deleteArtForm != null;
        artFormService.delete(deleteArtForm.getArtFormId());
        size -= 1;
        Assert.assertEquals(size, artFormService.getAll().size());
    }
}