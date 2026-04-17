package br.com.acqua_tariff.api.model.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TabelaCategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "tabela_tarifaria_id", nullable = false)
    private TabelaTarifaria tabelaTarifaria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaEnum categoria;

    @OneToMany(mappedBy = "tabelaCategoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<FaixaConsumo> faixas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TabelaTarifaria getTabelaTarifaria() {
		return tabelaTarifaria;
	}

	public void setTabelaTarifaria(TabelaTarifaria tabelaTarifaria) {
		this.tabelaTarifaria = tabelaTarifaria;
	}

	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	public List<FaixaConsumo> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<FaixaConsumo> faixas) {
		this.faixas = faixas;
	}
    
    

}
