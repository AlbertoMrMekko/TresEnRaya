package juegos.util;

public class Turno {
    private int turno = 0;

    public int quienToca(){
        return turno;
    }

    public void cambiar(){
        turno = (turno==0)?1:0;
    }

    public int quienNoToca(){
        return (turno==0)?1:0;
    }
}
