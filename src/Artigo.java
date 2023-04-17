import java.util.Objects;

public abstract class Artigo{
    public enum Estado{
        Novo,
        Usado;
    }
    private Estado estado;
    private double avaliacao;
    private int numeroDonos;
    private String descricao;
    private String marca;
    private String codAlfanumerico;
    private double precoBase;
    private double desconto;

    public  Artigo(){
        this.estado = null;
        this.numeroDonos = 0;
        this.descricao = null;
        this.marca = null;
        this.codAlfanumerico = null;
        this.precoBase = 0;
        this.desconto = 0;
    }
    public  Artigo(Artigo a){
        this.estado = a.getEstado();
        this.numeroDonos = a.getNumeroDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.codAlfanumerico = a.getCodAlfanumerico();
        this.precoBase = a.getPrecoBase();
        this.desconto = a.getDesconto();
    }
    public Artigo(Estado estado, int numeroDonos, String descricao, String marca, String codAlfanumerico, double precoBase, double desconto){
        this.estado = estado;
        this.numeroDonos = numeroDonos;
        this.descricao = descricao;
        this.marca = marca;
        this.codAlfanumerico = codAlfanumerico;
        this.precoBase = precoBase;
        this.desconto = desconto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public String getCodAlfanumerico() {
        return this.codAlfanumerico;
    }

    public void setCodAlfanumerico(String codAlfanumerico) {
        this.codAlfanumerico = codAlfanumerico;
    }

    public Double getPrecoBase() {
        return this.precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artigo artigo = (Artigo) o;
        return /*this.numeroDonos.equals(artigo.numeroDonos) &&
                this.precoBase.equals(artigo.precoBase) &&
                this.desconto.equals(artigo.desconto) &&*/
                this.estado.equals(artigo.estado) &&
                this.descricao.equals(artigo.descricao) &&
                this.marca.equals(artigo.marca) &&
                this.codAlfanumerico.equals(artigo.codAlfanumerico);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEstado(), getNumeroDonos(), getDescricao(), getMarca(), getCodAlfanumerico(), getPrecoBase(), getDesconto());
    }

    public abstract Artigo clone();

    public abstract double precofinal();
}
