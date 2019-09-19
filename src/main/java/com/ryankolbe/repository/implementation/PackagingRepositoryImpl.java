/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.repository.PackagingRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("PackagingRepository")
public class PackagingRepositoryImpl implements PackagingRepository {
    private static PackagingRepositoryImpl packagingRepository = null;
    private Set<Packaging> packagings;


    private PackagingRepositoryImpl() {
        this.packagings = new HashSet<>();
    }

    public static PackagingRepositoryImpl getPackagingRepository() {
        if (packagingRepository == null) packagingRepository = new PackagingRepositoryImpl();
        return packagingRepository;
    }

    @Override
    public Packaging create(Packaging packaging) {
        this.packagings.add(packaging);
        return packaging;
    }

    @Override
    public Packaging read(String packagingId) {
        return search(packagingId);
    }

    @Override
    public Packaging update(Packaging packaging) {
        Packaging packagingTemp = search(packaging.getPackagingId());
        if (packagingTemp != null) {
            packagings.remove(packagingTemp);
            return create(packaging);
        }
        return null;
    }

    @Override
    public void delete(String packagingId) {
        Packaging packagingDelete = search(packagingId);
        if (packagingDelete != null) this.packagings.remove(packagingDelete);
    }

    private Packaging search(final String packagingId) {
        for (Packaging packagingSearch : this.packagings) {
            if (packagingSearch.getPackagingId().equals(packagingId))
                return packagingSearch;
        }
        return null;
    }

    @Override
    public Set<Packaging> getAll() {
        return this.packagings;
    }
}*/
