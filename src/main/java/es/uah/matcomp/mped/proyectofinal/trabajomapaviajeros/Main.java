package es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros;


import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ListaEnlazada;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo.Grafo;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo.Vertice;

import java.util.Scanner;

public class Main extends Funciones {
    public static void main(String[] args) {


        ListaEnlazada listaViajeros = new ListaEnlazada();
        listaViajeros.add(new Viajero("Juan", "00000000Z"));
        listaViajeros.add(new Viajero("Jose", "00000000Q"));
        listaViajeros.add(new Viajero("Perico", "00000001A"));

        Grafo<Vertice> mapaVirtual = new Grafo<>();
        Vertice v1 = new Vertice("punto1");
        Vertice v2 = new Vertice("punto2");
        Vertice v3 = new Vertice("punto3");
        Vertice v4 = new Vertice("punto4");
        Vertice v5 = new Vertice("punto5");
        Vertice v6 = new Vertice("punto6");
        mapaVirtual.addVertice(v1);
        mapaVirtual.addVertice(v2);
        mapaVirtual.addVertice(v3);
        mapaVirtual.addVertice(v4);
        mapaVirtual.addVertice(v5);
        mapaVirtual.addVertice(v6);
        mapaVirtual.addArco(v1, v3, 3000);
        mapaVirtual.addArco(v1,v4, 20000);
        mapaVirtual.addArco(v3, v4, 2500);
        mapaVirtual.addArco(v2, v4, 5000);
        mapaVirtual.addArco(v3, v5, 6000);
        mapaVirtual.addArco(v4, v6, 1000);

        while (true) {
            System.out.println();
            Scanner lectura = new Scanner(System.in);
            System.out.println("Introduzca el numero correspondiente a la funcion que desee realizar: ");
            System.out.println("0.- Salir");
            System.out.println("1.- Añadir individuo");
            System.out.println("2.- Añadir punto al mapa");
            System.out.println("3.- Añadir viaje pendiente a un individuo");
            System.out.println("4.- Añadir camino entre puntos");
            System.out.println("5.- Mostrar mapa");
            System.out.println("6.- Mostrar viajeros");
            System.out.println("7.- Efectuar viajes");
            System.out.println("8.- Mostrar información sobre los viajeros");
            int eleccion = lectura.nextInt();
            if (eleccion == 0) {
                break;
            } else if (eleccion == 1) {
                System.out.println();
                addViajeros(listaViajeros);
            } else if (eleccion == 2) {
                System.out.println();
                addPunto(mapaVirtual);
            } else if (eleccion == 3) {
                System.out.println();
                addRutaPendiente(listaViajeros, mapaVirtual);
            } else if (eleccion == 4) {
                System.out.println();
                addCamino(mapaVirtual);
            } else if (eleccion == 5) {
                System.out.println();
                System.out.println("Puntos del mapa:");
                for (int i = 0; i < mapaVirtual.getVertices().getNumeroElementos(); i++) {
                    System.out.println(i + ".- " + mapaVirtual.getVertices().getElemento(i).getData().toString());
                }
                System.out.println();
                System.out.println("Caminos creados:");
                for (int i = 0; i < mapaVirtual.getArcos().getNumeroElementos(); i++) {
                    System.out.println(i + ".- Camino que conecta " + mapaVirtual.getArcos().getElemento(i).getData().getV1().getNombre() +
                            " con " + mapaVirtual.getArcos().getElemento(i).getData().getV2().getNombre() + " y tiene un coste de "
                            + mapaVirtual.getArcos().getElemento(i).getData().getPeso() + " kilómetros.");
                }
            } else if (eleccion == 6) {
                System.out.println();
                for (int i = 0; i < listaViajeros.getNumeroElementos(); i++) {
                    System.out.println(i + ".- " + listaViajeros.getElemento(i).getData().toString());
                }
            } else if (eleccion==7){
                efectuarCamino(listaViajeros, mapaVirtual);
            }else if(eleccion==8){
                mostrarInfoIndividuos(listaViajeros, mapaVirtual);
            } else {
                System.out.println("Opción no válida, escriba un número válido: ");
            }
        }
    }
}
