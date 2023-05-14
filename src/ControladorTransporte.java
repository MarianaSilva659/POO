import java.util.InputMismatchException;

public class ControladorTransporte implements InterfaceTransportes{
    
    private MenuTransportes menu;
    private Vintage vintage;
    private ControladorCentral controladorCentral;

    public ControladorTransporte(Vintage vintage, ControladorCentral controladorCentral){
        this.menu = new MenuTransportes();
        this.vintage = vintage;
        this.menu.setInterface(this);
        this.controladorCentral = controladorCentral;
    }

    public void run(Vintage vintage, int id){
        
        while(true){
            int opcaoEscolhida = -1;
            do{
                try {
                    opcaoEscolhida = menu.MenuTransportes();
                }catch (InputMismatchException e) {
                    System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (opcaoEscolhida < 0 || opcaoEscolhida > 7);
            switch(opcaoEscolhida){
                case 1:
                    vintage.novoValorPEQ(menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 2:
                   vintage.novoValorMED(menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 3:
                    vintage.novoValorGRA(menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 4:
                    vintage.novaMargemLucro(menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 5:
                    menu.MenuAlteraValores(id);
                break;
                case 6:
                    controladorCentral.correrPrograma();
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
    public void novoValores(double peq, double med, double gra, double margem, int id){
        vintage.novoValoresTransporte(peq, med, gra, margem, id);
    }
}
