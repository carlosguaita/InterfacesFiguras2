package Modelos;

import Interfaces.Figura2D;

public class Triangulo extends Figura implements Figura2D {

    private double ladoA, ladoB, ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public double calcularArea() {
        double semi = calcularPerimetro() / 2;
        double area = Math.sqrt(semi * (semi - ladoA) * (semi - ladoB) * (semi - ladoC));
        setArea(area);
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double per = ladoA + ladoB + ladoC;
        setPer(per);
        return per;
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    @Override
    public String toString(){
        return "Triangulo: " +
                " Lado A: " + ladoA +
                " Lado B: " + ladoB +
                " Lado C: " + ladoC +
                " Area: " + getArea() +
                " Perimetro: " + getPer() + '\n';
    }
}
