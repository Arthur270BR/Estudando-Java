// Creator: define o metodo fabrica e a operacao que utiliza o produto.
abstract class ImportacaoFactory {
    public abstract RegistrarClienteDecoder criarDecoder();

    public MsgRegistrarCliente importar(String dados) {
        RegistrarClienteDecoder decoder = criarDecoder();
        return decoder.decode(dados);
    }
}

// Concrete Creators: cada subclasse decide qual decoder instanciar.
final class XMLFactory extends ImportacaoFactory {
    @Override
    public RegistrarClienteDecoder criarDecoder() {
        return new RegistrarClienteXMLDecoder();
    }
}

final class CSVFactory extends ImportacaoFactory {
    @Override
    public RegistrarClienteDecoder criarDecoder() {
        return new RegistrarClienteCSVDecoder();
    }
}

final class TextoFixoFactory extends ImportacaoFactory {
    @Override
    public RegistrarClienteDecoder criarDecoder() {
        return new RegistrarClienteTextoFixoDecoder();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        mostrar("XML", new XMLFactory(), EntradasExemplo.xml());
        mostrar("CSV", new CSVFactory(), EntradasExemplo.csv());
        mostrar("TEXTO FIXO", new TextoFixoFactory(), EntradasExemplo.textoFixo());
    }

    private static void mostrar(String formato, ImportacaoFactory fabrica, String entrada) {
        MsgRegistrarCliente resultado = fabrica.importar(entrada);
        System.out.println("Factory Method | " + formato + " | " + resultado);
    }
}