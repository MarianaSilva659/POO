public class ControladorUtilizador {
    public static void run(Utilizador utilizador){
        
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 1 || opcaoEscolhida > 2){
                opcaoEscolhida = Menu.MenuUtilizador();
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

            }
        }
    }
    
}
