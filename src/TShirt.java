import java.util.Objects;

public abstract class TShirt extends Artigo{
    public enum Tamanho{
        S,
        M,
        L,
        XL
    }
    private Tamanho tamanho;

    private String padrao;

    public TShirt(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, Tamanho tamanho, String padrao) {
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

    public Tamanho getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
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

    public abstract TShirt clone();

    public abstract double precoartigo();

    @Override
    public String toString() {
        return "{" + super.toString() +
            " tamanho='" + getTamanho() + "'" +
            ", padrao='" + getPadrao() + "'" +
            "}";
    }

}

