package juegos.util;

public class PosicionFueraDelTableroException extends Exception{
    public PosicionFueraDelTableroException(){
        super("Atención: Posición fuera del tablero de juego...");
    }
}
