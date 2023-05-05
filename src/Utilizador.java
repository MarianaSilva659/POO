import java.util.Set;
import java.util.Objects;
import java.util.TreeSet;
public class Utilizador{
    private int id;
    private String email;
    private String nome;
    private String morada;
    private String nif;
    private Set<String> artigos_comprados;
    private Set<String> artigos_vendidos;
    private Set<String> artigos_pra_venda;

    public Utilizador(){
        this.id = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = "";
        this.artigos_comprados = new TreeSet<>();
        this.artigos_vendidos = new TreeSet<>();
        this.artigos_pra_venda = new TreeSet<>();
    }

    public Utilizador(int id, String email, String nome, String morada, String nif, Set<String> compras, Set<String> vendidas, Set<String> pra_venda) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.artigos_comprados = compras;
        this.artigos_vendidos = vendidas;
        this.artigos_pra_venda = pra_venda;
    }
    public Utilizador(int id, String email, String nome, String morada, String nif) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.artigos_comprados = new TreeSet<>();
        this.artigos_vendidos = new TreeSet<>();
        this.artigos_pra_venda = new TreeSet<>();
    }
    public Utilizador(Utilizador u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nif = u.getNif();
        this.artigos_comprados = u.getArtigos_comprados();
        this.artigos_vendidos = u.getArtigos_vendidos();
        this.artigos_pra_venda = u.getArtigos_pra_venda();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Set<String> getArtigos_comprados() {
        return this.artigos_vendidos;
    }

    public void setArtigos_comprados(Set<String> artigos_comprasdos) {
        this.artigos_comprados = artigos_comprasdos;
    }

    public Set<String> getArtigos_vendidos() {
        return this.artigos_vendidos;
    }

    public void setArtigos_vendidos(Set<String> artigos_vendidos) {
        this.artigos_vendidos = artigos_vendidos;
    }

    public Set<String> getArtigos_pra_venda() {
        return this.artigos_pra_venda;
    }

    public void setArtigos_pra_venda(Set<String> artigos_pra_venda) {
        this.artigos_pra_venda = artigos_pra_venda;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Utilizador that = (Utilizador) object;
        return this.id == that.getId()
            && this.email.equals(that.getEmail()) 
            && this.nome.equals(that.getNome()) 
            && this.morada.equals(that.getMorada()) 
            && this.nif.equals(that.getNif()) 
            && this.artigos_comprados.equals(that.getArtigos_comprados()) 
            && this.artigos_vendidos.equals(that.getArtigos_vendidos()) 
            && this.artigos_pra_venda.equals(that.getArtigos_pra_venda());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getEmail(), getNome(), getMorada(), getNif(), getArtigos_comprados(), getArtigos_vendidos(), getArtigos_pra_venda());
    }

    public Utilizador clone(){
        return new Utilizador();
    }
}
