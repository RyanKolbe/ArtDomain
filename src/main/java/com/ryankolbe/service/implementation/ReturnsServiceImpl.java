package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.repository.ReturnsRepository;
import com.ryankolbe.service.ReturnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ReturnsServiceImpl")
public class ReturnsServiceImpl implements ReturnsService {
    @Autowired
    private ReturnsRepository returnsRepository;

    @Override
    public Returns create(Returns returns) {
        return this.returnsRepository.save(returns);
    }

    @Override
    public Returns read(String returnsId) {
        Optional<Returns> byId = this.returnsRepository.findById(returnsId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Returns update(Returns returns) {
        return this.returnsRepository.save(returns);
    }

    @Override
    public void delete(String returnsId) {
        this.returnsRepository.deleteById(returnsId);
    }

    @Override
    public List<Returns> getAll() {
        return this.returnsRepository.findAll();
    }
}