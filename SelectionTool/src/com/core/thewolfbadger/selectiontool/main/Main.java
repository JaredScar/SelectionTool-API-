package com.core.thewolfbadger.selectiontool.main;

import com.core.thewolfbadger.selectiontool.cuboid.Cuboid;
import com.core.thewolfbadger.selectiontool.events.CuboidCreateEvent;
import com.core.thewolfbadger.selectiontool.events.PositionSetEvent;
import com.core.thewolfbadger.selectiontool.selection.SelectionMode;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created with IntelliJ IDEA.
 * User: TheWolfBadger
 * Date: 8/13/15
 * Time: 1:20 PM
 */
public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    @Override
    public void onDisable() {}
    @EventHandler
    public void onPlayerSelect(PlayerInteractEvent evt) {
        if(evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(SelectionMode.get().containsUser(evt.getPlayer())) {
                Bukkit.getServer().getPluginManager().callEvent(new PositionSetEvent(evt.getPlayer(), evt.getClickedBlock().getLocation(), 1)); evt.setCancelled(true);
                if(SelectionMode.get().allSet(evt.getPlayer())) {
                    Cuboid cube = new Cuboid(SelectionMode.get().getPos1(evt.getPlayer()), SelectionMode.get().getPos2(evt.getPlayer()));
                    Bukkit.getServer().getPluginManager().callEvent(new CuboidCreateEvent(cube, evt.getPlayer()));
                }
            }
        } else
            if(evt.getAction() == Action.LEFT_CLICK_BLOCK) {
                if(SelectionMode.get().containsUser(evt.getPlayer())) {
                    Bukkit.getServer().getPluginManager().callEvent(new PositionSetEvent(evt.getPlayer(), evt.getClickedBlock().getLocation(), 2)); evt.setCancelled(true);
                    if(SelectionMode.get().allSet(evt.getPlayer())) {
                        Cuboid cube = new Cuboid(SelectionMode.get().getPos1(evt.getPlayer()), SelectionMode.get().getPos2(evt.getPlayer()));
                        Bukkit.getServer().getPluginManager().callEvent(new CuboidCreateEvent(cube, evt.getPlayer()));
                    }
                }
            }
    }
    @EventHandler
    public void onPlayerBreak(BlockBreakEvent evt) {
        if(SelectionMode.get().containsUser(evt.getPlayer())) {
            evt.setCancelled(true);
            Bukkit.getServer().getPluginManager().callEvent(new PositionSetEvent(evt.getPlayer(), evt.getBlock().getLocation(), 2)); evt.setCancelled(true);
            if(SelectionMode.get().allSet(evt.getPlayer())) {
                Cuboid cube = new Cuboid(SelectionMode.get().getPos1(evt.getPlayer()), SelectionMode.get().getPos2(evt.getPlayer()));
                Bukkit.getServer().getPluginManager().callEvent(new CuboidCreateEvent(cube, evt.getPlayer()));
                }
        }
    }
}
