package com.wyvillworld.mmo;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.spawn.EntitySpawnCause;
import org.spongepowered.api.event.cause.entity.spawn.SpawnTypes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import java.util.Optional;

public class monstarCommand implements CommandExecutor{

    @Override
    public CommandResult execute(CommandSource src, CommandContext args)
            throws CommandException {
        if (src instanceof Player) {
            Location<World> loc = ((Player) src).getLocation();
            Extent extent = loc.getExtent();

            Optional<Entity> optional = extent.createEntity(EntityTypes.ZOMBIE, loc.getPosition());
            if (optional.isPresent()) {
                Entity zombie = optional.get();
                extent.spawnEntity(zombie, Cause.of(src));
                return CommandResult.success();
            } else {
                src.sendMessage(Text.builder("Only players can use this command!").color(TextColors.RED).build());
                return CommandResult.empty();
            }
        } else {
            return CommandResult.empty();
        }
    }
}
