package com.company;

public class Main {

    public static void main(String[] args) {

        Square s1 = new Square(1,1,1);
        Square s2 = new Square(0,0,0);

        System.out.println(s1.perimeterSquare());
        
        s1.moveRandom();
        s1.printSquare();
        s1.moveRandom();
        s1.printSquare();
        
        System.out.println(s1.encountDisntance(s2));
    }
}

