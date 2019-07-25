package cz.danakut.dnd.newgui;

import java.util.HashMap;
import java.util.Map;

public class PanelSettings {

    Map<String, Object> map;

    public PanelSettings() {
        map = new HashMap<>();
        map.put("defaultFont", null);
        map.put("titleFont", null);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }
}
