package Modelos;

import Interfaces.Figura2D;

public class Rectangulo extends Figura implements Figura2D {

    private double base, altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        double area = base * altura;
        setArea(area);
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double per = 2 * (base + altura);
        setPer(per);
        return per;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString(){
        return "Rectangulo: " +
                " Base: " + base +
                " Altura " + altura +
                " Area: " + getArea() +
                " Perimetro: " + getPer() + '\n';
    }

}
