package br.com.acqua_tariff.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.acqua_tariff.api.model.domain.TabelaTarifaria;
import br.com.acqua_tariff.api.model.service.TabelaTarifariaService;

@RestController
@RequestMapping("/api/tabelas-tarifarias")
public class TabelaTarifariaController {

    @Autowired
    private TabelaTarifariaService tabelaTarifariaService;

    // POST /api/tabelas-tarifarias
    @PostMapping
    public ResponseEntity<TabelaTarifaria> incluir(@RequestBody TabelaTarifaria tabelaTarifaria) {
        TabelaTarifaria salva = tabelaTarifariaService.incluir(tabelaTarifaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // GET /api/tabelas-tarifarias
    @GetMapping
    public ResponseEntity<List<TabelaTarifaria>> obterLista() {
        List<TabelaTarifaria> lista = tabelaTarifariaService.obterLista();
        return ResponseEntity.ok(lista);
    }

    // DELETE /api/tabelas-tarifarias/{id}
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        // tabelaTarifariaService.excluir(id);
        // return ResponseEntity.noContent().build();
    // }
}