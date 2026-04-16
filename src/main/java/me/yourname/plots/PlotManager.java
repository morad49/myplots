package me.yourname.plots;

import java.util.concurrent.ConcurrentHashMap;

public class PlotManager {
    // تخزين الأراضي في الذاكرة بشكل آمن وسريع جداً
    private static final ConcurrentHashMap<String, String> plots = new ConcurrentHashMap<>();

    public static void addPlot(String id, String owner) {
        plots.put(id, owner);
    }

    public static boolean exists(String id) {
        return plots.containsKey(id);
    }
}
