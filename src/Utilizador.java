import java.io.Serializable;
import java.util.Set;
import java.util.Iterator;
import java.util.Objects;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.*;
public class Utilizador implements Serializable{
    private int id;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private Map<String, LocalDate> artigos_comprados;
    private Map<String, LocalDate> artigos_vendidos;
    private Set<String> artigos_para_venda;
    private double dinheiro_faturado;
    private double dinheiro_gasto;
    private Encomenda encomenda;

    public Utilizador(){
        this.id = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = 0;
        this.artigos_comprados = new HashMap<>();
        this.artigos_vendidos = new HashMap<>();
        this.artigos_para_venda = new HashSet<>();
        this.dinheiro_faturado = 0;
        this.dinheiro_gasto = 0;
        this.encomenda = new Encomenda(this.id);
    }

    public Utilizador(int id, String email, String nome, String morada, int nif) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.artigos_comprados = new HashMap<>();
        this.artigos_vendidos = new HashMap<>();
        this.artigos_para_venda = new HashSet<>();
        this.dinheiro_faturado = 0;
        this.dinheiro_gasto = 0;
        this.encomenda = new Encomenda(id);
    }

    public Utilizador(Utilizador u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nif = u.getNif();
        this.artigos_comprados = u.getArtigos_comprados();
        this.artigos_vendidos = u.getArtigos_vendidos();
        this.artigos_para_venda = u.getArtigos_para_venda();
        this.dinheiro_faturado = u.getDinheiro_faturado();
        this.dinheiro_gasto = u.getDinheiro_gasto();
        this.encomenda  = u.getEncomenda();
    }

    public double getDinheiro_faturado() {
        return this.dinheiro_faturado;
    }

    public void setDinheiro_faturado(double dinheiro_faturado) {
        this.dinheiro_faturado = dinheiro_faturado;
    }

    public int getId() {
        return this.id;
    }

    public double getDinheiro_gasto() {
        return this.dinheiro_gasto;
    }

    public void setDinheiro_gasto(double dinheiro_gasto) {
        this.dinheiro_gasto = dinheiro_gasto;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public  Map<String, LocalDate> getArtigos_comprados() {
        return this.artigos_vendidos;
    }

    public void setArtigos_comprados( Map<String, LocalDate> artigos_comprados) {
        this.artigos_comprados = artigos_comprados;
    }

    public  Map<String, LocalDate> getArtigos_vendidos() {
        return this.artigos_vendidos;
    }

    public Collection<String> getID_Artigos_comprados(){
        Iterator<Map.Entry<String, LocalDate>> it = artigos_comprados.entrySet().iterator();
        String aux;
        Collection<String> result = new HashSet<>();
        while(it.hasNext()){
            aux = it.next().getKey();
            result.add(aux);
        }
        return result;
    }

    public Collection<String> getID_Artigos_vendidos(){
        Iterator<Map.Entry<String, LocalDate>> it = artigos_vendidos.entrySet().iterator();
        String aux;
        Collection<String> result = new HashSet<>();
        while(it.hasNext()){
            aux = it.next().getKey();
            result.add(aux);
        }
        return result;
    }

    public void setArtigos_vendidos( Map<String, LocalDate> artigos_vendidos) {
        this.artigos_vendidos = artigos_vendidos;
    }

    public Set<String> getArtigos_para_venda() {
        return this.artigos_para_venda;
    }

    public void setArtigos_para_venda(Set<String> artigos_para_venda) {
        this.artigos_para_venda = artigos_para_venda;
    }

    public Encomenda getEncomenda() {
        return this.encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }
    
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Utilizador that = (Utilizador) object;
        return this.id == that.getId()
            && this.email.equals(that.getEmail()) 
            && this.nome.equals(that.getNome()) 
            && this.morada.equals(that.getMorada()) 
            && this.nif == that.getNif()
            && this.artigos_comprados.equals(that.getArtigos_comprados()) 
            && this.artigos_vendidos.equals(that.getArtigos_vendidos()) 
            && this.artigos_para_venda.equals(that.getArtigos_para_venda());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getEmail(), getNome(), getMorada(), getNif(), getArtigos_comprados(), getArtigos_vendidos(), getArtigos_para_venda(), getDinheiro_faturado(), getEncomenda());
    }


    @Override
    public String toString() {
        return "\n{" +
            " NOME='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", id='" + getId() + "'" +
            ", morada='" + getMorada() + "'" +
            ", nif='" + getNif() + "'" +
            ", artigos_comprados='" + getID_Artigos_comprados() + "'" +
            ", artigos_vendidos='" + getID_Artigos_vendidos() + "'" +
            ", artigos_para_venda='" + getArtigos_para_venda() + "'" +
            "}";
    }

    private void updatePreço(double preço){
        double dinheiro = getDinheiro_faturado();
        setDinheiro_faturado(dinheiro + preço);
    }


    public Utilizador clone(){
        return new Utilizador(this);
    }

    public boolean verificaId(int id_utilizador){
        return (this.id == id_utilizador);
    }

    public void addArtigoParaVenda(String cod){
        this.artigos_para_venda.add(cod);
    }

    public void finalização_de_encomenda(double preço, String artigo_id){
        updatePreço(preço);
        artigos_para_venda.remove(artigo_id);
        artigos_vendidos.put(artigo_id, Vintage.getTime());
    }

    public void devolverArtigoVendedor(String artigo, double preço){
        artigos_vendidos.remove(artigo);
        artigos_para_venda.add(artigo);
        dinheiro_faturado -= preço;
    }

    public void devolverArtigoUtilizador(String artigo){
        artigos_comprados.remove(artigo);
    }

    public void corrigirPreçoComprador(double preço){
        this.dinheiro_gasto -= preço;
    }

    public void removeArtigoFromComprados(String artigo){
        artigos_comprados.remove(artigo);
    }

    public void addToComprados(String artigo){
        artigos_comprados.put(artigo, Vintage.getTime());
    }
    
    public void addToDinheiroGasto(double dinheiro){
        dinheiro_gasto += dinheiro;
    }

    private Collection<Double> filterMapArtigosByDate(Map<String, LocalDate> map, LocalDate date1, LocalDate date2, Vintage vintage){
        return map.entrySet().stream().
        filter(entry -> (entry.getValue().isAfter(date1) || entry.getValue().isEqual(date1)) && (entry.getValue().isEqual(date2) || entry.getValue().isBefore(date2))).
        map(entry -> vintage.getArtigos().getArtigoById(entry.getKey()).precoartigo()).collect(Collectors.toList());
    }

    public Pair<String, Double>getDadosVendedorEntreDatas(LocalDate date1, LocalDate date2, Vintage vintage){
        return new Pair<String, Double>(this.getNome(), filterMapArtigosByDate(getArtigos_vendidos(), date1, date2, vintage).stream().reduce(0.0, Double::sum));
    }

    public  Pair<String, Double> getDadosCompradorEntreDatas(LocalDate date1, LocalDate date2, Vintage vintage){
        return new Pair<String, Double>(this.getNome(), filterMapArtigosByDate(getArtigos_comprados(), date1, date2, vintage).stream().reduce(0.0, Double::sum));
    }
}
