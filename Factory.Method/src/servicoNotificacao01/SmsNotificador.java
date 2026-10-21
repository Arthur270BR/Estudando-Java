package servicoNotificacao01;

public class SmsNotificador implements Notificador {
	@Override
	public void Enviar(String mensagem) {
		System.out.println("Enviando SMS: " + mensagem);
	}
}
