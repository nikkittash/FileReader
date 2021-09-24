import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FileReader {

    protected static String name;
    protected static int coming;
    private static int totalComing;
    protected static int expenditure;
    private static int totalExpenditure;

    public FileReader() {
    }

    protected static HashMap<String, Operations> loadFromFile(String data) {

        HashMap<String, Operations> operations = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(data));
            lines.remove(0);
            for (String line : lines) {
                String[] fragments = line.split(",", 8);
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                name = getName(fragments[5]);
                coming = Integer.parseInt(fragments[6].replaceAll("[^\\d]", ""));
                expenditure = Integer.parseInt(fragments[7].replaceAll("[^\\d]", ""));
                totalComing += coming;
                totalExpenditure += expenditure;
                if (!operations.containsKey(name)) {
                    operations.put(name, new Operations(name, coming, expenditure));
                } else {
                    operations.get(name).setExpenditure(expenditure);
                }
            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        return operations;
    }

        protected static int getTotalExpenditure() {
        return totalExpenditure;
    }

        protected static int getTotalComing() {
        return totalComing;
    }

    protected static String getName(String name) {
        if(name.contains("/")) {
            name = name.substring((name.indexOf("/")) + 1, name.lastIndexOf(".") - 2);
        }
        if(name.contains("\\")) {
            name = name.substring((name.indexOf("\\")) + 1, name.lastIndexOf(".") - 2);
        }
        name = name.replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "").trim();
        return name;
    }
}
