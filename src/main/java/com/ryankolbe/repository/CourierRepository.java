package com.ryankolbe.repository;

import com.ryankolbe.domain.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, String> {
}
