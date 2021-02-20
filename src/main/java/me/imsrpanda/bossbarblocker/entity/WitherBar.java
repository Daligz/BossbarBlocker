package me.imsrpanda.bossbarblocker.entity;

import org.bukkit.boss.BossBar;

public class WitherBar implements IBossbar {

    private BossBar bossBar;

    public WitherBar(final BossBar bossBar) {
        if (bossBar == null) return;
        this.bossBar = bossBar;
        hideBar();
    }

    @Override
    public void hideBar() {
        this.bossBar.setVisible(false);
    }
}
