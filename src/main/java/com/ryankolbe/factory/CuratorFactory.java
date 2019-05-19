package com.ryankolbe.factory;

import com.ryankolbe.domain.Curator;

public class CuratorFactory {

    public static Curator createCurator(String curatorId, String curatorName, String curatorSurname) {
        return new Curator.Builder()
                .curatorId(curatorId)
                .curatorName(curatorName)
                .curatorSurname(curatorSurname)
                .build();
    }
}