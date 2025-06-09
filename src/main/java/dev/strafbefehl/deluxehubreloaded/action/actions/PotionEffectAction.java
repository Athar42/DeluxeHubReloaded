package dev.strafbefehl.deluxehubreloaded.action.actions;

import dev.strafbefehl.deluxehubreloaded.DeluxeHubPlugin;
import dev.strafbefehl.deluxehubreloaded.action.Action;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionEffectAction implements Action {

    @Override
    public String getIdentifier() {
        return "EFFECT";
    }

    @Override
    public void execute(DeluxeHubPlugin plugin, Player player, String data) {
        String[] args = data.split(";");
        PotionEffectType type = PotionEffectType.getByName(args[0].toUpperCase());
        if (type != null) {
            boolean showIcon = (args.length > 2 && args[2] != null) ? Boolean.parseBoolean(args[2]) : true;
            player.addPotionEffect(new PotionEffect(type, -1, Integer.parseInt(args[1]) - 1, false, false, showIcon));
        }
    }
}