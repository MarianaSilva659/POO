import java.time.LocalDate;

public class ControladorEncomenda implements InterfaceEncomendas{
    private MenuUtilizador menu;
    private MenuEncomenda menuE;
    private Vintage vintage;
    private ControladorUtilizador controladorUtilizador;

    public ControladorEncomenda(Vintage vintage, ControladorUtilizador controlador){
        this.vintage = vintage;
        this.menu = new MenuUtilizador();
        this.menuE = new MenuEncomenda();
        this.menuE.setInterface(this);
        this.controladorUtilizador = controlador;
    }

    public void run(Vintage vintage, int id){
        while(true){
            int opcao = menuE.MenuEncomenda();

            switch(opcao){
                case 1:
                    vintage.mostraTodosArtigos();
                    String artigo = menuE.MenuEscolheArtigo();
                    if(vintage.addArtigoEncomenda(artigo, id) == false) menu.avisos(3);
                break;
                case 2:
                    vintage.mostraEncomenda(id);
                    String cod = menuE.MenuEscolheArtigo();
                    if(vintage.cancelaArtigoEnc(id, cod) == false) menu.avisos(4);
                break;
                case 3:
                    if(vintage.devolverEncomenda(id) == false) menu.avisos(5);
                break;
                case 4: //finalizar encomenda;
                    LocalDate datacompra = LocalDate.now();
                    
                break;
                case 5:
                    controladorUtilizador.run(vintage, vintage.getEmailById(id));
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;
            }
        }
    }

    public void EncomendaNovoArtigo(int id){
        vintage.mostraTodosArtigos();
        String artigo = menuE.MenuEscolheArtigo();
        if(vintage.addArtigoEncomenda(artigo, id) == false) menu.avisos(3);
    }

   /* public void devolverEncomenda(String cod, int id){
        
    }*/
}
