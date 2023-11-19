package com.fiap.gs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fiap.gs.models.SituacaoUsuario;
import com.fiap.gs.models.TipoVacina;
import com.fiap.gs.models.Usuario;
import com.fiap.gs.models.Vacina;
import com.fiap.gs.repository.DependentesRepository;
import com.fiap.gs.repository.UsuarioRepository;
import com.fiap.gs.repository.VacinaRepository;

@Configuration
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	VacinaRepository vacinaRepository;
	
	@Autowired
	DependentesRepository dependenteRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setEmail("leonardkaric@gmail.com");
		usuario.setNome("Leonard Karic");
		usuario.setSenha(encoder.encode("12345"));
		usuario.setSituacao(SituacaoUsuario.ATIVADO);
		usuario.setTelefone("11965823342");
		
		Vacina vacina = new Vacina();
		vacina.setNome("Vacina 1");
		vacina.setTipo(TipoVacina.UNIQUE);
		vacina.setIntervalo(0);
		vacina.setPrimeiroMes(5);
		
		Vacina vacina2 = new Vacina();
		vacina2.setNome("Vacina 2");
		vacina2.setTipo(TipoVacina.PAIR);
		vacina2.setIntervalo(2);
		vacina2.setPrimeiroMes(5);
		
		Vacina vacina3 = new Vacina();
		vacina3.setNome("Vacina 3");
		vacina3.setTipo(TipoVacina.PAIR);
		vacina3.setIntervalo(2);
		vacina3.setPrimeiroMes(5);

		usuarioRepository.save(usuario);
		vacinaRepository.save(vacina);
		vacinaRepository.save(vacina2);
		vacinaRepository.save(vacina3);
		
		
	}
	
	
}
