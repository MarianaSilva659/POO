import java.io.Serializable;
import java.util.Objects;

public class Transportadora implements Serializable {

    private double valorBase_PEQ;
    private double valorBase_MED;
    private double valorBase_GRA;
    private double margemLucro; // percentagem
    private boolean EncPremium; //aceita encomendas premium?
    private int idTransporte;

    public Transportadora(){
        this.valorBase_MED = 0;
        this.valorBase_PEQ = 0;
        this.valorBase_GRA = 0;
        this.margemLucro = 0;
        this.EncPremium = false;
        this.idTransporte = 0;
    }

    public Transportadora(double baseMed,double basePeq,double baseGra,double margemLucro, boolean EncPremium, int idTransporte){
        this.valorBase_MED = baseMed;
        this.valorBase_PEQ = basePeq;
        this.valorBase_GRA = baseGra;
        this.margemLucro = margemLucro;
        this.EncPremium = EncPremium;
        this.idTransporte = idTransporte;
    }

    public Transportadora(Transportadora t){
        this.valorBase_MED = t.getValorBase_MED() ;
        this.valorBase_PEQ = t.getValorBase_PEQ();
        this.valorBase_GRA = t.getValorBase_GRA();
        this.margemLucro = t.getMargemLucro();
        this.EncPremium = t.getEncPremium();
        this.idTransporte = t.getIdTransporte();
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

    public boolean getEncPremium() {
        return this.EncPremium;
    }

    public void setEncPremium(boolean encPremium) {
        this.EncPremium = encPremium;
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
                ", EncPremium=" + EncPremium +
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
                this.EncPremium == transportadora.getEncPremium() &&
                this.getIdTransporte() == transportadora.getIdTransporte();
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValorBase_PEQ(), getValorBase_MED(), getValorBase_GRA(), getMargemLucro());
    }

    public double getPrecoEncomendaPEQ(){
        if(getEncPremium() == false) return getValorBase_PEQ() * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
        
        else return (getValorBase_PEQ() * 3) * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
    }

    public double getPrecoEncomendaMED(){
        if(getEncPremium() == false) return getValorBase_MED() * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;

        else return (getValorBase_MED() * 3) * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
    }

    public double getPrecoEncomendaGRA(){
        if(getEncPremium() == false) return getValorBase_GRA() * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
        
        else return (getValorBase_MED() * 3) * getMargemLucro() * (1 + Vintage.getImposto()) * 0.9;
    }
}
