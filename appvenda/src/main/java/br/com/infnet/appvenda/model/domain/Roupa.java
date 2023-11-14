package br.com.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="TRoupa")
public class Roupa extends Produto{

	@Size(min = 1, max = 100, message = "A marca deve ter entre {min} e {max} caracteres.")
	private String marca;
	
	@Size(min = 1, max = 100, message = "A cor deve ter entre {min} e {max} caracteres.")
	private String cor;
	
	@Size(min = 1, max = 100, message = "O tamanho deve ter entre {min} e {max} caracteres.")
	private String tamanho;
	
	@Override
	public String toString() {
		return String.format("%s - marca (%s) - cor (%s) - tamanho (%s)", 
				super.toString(), marca, cor, tamanho);
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}	
}
