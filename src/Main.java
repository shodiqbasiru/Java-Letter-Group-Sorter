import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static String groupLetters(String[] letters) {
        Map<Character, Integer> map = getCharacterIntegerMap(letters);

        Stream<Map.Entry<Character, Integer>> sorted = map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()));

        StringBuilder result = new StringBuilder();
        sorted.forEach(entry -> {
            if (entry.getValue() > 1) {
                entry.setValue(1);
            }
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        });

        return result.toString();
    }

    private static Map<Character, Integer> getCharacterIntegerMap(String[] letters) {
        StringBuilder arrToString = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            arrToString.append(letters[i]);
        }

        char[] lettersChar = arrToString.toString().toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < lettersChar.length; i++) {
            char letter = lettersChar[i];
            if (map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String[] letters = {"Abc", "bCd"};
        System.out.println(groupLetters(letters));

        String[] letters2 = {"Oke", "One"};
        System.out.println(groupLetters(letters2));

        String[] letters3 = {"Pendanaan","Terproteksi","Untuk","Dampak","Berarti"};
        System.out.println(groupLetters(letters3));
    }
}