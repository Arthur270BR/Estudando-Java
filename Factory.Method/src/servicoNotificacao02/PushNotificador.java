package servicoNotificacao02;

public class PushNotificador implements Notificador {
	@Override
	public void Enviar(Mensagem mensagem) {
		System.out.println("PUSH para " + mensagem.getDestino() + ": " + mensagem.getTexto());
	}
}
