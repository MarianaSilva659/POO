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

    public double precoartigo(){
        return getPrecoBase() + (getPrecoBase() * ((100 - this.getValorizacao())/100));
    }
}
