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
        this.id = a.getID();
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

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public Double getPrecoBase() {
        return this.precoBase;
    }

    public void setPrecoBase(Double precoBase) {
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

        Artigo artigo = (Artigo) o;
        return /*this.numeroDonos.equals(artigo.numeroDonos) &&
                this.precoBase.equals(artigo.precoBase) &&
                this.desconto.equals(artigo.desconto) &&*/
                this.descricao.equals(artigo.descricao) &&
                this.marca.equals(artigo.marca) &&
                this.id.equals(artigo.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getNumeroDonos(), getDescricao(), getMarca(), getID(), getPrecoBase(), getDesconto());
    }

    public abstract Artigo clone();

    public abstract double precoartigo();
}

