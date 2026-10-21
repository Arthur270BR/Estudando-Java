package servicoNotificacao02;
//
class SmsNotificador implements Notificador {
    public void enviar(Mensagem mensagem) {
    	
    }
    public void Enviar(Mensagem mensagem) {
		System.out.println("SMS para " + mensagem.getDestino() + ": " + mensagem.getTexto());
	}
    }

