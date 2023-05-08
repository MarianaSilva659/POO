import javax.xml.crypto.dsig.TransformService;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Vintage {

    private Map<Integer, Utilizador> users;
    private Map<Integer, Transportadora> trasportes;
    private Map<String, Artigo> artigos;

    public Vintage(){
        users = new TreeMap<>();
        trasportes = new TreeMap<>();
        artigos = new TreeMap<>();
    }
    
    public Set<Artigo> getArtigos() {
        return new HashSet<>(artigos.values());
    }
    public Set<Transportadora> getTrasportes() {
        return new HashSet<>(trasportes.values());
    }public Set<Utilizador> getUtilizadores() {
        return new HashSet<>(users.values());
    }
    public boolean hasUsers(){return !users.isEmpty();}

    public boolean hasTrasportes(){return !trasportes.isEmpty();}

    public boolean hasArtigos(){return !artigos.isEmpty();}


    public void addUser(int id){
        Utilizador user = new Utilizador();
        user.setId(id);
        users.put(id,user);
    }

    public void addTrasnportadora(int id){
        Transportadora trasp = new Transportadora();
        trasp.setIdTransporte(id);
        trasportes.put(id,trasp);
    }

    public void addArtigo(Artigo artigo){
        artigos.put(artigo.getId(),artigo);
    }

    public Utilizador getUtilizador(int id) {
        Utilizador u = users.get(id);
        return u.clone();
    }
    public Transportadora getTrasportadora(int id) {
        Transportadora u = trasportes.get(id);
        return u.clone();
    }
    public Artigo getArtigo(String id) {
        Artigo u = artigos.get(id);
        return u.clone();
    }

    public boolean existsUser(int id){
        return users.containsKey(id);
    }

    public boolean existsArtigo(String id){
        return artigos.containsKey(id);
    }
    public boolean existsTrasportadora(int id){
        return trasportes.containsKey(id);
    }

}
