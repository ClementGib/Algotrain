<p>
La méthode de la "fenêtre glissante" (sliding window) en algorithmique est une technique efficace pour résoudre divers problèmes qui impliquent des sous-ensembles continus de données. Cette technique utilise deux pointeurs (généralement appelés gauche et droite) pour représenter une fenêtre dynamique qui glisse sur la structure de données, souvent un tableau ou une chaîne de caractères.

Voici une définition simple :
Fenêtre glissante : une méthode qui permet de parcourir un tableau ou une chaîne de caractères en maintenant une sous-séquence (ou fenêtre) de taille variable. Cette sous-séquence est définie par deux indices (gauche et droite) qui peuvent se déplacer pour inclure ou exclure des éléments tout en respectant certaines contraintes.

Exemple en Java : Éviter les répétitions dans une chaîne de caractères

Supposons que nous voulons trouver la longueur de la plus longue sous-chaîne sans caractères répétitifs dans une chaîne donnée. Nous allons utiliser la technique de la fenêtre glissante avec un HashSet pour vérifier la présence de caractères dupliqués.

Voici un exemple de code Java :
</p>

‘‘‘java
    public static int longueurMaxSousChaine(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0, right = 0;
        HashSet<Character> uniqueChars = new HashSet<>();

        while (right < n) {
            if (!uniqueChars.contains(s.charAt(right))) {
                uniqueChars.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
‘‘‘

<p>
Explication du code :

On initialise deux pointeurs, left et right, au début de la chaîne.
On utilise un HashSet pour garder une trace des caractères uniques dans la fenêtre actuelle.
On déplace le pointeur right pour agrandir la fenêtre tant que le caractère à la position right n'est pas dans le HashSet.
Si le caractère est déjà présent, on déplace le pointeur left pour réduire la fenêtre jusqu'à ce que le caractère en double soit supprimé du HashSet.
À chaque étape, on met à jour la longueur maximale de la sous-chaîne sans répétition.
La fonction retourne la longueur de la plus longue sous-chaîne trouvée.
Ce code illustre comment la technique de la fenêtre glissante peut être utilisée pour résoudre des problèmes d'optimisation sur des sous-séquences continues d'une chaîne de caractères.
</p>