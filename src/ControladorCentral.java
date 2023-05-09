
public class ControladorCentral {
    public static void correrPrograma(){
        Vintage vintage = new Vintage();
        GestorUtilizadores conta = new GestorUtilizadores();
        
        boolean errorMessage = false;
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 4){
                opcaoEscolhida = Menu.MenuInicial();
            }
            switch(opcaoEscolhida){

                case 1:
                    String email = Menu.MenuLoginUtilizador(errorMessage);
                    
                    if(conta.existeConta(email) != false) Menu.avisos(1);
                    else{
                        ControladorUtilizador.run();
                    }
                    break;

                case 2:
                    if(Menu.MenuNovoRegisto() == false) Menu.avisos(2);
                    else{
                        System.out.println("\nFoi resgistado com sucesso\n");
                        ControladorUtilizador.run();

                    }
                    break;
                case 3:
                    
                    break;

                case 4:
                
                    break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                    break;
                default: 
                    break;
            }
        }
    }
    public static boolean novoUtilizador(String email, String nome, String morada, int nif){
        Vintage vintage  = new Vintage();
        return vintage.addContaVintage(email, nome, morada, nif);
    }
}

