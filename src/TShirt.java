import java.util.Objects;

public class TShirt extends Artigo{
    private String tamanho;

    private String padrao;

    public TShirt(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }
    public TShirt(TShirt t){
        super(t);
        this.padrao = t.getPadrao();
        this.tamanho = t.getTamanho();
    }

    public TShirt(){
        super();
        this.tamanho = null;
        this.padrao = null;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPadrao() {
        return this.padrao;
    }

    public void setPadrao(String padrao){
        this.padrao = padrao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return this.getTamanho() == tShirt.getTamanho() &&
               this.getPadrao().equals(tShirt.getPadrao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTamanho(), getPadrao());
    }

    public TShirt clone(){
        return new TShirt(this);
    }

    public double precoartigo(){
        return getPrecoBase()*((100-getDesconto())/100);
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
            " tamanho='" + getTamanho() + "'" +
            ", padrao='" + getPadrao() + "'" +
            "}";
    }

}

