package juegos.util;

import java.util.Scanner;

public class Coordenada {
    private int fila,columna;

    public Coordenada(int fila,int columna){
        this.fila=fila;
        this.columna=columna;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public static Coordenada introducirCoordenada(){
        java.util.Scanner s = new Scanner(System.in).useDelimiter("\n");
        System.out.println(" Fila: ");
        int fila = s.nextInt();
        System.out.println(" Columna: ");
        int columna = s.nextInt();
        return new Coordenada(fila,columna);
    }
}
