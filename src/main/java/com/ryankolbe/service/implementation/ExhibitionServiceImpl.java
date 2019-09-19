package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.repository.ExhibitionRepository;
import com.ryankolbe.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ExhibitionServiceImpl")
public class ExhibitionServiceImpl implements ExhibitionService {
    @Autowired
    private ExhibitionRepository exhibitionRepository;

    @Override
    public Exhibition create(Exhibition exhibition) {
        return this.exhibitionRepository.save(exhibition);
    }

    @Override
    public Exhibition read(String exhibitionId) {
        Optional<Exhibition> byId = this.exhibitionRepository.findById(exhibitionId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Exhibition update(Exhibition exhibition) {
        return this.exhibitionRepository.save(exhibition);
    }

    @Override
    public void delete(String exhibitionId) {
        this.exhibitionRepository.deleteById(exhibitionId);
    }

    @Override
    public List<Exhibition> getAll() {
        return this.exhibitionRepository.findAll();
    }
}