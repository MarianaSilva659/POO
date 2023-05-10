public class ControladorUtilizador {
    private Menu menu;
    public void run(Vintage vintage){
        
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 3){
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
                case 3:
              //  ControladorCentral.correrPrograma();
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
    
}
