package exercise;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        return homes.stream()
                .sorted()
                .map(Home::toString)
                .limit(n)
                .toList();
    }
}