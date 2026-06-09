package LogicaNegocio;

import Interfaces.Figura2D;
import Interfaces.Figura3D;
import Modelos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCLI {

    private Scanner sc;
    private List<Figura> figuras;

    public SistemaCLI() {
        sc = new Scanner(System.in);
        figuras = new ArrayList<>();
    }

    public int menu(){
        System.out.println("Seleccione una opcion:");
        System.out.println("1.Crear Figura");
        System.out.println("2.Listar Figuras");
        System.out.print(">> ");
        int opc = sc.nextInt();
        return opc;
    }

    public int submenu(){
        System.out.println("Selecciones una opcion:");
        System.out.println("1.Circulo");
        System.out.println("2.Rectangulo");
        System.out.println("3.Triangulo");
        System.out.println("4.Cilindro");
        System.out.println("5.Cubo");
        System.out.print(">> ");
        int opc = sc.nextInt();
        return opc;
    }

    public void crearFigura(){
        int opc = this.submenu();
        switch (opc){
            case 1:
                System.out.print("Ingrese el radio: ");
                double radio = sc.nextDouble();
                Circulo circulo = new Circulo(radio);
                figuras.add(circulo);
                break;
            case 2:
                System.out.print("Ingrese la base: ");
                double base = sc.nextDouble();
                System.out.print("Ingrese la altura: ");
                double altura = sc.nextDouble();
                Rectangulo rectangulo = new Rectangulo(base,altura);
                figuras.add(rectangulo);
                break;
            case 3:
                System.out.print("Ingrese Lado A: ");
                double ladoA = sc.nextDouble();
                System.out.print("Ingrese Lado B: ");
                double ladoB = sc.nextDouble();
                System.out.print("Ingrese Lado C: ");
                double ladoC = sc.nextDouble();
                Triangulo triangulo = new Triangulo(ladoA,ladoB,ladoC);
                figuras.add(triangulo);
                break;
            case 4:
                System.out.print("Ingrese el radio: ");
                double radioCil = sc.nextDouble();
                System.out.print("Ingrese la altura: ");
                double alturaCil = sc.nextDouble();
                Cilindro cilindro = new Cilindro(radioCil,alturaCil);
                figuras.add(cilindro);
                break;
            case 5:
                System.out.print("Ingrese la base: ");
                double baseCu = sc.nextDouble();
                System.out.print("Ingrese la altura: ");
                double alturaCu = sc.nextDouble();
                System.out.print("Ingrese la profundidad: ");
                double prof = sc.nextDouble();
                Cubo cubo = new Cubo(baseCu,alturaCu,prof);
                figuras.add(cubo);
                break;
            default:
                System.out.println("No existe la opcion");
                break;
        }


    }

    public void listarFiguras(){
        for (Figura figura : figuras){
            ((Figura2D)figura).calcularPerimetro();
            ((Figura2D)figura).calcularArea();
            if(figura instanceof Figura3D){
                ((Figura3D)figura).calcularVolumen();
                ((Figura3D)figura).calcularAreaSuperficial();
            }
            System.out.print(figura);
        }
    }

    public void inicio(){
        int opc, opc2;
        do {

            opc = menu();

            switch (opc){
                case 1:
                    crearFigura();
                    break;
                case 2:
                    listarFiguras();
                    break;
                default:
                    System.out.println("No existe la opcion");
                    break;
            }

            System.out.println("Desea otra opcion 1.Si/2.No: ");
            opc2 = sc.nextInt();

        }while(opc2 == 1);
    }
}
