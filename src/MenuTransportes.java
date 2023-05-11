import java.util.Scanner;

public class MenuTransportes{
    private InterfaceTransportes inter;

    public void setInterface(InterfaceTransportes inter){
        this.inter = inter;
    }

    public double scannerDouble(String message, Scanner s){
        System.out.print(message);
        return s.nextDouble();
    }

    public void MenuAlteraValores(int id){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append("Introduza os valores.\n\n");
        System.out.print(sb.toString());

        double peq = scannerDouble("Preço Base para encomenda pequena: ", scanner);
        double med = scannerDouble("Preço Base para encomenda média: ", scanner);
        double gra = scannerDouble("Preço Base para encomenda grande: ", scanner);
        double margem = scannerDouble("Margem de lucro em %: ", scanner);
        inter.novoValores(peq, med, gra, margem, id);
    }
    
    public int MenuTransportes(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU TRANSPORTE----------\n\n");
        sb.append("1 -> Deseja alterar o valor base para encomendas pequenas?\n");
        sb.append("2 -> Deseja alterar o valor base para encomendas médias?\n");
        sb.append("3 -> Deseja alterar o valor base para encomendas grandes?\n");
        sb.append("4 -> Deseja alterar o valor da margem de Lucro?\n");
        sb.append("5 -> Deseja alterar todos valores?\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Double MenuAlteraValor(int i){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append("Introduza os valores.\n\n");
        System.out.print(sb.toString());
        double v = 0;
        if (i==1) v = scannerDouble("Preço Base para encomenda pequena: ", scanner);
        if (i==2) v = scannerDouble("Preço Base para encomenda média: ", scanner);
        if (i==3) v = scannerDouble("Preço Base para encomenda grande: ", scanner);
        if (i==4) v = scannerDouble("Margem de lucro em %: ", scanner);
        return v;
    }
}
