package main;

import java.util.Map;
import java.util.TreeMap;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;
    /**
     * Le genre du personnage
     */
    protected Genre genre;

    protected Map<TypeJauge, Integer> JaugeHashMap;

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     * @param genre Le genre du personnage
     */
    public Personnage(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;

        // Initialisation des jauges entre 15 et 35 points
        this.JaugeHashMap = new TreeMap<>();
        JaugeHashMap.put(TypeJauge.CLERGE, 15 + (int)(Math.random() * (35 - 15)));
        JaugeHashMap.put(TypeJauge.ARMEE, 15 + (int)(Math.random() * (35 - 15)));
        JaugeHashMap.put(TypeJauge.PEUPLE, 15 + (int)(Math.random() * (35 - 15)));
        JaugeHashMap.put(TypeJauge.FINANCE, 15 + (int)(Math.random() * (35 - 15)));
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
        public void AfficheJauges(Map<TypeJauge, Integer> jauges) {
            afficheJauge(jauges);
        }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     */

    private void afficheJauge(Map<TypeJauge, Integer> jauges) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<TypeJauge, Integer> jauge : jauges.entrySet()) {
            // on complète avec ____
            // affichage du nom
            result.append("[").append("#".repeat(Math.max(0, jauge.getValue()))).append(
                            // on complète avec ____
                            "_".repeat(Math.max(0, 50 - (Math.max(jauge.getValue(), 0))))).append("] ")
                    // on ajoute le nom de la jauge (avec un espace à la fin pour afficher ...
                    .append(jauge.getKey()).append(" ")
                    // ... la valeur exacte de la jauge
                    .append(jauge.getValue())
                    // retours à la ligne pour affichage "propre"
                    .append("\n");
        }
        System.out.println(result);
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu(Map<TypeJauge, Integer> jauges){
        for (Map.Entry<TypeJauge, Integer> jauge : jauges.entrySet()) {
            if (jauge.getValue() <= 0 || jauge.getValue() >= 50) {
                System.out.println(jauge.getKey() + " est la raison de ta perte (noob)");
                return true;
            }
        }
        return false;
    }


    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retourne le genre du personnage
     * @return le genre du personnage
     */
    public Genre getGenre() {
        return genre;
    }
    /**
     * Modifie le genre du personnage
     * @param genre Le nouveau genre du personnage
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
