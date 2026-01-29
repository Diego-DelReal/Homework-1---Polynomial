import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
    private ArrayList<Term> terms;

    /**
     * Constructor for Polynomial class
     * Initializes an empty list of terms
     */
    public Polynomial() {
        terms = new ArrayList<>();
    }

    /**
     * Adds a new term to the polynomial and combines like terms
     * @param coefficient the coefficient of the term
     * @param exponent the exponent of the term
     */
    public void addTerm(int coefficient, int exponent) {
        // Search for an existing term with the same exponent
        for (Term term : terms) {
            if (term.getExponent() == exponent) {
                // Combine like terms by adding coefficients
                term.setCoefficient(term.getCoefficient() + coefficient);
                return;
            }
        }
        // If no like term exists, add the new term
        terms.add(new Term(coefficient, exponent));
        // Sort terms in descending order of exponents
        Collections.sort(terms);
    }

    /**
     * Returns the polynomial as a string
     * @return the polynomial in standard form
     */
    @Override
    public String toString() {
        if (terms.isEmpty()) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < terms.size(); i++) {
            Term term = terms.get(i);
            int coefficient = term.getCoefficient();

            // Skip terms with zero coefficient
            if (coefficient == 0) {
                continue;
            }

            // Add sign and coefficient
            if (i == 0) {
                // First term
                result.append(term.toString());
            } else {
                // Subsequent terms
                if (coefficient > 0) {
                    result.append(" + ");
                } else {
                    result.append(" - ");
                    coefficient = Math.abs(coefficient);
                }
                
                if (term.getExponent() == 0) {
                    result.append(coefficient);
                } else if (term.getExponent() == 1) {
                    result.append(coefficient).append("x");
                } else {
                    result.append(coefficient).append("x^").append(term.getExponent());
                }
            }
        }

        return result.toString().isEmpty() ? "0" : result.toString();
    }

    /**
     * Saves the polynomial to a file
     * @param filename the name of the file to save to
     * @throws IOException if an I/O error occurs
     */
    public void store(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println(this.toString());
        }
    }

    /**
     * Loads a polynomial from a file
     * @param filename the name of the file to load from
     * @return a new Polynomial object loaded from the file
     * @throws IOException if an I/O error occurs
     */
    public static Polynomial load(String filename) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename))).trim();
        Polynomial polynomial = new Polynomial();
        
        // Parse the polynomial string and reconstruct it
        // This is a simple parser for the polynomial format
        if (content.isEmpty() || content.equals("0")) {
            return polynomial;
        }
        
        // Replace minus signs with addition of negative numbers
        content = content.replaceAll(" - ", " + -");
        
        // Split by + to get individual terms
        String[] termStrings = content.split("\\+");
        
        for (String termStr : termStrings) {
            termStr = termStr.trim();
            if (termStr.isEmpty()) {
                continue;
            }
            
            int coefficient = 0;
            int exponent = 0;
            
            if (termStr.contains("x")) {
                // Term with x
                String[] parts = termStr.split("x");
                coefficient = Integer.parseInt(parts[0].isEmpty() ? "1" : parts[0]);
                
                if (parts.length > 1 && !parts[1].isEmpty()) {
                    // x^exponent format
                    exponent = Integer.parseInt(parts[1].substring(1)); // Skip the ^
                } else {
                    // Just x format
                    exponent = 1;
                }
            } else {
                // Just a coefficient
                coefficient = Integer.parseInt(termStr);
                exponent = 0;
            }
            
            polynomial.addTerm(coefficient, exponent);
        }
        
        return polynomial;
    }
}
