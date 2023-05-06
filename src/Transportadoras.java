import java.util.Objects;

public class Transportadoras {

    private double valorBase_PEQ;
    private double valorBase_MED;
    private double valorBase_GRA;
    private int margemLucro; // percentagem
    private boolean EncPremium; //aceita encomendas premium?
    private int idTransporte;
    private static int imposto = 23;

    public Transportadoras(){
        this.valorBase_MED = 0;
        this.valorBase_PEQ = 0;
        this.valorBase_GRA = 0;
        this.margemLucro = 0;
        this.EncPremium = false;
        this.idTransporte = 0;
    }

    public Transportadoras(double baseMed,double basePeq,double baseGra,int margemLucro, boolean EncPremium, int idTransporte){
        this.valorBase_MED = baseMed;
        this.valorBase_PEQ = basePeq;
        this.valorBase_GRA = baseGra;
        this.margemLucro = margemLucro;
        this.EncPremium = EncPremium;
        this.idTransporte = idTransporte;
    }

    public Transportadoras(Transportadoras t){
        this.valorBase_MED = t.getValorBase_MED() ;
        this.valorBase_PEQ = t.getPrecoEncomendaPEQ();
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

    public int getMargemLucro() {
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

    public void setMargemLucro(int margemlucro) {
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
        return "Transportadoras{" +
                "valorBase_PEQ=" + valorBase_PEQ +
                ", valorBase_MED=" + valorBase_MED +
                ", valorBase_GRA=" + valorBase_GRA +
                ", margemLucro=" + margemLucro +
                ", EncPremium=" + EncPremium +
                ", idTransporte=" + idTransporte +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadoras transportadora = (Transportadoras) o;
        return  Double.compare(this.getValorBase_PEQ(), transportadora.getValorBase_PEQ()) == 0 &&
                Double.compare(this.getValorBase_MED(), transportadora.getValorBase_MED()) == 0 &&
                Double.compare(this.getValorBase_GRA(), transportadora.getValorBase_GRA()) == 0 &&
                this.getMargemLucro() == transportadora.getMargemLucro() &&
                this.EncPremium == transportadora.getEncPremium() &&
                this.getIdTransporte() == transportadora.getIdTransporte();
    }

    public Transportadoras clone(){
        return new Transportadoras(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorBase_PEQ, valorBase_MED, valorBase_GRA, margemLucro);
    }

    public double getPrecoEncomendaPEQ(){
        if(getEncPremium() == false) return getValorBase_PEQ() * getMargemLucro() * (1 + imposto) * 0.9;
        
        else return (getValorBase_PEQ() * 3) * getMargemLucro() * (1 + imposto) * 0.9;
    }

    public double getPrecoEncomendaMED(){
        if(getEncPremium() == false) return getValorBase_MED() * getMargemLucro() * (1 + imposto) * 0.9;

        else return (getValorBase_MED() * 3) * getMargemLucro() * (1 + imposto) * 0.9;
    }

    public double getPrecoEncomendaGRA(){
        if(getEncPremium() == false) return getValorBase_GRA() * getMargemLucro() * (1 + imposto) * 0.9;
        
        else return (getValorBase_MED() * 3) * getMargemLucro() * (1 + imposto) * 0.9;
    }
}
