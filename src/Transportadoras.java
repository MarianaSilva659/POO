import java.util.Objects;

public class Transportadoras {

    double valorBase_PEQ;// valor para as encomendas de 1 artigo
    double valorBase_MED;// valor para as encomendas de 2-5 artigos
    double valorBase_GRA;// valor para as encomendas de +5 artigos
    double parteDeLucro; // fração do valor base que  que fica para a empresa

    public Transportadoras(){

        this.valorBase_MED = 0;
        this.valorBase_PEQ = 0;
        this.valorBase_GRA = 0;
        this.parteDeLucro = 0;
    }
    public Transportadoras(double baseMed,double basePeq,double baseGra,double partLucro){
        this.valorBase_MED = baseMed;
        this.valorBase_PEQ = basePeq;
        this.valorBase_GRA = baseGra;
        this.parteDeLucro = partLucro;

    }
    public Transportadoras(Transportadoras that){
        this.valorBase_MED = that.valorBase_MED ;
        this.valorBase_PEQ = that.valorBase_PEQ;
        this.valorBase_GRA = that.valorBase_GRA;
        this.parteDeLucro = that.parteDeLucro;
    }

    public double precoExpedicao(){
        //verificar qual dos valores base se quer

        //executar
        return -1;
    }

    public double getValorBase_PEQ() {
        return this.valorBase_PEQ;
    }

    public double getValorBase_MED() {
        return this.valorBase_MED;
    }

    public double getValorBase_GRA() {
        return this.valorBase_GRA;
    }

    public double getParteDeLucro() {
        return this.parteDeLucro;
    }


    public void setValorBase_PEQ(double valorBase_PEQ) {
        this.valorBase_PEQ = valorBase_PEQ;
    }

    public void setValorBase_MED(double valorBase_MED) {
        this.valorBase_MED = valorBase_MED;
    }

    public void setValorBase_GRA(double valorBase_GRA) {
        this.valorBase_GRA = valorBase_GRA;
    }

    public void setParteDeLucro(double parteDeLucro) {
        this.parteDeLucro = parteDeLucro;
    }

    @Override
    public String toString() {
        return "Transportadoras{" +
                "valorBase_PEQ=" + valorBase_PEQ +
                ", valorBase_MED=" + valorBase_MED +
                ", valorBase_GRA=" + valorBase_GRA +
                ", parteDeLucro=" + parteDeLucro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadoras that = (Transportadoras) o;
        return  Double.compare(that.valorBase_PEQ, valorBase_PEQ) == 0 &&
                Double.compare(that.valorBase_MED, valorBase_MED) == 0 &&
                Double.compare(that.valorBase_GRA, valorBase_GRA) == 0 &&
                Double.compare(that.parteDeLucro, parteDeLucro) == 0;
    }

    public Transportadoras clone(){
        return new Transportadoras(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorBase_PEQ, valorBase_MED, valorBase_GRA, parteDeLucro);
    }
}
