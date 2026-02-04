import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
    private ArrayList<Term> terms;

    public Polynomial() {
        terms = new ArrayList<>();
    }

    public void addTerm(int coefficient, int exponent) {
        for (Term term : terms) {
            if (term.getExponent() == exponent) {
                term.setCoefficient(term.getCoefficient() + coefficient);
                return;
            }
        }
        terms.add(new Term(coefficient, exponent));
        Collections.sort(terms);
    }

    @Override
    public String toString() {
        if (terms.isEmpty()) {
            return "0";
        }

    StringBuilder result = new StringBuilder();
        for (int i = 0; i < terms.size(); i++) {
            Term term = terms.get(i);
            int coefficient = term.getCoefficient();

            if (coefficient == 0) {
                continue;
            }

            if (i == 0) {
                result.append(term.toString());
            } else {
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

    public void store(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Term term : terms) {
                writer.println(term.getCoefficient() + " " + term.getExponent());
            }
        }
    }
}