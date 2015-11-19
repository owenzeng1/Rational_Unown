// Team Unown -- Andrew Lin, Owen Zeng
// APCS1 pd9
// HW33 -- Do you even add, bro?
// 2015-11-18

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
    
    public float floatValue(){
        return this.numerator / this.denominator;
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
        Rational r = new Rational(1, 1);
        Rational s = new Rational(7, 20);
        s.compareTo(r);
        System.out.println(s);
    }

 /*=====================PHASE 2=====================*/
    
    public void add(Rational other){
        int thisOriginal = this.denominator;
        if (this.denominator != other.denominator){
            this.numerator *= other.denominator;
            this.denominator *= other.denominator;
            other.numerator *= thisOriginal;
        }
        this.numerator += other.numerator;
    }
    
    public void subtract(Rational other){
        int thisOriginal = this.denominator;
        if (this.denominator != other.denominator){
            this.numerator *= other.denominator;
            this.denominator *= other.denominator;
           }
        this.numerator -= other.numerator * thisOriginal;
    }
    
    public int gcdEW(){
        int gcd = 0;
        int a = this.numerator;
        int b = this.denominator;
	    if (a == 0){
	        return b;
	    }
        while (a != 0 || b != 0){
            if (a > b) {
                if (a % b == 0){
		    gcd = b;
		}
                a = a % b;
            }
            else {
                if ( b % a == 0){
		    gcd = a;
		}
                b = b % a;
            }
        }
        return gcd;
    }
    
    public void reduce(){
        int gcd = gcdER(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }
    
    /*=====================PHASE 3=====================*/
    public static int gcdER (int a, int b){
        if ((a == b) || (b == 0)){
            return a;} //returns the GCD.
        else if (a < b){
            return gcdER (b,a);} //If b is greater than a, the function will be run again with both values swapped.
        else{
            return gcdER (b , (a-b));
        }
    }
    
    public float compareTo (Rational other){
        other.subtract(this);//figuring out which one is larger by taking difference of the two
        return this.numerator / this.denominator;//returning "Rational this" which fits the function's requirements 
    }
}
