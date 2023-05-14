import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;

public class Encomenda implements Serializable{
    private Set<String> encomenda;
    private int id_comprador;
    private LocalDate data;

    public int getId_comprador() {
        return this.id_comprador;
    }

    public void setId_comprador(int id) {
        this.id_comprador = id;
    }

    public Encomenda(int id){
        this.encomenda = new HashSet<>();
        this.data = null;
        this.id_comprador = id;
    }

    public Encomenda(Encomenda e){
        this.encomenda = e.getEncomenda();
        this.data = e.getData();
        this.id_comprador = e.getId_comprador();
    }

    public Encomenda(Set<String> encomenda, int id){
        this.encomenda = encomenda;
        this.data = null;
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

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate dataCriacao) {
        this.data = dataCriacao;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Encomenda encomenda1 = (Encomenda) object;
        return this.getEncomenda().equals(encomenda1.getEncomenda()) 
        && this.getData().equals(encomenda1.getData());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getEncomenda(), getData());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Encomenda{" +
                "encomenda=" + encomenda +
                ",dataCriacao=" + data +
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

    
    public double finalizarCompra(Vintage vintage){
        double preço = calculaPreço(vintage);
        Collection<Pair<Integer, Pair <String, Double>>> dadosDeVenda = vintage.getDadosDeVenda(getEncomenda());
        vintage.updateVendedores(dadosDeVenda);
        vintage.updateVintage(this.getEncomenda());
        vintage.finalizarArtigos(this.getEncomenda());
        Set<String> artigos = this.getEncomenda(); 
        Collection<Integer> listaDeTransportadorasDeArtigos = vintage.getTransportadoras(artigos);
        Iterator<Integer> it_transpotadoras = listaDeTransportadorasDeArtigos.iterator();
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
        vintage.updateTransportadora(listadeTransportadoras);
        vintage.updateComprador(getEncomenda(), this.id_comprador, preço);
        this.setData(Vintage.getTime());
        return preço;
    }

    public void cancelarEncomenda(Vintage vintage){
        vintage.cancelarEncomenda(getEncomenda());
        this.encomenda = new HashSet<>();
    }

    public void cancelarArtigo(Vintage vintage, String id){
       //Pair <String ,Integer> dados_de_devolução = vintage.getVendedores(id);
        vintage.cancelarArtigo(id);
        this.encomenda.remove(id);
    }

    public void devolverEncomenda(Vintage vintage){
        Collection<Pair<Integer, Pair <String, Double>>> dadosDeVenda = vintage.getDadosDeVenda(getEncomenda());
        vintage.devolverArtigosVendedor(dadosDeVenda);
        vintage.removeLucroFromVintage(this.getEncomenda());
        vintage.devolverArtigos(this.getEncomenda());
        Set<String> artigos = this.getEncomenda(); 
        Collection<Integer> listaDeTransportadoras = vintage.getTransportadoras(artigos);
        Iterator<Integer> it_transpotadoras = listaDeTransportadoras.iterator();
        Map<Integer, Integer> mapDeTransportadorasAssociadasAoNumeroDeOcurrencias = new HashMap<>();
        Integer aux;
        while(it_transpotadoras.hasNext()){
            aux = it_transpotadoras.next();
            if(mapDeTransportadorasAssociadasAoNumeroDeOcurrencias.containsKey(aux)){
                int currentvalue = mapDeTransportadorasAssociadasAoNumeroDeOcurrencias.get(aux);
                mapDeTransportadorasAssociadasAoNumeroDeOcurrencias.put(aux, currentvalue+1);
            }else{
                mapDeTransportadorasAssociadasAoNumeroDeOcurrencias.put(aux, 1);
            }
        }
        vintage.corrigirTransportadoras(mapDeTransportadorasAssociadasAoNumeroDeOcurrencias);
        vintage.corrigirUtilizador(getEncomenda(), calculaPreço(vintage), this.id_comprador);
        this.encomenda = new HashSet<>();
        data = null;
    }

    public boolean existe_ArtigoEnc(String cod){
        return this.encomenda.contains(cod);
    }

    public boolean isVazia(){
        return this.encomenda.isEmpty();
    }
}
