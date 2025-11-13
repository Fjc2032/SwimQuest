package dev.Fjc.swimQuest.quests;

import com.ordwen.odailyquests.quests.player.progression.Progression;
import com.ordwen.odailyquests.quests.types.AbstractQuest;
import com.ordwen.odailyquests.quests.types.shared.BasicQuest;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerMoveEvent;

public class SwimQuestClass extends AbstractQuest {

    public SwimQuestClass(BasicQuest basicQuest) {
        super(basicQuest);
    }

    @Override
    public String getType() {
        return "SWIM";
    }

    @Override
    public boolean canProgress(Event provided, Progression progression) {
        return provided instanceof PlayerMoveEvent && progression != null;
    }

    @Override
    public boolean loadParameters(ConfigurationSection configurationSection, String string, String string1) {
        return true;
    }
}
