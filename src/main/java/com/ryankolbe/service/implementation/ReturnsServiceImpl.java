package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.repository.ReturnsRepository;
import com.ryankolbe.repository.implementation.ReturnsRepositoryImpl;
import com.ryankolbe.service.ReturnsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ReturnsServiceImpl")
public class ReturnsServiceImpl implements ReturnsService {
    private final ReturnsRepository returnsRepository;

    private ReturnsServiceImpl() {
        this.returnsRepository = ReturnsRepositoryImpl.getReturnsRepository();
    }
    @Override
    public Returns create(Returns returns) {
        return this.returnsRepository.create(returns);
    }

    @Override
    public Returns read(String returnsId) {
        return this.returnsRepository.read(returnsId);
    }

    @Override
    public Returns update(Returns returns) {
        return this.returnsRepository.update(returns);
    }

    @Override
    public void delete(String returnsId) {
        this.returnsRepository.delete(returnsId);
    }

    @Override
    public Set<Returns> getAll() {
        return this.returnsRepository.getAll();
    }
}
