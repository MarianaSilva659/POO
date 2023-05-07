import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Encomenda {
    private Set<String> encomenda;
    public enum Dimensao{
        PEQ,
        MED,
        GRA;
    }
    private Dimensao dimensao;
    private LocalDate dataCriacao;
    public enum Estado{
        P, //pendente
        F, //finalizada
        E; //expedida
    }
    private Estado estado;

    public Set<String> getEncomenda() {
        return this.encomenda;
    }

    public void setEncomenda(Set<String> encomenda) {
        this.encomenda = encomenda;
    }

    public Dimensao getDimensao() {
        return this.dimensao;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Encomenda encomenda1 = (Encomenda) object;
        return this.getEncomenda().equals(encomenda1.getEncomenda()) 
        && getDimensao() == encomenda1.getDimensao() 
        && this.getDataCriacao().equals(encomenda1.getDataCriacao()) 
        && this.getEstado() == encomenda1.getEstado();
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getEncomenda(), getDimensao(), getDataCriacao(), getEstado());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Encomenda{" +
                "encomenda=" + encomenda +
                ", dimensao=" + dimensao +
                ", dataCriacao=" + dataCriacao +
                ", estado=" + estado +
                '}';
    }
}
