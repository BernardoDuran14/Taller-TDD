package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;

public class TresEnRaya
{
    private Character[][] tablero = {{'0', '0', '0'},
                                     {'0', '0', '0'},
                                     {'0', '0', '0'}};
    private  char ultimoJugador = '+';
    private final int TAMANHO = 3;
    public String jugar(int x, int y) throws Exception
    {
        verificarEje(x);
        verificarEje(y);

        ultimoJugador=siguienteTurno();
        asignarPosicion(x, y);
        if(hayGanador()){
            return ultimoJugador +" es el ganador";
        }
        return "no hay ganador aun";
    }
    private boolean hayGanador(){
        int total = ultimoJugador*TAMANHO;
        for (int i = 0; i<TAMANHO ; i++) {
            if (tablero[0][i] + tablero[1][i] + tablero[2][i] == total) {
                return true;
            }
            if (tablero[i][0] + tablero[i][1] + tablero[i][2] == total) {
                return true;
            }
            if (tablero[0][i] + tablero[1][i] + tablero[2][i] == total) {
                return true;
            }
            if (tablero[i][i] + tablero[i][i] + tablero[i][i] == total) {
                return true;
            }
            if (tablero[0][i-1] + tablero[i][i] + tablero[i-1][0] == total) {
                return true;
            }
        }
        return false;
    }
    private void asignarPosicion(int x, int y) throws Exception {
        if (tablero[x -1][y - 1] != '0')
        {
            throw new Exception(" esta ocupada");
        }
        else {
            tablero[x -1][y - 1] = ultimoJugador;
            System.out.println("Asignando posicion:" + x +"," + y);
            System.out.println("\n" +tablero[0][0]);
        }
    }
    public void verificarEje(int eje) throws Exception{
        if (eje>3||eje<1)
        {
            throw new Exception("La coordenada "+eje+" esta fuera");
        }
    }
    public char siguienteTurno(){
        if (ultimoJugador=='X'){
            return '+';
        }
        else {
            return 'X';
        }
    }
}
