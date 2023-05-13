
public class Pair<F,S> {
    private F first;
    private S second;


    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }


    public F getFirst() {
        return this.first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return this.second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;
        return first.equals(pair.getFirst()) && second.equals(pair.second);
    }
    
    @Override
    public String toString() {
        return "{" +
            " first='" + getFirst() + "'" +
            ", second='" + getSecond() + "'" +
            "}";
    }


    public Pair(Pair<F,S> pair){
        this.first = pair.getFirst();
        this.second = pair.getSecond();
    }

    public Pair(){

    }

    public Pair<F,S> clone(){
        return new Pair<F,S>(this);
    }
    
}