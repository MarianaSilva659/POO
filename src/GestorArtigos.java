import java.util.HashMap;
import java.util.Map;

public class GestorArtigos{
    private Map<String, ArtigoUtilizador> produtos_comprados;
    private Map<String, ArtigoUtilizador> produtos_vendidos;
    private Map<String, ArtigoUtilizador> produtos_pra_venda;

    public GestorArtigos(){
        this.produtos_comprados = new HashMap<>();
        this.produtos_vendidos = new HashMap<>();
        this.produtos_pra_venda = new HashMap<>();
    }

    public GestorArtigos(Map<String, ArtigoUtilizador> produtos_comprados, Map<String, ArtigoUtilizador> produtos_vendidos, Map<String, ArtigoUtilizador> produtos_pra_venda) {
        this.produtos_comprados = produtos_comprados;
        this.produtos_vendidos = produtos_vendidos;
        this.produtos_pra_venda = produtos_pra_venda;
    }

    public GestorArtigos(GestorArtigos g){
        this.produtos_comprados = g.getProdutos_comprados();
        this.produtos_vendidos = g.getProdutos_vendidos();
        this.produtos_pra_venda = g.getProdutos_pra_venda();
    }

    public Map<String, ArtigoUtilizador> getProdutos_comprados() {
        return this.produtos_comprados;
    }

    public void setProdutos_comprados(Map<String, ArtigoUtilizador> produtos_comprados) {
        this.produtos_comprados = produtos_comprados;
    }

    public Map<String, ArtigoUtilizador> getProdutos_vendidos() {
        return this.produtos_vendidos;
    }

    public void setProdutos_vendidos(Map<String, ArtigoUtilizador> produtos_vendidos) {
        this.produtos_vendidos = produtos_vendidos;
    }

    public Map<String, ArtigoUtilizador> getProdutos_pra_venda() {
        return this.produtos_pra_venda;
    }

    public void setProdutos_pra_venda(Map<String, ArtigoUtilizador> produtos_pra_venda) {
        this.produtos_pra_venda = produtos_pra_venda;
    }

    public void addCompra(Artigo a, String idcomprador){
        ArtigoUtilizador novo = new ArtigoUtilizador(a, idcomprador);
        this.produtos_comprados.put(a.getId(), novo);
    }

    public void addVendas(Artigo a, String idvendedor){
        ArtigoUtilizador novo = new ArtigoUtilizador(a, idvendedor);
        this.produtos_vendidos.put(a.getId(), novo);
    }

    public void addPra_venda(Artigo a, String idvende){
        ArtigoUtilizador novo = new ArtigoUtilizador(a, idvende);
        this.produtos_pra_venda.put(a.getId(), novo);
    }

    public void remove_produto_pra_venda(Artigo a, String idcomprador){
        ArtigoUtilizador nova_compra = new ArtigoUtilizador(a, idcomprador); // com o id de quem comprou
        ArtigoUtilizador novo_vendido = produtos_pra_venda.get(a.getId()); // como id de quem vendeu

        this.produtos_pra_venda.remove(a.getId());
        
        this.produtos_comprados.put(a.getId(), nova_compra);

        this.produtos_vendidos.put(a.getId(), novo_vendido);
    }

    public boolean existe_Artigo_pra_venda(Artigo a){
        boolean existe = false;
        for(Map.Entry<String, ArtigoUtilizador> e : produtos_pra_venda.entrySet()){
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
