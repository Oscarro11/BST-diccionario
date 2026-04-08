import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.Controlador;

public class ControladorTest {
    
    @Test
    public void pruebaTexto(){
        Controlador controlador = new Controlador();
        controlador.seleccionarDiccionario("src/test/resources/diccionarioFrances.txt");
        controlador.seleccionarTexto("src/test/resources/textoFrances1.txt");

        Assertions.assertEquals("*La* mujer *me* *a* *demandé* *de* *faire* *mes* tarea *sur* *ma* pueblo.", controlador.traducirTexto());
    }

    @Test
    public void pruebaUpperAndCapital(){
        Controlador controlador = new Controlador();
        controlador.seleccionarDiccionario("src/test/resources/diccionarioFrances.txt");
        controlador.seleccionarTexto("src/test/resources/textoFrances2.txt");

        Assertions.assertEquals("*La* MUJER *me* *a* *demandé* *de* *faire* *mes* tarea *sur* *ma* Pueblo.", controlador.traducirTexto());
    }

    @Test
    public void pruebaIngles1(){
        Controlador controlador = new Controlador();
        controlador.seleccionarDiccionario("src/test/resources/diccionarioIngles.txt");
        controlador.seleccionarTexto("src/test/resources/textoIngles1.txt");

        Assertions.assertTrue(controlador.traducirTexto() != null);
    }

    @Test
    public void pruebaIngles2(){
        Controlador controlador = new Controlador();
        controlador.seleccionarDiccionario("src/test/resources/diccionarioInglesBig.txt");
        controlador.seleccionarTexto("src/test/resources/textoIngles2.txt");

        Assertions.assertTrue(controlador.traducirTexto() != null);
    }
}
