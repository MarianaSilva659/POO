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
    private int id_comprador;
    private LocalDate dataCriacao;

    public int getId_comprador() {
        return this.id_comprador;
    }

    public void setId_comprador(int id) {
        this.id_comprador = id;
    }

    public Encomenda(int id){
        this.encomenda = new HashSet<>();
        this.dataCriacao = null;
        this.id_comprador = id;
    }

    public Encomenda(Encomenda e){
        this.encomenda = e.getEncomenda();
        this.dataCriacao = LocalDate.now();
        this.id_comprador = e.getId_comprador();
    }

    public Encomenda(Set<String> encomenda, int id){
        this.encomenda = encomenda;
        this.dataCriacao = LocalDate.now();
        this.id_comprador = id;
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
        && this.getDataCriacao().equals(encomenda1.getDataCriacao());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getEncomenda(), getDataCriacao());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Encomenda{" +
                "encomenda=" + encomenda +
                ",dataCriacao=" + dataCriacao +
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

    public void finalizarCompra(Vintage vintage, int id){
        Collection<Pair<Integer, Pair <String, Double>>> dadosDeVenda = vintage.getDadosDeVenda(getEncomenda());
        vintage.updateVendedores(dadosDeVenda);
        vintage.finalizarArtigos(this.getEncomenda());
    }

    public void devolverEncomenda(Vintage vintage){
        Collection<Pair <String ,Integer>> dados_de_devolução = vintage.getVendedores(getEncomenda());
        vintage.devolverArtigos(dados_de_devolução, getEncomenda(), this.id_comprador);
        this.encomenda = new HashSet<>();
    }

    public void cancelarArtigo(Vintage vintage, String id){
       Pair <String ,Integer> dados_de_devolução = vintage.getVendedores(id);
        vintage.cancelarArtigo(dados_de_devolução, this.id_comprador);
        this.encomenda.remove(id);
    }

    public boolean existe_Artigo(String cod){
        return this.encomenda.contains(cod);
    }
}
