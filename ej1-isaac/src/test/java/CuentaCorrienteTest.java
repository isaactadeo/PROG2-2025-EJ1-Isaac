import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.dto.cuenta.CuentaCorriente;

public class CuentaCorrienteTest {

    @Test
    public void testAgregarSaldo() {
        CuentaCorriente cuenta = new CuentaCorriente();
        boolean resultado = cuenta.agregarSaldo(100.0);
        assertTrue(resultado);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void testQuitarSaldoConSaldoDisponible() {
        CuentaCorriente cuenta = new CuentaCorriente();
        cuenta.agregarSaldo(100.0);
        boolean resultado = cuenta.quitarSaldo(60.0);
        assertTrue(resultado);
        assertEquals(40.0, cuenta.getSaldo());
    }

    @Test
    public void testQuitarSaldoConGiroEnDescubierto() {
        CuentaCorriente cuenta = new CuentaCorriente(200.0);
        boolean resultado = cuenta.quitarSaldo(100.0);
        assertTrue(resultado);
        assertEquals(-100.0, cuenta.getSaldo());
    }

    @Test
    public void testQuitarSaldoExcedeDescubierto() {
        CuentaCorriente cuenta = new CuentaCorriente(100.0);
        boolean resultado = cuenta.quitarSaldo(150.0);
        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void testAgregarSaldoCero() {
        CuentaCorriente cuenta = new CuentaCorriente();
        boolean resultado = cuenta.agregarSaldo(0.0);
        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void testQuitarSaldoCero() {
        CuentaCorriente cuenta = new CuentaCorriente(100.0);
        boolean resultado = cuenta.quitarSaldo(0.0);
        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldo());
    }
}
