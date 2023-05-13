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

    public SapatilhasPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano, String autores){
        super(numeroDonos, descricao, marca, id, precoBase, 0, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano);
        this.autores = autores;
    }
    
    public SapatilhasPremium clone(){
        return new SapatilhasPremium(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SapatilhasPremium)) {
            return false;
        }
        SapatilhasPremium sapatilhasPremium = (SapatilhasPremium) o;
        return this.autores.equals(sapatilhasPremium.autores);
    }

    public double precoartigo(){
        Year ano = Year.now();
        int anoAtual = ano.getValue();
        return getPrecoBase() + (getPrecoBase() / getNumeroDonos() * (anoAtual - getAno()));   
    }

    public boolean isPremium(){
        return true;
    }

    @Override
    public String toString() {
        return "\nSAPATILHAS PREMIUM: " + super.toString() +
            " autores='" + getAutores() + "'";
    }

}
