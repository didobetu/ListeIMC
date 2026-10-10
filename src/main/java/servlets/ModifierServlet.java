package servlets;

import beans.MonIMC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/** Contrôleur n°3 : MODIFIER un patient (GET = formulaire pré-rempli, POST = mise à jour). */
@WebServlet("/modifier")
public class ModifierServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MonIMC p = Outils.liste(this).trouver(Integer.parseInt(req.getParameter("id")));
            if (p == null) {
                resp.sendRedirect(req.getContextPath() + "/patients");
                return;
            }
            req.setAttribute("patient", p);
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/patients");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/vues/modifier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            MonIMC p = Saisie.lire(req);
            p.setId(id);
            Outils.liste(this).modifier(p);
        } catch (IllegalArgumentException e) {
            req.setAttribute("erreur", e.getMessage());
            req.setAttribute("patient", Outils.liste(this).trouver(id));
            req.getRequestDispatcher("/WEB-INF/vues/modifier.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/patients");
    }
}
