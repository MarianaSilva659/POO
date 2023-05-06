public class TSirtLisa extends TShirt{

    public TSirtLisa(){
        super();
    }

    public TSirtLisa(TSirtLisa t){
        super(t);
    }

    public TSirtLisa(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, Tamanho tamanho, String padrao) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
    }

    public TSirtLisa clone(){
        return new TSirtLisa(this);
    }

    public double precoartigo(){
        return getPrecoBase();
    }
}
