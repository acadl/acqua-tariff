package br.com.acqua_tariff.api.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acqua_tariff.api.model.domain.TabelaTarifaria;
import br.com.acqua_tariff.api.model.domain.TabelaCategoria;
import br.com.acqua_tariff.api.model.domain.FaixaConsumo;
import br.com.acqua_tariff.api.model.repository.TabelaTarifariaRepository;

@Service
public class TabelaTarifariaService {

    @Autowired
    private TabelaTarifariaRepository tabelaTarifariaRepository;
    
    @Autowired
    private FaixaConsumoValidator faixaConsumoValidator;

    public List<TabelaTarifaria> obterLista() {
        return tabelaTarifariaRepository.findByAtivoTrue();
    }

    public TabelaTarifaria incluir(TabelaTarifaria tabelaTarifaria) {

        // Para cada categoria, vincula a tabela pai
        for (TabelaCategoria categoria : tabelaTarifaria.getCategorias()) {
            categoria.setTabelaTarifaria(tabelaTarifaria);

            // Para cada faixa, vincula a categoria pai
            for (FaixaConsumo faixa : categoria.getFaixas()) {
                faixa.setTabelaCategoria(categoria);
            }
            
         // Valida as faixas de cada categoria (impede sobreposição) antes de salvar
            faixaConsumoValidator.validar(categoria.getFaixas());
        }

        return tabelaTarifariaRepository.save(tabelaTarifaria);
    }

    public void excluir(Integer id) {
        TabelaTarifaria tabela = tabelaTarifariaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tabela não encontrada com id: " + id));

        tabela.setAtivo(false);
        tabelaTarifariaRepository.save(tabela);
    }
}