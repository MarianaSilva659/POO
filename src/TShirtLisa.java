public class TShirtLisa extends TShirt{

    public TShirtLisa(){
        super();
    }

    public TShirtLisa(TShirtLisa t){
        super(t);
    }

    public TShirtLisa(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, Tamanho tamanho, String padrao) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
    }

    public TShirtLisa clone(){
        return new TShirtLisa(this);
    }

    public double precoartigo(){
        return getPrecoBase();
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
            "}";
    }

}