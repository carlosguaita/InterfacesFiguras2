package Modelos;

import Interfaces.Figura2D;

public class Circulo extends Figura implements Figura2D {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        double area = Math.PI * Math.pow(radio,2);
        setArea(area);
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double per = 2 * Math.PI * radio;
        setPer(per);
        return per;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString(){
        return "Circulo: " +
                " Radio: " + radio +
                " Area: " + getArea() +
                " Perimetro: " + getPer() + '\n';
    }
}
