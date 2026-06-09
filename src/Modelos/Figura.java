package Modelos;

import Interfaces.Figura2D;
import Interfaces.Figura3D;

public abstract class Figura {

    private double area;
    private double per;
    private double volumen;
    private double areaSuperficial;

    public Figura() {
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getAreaSuperficial() {
        return areaSuperficial;
    }

    public void setAreaSuperficial(double areaSuperficial) {
        this.areaSuperficial = areaSuperficial;
    }
}
