import java.util.Scanner;

public class MenuUtilizador {
    private InterfaceUtilizadores inter;

    public void setInterface(InterfaceUtilizadores inter){
        this.inter = inter;
    }

    public int scannerInt(String message, Scanner s){
        System.out.print(message);
        return s.nextInt();
    }

    public double scannerDouble(String message, Scanner s){
        System.out.print(message);
        return s.nextDouble();
    }

    public String scannerString(String message, Scanner s){
        System.out.print(message);
        return s.nextLine();
    }

    public int MenuUtilizador(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU UTILIZADOR-----------\n\n");
        sb.append("1 -> Deseja comprar\n");
        sb.append("2 -> Deseja vender\n");
        sb.append("3 -> Ver todos os artigos dispiníveis\n");
        sb.append("4 -> Voltar ao Menu Inicial\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int MenuTipoDoArtigo(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU VENDAS-----------\n\n");
        sb.append("1 -> Deseja vender uma Mala padrão?\n");
        sb.append("2 -> Deseja vender uma Mala Premium?\n");
        sb.append("3 -> Deseja vender Sapatilhas padrão?\n");
        sb.append("4 -> Deseja vender Sapatilhas Premium?\n");
        sb.append("5 -> Deseja vender uma Tshirt padrão?\n");
        sb.append("6 -> Deseja vender uma Tshirt com padrão Liso?\n");
        sb.append("7 -> Deseja vender uma Tshirt com padrão às Riscas?\n");
        sb.append("8 -> Deseja vender uma Tshit com padrão às Palmeiras?\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void MostraTodosArtigos(){
        System.out.println("Artigos para venda: ");
    }

    public boolean MenuArtigoMalas(int id_utilizador, int opcao){
        boolean a = false;
        StringBuilder sb = new StringBuilder("\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. \n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int id_transporte = scannerInt("Escolha um transporte a partir do IDENTIFICADOR para a entrega do artigo: ", scanner);
        scanner.nextLine();
        String marca = scannerString("Marca: ", scanner);
        String cod = scannerString("Código Alfanumérico: ", scanner);
        String descricao = scannerString("Descrição: ", scanner);
        double preco = scannerDouble("Preço Base: ", scanner);
        double avaliacao = scannerDouble("Avaliação(0...5): ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        double desconto = scannerDouble("Desconto em %: ", scanner);
        int ano = scannerInt("Ano da coleção: ", scanner);
        double altura = scannerDouble("Altura da mala(cm): ", scanner);
        double largura = scannerDouble("Largura da mala(cm): ", scanner);
        double profundidade = scannerDouble("Profundidade da mala(cm): ", scanner);
        scanner.nextLine();
        String material = scannerString("Material da mala: ", scanner);
        if(opcao == 1) a = inter.addMalaPadrao(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material);
        else if(opcao == 2){
            double valorizacao = scannerDouble("Valorização da mala em %: ", scanner);
            a = inter.addMalaPremium(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material, valorizacao);
        }
        return a;
    }

    public boolean MenuArtigoSapatilhas(int id_utilizador, int opcao){
        boolean r = false;
        StringBuilder sb = new StringBuilder("\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. \n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int id_transporte = scannerInt("Escolha um transporte a partir do IDENTIFICADOR para a entrega do artigo: ", scanner);
        scanner.nextLine();
        String marca = scannerString("Marca: ", scanner);
        String cod = scannerString("Código Alfanumérico: ", scanner);
        double preco = scannerDouble("Preço Base: ", scanner);
        scanner.nextLine();
        String detalhe = scannerString("Detalhes: ", scanner);
        String descricao = scannerString("Descrição: ", scanner);
        double avaliacao = scannerDouble("Avaliação(0..5): ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        double desconto = scannerDouble("Desconto em %: ", scanner);
        int ano = scannerInt("Ano da coleção: ", scanner);
        int tamanho = scannerInt("Número das Sapatilhas: ", scanner);
        scanner.nextLine();
        String cor = scannerString("Cor das Sapatilhas: ", scanner);
        if(opcao == 3) r = inter.addSapatilhasPadrao(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano);
        else if(opcao == 4){
            String autore = scannerString("\nAutor das Sapatilhas: ", scanner);
            r = inter.addSapatilhasPremium(donos, descricao, marca, cod, preco, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano, autore);
        }
        return r;
    }

    public boolean MenuArtigoTShit(int id_utilizador, int opcao){
        boolean r = false;
        StringBuilder sb = new StringBuilder("\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. \n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int id_transporte = scannerInt("Escolha um transporte a partir do IDENTIFICADOR para a entrega do artigo: ", scanner);
        scanner.nextLine();
        String marca = scannerString("Marca: ", scanner);
        String cod = scannerString("Código Alfanumérico: ", scanner);
        double preco = scannerDouble("Preço Base: ", scanner);
        scanner.nextLine();
        String detalhe = scannerString("Detalhes: ", scanner);
        String descricao = scannerString("Descrição: ", scanner);
        String padrao = scannerString("Padrão: ", scanner);
        double avaliacao = scannerDouble("Avaliação(0..5): ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        double desconto = scannerDouble("Desconto em %: ", scanner);
        scanner.nextLine();
        String tamanho = scannerString("Tamanho(S/M/L/XL): ", scanner);
        if(opcao == 5) r = inter.addTShirt(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
        else if(opcao == 6) r = inter.addTShirtLisa(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
        else if(opcao == 7) r = inter.addTShirtRiscas(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
        else if(opcao == 8) r = inter.addTShirtPalmeiras(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
        return r;
    }


    public void avisos(int a){
        StringBuilder sb = new StringBuilder();
        if (a==1) sb.append("\n!!!!Digite um número inteiro válido!!!!").append("\n");
        if (a==2) sb.append("\n!!!!ARTIGO JÁ EXISTE OU TRANSPORTADORA INVÁLIDA!!!").append("\n");
        if (a==3) sb.append("\n!!!!ARTIGO INDISPONÍVEL!!!").append("\n");
        if (a==4) sb.append("\n!!!!ARTIGO NÃO EXISTE NA SUA ENCOMENDA!!!").append("\n");
        if (a==5) sb.append("\n!!!!NÃO É POSSÍVEL DEVOLVER A SUA ENCOMENDA (FORA DE PRAZO)!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
