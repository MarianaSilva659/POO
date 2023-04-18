import java.util.Objects;
import java.util.HashMap;
import java.util.Map;

public class TShirt extends Artigo{
    private String tamanho;
    private String padrao;
    private static final Map<String, Integer> mapDesconto = new HashMap<>();

    static{
        mapDesconto.put("liso", 0);
        mapDesconto.put("riscas", 50);
        mapDesconto.put("palmeiras", 50);
    }

    public TShirt(String tamanho, String padrao) {
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(Artigo a, String tamanho, String padrao) {
        super(a);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, String tamanho, String padrao) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao);
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
        if(getNumeroDonos() > 0){
            preco = getPrecoBase() * ((100 - mapDesconto.get(this.getPadrao()))/100);
        }  
        else{
            preco = getPrecoBase() * ((100 - getDesconto())/100);
        } 
        return preco;
    }
}

