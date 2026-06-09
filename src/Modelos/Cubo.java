package Modelos;

import Interfaces.Figura3D;

public class Cubo extends Rectangulo implements Figura3D {

    private double prof;

    public Cubo(double base, double altura, double prof) {
        super(base, altura);
        this.prof = prof;
    }

    @Override
    public double calcularVolumen() {
        double volumen = this.calcularArea() * prof;
        setVolumen(volumen);
        return volumen;
    }

    @Override
    public double calcularAreaSuperficial() {
        double areaSup = 2 * (this.calcularArea() + getBase() * prof + getAltura() * prof);
        setAreaSuperficial(areaSup);
        return areaSup;
    }

    public double getProf() {
        return prof;
    }

    public void setProf(double prof) {
        this.prof = prof;
    }

    @Override
    public String toString(){
        return "Rectangulo: " +
                " Base: " + getBase() +
                " Altura: " + getAltura() +
                " Profundidad: " + prof +
                " Area: " + getArea() +
                " Perimetro: " + getPer() +
                " Volumen: " + getVolumen() +
                " Area Superficial: " + getAreaSuperficial() + '\n';
    }
}
