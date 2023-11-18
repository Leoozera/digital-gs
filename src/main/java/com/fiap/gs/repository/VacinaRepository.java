package com.fiap.gs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.gs.models.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
   
}