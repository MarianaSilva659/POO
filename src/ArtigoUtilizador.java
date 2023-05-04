public class ArtigoUtilizador {
    private Artigo artigo;
    private String id_utilizador;

    public ArtigoUtilizador(Artigo artigo, String id_utilizador) {
        this.artigo = artigo;
        this.id_utilizador = id_utilizador;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public String getIdUtilizador() {
        return id_utilizador;
    }
}
