package servicoNotificacao02;

//Creator: Classe abstrata que possui o Factory Method
abstract class ServicoNotificacao {
    protected abstract Notificador criarNotificador(); // Factory Method

    final void notificar(Mensagem mensagem) {
        Notificador notificador = criarNotificador();
        notificador.Enviar(mensagem);
    }
}