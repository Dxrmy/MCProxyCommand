# MCProxyCommand

A command mod and proxy plugin that allows sending proxy commands from Minecraft backend server instances to a Velocity proxy. Ported to Minecraft 26.2 and Java 25.

Forked from [GeraldTM/MCProxyCommand](https://github.com/GeraldTM/MCProxyCommand).

## Requirements

- **Fabric API** installed on your backend Minecraft server
- **FabricProxy-Lite** installed on your backend server
- **Velocity** proxy server (v3.4.0+)
- Java 25 runtime

## Installation

1. Drop `proxy-command-fabric-0.jar` into your backend server's `mods/` folder.
2. Drop `proxy-command-velocity-0.jar` into your Velocity proxy's `plugins/` folder.
3. Restart both the backend server and Velocity proxy.

## Usage

Use the `/proxycommand "<command>"` command on backend server instances (via command blocks, menus, or console with a player source):

```mcfunction
execute as @a run proxycommand "server main"
```

## Features for 26.2

- **Unobfuscated Mojang Mappings:** Refactored for native Minecraft 26.2 code structure.
- **Modern Fabric Networking API:** Custom packet payload registration using `CustomPacketPayload` and `clientboundPlay`.
- **Zero Overhead:** Fast byte buffer stream codecs for proxy-backend packet exchange.

## License

[MIT License](LICENSE)

