import java.util.InputMismatchException;

public class ControladorEncomenda{
    private MenuUtilizador menu;
    private MenuEncomenda menuE;
    private Vintage vintage;
    private ControladorUtilizador controladorUtilizador;

    public ControladorEncomenda(Vintage vintage, ControladorUtilizador controlador){
        this.vintage = vintage;
        this.menu = new MenuUtilizador();
        this.menuE = new MenuEncomenda();
        this.controladorUtilizador = controlador;
    }

    public void run(Vintage vintage, int id){
        while(true){
            int opcao = -1;
            do{
                try {
                    opcao = menuE.MenuEncomenda();
                }catch (InputMismatchException e) {
                    System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (opcao < 0 || opcao > 6);

            switch(opcao){
                case 1:
                    vintage.mostraTodosArtigos();
                    String artigo = menuE.MenuEscolheArtigo();
                    if(vintage.addArtigoEncomenda(artigo, id) == false) menuE.avisos(1);
                break;
                case 2:
                    vintage.mostraEncomenda(id);
                    String cod = menuE.MenuEscolheArtigo();
                    if(vintage.cancelaArtigoEnc(id, cod) == false) menuE.avisos(2);
                break;
                case 3: 
                    if(vintage.cancelarEncomenda(id) == false) menuE.avisos(4);
                break;
                case 4://devolver encomenda
                   if(vintage.devolverEncomenda(id) == false) menuE.avisos(3);          
                break;
                case 5: 
                    if(vintage.finalizaEnc(id) == false) menuE.avisos(5);
                break;
                case 6:
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
