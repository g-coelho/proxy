import org.example.BD;
import org.example.Fita;
import org.example.FitaProxy;
import org.example.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FitaProxyTest {

    @BeforeEach
    void setUp() {
        BD.addFita(new Fita(1, "Em Busca do Vale Encantado", "Delart", 69, 10));
        BD.addFita(new Fita(2, "Rei Leão", "Delart", 89, 10));
    }

    @Test
    void deveRetornarDadosFita() {
        FitaProxy fita = new FitaProxy(1);

        assertEquals(Arrays.asList("Em Busca do Vale Encantado", "Delart"), fita.obterDados());
    }

    @Test
    void deveRetonarNotasFita() {
        Funcionario funcionario = new Funcionario("Gabriel", true);
        FitaProxy fita = new FitaProxy(2);

        assertEquals(Arrays.asList(89, 10), fita.obterDuracaoAvaliacao(funcionario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarNotasFita() {
        try {
            Funcionario funcionario = new Funcionario("Marco", false);
            FitaProxy fita = new FitaProxy(2);

            fita.obterDuracaoAvaliacao(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}