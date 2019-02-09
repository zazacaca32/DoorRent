package ru.zazacaca32.scam.doorrent.doorrent;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.Optional;

@Plugin(
        id = "doorrent",
        name = "DoorRent",
        description = "Rent all doors in the world",
        url = "https://vk.com/zazacaca32",
        authors = {
                "zazacaca32"
        }
)
public class DoorRent {

    @Inject
    private Logger logger;


    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Successfully running ExamplePlugin!!!");
    }

    @Listener
    public void onInteract(InteractBlockEvent.Secondary.MainHand event) {
        Optional<Player> player = event.getCause().first(Player.class);
        if (event.getTargetBlock().getState().getType() == BlockTypes.WOODEN_DOOR)
        player.get().sendMessage(Text.builder(event.getTargetBlock().getState().getType().getName()).color(TextColors.LIGHT_PURPLE).style(TextStyles.BOLD).build());
    }
}
