
public class ControladorCentral implements Interface{

    private Menu menu;
    private Vintage vintage;
    private ControladorTransporte cT;
    private ControladorUtilizador cU;
    
    public ControladorCentral(){
        this.menu = new Menu();
        this.menu.setInterface(this);
        this.vintage = new Vintage();
        this.cT = new ControladorTransporte(vintage);
        this.cU = new ControladorUtilizador(vintage);
    }

    public void correrPrograma(){        
        boolean errorMessage = false;
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 4){
                opcaoEscolhida = menu.MenuInicial();
            }
            switch(opcaoEscolhida){

                case 1:
                    String emailI = menu.MenuLoginUtilizador(errorMessage);
                    if(vintage.existeContaU(emailI) == false) menu.avisos(1);
                    else cU.run(vintage, emailI);
                break;
                case 2:
                    String emailR = menu.MenuNovoRegisto();
                    if(vintage.existeContaU(emailR) == false) menu.avisos(2);
                    else{
                        System.out.println("Foi resgistado com sucesso\n");
                        correrPrograma();
                      //  cU.run(vintage, emailR);
                    }
                break;
                case 3:
                    int identificadorI = menu.MenuLoginTransportadora(errorMessage);
                    if(vintage.existeContaT(identificadorI) == true) menu.avisos(3);    
                    else cT.run(vintage, identificadorI);
                break;
                case 4:
                    int identificadorR = menu.MenuNovoRegistoTransportadora();
                    if(identificadorR < 0) menu.avisos(4);
                    else{
                        System.out.println("Foi resgistado com sucesso\n");
                        correrPrograma();
                       // cT.run(vintage, identificadorR);
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

    public String novoUtilizador(String email, String nome, String morada, int nif){
        return vintage.addContaVintage(email, nome, morada, nif);
    }

    public int novoTransporte(double peq, double med, double gra, int margem, boolean aceitaPremium, int id){
        return vintage.addTransporteVintage(peq, med, gra, margem, aceitaPremium, id);
    }
}

