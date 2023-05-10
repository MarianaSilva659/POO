
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Interface inter;

    public void setInterface(Interface inter){
        this.inter = inter;
    }

    public  int MenuInicial(){
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

    public String MenuLoginUtilizador(boolean errorMessage){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        if(errorMessage) sb.append("Erro - Dados inválidos! Tente novamente!\n\n");
        sb.append("Insira os seus dados.\n\n");
        sb.append("Endereço de e-mail: ");
        System.out.print(sb.toString());
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
       
        return email;
    }

    public int MenuUtilizador(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU UTILIZADOR-----------\n\n");
        sb.append("1 -> Deseja comprar\n");
        sb.append("2 -> Deseja vender\n");
        sb.append("3 -> Voltar ao Menu Principal\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean MenuNovoRegisto(){
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
        return inter.novoUtilizador(email, nome, morada, nif);
    }

    public boolean MenuNovoRegistoTransportadora(){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("\n\n\n------------REGISTAR TRANSPORTE---------\n\n");
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
        System.out.print("Aceita encomendas Premium(true/false): ");
        boolean aceita = scanner.nextBoolean();
        return inter.novoTransporte(peq, med, gra, margem, aceita, id);
    }

    public void MostraTodosArtigos(){
        System.out.println("Artigos para venda: ");
    }

    public Malas MenuArtigoMalas(int id_utilizador){
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
        return new Malas(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, 10, null, 1.1, 1.1, 1.1, null);
    }

    public MalasPremium MenuArtigoMalasP(int id_utilizador){
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
        return new MalasPremium(donos, descricao, marca, cod, preco, desconto, avaliacao, id_utilizador, 10, null, 1.1, 1.1, 1.1, null,0);
    }

    public int MenuLoginTransportadora(boolean errorMessage){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        if(errorMessage) sb.append("Erro - Dados inválidos! Tente novamente!\n\n");
        sb.append("Insira os seus dados.\n\n");
        sb.append("Identificador: ");
        System.out.print(sb.toString());
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
       
        return id;
    }

    public int MenuTransportes(){
        StringBuilder sb = new StringBuilder("\n\n\n-----------MENU TRANSPORTE----------\n\n");
        sb.append("1 -> Deseja alterar todos os valores de cálculo?\n");
        sb.append("2 -> Deseja alterar o valor base para encomendas pequenas?\n");
        sb.append("3 -> Deseja alterar o valor base para encomendas médias?\n");
        sb.append("4 -> Deseja alterar o valor base para encomendas grandes?\n");
        sb.append("5 -> Deseja alterar o valor da margem de Lucro?\n");
        sb.append("6 -> Voltar ao Menu Principal\n");
        sb.append("0 -> Sair\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void MenuAlteraValores(int id){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append("Introduza os valores.\n\n");
        System.out.print(sb.toString());

        System.out.print("Preço Base para encomenda pequena: ");
        double peq = scanner.nextDouble();
        System.out.print("Preço Base para encomenda média: ");
        double med = scanner.nextDouble();
        System.out.print("Preço Base para encomenda grande: ");
        double gra = scanner.nextDouble();
        System.out.print("Margem de lucro em %: ");
        double margem = scanner.nextDouble();
        //this.novoValores(peq, med, gra, margem, id);
        return;
    }

    public Double MenuAlteraValor(int i){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append("Introduza os valores.\n\n");
        System.out.print(sb.toString());
        double v = 0;
        if (i==2){System.out.print("Preço Base para encomenda pequena: ");
        v = scanner.nextDouble();}
        if (i==3){System.out.print("Preço Base para encomenda média: ");
        v = scanner.nextDouble();}
        if (i==4){System.out.print("Preço Base para encomenda grande: ");
        v = scanner.nextDouble();}
        if (i==5){System.out.print("Margem de lucro em %: ");
        v = scanner.nextDouble();}
        return v;
    }

    public void avisos(int a){
        StringBuilder sb = new StringBuilder();
        if (a==1) sb.append("!!!Email Inválido!!!").append("\n");
        if (a==2) sb.append("!!!Email já existe!!!").append("\n");
        if (a==3) sb.append("!!!Identificador Inválido!!!").append("\n");
        if (a==4) sb.append("!!!Identificador já existe!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}


