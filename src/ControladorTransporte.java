public class ControladorTransporte implements InterfaceTransportes{
    
    private MenuTransportes menu;
    private Vintage vintage;

    public ControladorTransporte(Vintage vintage){
        this.menu = new MenuTransportes();
        this.vintage = vintage;
        this.menu.setInterface(this);
    }

    public void run(Vintage vintage, int id){
        
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 5){
                opcaoEscolhida = menu.MenuTransportes();
            }
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
