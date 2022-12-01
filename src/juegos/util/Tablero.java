package juegos.util;

public class Tablero {
    private char[][] tablero;
    private final char VACIO = '-';
    public static final char X = 'X';
    public static final char O = 'O';

    public Tablero(int dimension){
        tablero = new char[dimension][dimension];
        inicializar();
    }

    public Tablero(){
        this(3);
    }

    public void inicializar(){
        for(int i=0;i<tablero.length;i++)
            for(int j=0;j<tablero.length;j++)
                tablero[i][j] = VACIO;
    }

    public int dimension(){
        return tablero.length;
    }

    public void imprimir(){
        int i,j;
        System.out.println();
        System.out.print("  ");
        for(i=0;i< tablero.length;i++)
            System.out.print(i + " ");
        System.out.println();
        for(i=0;i<tablero.length;i++){
            System.out.print(i + " ");
            for(j=0;j<tablero.length;j++)
                System.out.print(tablero[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public boolean hayTresEnRaya(){
        boolean hayTresEnRaya = false;
        int i;
        for(i=0;i<tablero.length && !hayTresEnRaya;i++)
            if(tablero[i][0] != VACIO && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2])
                hayTresEnRaya = true;
        for(i=0;i<tablero.length && !hayTresEnRaya;i++)
            if(tablero[0][i] != VACIO && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i])
                hayTresEnRaya = true;
        if(tablero[0][0] != VACIO && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2])
            hayTresEnRaya = true;
        if(tablero[0][2] != VACIO && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0])
            hayTresEnRaya = true;
        return hayTresEnRaya;
    }

    public boolean hayNEnRaya(){
        boolean hayNEnRaya = true;
        int i,j;
        for(i=0;i<tablero.length;i++) {
            hayNEnRaya = tablero[i][0] != VACIO;
            for(j=0;j<tablero.length-1;j++)
                hayNEnRaya &= tablero[i][j] == tablero[i][j+1];
        }
        if(hayNEnRaya)
            return true;

        for(i=0;i<tablero.length;i++) {
            hayNEnRaya = tablero[0][i] != VACIO;
            for(j=0;j<tablero.length-1;j++)
                hayNEnRaya &= tablero[j][i] == tablero[j+1][i];
        }
        if(hayNEnRaya)
            return true;

        hayNEnRaya = tablero[0][0] != VACIO;
        for(i=0;i< tablero.length-1;i++)
            hayNEnRaya &= tablero[i][i] == tablero[i+1][i+1];
        if(hayNEnRaya)
            return true;

        hayNEnRaya = tablero[0][tablero.length-1] != VACIO;
        for(i=0,j=tablero.length-1;i<tablero.length-1 && j>0;i++,j--)
            hayNEnRaya &= tablero[i][j] == tablero[i+1][j-1];
        return hayNEnRaya;
    }

    public void ponerFicha(Coordenada c, char ficha) throws PosicionFueraDelTableroException, PosicionNoVaciaException {
        if(validarCoordenada(c) && posicionVacia(c))
            tablero[c.getFila()][c.getColumna()] = ficha;
        else
            throw new PosicionNoVaciaException();
    }

    public void quitarFicha(Coordenada c, char ficha) throws PosicionFueraDelTableroException, FichaDeOtroJugadorException {
        if(validarCoordenada(c) && ficha == obtenerFicha(c))
            tablero[c.getFila()][c.getColumna()] = VACIO;
        else
            throw new FichaDeOtroJugadorException();
    }

    private boolean validarCoordenada(Coordenada c) throws PosicionFueraDelTableroException {
        if(c.getFila() < 0 || c.getFila() > tablero.length-1 || c.getColumna() < 0 || c.getColumna() > tablero.length-1 )
            throw new PosicionFueraDelTableroException();
        else
            return true;
    }

    private boolean posicionVacia(Coordenada c){
        return tablero[c.getFila()][c.getColumna()] == VACIO;
    }

    private char obtenerFicha(Coordenada c){
        return tablero[c.getFila()][c.getColumna()];
    }
}
