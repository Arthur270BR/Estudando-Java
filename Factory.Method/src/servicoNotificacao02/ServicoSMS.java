package servicoNotificacao02;

class ServicoSms extends ServicoNotificacao {
    protected Notificador criarNotificador() {
        return new SmsNotificador();
    }
}