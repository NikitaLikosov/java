package com.main;


public class Message {
  String Stroca;
  public Message(String str)//конструктор 
  { 
    Stroca = str;
  }
  public Message()
  { 
    Stroca = "";
  }
 
  public String reverse(){
    String  rev="";
    int length= Stroca.length();
    for(int i=length-1;i>=0;i--)
      rev=rev+ Stroca.charAt(i);
    return rev;
  }
  public int count(String c) {
    return Stroca.split(c).length - 1;
  }
  public String nomer() {
    return Stroca.split("№")[1].trim().split(" ")[0];
  }
  public String replaceSubstring(String sold, String snew) {
    String[] x = Stroca.split(sold);
    String y = "";
    for(String str: x)
      if (y == "") y=  y + str;  else 
        y=  y + snew + str;
    

    return y;

  }
}
