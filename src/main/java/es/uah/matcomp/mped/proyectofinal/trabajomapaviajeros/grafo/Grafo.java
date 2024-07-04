package es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo;



import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ElementoLE;
import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ListaEnlazada;

public class Grafo<TipoDato> {
    private ListaEnlazada<Vertice> vertices;
    private ListaEnlazada<Arco<Vertice>> arcos;

    public Grafo(ListaEnlazada<Vertice> vertices, ListaEnlazada<Arco<Vertice>> arcos) {
        this.vertices = vertices;
        this.arcos = arcos;
    }


    public Grafo() {
        this.vertices = new ListaEnlazada<>();
        this.arcos = new ListaEnlazada<>();
    }

    public void addVertice(Vertice vertice) {
        if (vertices.isVacia()) {
            vertices.add(vertice);
        } else {
            boolean bool = false;//Suponemos que el vértice que vamos a añadir no está presente en nuestro grafo
            for (int x = 0; x < vertices.getNumeroElementos(); x++) {
                if (vertice.getId() == vertices.getElemento(x).getData().getId()) {
                    bool = true;//Ahora lo cambiamos en el momento en el que detectemos que este. Solo se mete aquí si está en la lista de vértices
                }
            }
            if (!bool) {
                vertices.add(vertice);
            }
        }
    }


    public void deleteVertice(Vertice vertice) {
        if (vertices.isVacia()) {
            System.out.println("ERROR ESTA VACIA");
        } else {
            for (int x = 0; x < vertices.getNumeroElementos(); x++) {
                if (vertice.getId() == vertices.getElemento(x).getData().getId()) {
                    //ListaEnlazada<Arco<TipoDato>> listaFrontera=vertices.getElemento(x).getData().getFrontera();
                    //for (int y = 0; y <= listaFrontera.getNumeroElementos(); y++) {
                    //    listaFrontera.delete(y);
                    //}
                    vertices.delete(x);
                }
            }
        }
    }

    public boolean buscarVertice(Vertice vertice) {
        if (vertices.isVacia()) {
            return false;
        } else {
            for (int x = 0; x < vertices.getNumeroElementos(); x++) {
                if (vertice.getId() == vertices.getElemento(x).getData().getId()) {
                    return true;
                }
            }
            return false;
        }
    }

    public void addArco(Vertice v1, Vertice v2, int peso) {
        Arco<Vertice> arcoNuevo = new Arco<Vertice>(v1, v2, peso);
        if (vertices.getPosicion(new ElementoLE<Vertice>(v1)) >-1 && vertices.getPosicion(new ElementoLE<Vertice>(v2)) > -1) {
            ElementoLE<Arco<Vertice>> arcoNuevoElem = new ElementoLE<Arco<Vertice>>(arcoNuevo);
            if (arcos.getPosicion(arcoNuevoElem) == -1) {
                arcos.add(arcoNuevo);
                v1.getFrontera().add(v2);
                v2.getFrontera().add(v1);
                v1.setConectado(true);
                v2.setConectado(true);
            }
        }
    }


    public ListaEnlazada<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ListaEnlazada<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ListaEnlazada<Arco<Vertice>> getArcos() {
        return arcos;
    }

    public void setArcos(ListaEnlazada<Arco<Vertice>> arcos) {
        this.arcos = arcos;
    }

    public void addArco(Arco<Vertice> arco) {
        this.arcos.add(arco);
    }
}



