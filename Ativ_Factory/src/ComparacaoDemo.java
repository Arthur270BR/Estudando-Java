public class ComparacaoDemo {
    public static void main(String[] args) {
        comparar("XML", EntradasExemplo.xml(), new XMLFactory(),
                new RegistrarClienteXMLDecoder(), new ImportadorXML());
        comparar("CSV", EntradasExemplo.csv(), new CSVFactory(),
                new RegistrarClienteCSVDecoder(), new ImportadorCSV());
        comparar("TEXTO FIXO", EntradasExemplo.textoFixo(), new TextoFixoFactory(),
                new RegistrarClienteTextoFixoDecoder(), new ImportadorTextoFixo());

        esperarFalha("CSV com 2 campos",
                () -> new CSVFactory().importar("Ana Silva,12345678901"));
        esperarFalha("CPF com menos de 11 digitos",
                () -> new CadastroClienteService(new RegistrarClienteCSVDecoder())
                        .importar("Ana Silva,123,ana@exemplo.com"));
        esperarFalha("Texto fixo curto",
                () -> new ImportadorTextoFixo().importar("texto curto"));
        esperarFalha("Entrada vazia no Template Method",
                () -> new ImportadorXML().importar(""));

        System.out.println("TODOS OS TESTES PASSARAM.");
    }

    private static void comparar(String formato, String entrada,
                                 ImportacaoFactory fabrica,
                                 RegistrarClienteDecoder estrategia,
                                 ImportadorClienteTemplate template) {
        MsgRegistrarCliente resultadoFactory = fabrica.importar(entrada);
        MsgRegistrarCliente resultadoStrategy =
                new CadastroClienteService(estrategia).importar(entrada);
        MsgRegistrarCliente resultadoTemplate = template.importar(entrada);

        if (!resultadoFactory.equals(resultadoStrategy)
                || !resultadoFactory.equals(resultadoTemplate)) {
            throw new AssertionError("Divergencia na importacao: " + formato);
        }
        System.out.println("[OK] " + formato + ": os 3 padroes geraram o mesmo objeto.\n");
    }

    private static void esperarFalha(String cenario, Runnable teste) {
        try {
            teste.run();
            throw new AssertionError("A falha esperada nao ocorreu: " + cenario);
        } catch (IllegalArgumentException esperado) {
            System.out.println("[OK] Erro detectado: " + cenario
                    + " | motivo: " + esperado.getMessage());
        }
    }
}