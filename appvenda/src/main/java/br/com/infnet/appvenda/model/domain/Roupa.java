package br.com.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TRoupa")
public class Roupa extends Produto{

	private String marca;
	private String cor;
	private String tamanho;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(), marca, cor, tamanho);
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
