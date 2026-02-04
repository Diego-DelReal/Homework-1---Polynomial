import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== Creating a Polynomial ===");
            Polynomial poly = new Polynomial();
            
            System.out.println("Adding terms to the polynomial...");
            poly.addTerm(3, 4);
            poly.addTerm(2, 2);
            poly.addTerm(3, 1);
            poly.addTerm(7, 0);

            //Test Case 2
            //poly.addTerm(2, 3);
            //poly.addTerm(4, 1);
            //poly.addTerm(5, 0);

            //Test Case 3
            //poly.addTerm(3, 4);
            //poly.addTerm(2, 3);
            //poly.addTerm(2, 2);
            //poly.addTerm(7, 1);
            //poly.addTerm(12, 0);
            
            System.out.println("\n=== Polynomial After Adding Terms ===");
            System.out.println("Polynomial: " + poly);
            
            System.out.println("\n=== Saving Polynomial 1 to File ===");
            String filename = "poly.txt";
            poly.store(filename);
            System.out.println("Polynomial saved to '" + filename + "'");
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
