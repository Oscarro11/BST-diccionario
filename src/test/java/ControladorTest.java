import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.Controlador;

public class ControladorTest {
    
    @Test
    public void pruebaTexto(){
        Controlador controlador = new Controlador();
        controlador.seleccionarDiccionario("src/test/resources/diccionario1.txt");
        controlador.seleccionarTexto("src/test/resources/texto1.txt");

        Assertions.assertEquals("*La* mujer *me* *a* *demandé* *de* *faire* *mes* tarea *sur* *ma* pueblo.", controlador.traducirTexto());
    }
}
