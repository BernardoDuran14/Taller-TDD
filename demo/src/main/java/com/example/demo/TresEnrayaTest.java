package com.example.demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TresEnrayaTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void cuandoFueraDEXlanzaException() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();
        //2. Logica de la prueba
        exception.expect(Exception.class);
        tresEnraya.jugar(5,2);

    }

    @Test
    public void cuandoFueraDEYlanza() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();
        //2. Logica de la prueba
        exception.expect(Exception.class);
        tresEnraya.jugar(2,5);
    }


    @Test
    public void lugarOcupado() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();
        //2. Logica de la prueba
        tresEnraya.jugar(1,3);

        exception.expect(Exception.class);
        tresEnraya.jugar(1,3);
    }
    @Test
    public void lugardiferente() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();
        //2. Logica de la prueba
        tresEnraya.jugar(1,3);

        tresEnraya.jugar(2,3);
    }
    @Test
    public void PrimerTurnoX() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();
        //2. Logica de la prueba
        assertEquals ('X', tresEnraya.siguienteTurno());


    }
    @Test
    public void PrimerTurnoXSiguienteCruz() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();

        tresEnraya.jugar(1,3);
        //2. Logica de la prueba
        assertEquals ('+', tresEnraya.siguienteTurno());


    }
    @Test
    public void UltimoTurnoCruzSiguienteX() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();

        tresEnraya.jugar(1,3);
        //2. Logica de la prueba
        assertEquals ('+', tresEnraya.siguienteTurno());
        tresEnraya.jugar(2,3);
        assertEquals ('X', tresEnraya.siguienteTurno());

    }

    @Test
    public void CondicionDeNOVictoria() throws Exception{
        //1. Preparacion de la prueba
        TresEnRaya tresEnraya = new TresEnRaya();
        String resultado = tresEnraya.jugar(2,1);



        //2. Logica de la prueba
        assertEquals ("no hay ganador aun", resultado);

    }


    @Test
    public void siLlenaColumnaEntoncesGana() throws Exception {

        //1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        //2. Logica de la prueba
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(2,2);
        String resultado = tresEnRaya.jugar(3,1);

        //3. Verificacion o assert
        assertEquals("X es el ganador",resultado);

    }
    @Test
    public void siLlenaFilaEntoncesGana() throws Exception {

        //1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        //2. Logica de la prueba
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(3,1);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(2,2);
        String resultado = tresEnRaya.jugar(1,3);

        //3. Verificacion o assert
        assertEquals("+ es el ganador",resultado);

    }
// instalar jenkins


}
