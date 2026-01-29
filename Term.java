public class Term implements Comparable<Term> {
    private int coefficient;
    private int exponent;

    /**
     * Constructor for Term class
     * @param coefficient the coefficient of the term
     * @param exponent the exponent of the term
     */
    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    /**
     * Gets the coefficient of the term
     * @return the coefficient
     */
    public int getCoefficient() {
        return coefficient;
    }

    /**
     * Sets the coefficient of the term
     * @param coefficient the new coefficient
     */
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * Gets the exponent of the term
     * @return the exponent
     */
    public int getExponent() {
        return exponent;
    }

    /**
     * Sets the exponent of the term
     * @param exponent the new exponent
     */
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    /**
     * Returns the term in proper format
     * @return a string representation of the term (e.g., 3x^4)
     */
    @Override
    public String toString() {
        if (exponent == 0) {
            return String.valueOf(coefficient);
        } else if (exponent == 1) {
            return coefficient + "x";
        } else {
            return coefficient + "x^" + exponent;
        }
    }

    /**
     * Compares two terms by exponent
     * @param obj the object to compare with
     * @return true if both terms have the same exponent, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Term term = (Term) obj;
        return this.exponent == term.exponent;
    }

    /**
     * Compares terms by exponent in descending order
     * @param other the term to compare with
     * @return a negative integer if this term's exponent is greater,
     *         a positive integer if this term's exponent is smaller,
     *         zero if they are equal
     */
    @Override
    public int compareTo(Term other) {
        // Descending order: larger exponents come first
        return other.exponent - this.exponent;
    }
}
