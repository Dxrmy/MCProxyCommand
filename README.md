<div align="center">

# 🔀 MCProxyCommand
**High-performance proxy command bridge for Minecraft 26.2 & Velocity**

[![Minecraft](https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge&logo=minecraft)](https://minecraft.net/)
[![Fabric](https://img.shields.io/badge/Fabric-0.19.3+-blue?style=for-the-badge&logo=fabric)](https://fabricmc.net/)
[![Velocity](https://img.shields.io/badge/Velocity-3.4.0+-purple?style=for-the-badge&logo=paper)](https://papermc.io/)
[![Fork](https://img.shields.io/badge/Fork-GeraldTM%2FMCProxyCommand-gray?style=for-the-badge&logo=github)](https://github.com/GeraldTM/MCProxyCommand)
[![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)](LICENSE)

</div>

---

## 📖 About MCProxyCommand

**MCProxyCommand** is a seamless communication bridge between Fabric 26.2 backend servers and Velocity proxy networks. This repository is a 26.2 fork of the original project by [GeraldTM](https://github.com/GeraldTM/MCProxyCommand), upgraded to support Minecraft 26.2 unobfuscated Mojang mappings and Java 25.

Engineered specifically for **Minecraft 26.2**, it leverages native unobfuscated Mojang mappings, modern Fabric Networking API (`CustomPacketPayload`, `clientboundPlay`), and high-efficiency byte buffer codecs.

---

## ✨ Features

- **26.2 Native Compatibility:** Native Mojang-mapped Fabric mod targeting Minecraft 26.2 and Java 25.
- **Velocity Integration:** Companion Velocity plugin to execute proxy actions securely on behalf of connected players.
- **GUI & Command Block Support:** Seamlessly execute `/proxycommand "server <name>"` from server menus, NPC interactions, or command blocks.
- **Stateless & Lightweight:** Zero background thread overhead on both the proxy and backend servers.

---

## 🚀 Installation

1. **Backend Server (Fabric 26.2):**
   - Install **Fabric API** (`0.155.2+26.2` or later).
   - Install **FabricProxy-Lite**.
   - Place `proxy-command-fabric-0.jar` into your `mods/` directory.

2. **Proxy Server (Velocity):**
   - Place `proxy-command-velocity-0.jar` into your Velocity `plugins/` directory.

---

## 💡 Usage

Execute `/proxycommand "<command>"` on the backend server with a player as the command source:

```mcfunction
execute as @a run proxycommand "server main"
```

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

