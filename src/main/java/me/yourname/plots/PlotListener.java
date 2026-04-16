package me.morad49.plots;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlotListener implements Listener {

    // 1. عند الضغط على اللوحة
    @EventHandler
    public void onSignInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && event.getClickedBlock().getState() instanceof Sign sign) {
            // التحقق من السطر الأول (المفتاح)
            if (sign.getLine(0).equalsIgnoreCase("§l[Plot]")) {
                String plotId = sign.getLine(1);
                openPlotMenu(event.getPlayer(), plotId);
            }
        }
    }

    // 2. دالة فتح المنيو
    public void openPlotMenu(Player player, String id) {
        Inventory gui = Bukkit.createInventory(null, 9, "§8Plot: §n" + id);

        ItemStack rentItem = new ItemStack(Material.LIME_WOOL);
        ItemMeta meta = rentItem.getItemMeta();
        
        if (meta != null) {
            meta.setDisplayName("§a§lRent This Plot");
            List<String> lore = new ArrayList<>();
            lore.add("§7Price: §6100$");
            lore.add("§7Duration: §f7 Days");
            meta.setLore(lore);
            rentItem.setItemMeta(meta);
        }

        gui.setItem(4, rentItem);
        player.openInventory(gui);
    }

    // 3. ماذا يحدث عند الضغط داخل المنيو
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if (event.getView().getTitle().contains("Plot:")) {
            event.setCancelled(true); // عشان اللاعب ما يسحب الصوف لشنطته
            
            if (event.getCurrentItem() == null) return;
            
            Player player = (Player) event.getWhoClicked();
            
            if (event.getCurrentItem().getType() == Material.LIME_WOOL) {
                player.closeInventory();
                player.sendMessage("§e§lPLOTS §8» §aProcessing your rent request...");
                // هنا مستقبلاً نربط نظام الفلوس (Vault)
            }
        }
    }
}
