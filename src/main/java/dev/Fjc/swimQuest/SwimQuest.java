package dev.Fjc.swimQuest;

import com.ordwen.odailyquests.api.ODailyQuestsAPI;
import dev.Fjc.swimQuest.listener.SwimQuestListener;
import dev.Fjc.swimQuest.quests.SwimQuestClass;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SwimQuest extends JavaPlugin {

    @Override
    public void onLoad() {
        ODailyQuestsAPI.registerQuestType("SWIM", SwimQuestClass.class);
        getLogger().info("Quest registration success.");
    }

    @Override
    public void onEnable() {
        if (!getServer().getPluginManager().isPluginEnabled("ODailyQuests")) {
            getLogger().warning("ODailyQuests was not detected! That is an issue but loading will attempt to continue.");
        } else {
            getLogger().info("Found ODailyQuests.");
        }
        Bukkit.getPluginManager().registerEvents(new SwimQuestListener(), this);
        getLogger().info("Listener loaded.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
