import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import edu.javacourse.queue.ObjectQueue;

public class main {
  
  public static void  main(String[] args) throws IOException {
    ObjectQueue<String> Que = new ObjectQueue<String>();
    read(Que);
    Que = quest(Que);
    write(Que);
  }
 
  public static ObjectQueue<String> quest(ObjectQueue<String> Que) {
    int size = Que.size();
    ObjectQueue<String> NewQue = new ObjectQueue<String>();
    for (int i = 0; i < size; i++) {
      String el = Que.get(i);
      String newLine = "";
      String newLineDigit = "";
      for (int j = 0; j < el.length(); j++){
        char c = el.charAt(j);
        if (Character.isDigit(c)) {
          newLineDigit = newLineDigit + c;
        } else {
          newLine = newLine + c;
        }
      }
      NewQue.push(newLine + newLineDigit + " " + newLineDigit.length());
    }
    return NewQue;
  }
 
  public static ObjectQueue<String> write(ObjectQueue<String> Que) throws IOException {
    File file = new File("g.txt");
    file.createNewFile();
      

    BufferedWriter writer = new BufferedWriter(new FileWriter(file)); 
    String line = null;
    while ((line = Que.pull()) != null) {
      writer.write(line);
      writer.newLine();
    }
    writer.close();
    return Que;
    

  }
  public static ObjectQueue<String> read(ObjectQueue<String> Que) {
    try 
      {
        File file = new File("f.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr); 
        String line = null;
        while ((line = reader.readLine()) != null) {
          Que.push(line);
        }
        reader.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return Que;
  }
}
