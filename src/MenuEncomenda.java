import java.util.Scanner;

public class MenuEncomenda {
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
        String cod = scannerString("\nDigite o Código alfanomérico do artigo: ", scanner);
        return cod;
    }

    public int MenuEncomenda() throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU VENDAS-----------\n\n");
        sb.append("1 -> Deseja adicionar artigo há encomenda?\n");
        sb.append("2 -> Deseja remover artigo da encomenda?\n");
        sb.append("3 -> Deseja cancelar a encomenda?\n");
        sb.append("4 -> Deseja devolver a encomenda?\n");
        sb.append("5 -> Deseja finalizar a encomenda?\n");
        sb.append("6 -> Deseja voltar atrás?\n");
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
        if (a==4) sb.append("\n!!!!NÃO É POSSÍVEL CANCELAR A SUA ENCOMENDA (SUA ENCOMENDA FOI FINALIZADA TENTE DEVOLVER)!!!").append("\n");
        if (a==5) sb.append("\n!!!!NÃO É POSSÍVEL FINALIZAR A SUA ENCOMENDA (SEM ARTIGOS)!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
