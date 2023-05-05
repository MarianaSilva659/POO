import java.util.Map;
import java.util.TreeMap;

public class GestorUtilizadores{
    private Map<Integer, Utilizador> contas;

    public GestorUtilizadores(){
        this.contas = new TreeMap<>();
    }

    public GestorUtilizadores(GestorUtilizadores c){
        this.contas = c.getContas();
    }

    public Map<Integer, Utilizador> getContas(){
        TreeMap<Integer, Utilizador> copia = new TreeMap<>();

        for(Map.Entry<Integer, Utilizador> c : contas.entrySet()){
            copia.put(c.getKey(), c.getValue().clone());
        }
        return copia;
    }

    public void setContas(Map<Integer, Utilizador> contas){
        TreeMap<Integer, Utilizador> copia = new TreeMap<>();

        for (Map.Entry<Integer, Utilizador> c : contas.entrySet()) {
            Integer key = c.getKey();
            Utilizador value = c.getValue().clone();
            copia.put(key, value);
        }
            this.contas = copia;
    }

    public void addConta(Utilizador conta){
        this.contas.put(conta.getId(), conta.clone());
    }

    public GestorUtilizadores clone(){
        return new GestorUtilizadores(this);
    }

    public Utilizador getContaByCod(int cod){
        if(contas.containsKey(cod)) return contas.get(cod).clone();
        else return null;
    }

    public Utilizador geContaByEmail(String email){
        Utilizador conta = null;
        for(Map.Entry<Integer, Utilizador> c : contas.entrySet()){
            if(email.equals(c.getValue().getEmail())){
                conta = c.getValue();
            }
        }
        if(conta != null) return conta.clone();
        else return null;
    }

    public String getIdNewUtilizador(){
        String newId = "";
        for(Map.Entry<String, Utilizador> c : contas.entrySet()){

        }
    }

}
