package main.BST;

import java.util.List;

public interface IBST<T>{
    void agregar(T dato);
    T buscar(T dato);

    List<T> preOrder();
    List<T> inOrder();
    List<T> postOrder();
}
