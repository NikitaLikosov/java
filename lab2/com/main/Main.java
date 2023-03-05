package com.main;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    String s1,  s2 ,s3, s4, s5, s6;
    Scanner sc = new Scanner(System.in);
    // s1 = sc.nextLine();
    // s2 = sc.nextLine();

    // Message mes =new Message(s1);
    // System.out.println("Символов в строке " + mes.Stroca + " :" + mes.count(s2));
    // s3 = sc.nextLine();
    // Message mes2 = new Message(s3);
    // System.out.println("номер в строке " + mes2.Stroca + " :" + mes2.nomer());
    s6 = sc.nextLine();
    s4 = sc.nextLine();
    s5 = sc.nextLine();

    Message mes3 = new Message(s6);

    System.out.println("Замена в строке " + mes3.Stroca + " :" + mes3.replaceSubstring(s4, s5));
    System.out.println("Конец");

  }
} 