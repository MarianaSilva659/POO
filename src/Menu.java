
import java.util.Scanner;

public class Menu {
    public static int MenuInicial(){
        StringBuilder str = new StringBuilder("          Seja bem vindo á Vintege\n\n");
        
        str.append("1 -> Iniciar sessão\n");
        str.append("2 -> Registar nova conta\n");
        str.append("0 -> Sair\n\n");

        str.append("Selecione um número para prosseguir: ");

        System.out.println(str.toString());
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
