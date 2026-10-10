package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/** Contrôleur n°2 : AJOUTER un patient (GET = formulaire, POST = enregistrement). */
@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vues/ajouter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Outils.liste(this).ajouter(Saisie.lire(req));
        } catch (IllegalArgumentException e) {
            req.setAttribute("erreur", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/vues/ajouter.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/patients");
    }
}
