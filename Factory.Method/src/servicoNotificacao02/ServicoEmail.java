package servicoNotificacao02;

//Concrete Creators: Subclasses especializadas em criar os objetos corretos
class ServicoEmail extends ServicoNotificacao {
 protected Notificador criarNotificador() {
     return new EmailNotificador();
 }
}