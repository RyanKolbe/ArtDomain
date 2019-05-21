package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Curator;
import com.ryankolbe.repository.CuratorRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CuratorRepository")
public class CuratorRepositoryImpl implements CuratorRepository {
    private static CuratorRepositoryImpl curatorRepository = null;
    private Set<Curator> curators;


    private CuratorRepositoryImpl() {
        this.curators = new HashSet<>();
    }

    public static CuratorRepositoryImpl getCuratorRepository() {
        if (curatorRepository == null) curatorRepository = new CuratorRepositoryImpl();
        return curatorRepository;
    }

    @Override
    public Curator create(Curator curator) {
        this.curators.add(curator);
        return curator;
    }

    @Override
    public Curator read(String curatorId) {
        return search(curatorId);
    }

    @Override
    public Curator update(Curator curator) {
        Curator curatorTemp = search(curator.getCuratorId());
        if (curatorTemp != null) {
            return create(new Curator.Builder()
                    .copy(curatorTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String curatorId) {
        Curator curatorDelete = search(curatorId);
        if (curatorDelete != null) this.curators.remove(curatorDelete);
    }

    private Curator search(final String curatorId) {
        for (Curator curatorSearch : this.curators) {
            if (curatorSearch.getCuratorId().equals(curatorId))
                return curatorSearch;
        }
        return null;
    }

    @Override
    public Set<Curator> getAll() {
        return this.curators;
    }
}