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
                    if(opcao == 1 || opcao == 2) menu.MenuArtigoMalas(vintage.getIdUtilizador(email), opcao);
                //inserir dados dos artigos a vender
                //mostrar transportadoras 
                //escolher uma transportadora para transportar o artigo
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
    public void addArtigoMalaPadrao(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material){
        vintage.addArtigoMalaPadrao(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material);
    }

    public void addArtigoMalaPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material, double valorizacao){
        vintage.addArtigoMalaPremium(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material, valorizacao);
    }
}
