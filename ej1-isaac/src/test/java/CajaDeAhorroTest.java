import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.dto.cuenta.CajaDeAhorro;

public class CajaDeAhorroTest {

    @Test
    public void testAgregarSaldo() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        boolean resultado = cuenta.agregarSaldo(100.0);
        assertTrue(resultado);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void testQuitarSaldoConSaldoDisponible() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        cuenta.agregarSaldo(100.0);
        boolean resultado = cuenta.quitarSaldo(60.0);
        assertTrue(resultado);
        assertEquals(40.0, cuenta.getSaldo());
    }

    @Test
    public void testQuitarSaldoExcedeSaldo() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        cuenta.agregarSaldo(100.0);
        boolean resultado = cuenta.quitarSaldo(150.0);
        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void testAgregarSaldoCero() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        boolean resultado = cuenta.agregarSaldo(0.0);
        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void testQuitarSaldoCero() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        boolean resultado = cuenta.quitarSaldo(0.0);
        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void testOperaciones() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        cuenta.agregarSaldo(100.0);
        assertEquals(1, cuenta.getOperaciones());
        cuenta.quitarSaldo(50.0);
        assertEquals(2, cuenta.getOperaciones());
    }
}
