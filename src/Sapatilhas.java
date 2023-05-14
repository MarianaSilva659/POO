import java.util.Objects;

public class Sapatilhas extends Artigo {
    private String detalhe;
    private int tamanho;
    private String cor;
    private int ano;


    public Sapatilhas(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano){
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte);
        this.detalhe = detalhe;
        this.tamanho = tamanho;
        this.cor = cor;
        this.ano = ano;
    }

    public Sapatilhas(Sapatilhas s){
        super(s);
        this.detalhe = s.getDetalhe();
        this.tamanho = s.getTamanho();
        this.cor = s.getCor();
        this.ano = s.getAno();
    }

    public Sapatilhas(){
        super();
        this.detalhe = null;
        this.tamanho = 0;
        this.cor = null;
        this.ano = 0;
    }

    public String getDetalhe() {
        return this.detalhe;
    }

    public void setDetalhe(String detalhe) {
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
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sapatilhas)) {
            return false;
        }
        Sapatilhas sapatilhas = (Sapatilhas) o;
        return this.getDetalhe().equals(sapatilhas.getDetalhe()) && 
        this.getTamanho() == sapatilhas.getTamanho() && 
        this.getCor().equals(sapatilhas.getCor()) && 
        this.getAno() == sapatilhas.getAno();
    }

    @Override
    public int hashCode() {
        return Objects.hash(detalhe, tamanho, cor, ano);
    }

    public Sapatilhas clone(){
        return new Sapatilhas(this);
    }

    public double precoartigo(){
        double preco = 0.0;
        if((this.getNumeroDonos() > 0) || (this.getTamanho() > 45)){
            preco = getPrecoBase() - (getPrecoBase() / getNumeroDonos() * getAvaliacao());
            preco = preco * ((100 - getDesconto())/100);
        }
        else{
            preco = getPrecoBase() * ((100 - getDesconto())/100);
        }
        return preco;
    }

    @Override
    public String toString() {
        return "\nSAPATILHAS: " + super.toString()+
            " detalhe='" + getDetalhe() + "'" +
            ", tamanho='" + getTamanho() + "'" +
            ", cor='" + getCor() + "'" +
            ", ano='" + getAno() + "'";
    }


}
