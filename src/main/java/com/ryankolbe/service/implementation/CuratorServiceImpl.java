package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Curator;
import com.ryankolbe.repository.CuratorRepository;
import com.ryankolbe.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CuratorServiceImpl")
public class CuratorServiceImpl implements CuratorService {
    @Autowired
    private CuratorRepository curatorRepository;

    @Override
    public List<Curator> getAll() {
        return this.curatorRepository.findAll();
    }

    @Override
    public Curator create(Curator curator) {
        return this.curatorRepository.save(curator);
    }

    @Override
    public Curator read(String curatorId) {
        Optional<Curator> byId = this.curatorRepository.findById(curatorId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Curator update(Curator curator) {
        return this.curatorRepository.save(curator);
    }

    @Override
    public void delete(String curatorId) {
        this.curatorRepository.deleteById(curatorId);
    }
}