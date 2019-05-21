package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Curator;
import com.ryankolbe.repository.CuratorRepository;
import com.ryankolbe.repository.implementation.CuratorRepositoryImpl;
import com.ryankolbe.service.CuratorService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CuratorServiceImpl")
public class CuratorServiceImpl implements CuratorService {
    private final CuratorRepository curatorRepository;

    private CuratorServiceImpl() {
        this.curatorRepository = CuratorRepositoryImpl.getCuratorRepository();
    }

    @Override
    public Set<Curator> getAll() {
        return this.curatorRepository.getAll();
    }

    @Override
    public Curator create(Curator curator) {
        return this.curatorRepository.create(curator);
    }

    @Override
    public Curator read(String curatorId) {
        return this.curatorRepository.read(curatorId);
    }

    @Override
    public Curator update(Curator curator) {
        return this.curatorRepository.update(curator);
    }

    @Override
    public void delete(String curatorId) {
        this.curatorRepository.delete(curatorId);
    }
}