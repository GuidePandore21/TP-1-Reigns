package main;

public class GameLoop extends Reigns{
    /**
     * La méthode main lance le jeu Reigns.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){

        // début du jeu
        System.out.println("Bienvenue sur Reigns");

        initBanqueQuestions();

        System.out.println("Création du personnage...");

        initPersonnage();

        personnage.AfficheJauges(personnage.JaugeHashMap);

        // tirage des questions
        int nbTours = 0;
        while(!personnage.finDuJeu(personnage.JaugeHashMap)){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            personnage.AfficheJauges(personnage.JaugeHashMap);
        }

        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }
}
