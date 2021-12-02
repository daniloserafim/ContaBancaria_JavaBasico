package View;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import Model.*;
import Controller.*;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = { "Dep�sito", "Saque", "Saldo", "Dados da Conta", "Extrato", "Extrato de Dep�sitos",
				"Extrato de Saques", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a op��o desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	};

	public static double solicitaValorMovimentacao(String operacao) {
		return Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do "+operacao+" que deseja realizar"));
	}

	public static void exibirSaldo(Conta conta) {
		JOptionPane.showMessageDialog(null, "Seu saldo � de: "+conta.getSaldo());
	};

	public static void exibirDadosDaConta(Conta conta) {
		JOptionPane.showMessageDialog(null, "Titular: "+conta.getTitularDaConta()+"\n Tipo de Conta: "+conta.getTipo()+"\n Saldo: "+conta.getSaldo());
	};

	public static void exibirExtratoCompleto() {
		JOptionPane.showMessageDialog(null, Operacoes.listaExtratoCompleto(), "Extrato Completo", JOptionPane.INFORMATION_MESSAGE);
	};

	public static void exibirExtratoDeDepositos() {
		JOptionPane.showMessageDialog(null, Operacoes.listaExtratoDepositos(), "Extrato de Dep�sitos", JOptionPane.INFORMATION_MESSAGE);
	};

	public static void exibirExtratoDeSaques() {
		JOptionPane.showMessageDialog(null, Operacoes.listaExtratoSaques(), "Extrato de Saques", JOptionPane.INFORMATION_MESSAGE);
	};

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa ser� encerrado!");
	};

	public static String solicitaTitular() {
		return JOptionPane.showInputDialog("Informe o seu nome completo");
	}

	public static String solicitaTipoDaConta() {
		String[] opcoes = { "Conta Corrente", "Conta Poupan�a" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione o tipo de conta que deseja criar", JOptionPane.OK_CANCEL_OPTION);
		
		String tipoDaConta = null;
		
		if (menu.getSelectedIndex() == 0) {
			tipoDaConta = "Conta Corrente";
		} else  {
			tipoDaConta = "Conta Poupan�a";
		}
		
		return tipoDaConta;
	}
	
	public static void opcaoInvalidaMsg() {
		JOptionPane.showMessageDialog(null, "D�gito inv�lido inserido!");
	}
	
	public static void saldoNegativoMsg() {
		JOptionPane.showMessageDialog(null, "Seu tipo de conta n�o permite netagivar seu saldo!");
	}
}
