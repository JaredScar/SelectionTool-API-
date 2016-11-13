package com.core.thewolfbadger.selectiontool.selection;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: TheWolfBadger
 * Date: 8/13/15
 * Time: 1:25 PM
 */
public class SelectionMode {
    private static SelectionMode sm = new SelectionMode();
    public static SelectionMode get() {
        return sm;
    }
    private ArrayList<UUID> users = new ArrayList<UUID>();
    private HashMap<UUID, Location> position1 = new HashMap<UUID, Location>();
    private HashMap<UUID, Location> position2 = new HashMap<UUID, Location>();
    public Location getPos1(Player user) {
        if(position1.containsKey(user.getUniqueId())) {
            return position1.get(user.getUniqueId());
        }
        return null;
    }
    public boolean hasPos1(Player user) {
        if(position1.containsKey(user.getUniqueId())) {
            return true;
        }
        return false;
    }
    public Location getPos2(Player user) {
        if(position2.containsKey(user.getUniqueId())) {
            return position2.get(user.getUniqueId());
        }
        return null;
    }
    public boolean hasPos2(Player user) {
        if(position2.containsKey(user.getUniqueId())) {
            return true;
        }
        return false;
    }
    public void setPos1(Player user, Location l) {
        position1.put(user.getUniqueId(), l);
    }
    public void setPos2(Player user, Location l) {
        position2.put(user.getUniqueId(), l);
    }
    public boolean allSet(Player user) {
        if(position1.containsKey(user.getUniqueId()) && position2.containsKey(user.getUniqueId())) {
            return true;
        }
        return false;
    }
    public boolean containsUser(Player user) {
        if(this.users.contains(user.getUniqueId())) {
            return true;
        }
        return false;
    }
    public void addUser(Player user) {
        this.users.add(user.getUniqueId());
    }
    public void removeUser(Player user) {
        this.users.remove(user.getUniqueId());
    }
}
