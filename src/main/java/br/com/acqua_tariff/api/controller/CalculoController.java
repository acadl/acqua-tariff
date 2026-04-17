package br.com.acqua_tariff.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.acqua_tariff.api.model.dto.CalculoRequestDTO;
import br.com.acqua_tariff.api.model.dto.CalculoResponseDTO;
import br.com.acqua_tariff.api.model.service.CalculoService;

@RestController
@RequestMapping("/api/calculos")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping
    public ResponseEntity<CalculoResponseDTO> calcular(@RequestBody CalculoRequestDTO request) {
        CalculoResponseDTO response = calculoService.calcular(request);
        return ResponseEntity.ok(response);
    }
}