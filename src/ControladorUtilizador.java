public class ControladorUtilizador implements InterfaceUtilizadores{
    private MenuUtilizador menu;
    private Vintage vintage;

    public ControladorUtilizador(Vintage vintage){
        this.vintage = vintage;
        this.menu = new MenuUtilizador();
        this.menu.setInterface(this);
    }
    
    public void run(Vintage vintage, String email){
        
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 2){
                opcaoEscolhida = menu.MenuUtilizador();
            }
            switch(opcaoEscolhida){
                case 1:
                //comprar
                break;
                case 2:
                    int opcao = menu.MenuTipoDoArtigo();
                    vintage.mostraTransportes();
                    if(opcao == 1 || opcao == 2){
                         if(menu.MenuArtigoMalas(vintage.getIdUtilizador(email), opcao)){

                        }
                    }
                    else if(opcao == 3 || opcao == 4) menu.MenuArtigoSapatilhas(vintage.getIdUtilizador(email), opcao);
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
}
