package br.com.acqua_tariff.api.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acqua_tariff.api.model.domain.TabelaTarifaria;
import br.com.acqua_tariff.api.model.repository.TabelaTarifariaRepository;

@RestController
public class TabelaTarifariaController {
	
	@Autowired
	private TabelaTarifariaRepository tabelaTarifariaRepository;
	
	@GetMapping("/api/tabelas-tarifas")
	public String criarTabelaTarifariaCompleta(){
		
		
		TabelaTarifaria tabelaTarifaria = new TabelaTarifaria();
		
		tabelaTarifaria.setId(1);
		tabelaTarifaria.setNome("Primeira tabela!");
		tabelaTarifaria.setVigencia(LocalDate.of(2024, 1, 15));
	    
		tabelaTarifariaRepository.save(tabelaTarifaria);
	    
		
        return "Chamou o método criar tabela";
    }
	
	@GetMapping("/api/listar-tabelas-tarifarias")
	public String listarTabelasTarifarias() {
        return "Chamou o método listar tabela";
    }

}
