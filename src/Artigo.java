import java.util.Objects;

public abstract class Artigo{
    private double avaliacao;
    private int numeroDonos;
    private String descricao;
    private String marca;
    private String id_artigo;
    private double precoBase;
    private double desconto;
    private String id_utilizador;

    public  Artigo(){
        this.numeroDonos = 0;
        this.descricao = null;
        this.marca = null;
        this.id_artigo = null;
        this.precoBase = 0;
        this.desconto = 0;
        this.avaliacao = 0;
        this.id_utilizador = null;
    }
    public  Artigo(Artigo a){
        this.numeroDonos = a.getNumeroDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.id_artigo = a.getId();
        this.precoBase = a.getPrecoBase();
        this.desconto = a.getDesconto();
        this.avaliacao = a.getAvaliacao();
        this.id_utilizador = a.getIdUtilizador();
    }
    public Artigo(int numeroDonos, String descricao, String marca, String id_artigo, double precoBase, double desconto, double avaliacao, String id_utilizador){
        this.numeroDonos = numeroDonos;
        this.descricao = descricao;
        this.marca = marca;
        this.id_artigo = id_artigo;
        this.precoBase = precoBase;
        this.desconto = desconto;
        this.avaliacao = avaliacao;
        this.id_utilizador = id_utilizador;
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

    public String getIdUtilizador(){
        return this.id_utilizador;
    }

    public void setIdUtilizador(String id_utilizador){
        this.id_utilizador = id_utilizador;
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
               Double.compare(this.getDesconto(), a.getDesconto()) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getNumeroDonos(), getDescricao(), getMarca(), getId(), getPrecoBase(), getDesconto());
    }

    @Override
    public String toString() {
        return "{" +
            " avaliacao='" + getAvaliacao() + "'" +
            ", numeroDonos='" + getNumeroDonos() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", marca='" + getMarca() + "'" +
            ", id='" + getId() + "'" +
            ", precoBase='" + getPrecoBase() + "'" +
            ", desconto='" + getDesconto() + "'" +
            "}";
    }

    public abstract Artigo clone();

    public abstract double precoartigo();
}

