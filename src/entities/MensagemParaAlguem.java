package entities;

public class MensagemParaAlguem extends Mensagem {

	private String emailDestinatario;
	
	public MensagemParaAlguem(String texto, String emailDestinatario, boolean anonima) {
		super(texto, emailDestinatario, anonima);
		
	}

	public String getEmailRemetente() {
		return emailDestinatario;
	}

	public void setEmailRemetente(String emailRemetente) {
		this.emailDestinatario = emailRemetente;
	}

	@Override
	public String getTextoCompletoAExibir() {
		// TODO Auto-generated method stub
		 return "Mensagem para: "+this.emailDestinatario+ "\nTexto da mensagem:"+getTexto();
	}
	
	

}
