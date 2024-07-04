module es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros to javafx.fxml;
    exports es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros;
    exports es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo;
    opens es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.grafo to javafx.fxml;
    exports es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas;
    opens es.uah.matcomp.mped.proyectofinal.trabajomapaviajeros.Listas to javafx.fxml;
}