package com.company;

class Square {

    public double x;
    public double y;
    public double dl_s;

    public Square() {
        x = 0.0;
        y = 0.0;
        dl_s = 1.0;
    }

    public Square(double a, double b, double s) {
        x = a;
        y = b;
        dl_s = s;
    }

    public void printSquare() {
        System.out.println("Квадрат с центром (" + x + ";" + y + ") и стороной " + dl_s);
    }

    public void moveSquare(double a, double b) {
        x = x + a;
        y = y + b;
    }

    public void zoomSquare(double k) {
        dl_s = dl_s * k;
    }

    public double squareSquare() {
        double s =  dl_s * dl_s;
        return s;
    }

    public boolean equalsSquare(Square squ) {
        if(this.squareSquare() == squ.squareSquare()) {
            return true;
        } else {
            return false;
        }
    }

    public double perimeterSquare() {
        double p = dl_s * 4;
        return p;
    }

    public void moveRandom() {
        x = Math.random() * 200 - 100;
        y = Math.random() * 200 - 100;
    }
    public  double encountDisntance(Square s2) {
        double d = Math.sqrt(Math.pow(x - s2.x, 2) + Math.pow(y - s2.y, 2));
        return d;
    }



}