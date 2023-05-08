
public class ControladorCentral {
    public static void correrPrograma(){
        GestorUtilizadores conta = new GestorUtilizadores();
        boolean errorMessage = false;
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 2){
                opcaoEscolhida = Menu.MenuInicial();
            }
            switch(opcaoEscolhida){

                case 1:
                    String email = Menu.MenuLoginUtilizador(errorMessage);
                    
                    if(conta.existeConta(email) != false) Menu.avisos(1);
                    else{
                        ControladorUtilizador.run(conta.getContaByEmail(email));
                    }
                    break;

                case 2:
                    Utilizador utilizador = Menu.MenuNovoRegisto(1000); //no 1000 fica o novo id
                    System.out.println("\nFoi resgistado com sucesso\n");
                    //temos de mandar o novo utilizador para o sistema!
                    ControladorUtilizador.run(utilizador);
                    break;
                case 3:

                    break;

                case 4:
                
                    break;
                case 0:
                    System.out.println("Execução interrompida");
                    System.exit(0);
                    break;
                default: 
                    break;
            }
        }
    }
}

