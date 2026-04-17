package br.com.acqua_tariff.api.model.service;

import br.com.acqua_tariff.api.model.domain.FaixaConsumo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FaixaConsumoValidator {

    public void validar(List<FaixaConsumo> faixas) {
        if (faixas == null || faixas.isEmpty()) {
            throw new IllegalArgumentException("A lista de faixas não pode ser vazia.");
        }

        // Ordena por início para facilitar as validações
        List<FaixaConsumo> ordenadas = faixas.stream()
            .sorted((a, b) -> Integer.compare(a.getInicio(), b.getInicio()))
            .toList();

        // Regra: Cobertura completa — deve iniciar em 0
        if (ordenadas.get(0).getInicio() != 0) {
            throw new IllegalArgumentException("As faixas devem iniciar em 0 m³.");
        }

        for (int i = 0; i < ordenadas.size(); i++) {
            FaixaConsumo atual = ordenadas.get(i);

            // Regra: Ordem válida — início deve ser menor que fim
            if (atual.getInicio() >= atual.getFim()) {
                throw new IllegalArgumentException(
                    "Faixa inválida: início (" + atual.getInicio() +
                    ") deve ser menor que fim (" + atual.getFim() + ")."
                );
            }

            // Regra: Não sobreposição — fim da faixa atual não pode sobrepor início da próxima
            if (i < ordenadas.size() - 1) {
                FaixaConsumo proxima = ordenadas.get(i + 1);
                if (atual.getFim() >= proxima.getInicio()) {
                    throw new IllegalArgumentException(
                        "Sobreposição detectada entre faixas: [" +
                        atual.getInicio() + "-" + atual.getFim() + "] e [" +
                        proxima.getInicio() + "-" + proxima.getFim() + "]."
                    );
                }
            }
        }
    }
}