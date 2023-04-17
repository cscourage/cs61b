import java.util.*;

public class LibraryDemo {
    public static String cleanString(String s) {
        return s.toLowerCase().replaceAll("[^a-z]", "");
    }

    public static List<String> getWords(String inputFileName) {
        List<String> lst = new ArrayList<>();
        In in = new In(inputFileName);
        while (!in.isEmpty()) {
            String nextWord = cleanString(in.readString());
            lst.add(nextWord);
        }
        return lst;
    }

    public static int countUniqueWords(List<String> words) {
        Set<String> ss = new HashSet<>();
        for (String s : words) {
            ss.add(s);
        }
        return ss.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> target, List<String> words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String t : target) {
            counts.put(t, 0);
        }
        for (String s : words) {
            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        List<String> w = getWords("librarytest.txt");
        System.out.println(w);

        System.out.println(countUniqueWords(w));

        List<String> targets = new ArrayList<>();
        targets.add("linux");
        targets.add("huawei");
        targets.add("arm");
        System.out.println(collectWordCount(targets, w));
    }

}
