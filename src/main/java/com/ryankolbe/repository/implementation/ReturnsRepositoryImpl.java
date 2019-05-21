package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.repository.ReturnsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ReturnsRepository")
public class ReturnsRepositoryImpl implements ReturnsRepository {
    private static ReturnsRepositoryImpl returnRepository = null;
    private Set<Returns> returns;


    private ReturnsRepositoryImpl() {
        this.returns = new HashSet<>();
    }

    public static ReturnsRepositoryImpl getReturnsRepository() {
        if (returnRepository == null) returnRepository = new ReturnsRepositoryImpl();
        return returnRepository;
    }

    @Override
    public Returns create(Returns returns) {
        this.returns.add(returns);
        return returns;
    }

    @Override
    public Returns read(String returnId) {
        return search(returnId);
    }

    @Override
    public Returns update(Returns returns) {
        Returns returnTemp = search(returns.getReturnId());
        if (returnTemp != null) {
            return create(new Returns.Builder()
                    .copy(returnTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String returnId) {
        Returns returnDelete = search(returnId);
        if (returnDelete != null) this.returns.remove(returnDelete);
    }

    private Returns search(final String returnId) {
        for (Returns returnSearch : this.returns) {
            if (returnSearch.getReturnId().equals(returnId))
                return returnSearch;
        }
        return null;
    }

    @Override
    public Set<Returns> getAll() {
        return this.returns;
    }
}