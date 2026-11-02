// Abstract Class: fixa a ordem do algoritmo; as subclasses mudam a extracao.
abstract class ImportadorClienteTemplate {
    public final MsgRegistrarCliente importar(String entrada) {
        System.out.println("  [1/3] Validar entrada");
        validarEntrada(entrada);

        System.out.println("  [2/3] Extrair campos (etapa variavel)");
        DadosCliente dados = extrairCampos(entrada);

        System.out.println("  [3/3] Montar mensagem (etapa comum)");
        return montarMensagem(dados);
    }

    protected void validarEntrada(String entrada) {
        if (entrada == null || entrada.isBlank()) {
            throw new IllegalArgumentException("A entrada nao pode ficar vazia.");
        }
    }

    protected abstract DadosCliente extrairCampos(String entrada);

    protected MsgRegistrarCliente montarMensagem(DadosCliente dados) {
        return Mensagens.montar(dados);
    }
}

final class ImportadorXML extends ImportadorClienteTemplate {
    @Override
    protected DadosCliente extrairCampos(String entrada) {
        return LeitoresDados.xml(entrada);
    }
}

final class ImportadorCSV extends ImportadorClienteTemplate {
    @Override
    protected DadosCliente extrairCampos(String entrada) {
        return LeitoresDados.csv(entrada);
    }
}

final class ImportadorTextoFixo extends ImportadorClienteTemplate {
    @Override
    protected DadosCliente extrairCampos(String entrada) {
        return LeitoresDados.textoFixo(entrada);
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        executar("XML", new ImportadorXML(), EntradasExemplo.xml());
        executar("CSV", new ImportadorCSV(), EntradasExemplo.csv());
        executar("TEXTO FIXO", new ImportadorTextoFixo(), EntradasExemplo.textoFixo());
    }

    private static void executar(String formato, ImportadorClienteTemplate importador,
                                String entrada) {
        System.out.println("Template Method | " + formato);
        System.out.println("  Resultado: " + importador.importar(entrada));
    }
}