package View;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import Model.*;
import Controller.*;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = { "Depósito", "Saque", "Saldo", "Dados da Conta", "Extrato", "Extrato de Depósitos",
				"Extrato de Saques", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	};

	public static double solicitaValorMovimentacao(String operacao) {
		return Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do "+operacao+" que deseja realizar"));
	}

	public static void exibirSaldo(Conta conta) {
		JOptionPane.showMessageDialog(null, "Seu saldo é de: "+conta.getSaldo());
	};

	public static void exibirDadosDaConta(Conta conta) {
		JOptionPane.showMessageDialog(null, "Titular: "+conta.getTitularDaConta()+"\n Tipo de Conta: "+conta.getTipo()+"\n Saldo: "+conta.getSaldo());
	};

	public static void exibirExtratoCompleto() {
		JOptionPane.showMessageDialog(null, Operacoes.listaExtratoCompleto(), "Extrato Completo", JOptionPane.INFORMATION_MESSAGE);
	};

	public static void exibirExtratoDeDepositos() {
		JOptionPane.showMessageDialog(null, Operacoes.listaExtratoDepositos(), "Extrato de Depósitos", JOptionPane.INFORMATION_MESSAGE);
	};

	public static void exibirExtratoDeSaques() {
		JOptionPane.showMessageDialog(null, Operacoes.listaExtratoSaques(), "Extrato de Saques", JOptionPane.INFORMATION_MESSAGE);
	};

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	};

	public static String solicitaTitular() {
		return JOptionPane.showInputDialog("Informe o seu nome completo");
	}

	public static String solicitaTipoDaConta() {
		String[] opcoes = { "Conta Corrente", "Conta Poupança" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione o tipo de conta que deseja criar", JOptionPane.OK_CANCEL_OPTION);
		
		String tipoDaConta = null;
		
		if (menu.getSelectedIndex() == 0) {
			tipoDaConta = "Conta Corrente";
		} else  {
			tipoDaConta = "Conta Poupança";
		}
		
		return tipoDaConta;
	}
	
	public static void opcaoInvalidaMsg() {
		JOptionPane.showMessageDialog(null, "Dígito inválido inserido!");
	}
	
	public static void saldoNegativoMsg() {
		JOptionPane.showMessageDialog(null, "Seu tipo de conta não permite netagivar seu saldo!");
	}
}
