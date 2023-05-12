import java.util.Collections;
import java.util.Iterator;
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
        Iterator<Map.Entry<Integer, Utilizador>> iterator = contas.entrySet().iterator();
        Map.Entry<Integer,Utilizador> c;

        while(iterator.hasNext()){
            c = iterator.next();

            copia.put(c.getKey(), c.getValue());
        }
        return copia;
    }

    public void setContas(Map<Integer, Utilizador> contas){
        TreeMap<Integer, Utilizador> copia = new TreeMap<>();
        Iterator<Map.Entry<Integer, Utilizador>> iterator = contas.entrySet().iterator();
        Map.Entry<Integer,Utilizador> c;

        while(iterator.hasNext()){
            c = iterator.next();

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

    public Utilizador getContaByCod(int id){
        if(contas.containsKey(id)) return contas.get(id).clone();
        else return null;
    }

    public Utilizador getContaByEmail(String email){
        Utilizador conta = null;
        Iterator<Map.Entry<Integer, Utilizador>> iterator = contas.entrySet().iterator();
        Map.Entry<Integer,Utilizador> c;

        while(iterator.hasNext()){
            c = iterator.next();

            if(email.equals(c.getValue().getEmail())){
                conta = c.getValue();
            }
        }
        if(conta != null) return conta.clone();
        else return null;
    }

    public boolean existeConta(String email){
        Iterator<Map.Entry<Integer, Utilizador>> iterator = contas.entrySet().iterator();
        Map.Entry<Integer,Utilizador> c;

        while(iterator.hasNext()){
            c = iterator.next();

            if(email.equals(c.getValue().getEmail())){
                return true;
            }
        }
        return false;
    }

    public int getIdNewUtilizador(){
        int newId = 0;
        Iterator<Map.Entry<Integer, Utilizador>> iterator = contas.entrySet().iterator();
        Map.Entry<Integer,Utilizador> c;
        while(iterator.hasNext()){
            c = iterator.next();
            newId = c.getKey();
        }
        return newId+1;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Contas: ").append(contas.toString()).append('\n');
        return sb.toString();
    }

    public int getIdByEmail(String email){
            Iterator<Map.Entry<Integer, Utilizador>> iterator = contas.entrySet().iterator();
            Map.Entry<Integer,Utilizador> c;
            int id = -1;
            while(iterator.hasNext()){
                c = iterator.next();
    
                if(email.equals(c.getValue().getEmail())){
                     id = c.getKey();
                }
            }
            return id;
    }

}
