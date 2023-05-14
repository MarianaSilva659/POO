import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Iterator;

public class GestorTransportes implements Serializable {
    private Map<Integer, Transportadora> transportes;


    public GestorTransportes(){
        this.transportes = new TreeMap<>();
    }

    public GestorTransportes(GestorTransportes t){
        this.transportes = t.getTransportes();
    }

    public Map<Integer,Transportadora> getTransportes() {
        TreeMap<Integer, Transportadora> copia = new TreeMap<>();
        Iterator<Map.Entry<Integer, Transportadora>> iterator = transportes.entrySet().iterator();
        Map.Entry<Integer,Transportadora> c;

        while(iterator.hasNext()){
            c = iterator.next();

            copia.put(c.getKey(), c.getValue());
        }
        return copia;
    }

    public void setTransportes(Map<Integer,Transportadora> transportes) {
        TreeMap<Integer, Transportadora> copia = new TreeMap<>();
        Iterator<Map.Entry<Integer, Transportadora>> iterator = transportes.entrySet().iterator();
        Map.Entry<Integer,Transportadora> c;

        while(iterator.hasNext()){
            c = iterator.next();

            Integer key = c.getKey();
            Transportadora value = c.getValue().clone();
            copia.put(key, value);
        }
            this.transportes = copia;
    }
    
    public GestorTransportes clone(){
        return new GestorTransportes(this);
    }

    boolean existe_Transportadora(int id){
        return transportes.containsKey(id);
    }

    public void addTransporte(Transportadora t){
        this.transportes.put(t.getIdTransporte(), t.clone());
    }

    public int getIdNewTransportadora(){
        int newId = 0;
        Iterator<Map.Entry<Integer, Transportadora>> iterator = transportes.entrySet().iterator();
        Map.Entry<Integer,Transportadora> n;
        
        while(iterator.hasNext()){
            n = iterator.next();
            
                newId = n.getKey();
        }
        return newId++;
    }

    public Transportadora getTransportadoraById(int id){
        if(transportes.containsKey(id)) return transportes.get(id).clone();
        else return null;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("TRANSPORTES: \n").append(transportes.values().toString()).append('\n');
        return sb.toString();
    }

   

    public void setTransporte(Transportadora t){
        this.transportes.put(t.getIdTransporte(), t.clone());
    }

    public int QuantidadeTransportes(){
        return this.transportes.size();
    }

    public Map<Integer,Transportadora> getTransportesPremium(){
        Map<Integer, Transportadora> transportesPremium = new TreeMap<>();
        Iterator<Map.Entry<Integer, Transportadora>> iterator = transportes.entrySet().iterator();
        Map.Entry<Integer, Transportadora> t;
        while (iterator.hasNext()){
            t = iterator.next();
            Transportadora transportadora = t.getValue();

            if (transportadora.isPremium() == true) {
                transportesPremium.put(t.getKey(), transportadora);
            }
        }
        return transportesPremium;
    }

    public double getPreçoTransportadora(int id, int num_artigos){
        Transportadora t = getTransportadoraById(id);
      return t.getPrecoEncomenda(num_artigos);
}

    public void updateTransportadora(Map<Integer, Integer> transportadora){
        Iterator<Map.Entry<Integer, Integer>> it = transportadora.entrySet().iterator();
        Map.Entry<Integer, Integer> aux;
        Transportadora t;
        while(it.hasNext()){
            aux = it.next();
            t = transportes.get(aux.getKey());
            t.updateTransportadora(aux.getValue());
        }
    }

    public void corrigirTransportadoras(Map<Integer, Integer> transportadora){
        Iterator<Map.Entry<Integer, Integer>> it = transportadora.entrySet().iterator();
        Map.Entry<Integer, Integer> aux;
        Transportadora t;
        while(it.hasNext()){
            aux = it.next();
            t = transportes.get(aux.getKey());
            t.corrigirTransportadora(aux.getValue());
        }
    }
}
