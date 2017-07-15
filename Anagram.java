import java.util.*;

public class Anagram {
  public static void main(String[] args) {
    ArrayList<String> l = new ArrayList<String>(Arrays.asList("logarithm","algorithm","snow","owns","miles","smile","limes","none"));
    HashMap<String,ArrayList<String>> map = anagram(l);
    out(map);
  }

  public static HashMap<String,ArrayList<String>> anagram(ArrayList<String> words) {

    HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

    for(String s : words) {

      char[] sort = s.toCharArray();
      Arrays.sort(sort);
      String sorted = String.valueOf(sort);

      if(map.containsKey(sorted))
        map.get(sorted).add(s);
      else {
        ArrayList<String> l = new ArrayList<String>();
        l.add(s);
        map.put(sorted,l);
      }
    }
    return map;
  }

    public static void out(HashMap<String,ArrayList<String>> map) {
      for(String s : map.keySet()) {
        System.out.print(s + ": ");
        for(String i : map.get(s)) {
          System.out.print(i + " ");
        }
        System.out.println();
      }
    }
}
