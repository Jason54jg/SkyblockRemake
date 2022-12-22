package me.CarsCupcake.SkyblockRemake.API.PlayerEvent;

import lombok.Getter;
import me.CarsCupcake.SkyblockRemake.Skyblock.SkyblockPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DamagePrepairEvent extends PlayerEvent{
    private static final HandlerList HANDLERS = new HandlerList();
    @Getter
    private final LivingEntity entity;
    @Getter
    private double preMultiplier = 1;
    @Getter
    private double postMultiplier = 1;
    public DamagePrepairEvent(SkyblockPlayer player, LivingEntity entity) {
        super(player);
        this.entity = entity;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
    public static HandlerList getHandlerList(){
        return HANDLERS;
    }
    public void addPreMultiplier(double d){
        preMultiplier+=d;
    }

    public void addPostMultiplier(double d){
        postMultiplier*=d;
    }

}
