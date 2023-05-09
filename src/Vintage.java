
public class Vintage {
    private GestorArtigos artigos;
    private GestorUtilizadores utilizadores;
    private GestorTransportes transportes;


    public Vintage() {
        this.artigos = new GestorArtigos();
        this.utilizadores = new GestorUtilizadores();
        this.transportes = new GestorTransportes();
    }

    public Vintage(Vintage v){
        this.artigos = v.artigos;
        this.utilizadores = v.utilizadores;
        this.transportes = v.transportes;
    }

    public boolean existeConta(String email){
        return this.utilizadores.existeConta(email);
    }

    public boolean addContaVintage(String email, String nome, String morada, int nif){
        int id = this.utilizadores.getIdNewUtilizador();
        System.out.println("id " + id);
        Utilizador novo = new Utilizador(id, email, nome, morada, nif);
        if(this.utilizadores.existeConta(email) == false){
            this.utilizadores.addConta(novo);
            System.out.println(utilizadores);
            return true;
        }
        else return false;
    }
}
