import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
class EvaluadorTest {
    List<String> test = new ArrayList();

    @org.junit.jupiter.api.Test
    void testEquals() {
        Evaluador prueba = new Evaluador();
        boolean resultado = prueba.equals(4, 4);
        assertEquals(true, resultado);
    }

    @org.junit.jupiter.api.Test
    void mayor() {
        Evaluador prueba = new Evaluador();
        boolean resultado = prueba.Mayor(5,1);
        assertEquals(true, resultado);

    }

    @org.junit.jupiter.api.Test
    void menor() {
        Evaluador prueba = new Evaluador();
        boolean resultado = prueba.Menor(5,1);
        assertEquals(false, resultado);
    }

    @org.junit.jupiter.api.Test
    void quote() {
        Evaluador prueba = new Evaluador();
        test.add("e");
        test.add("3fd");
        prueba.quote(test);
    }

    @org.junit.jupiter.api.Test
    void setq() {
        Evaluador prueba = new Evaluador();
        test.add("setq");
        test.add("x");
        test.add("4");
        prueba.setq(test);
    }
}