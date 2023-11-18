package com.fiap.gs.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.gs.exception.RestDuplicatedException;
import com.fiap.gs.exception.RestNotAuthorized;
import com.fiap.gs.models.Credencial;
import com.fiap.gs.models.SituacaoUsuario;
import com.fiap.gs.models.Usuario;
import com.fiap.gs.repository.UsuarioRepository;
import com.fiap.gs.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	AuthenticationManager manager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	TokenService tokenService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario) {
		try {

			usuario.setSenha(encoder.encode(usuario.getSenha()));
			repository.save(usuario);

			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

		} catch (DataIntegrityViolationException e) {
			throw new RestDuplicatedException("Já existe um usuario com este email ou telefone");
		}

	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
		manager.authenticate(credencial.toAuthentication());
		var token = tokenService.generateToken(credencial);
		return ResponseEntity.ok(token);
	}

	@DeleteMapping()
	public ResponseEntity<Usuario> delete() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();

		Usuario usuario = repository.findByEmail(email)
				.orElseThrow(() -> new RestNotAuthorized("Somente o próprio usuário pode deletar a própria conta."));

		usuario.setSituacao(SituacaoUsuario.DESATIVADO);
		repository.save(usuario);

		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String email = authentication.getName();

			Usuario usuarioSelecionado = repository.findByEmail(email).orElseThrow(
					() -> new RestNotAuthorized("Somente o próprio usuário pode atualizar a própria conta."));

			usuario.setId(usuarioSelecionado.getId());

			if (usuario.getEmail() == null)
				usuario.setEmail(usuarioSelecionado.getEmail());
			else
				usuario.setEmail(usuario.getEmail());

			if (usuario.getNome() == null)
				usuario.setNome(usuarioSelecionado.getNome());
			else
				usuario.setNome(usuario.getNome());

			if (usuario.getTelefone() == null)
				usuario.setTelefone(usuarioSelecionado.getTelefone());
			else
				usuario.setTelefone(usuario.getTelefone());

			if (usuario.getSenha() == null)
				usuario.setSenha(usuarioSelecionado.getSenha());
			else
				usuario.setSenha(encoder.encode(usuario.getSenha()));

			repository.save(usuario);
			return ResponseEntity.status(HttpStatus.OK).body(usuario);

		} catch (DataIntegrityViolationException e) {
			throw new RestDuplicatedException("Já existe um usuario com este email");
		}

	}

}
