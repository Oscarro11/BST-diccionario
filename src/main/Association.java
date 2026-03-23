package main;

public class Association <K extends Comparable<K>, V> implements Comparable<Association<K, V>>{
    
    private K llave;
    private V valor;

    public Association(K llave, V valor){
        this.llave = llave;
        this.valor = valor;
    }

    @Override
    public int compareTo(Association<K, V> o) {
        return llave.compareTo(o.getLlave());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Association) {
            Association<K, V> association = (Association<K, V>) obj;    
            return (association.getLlave().equals(this.llave) && association.getValor().equals(this.valor));
        }
        return false;
    }

    public K getLlave() {
        return llave;
    }
    public V getValor() {
        return valor;
    }
}
