public class TShirtPalmeiras extends TShirt{
    public TShirtPalmeiras(){
        super();
    }

    public TShirtPalmeiras(TShirtPalmeiras t){
        super(t);
    }

    public TShirtPalmeiras(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String tamanho, String padrao) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, id_transporte, tamanho, padrao);
    }

    public TShirtPalmeiras clone(){
        return new TShirtPalmeiras(this);
    }

    public double precoartigo(){
        double preco = 0.0;
        if(getNumeroDonos() > 0){
            preco = getPrecoBase() * 0.5;
        }
        else{
            preco = getPrecoBase()*((100-getDesconto())/100);
        }
        return preco;
    }

    @Override
    public String toString() {
        return "\nTSHIRT PALMEIRAS: " + super.toString();
    }

}
