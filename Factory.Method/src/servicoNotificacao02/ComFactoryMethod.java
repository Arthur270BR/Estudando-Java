package servicoNotificacao02;

public class ComFactoryMethod {

	public static void main(String[] args) {
		Mensagem boasVindas = new Mensagem("aluno@estacio.br", "Bem-vindo");
		Mensagem protocolo = new Mensagem("8599990000", "Solicitação recebida");
		Mensagem chamado = new Mensagem("device-123", "Chamado atualizado");
		
		ServicoEmail email = new  ServicoEmail();
		ServicoSms sms = new ServicoSms();
		ServicoPush push = new ServicoPush();
		
		email.notificar(boasVindas);
		sms.notificar(protocolo);
		push.notificar(chamado);
	}

}
