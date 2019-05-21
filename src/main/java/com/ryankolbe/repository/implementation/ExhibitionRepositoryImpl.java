package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.repository.ExhibitionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ExhibitionRepository")
public class ExhibitionRepositoryImpl implements ExhibitionRepository {
    private static ExhibitionRepositoryImpl exhibitionRepository = null;
    private Set<Exhibition> exhibitions;


    private ExhibitionRepositoryImpl() {
        this.exhibitions = new HashSet<>();
    }

    public static ExhibitionRepositoryImpl getExhibitionRepository() {
        if (exhibitionRepository == null) exhibitionRepository = new ExhibitionRepositoryImpl();
        return exhibitionRepository;
    }

    @Override
    public Exhibition create(Exhibition exhibition) {
        this.exhibitions.add(exhibition);
        return exhibition;
    }

    @Override
    public Exhibition read(String exhibitionId) {
        return search(exhibitionId);
    }

    @Override
    public Exhibition update(Exhibition exhibition) {
        Exhibition exhibitionTemp = search(exhibition.getExhibitionId());
        if (exhibitionTemp != null) {
            return create(new Exhibition.Builder()
                    .copy(exhibitionTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String exhibitionId) {
        Exhibition exhibitionDelete = search(exhibitionId);
        if (exhibitionDelete != null) this.exhibitions.remove(exhibitionDelete);
    }

    private Exhibition search(final String exhibitionId) {
        for (Exhibition exhibitionSearch : this.exhibitions) {
            if (exhibitionSearch.getExhibitionId().equals(exhibitionId))
                return exhibitionSearch;
        }
        return null;
    }

    @Override
    public Set<Exhibition> getAll() {
        return this.exhibitions;
    }
}