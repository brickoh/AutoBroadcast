package me.ethan.autobroadcast.task;

import me.ethan.autobroadcast.AutoBroadcast;
import me.ethan.autobroadcast.utils.ChatUtils;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class BroadcastTask {

    private final AutoBroadcast auto = AutoBroadcast.getInstance();
    private final String BLANK_LINE = "";
    private final List<String> announcements = auto.getConfig().getStringList("announcements");
    private int num;

    /*
    Every 5 minutes we are going to send the next announcement
     */
    public BroadcastTask() {
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(auto, () -> {
                auto.getServer().broadcastMessage(BLANK_LINE);
                auto.getServer().broadcastMessage(getNextAnnouncement());
                auto.getServer().broadcastMessage(BLANK_LINE);
        }, 0L, 6000L);
    }


    private String getNextAnnouncement() {
        if (this.num >= this.announcements.size()) {
            this.num = 0;
        }
        final String message = this.announcements.get(this.num);
        this.num++;
        return ChatUtils.format(message);
    }

}