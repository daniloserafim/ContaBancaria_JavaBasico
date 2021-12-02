package Model;

import java.util.Date;

public class Movimentacao {
	
	private String tipo;
	
	private double valor;
	
	private Date data;
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return this.data;
	}
	
	public void setData() {
		this.data = new Date();
	}
}
