import java.time.Year;
import java.util.Objects;

public class Sapatilhas extends Artigo {
    public enum Detalhe{
        Atacadore,
        Atilhos;
    }
    private Detalhe detalhe;
    private int tamanho;
    private String cor;
    private Year ano;


    public Sapatilhas(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, Detalhe detalhe , int tamanho, String cor, int ano){
        super(numeroDonos, descricao, marca, id, precoBase, desconto);
        this.detalhe = detalhe;
        this.tamanho = tamanho;
        this.cor = cor;
        this.ano = Year.of(ano);
    }
    public Sapatilhas(Sapatilhas s){
        super(s);
        this.detalhe = s.getDetalhe();
        this.tamanho = s.getTamanho();
        this.cor = s.getCor();
        this.ano = Year.of(s.getAno());
    }
    public Sapatilhas(){
        super();
        this.detalhe = null;
        this.tamanho = 0;
        this.cor = null;
        this.ano = null;
    }
    public Detalhe getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(Detalhe detalhe) {
        this.detalhe = detalhe;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno(){
        return this.ano.getValue();
    }

    public void setAno(int ano) {
        this.ano = Year.of(ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDetalhe(), getTamanho(), getCor(), getAno(), getDesconto());
    }

    public Sapatilhas clone(){
        return new Sapatilhas(this);
    }

    public double precoartigo(){
        double preco = 0.0;
        if(this.getNumeroDonos() > 0 || this.getTamanho() > 45){
            preco = getPrecoBase() - (getPrecoBase() / getNumeroDonos() * getAvaliacao());
            preco = preco - (preco * getDesconto());
        }
        return preco;
    }

}
