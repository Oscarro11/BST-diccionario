package com.example.BST;

import java.util.List;
import java.util.ArrayList;

public class BST<T extends Comparable<T>> implements IBST<T> {
    private NodoBST<T> cabeza;

    public void agregar(T elemento){
        NodoBST<T> actual = cabeza;

        if (actual == null) {
            cabeza = new NodoBST<T>(elemento);
        }
        else{
            boolean insertado = false;

            while (!insertado) {
                if (elemento.compareTo(actual.getContenido()) > 0){
                    if (actual.getDerecha() == null){
                        actual.setDerecha(new NodoBST<T>(elemento));
                        insertado = true;
                    }
                    else{
                        actual = actual.getDerecha();
                    }
                }
                else{
                    if (actual.getIzquierda() == null){
                        actual.setIzquierda(new NodoBST<T>(elemento));
                        insertado = true;
                    }
                    else{
                        actual = actual.getIzquierda();
                    }
                }
            }
        }        
    }

    public T buscar(T elemento){
        NodoBST<T> actual = cabeza;

        while (actual != null){
            if (actual.getContenido().equals(elemento)) {
                return actual.getContenido();
            }
            else{
                if (elemento.compareTo(actual.getContenido()) > 0){
                    actual = actual.getDerecha();
                } 
                else{
                    actual = actual.getIzquierda();
                }
            }
        }

        return null;
    }

    public List<T> preOrder(){
        List<T> contenidos = new ArrayList<T>();
        ingresarPre(contenidos, cabeza);

        return contenidos;
    }

    private void ingresarPre(List<T> lista, NodoBST<T> nodo){
        if (nodo == null) {
            return;
        }
        else{
            lista.add(nodo.getContenido());
            ingresarPre(lista, nodo.getIzquierda());
            ingresarPre(lista, nodo.getDerecha());
        }
    }

    public List<T> inOrder(){
        List<T> contenidos = new ArrayList<T>();
        ingresarIn(contenidos, cabeza);

        return contenidos;
    }

    private void ingresarIn(List<T> lista, NodoBST<T> nodo){
        if (nodo == null) {
            return;
        }
        else{
            ingresarIn(lista, nodo.getIzquierda());
            lista.add(nodo.getContenido());
            ingresarIn(lista, nodo.getDerecha());
        }
    }

    public List<T> postOrder(){
        List<T> contenidos = new ArrayList<T>();
        ingresarPost(contenidos, cabeza);

        return contenidos;
    }

    private void ingresarPost(List<T> lista, NodoBST<T> nodo){
        if (nodo == null) {
            return;
        }
        else{
            ingresarPost(lista, nodo.getIzquierda());
            ingresarPost(lista, nodo.getDerecha());
            lista.add(nodo.getContenido());
        }
    }
}
