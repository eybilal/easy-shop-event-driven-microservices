package com.eybilal.esedmauthservice.repository;

import com.eybilal.esedmauthservice.model.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
