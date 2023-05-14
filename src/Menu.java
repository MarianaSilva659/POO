import java.util.Scanner;

public class Menu {
    private Interface inter;

    public void setInterface(Interface inter){
        this.inter = inter;
    }

    public  int MenuInicial() throws IllegalArgumentException{
        int opcao;
        StringBuilder str = new StringBuilder("          Seja bem vindo á Vintege\n\n");
        
        str.append("1 -> Iniciar sessão como Utilizador\n");
        str.append("2 -> Registar nova conta como Utilizador\n");
        str.append("3 -> Iniciar sessão para Transportadora\n");
        str.append("4 -> Registar nova conta para Transportadora\n");
        str.append("5 -> Qual o Vendedor que mais faturou?\n");
        str.append("6 -> Qual a Transportadora com maior volume de faturação?\n");
        str.append("7 -> Maiores compradores do sistema\n");
        str.append("8 -> Maiores vendedores do sistema\n");
        str.append("9 -> Quanto dinheiro ganou a Vintage\n");
        str.append("10 -> Atualizar para a última versão guardada\n");
        str.append("11 -> Gravar versão\n");
        str.append("0 -> Sair\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        opcao = input.nextInt();
        return opcao;
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

    public String MenuLoginUtilizador(boolean errorMessage){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        if(errorMessage) sb.append("Erro - Dados inválidos! Tente novamente!\n\n");
        sb.append("Insira os seus dados.\n\n");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        String email = scannerString("Endereço de e-mail: ", scanner);
        return email;
    }

    public String MenuNovoRegisto(){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("\n\n\n------------REGISTAR UTLIZADOR---------\n\n");
        sb.append("Introduza os seguintes dados.\n\n");
        System.out.print(sb.toString());
        String nome = scannerString("Nome: ", scanner);
        String email = scannerString("E-mail: ", scanner);
        String morada = scannerString("Morada: ", scanner);
        int nif = scannerInt("NIF: ", scanner);
        return inter.novoUtilizador(email, nome, morada, nif);
    }

    public int MenuNovoRegistoTransportadora(){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("\n\n\n------------REGISTAR TRANSPORTE---------\n\n");
        sb.append("Introduza os seguintes dados.\n\n");

        System.out.print(sb.toString());
        int id = scannerInt("Identificador(inteiro): ", scanner);
        double peq = scannerDouble("Preço Base para encomenda pequena: ", scanner);
        double med = scannerDouble("Preço Base para encomenda média: ", scanner);
        double gra = scannerDouble("Preço Base para encomenda grande: ", scanner);
        int margem = scannerInt("Margem de lucro em %: ", scanner);
        System.out.print("Aceita encomendas Premium(true/false): ");
        boolean aceita = scanner.nextBoolean();
        return inter.novoTransporte(peq, med, gra, margem, aceita, id);
    }

    public int MenuLoginTransportadora(boolean errorMessage){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        if(errorMessage) sb.append("Erro - Dados inválidos! Tente novamente!\n\n");
        sb.append("Insira os seus dados.\n\n");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        int id = scannerInt("Identificador: ", scanner);
       
        return id;
    }

    public void avisos(int a){
        StringBuilder sb = new StringBuilder();
        if (a==1) sb.append("!!!Email Inválido!!!").append("\n");
        if (a==2) sb.append("!!!Email já existe!!!").append("\n");
        if (a==3) sb.append("!!!Identificador Inválido!!!").append("\n");
        if (a==4) sb.append("!!!Identificador já existe!!!").append("\n");
        if (a==5) sb.append("!!!Load falhou!!!").append("\n");
        if (a==6) sb.append("!!!Save falhou!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    }


