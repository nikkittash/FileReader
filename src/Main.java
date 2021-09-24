import java.util.HashMap;

public class Main {

    private static final String data = "data/movementList.csv";

    public static void main(String[] args) {

        FileReader reader = new FileReader();
        HashMap<String, Operations> operations = reader.loadFromFile(data);

        System.out.println("Сумма доходов: " + reader.getTotalComing() + " руб.");
        System.out.println("Сумма расходов: " + reader.getTotalExpenditure() + " руб.");
        printMap(operations);
    }

    private static void printMap(HashMap<String, Operations> map) {
        System.out.println("\n" + "Суммы расходов по организациям:" + "\n");
        for(String key : map.keySet()) {
            System.out.println(key + "\t\t" + map.get(key).getExpenditure() + " руб.");
        }
    }
}
