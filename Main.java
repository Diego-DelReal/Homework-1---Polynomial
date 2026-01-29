import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a polynomial
            System.out.println("=== Creating a Polynomial ===");
            Polynomial poly = new Polynomial();
            
            // Add several terms
            System.out.println("Adding terms to the polynomial...");
            poly.addTerm(3, 4);      // 3x^4
            poly.addTerm(2, 2);      // 2x^2
            poly.addTerm(-5, 1);     // -5x
            poly.addTerm(7, 0);      // 7
            poly.addTerm(1, 4);      // 1x^4 (will combine with 3x^4)
            
            // Print the polynomial
            System.out.println("\n=== Polynomial After Adding Terms ===");
            System.out.println("Polynomial: " + poly);
            
            // Save to file
            System.out.println("\n=== Saving Polynomial to File ===");
            String filename = "polynomial.txt";
            poly.store(filename);
            System.out.println("Polynomial saved to '" + filename + "'");
            
            // Load from file and print
            System.out.println("\n=== Loading Polynomial from File ===");
            Polynomial loadedPoly = Polynomial.load(filename);
            System.out.println("Loaded polynomial: " + loadedPoly);
            
            // Demonstrate the Term class
            System.out.println("\n=== Demonstrating Term Class ===");
            Term t1 = new Term(5, 3);
            Term t2 = new Term(2, 3);
            Term t3 = new Term(7, 2);
            
            System.out.println("Term 1: " + t1);
            System.out.println("Term 2: " + t2);
            System.out.println("Term 3: " + t3);
            System.out.println("t1 equals t2 (same exponent)? " + t1.equals(t2));
            System.out.println("t1 equals t3? " + t1.equals(t3));
            System.out.println("t1.compareTo(t3) (should be negative, t1 has larger exponent): " + t1.compareTo(t3));
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
