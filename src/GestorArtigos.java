import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestorArtigos{
    private Map<String, Artigo> produtos_comprados;
    private Map<String, Artigo> produtos_vendidos;
    private Map<String, Artigo> produtos_pra_venda;

    public GestorArtigos(){
        this.produtos_comprados = new HashMap<>();
        this.produtos_vendidos = new HashMap<>();
        this.produtos_pra_venda = new HashMap<>();
    }

    public GestorArtigos(Map<String, Artigo> produtos_comprados, Map<String, Artigo> produtos_vendidos, Map<String, Artigo> produtos_pra_venda) {
        this.produtos_comprados = produtos_comprados;
        this.produtos_vendidos = produtos_vendidos;
        this.produtos_pra_venda = produtos_pra_venda;
    }

    public GestorArtigos(GestorArtigos g){
        this.produtos_comprados = g.getProdutos_comprados();
        this.produtos_vendidos = g.getProdutos_vendidos();
        this.produtos_pra_venda = g.getProdutos_pra_venda();
    }

    public Map<String, Artigo> getProdutos_comprados() {
        return this.produtos_comprados;
    }

    public void setProdutos_comprados(Map<String, Artigo> produtos_comprados) {
        this.produtos_comprados = produtos_comprados;
    }

    public Map<String, Artigo> getProdutos_vendidos() {
        return this.produtos_vendidos;
    }

    public void setProdutos_vendidos(Map<String, Artigo> produtos_vendidos) {
        this.produtos_vendidos = produtos_vendidos;
    }

    public Map<String, Artigo> getProdutos_pra_venda() {
        return this.produtos_pra_venda;
    }

    public void setProdutos_pra_venda(Map<String, Artigo> produtos_pra_venda) {
        this.produtos_pra_venda = produtos_pra_venda;
    }

    public void addCompra(Artigo a, int idcomprador){
        a.setIdUtilizador(idcomprador);
        this.produtos_comprados.put(a.getId(), a);
    }

    public void addVendas(Artigo a, int idvendedor){
        a.setIdUtilizador(idvendedor);
        this.produtos_vendidos.put(a.getId(), a);
    }

    public void addPra_venda(Artigo a, int idvende){
        a.setIdUtilizador(idvende);
        this.produtos_pra_venda.put(a.getId(), a);
    }

    public void remove_produto_pra_venda(Artigo a, int idcomprador){
        Artigo nova_compra = a.clone();
        nova_compra.setIdUtilizador(idcomprador);

        this.produtos_pra_venda.remove(a.getId());
        
        this.produtos_comprados.put(a.getId(), nova_compra); //com id de que comprou

        this.produtos_vendidos.put(a.getId(), a); //com id de quem vendeu
    }

    public boolean existe_Artigo_pra_venda_id(Artigo a){
        boolean existe = false;
        Iterator<Map.Entry<String,Artigo>> iterator = produtos_pra_venda.entrySet().iterator();
       while(iterator.hasNext()){
        Map.Entry<String, Artigo> e = iterator.next();
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
                ", produtos_pra_venda=" + produtos_pra_venda +
                '}';
    }

    public GestorArtigos clone(){
        return new GestorArtigos(this);
    }
}
