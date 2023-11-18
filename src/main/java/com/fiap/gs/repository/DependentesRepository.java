package com.fiap.gs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.gs.models.Dependente;

public interface DependentesRepository extends JpaRepository<Dependente, Long> {
   
}