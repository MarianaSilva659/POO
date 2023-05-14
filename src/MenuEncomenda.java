import java.util.Scanner;

public class MenuEncomenda {
    private InterfaceEncomendas inter;

    public void setInterface(InterfaceEncomendas inter){
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

    public String MenuEscolheArtigo(){
        StringBuilder sb = new StringBuilder("\n");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        String cod = scannerString("Digite o Código alfanomérico do artigo: ", scanner);
        return cod;
    }

    public int MenuMaisArtigos(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU VENDAS-----------\n\n");
        sb.append("1 -> Adicionar mais artigos há encomenda?\n");
        sb.append("2 -> Deseja finalizar a encomenda\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int MenuEncomenda(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU VENDAS-----------\n\n");
        sb.append("1 -> Deseja adicionar artigo há encomenda?\n");
        sb.append("2 -> Deseja remover artigo da encomenda?\n");
        sb.append("3 -> Deseja devolver a encomenda?\n");
        sb.append("4 -> Deseja finalizar a encomenda?\n");
        sb.append("5 -> Deseja voltar atrás?\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void avisos(int a){
        StringBuilder sb = new StringBuilder();
        if (a==1) sb.append("\n!!!!ARTIGO INDISPONÍVEL!!!").append("\n");
        if (a==2) sb.append("\n!!!!ARTIGO NÃO EXISTE NA SUA ENCOMENDA!!!").append("\n");
        if (a==3) sb.append("\n!!!!NÃO É POSSÍVEL DEVOLVER A SUA ENCOMENDA (FORA DE PRAZO)!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
