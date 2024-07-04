package es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo;

public class Arco<V> {
    private Vertice v1;
    private Vertice v2;
    private int peso;
    private String nombre;

    public Arco(Vertice v1, Vertice v2, int peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public Arco(Vertice v1, Vertice v2, int peso, String nombre) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
        this.nombre = nombre;
    }

    public Arco(V data, V data1) {
    }


    public Vertice getV1() {
        return this.v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
