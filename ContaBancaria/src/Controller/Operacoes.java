package Controller;

import Model.*;
import View.EntradaSaida;
import java.util.ArrayList;

public class Operacoes {

	static ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

	public static Conta configurarConta(Conta conta) {
		conta = new Conta();
		conta.setTitularDaConta(EntradaSaida.solicitaTitular());
		conta.setTipo(EntradaSaida.solicitaTipoDaConta());
		conta.setSaldo(0);

		return conta;
	}

	public static void solicitaMovimentacao(Conta conta, Movimentacao movimentacao, String tipoDeMovimentacao) {
		realizaMovimentacao(tipoDeMovimentacao, EntradaSaida.solicitaValorMovimentacao(tipoDeMovimentacao), conta,
				movimentacao);
	}

	public static void realizaMovimentacao(String tipo, double valor, Conta conta, Movimentacao movimentacao) {
		movimentacao = new Movimentacao();
		movimentacao.setTipo(tipo);
		movimentacao.setValor(valor);
		movimentacao.setData();

		double valorTotal = 0;

		switch (tipo) {
		case "Depósito":
			valorTotal = conta.getSaldo() + valor;
			conta.setSaldo(valorTotal);
			movimentacoes.add(movimentacao);
			break;
		case "Saque":
			if ((conta.getTipo().equals("Conta Poupança"))&&((conta.getSaldo() - valor)<0)) {
				EntradaSaida.saldoNegativoMsg();
			} else {
				valorTotal = conta.getSaldo() - valor;
				conta.setSaldo(valorTotal);
				movimentacoes.add(movimentacao);
			}
			break;
		}
	}

	public static String listaExtratoCompleto() {

		String listaExtrato = "";

		for (Movimentacao movimentacao : movimentacoes) {
			listaExtrato += movimentacao.getTipo() + "\n" + movimentacao.getValor() + "\n" + movimentacao.getData()
					+ "\n\n";
		}
		return listaExtrato;
	}

	public static String listaExtratoDepositos() {
		String listaExtrato = "";

		for (Movimentacao movimentacao : movimentacoes) {
			if (movimentacao.getTipo().equals("Depósito")) {
				listaExtrato += movimentacao.getTipo() + "\n" + movimentacao.getValor() + "\n" + movimentacao.getData()
						+ "\n\n";
			}
		}
		return listaExtrato;
	}

	public static String listaExtratoSaques() {
		String listaExtrato = "";

		for (Movimentacao movimentacao : movimentacoes) {
			if (movimentacao.getTipo().equals("Saque")) {
				listaExtrato += movimentacao.getTipo() + "\n" + movimentacao.getValor() + "\n" + movimentacao.getData()
						+ "\n\n";
			}
		}
		return listaExtrato;
	}

}
