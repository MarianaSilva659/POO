public interface Interface {
    boolean novoUtilizador(String email, String nome, String morada, int nif);
    boolean novoTransporte(double peq, double med, double gra, int margem, boolean aceitaPremium, int id);
}
