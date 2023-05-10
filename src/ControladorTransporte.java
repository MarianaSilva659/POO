public class ControladorTransporte{
    private Menu menu;
    public void run(Vintage vintage, int id){
        
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 3){
                opcaoEscolhida = menu.MenuTransportes();
            }
            switch(opcaoEscolhida){
                case 1:
                    menu.MenuAlteraValores(id);
                break;
                case 2:
                    vintage.novoValorPEQ(menu.MenuAlteraValor(opcaoEscolhida), id);
                    //menu.MenuNovoRegistoTransportadora();
                break;
                case 3:
                    vintage.novoValorMED(menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 4:
                    vintage.novoValorGRA(menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 5:
                    vintage.novaMargemLucro(menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 6:
                   // ControladorCentral.correrPrograma();
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
    public void novoValores(double peq, double med, double gra, double margem, int id){
       Vintage vintage = new Vintage();
        vintage.novoValoresTransporte(peq, med, gra, margem, id);
    }
}
