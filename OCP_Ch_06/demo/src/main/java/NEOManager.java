import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public final class NEOManager {

    private final static NEOManager instance = new NEOManager();

    private Map<Integer, NEO> neos = new HashMap();
    private List fields = new ArrayList();
    private List units = new ArrayList();

    private NEOManager() {
        // TODO: fetch fields
        // TODO: fetch units
        // TODO: populate NEOs
    }

    public NEOManager getInstance() {
        return this.instance;
    }

    // TODO: fetchProperty
    public String fetchProperty(String propertyName) {

    }

    // TODO: fetch NEO properties

    // TODO: create NEO

    // TODO: printFields

    // TODO: printUnits

    // TODO: toString()
}