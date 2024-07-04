package es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo;


import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ListaEnlazada;

import static es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.ValoresEstaticos.idGlobalVertices;

public class Vertice {
    private int id;
    private String nombre;
    private boolean conectado = false;
    private ListaEnlazada<Vertice> frontera = new ListaEnlazada<>();

    public Vertice(String nombreCiudad) {
        this.id = idGlobalVertices;
        idGlobalVertices++;
        this.nombre = nombreCiudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public ListaEnlazada<Vertice> getFrontera() {
        return frontera;
    }

    public void setFrontera(ListaEnlazada<Vertice> frontera) {
        this.frontera = frontera;
    }

    public void addFrontera(Arco<Vertice> adyacente) {
        frontera.add(adyacente);
    }


    @Override
    public String toString() {
        StringBuilder fronteraString = new StringBuilder();
        for (int i = 0; i < frontera.getNumeroElementos(); i++) {
            if (i != frontera.getNumeroElementos() - 1) {
                fronteraString.append(frontera.getElemento(i).getData().getNombre() + ", ");
            }else{
                fronteraString.append(frontera.getElemento(i).getData().getNombre());
            }

        }

        return "Vertice{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", conectado=" + conectado +
                ", frontera=" + fronteraString +
                '}';

    }

}
