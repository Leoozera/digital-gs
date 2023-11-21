package com.fiap.gs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.gs.models.Aviso;
import com.fiap.gs.models.Dependente;
import com.fiap.gs.models.Usuario;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
	List<Aviso> findAllByDependente(Dependente dependente);
}