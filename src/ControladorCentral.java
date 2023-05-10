
public class ControladorCentral implements Interface{

    private Menu menu;
    private Vintage vintage;
    private ControladorTransporte cT;
    
    public ControladorCentral(){
        this.menu = new Menu();
        this.menu.setInterface(this);
        this.vintage = new Vintage();
        this.cT = new ControladorTransporte();
    }

    public void correrPrograma(){
        Vintage vintage = new Vintage();
        
        boolean errorMessage = false;
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 4){
                opcaoEscolhida = menu.MenuInicial();
            }
            switch(opcaoEscolhida){

                case 1:
                    String email = menu.MenuLoginUtilizador(errorMessage);
                    
                    if(vintage.existeContaU(email) == false) menu.avisos(1);
                  //  else ControladorUtilizador.run(vintage);
                break;
                case 2:
                    if(menu.MenuNovoRegisto() == false) menu.avisos(2);
                    else{
                        System.out.println("Foi resgistado com sucesso\n");
                     //   ControladorUtilizador.run(vintage);
                    }
                break;
                case 3:
                    int id = menu.MenuLoginTransportadora(errorMessage);
                    if(vintage.existeContaT(id) == false) menu.avisos(3);    
                   // else ControladorTransporte.run(vintage, id);
                break;
                case 4:
                    if(menu.MenuNovoRegistoTransportadora() == false) menu.avisos(4);
                    else{
                        System.out.println("Foi resgistado com sucesso\n");
                      //  ControladorTransporte.run(vintage, 1);
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
    public boolean novoUtilizador(String email, String nome, String morada, int nif){
       // Vintage vintage  = new Vintage();
        return vintage.addContaVintage(email, nome, morada, nif);
    }

    public boolean novoTransporte(double peq, double med, double gra, int margem, boolean aceitaPremium, int id){
        //Vintage vintage = new Vintage();
        return vintage.addTransporteVintage(peq, med, gra, margem, aceitaPremium, id);
    }
}

