import java.util.List;

// Calcul de prime progressive On souhaite rédiger l'algorithme "CalculPrimeProgressive" 
// permettant de calculer la prime d'un commercial. 
// La prime d'un commercial est calculée selon un barème progressif à partir du chiffre d'affaires qu'il a réalisé. 
// Le barème est le suivant : 
// Chiffre d'affaires (CA) Prime (%) 
// ≤ 100.000 0%
// > 100.000 et ≤ 250.000 2% 
// > 250.000 et < 500.000 5% 
// > 500.000 10%

// La prime d'un commercial ayant réalisé:
// 400000€ de CA est de (250.000-100.000) x2% + (400.000-250.000) x 5% = 3.000 + (400.000-250.000) × 5% = 10500€

public class Prime {

    private static final List<Slice> slices = List.of(
        new Slice(100000, 0.00), // 0% jusqu'à 100.000
        new Slice(150000, 0.02), // 2% entre 100.000 et 250.000 (250.000 - 100.000)
        new Slice(250000, 0.05), // 5% entre 250.000 et 500.000 (500.000 - 250.000)
        new Slice(Double.MAX_VALUE, 0.10) // 10% au-delà de 500.000
    );

    public static void main(String[] args) {
        System.out.println("Prime for CA 600000: " + calculPrimeProgressive(600000));
        System.out.println("Prime for CA 400000: " + calculPrimeProgressive(400000));
    }

    // Classe statique pour éviter les erreurs de contexte
    public static class Slice {
        double sliceValue;
        double percentage;

        public Slice(double sliceValue, double percentage) {
            this.sliceValue = sliceValue;
            this.percentage = percentage;
        }
    }

    private static double calculPrimeProgressive(double CA) {
        double prime = 0;
        double remainingCA = CA;
        double previousThreshold = 0;

        for (Slice slice : slices) {
            if (remainingCA <= previousThreshold) break; // Si plus de CA à traiter, on arrête

            double applicableCA = Math.min(remainingCA - previousThreshold, slice.sliceValue);
            prime += apply(applicableCA, slice.percentage);
            previousThreshold += slice.sliceValue; // On avance dans les tranches
        }

        return prime;
    }

    private static double apply(double ca, double percentage) {
        return (ca > 0) ? ca * percentage : 0;
    }
}
