import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.Association;

import org.junit.jupiter.api.BeforeAll;
import java.util.List;
import java.util.ArrayList;

import com.example.BST.BST;

public class AssociationBSTTest {
    private static BST<Association<String, String>> arbol;

    @BeforeAll
    public static void agregarDiccionario(){
        arbol = new BST<Association<String, String>>();

        arbol.agregar(new Association<String,String>("oui", "si"));
        arbol.agregar(new Association<String,String>("maison", "casa"));
        arbol.agregar(new Association<String,String>("devoirs", "tarea"));
        arbol.agregar(new Association<String,String>("femme", "mujer"));
        arbol.agregar(new Association<String,String>("chien", "perro"));
        arbol.agregar(new Association<String,String>("ville", "pueblo"));
    }

    @Test
    public void testInOrder(){
        List<Association<String, String>> resultado = new ArrayList<Association<String, String>>();
        resultado.add(new Association<String,String>("chien", "perro"));
        resultado.add(new Association<String,String>("devoirs", "tarea"));
        resultado.add(new Association<String,String>("femme", "mujer"));
        resultado.add(new Association<String,String>("maison", "casa"));
        resultado.add(new Association<String,String>("oui", "si"));
        resultado.add(new Association<String,String>("ville", "pueblo"));

        Assertions.assertEquals(resultado, arbol.inOrder());
    }

    @Test
    public void buscarExistente(){
        Association<String, String> objetoBusqueda = new Association<String,String>("femme", "mujer");

        Assertions.assertEquals(new Association<String, String>("femme", "mujer"), arbol.buscar(objetoBusqueda));
    }

    @Test
    public void buscarInexistente(){
        Association<String, String> objetoBusqueda = new Association<String,String>("fememem","sss");
        Assertions.assertEquals(null, arbol.buscar(objetoBusqueda));

        objetoBusqueda = new Association<String,String>("monsieur", "mujer");
        Assertions.assertEquals(null, arbol.buscar(objetoBusqueda));
    }
}
