import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Interface inter;

    public void setInterface(Interface inter){
        this.inter = inter;
    }

    public  int MenuInicial() throws IllegalArgumentException{
        StringBuilder str = new StringBuilder("          Seja bem vindo á Vintege\n\n");
        
        str.append("1 -> Iniciar sessão como Utilizador\n");
        str.append("2 -> Registar nova conta como Utilizador\n");
        str.append("3 -> Iniciar sessão para Transportadora\n");
        str.append("4 -> Registar nova conta para Transportadora\n");
        str.append("5 -> Qual o Vendedor que mais faturou?\n");
        str.append("6 -> Qual a Transportadora com maior volume de faturação?\n");
        str.append("7 -> Maiores compradores do sistema num período\n");
        str.append("8 -> Maiores vendedores do sistema num período\n");
        str.append("9 -> Quanto dinheiro ganhou a Vintage\n");
        str.append("10 -> Atualizar para a última versão guardada\n");
        str.append("11 -> Gravar versão\n");
        str.append("12 -> Avançar dias\n");
        str.append("0 -> Sair\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 12) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 12\n");
        }
        return opcaoEscolhida;
    }

    public int scannerInt(String message, Scanner s) {
        try {
            System.out.print(message);
            return s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n!!!Entrada inválida. Por favor, insira um valor inteiro!!!\n");
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

    public boolean scannerBoolean(String message, Scanner s) {
        try {
            System.out.print(message);
            return s.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("\n!!!Entrada inválida. Por favor, insira 'true' ou 'false'!!!");
            s.nextLine();
            return scannerBoolean(message, s); 
        }
    }
    
    public String scannerString(String message, Scanner s) {
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

    public int dias(){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        sb.append("Insira os seus dados.\n\n");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        int dias = scannerInt("Dias a avançar(int): ", scanner);
        return dias;
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
        boolean aceita = scannerBoolean("Aceita encomendas Premium (true/false): ", scanner);
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
        if (a==7) sb.append("!!!\nAinda não existem vendedores no sistema!!!").append("\n");
        if (a==8) sb.append("!!!\nAinda não existem transportaras no sistema!!!").append("\n");
        if (a==9) sb.append("!!!\nAinda não existem compradores no sistema!!!").append("\n");
        if (a==10) sb.append("!!!\nAinda não existem vendedores no sistema!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public LocalDate[] MenuVendedorFaturou() {
        StringBuilder str = new StringBuilder("------------VENDEDOR QUE MAIS FATUROU--------------\n\n");
    
        str.append("1 -> Vendedor que mais faturou desde sempre\n");
        str.append("2 -> Vendedor que mais faturou num período\n");
        System.out.print(str.toString());
    
        Scanner input = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 1 && opcao != 2) {
            try {
                opcao = scannerInt("\nSelecione um número para prosseguir: ", input);
                if (opcao != 1 && opcao != 2) {
                    System.out.println("\n!!!Opção inválida. Por favor, selecione 1 ou 2!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n!!!Opção inválida. Por favor, selecione 1 ou 2!!!\n");
            }
        }
        if (opcao == 1) return new LocalDate[] { null, null };
        else if (opcao == 2) {
            return obterDatas();
        }
        return null;
    }

    public LocalDate[] obterDatas() {
        LocalDate[] datas = new LocalDate[2];
        boolean validDates = false;
    
        Scanner input = new Scanner(System.in);
    
        while (!validDates) {
            try {
                String startDateString = scannerString("Insira a data de início (yyyy-MM-dd): ", input);
                String endDateString = scannerString("Insira a data de término (yyyy-MM-dd): ", input);
                datas[0] = LocalDate.parse(startDateString);
                datas[1] = LocalDate.parse(endDateString);
                validDates = true;
            } catch (DateTimeParseException e) {
                System.out.println("\n!!!Datas inválidas. Insira as datas no formato correto (yyyy-MM-dd)!!!\n");
            }
        }
        return datas;
    }


}


