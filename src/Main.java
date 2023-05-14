import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Vintage.setVintageTime(LocalDate.now());
        ControladorCentral controladorCentral = new ControladorCentral();
        controladorCentral.correrPrograma();
    }
}