package com.ryankolbe.repository;

import com.ryankolbe.model.Artwork;

import java.util.HashSet;
import java.util.Set;

public class ArtWorkRepositoryImp implements ArtWorkRepository {
    private static ArtWorkRepository artWorkRepository = null;
    private Set<Artwork> artworks;

    private ArtWorkRepositoryImp() {
        this.artworks = new HashSet<>();
    }

    public static ArtWorkRepository getArtWorkRepository() {
        if (artWorkRepository == null) artWorkRepository = new ArtWorkRepositoryImp();
        return artWorkRepository;
    }

    @Override
    public Artwork create(Artwork artwork) {
        this.artworks.add(artwork);
        return artwork;
    }

    @Override
    public Artwork read(String artworkId) {
        return search(artworkId);
    }

    @Override
    public Artwork update(Artwork artwork) {
        Artwork artworkTemp = search(artwork.getArtworkId());
        if (artworkTemp != null) {
            Artwork artworkNew = new Artwork.Builder()
                    .copy(artworkTemp)
                    .build();
            return create(artworkNew);
        }
        return null;
    }

    @Override
    public void delete(String artworkId) {
        Artwork artwork = search(artworkId);
        if (artwork != null) this.artworks.remove(artwork);
    }

    @Override
    public Set<Artwork> getAll() {
        return this.artworks;
    }

    public Artwork search(final String artworkId) {
        for (Artwork artworkSearch : this.artworks) {
            if (artworkSearch.getArtworkId().equals(artworkId))
                return artworkSearch;
        }
        return null;
    }
}
