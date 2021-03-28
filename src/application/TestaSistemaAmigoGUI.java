package application;

import java.util.List;

import javax.swing.JOptionPane;

import entities.Amigo;
import entities.AmigoInexistenteException;
import entities.AmigosJaExistenteException;
import entities.SistemaAmigo;

public class TestaSistemaAmigoGUI {

	public static void main(String[] args) {

		int quantMensagens = Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade de mensagens? "));
		SistemaAmigo sistema = new SistemaAmigo(quantMensagens);

		int numAmigos = Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade de amigos? "));

		for (int i = 0; i < numAmigos; i++) {
			String nomeAmigo = JOptionPane.showInputDialog("Digite o nome da pessoa: ");
			String emailAmigo = JOptionPane.showInputDialog("Digite o e-mail da pessoa? ");

			try {
				sistema.cadastraAmigo(nomeAmigo, emailAmigo);

			} catch (AmigosJaExistenteException e) {
				JOptionPane.showMessageDialog(null, "Error ao cadastrar usuário");
				e.printStackTrace();
			}
		}

		try {
			List<Amigo> participantes = sistema.TodosOsParticipantes();
			for (Amigo a : participantes) {
				String emailSorteado = JOptionPane.showInputDialog("Quem é amigo de " + a.getNome() + ": ");

			}

		} catch (AmigoInexistenteException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		String texto = JOptionPane.showInputDialog("Digite o texto da Mensagem: ");
		String emailRemetente = JOptionPane.showInputDialog("Digite o email do remetente: ");
		String mensagemEhAnonima = JOptionPane.showInputDialog("Eh anonima? ");
		
		boolean ehAnonima = false;
		
		if (mensagemEhAnonima.startsWith("S")) {
			ehAnonima = true;
		}
		
		sistema.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);

	}
}



























