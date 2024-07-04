package es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo;


import es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas.ListaEnlazada;

public class Camino {
    ListaEnlazada<Vertice> caminoDeVertices;
    int coste;

    public Camino(ListaEnlazada<Vertice> caminoDeVertices, int coste) {
        this.caminoDeVertices = caminoDeVertices;
        this.coste = coste;
    }

    public Camino(ListaEnlazada<Vertice> caminoDeVertices) {
        this.caminoDeVertices = caminoDeVertices;
    }

    public double getCoste() {
        return coste;
    }

    public ListaEnlazada<Vertice> getCaminoDeVertices() {
        return caminoDeVertices;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        ListaEnlazada<Vertice> caminoCorrecto = this.caminoDeVertices.invertir();
        texto.append("\n    Origen: "+caminoCorrecto.getPrimero().getData().getNombre());
        texto.append("\n    Destino: " + caminoCorrecto.getUltimo().getData().getNombre());
        if (caminoCorrecto.getNumeroElementos()>2){
            texto.append("\n    Puntos intermedios: ");
            for (int i = 1; i < caminoCorrecto.getNumeroElementos()-1; i++) {
                texto.append(caminoCorrecto.getElemento(i).getData().getNombre()+" ");
            }
        }
        return texto.toString();
    }
}
