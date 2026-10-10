package servlets;

import beans.MonIMC;
import jakarta.servlet.http.HttpServletRequest;

/** Lecture et validation du formulaire (partagée par AjouterServlet et ModifierServlet). */
final class Saisie {

    private Saisie() {
    }

    /** Retourne le patient lu dans le formulaire ; lève IllegalArgumentException avec le message d'erreur. */
    static MonIMC lire(HttpServletRequest req) {
        String nom = req.getParameter("nom") == null ? "" : req.getParameter("nom").trim();
        String prenom = req.getParameter("prenom") == null ? "" : req.getParameter("prenom").trim();
        if (nom.isEmpty() || prenom.isEmpty()) {
            throw new IllegalArgumentException("Le nom et le prénom sont obligatoires.");
        }
        double masse, taille;
        try {
            masse = Double.parseDouble(req.getParameter("masse").trim().replace(',', '.'));
            taille = Double.parseDouble(req.getParameter("taille").trim().replace(',', '.'));
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("La masse et la taille doivent être des nombres.");
        }
        if (masse <= 0 || taille <= 0) {
            throw new IllegalArgumentException("La masse et la taille doivent être supérieures à 0.");
        }
        MonIMC p = new MonIMC();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setMasse(masse);
        p.setTaille(taille);
        return p;
    }
}
