package juegos.ter;

import juegos.util.*;

public class Jugador {
    private char ficha;

    public Jugador(char ficha){
        this.ficha = ficha;
    }

    public void ponerFicha(Tablero tablero){
        Coordenada c1;
        try {
            System.out.println("Poner ficha ["+ficha+"]");
            c1 = Coordenada.introducirCoordenada();
            tablero.ponerFicha(c1,ficha);
        }catch (PosicionFueraDelTableroException | PosicionNoVaciaException e){
            System.out.println("<<< " + e.getMessage() + " >>>");
            ponerFicha(tablero);
        }
    }

    public void moverFicha(Tablero tablero){
        quitarFicha(tablero);
        ponerFicha(tablero);
    }

    public void quitarFicha(Tablero tablero){
        Coordenada c1;
        try {
            System.out.println("Mover ficha ["+ficha+"]");
            c1 = Coordenada.introducirCoordenada();
            tablero.quitarFicha(c1,ficha);
        }catch (PosicionFueraDelTableroException | FichaDeOtroJugadorException e){
            System.out.println("<<< " + e.getMessage() + " >>>");
            quitarFicha(tablero);
        }
    }

    public void ganador(){
        System.out.println("¡¡¡ " + ficha + " ganan !!!");
    }
}
