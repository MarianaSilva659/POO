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
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int MenuTipoDoArtigo(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU UTILIZADOR-----------\n\n");
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
        StringBuilder sb = new StringBuilder("\n\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. \n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int id_transporte = scannerInt("Escolha um identificador do transporte que vai entregar o artigo: ", scanner);
        scanner.nextLine();
        String marca = scannerString("Marca: ", scanner);
        String cod = scannerString("Código Alfanumérico: ", scanner);
        String descricao = scannerString("Descrição: ", scanner);
        double preco = scannerDouble("Preço Base: ", scanner);
        double avaliacao = scannerDouble("Avaliação: ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        double desconto = scannerDouble("Desconto em %: ", scanner);
        int ano = scannerInt("Ano da coleção: ", scanner);
        double altura = scannerDouble("Altura da mala(cm): ", scanner);
        double largura = scannerDouble("Largura da mala(cm): ", scanner);
        double profundidade = scannerDouble("Profundidade da mala(cm): ", scanner);
        scanner.nextLine();
        String material = scannerString("Material da mala: ", scanner);
        if(opcao == 1) return inter.addMalaPadrao(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material);
        else if(opcao == 2){
            double valorizacao = scannerDouble("\nValorização da mala: ", scanner);
           return inter.addMalaPremium(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material, valorizacao);
        }
    }

    public boolean MenuArtigoSapatilhas(int id_utilizador, int opcao){
        StringBuilder sb = new StringBuilder("\n\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. n\n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int id_transporte = scannerInt("Escolha um identificador do transporte que vai entregar o artigo: ", scanner);
        scanner.nextLine();
        String marca = scannerString("Marca: ", scanner);
        String cod = scannerString("Código Alfanumérico: ", scanner);
        double preco = scannerDouble("Preço Base: ", scanner);
        scanner.nextLine();
        String detalhe = scannerString("Detalhes: ", scanner);
        String descricao = scannerString("Descrição: ", scanner);
        double avaliacao = scannerDouble("Avaliação: ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        double desconto = scannerDouble("Desconto em %: ", scanner);
        int ano = scannerInt("Ano da coleção: ", scanner);
        int tamanho = scannerInt("Número das Sapatilhas: ", scanner);
        scanner.nextLine();
        String cor = scannerString("Cor das Sapatilhas: ", scanner);
        if(opcao == 3) return inter.addSapatilhasPadrao(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano);
        else if(opcao == 4){
            String autore = scannerString("\nAutor das Sapatilhas: ", scanner);
            return inter.addSapatilhasPremium(donos, descricao, marca, cod, preco, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano, autore);
        }
    }
}



/*Malas
StringBuilder sb = new StringBuilder("\n\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. \n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int id_transporte = scannerInt("Escolha um identificador do transporte que vai entregar o artigo: ", scanner);
        String marca = scannerString("Marca: ", scanner);
        String cod = scannerString("Código Alfanumérico: ", scanner);
        double preco = scannerDouble("Preço Base: ", scanner);
        double avaliacao = scannerDouble("Avaliação: ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        String descricao = scannerString("Descrição: ", scanner);
        double desconto = scannerDouble("Desconto em %: ", scanner);
        int ano = scannerInt("Ano da coleção: ", scanner);
        double altura = scannerDouble("Altura da mala(cm): ", scanner);
        double largura = scannerDouble("Largura da mala(cm): ", scanner);
        double profundidade = scannerDouble("Profundidade da mala(cm): ", scanner);
        String material = scannerString("Material da mala: ", scanner);
        if(opcao == 1) inter.addMalaPadrao(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material);
        else if(opcao == 2){
            double valorizacao = scannerDouble("\nValorização da mala: ", scanner);
            inter.addMalaPremium(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material, valorizacao);
    
        } */