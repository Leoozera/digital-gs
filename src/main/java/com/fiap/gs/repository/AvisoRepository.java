package com.fiap.gs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.gs.models.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
   
}