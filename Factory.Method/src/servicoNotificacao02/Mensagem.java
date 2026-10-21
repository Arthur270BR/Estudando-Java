package servicoNotificacao02;

//Encapsula destino e texto da mensagem
class Mensagem {
	private final String destino;
	private final String texto;
	
	Mensagem(String destino, String texto){
		this.destino = destino;
		this.texto = texto;
	}
	String getDestino() {
		return destino;
	}
	String getTexto() {
		return texto;
	}
}
