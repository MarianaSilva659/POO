public class ControladorCentral {
    public static void correrPrograma(){
        while(true){
            int opcaoEscolhida;
//while(opcaoEscolhida < 0 || opcaoEscolhida > 3){
                opcaoEscolhida = Menu.MenuInicial();
                
        

            switch(opcaoEscolhida){

                case 1:
                //pedir o email e password já com conta
                    break;

                case 2:
                //criar conta pedir email e password
                    break;

                case 0:
                    System.out.println("Execução interrompida");
                    System.exit(0);
                    break;
                default: 
                    System.out.println("Inseriu um número incorreto. Vintege exit");
                    break;
            }
        }
    }
}
