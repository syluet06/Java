import java.util.HashMap;
import java.util.Scanner;
public class WordFrequency {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String sentence = in.nextLine();
    out(getWordFrequencies(sentence));
  }

  public static HashMap<String,Double> getWordFrequencies(String sentence) {
    HashMap<String,Double> map = new HashMap<String,Double>();

    sentence = sentence.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
    String[] words = sentence.split("[\t\n .!?\\\\-]");
    int len = words.length;

    for(String s : words) {
      if(map.containsKey(s))
        map.put(s,map.get(s)+1.0);
      else
        map.put(s,1.0);
    }

    for(String s : map.keySet())
      map.put(s,map.get(s)/len);


    return map;
  }

  public static void out(HashMap<String,Double> map) {
    for(String s : map.keySet())
      System.out.printf("%s %.2f\n",s,map.get(s));
  }
}
