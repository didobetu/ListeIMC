# PROJET IMC – Développement Web avec JEE

Application web **Jakarta EE 10** (Servlets, JSP, EL, JSTL) : liste de patients et calcul de l'IMC.
Les données sont en mémoire (réinitialisées au redémarrage de Tomcat).

## Architecture MVC : un contrôleur par action
| Rôle | Fichier |
|---|---|
| Modèle (Bean) | `beans/MonIMC.java` |
| Modèle (liste en mémoire) | `modele/ListePatients.java` |
| Contrôleur – lister, `init()` | `servlets/ListeServlet.java` (`/patients`) |
| Contrôleur – ajouter | `servlets/AjouterServlet.java` (`/ajouter`) |
| Contrôleur – modifier | `servlets/ModifierServlet.java` (`/modifier`) |
| Contrôleur – supprimer | `servlets/SupprimerServlet.java` (`/supprimer`, POST) |
| Vues (JSP + EL + JSTL) | `webapp/WEB-INF/vues/*.jsp` |

`ListeServlet.init()` crée la liste et la partage (ServletContext) ; le chargement des 4 patients de départ est fait à part dans `chargerPatientsDeDepart()`.

## Installation
1. Placer dans `src/main/webapp/WEB-INF/lib/` : `jakarta.servlet.jsp.jstl-api-3.0.0.jar` et `jakarta.servlet.jsp.jstl-3.0.1.jar`.
2. Déployer sur **Tomcat 10.1** (Eclipse : Export > WAR, copier dans `webapps/`).
3. Ouvrir http://localhost:8080/ListeIMC/patients
