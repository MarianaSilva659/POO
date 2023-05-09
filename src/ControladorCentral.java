
public class ControladorCentral {
    public static void correrPrograma(){
        Vintage vintage = new Vintage();
        
        boolean errorMessage = false;
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 4){
                opcaoEscolhida = Menu.MenuInicial();
            }
            switch(opcaoEscolhida){

                case 1:
                    String email = Menu.MenuLoginUtilizador(errorMessage);
                    
                    if(vintage.existeContaU(email) == false) Menu.avisos(1);
                    else ControladorUtilizador.run(vintage);
                break;
                case 2:
                    if(Menu.MenuNovoRegisto() == false) Menu.avisos(2);
                    else{
                        System.out.println("Foi resgistado com sucesso\n");
                        ControladorUtilizador.run(vintage);
                    }
                break;
                case 3:
                    int id = Menu.MenuLoginTransportadora(errorMessage);
                    if(vintage.existeContaT(id) == false) Menu.avisos(3);    
                    else ControladorTransporte.run(vintage, id);
                break;
                case 4:
                    if(Menu.MenuNovoRegistoTransportadora() == false) Menu.avisos(4);
                    else{
                        System.out.println("Foi resgistado com sucesso\n");
                        Menu.MenuInicial();
                    }
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

    public static boolean novoTransporte(double peq, double med, double gra, int margem, boolean aceitaPremium, int id){
        Vintage vintage = new Vintage();
        return vintage.addTransporteVintage(peq, med, gra, margem, aceitaPremium, id);
    }
}

