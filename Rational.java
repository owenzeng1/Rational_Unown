// Team Unown -- James Wang, Owen Zeng
// APCS1 pd9
// HW32 -- Irrationality Stops Here
// 2015-11-17

public class Rational {
    public int numerator;
    public int denominator;
    
    public Rational() {
        numerator = 0;
        denominator = 1;
    }
    
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("STOP DIVIDING BY 0!!!!!!!");
            this.denominator = 1;
            this.numerator = 0;
        }
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public float floatValue(int numerator, int denominator){
        float answer = numerator / denominator;
        return answer;
    }

    
    public void multiply(Rational other) {
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
    }
    
    public void divide(Rational other) {
        this.numerator *= other.denominator;
        this.denominator *= other.numerator;
    }
    
    public static void main(String[] args) {
        Rational r = new Rational(2, 3);
        Rational s = new Rational(1, 2);
        r.divide(s);
        System.out.println(r);
    }
}