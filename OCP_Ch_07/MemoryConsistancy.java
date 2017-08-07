import java.util.Map;
import java.util.HashMap;
import java.util.ConcurrentModificationException;

public class MemoryConsistancy {
    public static void main(String[] args) {
        try {
            Map<String, Object> foodData = new HashMap<String, Object>();

            foodData.put("penguin", 1);
            foodData.put("flamingo", 2);

            for (String key : foodData.keySet()) {
                foodData.remove(key);
            }
        } catch (ConcurrentModificationException e) {

        }
    }
}
