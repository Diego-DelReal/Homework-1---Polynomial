public class Term implements Comparable<Term> {
    private int coefficient;
    private int exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

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

    @Override
    public int compareTo(Term other) {
        if (this.exponent != other.exponent) {
            return other.exponent - this.exponent;
        }
        return other.coefficient - this.coefficient;
    }
}
