package com.wyvillworld.mmo;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.network.Message;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.text.action.TextActions;

/**
 * Created by Nicholas on 29/02/2016.
 */
public class helloWorldCommand implements CommandExecutor{

    Text playerMsg = Text.builder("Hello World!!").color(TextColors.GOLD).style(TextStyles.BOLD).onClick(TextActions.runCommand("HELLO!")).build();
    Text notPlayerMsg = Text.builder("Hello Console!!").color(TextColors.RED).build();

    @Override
    public CommandResult execute(CommandSource src, CommandContext args)
            throws CommandException {
        if (src instanceof Player) {
            src.sendMessage(playerMsg);
        } else {
            src.sendMessage(notPlayerMsg);
        }
        return CommandResult.success();
    }
}
