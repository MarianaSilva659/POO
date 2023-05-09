
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static int MenuInicial(){
        int opcao;
        StringBuilder str = new StringBuilder("          Seja bem vindo á Vintege\n\n");
        
        str.append("1 -> Iniciar sessão como Utilizador\n");
        str.append("2 -> Registar nova conta como Utilizador\n");
        str.append("3 -> Iniciar sessão para Transportadora\n");
        str.append("4 -> Registar nova conta para Transportadora\n");
        str.append("0 -> Sair\n\n");

        str.append("Selecione um número para prosseguir: ");

        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        opcao = input.nextInt();
        
        return opcao;
    }

    public static String MenuLoginUtilizador(boolean errorMessage){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        if(errorMessage) sb.append("Erro - Dados inválidos! Tente novamente!\n\n");
        sb.append("Insira os seus dados.\n\n");
        sb.append("Endereço de e-mail: ");
        System.out.print(sb.toString());
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
       
        return email;
    }

    public static int MenuUtilizador(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU UTILIZADOR-----------\n\n");
        sb.append("1 -> Deseja comprar\n");
        sb.append("2 > Deseja vender\n");
        sb.append("3 -> Voltar ao Menu Principal\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static boolean MenuNovoRegisto(){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("\n\n\n------------REGISTAR UTLIZADOR---------\n\n");
        sb.append("Introduza os seguintes dados.\n\n");
        sb.append("Nome: ");
        System.out.print(sb.toString());
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Morada: ");
        String morada = scanner.nextLine();
        System.out.print("NIF: ");
        int nif = scanner.nextInt();
        return ControladorCentral.novoUtilizador(email, nome, morada, nif);
    }

    public static Transportadora MenuNovoRegistoTransportadora(){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("\n\n\n------------REGISTAR UTLIZADOR---------\n\n");
        sb.append("Introduza os seguintes dados.\n\n");

        sb.append("Identificador(inteiro): ");
        System.out.print(sb.toString());
        int id = scanner.nextInt();
        System.out.print("Preço Base para encomenda pequena: ");
        double peq = scanner.nextDouble();
        System.out.print("Preço Base para encomenda média: ");
        double med = scanner.nextDouble();
        System.out.print("Preço Base para encomenda grande: ");
        double gra = scanner.nextDouble();
        System.out.print("Margem de lucro em %: ");
        int margem = scanner.nextInt();
        System.out.print("Aceita encomendas Premium: ");
        String valor = scanner.nextLine();
        boolean aceita = Boolean.parseBoolean(valor);
        return new Transportadora(peq, med, gra, margem, aceita, id);
    }

    public static void MostraTodosArtigos(){
        System.out.println("Artigos para venda: ");
    }

    public static Malas menuArtigoNovo(int id_utilizador){
        StringBuilder sb = new StringBuilder("\n\n\n-----------NOVO ARTIGO-----------\n\n");
        sb.append("Insira os dados. n\n");
        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        sb.append("Avaliação: ");
        double avaliacao = scanner.nextDouble();
        sb.append("Número de Donos: ");
        int donos = scanner.nextInt();
        sb.append("Descrição: ");
        String descricao = scanner.nextLine();
        sb.append("Marca: ");
        String marca = scanner.nextLine();
        sb.append("Código Alfanumérico: ");
        String cod = scanner.nextLine();
        sb.append("Preço Base: ");
        double preco = scanner.nextDouble();
        sb.append("Desconto em %: ");
        double desconto = scanner.nextDouble();
        sb.append("Identificador do Transporte: ");
        return new Malas(donos, descricao, marca, cod, preco, desconto, avaliacao,id_utilizador, 10, null, 1.1, 1.1, 1.1, null);
    }

    public static void avisos(int a){
        StringBuilder sb = new StringBuilder();
        System.out.println("aqui\n");
        if (a==1) sb.append("!!!Email Inválido!!!").append("\n");
        if (a==2) sb.append("!!!Email já existe!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}


