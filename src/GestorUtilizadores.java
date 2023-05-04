import java.util.Map;
import java.util.TreeMap;

public class GestorUtilizadores{
    private Map<String, Utilizador> contas;

    public GestorUtilizadores(){
        this.contas = new TreeMap<>();
    }

    public GestorUtilizadores(GestorUtilizadores c){
        this.contas = c.getContas();
    }

    public Map<String, Utilizador> getContas(){
        TreeMap<String, Utilizador> copia = new TreeMap<>();

        for(Map.Entry<String, Utilizador> c : contas.entrySet()){
            copia.put(c.getKey(), c.getValue().clone());
        }
        return copia;
    }

    public void setContas(Map<String, Utilizador> contas){
        TreeMap<String, Utilizador> copia = new TreeMap<>();

        for (Map.Entry<String, Utilizador> c : contas.entrySet()) {
            String key = c.getKey();
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

    public Utilizador getContaByCod(String cod){
        if(contas.containsKey(cod)) return contas.get(cod).clone();
        else return null;
    }

    public Utilizador geContaByEmail(String email){
        Utilizador conta = null;
        for(Map.Entry<String, Utilizador> c : contas.entrySet()){
            if(email.equals(c.getValue().getEmail())){
                conta = c.getValue();
            }
        }
        if(conta != null) return conta.clone();
        else return null;
    }


}
