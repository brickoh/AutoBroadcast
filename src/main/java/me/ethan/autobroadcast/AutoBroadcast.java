package me.ethan.autobroadcast;

import lombok.Getter;
import me.ethan.autobroadcast.task.BroadcastTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoBroadcast extends JavaPlugin {

    @Getter private static AutoBroadcast instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        new BroadcastTask();
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
