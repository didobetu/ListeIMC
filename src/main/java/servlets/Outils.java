package servlets;

import jakarta.servlet.http.HttpServlet;
import modele.ListePatients;

/** Récupère la liste partagée créée par ListeServlet.init(). */
final class Outils {
    private Outils() {
    }

    static ListePatients liste(HttpServlet servlet) {
        return (ListePatients) servlet.getServletContext().getAttribute(ListePatients.CLE);
    }
}
