package me.yourname.plots;

import org.bukkit.plugin.java.JavaPlugin;

public class MyPlots extends JavaPlugin {
    private static MyPlots instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig(); // إنشاء ملف الـ Config تلقائياً
        
        // تسجيل الأوامر والفعاليات
        getCommand("plot").setExecutor(new PlotCommand());
        getServer().getPluginManager().registerEvents(new PlotListener(), this);
        
        getLogger().info("MyPlots Plugin Started Successfully!");
    }

    public static MyPlots getInstance() { return instance; }
}
