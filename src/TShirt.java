import java.util.Objects;

public class TShirt extends Artigo{
    private String tamanho;
    private String padrao;

    public TShirt(String tamanho, String padrao) {
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(Artigo a, String tamanho, String padrao) {
        super(a);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, String tamanho, String padrao) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }
    public TShirt(TShirt t){
        super(t);
        this.padrao = t.getPadrao();
        this.tamanho = t.getTamanho();
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
        return Objects.equals(getTamanho(), tShirt.getTamanho()) && Objects.equals(getPadrao(), tShirt.getPadrao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTamanho(), getPadrao());
    }

    public TShirt clone(){
        return new TShirt(this);
    }
    public double precoartigo(){
        double preco = 0;
        preco = getPrecoBase() * ((100 - getDesconto())/100);
        return preco;
    }
}

