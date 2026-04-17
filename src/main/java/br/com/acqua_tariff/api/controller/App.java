package br.com.acqua_tariff.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {


	    @GetMapping("/api/tabelas-tarifarias/{id}") // Gerenciar tabela: DELETE
	    public String removerTabelaTarifaria() {
	        return "Chamou o método remover tabela";
	    }

	    @GetMapping("/api/calculos") // Endpoint Cálculo: POST
	    public String calcularValorPagar() {
	        return "Chamou o método Calcular valor";
	    }

	    

}












