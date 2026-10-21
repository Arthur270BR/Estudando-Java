package servicoNotificacao02;

class ServicoPush extends ServicoNotificacao {
    protected Notificador criarNotificador() {
        return new PushNotificador();
    }
}