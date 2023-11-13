package br.com.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name="TCalcado")
public class Calcado extends Produto {

	@Size(min = 2, max = 100, message = "A marca deve ter entre {min} e {max} caracteres.")
	private String marca;
	
	@Size(min = 2, max = 100, message = "A cor deve ter entre {min} e {max} caracteres.")
	private String cor;
	
	@PositiveOrZero
	private int tamanho;
	
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

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}	
}
