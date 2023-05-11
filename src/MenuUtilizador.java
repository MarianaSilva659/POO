import java.util.Scanner;

public class MenuUtilizador {

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
    
    public void MostraTodosArtigos(){
        System.out.println("Artigos para venda: ");
    }

    public Malas MenuArtigoMalas(int id_utilizador){
        StringBuilder sb = new StringBuilder("\n\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. n\n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        double avaliacao = scannerDouble("Avaliação: ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        String descricao = scannerString("Descrição: ", scanner);
        String marca = scannerString("Marca:", scanner);
        String cod = scannerString("Código Alfanumérico: ", scanner);
        double preco = scannerDouble("Preço Base: ", scanner);
        double desconto = scannerDouble("Desconto em %: ", scanner);
        sb.append("Identificador do Transporte: ");
        return new Malas(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, 10, null, 1.1, 1.1, 1.1, null);
    }

    public MalasPremium MenuArtigoMalasP(int id_utilizador){
        StringBuilder sb = new StringBuilder("\n\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. n\n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        double avaliacao = scannerDouble("Avaliação: ", scanner);
        int donos = scannerInt("Número de Donos: ", scanner);
        sb.append("Descrição: ");
        String descricao = scannerString("Descrição: ", scanner);
        sb.append("Marca: ");
        String marca = scanner.nextLine();
        sb.append("Código Alfanumérico: ");
        String cod = scanner.nextLine();
        sb.append("Preço Base: ");
        double preco = scannerDouble("Preço Base: ", scanner);
        sb.append("Desconto em %: ");
        double desconto = scannerDouble("Desconto em %: ", scanner);
        sb.append("Identificador do Transporte: ");
        return new MalasPremium(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, 10, null, 1.1, 1.1, 1.1, null,0);
    }
}
