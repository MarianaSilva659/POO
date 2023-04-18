import java.time.Year;

public class SapatilhasPremium extends Sapatilhas{
    private String autores;

    public String getAutores() {
        return this.autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }
    
    public SapatilhasPremium(){
        super();
        this.autores = null;
    }

    public SapatilhasPremium(SapatilhasPremium s){
        super(s);
        this.autores = s.getAutores();
    }

    public SapatilhasPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, String detalhe , int tamanho, String cor, int ano, String autores){
        super(numeroDonos, descricao, marca, id, precoBase, 0, avaliacao, detalhe, tamanho, cor, ano);
        this.autores = autores;
    }

    public double precoartigo(){
        Year ano = Year.now();
        int anoAtual = ano.getValue();
        return getPrecoBase() + (getPrecoBase() / getNumeroDonos() * (anoAtual - getAno()));
        
    }
}
