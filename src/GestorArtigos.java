import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestorArtigos{
    private Map<String, Artigo> produtos_comprados;
    private Map<String, Artigo> produtos_vendidos;
    private Map<String, Artigo> produtos_para_venda;

    public GestorArtigos(){
        this.produtos_comprados = new HashMap<>();
        this.produtos_vendidos = new HashMap<>();
        this.produtos_para_venda = new HashMap<>();
    }

    public GestorArtigos(Map<String, Artigo> produtos_comprados, Map<String, Artigo> produtos_vendidos, Map<String, Artigo> produtos_para_venda) {
        this.produtos_comprados = produtos_comprados;
        this.produtos_vendidos = produtos_vendidos;
        this.produtos_para_venda = produtos_para_venda;
    }

    public GestorArtigos(GestorArtigos g){
        this.produtos_comprados = g.getProdutos_comprados();
        this.produtos_vendidos = g.getProdutos_vendidos();
        this.produtos_para_venda = g.getProdutos_pra_venda();
    }

    public Map<String, Artigo> getProdutos_comprados() {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_comprados.entrySet().iterator();
        Map.Entry<String,Artigo> a;
        
        while(iterator.hasNext()){
            a = iterator.next();

            copia.put(a.getKey(), a.getValue());
        }
        return copia;
    }

    public void setProdutos_comprados(Map<String, Artigo> produtos_comprados) {
        HashMap<String, Artigo> copia = new HashMap<>();
        Iterator<Map.Entry<String, Artigo>> iterator = produtos_comprados.entrySet().iterator();
        Map.Entry<String,Artigo> c;

        while(iterator.hasNext()){
            c = iterator.next();

            String key = c.getKey();
            Artigo value = c.getValue().clone();
            copia.put(key, value);
        }
            this.produtos_comprados = copia;
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
        a.setId_Utilizador(idcomprador);
        this.produtos_comprados.put(a.getId(), a);
    }

    public void addVendas(Artigo a, int idvendedor){
        a.setId_Utilizador(idvendedor);
        this.produtos_vendidos.put(a.getId(), a);
    }

    public void addPra_venda(Artigo a, int idvende){
        a.setId_Utilizador(idvende);
        this.produtos_para_venda.put(a.getId(), a);
    }

    public void remove_produto_pra_venda(Artigo a, int idcomprador){
        Artigo nova_compra = a.clone();
        nova_compra.setId_Utilizador(idcomprador);

        this.produtos_para_venda.remove(a.getId());
        
        this.produtos_comprados.put(a.getId(), nova_compra); //com id de que comprou

        this.produtos_vendidos.put(a.getId(), a); //com id de quem vendeu
    }

    public boolean existe_Artigo_pra_venda_id(Artigo a){
        boolean existe = false;
        Iterator<Map.Entry<String,Artigo>> iterator = produtos_para_venda.entrySet().iterator();
        Map.Entry<String,Artigo> e;
       while(iterator.hasNext()){
        e = iterator.next();
                String id_produto = e.getKey();
                if(id_produto.equals(a.getId()) == true){
                    existe = true;
                }
        }
        return existe;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "GestorArtigos{" +
                "produtos_comprados=" + produtos_comprados +
                ", produtos_vendidos=" + produtos_vendidos +
                ", produtos_para_venda=" + produtos_para_venda +
                '}';
    }

    public GestorArtigos clone(){
        return new GestorArtigos(this);
    }

    public Artigo getArtigoById(String id_artigo){
        Artigo artigo = null;
        Iterator<Map.Entry<String,Artigo>> iterator = produtos_para_venda.entrySet().iterator();
        Map.Entry<String,Artigo> a;

        while(iterator.hasNext()){
            a = iterator.next();
            
            if(a.getKey().equals(id_artigo)){
                artigo = a.getValue();
            }
        }
        if(artigo != null) return artigo.clone();
        else return null;
    }
}
