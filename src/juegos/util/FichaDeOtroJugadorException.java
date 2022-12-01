package juegos.util;

public class FichaDeOtroJugadorException extends Exception{
    public FichaDeOtroJugadorException(){
        super("Atención: Posición seleccionada no válida...");
    }
}
