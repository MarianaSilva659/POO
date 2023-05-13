import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;

public class GestorUtilizadores implements Serializable{
    private Map<Integer, Utilizador> contas;
    private int id;

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

    private Utilizador getContaById(int id){
        if(contas.containsKey(id)) return contas.get(id);
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
        id++;
        return id;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("UTILIZADORES: ").append(contas.toString()).append('\n');
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


    public void updateVendedores(Collection<Pair<Integer, Pair <String,Double>>> dadosDeVenda){
        Iterator<Pair<Integer, Pair<String,Double>>> it = dadosDeVenda.iterator();
        Pair<Integer, Pair<String,Double>> pair = new Pair<>();
        Utilizador utilizador;
        while(it.hasNext()){
            pair = it.next();
            utilizador = getContaById(pair.getFirst());
            utilizador.finalização_de_encomenda(pair.getSecond().getSecond(), pair.getSecond().getFirst());
        }
    }

    public void devolverArtigosVendedor(Collection<Pair < String ,Integer>> dados_de_devolução){
        Iterator<Pair<String, Integer>> it = dados_de_devolução.iterator();
        Pair<String, Integer> pair = new Pair<>(); 
        Utilizador utilizador;
        while(it.hasNext()){
            pair = it.next();
            utilizador = getContaById(pair.getSecond());
            utilizador.devolverArtigoVendedor(pair.getFirst());
        }
    }

    public void devolverArtigosVendedor(Pair < String ,Integer> dados_de_devolução){
        Utilizador utilizador;
            utilizador = getContaById(dados_de_devolução.getSecond());
            utilizador.devolverArtigoVendedor(dados_de_devolução.getFirst());
    }

    public void devolverArtigosComprador(Collection<String> artigosID, int id_comprador){
        Iterator<String> it = artigosID.iterator();
        String aux;
        Utilizador utilizador = this.getContaById(id_comprador);
        while(it.hasNext()){
            aux = it.next();
            utilizador.removeArtigoFromComprados(aux);
        }
    }

    public void devolverArtigosComprador(String artigosID, int id_comprador){
        Utilizador utilizador = this.getContaById(id_comprador);
            utilizador.removeArtigoFromComprados(artigosID);
    }

    public String getEmailById(int id){
        Utilizador utilizador = contas.get(id);
        String email = utilizador.getEmail();
        return email;
    }

}
