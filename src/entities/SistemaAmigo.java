package entities;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

	private List<Amigo> amigos;
	private List<Mensagem> mensagem;

	private int quantMensagens;

	public static final int QUANT_MAXIMA_MENSAGEM = 1000;

	public SistemaAmigo() {
		this.amigos = new ArrayList<>();
		this.mensagem = new ArrayList<>();

	}

	public SistemaAmigo(int msg) {
		this.quantMensagens = msg;
	}

	public int getQuantMensagens() {
		return quantMensagens;
	}

	public void setQuantMensagens(int quantMensagens) {
		this.quantMensagens = quantMensagens;
	}

	public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigosJaExistenteException {

		Amigo amigo = new Amigo(nomeAmigo, emailAmigo);

		if (!(amigo.getEmail().equalsIgnoreCase(emailAmigo)))
			this.amigos.add(amigo);

		else {
			throw new AmigosJaExistenteException("Amigo já existente.");
		}

	}

	public Amigo pesquisarAmigo(String email) {
		Amigo amigo = null;

		for (Amigo a : amigos) {

			if (a.getEmail().equalsIgnoreCase(email)) {
				amigo = a;

			}
		}

		return amigo;
	}

	public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
		Mensagem mensagens = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
		this.mensagem.add(mensagens);

	}

	public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatorio,
			boolean ehAnonima) {
		this.mensagem.add( new MensagemParaAlguem(texto, emailRemetente, ehAnonima));

	}

	public List<Mensagem> pesquisaTodasAsMensagens() {
		return this.mensagem;
	}

	public List<Mensagem> pesquisaMensagensAnonimas() {

		ArrayList<Mensagem> mensagensAnonimas = new ArrayList<>();

		for (Mensagem msg : mensagem) {
			if (msg.ehAnonima()) {
				mensagensAnonimas.add(msg);

			}
		}
		return mensagensAnonimas;
	}

	public String pesquisaAmigoSecretoDe(String emailDaPessoa)
			throws AmigoInexistenteException, AmigoNaoSorteadoException {
		boolean amigoAchado = false;

		for (Amigo amigo : amigos) {
			if (amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
				amigoAchado = true;

				if (amigo.getEmailAmigoSorteado() == null) {
					throw new AmigoNaoSorteadoException("Amigo não sorteado");

				}

				return amigo.getEmailAmigoSorteado();
			}
			if (!amigoAchado) {
				throw new AmigoInexistenteException("Amigo inexistente");

			}
		}

		return null;
	}

	public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado)
			throws AmigoInexistenteException {
		boolean amigoAchado = false;
		for (Amigo amigo : amigos) {
			if (amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
				amigo.setEmail(emailAmigoSorteado);
				amigoAchado = true;
			}
		}

		if (!amigoAchado) {
			throw new AmigoInexistenteException("Amigo Inexistente no sistema.");
		}

	}

	public List<Amigo> TodosOsParticipantes() throws AmigoInexistenteException {

		List<Amigo> amigos = new ArrayList<>();

		for (Amigo a : amigos) {
			System.out.println(a.getNome());

		}

		throw new AmigoInexistenteException("Amigo inexistentes");

	}

}
