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
        String cod = scannerString("Digite o Código alfanomérico do artigo que quer comprar: ", scanner);
        return cod;
    }

    public int MenuEncomenda(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU VENDAS-----------\n\n");
        sb.append("1 -> Deseja adicionar um artigo há encomenda?\n");
        sb.append("2 -> Deseja finalizar a encomenda?\n");
        sb.append("3 -> Deseja devolver a encomenda?\n");
        sb.append("4 -> Deseja voltar atrás?\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
