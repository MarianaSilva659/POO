import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class GestorTransportes {
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
        boolean existe = false;
        Iterator<Map.Entry<Integer, Transportadora>> iterator = transportes.entrySet().iterator();
        Map.Entry<Integer, Transportadora> n;
        
        while(iterator.hasNext()){
            n = iterator.next();

            if(id == n.getKey()){
                existe = true;
            }
        }
        return existe;
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
        sb.append("TRANSPORTES: ").append(transportes.toString()).append('\n');
        return sb.toString();
    }

    public void setTransporte(Transportadora t){
        this.transportes.put(t.getIdTransporte(), t.clone());
    }
}
