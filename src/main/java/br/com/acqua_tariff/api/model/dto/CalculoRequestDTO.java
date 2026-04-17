package br.com.acqua_tariff.api.model.dto;

public class CalculoRequestDTO {
	private String categoria;
    private Integer consumo;

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Integer getConsumo() { return consumo; }
    public void setConsumo(Integer consumo) { this.consumo = consumo; }
}
