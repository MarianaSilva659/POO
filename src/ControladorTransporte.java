public class ControladorTransporte {
    public static void run(Vintage vintage, int id){
        
        while(true){
            int opcaoEscolhida = -1;
            while(opcaoEscolhida < 0 || opcaoEscolhida > 3){
                opcaoEscolhida = Menu.MenuTransportes();
            }
            switch(opcaoEscolhida){
                case 1:
                    Menu.MenuAlteraValores(id);
                break;
                case 2:
                    vintage.novoValorPEQ(Menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 3:
                    vintage.novoValorMED(Menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 4:
                    vintage.novoValorGRA(Menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 5:
                    vintage.novaMargemLucro(Menu.MenuAlteraValor(opcaoEscolhida), id);
                break;
                case 6:
                    ControladorCentral.correrPrograma();
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
    public static void novoValores(double peq, double med, double gra, double margem, int id){
       Vintage vintage = new Vintage();
        vintage.novoValoresTransporte(peq, med, gra, margem, id);
    }
}
