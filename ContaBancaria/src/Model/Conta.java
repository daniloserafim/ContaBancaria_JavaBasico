package Model;

public class Conta {
	
	private String titularDaConta;
	
	private String tipo;
	
	private double saldo;
	
	public String getTitularDaConta() {
		return titularDaConta;
	}
	
	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}