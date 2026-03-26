package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.List;
import java.util.ArrayList;

import main.Association;
import main.LectorTexto;

public class LectorTextoTest {
    
    @Test
    public void leerTexto1(){
        String texto = null;

        try {
            texto = LectorTexto.leerTexto("src/test/resources/texto1.txt");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        String esperado = "La femme me a demandé de faire mes devoirs sur ma ville.";
        Assertions.assertEquals(esperado, texto);
    }

    @Test
    public void leerDiccionario1(){
        List<Association<String, String>> diccionario = new ArrayList<>();
        
        try {
            diccionario = LectorTexto.leerDiccionario("src/test/resources/diccionario1.txt");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
        List<Association<String, String>> diccionarioEsperado = new ArrayList<>();
        diccionarioEsperado.add(new Association<String,String>("oui", "si"));
        diccionarioEsperado.add(new Association<String,String>("maison", "casa"));
        diccionarioEsperado.add(new Association<String,String>("devoirs", "tarea"));
        diccionarioEsperado.add(new Association<String,String>("femme", "mujer"));
        diccionarioEsperado.add(new Association<String,String>("chien", "perro"));
        diccionarioEsperado.add(new Association<String,String>("ville", "pueblo"));

        Assertions.assertEquals(diccionario, diccionarioEsperado);
    }
}
