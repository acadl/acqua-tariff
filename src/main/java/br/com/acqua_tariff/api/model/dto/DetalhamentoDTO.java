package br.com.acqua_tariff.api.model.dto;

import java.math.BigDecimal;

public class DetalhamentoDTO {
	 	private FaixaDTO faixa;
	    private Integer m3Cobrados;
	    private BigDecimal valorUnitario;
	    private BigDecimal subtotal;

	    // getters e setters
	    public FaixaDTO getFaixa() { return faixa; }
	    public void setFaixa(FaixaDTO faixa) { this.faixa = faixa; }
	    public Integer getM3Cobrados() { return m3Cobrados; }
	    public void setM3Cobrados(Integer m3Cobrados) { this.m3Cobrados = m3Cobrados; }
	    public BigDecimal getValorUnitario() { return valorUnitario; }
	    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }
	    public BigDecimal getSubtotal() { return subtotal; }
	    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
