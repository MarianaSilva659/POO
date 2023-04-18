import java.time.Year;
import java.util.Objects;


public class Malas extends Artigo{
    private Year ano;
    private double altura;
    private double largura;
    private double profundidade;
    private String material;

    public int getAno(){
        return this.ano.getValue();
    }

    public void setAno(int ano) {
        this.ano = Year.of(ano);
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return this.largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return this.profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Malas(){
        super();
        this.altura = 0;
        this.largura = 0;
        this.profundidade = 0;
        this.ano = null;
    }

    public Malas(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, Year ano, double altura, double largura, double profundidade, String material) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao);
        this.ano = ano;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.material = material;
    }

    public Malas(Malas m) {
        super(m);
        this.ano = Year.of(m.getAno());
        this.altura = m.getAltura();
        this.largura = m.getLargura();
        this.profundidade = m.getProfundidade();
        this.material = m.getMaterial();
    }

    public Malas clone(){
        return new Malas(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, altura, largura, profundidade, material);
    }

    public double precoartigo(){
        return getPrecoBase()*((100-getDesconto())/100);
    }
}
