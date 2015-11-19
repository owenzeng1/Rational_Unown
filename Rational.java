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

    //======================PHASE2==================================//
    public static int gcdER (int a, int b){
        if ((a == b) || (b == 0)){
            return a;} //returns the GCD.
        else if (a < b){
            return gcdER (b,a);} //If b is greater than a, the function will be run again with both values swapped.
        else{
            return gcdER (b , (a-b));
        }
    }
    //Adds fractions brute-force way
    public void add (Rational other) {
	this.numerator = (this.numerator)*(other.denominator) + (other.numerator)*(this.denominator);
	this.denominator = (this.denominator*other.denominator); }

    //subtracts fractions brute-force way
    public void subtract (Rational other) {
	this.numerator = (this.numerator*other.denominator) - (other.numerator*this.denominator);
	this.denominator = (this.denominator*other.denominator); }

    //reduces fraction
    public void reduce () {
	int gcd = gcdER (this.numerator, this.denominator);
	this.numerator /= gcd;
	this.denominator /= gcd; }

    //========================PHASE3================================//

    public static void main(String[] args) {
        Rational r = new Rational(2, 3);
        Rational s = new Rational(1, 2);
        r.divide(s);
        System.out.println(r);
	r.multiply(s);
        System.out.println(r);
	//Phase 2 Test
	r.add(s);
	System.out.println(r);
	r.subtract(s);
	System.out.println(r);
	r.reduce();
	System.out.println(r);
	//Phase3 Test
    }
}
