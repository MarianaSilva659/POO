public class ControladorEncomenda {
    private MenuUtilizador menu;
    private Vintage vintage;
    private ControladorUtilizador controladorUtilizador;

    public ControladorEncomenda(Vintage vintage, ControladorUtilizador controlador){
        this.vintage = vintage;
        this.menu = new MenuUtilizador();
       // this.menu.setInterface(this);
        this.controladorUtilizador = controlador;
    }

    public void run(Vintage vintage, int id){
        while(true){
            int opcao = menu.MenuEncomenda();

            switch(opcao){
                case 1:
                    vintage.mostraTodosArtigos();
                    String artigo = menu.MenuEscolheArtigo();
                    vintage.addArtigoEncomenda(artigo);
                break;
                case 2: //finalizar a encomenda
                break;
                case 3:
                    controladorUtilizador.run(vintage, vintage.getEmailById(id));
                break;
                case 0:
                break;
            }
        }
    }
}
