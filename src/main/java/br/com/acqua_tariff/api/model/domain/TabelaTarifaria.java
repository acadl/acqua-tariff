package br.com.acqua_tariff.api.model.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class TabelaTarifaria {
	
	@Id
    private Integer id;
    
    private String nome;
    private LocalDate vigencia;
    private Boolean ativo = true;
    private LocalDateTime criadoEm = LocalDateTime.now();
    
    
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
	public LocalDate getVigencia() {
		return vigencia;
	}
	public void setVigencia(LocalDate vigencia) {
		this.vigencia = vigencia;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}
    

   

}
