package de.michiruf.proxycommand.fabric;

import de.michiruf.proxycommand.common.ProxyCommandConstants;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;

public class S2CPacket {

  public record ProxyCommandPacket(String command) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ProxyCommandPacket> PACKET_TYPE = new CustomPacketPayload.Type<>(
      Identifier.parse(ProxyCommandConstants.COMMAND_PACKET_ID)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, ProxyCommandPacket> PACKET_CODEC = StreamCodec.of(
      (buf, value) -> buf.writeUtf(value.command),
      buf -> new ProxyCommandPacket(buf.readUtf())
    );
    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
      return PACKET_TYPE;
    }
  }

  public S2CPacket() {
    PayloadTypeRegistry
      .clientboundPlay()
      .register(ProxyCommandPacket.PACKET_TYPE, ProxyCommandPacket.PACKET_CODEC);
  }

  public void sendCommandPacket(ServerPlayer player, String command) {
    ServerPlayNetworking.send(player, new ProxyCommandPacket(command));
  }
}
