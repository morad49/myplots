package me.yourname.plots;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.block.Sign;
import org.bukkit.ChatColor;

public class PlotCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return true;

        if (args.length == 2 && args[0].equalsIgnoreCase("create")) {
            String plotId = args[1];
            
            // نتحقق إذا كان اللاعب ينظر إلى لوحة
            if (player.getTargetBlockExact(5) != null && player.getTargetBlockExact(5).getState() instanceof Sign sign) {
                
                // برمجة اللوحة بناءً على الـ Config
                sign.setLine(0, "§l[Plot]");
                sign.setLine(1, plotId);
                sign.setLine(2, "§aAVAILABLE");
                sign.setLine(3, "§7Click to Rent");
                sign.update();

                PlotManager.addPlot(plotId, "Available");
                player.sendMessage("§e§lPLOTS §8» §fPlot §6" + plotId + " §fcreated successfully!");
            } else {
                player.sendMessage("§cYou must be looking at a sign!");
            }
            return true;
        }
        return false;
    }
}
