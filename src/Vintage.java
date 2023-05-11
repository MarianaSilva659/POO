
public class Vintage {
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
        System.out.println("idd");
        int id = this.utilizadores.getIdNewUtilizador();
        System.out.println("idd" + id);
        Utilizador novo = new Utilizador(id, email, nome, morada, nif);
        if(this.utilizadores.existeConta(email) == false){
            this.utilizadores.addConta(novo);
            System.out.println(utilizadores);
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
            System.out.println(transportes);
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
        System.out.println(transportes);
    }

    public Transportadora getTransporte(int id){
        return this.transportes.getTransportadoraById(id);
    }

    public int getIdUtilizador(String email){
        return this.utilizadores.getIdByEmail(email);
    }

    public boolean addMalaPadrao(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material){
        if(this.artigos.existe_Artigo(cod) == false){
            Malas a = new Malas(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material);
            this.artigos.addPra_venda(a, id_utilizador);
            System.out.println(a);
            return true;
        }else return false;
    }

    public boolean addMalaPremium(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material, double valorizacao){
        if(this.artigos.existe_Artigo(cod) == false){
            MalasPremium a = new MalasPremium(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_utilizador, id_transporte, ano, altura, largura, profundidade, material, valorizacao);
            this.artigos.addPra_venda(a, id_utilizador);
            return true;
        }else return false;
    }

    public boolean addSapatilhasPadrao(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano){
            if(this.artigos.existe_Artigo(cod) == false){
            Sapatilhas s = new Sapatilhas(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano);
            this.artigos.addPra_venda(s, id_utilizador);
            return true;
        }else return false;
    }

    public boolean addSapatilhasPremium(int numeroDonos, String descricao, String marca, String cod, double precoBase, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano, String autores){
            if(this.artigos.existe_Artigo(cod) == false){
            Sapatilhas s = new SapatilhasPremium(numeroDonos, descricao, marca, cod, precoBase, avaliacao, id_utilizador, id_transporte, detalhe, tamanho, cor, ano, autores);
            this.artigos.addPra_venda(s, id_utilizador);
            return true;
        }else return false;
    }

    public void mostraTransportes(){
        System.out.println(transportes);
    }

    public boolean addTShirt(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false){
            TShirt t = new TShirt(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_utilizador, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_transporte);
            return true;
        }else return false;
    }

    public boolean addTShirtLisa(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false){
            TShirtLisa t = new TShirtLisa(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_utilizador, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_transporte);
            return true;
        }else return false;
    }

    public boolean addTShirtRiscas(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false){
            TShirtRiscas t = new TShirtRiscas(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_utilizador, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_transporte);
            return true;
        }else return false;
    }

    public boolean addTShirtPalmeiras(int numeroDonos, String descricao, String marca, String cod, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao){
        if(this.artigos.existe_Artigo(cod) == false){
            TShirtPalmeiras t = new TShirtPalmeiras(numeroDonos, descricao, marca, cod, precoBase, desconto, avaliacao, id_utilizador, id_transporte,tamanho, padrao);
            this.artigos.addPra_venda(t, id_transporte);
            return true;
        }else return false;
    }
}
