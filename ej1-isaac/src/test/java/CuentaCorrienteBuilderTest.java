import org.example.dto.builder.CuentaCorrienteBuilder;
import org.example.dto.cuenta.CuentaCorriente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteBuilderTest {

    @Test
    public void testBuildCuentaCorrienteConSaldoYGiro() {
        CuentaCorriente cuenta = new CuentaCorrienteBuilder()
                .conSaldoInicial(300)
                .conGiroDescubierto(150)
                .build();

        assertEquals(300, cuenta.getSaldo());
        assertTrue(cuenta.quitarSaldo(400)); // Usa parte del giro
        assertEquals(-100, cuenta.getSaldo());
    }

    @Test
    public void testBuildCuentaCorrienteSinParametros() {
        CuentaCorriente cuenta = new CuentaCorrienteBuilder().build();
        assertEquals(0.0, cuenta.getSaldo());
        assertFalse(cuenta.quitarSaldo(1)); // No tiene giro ni saldo
    }
}
