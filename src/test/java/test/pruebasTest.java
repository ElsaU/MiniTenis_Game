package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class pruebasTest {

    @Test
    @DisplayName("Primera prueba JUnit")
    void primeraPrueba(){
        System.out.println("Esta es la primera prueba");
    }

    @Test
    @DisplayName("Segunda prueba JUnit")
    void segundaPrueba(){
        System.out.println("Esta es la segunda prueba");
    }
}
