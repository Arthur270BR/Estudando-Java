package servicoNotificacao01;

public class FabricaNotificador {
	public Notificador criar(String mensagem) {
		String tipo = "email";
		
		
		if (tipo.equalsIgnoreCase("email")) {
			return new EmailNotificador(); // O 'new' concentrado aqui
		} else if (tipo.equalsIgnoreCase("sms")) {
			return new SmsNotificador(); // O 'new' concentrado aqui
		}
		throw new IllegalArgumentException("Tipo desconhecido");
	}
}
