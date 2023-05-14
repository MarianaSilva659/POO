import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEncomenda {

    public int scannerInt(String message, Scanner s) {
        try {
            System.out.print(message);
            return s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("!!!Entrada inválida. Por favor, insira um valor inteiro!!!");
            s.nextLine();
            return scannerInt(message, s);
        }
    }
    
    public double scannerDouble(String message, Scanner s) {
        try {
            System.out.print(message);
            return s.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("\n!!!Entrada inválida. Por favor, insira um valor inteiro ou double!!!\n");
            s.nextLine();
            return scannerDouble(message, s); 
        }
    }
    
    public String scannerString(String message, Scanner s) {
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

    public int Menu() throws IllegalArgumentException {
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
        int opcaoEscolhida = scanner.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 6) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 6\n");
        }
        return opcaoEscolhida;
    }

    public void avisos(int a){
        StringBuilder sb = new StringBuilder();
        if (a==1) sb.append("\n!!!!ARTIGO INDISPONÍVEL!!!").append("\n");
        if (a==2) sb.append("\n!!!!ARTIGO NÃO EXISTE NA SUA ENCOMENDA!!!").append("\n");
        if (a==3) sb.append("\n!!!!NÃO É POSSÍVEL DEVOLVER A SUA ENCOMENDA!!!").append("\n");
        if (a==4) sb.append("\n!!!!NÃO É POSSÍVEL CANCELAR A SUA ENCOMENDA (SUA ENCOMENDA FOI FINALIZADA TENTE DEVOLVER)!!!").append("\n");
        if (a==5) sb.append("\n!!!!NÃO É POSSÍVEL FINALIZAR A SUA ENCOMENDA (SEM ARTIGOS)!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
