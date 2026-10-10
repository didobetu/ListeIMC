package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/** Contrôleur n°4 : SUPPRIMER un patient (POST uniquement : une suppression ne doit pas se faire par simple lien). */
@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Outils.liste(this).supprimer(Integer.parseInt(req.getParameter("id")));
        } catch (NumberFormatException ignore) {
            // identifiant invalide : on ne fait rien
        }
        resp.sendRedirect(req.getContextPath() + "/patients");
    }
}
