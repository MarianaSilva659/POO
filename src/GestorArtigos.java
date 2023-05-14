
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class GestorArtigos implements Serializable{
    private Map<String, Artigo> produtos_pendentes;
    private Map<String, Artigo> produtos_vendidos;
    private Map<String, Artigo> produtos_para_venda;

    public GestorArtigos(){
        this.produtos_pendentes = new HashMap<>();
        this.produtos_vendidos = new HashMap<>();
        this.produtos_para_venda = new HashMap<>();
    }

    public GestorArtigos(Map<String, Artigo> produtos_pendentes, Map<String, Artigo> produtos_vendidos, Map<String, Artigo> produtos_para_venda) {
        this.produtos_pendentes = produtos_pendentes;
        this.produtos_vendidos = produtos_vendidos;
        this.produtos_para_venda = produtos_para_venda;
    }

    public GestorArtigos(GestorArtigos g){
        this.produtos_pendentes = g.getprodutos_pendentes();
        this.produtos_vendidos = g.getProdutos_vendidos();
        this.produtos_para_venda = g.getProdutos_pra_venda();
    }

    public Map<String, Artigo> getprodutos_pendentes() {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_pendentes.entrySet().iterator();
        Map.Entry<String,Artigo> a;
        
        while(iterator.hasNext()){
            a = iterator.next();

            copia.put(a.getKey(), a.getValue());
        }
        return copia;
    }

    public void setprodutos_pendentes(Map<String, Artigo> produtos_pendentes) {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_pendentes.entrySet().iterator();
        Map.Entry<String,Artigo> c;

        while(iterator.hasNext()){
            c = iterator.next();

            String key = c.getKey();
            Artigo value = c.getValue().clone();
            copia.put(key, value);
        }
            this.produtos_pendentes = copia;
    }

    public Map<String, Artigo> getProdutos_vendidos() {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_vendidos.entrySet().iterator();
        Map.Entry<String,Artigo> a;

        while(iterator.hasNext()){
            a = iterator.next();

            copia.put(a.getKey(), a.getValue());
        }
        return copia;
    }

    public void setProdutos_vendidos(Map<String, Artigo> produtos_vendidos) {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_vendidos.entrySet().iterator();
        Map.Entry<String,Artigo> c;

        while(iterator.hasNext()){
            c = iterator.next();

            String key = c.getKey();
            Artigo value = c.getValue().clone();
            copia.put(key, value);
        }
            this.produtos_vendidos = copia;
    }

    public Map<String, Artigo> getProdutos_pra_venda() {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_para_venda.entrySet().iterator();
        Map.Entry<String,Artigo> a;

        while(iterator.hasNext()){
           a = iterator.next();

            copia.put(a.getKey(), a.getValue());
        }
        return copia;
    }

    public void setProdutos_pra_venda(Map<String, Artigo> produtos_para_venda) {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_para_venda.entrySet().iterator();
        Map.Entry<String,Artigo> c;

        while(iterator.hasNext()){
            c = iterator.next();

            String key = c.getKey();
            Artigo value = c.getValue().clone();
            copia.put(key, value);
        }
            this.produtos_para_venda = copia;
    }

    public void addCompra(Artigo a, int idcomprador){
        a.setId_vendedor(idcomprador);
        this.produtos_pendentes.put(a.getId(), a);
    }

    public void addVendas(Artigo a, int idvendedor){
        a.setId_vendedor(idvendedor);
        this.produtos_vendidos.put(a.getId(), a);
    }

    public void addPra_venda(Artigo a, int idvende){
        a.setId_vendedor(idvende);
        this.produtos_para_venda.put(a.getId(), a);
    }

    public void remove_produto_pra_venda(Artigo a, int idcomprador){
        Artigo nova_compra = a.clone();
        nova_compra.setId_vendedor(idcomprador);

        this.produtos_para_venda.remove(a.getId());
        
        this.produtos_pendentes.put(a.getId(), nova_compra); //com id de que comprou

        this.produtos_vendidos.put(a.getId(), a); //com id de quem vendeu
    }

    public boolean existe_Artigo_pra_venda_id(String a){
       return this.produtos_para_venda.containsKey(a);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ARTIGOS DISPONÍVEIS: \n" +
                "\nprodutos_pendentes=" + produtos_pendentes.values() +
                "\n produtos_vendidos=" + produtos_vendidos.values() +
                "\n produtos_para_venda=" + produtos_para_venda.values();
    }

    public boolean existe_Artigo(String id){
        return this.produtos_pendentes.containsKey(id) || this.produtos_para_venda.containsKey(id) || this.produtos_vendidos.containsKey(id);
    }

    public Artigo getArtigoById(String id_artigo){
        if(produtos_pendentes.containsKey(id_artigo)){
            return produtos_pendentes.get(id_artigo);
        }else if(produtos_para_venda.containsKey(id_artigo))
        return produtos_para_venda.get(id_artigo);
        else return produtos_vendidos.get(id_artigo);
    }

    public Collection<Double> getPreçoArtigos(Collection<String> artigosID){
        ArrayList<Double> result = new ArrayList<Double>();
        Iterator<String> it = artigosID.iterator();
        String aux;
        while(it.hasNext()){
            aux = it.next();
            result.add(getArtigoById(aux).precoartigo());
        }
        return result;
    }

    public Collection<Integer> getTransportadoras(Collection<String> artigos){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<String> it = artigos.iterator();
        String aux;
        while(it.hasNext()){
            aux = it.next();
            result.add(getArtigoById(aux).getId_transporte());
        }
        return result;
    }

    public Collection<Pair<Integer, Pair <String, Double>>> getDadosDeVenda(Collection<String> artigos){
        ArrayList<Pair<Integer, Pair <String, Double>>> result = new ArrayList<Pair<Integer, Pair <String, Double>>>();
        Iterator<String> it = artigos.iterator();
        String aux;
        Pair<Integer, Pair <String, Double>> pair = new Pair<Integer, Pair <String, Double>>();
        Artigo artigo;

        while(it.hasNext()){
            aux = it.next();
            artigo = getArtigoById(aux);
          pair.setFirst(artigo.getId_vendedor());
          pair.getSecond().setSecond(artigo.precoartigo());
          pair.getSecond().setFirst(aux);
        result.add(pair.clone());
        }
        return result;
    }

    public Collection<Pair<String, Integer>> getVendedores(Collection<String> artigosID){
        List<Pair<String, Integer>> result = new ArrayList<>();
        Iterator<String> it = artigosID.iterator();
        String aux;
        Artigo artigo;
        Pair<String, Integer> pair = new Pair<String, Integer>();
        while(it.hasNext()){
            aux = it.next();
            artigo = getArtigoById(aux);
            pair.setFirst(aux);
            pair.setSecond(artigo.getId_vendedor());
        result.add(pair);
        }
        return result;
    }

    public Pair<String, Integer> getVendedores(String artigosID){
        Pair<String, Integer> pair = new Pair<>();
        Artigo artigo;
            artigo = getArtigoById(artigosID);
            pair.setFirst(artigosID);
            pair.setSecond(artigo.getId_vendedor());
          //  result.add(this.produtos_pendentes.get(aux).getId_transporte());
        return pair;
    }

    public void cancelarEncomenda(Collection<String> artigosID){
        Iterator<String> it = artigosID.iterator();
        String aux;
        Artigo artigo;
        while(it.hasNext()){
            aux = it.next();
            artigo = produtos_pendentes.get(aux).clone();
            produtos_pendentes.remove(aux);
            produtos_para_venda.put(aux, artigo);
        }
    }

    public void cancelarArtigo(String artigosID){
        Artigo artigo;
            artigo = produtos_pendentes.get(artigosID);
            produtos_pendentes.remove(artigosID);
            produtos_para_venda.put(artigosID, artigo.clone());
    }

    public void devolverArtigos(Collection<String> artigosID){
        Iterator<String> it = artigosID.iterator();
        String aux;
        Artigo artigo;
        while(it.hasNext()){
            aux = it.next();
            artigo = produtos_vendidos.get(aux).clone();
            produtos_vendidos.remove(aux);
            produtos_para_venda.put(aux, artigo);
        }
    }

    public void devolverArtigos(String artigosID){
        Artigo artigo;
            artigo = produtos_vendidos.get(artigosID).clone();
            produtos_vendidos.remove(artigosID);
            produtos_para_venda.put(artigosID, artigo);
    }

    public void updateArtigo(String id){
        Artigo artigo = produtos_para_venda.get(id).clone();
        produtos_para_venda.remove(id);
        produtos_pendentes.put(id, artigo);
    }

    public void finalizarArtigos(Collection <String> artigosID){
        Iterator<String> it = artigosID.iterator();
        String aux;
        Artigo artigo;
        while(it.hasNext()){
            aux = it.next();
            artigo = produtos_pendentes.get(aux).clone();
            produtos_pendentes.remove(aux);
            produtos_vendidos.put(aux, artigo);
        }
    }

    public int getNumNovos(Collection <String> artigosID){
        Iterator<String> it = artigosID.iterator();
        String aux;
        Artigo artigo;
        int count = 0;
        while(it.hasNext()){
            aux = it.next();
            artigo = getArtigoById(aux);
            if(artigo.isNovo()) count++;
        }
        return count;
    }

    public int getNumUsados(Collection <String> artigosID){
        Iterator<String> it = artigosID.iterator();
        String aux;
        Artigo artigo;
        int count = 0;
        while(it.hasNext()){
            aux = it.next();
            artigo = getArtigoById(aux);
            if(!(artigo.isNovo())) count++;
        }
        return count;
    }
}
