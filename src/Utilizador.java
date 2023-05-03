import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Objects;
public class Utilizador {
    private String cod;
    private String email;
    private String nome;
    private String morada;
    private  String nif;
    private Map<String, Artigo> compras;
    private Map<String, Artigo> vendidas;
    private Map<String, Artigo> pra_venda;
    private double valor_vendas;
    public Utilizador(){
        this.cod = "";
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = "";
        this.compras = new HashMap<>();
        this.vendidas = new HashMap<>();
        this.pra_venda = new HashMap<>();
        this.valor_vendas = 0;
    }

    public Utilizador(String cod, String email, String nome, String morada, String nif, Map<String, Artigo> compras, Map<String, Artigo> vendidas, Map<String, Artigo> pra_venda, double valor_vendas) {
        this.cod = cod;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.compras = compras.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
        this.vendidas = vendidas.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
        this.pra_venda = pra_venda.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
        this.valor_vendas = valor_vendas;
    }
    public Utilizador(String cod, String email, String nome, String morada, String nif) {
        this.cod = cod;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.compras = new HashMap<>();
        this.vendidas = new HashMap<>();
        this.pra_venda = new HashMap<>();
        this.valor_vendas = 0;
    }
    public Utilizador(Utilizador u) {
        this.cod = u.getCod();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nif = u.getNif();
        this.compras = u.getCompras();
        this.vendidas = u.getVendidas();
        this.pra_venda = u.getPra_venda();
        this.valor_vendas = u.getValor_vendas();
    }

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Map<String, Artigo> getCompras() {
        return this.compras.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
    }

    public void setCompras(Map<String, Artigo> compras) {
        this.compras = compras;
    }

    public Map<String, Artigo> getVendidas() {
        return this.vendidas.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
    }

    public void setVendidas(Map<String, Artigo> vendidas) {
        this.vendidas = vendidas;
    }

    public Map<String, Artigo> getPra_venda() {
        return this.pra_venda.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
    }

    public void setPra_venda(Map<String, Artigo> pra_venda) {
        this.pra_venda = pra_venda;
    }

    public double getValor_vendas() {
        return this.valor_vendas;
    }

    public void setValor_vendas(double valor_vendas) {
        this.valor_vendas = valor_vendas;
    }

    public void addCompras(Artigo a){
        this.compras.put(a.getId(), a.clone());
    }
    public void addVendidas(Artigo a){
        this.vendidas.put(a.getId(), a.clone());
    }
    public void addPra_Venda(Artigo a){
        this.pra_venda.put(a.getId(), a.clone());
    }
    public Artigo getCompra(String id){
        if(!compras.containsKey(id)){
            return null;
        }
        return this.compras.get(id).clone();
    }
    public Artigo getVendida(String id){
        if(!vendidas.containsKey(id)){
            return null;
        }
        return this.vendidas.get(id).clone();
    }
    public Artigo getPra_Venda(String id){
        if(!pra_venda.containsKey(id)){
            return null;
        }
        return this.pra_venda.get(id).clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return Double.compare(that.getValor_vendas(), getValor_vendas()) == 0
                && Objects.equals(getCod(), that.getCod())
                && Objects.equals(getEmail(), that.getEmail())
                && Objects.equals(getNome(), that.getNome())
                && Objects.equals(getMorada(), that.getMorada())
                && Objects.equals(getNif(), that.getNif())
                && this.compras.equals(that.getCompras())
                && this.vendidas.equals(that.getVendidas())
                && this.pra_venda.equals(that.getPra_venda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod(), getEmail(), getNome(), getMorada(), getNif(), getCompras(), getVendidas(), getPra_venda(), getValor_vendas());
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "cod='" + cod + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", nif='" + nif + '\'' +
                ", compras=" + compras +
                ", vendidas=" + vendidas +
                ", pra_venda=" + pra_venda +
                ", valor_vendas=" + valor_vendas +
                '}';
    }
    public Utilizador clone(){
        return new Utilizador();
    }
}
