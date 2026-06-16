package cli;

import Exceptions.ValidarTrianguloException;
import Interfaces.Figura2D;
import Interfaces.Figura3D;
import Modelos.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaCLI {


    private List<Figura> figuras;

    public SistemaCLI() {
        figuras = new ArrayList<>();
    }

    public double validarDouble(){
        Scanner sc = new Scanner(System.in);
        double num = 0;
        boolean flag = true;
        do {
            try{
                num = sc.nextDouble();
                flag = false;
            }catch (InputMismatchException ex1){
                System.out.println("Error: el dato ingresado es incorrecto");
                System.out.print(">> ");
            }finally {
                sc.nextLine();
            }
        }while(flag);
        return num;
    }


    public void validarTriangulo(double ladoA, double ladoB, double ladoC) throws ValidarTrianguloException {
        double ladoMayor = 0, lado1 = 0, lado2 = 0;
        if (ladoA >= ladoB && ladoA >= ladoC){
            ladoMayor = ladoA;
            lado1 = ladoB;
            lado2 = ladoC;
        } else if (ladoB >= ladoA && ladoB >= ladoC) {
            ladoMayor = ladoB;
            lado1 = ladoA;
            lado2 = ladoC;
        } else if (ladoC >= ladoA && ladoC >= ladoB) {
            ladoMayor = ladoC;
            lado1 = ladoA;
            lado2 = ladoB;
        }
        if (ladoMayor >= (lado1 + lado2)){
            throw new ValidarTrianguloException("Error: No es un triangulo");
        }
    }



    public int menu(){
        System.out.println("Seleccione una opcion:");
        System.out.println("1.Crear Figura");
        System.out.println("2.Listar Figuras");
        System.out.print(">> ");
        int opc = (int)validarDouble();
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
        int opc = (int)validarDouble();
        return opc;
    }

    public void crearFigura(){
        int opc = this.submenu();
        switch (opc){
            case 1:
                System.out.print("Ingrese el radio: ");
                double radio = validarDouble();
                Circulo circulo = new Circulo(radio);
                figuras.add(circulo);
                break;
            case 2:
                System.out.print("Ingrese la base: ");
                double base = validarDouble();
                System.out.print("Ingrese la altura: ");
                double altura = validarDouble();
                Rectangulo rectangulo = new Rectangulo(base,altura);
                figuras.add(rectangulo);
                break;
            case 3:
                try {
                    System.out.print("Ingrese Lado A: ");
                    double ladoA = validarDouble();
                    System.out.print("Ingrese Lado B: ");
                    double ladoB = validarDouble();
                    System.out.print("Ingrese Lado C: ");
                    double ladoC = validarDouble();
                    validarTriangulo(ladoA,ladoB,ladoC);
                    Triangulo triangulo = new Triangulo(ladoA,ladoB,ladoC);
                    figuras.add(triangulo);
                } catch (ValidarTrianguloException ex){
                    ex.printStackTrace();
                }

                break;
            case 4:
                System.out.print("Ingrese el radio: ");
                double radioCil = validarDouble();
                System.out.print("Ingrese la altura: ");
                double alturaCil = validarDouble();
                Cilindro cilindro = new Cilindro(radioCil,alturaCil);
                figuras.add(cilindro);
                break;
            case 5:
                System.out.print("Ingrese la base: ");
                double baseCu = validarDouble();
                System.out.print("Ingrese la altura: ");
                double alturaCu = validarDouble();
                System.out.print("Ingrese la profundidad: ");
                double prof = validarDouble();
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
            opc2 = (int)validarDouble();

        }while(opc2 == 1);
    }
}
