import java.io.Serializable;
import java.util.Objects;

public abstract class Artigo implements Serializable {
    private double avaliacao;
    private int numeroDonos;
    private String descricao;
    private String marca;
    private String id_artigo;
    private double precoBase;
    private double desconto;
    private int id_utilizador;
    private int id_transporte;

    public  Artigo(){
        this.numeroDonos = 0;
        this.descricao = null;
        this.marca = null;
        this.id_artigo = null;
        this.precoBase = 0;
        this.desconto = 0;
        this.avaliacao = 0;
        this.id_utilizador = 0;
        this.id_transporte = 0;
    }
    public  Artigo(Artigo a){
        this.numeroDonos = a.getNumeroDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.id_artigo = a.getId();
        this.precoBase = a.getPrecoBase();
        this.desconto = a.getDesconto();
        this.avaliacao = a.getAvaliacao();
        this.id_utilizador = a.getId_Utilizador();
        this.id_transporte = a.getId_transporte();
        
    }
    public Artigo(int numeroDonos, String descricao, String marca, String id_artigo, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte){
        this.numeroDonos = numeroDonos;
        this.descricao = descricao;
        this.marca = marca;
        this.id_artigo = id_artigo;
        this.precoBase = precoBase;
        this.desconto = desconto;
        this.avaliacao = avaliacao;
        this.id_utilizador = id_utilizador;
        this.id_transporte = id_transporte;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getNumeroDonos() {
        return this.numeroDonos;
    }

    public void setNumeroDonos(int numeroDonos) {
        this.numeroDonos = numeroDonos;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getId() {
        return this.id_artigo;
    }

    public void setId(String id_artigo) {
        this.id_artigo = id_artigo;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getAvaliacao() {
        return this.avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getId_Utilizador(){
        return this.id_utilizador;
    }

    public void setId_Utilizador(int id_utilizador){
        this.id_utilizador = id_utilizador;
    }

    public int getId_transporte() {
        return this.id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artigo a = (Artigo) o;
        return Double.compare(this.getAvaliacao(), a.getAvaliacao()) == 0 &&
               this.getNumeroDonos() == a.getNumeroDonos() &&
               this.getDescricao().equals(a.getDescricao()) &&
               this.getMarca().equals(a.getMarca()) &&
               this.getId().equals(a.getId()) &&
               Double.compare(this.getPrecoBase(), a.getPrecoBase()) == 0 &&
               Double.compare(this.getDesconto(), a.getDesconto()) == 0 &&
               this.getId_Utilizador() == a.getId_Utilizador() &&
               this.getId_transporte() == a.getId_transporte();
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getAvaliacao(), getNumeroDonos(), getDescricao(), getMarca(), id_artigo, getPrecoBase(), getDesconto(), id_utilizador, getId_transporte());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "\n" +
                " CÓDIGO DO ARTIGO='" + id_artigo + '\'' +
                ", Avaliacao=" + avaliacao +
                ", NumeroDonos=" + numeroDonos +
                ", Descricao='" + descricao + '\'' +
                ", Marca='" + marca + '\'' +
                ", PrecoBase=" + precoBase +
                ", Desconto=" + desconto +
                ", id_utilizador=" + id_utilizador +
                ", id_transporte=" + id_transporte;
    }

    public abstract Artigo clone();

    public abstract double precoartigo();
}

