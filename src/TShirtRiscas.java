public class TShirtRiscas extends TShirt{

    public TShirtRiscas(){
        super();
    }

    public TShirtRiscas(TShirtRiscas t){
        super(t);
    }

    public TShirtRiscas(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, Tamanho tamanho, String padrao) {
        super(numeroDonos, descricao, marca, id, precoBase, desconto, avaliacao, id_utilizador, tamanho, padrao);
    }

    public TShirtRiscas clone(){
        return new TShirtRiscas(this);
    }

    public double precoartigo(){
        double preco = 0.0;
        if(getNumeroDonos() > 0){
            preco = getPrecoBase() * 0.5;
        }
        else{
            preco = getPrecoBase() *((100-getDesconto())/100);
        }
        return preco;
    }
}
