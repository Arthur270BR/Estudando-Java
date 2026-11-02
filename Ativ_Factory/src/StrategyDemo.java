import java.util.Objects;

final class CadastroClienteService {
    private RegistrarClienteDecoder decoder;

    public CadastroClienteService(RegistrarClienteDecoder decoder) {
        definirDecoder(decoder);
    }

    public void definirDecoder(RegistrarClienteDecoder novoDecoder) {
        this.decoder = Objects.requireNonNull(novoDecoder, "Decoder obrigatorio.");
    }

    public MsgRegistrarCliente importar(String dados) {
        return decoder.decode(dados);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        CadastroClienteService servico =
                new CadastroClienteService(new RegistrarClienteXMLDecoder());

        System.out.println("Strategy | XML | " + servico.importar(EntradasExemplo.xml()));

        servico.definirDecoder(new RegistrarClienteCSVDecoder());
        System.out.println("Strategy | CSV | " + servico.importar(EntradasExemplo.csv()));

        servico.definirDecoder(new RegistrarClienteTextoFixoDecoder());
        System.out.println("Strategy | TEXTO FIXO | "
                + servico.importar(EntradasExemplo.textoFixo()));
    }
}