package question3;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author à compléter
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Création", le constructeur d'un auditeur avec son nom, son prénom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son prénom
     * @param matricule
     *            sur la carte d'inscription, près de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        if(chaineVide(nom))
        {
            System.out.println("Entrez votre nom!");
        }
        else this.nom = nom;
        if(chaineVide(prenom))
        {
            System.out.println("Entrez votre prenom!");
        }
        else this.prenom = prenom;
        if(chaineVide(matricule))
        {
            System.out.println("Entrez votre matricule!");
        }
        else this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premières lettres du nom suivies de la première
     * lettre du prénom séparées de '_' . le login retourné est en minuscules,
     * le trait d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des
     * '_' pas de caractères accentués pour le login voir les classes
     * prédéfines, java.lang.String : les méthodes replaceAll, toLowerCase et
     * substring java.lang.Math : la méthode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifié, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {
        String nom = this.nom;
        String prenom = this.prenom;
        /**
         * Pas de caractères accentués pour le login
         */
        nom = sansAccents(nom); //retourner le nom sans accents
        prenom = sansAccents(prenom); //retourner le prenom sans accents
 
        /**
         * Le trait d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des '_' 
         */
        nom = nom.replaceAll("[^a-zA-Z0-9]+","_"); //retourner le nom en remplacent les trait d'union, ou spéciaux <i>(pour unix)</i> par '_' 
        prenom = prenom.replaceAll("[^a-zA-Z0-9]+","_"); //retourner le nom en remplacent les trait d'union, ou spéciaux <i>(pour unix)</i> par '_'

        /**
         * Le login est convertis en minuscules
         */
        String nomAjuste = nom.toLowerCase();
        String prenomAjuste = prenom.toLowerCase();

        /** 
         * Le login est composé des 6 premieres lettres du nom suivies de la première
         * lettre du prénom séparées de '_'  
         */
        
        if(nomAjuste.length()>=6)
        {
            return nomAjuste.substring(0,6) + "_" + prenomAjuste.substring(0,1);
        }
        else return nomAjuste + "_" + prenomAjuste.substring(0,1);
       
    }
    
    /**
    * Méthode pour vérifiez si la Chaine est nulle ou vide.
    */
   public boolean chaineVide(String s) {
        if(s != null && !s.trim().isEmpty())
        {
            return false;
        }
        else return true;
    }
    
   /**
   * Méthode pour enlever les accents , prend un string avec accents et le retourne sans accents
   */
   public String sansAccents(String s){
        String avecAccent = "àâäãéèêëîïìöôòõüûùÀÂÄÃÉÈÊËÎÏÌÖÔÒÕÜÛÙ";//tableau des lettres avec accents
        String sansAccent = "aaaaeeeeiiioooouuuaaaaeeeeiiioooouuu";//tableau ayant les mêmes lettres mais sans accents
        int l = avecAccent.length();
        for(int i = 0; i<l ; i++){
            s = s.replace(avecAccent.charAt(i), sansAccent.charAt(i)); //enlever les accents
        }
        return s;
    }
    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        //return null;// à compléter
        return this.nom;
    }

    /**
     * Lecture du prénom de l'auditeur.
     * 
     * @return son prénom
     */
    public String prenom() {
        //return null;// à compléter
        return this.prenom;
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        //return null;// à compléter
        return this.matricule;
    }

    /**
     * méthode toString ( méthode redéfinie de la classe Object).
     * 
     * @return la concaténation du nom, du prénom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
