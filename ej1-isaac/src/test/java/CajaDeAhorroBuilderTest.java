import org.example.dto.builder.CajaDeAhorroBuilder;
import org.example.dto.cuenta.CajaDeAhorro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroBuilderTest {

    @Test
    public void testBuildCajaDeAhorroConSaldoInicial() {
        CajaDeAhorro cuenta = new CajaDeAhorroBuilder()
                .conSaldoInicial(500)
                .build();

        assertEquals(500.0, cuenta.getSaldo());
    }

    @Test
    public void testBuildCajaDeAhorroSinSaldoInicial() {
        CajaDeAhorro cuenta = new CajaDeAhorroBuilder().build();
        assertEquals(0.0, cuenta.getSaldo());
    }
}
