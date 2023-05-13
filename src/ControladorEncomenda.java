public class ControladorEncomenda implements InterfaceEncomendas{
    private MenuUtilizador menu;
    private MenuEncomenda menuE;
    private Vintage vintage;
    private ControladorUtilizador controladorUtilizador;

    public ControladorEncomenda(Vintage vintage, ControladorUtilizador controlador){
        this.vintage = vintage;
        this.menu = new MenuUtilizador();
        this.menuE.setInterface(this);
        this.controladorUtilizador = controlador;
        this.menuE = new MenuEncomenda();
    }

    public void run(Vintage vintage, int id){
        while(true){
            int opcao = menuE.MenuEncomenda();

            switch(opcao){
                case 1:
                    vintage.mostraTodosArtigos();
                    String artigo = menuE.MenuEscolheArtigo();
                    vintage.addArtigoEncomenda(artigo, id);
                break;
                case 2:

                break;
                case 3:
                break;
                case 4:
                    controladorUtilizador.run(vintage, vintage.getEmailById(id));
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;
            }
        }
    }
}
