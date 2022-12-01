package juegos.ter;

import juegos.util.Tablero;
import juegos.util.Turno;

public class TresEnRaya {
    private Turno turno;
    private Tablero tablero;
    private Jugador[] jugadores;

    public TresEnRaya(){
        turno = new Turno();
        tablero = new Tablero();
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador(Tablero.X);
        jugadores[1] = new Jugador(Tablero.O);
    }

    public void jugar(){
        tablero.imprimir();
        for(int i=0;i<(tablero.dimension()*2)-1;i++){
            jugadores[turno.quienToca()].ponerFicha(tablero);
            turno.cambiar();
            tablero.imprimir();
        }
        if(tablero.hayTresEnRaya())
            jugadores[turno.quienNoToca()].ganador();
        else{
            jugadores[turno.quienToca()].ponerFicha(tablero);
            while(!tablero.hayTresEnRaya()){
                turno.cambiar();
                tablero.imprimir();
                jugadores[turno.quienToca()].moverFicha(tablero);
            }
            tablero.imprimir();
            jugadores[turno.quienToca()].ganador();
        }
    }

    public static void main(String[] args) {
        TresEnRaya ter = new TresEnRaya();
        ter.jugar();
    }
}
