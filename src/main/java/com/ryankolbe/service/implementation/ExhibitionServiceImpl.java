package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.repository.ExhibitionRepository;
import com.ryankolbe.repository.implementation.ExhibitionRepositoryImpl;
import com.ryankolbe.service.ExhibitionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ExhibitionServiceImpl")
public class ExhibitionServiceImpl implements ExhibitionService {
    private final ExhibitionRepository exhibitionRepository;

    private ExhibitionServiceImpl() {
        this.exhibitionRepository = ExhibitionRepositoryImpl.getExhibitionRepository();
    }

    @Override
    public Exhibition create(Exhibition exhibition) {
        return this.exhibitionRepository.create(exhibition);
    }

    @Override
    public Exhibition read(String exhibitionId) {
        return this.exhibitionRepository.read(exhibitionId);
    }

    @Override
    public Exhibition update(Exhibition exhibition) {
        return this.exhibitionRepository.update(exhibition);
    }

    @Override
    public void delete(String exhibitionId) {
        this.exhibitionRepository.delete(exhibitionId);
    }

    @Override
    public Set<Exhibition> getAll() {
        return this.exhibitionRepository.getAll();
    }
}