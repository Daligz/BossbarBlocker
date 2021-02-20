package me.imsrpanda.bossbarblocker.entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderDragonBar implements IBossbar {

    private ProtocolManager protocolManager;
    private JavaPlugin plugin;

    private static final String DRAGON_BOSSBAR_ID = "entity.minecraft.ender_dragon";

    public EnderDragonBar(final JavaPlugin plugin, final ProtocolManager protocolManager) {
        this.plugin = plugin;
        this.protocolManager = protocolManager;
        hideBar();
    }

    @Override
    public void hideBar() {
        this.protocolManager.addPacketListener(
                new PacketAdapter(this.plugin, ListenerPriority.LOW, PacketType.Play.Server.BOSS) {
                    @Override
                    public void onPacketSending(final PacketEvent event) {
                        try {
                            if (event.getPacketType() != PacketType.Play.Server.BOSS) return;
                            final PacketContainer packet = event.getPacket();
                            if (packet == null || packet.getChatComponents() == null) return;
                            final String json = packet.getChatComponents().read(0).getJson();
                            if (json == null) return;
                            if (json.contains(DRAGON_BOSSBAR_ID)) {
                                event.setCancelled(true);
                            }
                        } catch (final Exception ex) { /*TEMPORARY SOLUTION*/ }
                    }
                }
        );
    }
}
