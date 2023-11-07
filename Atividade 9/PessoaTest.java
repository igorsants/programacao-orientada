package com.mycompany.atividade09;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 
Unit test for simple App.*/

public class PessoaTest {

    @Test
    public void testDizerOla() {
        Pessoa pessoa = new Pessoa();
        String resultado = pessoa.dizerOla();
        assertEquals("Olá, mundo!", resultado);
    }
}
