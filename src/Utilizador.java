import java.util.Set;
import java.util.Objects;
import java.util.HashSet;
public class Utilizador{
    private int id;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private Set<String> artigos_comprados;
    private Set<String> artigos_vendidos;
    private Set<String> artigos_para_venda;
    private double dinheiro_faturado;
    private Encomenda encomenda;

    public Utilizador(){
        this.id = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = 0;
        this.artigos_comprados = new HashSet<>();
        this.artigos_vendidos = new HashSet<>();
        this.artigos_para_venda = new HashSet<>();
        this.dinheiro_faturado = 0;
        this.encomenda = new Encomenda(this.id);
    }

    public Utilizador(int id, String email, String nome, String morada, int nif, Set<String> compras, Set<String> vendidas, Set<String> pra_venda, double dinheiro) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.artigos_comprados = compras;
        this.artigos_vendidos = vendidas;
        this.artigos_para_venda = pra_venda;
        this.dinheiro_faturado = 0;
        this.encomenda = new Encomenda(this.id);
    }
    public Utilizador(int id, String email, String nome, String morada, int nif) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.artigos_comprados = new HashSet<>();
        this.artigos_vendidos = new HashSet<>();
        this.artigos_para_venda = new HashSet<>();
        this.dinheiro_faturado = 0;
        this.encomenda = new Encomenda(id);
    }

    public Utilizador(Utilizador u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nif = u.getNif();
        this.artigos_comprados = u.getArtigos_comprados();
        this.artigos_vendidos = u.getArtigos_vendidos();
        this.artigos_para_venda = u.getArtigos_para_venda();
        this.dinheiro_faturado = u.getDinheiro_faturado();
        this.encomenda  = u.getEncomenda();
    }

    public double getDinheiro_faturado() {
        return this.dinheiro_faturado;
    }

    public void setDinheiro_faturado(double dinheiro_faturado) {
        this.dinheiro_faturado = dinheiro_faturado;
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

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
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

    public Set<String> getArtigos_para_venda() {
        return this.artigos_para_venda;
    }

    public void setArtigos_para_venda(Set<String> artigos_para_venda) {
        this.artigos_para_venda = artigos_para_venda;
    }

    public Encomenda getEncomenda() {
        return this.encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
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
            && this.nif == that.getNif()
            && this.artigos_comprados.equals(that.getArtigos_comprados()) 
            && this.artigos_vendidos.equals(that.getArtigos_vendidos()) 
            && this.artigos_para_venda.equals(that.getArtigos_para_venda());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getEmail(), getNome(), getMorada(), getNif(), getArtigos_comprados(), getArtigos_vendidos(), getArtigos_para_venda(), getDinheiro_faturado(), getEncomenda());
    }


    @Override
    public String toString() {
        return "\n{" +
            " NOME='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", id='" + getId() + "'" +
            ", morada='" + getMorada() + "'" +
            ", nif='" + getNif() + "'" +
            ", artigos_comprados='" + getArtigos_comprados() + "'" +
            ", artigos_vendidos='" + getArtigos_vendidos() + "'" +
            ", artigos_para_venda='" + getArtigos_para_venda() + "'" +
            "}";
    }

    private void updatePreço(double preço){
        double dinheiro = getDinheiro_faturado();
        setDinheiro_faturado(dinheiro + preço);
    }


    public Utilizador clone(){
        return new Utilizador(this);
    }

    public boolean verificaId(int id_utilizador){
        return (this.id == id_utilizador);
    }

    public void addArtigoCompra(String cod){
        this.artigos_comprados.add(cod);
    }

    public void addArtigoVendidos(String cod){
        this.artigos_vendidos.add(cod);
    }

    public void addArtigoParaVenda(String cod){
        this.artigos_para_venda.add(cod);
    }

    public void finalização_de_encomenda(double preço, String artigo_id){
        updatePreço(preço);
        artigos_para_venda.remove(artigo_id);
        artigos_vendidos.
        add(artigo_id);
    }

    public void devolverArtigoVendedor(String artigo){
        artigos_vendidos.remove(artigo);
        artigos_para_venda.add(artigo);
    }

    public void devolverArtigoUtilizador(String artigo){
        artigos_comprados.remove(artigo);
    }

    public void removeArtigoFromComprados(String artigo){
        artigos_comprados.remove(artigo);
    }
    
}
