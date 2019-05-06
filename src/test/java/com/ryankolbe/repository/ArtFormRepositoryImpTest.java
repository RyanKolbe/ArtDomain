package com.ryankolbe.repository;

import com.ryankolbe.factory.ArtFormFactory;
import com.ryankolbe.model.ArtForm;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtFormRepositoryImpTest {

    private static ArtFormRepository artFormRepository = ArtFormRepositoryImp.getArtFormRepository();
    private static ArtForm artForm;
    private static Set<ArtForm> artForms = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        artForm = ArtFormFactory.createArtForm("Painting", "Modern");
        artForms.add(artFormRepository.create(artForm));
    }

    @Test
    public void create() {
        artForm = ArtFormFactory.createArtForm("Sculpture", "Venetian");
        Assert.assertEquals("Sculpture", artForm.getArtFormType());
    }

    @Test
    public void read() {
        artForm = ArtFormFactory.createArtForm("Drawing", "Chalk");
        artForms.add(artFormRepository.create(artForm));

        Assert.assertEquals("Drawing", artFormRepository.read(artForm.getArtFormId()).getArtFormType());
    }

    @Test
    public void update() {
        String newArtStyle = "Moroccan";
        ArtForm newArtForm = new ArtForm.Builder().copy(artForm).artFormStyle(newArtStyle).build();

        Assert.assertEquals(newArtStyle, newArtForm.getArtFormStyle());
    }

    @Test
    public void delete() {
        artForm = ArtFormFactory.createArtForm("Pottery", "Ceramic");
        artForms.add(artFormRepository.create(artForm));
        artFormRepository.delete(artForm.getArtFormId());

        Assert.assertEquals(2, artFormRepository.getAll().size());
    }
}