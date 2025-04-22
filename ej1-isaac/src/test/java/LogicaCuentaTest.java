import org.example.dto.builder.CajaDeAhorroBuilder;
import org.example.dto.cuenta.CajaDeAhorro;
import org.example.service.LogicaCuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicaCuentaTest {

    LogicaCuenta logica;

    @BeforeEach
    public void setup() {
        logica = LogicaCuenta.getInstancia(); //con beforeeach hacemos que el metodo getinstancia
                                                //se ejecute antes de cada test
    }

    @Test
    public void testAgregarCuentaYConsultarSaldo() {
        CajaDeAhorro cuenta = new CajaDeAhorroBuilder()
                .conSaldoInicial(100)
                .build();

        int id = logica.agregarCuenta(cuenta);
        assertEquals(100.0, logica.consultarSaldo(id));
    }

    @Test
    public void testAgregarSaldo() {
        CajaDeAhorro cuenta = new CajaDeAhorroBuilder()
                .conSaldoInicial(50)
                .build();

        int id = logica.agregarCuenta(cuenta);
        assertTrue(logica.agregarSaldo(id, 25));
        assertEquals(75.0, logica.consultarSaldo(id));
    }

    @Test
    public void testQuitarSaldo() {
        CajaDeAhorro cuenta = new CajaDeAhorroBuilder()
                .conSaldoInicial(80)
                .build();

        int id = logica.agregarCuenta(cuenta);
        assertTrue(logica.quitarSaldo(id, 30));
        assertEquals(50.0, logica.consultarSaldo(id));
    }

    @Test
    public void testQuitarSaldoInsuficiente() {
        CajaDeAhorro cuenta = new CajaDeAhorroBuilder()
                .conSaldoInicial(20)
                .build();

        int id = logica.agregarCuenta(cuenta);
        assertFalse(logica.quitarSaldo(id, 50));
        assertEquals(20.0, logica.consultarSaldo(id));
    }

    @Test
    public void testCuentaInvalida() {
        assertFalse(logica.agregarSaldo(-1, 100));
        assertFalse(logica.quitarSaldo(999, 100));
        assertEquals(-1.0, logica.consultarSaldo(999));
    }
}
