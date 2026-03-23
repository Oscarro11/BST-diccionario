package main.BST;

public class NodoBST<T> {
    
    private T contenido;
    private NodoBST<T> izquierda;
    private NodoBST<T> derecha;

    public NodoBST(T contenido){
        this.contenido = contenido;
    }

    public T getContenido() {return contenido;}
    public NodoBST<T> getDerecha() {return derecha;}
    public NodoBST<T> getIzquierda() {return izquierda;}

    public void setDerecha(NodoBST<T> derecha) {this.derecha = derecha;} 
    public void setIzquierda(NodoBST<T> izquierda) {this.izquierda = izquierda;}
}
