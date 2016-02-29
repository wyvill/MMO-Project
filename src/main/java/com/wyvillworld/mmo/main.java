package com.wyvillworld.mmo;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(id = "example", name="Example project", version = "1.0")

public class main{

    @Listener
    public void onServerStart(GameStartedServerEvent e){

        CommandSpec hello = CommandSpec.builder()
                .description(Text.of("hello"))
                .executor(new helloWorldCommand())
                .build();

        CommandSpec monstars = CommandSpec.builder()
                .description(Text.of("hello"))
                .executor(new monstarCommand())
                .build();

        Sponge.getCommandManager().register(this, hello, "hello", "hi");
        Sponge.getCommandManager().register(this, monstars, "monstar", "mon");
    }
}
