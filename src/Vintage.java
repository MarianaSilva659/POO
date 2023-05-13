<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
=======
import java.util.Collection;
>>>>>>> 8293e3b (Adição das encomendas e ligeiras otimizações)

public class Vintage implements Serializable {
    private GestorArtigos artigos;
    private GestorUtilizadores utilizadores;
    private GestorTransportes transportes;


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
    }
    
    public void novoValorMED(double med, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setValorBase_MED(med);
        this.transportes.setTransporte(t);
    }

    public void novoValorGRA(double gra, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setValorBase_GRA(gra);
        this.transportes.setTransporte(t);
    }

    public void novaMargemLucro(double margem, int id){
        Transportadora t = this.transportes.getTransportadoraById(id);
        t.setMargemLucro(margem);
        this.transportes.setTransporte(t);
        System.out.println(transportes);
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

<<<<<<< HEAD
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
//devolve o valor total do artigos que um utilizador vendeu
    public double getValorTotalArtigosVendidos(Set<String> vendidos){
        Iterator<String> iteratorartigos = vendidos.iterator();
        String codArtigo;
        Artigo artigo;
        double valorArtigosVendidos = 0;
        while(iteratorartigos.hasNext()){
            codArtigo = iteratorartigos.next();
            artigo = this.artigos.getArtigoById(codArtigo);
            valorArtigosVendidos += artigo.precoartigo();
        }
        return valorArtigosVendidos;
    }
//. qual é o vendedor que mais facturou
    public void getMaiorVendedor(){
        Map<Integer, Utilizador> aqui = this.utilizadores.getContas();
        Iterator<Map.Entry<Integer, Utilizador>> iterator = aqui.entrySet().iterator();
        Map.Entry<Integer,Utilizador> c;
        Utilizador maisFaturou = new Utilizador();
        Utilizador vendedor;
        double valor, maior = 0;
        while(iterator.hasNext()){
            c = iterator.next();
            vendedor = c.getValue();

            valor = getValorTotalArtigosVendidos(vendedor.getArtigos_pra_venda());
            System.out.println(vendedor.getNome() + "faturou " + valor + '€');
            if(valor > maior){
                maisFaturou = vendedor.clone();
                maior = valor;
            }
        }
        System.out.println(maisFaturou.getNome() + " faturou um total de " + maior + '€');
=======
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

    public  Collection<Pair < String , Integer>> getVendedores(Collection<String> artigosID){
       return this.artigos.getVendedores(artigosID);
    }

    public  Pair < String , Integer> getVendedores(String artigosID){
        return this.artigos.getVendedores(artigosID);
     }

    public void devolverArtigos(Collection<Pair < String ,Integer>> dados_de_devolução, Collection<String> conjuntoDeArtigos){
        utilizadores.devolverArtigos(dados_de_devolução);
        artigos.devolveArtigos(conjuntoDeArtigos);
    }

    public void devolverArtigos(Pair < String ,Integer> dados_de_devolução){
        utilizadores.devolverArtigos(dados_de_devolução);
        artigos.devolveArtigos(dados_de_devolução.getFirst());
    }

    public void updateArtigo(String id){
        artigos.updateArtigo(id);
>>>>>>> 8293e3b (Adição das encomendas e ligeiras otimizações)
    }
}
