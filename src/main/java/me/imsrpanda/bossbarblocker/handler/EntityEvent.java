package me.imsrpanda.bossbarblocker.handler;

import me.imsrpanda.bossbarblocker.entity.WitherBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntityEvent implements Listener {

    @EventHandler
    public void entitySpawn(final EntitySpawnEvent event) {
        final Entity entity = event.getEntity();
        if (entity.getType() != EntityType.WITHER) return;
        new WitherBar(((Wither) entity).getBossBar());
    }
}
