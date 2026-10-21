package servicoNotificacao01;

public class EmailNotificador implements Notificador {
	@Override
	public void Enviar(String mensagem) {
		System.out.println("Enviando E-mail: " + mensagem);
	}
}