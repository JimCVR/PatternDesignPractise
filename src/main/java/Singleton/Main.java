package Singleton;

public class Main {
    public static void main(String[] args) {
        Demo demo1 = Demo.getInstance("hola");
        Demo demo2 = Demo.getInstance("adios");

        System.out.println(demo1.getValue());
        System.out.println(demo2.getValue());
        System.out.println(demo1.getValue());
        System.out.println(demo2.getValue());
    }
}
