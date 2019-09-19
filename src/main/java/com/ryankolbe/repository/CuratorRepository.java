package com.ryankolbe.repository;

import com.ryankolbe.domain.Curator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratorRepository extends JpaRepository<Curator, String> {
}
