package com.ryankolbe.repository;

import com.ryankolbe.model.ArtForm;

import java.util.HashSet;
import java.util.Set;

public class ArtFormRepositoryImp implements ArtFormRepository {
    private static ArtFormRepository artFormRepository = null;
    private Set<ArtForm> artForms;

    private ArtFormRepositoryImp() {
        this.artForms = new HashSet<>();
    }


    public static ArtFormRepository getArtFormRepository() {
        if (artFormRepository == null) artFormRepository = new ArtFormRepositoryImp();
        return artFormRepository;
    }

    @Override
    public Set<ArtForm> getAll() {
        return this.artForms;
    }

    @Override
    public ArtForm create(ArtForm artForm) {
        this.artForms.add(artForm);
        return artForm;
    }

    @Override
    public ArtForm update(ArtForm artForm) {
        ArtForm artFormTemp = search(artForm.getArtFormId());
        if (artFormTemp != null) {
            ArtForm artFormNew = new ArtForm.Builder()
                    .copy(artFormTemp)
                    .build();
            return create(artFormNew);
        }
        return null;
    }

    @Override
    public void delete(String artFormId) {
        ArtForm artForm = search(artFormId);
        if (artForm != null) this.artForms.remove(artForm);
    }

    @Override
    public ArtForm read(String artFormId) {
        return search(artFormId);
    }

    private ArtForm search(final String artFormId) {
        for (ArtForm artFormSearch : artForms) {
            if (artFormSearch.getArtFormId().equals(artFormId))
                return artFormSearch;
        }
        return null;
    }
}
