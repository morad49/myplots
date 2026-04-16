package me.yourname.plots;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Sign;

public class PlotListener implements Listener {

    @EventHandler
    public void onSignInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && event.getClickedBlock().getState() instanceof Sign sign) {
            // التحقق إذا كانت اللوحة تابعة للبلوقن من السطر الأول
            if (sign.getLine(0).contains("[Plot]")) {
                String plotId = sign.getLine(1);
                event.getPlayer().sendMessage("§eChecking info for plot: " + plotId);
                // هنا تفتح المنيو GUI
            }
        }
    }
}
