import java.io.Serializable;
import java.util.Objects;

public class Transportadora implements Serializable {

    private double valorBase_PEQ;
    private double valorBase_MED;
    private double valorBase_GRA;
    private double margemLucro; // percentagem
    private boolean Premium; //aceita encomendas premium?
    private int idTransporte;
    private double faturação;

    public Transportadora(){
        this.valorBase_MED = 0;
        this.valorBase_PEQ = 0;
        this.valorBase_GRA = 0;
        this.margemLucro = 0;
        this.Premium = false;
        this.idTransporte = 0;
        this.faturação = 0;
    }

    public Transportadora(double baseMed,double basePeq,double baseGra,double margemLucro, boolean EncPremium, int idTransporte){
        this.valorBase_MED = baseMed;
        this.valorBase_PEQ = basePeq;
        this.valorBase_GRA = baseGra;
        this.margemLucro = margemLucro;
        this.Premium = EncPremium;
        this.idTransporte = idTransporte;
        this.faturação = 0;
    }

    public Transportadora(Transportadora t){
        this.valorBase_MED = t.getValorBase_MED() ;
        this.valorBase_PEQ = t.getValorBase_PEQ();
        this.valorBase_GRA = t.getValorBase_GRA();
        this.margemLucro = t.getMargemLucro();
        this.Premium = t.isPremium();
        this.idTransporte = t.getIdTransporte();
        this.faturação = t.getFaturação();
    }

    public double getFaturação() {
        return this.faturação;
    }

    public void setFaturação(double faturação) {
        this.faturação = faturação;
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

    public double getMargemLucro() {
        return this.margemLucro;
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

    public void setMargemLucro(Double margemlucro) {
        this.margemLucro = margemlucro;
    }

    public boolean isPremium() {
        return this.Premium;
    }

    public void setPremium(boolean encPremium) {
        this.Premium = encPremium;
    }

    public int getIdTransporte() {
        return this.idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "\nTRANSPORTADORA:" +
                " INDETIFICADOR=" + idTransporte +
                ", ValorBase_PEQ=" + valorBase_PEQ +
                ", ValorBase_MED=" + valorBase_MED +
                ", ValorBase_GRA=" + valorBase_GRA +
                ", MargemLucro=" + margemLucro +
                ", EncPremium=" + Premium +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora transportadora = (Transportadora) o;
        return  Double.compare(this.getValorBase_PEQ(), transportadora.getValorBase_PEQ()) == 0 &&
                Double.compare(this.getValorBase_MED(), transportadora.getValorBase_MED()) == 0 &&
                Double.compare(this.getValorBase_GRA(), transportadora.getValorBase_GRA()) == 0 &&
                Double.compare(this.getMargemLucro(),transportadora.getMargemLucro()) == 0 &&
                this.Premium == transportadora.isPremium() &&
                this.getIdTransporte() == transportadora.getIdTransporte();
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValorBase_PEQ(), getValorBase_MED(), getValorBase_GRA(), getMargemLucro());
    }

    private double getPrecoEncomendaPEQ(){
        if(isPremium() == false) return getValorBase_PEQ() * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
        
        else return getValorBase_PEQ() * 3 * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
    }

    private double getPrecoEncomendaMED(){
        if (isPremium() == false) return getValorBase_MED() * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;

        else return getValorBase_MED() * 3 * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
    }

    private double getPrecoEncomendaGRA(){
        if(isPremium() == false) return getValorBase_GRA() * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
        
        else return getValorBase_GRA() * 3 * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
    }

    public double getPrecoEncomenda(int tamanho_da_encomenda){
        if(tamanho_da_encomenda == 1){
          return  getPrecoEncomendaPEQ();
        }else if((tamanho_da_encomenda > 1) && (tamanho_da_encomenda <= 5)){
            return getPrecoEncomendaMED();
        }else return getPrecoEncomendaGRA();
    }

    public void updateTransportadora(int tamanho_da_encomenda){
        double temp = getFaturação();
        setFaturação(temp + getPrecoEncomenda(tamanho_da_encomenda));
    }
}
