package entities;

public class MensagemParaTodos extends Mensagem {

	public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
		super(texto, emailRemetente, anonima);

	}
	
	public MensagemParaTodos() {
		this("", "", false);
	}

	@Override
	public String getTextoCompletoAExibir() {
		// TODO Auto-generated method stub
		if(super.ehAnonima()) {
            return "Mensagem para todos\nTexto: "+ getTexto();
        }else {
            return "Mensagem de " + super.getEmailRemetente() + " Para todos\n" +"Texto:" + super.getTexto();
        }
	}
	
	
	
}
