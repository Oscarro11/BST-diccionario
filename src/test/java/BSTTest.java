package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import main.BST.BST;

public class BSTTest {
    public static BST<Integer> arbol = new BST<Integer>();

    @BeforeAll
    public static void insertarElementos(){
        arbol.agregar(5);
        arbol.agregar(3);
        arbol.agregar(8);
        arbol.agregar(2);
        arbol.agregar(6);
        arbol.agregar(11);
    }

    @Test
    public void evaluarPreOrder(){
        Integer[] temp = new Integer[]{5, 3, 2, 8, 6, 11};
        List<Integer> resultado = new ArrayList<Integer>(Arrays.asList(temp));

        Assertions.assertEquals(resultado, arbol.preOrder());
    }

    @Test
    public void evaluarInOrder(){
        Integer[] temp = new Integer[]{2, 3, 5, 6, 8, 11};
        List<Integer> resultado = new ArrayList<Integer>(Arrays.asList(temp));

        Assertions.assertEquals(resultado, arbol.inOrder());
    }

    @Test
    public void evaluarPostOrder(){
        Integer[] temp = new Integer[]{2, 3, 6, 11, 8, 5};
        List<Integer> resultado = new ArrayList<Integer>(Arrays.asList(temp));

        Assertions.assertEquals(resultado, arbol.postOrder());
    }

    @Test
    public void buscarExistente(){
        Assertions.assertEquals(6, arbol.buscar(6));
    }

    @Test
    public void buscarInexistente(){
        Assertions.assertEquals(null, arbol.buscar(7));
    }
}
