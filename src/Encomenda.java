import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;

public class Encomenda {
    private Set<String> encomenda;
    private LocalDate dataCompra;

    public Encomenda(){
        this.encomenda = new HashSet<>();
        this.dataCompra = null;
    }

    public Encomenda(Encomenda e){
        this.encomenda = e.getEncomenda();
        this.dataCompra = LocalDate.now();
    }

    public Encomenda(Set<String> encomenda){
        this.encomenda = encomenda;
        this.dataCompra = LocalDate.now();
    }

    public Set<String> getEncomenda() {
        Set<String> copia = new HashSet<>();
        Iterator<String> iterator = encomenda.iterator();
        while (iterator.hasNext()) {
                String artigo = iterator.next();
                copia.add(new String(artigo));
        }
    return copia;
    }

    public void setEncomenda(Set<String> encomenda) {
        this.encomenda = new HashSet<>();
        Iterator<String> iterator = encomenda.iterator();
        while (iterator.hasNext()) {
                String artigo = iterator.next();
                this.encomenda.add(new String(artigo)); // Clonar a String
        }
    }

    public LocalDate getDataCompra() {
        return this.dataCompra;
    }

    public void setDataCompra(LocalDate dataCriacao) {
        this.dataCompra = dataCriacao;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Encomenda encomenda1 = (Encomenda) object;
        return this.getEncomenda().equals(encomenda1.getEncomenda()) 
        && this.getDataCompra().equals(encomenda1.getDataCompra());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getEncomenda(), getDataCompra());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Encomenda{" +
                "encomenda=" + encomenda +
                ",dataCriacao=" + dataCompra +
                '}';
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public void addArtigo(String id, Vintage vintage){
        vintage.updateArtigo(id);
        this.encomenda.add(id);
    }

    public double calculaPreço(Vintage vintage){
        double preço = 0;
        Set<String> artigos = this.getEncomenda(); 
        Collection<Double> listaDePreços = vintage.getPreçoArtigos(artigos);
        Iterator<Double> it_preços = listaDePreços.iterator();
        while(it_preços.hasNext()){
            preço += it_preços.next();
        }
        Collection<Integer> listaDeTransportadorasDeArtigosNãoPremiumComRepetição = vintage.getTransportadoras(artigos);
        Iterator<Integer> it_transpotadoras = listaDeTransportadorasDeArtigosNãoPremiumComRepetição.iterator();
        Map<Integer, Integer> listadeTransportadoras = new HashMap<>();
        Integer aux;
        while(it_transpotadoras.hasNext()){
            aux = it_transpotadoras.next();
            if(listadeTransportadoras.containsKey(aux)){
                int currentvalue = listadeTransportadoras.get(aux);
                listadeTransportadoras.put(aux, currentvalue+1);
            }else{
                listadeTransportadoras.put(aux, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> transportadora_aux = listadeTransportadoras.entrySet().iterator();
        Map.Entry<Integer, Integer> a;
        while(transportadora_aux.hasNext()){
        a = transportadora_aux.next();
        preço += vintage.getPreçoTransportadora(a.getKey().intValue(), a.getValue().intValue());
        }
        return preço;
    }

    public void finalizarCompra(Vintage vintage){
        Collection<Pair<Integer, Pair <String, Double>>> dadosDeVenda = vintage.getDadosDeVenda(getEncomenda());
        vintage.updateVendedores(dadosDeVenda);
    }

    public void devolverEncomenda(Vintage vintage){
        Collection<Pair <String ,Integer>> dados_de_devolução = vintage.getVendedores(getEncomenda());
        vintage.devolverArtigos(dados_de_devolução, getEncomenda());
        this.encomenda = new HashSet<>();
    }

    public void devolverArtigo(Vintage vintage, String id){
       Pair <String ,Integer> dados_de_devolução = vintage.getVendedores(id);
        vintage.devolverArtigos(dados_de_devolução);
        this.encomenda.remove(id);
    }


}
