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
        str.append("7 -> Maiores compradores do sistema\n");
        str.append("8 -> Maiores vendedores do sistema\n");
        str.append("9 -> Quanto dinheiro ganou a Vintage\n");
        str.append("10 -> Atualizar para a última versão guardada\n");
        str.append("11 -> Gravar versão\n");
        str.append("0 -> Sair\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 11) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 11\n");
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

    public LocalDate[] MenuVendedorFaturou() {
        StringBuilder str = new StringBuilder("------------VENDEDOR QUE MAIS FATUROU--------------\n\n");
    
        str.append("1 -> Vendedor que mais faturou desde sempre\n");
        str.append("2 -> Vendedor que mais faturou num período\n");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcao = scannerInt("Selecione um número para prosseguir: ", input);
        if (opcao < 0 || opcao > 11) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 11\n");
        }
        try {
            if (opcao == 1) {
                return new LocalDate[] { null, null };
            } else if (opcao == 2) {
                LocalDate dataInicio = LocalDate.parse(scannerString("Digite a data de início (AAAA-MM-DD): ", input));
                LocalDate dataFim = LocalDate.parse(scannerString("Digite a data de fim (AAAA-MM-DD): ", input));
                return new LocalDate[] { dataInicio, dataFim };
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Certifique-se de usar o formato AAAA-MM-DD.");
        }
    
        return null;
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


