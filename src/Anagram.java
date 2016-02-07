import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    private final String str;

    Anagram(String str) {
        this.str = str.replaceAll("\\s", "");
    }


    public static void main(String[] args) {
        final String[] input = {"abc", "dormitory", "cba", "test", "sett", "tar", "tinsel", "silent", "listen", "dirty room"};
        Map<Anagram, List<String>> processedMap = new HashMap<>();
        for (String anInput : input) {
            Anagram cString = new Anagram(anInput);
            if (processedMap.get(cString) == null) {
                List<String> list = new ArrayList<>();
                list.add(anInput);
                processedMap.put(cString, list);
            } else {
                processedMap.get(cString).add(anInput);
            }
        }
        System.out.println(processedMap.values());
    }

    @Override
    public int hashCode() {
        int charSum = 0;
        for (int i = 0; i < str.length(); i++) {

            charSum += str.charAt(i);
        }
        return charSum;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }


}
