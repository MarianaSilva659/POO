import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;
import java.util.Iterator;
import java.util.Collection;

public class Vintage implements Serializable {
    private GestorArtigos artigos;
    private GestorUtilizadores utilizadores;
    private GestorTransportes transportes;
    private static double imposto;
    private static LocalDate data;
    private static double lucro;


    public Vintage() {
        this.artigos = new GestorArtigos();
        this.utilizadores = new GestorUtilizadores();
        this.transportes = new GestorTransportes();
    }

    public Vintage(Vintage v){
        this.artigos = v.artigos;
        this.utilizadores = v.utilizadores;
        this.transportes = v.transportes;
    }

    public static double getLucro(){
        return lucro;
    }

    public static void setLucro(double valor){
        lucro = valor;
    }

    public static void addLucro(double valor){
        lucro+=valor;
    }

    public static void subLucro(double valor){
        lucro-=valor;
    }

    public static void avançarTempo(int dias){
        Vintage.setTime(Vintage.getTime().plusDays(dias));
    }

    public GestorArtigos getArtigos() {
        return this.artigos;
    }

    public void setArtigos(GestorArtigos artigos) {
        this.artigos = artigos;
    }

    public GestorUtilizadores getUtilizadores() {
        return this.utilizadores;
    }

    public void setUtilizadores(GestorUtilizadores utilizadores) {
        this.utilizadores = utilizadores;
    }

    public GestorTransportes getTransportes() {
        return this.transportes;
    }

    public void setTransportes(GestorTransportes transportes) {
        this.transportes = transportes;
    }

    public static double getImposto(){
        return imposto;
    }

    public static void setImposto(double novoimposto){
        imposto = novoimposto;
    }
    
    public static LocalDate getTime(){
        LocalDate atualizaDate = LocalDate.now();
        if (data.isBefore(atualizaDate)){
            data = atualizaDate;
        }
        return data;
    }

    public static void setTime(LocalDate time){
        data = time;
    }

    public boolean existeContaU(String email){
        return this.utilizadores.existeConta(email);
    }

    public String addContaVintage(String email, String nome, String morada, int nif){
        int id = this.utilizadores.getIdNewUtilizador();
        Utilizador novo = new Utilizador(id, email, nome, morada, nif);
        if(this.utilizadores.existeConta(email) == false){
            this.utilizadores.addConta(novo);
            System.out.println(novo);
            return email;
        }
        else return null;
    }


    public boolean existeContaT(int id){
        return this.transportes.existe_Transportadora(id);
    }

    public int addTransporteVintage(double peq, double med, double gra, int margem, boolean aceitaPremium, int id){
        Transportadora novo = new Transportadora(peq, med, gra, margem, aceitaPremium, id);
        if(this.transportes.existe_Transportadora(id) == false){ 
            this.transportes.addTransporte(novo);
            System.out.println(novo);
            return id;
        }
        return -1;
    }

    public void novoValorPEQ(double peq, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setValorBase_PEQ(peq);
        this.transportes.setTransporte(t);
        System.out.println(t);
    }
    
    public void novoValorMED(double med, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setValorBase_MED(med);
        this.transportes.setTransporte(t);
        System.out.println(t);
    }

    public void novoValorGRA(double gra, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setValorBase_GRA(gra);
        this.transportes.setTransporte(t);
        System.out.println(t);
    }

    public void novaMargemLucro(double margem, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setMargemLucro(margem);
        this.transportes.setTransporte(t);
        System.out.println(t);
    }

    public void novoValoresTransporte(double peq, double med, double gra, double margem, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setValorBase_PEQ(peq);
        t.setValorBase_MED(med);
        t.setValorBase_GRA(gra);
        t.setMargemLucro(margem);
        this.transportes.setTransporte(t);
        System.out.println(t);
    }

    public Transportadora getTransporte(int id){
        return this.transportes.getTransportadoraById(id);
    }

    public int getIdUtilizador(String email){
        return this.utilizadores.getIdByEmail(email);
    }

    public boolean addMalaPadrao(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_vendedor, int id_transporte, int ano, double altura, double largura, double profundidade, String material){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            Malas a = new Malas(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_vendedor, id_transporte, ano, altura, largura, profundidade, material);
            this.artigos.addPra_venda(a, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(a);
            return true;
        }else return false;
    }

    public boolean addMalaPremium(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_vendedor, int id_transporte, int ano, double altura, double largura, double profundidade, String material, double valorizacao){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            MalasPremium a = new MalasPremium(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_vendedor, id_transporte, ano, altura, largura, profundidade, material, valorizacao);
            this.artigos.addPra_venda(a, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(a);
            return true;
        }else return false;
    }

    public boolean addSapatilhasPadrao(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_vendedor, int id_transporte, String detalhe , int tamanho, String cor, int ano){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            Sapatilhas s = new Sapatilhas(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_vendedor, id_transporte, detalhe, tamanho, cor, ano);
            this.artigos.addPra_venda(s, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(s);
            return true;
        }else return false;
    }

    public boolean addSapatilhasPremium(int numeroDonos, String descricao, String marca, String cod, double precoBase, double avaliacao, int id_vendedor, int id_transporte, String detalhe , int tamanho, String cor, int ano, String autores){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            Sapatilhas s = new SapatilhasPremium(numeroDonos, descricao, marca, cod, precoBase, avaliacao, id_vendedor, id_transporte, detalhe, tamanho, cor, ano, autores);
            this.artigos.addPra_venda(s, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(s);
            return true;
        }else return false;
    }

    public void mostraTransportes(int opcao){
        if(opcao == 2 || opcao == 4)
        System.out.println(transportes.getTransportesPremium().values().toString());
        else System.out.println(transportes.toString());
    }

    public void mostraTodosArtigos(){
        System.out.println(artigos.getProdutos_pra_venda());
    }

    public boolean addTShirt(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_vendedor, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            TShirt t = new TShirt(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_vendedor, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(t);
            return true;
        }else return false;
    }

    public boolean addTShirtLisa(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_vendedor, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            TShirtLisa t = new TShirtLisa(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_vendedor, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(t);
            return true;
        }else return false;
    }

    public boolean addTShirtRiscas(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_vendedor, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            TShirtRiscas t = new TShirtRiscas(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_vendedor, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(t);
            return true;
        }else return false;
    }

    public boolean addTShirtPalmeiras(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_vendedor, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false && existeContaT(id_transporte) == true){
            TShirtPalmeiras t = new TShirtPalmeiras(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_vendedor, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_vendedor);
            this.utilizadores.getContaByCod(id_vendedor).addArtigoParaVenda(cod);
            System.out.println(t);
            return true;
        }else return false;
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeDouble(imposto);
        out.writeDouble(lucro);
        out.writeObject(data);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        imposto = in.readDouble();
        lucro = in.readDouble();
        data = (LocalDate)in.readObject();
    }

    public static Vintage loadState (String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        Vintage f = (Vintage) ois.readObject();
        ois.close();
        return f;
    }

    public void saveState (String filename) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public Collection<Double> getPreçoArtigos(Collection<String> collection){
        return this.artigos.getPreçoArtigos(collection);
    }

    public Collection<Integer> getTransportadoras(Collection<String> collection){
        return artigos.getTransportadoras(collection);
    }

    public double getPreçoTransportadora(int id, int num_artigos){
        return transportes.getPreçoTransportadora(id, num_artigos);
    }

    public Collection<Pair<Integer, Pair <String,Double>>> getDadosDeVenda(Collection<String> collection){
        return artigos.getDadosDeVenda(collection);
    }

    public void updateVendedores(Collection<Pair<Integer, Pair <String,Double>>> dadosDeVenda){
        utilizadores.updateVendedores(dadosDeVenda);
    }

    public void devolverArtigosVendedor(Collection<Pair<Integer, Pair <String,Double>>> dadosDeVenda){
        utilizadores.devolverArtigosVendedor(dadosDeVenda);
    }

    public  Collection<Pair < String , Integer>> getVendedores(Collection<String> artigosID){
       return this.artigos.getVendedores(artigosID);
    }

    public  Pair < String , Integer> getVendedores(String artigosID){
        return this.artigos.getVendedores(artigosID);
     }

    public void cancelarEncomenda(Collection<String> conjuntoDeArtigos){
        artigos.cancelarEncomenda(conjuntoDeArtigos);
    }


    public void cancelarArtigo(String artigoID){
        artigos.cancelarArtigo(artigoID);
    }

    public void updateArtigo(String id){
        artigos.updateArtigo(id);
    }

    public boolean addArtigoEncomenda(String cod, int id_comprador){
        boolean valido = this.artigos.existe_Artigo_pra_venda_id(cod);
        if(valido == true) this.utilizadores.getContaByCod(id_comprador).getEncomenda().addArtigo(cod, this);
        System.out.println(this.utilizadores.getContaByCod(id_comprador).getEncomenda());
        return valido; //falso não pode comprar
    }

    public String getEmailById(int id){
        return this.utilizadores.getEmailById(id);
    }


    public boolean devolverEncomenda(int id_comprador){
        if((this.utilizadores.getContaByCod(id_comprador).getEncomenda().getData() != null) && (this.utilizadores.getContaByCod(id_comprador).getEncomenda().isVazia() == false) && (podeDevolverEnc(this.utilizadores.getContaByCod(id_comprador).getEncomenda().getData()))){
            this.utilizadores.getContaByCod(id_comprador).getEncomenda().devolverEncomenda(this);
            System.out.println(this.utilizadores.getContaByCod(id_comprador).getEncomenda());
            return true;
        }
        else return false;
    }

    public boolean cancelarEncomenda(int id_comprador){
        if(this.utilizadores.getContaByCod(id_comprador).getEncomenda().getData() == null){
            this.utilizadores.getContaByCod(id_comprador).getEncomenda().cancelarEncomenda(this);
            System.out.println(this.utilizadores.getContaByCod(id_comprador).getEncomenda());
            return true;
        }
        else return false;
    }

    public boolean finalizaEnc(int id_comprador){
        if((this.utilizadores.getContaByCod(id_comprador).getEncomenda().getData() == null) && (this.utilizadores.getContaByCod(id_comprador).getEncomenda().isVazia() == false)){
            double precoAPagar = this.utilizadores.getContaByCod(id_comprador).getEncomenda().finalizarCompra(this);
            System.out.println(this.utilizadores.getContaByCod(id_comprador).getEncomenda());
            System.out.println("Preço a pagar pela encomenda = " + precoAPagar + '€');
            return true;
        }else return false;
    }

    public boolean podeDevolverEnc(LocalDate dataFinalizacao){
        Duration duracao = Duration.between(dataFinalizacao.atStartOfDay(), data.atStartOfDay());
        long diferencaHoras = duracao.toHours();

        return (diferencaHoras < 48);
    }

    public void mostraEncomenda(int id){
        System.out.println(this.utilizadores.getContaByCod(id).getEncomenda());
    }

    public void finalizarArtigos(Collection<String> artigosID){
        artigos.finalizarArtigos(artigosID);
    }

    public void updateComprador(Collection<String> artigosID, int id, double preço){
        utilizadores.updateComprador(artigosID, id, preço);
    }

    public boolean cancelaArtigoEnc(int id, String cod){
        if(this.utilizadores.getContaByCod(id).getEncomenda().existe_ArtigoEnc(cod) == true){
            this.utilizadores.getContaByCod(id).getEncomenda().cancelarArtigo(this, cod);
            System.out.println(this.utilizadores.getContaByCod(id).getEncomenda());
        return true;
        }
        else return false;
    }

    public boolean finalizarEnc(int id_comprador){
        if(this.utilizadores.getContaByCod(id_comprador).getEncomenda().isVazia() == false){
         this.utilizadores.getContaByCod(id_comprador).getEncomenda().finalizarCompra(this);
        return true;
        }
        else return false;
    }


    public double getPrecoEncomenda(int id_comprador){
        return this.utilizadores.getContaByCod(id_comprador).getEncomenda().calculaPreço(this);
    }

    //ARTIGOS VENDIDOS DE UM UTILIZADOR
    public void encomendaEmitidasVendedor(int id_vendedor){
        Collection<String> artigos = this.utilizadores.getContaByCod(id_vendedor).getID_Artigos_vendidos();
        Iterator<String> iterator = artigos.iterator();
        String id_artigo;
        while(iterator.hasNext()){
            id_artigo = iterator.next();
            System.out.println(this.artigos.getArtigoById(id_artigo));
        }
    }

   public void updateTransportadora(Map<Integer, Integer> transportadora){
    transportes.updateTransportadora(transportadora);
   }

   public void corrigirTransportadoras(Map<Integer, Integer> transportadora){
    transportes.corrigirTransportadoras(transportadora);
   }

   public void updateVintage(Collection<String> artigosID){
    int novos = artigos.getNumNovos(artigosID);
    int usados = artigos.getNumUsados(artigosID);
    Vintage.addLucro(0.5 * novos + 0.25 * usados);
   }

   public void removeLucroFromVintage(Collection<String> artigosID){
    int novos = artigos.getNumNovos(artigosID);
    int usados = artigos.getNumUsados(artigosID);
    Vintage.subLucro(0.5 * novos + 0.25 * usados);
   }

   public void devolverArtigos(Collection<String> artigosID){
    artigos.devolverEncomenda(artigosID);
   }

   public void corrigirUtilizador(Collection<String> artigos,double preço, int id){
    utilizadores.corrigirUtilizador(artigos, preço, id);
   }

   public void lucroVintage(){
    System.out.println("A Vintage já ganhou " + Vintage.getLucro() + '€');
   }

    public void getMaiorVendedor(){
        Utilizador vendedorMaisfaturou = this.utilizadores.getMaiorVendedor();
        System.out.println("Vendedor " + vendedorMaisfaturou.getNome() + " faturou um total de " + vendedorMaisfaturou.getDinheiro_faturado() + '€');
    }

    public boolean getMelhorVendedor(LocalDate date1, LocalDate date2){
        if(!this.utilizadores.isVazio()){
            if((date1 == null) && (date2 == null)){
                getMaiorVendedor();
            }
            else{
                Pair<String, Double> vendedor = this.utilizadores.getMelhorVendedorEntreDuasDatas(date1, date2, this);
                System.out.println("Vendedor " + vendedor.getFirst() + " faturou um total de " + vendedor.getSecond() + '€');
            }
            return true;
        }
        else return false;   
   }

   public boolean getMelhoresVendedores(LocalDate date1, LocalDate date2){
    if(!this.utilizadores.isVazio()){
        Map<String, Double> vendedores = this.utilizadores.getMelhoresVendedoresEntreDuasDatas(date1, date2, this);
        Iterator<Map.Entry<String, Double>> iterator = vendedores.entrySet().iterator();

        while (iterator.hasNext()) {
                Map.Entry<String, Double> entry = iterator.next();
                String vendedor = entry.getKey();
                Double valor = entry.getValue();
                System.out.println("Vendedor: " + vendedor + ", Valor: " + valor);
        }
        return true;
    }
    else return false;   
}

public boolean getMelhoresCompradoresEntreDuasDatas(LocalDate date1, LocalDate date2){
    if(!this.utilizadores.isVazio()){
        Map<String, Double> vendedores = this.utilizadores.getMelhoresCompradoresEntreDuasDatas(date1, date2, this);
        Iterator<Map.Entry<String, Double>> iterator = vendedores.entrySet().iterator();

        while (iterator.hasNext()) {
                Map.Entry<String, Double> entry = iterator.next();
                String vendedor = entry.getKey();
                Double valor = entry.getValue();
                System.out.println("Compradores: " + vendedor + ", Valor: " + valor);
        }
        return true;
    }
    else return false;   
}

   
}
