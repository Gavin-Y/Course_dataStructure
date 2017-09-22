package util.Math.Complex;

/**
 * Created by yejiaquan on 2016/9/23.
 */
public class Complex {
    private double real,imag;
    public Complex(String complex){
        String[]str;
        int i=complex.indexOf("i");
        if(i>=0){
            complex=complex.substring(0,i);
        }
        if(complex.contains("+")){
            str=complex.split("\\+");
            this.imag=Double.parseDouble(str[1]);
        }else if(complex.contains("-")){
            str=complex.split("\\-");
            this.imag=-Double.parseDouble(str[1]);
        }else{
            return;
        }
        this.real=Double.parseDouble(str[0]);
    }
    public Complex(double real,double imag){
        this.real=real;
        this.imag=imag;
    }
    public Complex add(Complex c){
        this.real+=c.real;
        this.imag+=c.imag;
        return this;
    }
    public Complex sub(Complex c){
        this.real-=c.real;
        this.imag-=c.imag;
        return this;
    }
    public String toString(){
        if(this.imag<0)
            return this.real+""+this.imag+"i";
        return this.real+"+"+this.imag+"i";
    }
    public boolean equals(Complex c){
        if(this.toString().equals(c.toString()))
            return true;
        return false;
    }
}
