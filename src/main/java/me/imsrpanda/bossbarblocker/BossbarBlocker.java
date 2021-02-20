package me.imsrpanda.bossbarblocker;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.imsrpanda.bossbarblocker.entity.EnderDragonBar;
import me.imsrpanda.bossbarblocker.handler.EntityEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossbarBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        final ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new EntityEvent(), this);
        new EnderDragonBar(this, protocolManager);
    }
}
