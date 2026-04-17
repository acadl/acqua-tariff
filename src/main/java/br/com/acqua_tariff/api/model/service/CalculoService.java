package br.com.acqua_tariff.api.model.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acqua_tariff.api.model.domain.FaixaConsumo;
import br.com.acqua_tariff.api.model.domain.TabelaCategoria;
import br.com.acqua_tariff.api.model.domain.TabelaTarifaria;
import br.com.acqua_tariff.api.model.dto.*;
import br.com.acqua_tariff.api.model.repository.TabelaTarifariaRepository;

@Service
public class CalculoService {

    @Autowired
    private TabelaTarifariaRepository tabelaTarifariaRepository;

    public CalculoResponseDTO calcular(CalculoRequestDTO request) {

        // Busca a tabela ativa
        TabelaTarifaria tabela = tabelaTarifariaRepository.findByAtivoTrue()
            .stream()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Nenhuma tabela tarifária ativa encontrada"));

        // Busca a categoria correta
        TabelaCategoria categoriaEncontrada = tabela.getCategorias()
            .stream()
            .filter(c -> c.getCategoria().name().equals(request.getCategoria()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada: " + request.getCategoria()));

        // Faz o cálculo progressivo
        List<DetalhamentoDTO> detalhamento = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;
        int consumoRestante = request.getConsumo();

        for (FaixaConsumo faixa : categoriaEncontrada.getFaixas()) {
            if (consumoRestante <= 0) break;

            int inicioFaixa = faixa.getInicio();
            int fimFaixa = faixa.getFim();
            int tamanhoFaixa = fimFaixa - inicioFaixa;
            int m3Cobrados = Math.min(consumoRestante, tamanhoFaixa);

            BigDecimal subtotal = faixa.getValorUnitario()
                .multiply(BigDecimal.valueOf(m3Cobrados));

            valorTotal = valorTotal.add(subtotal);
            consumoRestante -= m3Cobrados;

            FaixaDTO faixaDTO = new FaixaDTO();
            faixaDTO.setInicio(inicioFaixa);
            faixaDTO.setFim(fimFaixa);

            DetalhamentoDTO det = new DetalhamentoDTO();
            det.setFaixa(faixaDTO);
            det.setM3Cobrados(m3Cobrados);
            det.setValorUnitario(faixa.getValorUnitario());
            det.setSubtotal(subtotal);

            detalhamento.add(det);
        }

        CalculoResponseDTO response = new CalculoResponseDTO();
        response.setCategoria(request.getCategoria());
        response.setConsumoTotal(request.getConsumo());
        response.setValorTotal(valorTotal);
        response.setDetalhamento(detalhamento);

        return response;
    }
}