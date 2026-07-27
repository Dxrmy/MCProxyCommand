package de.michiruf.proxycommand.fabric;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Michael Ruf
 * @since 2022-12-15
 */
public class ProxyCommandMod implements ModInitializer {

  public static final Logger LOGGER = LoggerFactory.getLogger("ProxyCommand");
  private static S2CPacket packetSender = new S2CPacket();

  @Override
  public void onInitialize() {
    LOGGER.info("ProxyCommand is active");
    CommandRegistrationCallback.EVENT.register(
        (dispatcher, registry, environment) ->
      registerCommand(dispatcher)
    );
  }

  private static void registerCommand(
    CommandDispatcher<CommandSourceStack> dispatcher
  ) {
    LiteralCommandNode<CommandSourceStack> proxyCommand = Commands
      .literal("proxycommand")
      .requires(cmd -> cmd.isPlayer())
      .then(
        Commands
          .argument("command", StringArgumentType.string())
          .executes(ProxyCommandMod::sendMessage)
          .build()
      )
      .build();
    dispatcher.getRoot().addChild(proxyCommand);
  }

  private static int sendMessage(CommandContext<CommandSourceStack> context) {
    var command = StringArgumentType.getString(context, "command");

    ServerPlayer player = context.getSource().getPlayer();
    if (player == null) {
      LOGGER.warn(
        "Command \"" + command + "\" was executed without the player as source"
      );
      context
        .getSource()
        .sendFailure(Component.literal("Command source must be a player"));
      return -1;
    }

    LOGGER.info(
      "Proxycommand \"" +
      command +
      "\" was triggered by " +
      player.getName().getString()
    );
    // To communicate with the proxy, a S2C packet sent via the players connection is needed (the player's connection is the means of communication with the proxy)

    packetSender.sendCommandPacket(player, command);

    return 1;
  }
}
