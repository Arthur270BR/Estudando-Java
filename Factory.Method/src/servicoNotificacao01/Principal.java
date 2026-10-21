package servicoNotificacao01;

public class Principal {

	public static void main(String[] args) {
		FabricaNotificador fabrica = new FabricaNotificador();
		
		// Pede a criação para a fábrica
		Notificador notificador = fabrica.criar("Email");
		
		// Usa o método sem se preocupar com o 'new' ou com a classe concreta
		notificador.Enviar("Olá, isso é um teste do Factory Method!");
	}
}
