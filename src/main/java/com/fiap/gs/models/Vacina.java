package com.fiap.gs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.GenerationType;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Vacina {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Size(min = 1, max = 50, message = "Nome da vacina deve possuír entre 1 e 50 caractéres!")
    @NotEmpty 
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private TipoVacina tipo;
    
    @Min(value = 0, message = "O mes da primeira aplicação deverá ser um inteiro maior que 0!") 
    @NotNull
    private Integer primeiroMes;
    
    @Min(value = 0, message = "O intervalo de meses para as próximas aplicações deve ser maior que 0!") 
    private Integer intervalo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoVacina getTipo() {
		return tipo;
	}

	public void setTipo(TipoVacina tipo) {
		this.tipo = tipo;
	}

	public Integer getPrimeiroMes() {
		return primeiroMes;
	}

	public void setPrimeiroMes(Integer primeiroMes) {
		this.primeiroMes = primeiroMes;
	}

	public Integer getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
 
    

}
