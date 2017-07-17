package biz.princeps.landlord.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by spatium on 16.07.17.
 */
@CommandAlias("ll|land|landlord")
public class Landlordbase extends BaseCommand {

    private Map<String, LandlordCommand> subcommands;

    public Landlordbase() {
        subcommands = new HashMap<>();
        subcommands.put("claim", new Claim());
        subcommands.put("info", new Info());
        subcommands.put("unclaim", new Unclaim());
        subcommands.put("addfriend", new Addfriend());
    }

    @Default
    @UnknownHandler
    @Subcommand("help")
    public void onDefault(CommandSender sender) {
        sender.sendMessage("help command");
    }

    @Subcommand("claim|buy|cl")
    @CommandAlias("claim")
    @Syntax("land claim - Claims the land you are currently standing on")
    public void onClaim(Player player) {
        ((Claim) subcommands.get("claim")).onClaim(player);
    }

    @Subcommand("info|i")
    @CommandAlias("landi|landinfo")
    @Syntax("land info - Shows information about the land you are standing on")
    public void onInfo(Player player) {
        ((Info) subcommands.get("info")).onInfo(player);
    }

    @Subcommand("unclaim|sell")
    @Syntax("land sell - Unclaim the chunk you are standing on")
    public void onUnClaim(Player player) {
        ((Unclaim) subcommands.get("unclaim")).onUnclaim(player);
    }

    @Subcommand("addfriend|friendadd")
    @Syntax("land addfriend - Adds friends to your land")
    public void onAddFriend(Player player, String[] names) {
        ((Addfriend) subcommands.get("addfriend")).onAddfriend(player, names);
    }
}
