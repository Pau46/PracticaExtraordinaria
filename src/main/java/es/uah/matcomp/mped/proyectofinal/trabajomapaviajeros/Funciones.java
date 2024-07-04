package es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros;

import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ElementoLE;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ListaEnlazada;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo.Arco;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo.Camino;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo.Grafo;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo.Vertice;

import java.util.Objects;
import java.util.Scanner;

public class
Funciones {
    public static void addViajeros(ListaEnlazada viajeros) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Introduce tu nombre, viajero: ");
        String nombre = lectura.next();
        System.out.println("Introduce tu DNI: ");
        String dni = lectura.next();
        viajeros.add(new Viajero(nombre, dni));
        System.out.println("Viajero " + nombre + " añadido correctamente!");
        System.out.println();
    }

    public static void addPunto(Grafo<Vertice> mapa) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Introduce el nombre del punto nuevo del mapa: ");
        String nombre = lectura.next();
        mapa.getVertices().add(new Vertice(nombre));
        System.out.println("Nuevo punto con nombre " + nombre + " añadido correctamente!");
        System.out.println();
    }

    public static void addRutaPendiente(ListaEnlazada<Viajero> listaViajeros, Grafo<Vertice> mapa) {
        for (int i = 0; i < listaViajeros.getNumeroElementos(); i++) {
            System.out.println(i + ": " + listaViajeros.getElemento(i).getData().getNombre());
        }
        Scanner lectura = new Scanner(System.in);
        System.out.println("Introduzca el número del viajero que desee modificar: ");
        int individuoElegido = lectura.nextInt();
        System.out.println();
        //System.out.println("Viajero elegido: "+listaViajeros.getElemento(individuoElegido).getData().getNombre());
        for (int i = 0; i < mapa.getVertices().getNumeroElementos(); i++) {
            System.out.println(mapa.getVertices().getElemento(i).getData().getId() + ": " + mapa.getVertices().getElemento(i).getData().getNombre());
        }
        System.out.println("Introduzca el origen del viaje: ");
        int origen = lectura.nextInt();
        System.out.println("Introduzca el destino del viaje: ");
        int destino = lectura.nextInt();
        System.out.println("Desea añadir puntos intermedios? S/N");
        String opcion = lectura.next();
        ListaEnlazada verticesCamino = new ListaEnlazada();
        for (int i = 0; i < mapa.getVertices().getNumeroElementos(); i++) {
            if (mapa.getVertices().getElemento(i).getData().getId() == origen) {
                verticesCamino.add(mapa.getVertices().getElemento(i).getData());
            }
        }
        if (opcion.equals("S")) {
            System.out.println();
            System.out.println("Aquí tiene los puntos del mapa:");
            for (int i = 0; i < mapa.getVertices().getNumeroElementos(); i++) {
                System.out.println(i + ".- " + mapa.getVertices().getElemento(i).getData().toString());
            }
            System.out.println();
            System.out.println("Caminos creados:");
            for (int i = 0; i < mapa.getArcos().getNumeroElementos(); i++) {
                System.out.println(i + ".- Camino que conecta " + mapa.getArcos().getElemento(i).getData().getV1().getNombre() +
                        " con " + mapa.getArcos().getElemento(i).getData().getV2().getNombre() + " y tiene un coste de "
                        + mapa.getArcos().getElemento(i).getData().getPeso() + " kilómetros.");
            }
            System.out.println("Escriba el id de los puntos intermedios, y al finalizar escriba 'fin'");

            String entrada = lectura.next();
            int intEntrada;
            while (!Objects.equals(entrada, "fin")) {
                try {
                    intEntrada = Integer.parseInt(entrada);
                    if (intEntrada >= 0 && intEntrada <= mapa.getVertices().getNumeroElementos()) {
                        for (int i = 0; i < mapa.getVertices().getNumeroElementos(); i++) {
                            if (mapa.getVertices().getElemento(i).getData().getId() == intEntrada) {
                                verticesCamino.add(mapa.getVertices().getElemento(i).getData());
                            }
                        }
                    } else {
                        System.out.println("Por favor, escriba un número válido, o 'fin' para terminar: ");
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, escriba un número válido, o 'fin' para terminar: ");
                    e.printStackTrace();
                }
                entrada = lectura.next();
            }
        }
        for (int i = 0; i < mapa.getVertices().getNumeroElementos(); i++) {
            if (mapa.getVertices().getElemento(i).getData().getId() == destino) {
                verticesCamino.add(mapa.getVertices().getElemento(i).getData());
            }
        }
        if (listaViajeros.getElemento(individuoElegido).getData().getRutasPendientes() != null) {
            listaViajeros.getElemento(individuoElegido).getData().getRutasPendientes().add(new Camino(verticesCamino.invertir()));
        } else {
            listaViajeros.getElemento(individuoElegido).getData().setRutasPendientes(new ListaEnlazada<>(new ElementoLE(new Camino(verticesCamino.invertir()))));
        }
        Camino camino = listaViajeros.getElemento(individuoElegido).getData().getRutasPendientes().getPrimero().getData();
        System.out.println("Ha añadido al viajero " + listaViajeros.getElemento(individuoElegido).getData().getNombre() + " el siguiente camino: ");
        for (int i = 0; i < camino.getCaminoDeVertices().getNumeroElementos(); i++) {
            int num = i + 1;
            System.out.println("Punto " + num + "  ->  " + new Camino(verticesCamino.invertir()).getCaminoDeVertices().getElemento(i).getData().getNombre());
        }
    }

    public static void addCamino(Grafo<Vertice> mapa) {
        Scanner lectura = new Scanner(System.in);
        ListaEnlazada verticesMapa = mapa.getVertices();
        for (int i = 0; i < verticesMapa.getNumeroElementos(); i++) {
            System.out.println(i + ".- " + verticesMapa.getElemento(i).getData().toString());
        }
        System.out.println("Introduzca el origen del camino: ");
        int origen = lectura.nextInt();
        System.out.println("Introduzca el fin del camino: ");
        int fin = lectura.nextInt();
        System.out.println("Introduzca la distancia del camino: ");
        int coste = lectura.nextInt();
        while (coste > 50000 || coste < 0) {
            System.out.println("Introduzca una distancia entre 0 y 50000 km por favor: ");
            coste = lectura.nextInt();
        }
        Vertice v1 = null;
        Vertice v2 = null;
        int pos1 = -1;
        int pos2 = -1;
        for (int x= 0; x<mapa.getVertices().getNumeroElementos(); x++) {
            if (mapa.getVertices().getElemento(x).getData().getId() == origen) {
                v1=mapa.getVertices().getElemento(x).getData();
                mapa.getVertices().getElemento(x).getData().setConectado(true);
                pos1=x;
            }
            if (mapa.getVertices().getElemento(x).getData().getId() == fin) {
                v2=mapa.getVertices().getElemento(x).getData();
                mapa.getVertices().getElemento(x).getData().setConectado(true);
                pos2=x;
            }
        }
        if (pos1!=-1 && pos2!=-1){
            mapa.getVertices().getElemento(pos1).getData().getFrontera().add(mapa.getVertices().getElemento(pos2).getData());
            mapa.getVertices().getElemento(pos2).getData().getFrontera().add(mapa.getVertices().getElemento(pos1).getData());
        }
        Arco<Vertice> arco = new Arco<Vertice>(v1, v2, coste);
        mapa.addArco(arco);
        System.out.println("Nuevo camino desde " + arco.getV1().getNombre() + " hasta " + arco.getV2().getNombre() + " con coste de " + coste + " añadido correctamente !");
    }

    public static void efectuarCamino(ListaEnlazada<Viajero> listaViajeros, Grafo<Vertice> mapa) {
        for (int i = 0; i < listaViajeros.getNumeroElementos(); i++) {
            if (listaViajeros.getElemento(i).getData().getRutasPendientes() != null) {
                int contadorCosteTotal = 0;
                for (int j = 0; j < listaViajeros.getElemento(i).getData().getRutasPendientes().getNumeroElementos(); j++) {
                    Viajero viajeroActual = listaViajeros.getElemento(i).getData();
                    System.out.println();
                    System.out.println("Efectuando ruta pendiente de " + viajeroActual.getNombre() + " con DNI " + viajeroActual.getDni());
                    ListaEnlazada<Vertice> caminoEfectuar = viajeroActual.getRutasPendientes().getElemento(j).getData().getCaminoDeVertices();
                    for (int k = 0; k < caminoEfectuar.getNumeroElementos() - 1; k++) {
                        int idSiguiente = caminoEfectuar.getElemento(k).getSiguiente().getData().getId();
                        for (int l = 0; l < caminoEfectuar.getElemento(k).getData().getFrontera().getNumeroElementos(); l++) {
                            //Aquí entramos solo si el camino es posible
                            if (caminoEfectuar.getElemento(k).getData().getFrontera().getElemento(l).getData().getId() == idSiguiente) {
                                for (int m = 0; m < mapa.getArcos().getNumeroElementos(); m++) {
                                    Arco<Vertice> arcoActual = mapa.getArcos().getElemento(m).getData();
                                    if ((arcoActual.getV1().getId() == caminoEfectuar.getElemento(k).getData().getId() || arcoActual.getV1().getId() == idSiguiente) && (arcoActual.getV2().getId() == caminoEfectuar.getElemento(k).getData().getId() || arcoActual.getV2().getId() == idSiguiente)) {
                                        contadorCosteTotal = contadorCosteTotal + arcoActual.getPeso();
                                    }
                                }
                            }
                        }

                    }
                    System.out.println();
                    int num = j + 1;
                    System.out.println("La ruta " + num + " del viajero actual se ha efectuado correctamente, se han añadido los kilómetros recorridos al perfil y se ha añadido a rutas realizadas.");
                    listaViajeros.getElemento(i).getData().setKilometrosRecorridos(listaViajeros.getElemento(i).getData().getKilometrosRecorridos() + contadorCosteTotal);
                    Camino caminoEfectuado = viajeroActual.getRutasPendientes().getElemento(j).getData();
                    listaViajeros.getElemento(i).getData().getRutasRealizadas().add(caminoEfectuado);

                }
            }
            listaViajeros.getElemento(i).getData().setRutasPendientes(new ListaEnlazada<Camino>());
        }
    }

    public static void mostrarInfoIndividuos(ListaEnlazada<Viajero> listaViajeros, Grafo<Vertice> mapa) {
        System.out.println();
        for (int i = 0; i < listaViajeros.getNumeroElementos(); i++) {
            System.out.println(i + ": " + listaViajeros.getElemento(i).getData().getNombre());
        }
        while (true) {
            System.out.println();
            System.out.println("Elija la informaión que desee saber acerca de los viajeros: ");
            System.out.println("0.- Salir");
            System.out.println("1.- Rutas pendientes");
            System.out.println("2.- Rutas realizadas");
            System.out.println("3.- Kilometros recorridos");
            Scanner lectura = new Scanner(System.in);
            int opcion = lectura.nextInt();
            if (opcion == 0) {
                break;
            } else if (opcion == 1) {
                System.out.println();
                for (int i = 0; i < listaViajeros.getNumeroElementos(); i++) {
                    System.out.println();
                    System.out.println("Rutas pendientes de " + listaViajeros.getElemento(i).getData().getNombre() + ":");
                    for (int j = 0; j < listaViajeros.getElemento(i).getData().getRutasPendientes().getNumeroElementos(); j++) {
                        int num=j+1;
                        System.out.println(num + ".- " + listaViajeros.getElemento(i).getData().getRutasPendientes().getElemento(j).getData().toString());
                    }
                }
            } else if (opcion == 2) {
                System.out.println();
                for (int i = 0; i < listaViajeros.getNumeroElementos(); i++) {
                    System.out.println();
                    System.out.println("Rutas realizadas de " + listaViajeros.getElemento(i).getData().getNombre() + ":");
                    for (int j = 0; j < listaViajeros.getElemento(i).getData().getRutasRealizadas().getNumeroElementos(); j++) {
                        int num=j+1;
                        System.out.println(num+ ".- " + listaViajeros.getElemento(i).getData().getRutasRealizadas().getElemento(j).getData().toString());
                    }
                }
            } else if (opcion == 3) {
                System.out.println();
                for (int i = 0; i < listaViajeros.getNumeroElementos(); i++) {
                    System.out.println();
                    System.out.println("Kilómetros recorridos de " + listaViajeros.getElemento(i).getData().getNombre() + ": " + listaViajeros.getElemento(i).getData().getKilometrosRecorridos() + "kms en total. ");
                }
            } else {
                System.out.println("Opción no válida, por favor escriba una opción válida: ");
            }
        }
    }
}

