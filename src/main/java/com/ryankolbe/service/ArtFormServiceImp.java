package com.ryankolbe.service;

import com.ryankolbe.model.ArtForm;
import com.ryankolbe.repository.ArtFormRepository;
import com.ryankolbe.repository.ArtFormRepositoryImp;

import java.util.Set;

public class ArtFormServiceImp implements ArtFormService {
    private static ArtFormService artFormService = null;
    private ArtFormRepository artFormRepository;

    private ArtFormServiceImp() {
        this.artFormRepository = ArtFormRepositoryImp.getArtFormRepository();
    }

    public static ArtFormService getArtFormService() {
        if (artFormService == null) artFormService = new ArtFormServiceImp();
        return artFormService;
    }

    @Override
    public Set<ArtForm> getAll() {
        return this.artFormRepository.getAll();
    }

    @Override
    public ArtForm create(ArtForm artForm) {
        return this.artFormRepository.create(artForm);
    }

    @Override
    public ArtForm read(String artFormId) {
        return this.artFormRepository.read(artFormId);
    }

    @Override
    public ArtForm update(ArtForm artForm) {
        return this.artFormRepository.update(artForm);
    }

    @Override
    public void delete(String artFormId) {
        this.artFormRepository.delete(artFormId);
    }
}