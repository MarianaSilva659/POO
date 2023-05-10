import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class Encomenda {
    private Set<String> encomenda;
    public enum Dimensao{
        PEQ,
        MED,
        GRA;
    }
    private Dimensao dimensao;
    private LocalDate dataCriacao;

    public Encomenda(){
        this.encomenda = new TreeSet<>();
        this.dimensao = null;
        this.dataCriacao = null;
    }

    public Encomenda(Encomenda e){
        this.encomenda = e.getEncomenda();
        this.dimensao = null;
        this.dataCriacao = LocalDate.now();
    }

    public Encomenda(Set<String> encomenda, Dimensao dimensao){
        this.encomenda = encomenda;
        this.dimensao = null;
        this.dataCriacao = LocalDate.now();
    }

    public Set<String> getEncomenda() {
        TreeSet<String> copia = new TreeSet<>();
        Iterator<String> iterator = encomenda.iterator();
        while (iterator.hasNext()) {
                String artigo = iterator.next();
                copia.add(new String(artigo));
        }
    return copia;
    }

    public void setEncomenda(Set<String> encomenda) {
        this.encomenda = new TreeSet<>();
        Iterator<String> iterator = encomenda.iterator();
        while (iterator.hasNext()) {
                String artigo = iterator.next();
                this.encomenda.add(new String(artigo)); // Clonar a String
        }
    }

    public Dimensao getDimensao() {
        return this.dimensao;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Encomenda encomenda1 = (Encomenda) object;
        return this.getEncomenda().equals(encomenda1.getEncomenda()) 
        && getDimensao() == encomenda1.getDimensao() 
        && this.getDataCriacao().equals(encomenda1.getDataCriacao());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getEncomenda(), getDimensao(), getDataCriacao());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Encomenda{" +
                "encomenda=" + encomenda +
                ", dimensao=" + dimensao +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }
    public void removeArtigoEnc(String idartigo){
        this.encomenda.remove(idartigo);
    }

    public void addArtigoEnc(String idartigo){
        this.encomenda.add(idartigo);
    }

    public void getdimensaoEnc(){
        int dimensao = 0;
        Iterator<String> iterator = encomenda.iterator();
        while (iterator.hasNext()) {
                dimensao++;
        }
        if(dimensao == 1) this.dimensao = Dimensao.PEQ;
        else if((dimensao > 1) && (dimensao < 5)) this.dimensao = Dimensao.MED;
        else this.dimensao = Dimensao.GRA;
    }

    public int calculaPreço(ControladorCentral controlador){
        int preço = 0;
        return preço;
    }
}
