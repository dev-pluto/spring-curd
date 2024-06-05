package com.techindeck.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techindeck.master.model.ConstituentRoleType;

public interface ConstituentRoleTypeRepository extends JpaRepository<ConstituentRoleType, Long>{

    boolean existsByName(String name);

}
