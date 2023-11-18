package com.fiap.gs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.gs.models.Dependente;

public interface DependentesRepository extends JpaRepository<Dependente, Long> {
	Page<Dependente> findByUsuarioIdOrderByIdDesc(Integer idUsuario, Pageable pageable);

	Dependente findById(Integer id);
}