import java.time.Year;


public class MalasPremium extends Malas{
    private double valorizacao;

    public double getValorizacao() {
        return this.valorizacao;
    }

    public void setValorizacao(double valorizacao) {
        this.valorizacao = valorizacao;
    }

    public MalasPremium(){
        super();
        this.valorizacao = 0;
    }

    public MalasPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, Year ano, double altura, double largura, double profundidade, String material, double valorizacao){
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, ano, altura, largura, profundidade, material);
        this.valorizacao = valorizacao;
    }

    public MalasPremium(MalasPremium m) {
        super(m);
        this.valorizacao = m.getValorizacao();
    }

    public MalasPremium clone(){
        return new MalasPremium(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MalasPremium)) {
            return false;
        }
        MalasPremium malasPremium = (MalasPremium) o;
        return this.getValorizacao() == malasPremium.getValorizacao();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valorizacao);
    }

    @Override
    public String toString() {
        return "{" +
            " valorizacao='" + getValorizacao() + "'" +
            "}";
    }

    public double precoartigo(){
        return getPrecoBase() + (getPrecoBase() * ((100 - this.getValorizacao())/100));
    }
}
