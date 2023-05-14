import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Vintage.setTime(LocalDate.now());
        ControladorCentral controladorCentral = new ControladorCentral();
        controladorCentral.correrPrograma();
    }
}