import java.util.HashMap;
import java.io.*;


public class NaiveWordCount {
  public static void main(String[]args){
    //Start Timer
    long startTime = System.currentTimeMillis();
    HashMap<String, Integer> counter = new HashMap<>();

    //Read Each File Sequentially
    readFile("./test1.txt", counter);
    readFile("./test2.txt", counter);
    readFile("./test3.txt", counter);

    //Print All Results to a File
    try{
      PrintWriter writer = new PrintWriter("./NaiveResults.txt", "UTF-8");
      for(String key : counter.keySet()){
        writer.println(key + " " + counter.get(key));
      }
    }catch(Exception e){
      e.printStackTrace();
    }

    //End Timer and Print Time
    long totalTime = System.currentTimeMillis();
    System.out.println("Total time in milliseconds for the program to run: " + totalTime);
  }

  // Read File
  public static void readFile(String filename, HashMap<String, Integer> counter){
    File file = new File(filename);
    String word;
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
      while((word = br.readLine()) != null){
        if (counter.get(word) == null){
          counter.put(word, 1);
        } else {
          Integer val = (Integer)counter.get(word) + 1;
          counter.put(word, val + 1);
        }
      }
      br.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}
