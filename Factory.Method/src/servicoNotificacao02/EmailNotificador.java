package servicoNotificacao02;

//Concrete Products: Implementações específicas de envio
public class EmailNotificador implements Notificador {
	
	public void Enviar(Mensagem mensagem) {
		System.out.println("EMAIL para " + mensagem.getDestino() + ": " + mensagem.getTexto());
	}
}