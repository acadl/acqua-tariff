package br.com.acqua_tariff.api.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class CalculoResponseDTO {
	 private String categoria;
	    private Integer consumoTotal;
	    private BigDecimal valorTotal;
	    private List<DetalhamentoDTO> detalhamento;

	    
	    public String getCategoria() { return categoria; }
	    public void setCategoria(String categoria) { this.categoria = categoria; }
	    public Integer getConsumoTotal() { return consumoTotal; }
	    public void setConsumoTotal(Integer consumoTotal) { this.consumoTotal = consumoTotal; }
	    public BigDecimal getValorTotal() { return valorTotal; }
	    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
	    public List<DetalhamentoDTO> getDetalhamento() { return detalhamento; }
	    public void setDetalhamento(List<DetalhamentoDTO> detalhamento) { this.detalhamento = detalhamento; }
}
