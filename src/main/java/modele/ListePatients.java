package modele;

import beans.MonIMC;

import java.util.ArrayList;
import java.util.List;

/**
 * La liste des patients, en mémoire, partagée par les 4 contrôleurs.
 * Elle est créée une seule fois (par ListeServlet.init) et rangée dans le ServletContext.
 */
public class ListePatients {

    public static final String CLE = "listePatients";

    private final List<MonIMC> liste = new ArrayList<>();
    private int prochainId = 1;

    public synchronized List<MonIMC> lister() {
        return new ArrayList<>(liste);
    }

    public synchronized MonIMC trouver(int id) {
        for (MonIMC p : liste) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public synchronized void ajouter(MonIMC p) {
        p.setId(prochainId++);
        liste.add(p);
    }

    /** Remplace les valeurs du patient ayant le même id. */
    public synchronized void modifier(MonIMC nouveau) {
        MonIMC p = trouver(nouveau.getId());
        if (p != null) {
            p.setNom(nouveau.getNom());
            p.setPrenom(nouveau.getPrenom());
            p.setMasse(nouveau.getMasse());
            p.setTaille(nouveau.getTaille());
        }
    }

    public synchronized void supprimer(int id) {
        liste.removeIf(p -> p.getId() == id);
    }
}
