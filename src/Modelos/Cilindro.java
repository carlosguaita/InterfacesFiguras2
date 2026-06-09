package Modelos;

import Interfaces.Figura3D;

public class Cilindro extends Circulo implements Figura3D {

    private double altura;

    public Cilindro(double radio, double altura) {
        super(radio);
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        double volumen = this.calcularArea() * altura;
        setVolumen(volumen);
        return volumen;
    }

    @Override
    public double calcularAreaSuperficial() {
        double areaSup = 2 * this.calcularArea() + this.calcularPerimetro() * altura;
        setAreaSuperficial(areaSup);
        return areaSup;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString(){
        return "Cilindro: " +
                " Radio: " + getRadio() +
                " Altura: " + altura +
                " Area: " + getArea() +
                " Perimetro: " + getPer() +
                " Volumen: " + getVolumen() +
                " Area Superficial: " + getAreaSuperficial() + '\n';
    }
}
