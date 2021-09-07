class Rational {
    long numerator,denominator; 

    class Illegal extends Exception { 
        String reason; 
        Illegal (String reason) { 
            this.reason = reason; 
        } 
    } 

    Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    Rational(long numerator, long denominator) throws Illegal {
        this.numerator = numerator;
        this.denominator = denominator;
        if(denominator == 0) throw new Illegal("Denominator can't be 0");
        simplestForm();
    }

    // find the reduce form 
    private void simplestForm() { 
        long computeGCD; 
        computeGCD = GCD(Math.abs(numerator), denominator); 
        numerator /= computeGCD; 
        denominator /= computeGCD; 
    } 

    // find the greatest common denominator 
    private long GCD(long a, long b) { 
        if (a%b ==0) return b; 
        else return GCD(b,a%b); 
    }

    /***
     * Compute an addition of the current rational number to another given rational number
     * @param x the rational number to be added to the current rational number
     */
    public void add(Rational x) { 
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator); 
        simplestForm(); 
    }

    /***
     * Compute a subtraction of the current rational number to another given rational number
     * @param x the rational number to be subtracted from the current rational number
     */
    public void subtract(Rational x) {
        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a multiplication of the current rational number to another given rational number
     * @param x the rational number to be multiplied to the current rational number
     */
    public void multiply(Rational x) { 
        numerator *= x.numerator;
        denominator *= x.denominator;
        simplestForm();
    }

    /***
     * Compute a division of the current rational number to another given rational number
     * @param x the rational number to be divided by the current rational number
     */
    public void divide(Rational x) {
        numerator *= x.denominator;
        denominator *= x.numerator;
        simplestForm();
    }

    /***
     * Check if the given rational number equals to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return true if the given rational number equals to the current, false otherwise
     */
    public boolean equals(Object x) {
        simplestForm();
        if(x instanceof Rational) {
            Rational rationalizedX = (Rational) x;
            rationalizedX.simplestForm();
            if (rationalizedX.numerator == numerator && rationalizedX.denominator == denominator) {
                return true;
            }
        }
        return false;
    }

    /***
     * Compare the current rational number to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return -1 if the current rational number is less than the given number, 0 if they're equal, 1 if the current
     * rational number is larger than the given number
     */
    public long compareTo(Object x) {
        if(x instanceof Rational) {
            Rational rationalizedX = (Rational) x;
            long result = numerator * rationalizedX.denominator - rationalizedX.numerator * denominator;
            if (result > 0) {
                return 1;
            }
            else if (result == 0) {
                return 0;
            }
            else {
                return -1;
            }
        }
        return 0;
    }

    /***
     * Give the formatted string of the rational number
     * @return the string representation of the rational number. For example, "1/2", "3/4".
     */
    public String toString() { 
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
    }
}