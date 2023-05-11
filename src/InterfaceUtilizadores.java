public interface InterfaceUtilizadores {
    boolean addMalaPadrao(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material);
    boolean addMalaPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, int ano, double altura, double largura, double profundidade, String material, double valorizacao);
    boolean addSapatilhasPadrao(int numeroDonos, String descricao, String marca, String id, double precoBase, double desconto, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano);
    boolean addSapatilhasPremium(int numeroDonos, String descricao, String marca, String id, double precoBase, double avaliacao, int id_utilizador, int id_transporte, String detalhe , int tamanho, String cor, int ano, String autores);

}
