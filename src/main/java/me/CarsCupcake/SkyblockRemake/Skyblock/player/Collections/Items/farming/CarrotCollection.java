package me.CarsCupcake.SkyblockRemake.Skyblock.player.Collections.Items.farming;

import me.CarsCupcake.SkyblockRemake.Items.Items;
import me.CarsCupcake.SkyblockRemake.Skyblock.SkyblockPlayer;
import me.CarsCupcake.SkyblockRemake.Skyblock.player.Collections.CollectHandler;
import me.CarsCupcake.SkyblockRemake.Skyblock.player.Collections.ICollection;
import me.CarsCupcake.SkyblockRemake.Skyblock.player.Collections.ItemCollection;
import me.CarsCupcake.SkyblockRemake.utils.Inventorys.GUI;
import me.CarsCupcake.SkyblockRemake.utils.Inventorys.InventoryBuilder;
import org.bukkit.Material;

public class CarrotCollection extends ItemCollection {
    public CarrotCollection(SkyblockPlayer player) {
        super(player);
    }

    @Override
    public int getMaxLevels() {
        return 9;
    }

    @Override
    public int[] collectAmount() {
        return new int[]{
                100,
                250,
                500,
                1700,
                5000,
                10000,
                25000,
                50000,
                100000
        };
    }

    @Override
    public GUI getInventory() {
        InventoryBuilder builder = CollectHandler.getBaseInventory("Carrot", this, Items.SkyblockItems.get("CARROT").createNewItemStack());
        int iI = 18;
        for (int i = 1; i <= getMaxLevels(); i++){
            builder.setItem(CollectHandler.getProgressItem(this, i, "Carrot").build(),iI);
            iI++;
        }

        GUI gui = new GUI(builder.build());
        gui.setCanceled(true);
        gui.inventoryClickAction(49, type -> gui.closeInventory());
        return gui;
    }

    @Override
    public void sendLevelUpMessage(int level) {
        player.sendMessage("§d§lBoop! §fYou leveled carrot up to level: " + level);
    }

    @Override
    public ICollection makeNew(SkyblockPlayer player) {
        return new CarrotCollection(player);
    }

    @Override
    public String getCollecteItemId() {
        return Material.CARROT + "";
    }

    @Override
    public String getName() {
        return "Carrot Collection";
    }
}
