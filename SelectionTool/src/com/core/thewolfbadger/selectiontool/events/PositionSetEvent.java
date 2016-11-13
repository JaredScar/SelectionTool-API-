package com.core.thewolfbadger.selectiontool.events;

import com.core.thewolfbadger.selectiontool.selection.SelectionMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created with IntelliJ IDEA.
 * User: TheWolfBadger
 * Date: 8/13/15
 * Time: 5:21 PM
 */
public class PositionSetEvent extends Event {
    private Player selector;
    private Location l;
    private int position;
    public PositionSetEvent(Player selector, Location l, int position) {
        this.selector = selector;
        this.l = l;
        this.position = position;
        switch (position) {
            case 1:
                SelectionMode.get().setPos1(selector, l);
                break;
            case 2:
                SelectionMode.get().setPos2(selector, l);
        }
    }
    public void setSelector(Player selector) {
        this.selector = selector;
    }
    public void setLocation(Location l) {
        this.l = l;
    }
    public Location getLocation() {
        return this.l;
    }
    public int getPosition() {
        return this.position;
    }
    public void setPosition(int i) {
        this.position = i;
    }
    public Player getSelector() {
        return this.selector;
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
