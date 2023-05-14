import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Vintage.setImposto(0.23);
        Vintage.setLucro(0);
        Vintage.setTime(LocalDate.now());
        ControladorCentral controladorCentral = new ControladorCentral();
        controladorCentral.correrPrograma();
    }
}