package com.core.thewolfbadger.selectiontool.events;

import com.core.thewolfbadger.selectiontool.cuboid.Cuboid;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created with IntelliJ IDEA.
 * User: TheWolfBadger
 * Date: 8/13/15
 * Time: 1:21 PM
 */
public class CuboidCreateEvent extends Event {
    private Cuboid cuboid;
    private Player creator;
    public CuboidCreateEvent(Cuboid c, Player p) {
        this.creator = p;
        this.cuboid = c;
    }
    public Player getCreator() {
        return this.creator;
    }
    public Cuboid getCuboid() {
        return cuboid;
    }
    public void setCuboid(Cuboid c) {
        this.cuboid = c;
    }
    public void setCreator(Player p) {
        this.creator = p;
    }
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
