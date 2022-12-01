package juegos.util;

public class PosicionNoVaciaException extends Exception{
    public PosicionNoVaciaException(){
        super("Atención: Posición ocupada por otra ficha...");
    }
}
