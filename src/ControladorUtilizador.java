import java.util.InputMismatchException;

public class ControladorUtilizador implements InterfaceUtilizadores {
    private MenuUtilizador menu;
    private Vintage vintage;
    private ControladorCentral controladorCentral;
    private ControladorEncomenda cE;

    public ControladorUtilizador(Vintage vintage, ControladorCentral controladorCentral){
        this.vintage = vintage;
        this.menu = new MenuUtilizador();
        this.menu.setInterface(this);
        this.controladorCentral = controladorCentral;
        this.cE = new ControladorEncomenda(vintage, this);
    }
    
    public void run(Vintage vintage, String email){
        
        while(true){
            int opcaoEscolhida = -1;
            do{
                try {
                    opcaoEscolhida = menu.Menu();
                }catch (InputMismatchException e) {
                    System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (opcaoEscolhida < 0 || opcaoEscolhida > 5);
            
            
            switch(opcaoEscolhida){
                case 1:
                   cE.run(vintage, vintage.getIdUtilizador(email));
                break;
                case 2:
                    int opcao = -1;
                    do{
                        try {
                            opcao = menu.MenuTipoDoArtigo();
                        }catch (InputMismatchException e) {
                            System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                        }catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (opcao < 0 || opcao > 8);

                    vintage.mostraTransportes(opcao);
                    if((opcao == 1) || (opcao == 2)){
                         if(menu.MenuArtigoMalas(vintage.getIdUtilizador(email), opcao) == false) menu.avisos(2);
                    }
                    else if((opcao == 3) || (opcao == 4)){
                        if(menu.MenuArtigoSapatilhas(vintage.getIdUtilizador(email), opcao) == false) menu.avisos(2);
                    }
                    else if((opcao >= 5) && (opcao <= 8)){
                        if((menu.MenuArtigoTShit(vintage.getIdUtilizador(email), opcao)) == false) menu.avisos(2);
                    }
                break;
                case 3:
                    vintage.mostraTodosArtigos();
                break;
                case 4:
                    vintage.encomendaEmitidasVendedor(vintage.getIdUtilizador(email));
                break;
                case 5:
                    controladorCentral.correrPrograma();
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
    public boolean addMalaPadrao(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material){
        return vintage.addMalaPadrao(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material);
    }

    public boolean addMalaPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material, double valorizacao){
        return vintage.addMalaPremium(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material, valorizacao);
    }

    public boolean addSapatilhasPadrao(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano){
        return vintage.addSapatilhasPadrao(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano);
    }

    public boolean addSapatilhasPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano, String autores){
        return vintage.addSapatilhasPremium(numeroDonos, descricao, marca, id, precoBase, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano, autores);
    }

    public boolean addTShirt(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        return vintage.addTShirt(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
    }

    public boolean addTShirtLisa(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        return vintage.addTShirtLisa(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
    }

    public boolean addTShirtRiscas(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        return vintage.addTShirtRiscas(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
    }

    public boolean addTShirtPalmeiras(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        return vintage.addTShirtPalmeiras(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
    }
}
