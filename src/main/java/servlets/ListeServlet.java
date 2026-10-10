package servlets;

import beans.MonIMC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.ListePatients;

import java.io.IOException;

/**
 * Contrôleur n°1 : AFFICHER la liste.
 * init() crée la liste (une seule fois) et la partage avec les autres contrôleurs ;
 * le remplissage avec les patients de départ est fait à part, dans chargerPatientsDeDepart().
 */
@WebServlet(urlPatterns = "/patients", loadOnStartup = 1)
public class ListeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ListePatients liste;

    @Override
    public void init() throws ServletException {
        liste = new ListePatients();
        // Rend la liste accessible aux autres contrôleurs (portée application)
        getServletContext().setAttribute(ListePatients.CLE, liste);
        chargerPatientsDeDepart();
    }

    /** Les patients de départ, séparés de init(). */
    private void chargerPatientsDeDepart() {
        liste.ajouter(new MonIMC(0, "DIOP", "Daouda", 70, 1.70));
        liste.ajouter(new MonIMC(0, "Dieudonné", "Betukumesu", 50, 1.50));
        liste.ajouter(new MonIMC(0, "Nicolas", "Ouedraogo", 85, 1.82));
        liste.ajouter(new MonIMC(0, "Marceline", "nseya", 110, 1.75));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients", liste.lister());
        req.getRequestDispatcher("/WEB-INF/vues/liste.jsp").forward(req, resp);
    }
}
