package br.com.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TCalcado")
public class Calcado extends Produto {

	private String marca;
	private String cor;
	private int tamanho;
	
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

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}	
}
