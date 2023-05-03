import java.util.Objects;

public abstract class Artigo{
    private double avaliacao;
    private int numeroDonos;
    private String descricao;
    private String marca;
    private String id;
    private double precoBase;
    private double desconto;

    public  Artigo(){
        this.numeroDonos = 0;
        this.descricao = null;
        this.marca = null;
        this.id = null;
        this.precoBase = 0;
        this.desconto = 0;
        this.avaliacao = 0;
    }
    public  Artigo(Artigo a){
        this.numeroDonos = a.getNumeroDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.id = a.getId();
        this.precoBase = a.getPrecoBase();
        this.desconto = a.getDesconto();
        this.avaliacao = a.getAvaliacao();
    }
    public Artigo(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao){
        this.numeroDonos = numeroDonos;
        this.descricao = descricao;
        this.marca = marca;
        this.id = id;
        this.precoBase = precoBase;
        this.desconto = desconto;
        this.avaliacao = avaliacao;
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
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

