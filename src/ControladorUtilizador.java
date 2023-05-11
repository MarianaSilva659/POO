public class ControladorUtilizador {
    private MenuUtilizador menu;
    private Vintage vintage;

    public ControladorUtilizador(Vintage vintage){
        this.vintage = vintage;
        this.menu = new MenuUtilizador();
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
    
}
