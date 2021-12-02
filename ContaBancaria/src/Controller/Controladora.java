package Controller;

import Model.*;
import View.EntradaSaida;

public class Controladora {
	
	private static Conta conta = null;
	
	private Movimentacao movimentacao = null;
	
	public String tipoDeMovimentacao = null;
	
	public void iniciarApp() {		
		exibeMenu(Operacoes.configurarConta(conta));
		
	}
	
	public void exibeMenu(Conta conta) {
		int opcao;
		
		do {
			opcao = View.EntradaSaida.solicitaOpcao();

			switch (opcao) {
			case 0:
				tipoDeMovimentacao = "Depósito";
				Operacoes.solicitaMovimentacao(conta, movimentacao, tipoDeMovimentacao);
				break;
			case 1:
				tipoDeMovimentacao = "Saque";
				Operacoes.solicitaMovimentacao(conta, movimentacao, tipoDeMovimentacao);
				break;
			case 2:
				EntradaSaida.exibirSaldo(conta);
				break;
			case 3:
				EntradaSaida.exibirDadosDaConta(conta);
				break;
			case 4:
				EntradaSaida.exibirExtratoCompleto();
				break;
			case 5:
				EntradaSaida.exibirExtratoDeDepositos();
				break;
			case 6:
				EntradaSaida.exibirExtratoDeSaques();
				break;
			case 7:
				EntradaSaida.exibeMsgEncerraPrograma();
				break;
			default:
				EntradaSaida.opcaoInvalidaMsg();
				break;				
			}
		}while (opcao != 7);

		System.exit(0);
	}
}
