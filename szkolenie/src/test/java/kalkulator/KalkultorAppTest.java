package kalkulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Kocurek")
class KalkultorAppTest {

    @Test
    public void addTwoPositiveIntegers() {
        // arrange
        KalkultorApp calc = new KalkultorApp();
// act
        int suma = calc.add(1, 13);

//assert
        Assertions.assertEquals(14, suma, "Sprawdź, że działa  dodawanie liczb całkowitych");

    }

    @Test
    public void addTwoPositiveDouble() {
        // arrange

        KalkultorApp kalkultorApp = new KalkultorApp();
// act
        double suma = kalkultorApp.add(1.23, 3.0);

//assert
        Assertions.assertEquals(4.23, suma, "Sprawdź, że dodawanie liczb całkowitych dzialą");

        Assertions.assertEquals(4.23, suma, 0.0000001,  "Sprawdź, że działa  dodawanie liczb zmiennoprzecinkowych");
    }

    @Test
    public void positiveDiv() {

        KalkultorApp kalkultorApp = new KalkultorApp();
        double suma =  kalkultorApp.div(2.0 , 3.0) ;
        Assertions.assertEquals(0.66667, suma, 0.00001,  "Sprawdź, że dziala dzielenie liczb double");
    }

}

