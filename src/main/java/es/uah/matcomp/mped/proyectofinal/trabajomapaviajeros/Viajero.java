package es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros;

import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ListaEnlazada;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo.Camino;

import static es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.ValoresEstaticos.idGlobal;

public class Viajero {
    private int id;
    private String nombre;
    private String dni;
    private int kilometrosRecorridos=0;
    private ListaEnlazada<Camino> rutasPendientes=new ListaEnlazada<>();
    private ListaEnlazada<Camino> rutasRealizadas=new ListaEnlazada<>();

    @Override
    public String toString() {
        return "Viajero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", kilometrosRecorridos=" + kilometrosRecorridos +
                ", rutasPendientes=" + rutasPendientes +
                ", rutasRealizadas=" + rutasRealizadas +
                '}';
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public ListaEnlazada<Camino> getRutasPendientes() {
        return rutasPendientes;
    }

    public void setRutasPendientes(ListaEnlazada<Camino> rutasPendientes) {
        this.rutasPendientes = rutasPendientes;
    }

    public ListaEnlazada<Camino> getRutasRealizadas() {
        return rutasRealizadas;
    }

    public void setRutasRealizadas(ListaEnlazada<Camino> rutasRealizadas) {
        this.rutasRealizadas = rutasRealizadas;
    }

    public Viajero(String nombre, String dni) {
        this.id = idGlobal;
        idGlobal++;
        this.nombre = nombre;
        this.dni = dni;
    }
}
