package com.gfr.betterandbluer.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.net.HttpURLConnection;
import java.net.URI;
import java.security.MessageDigest;

public class PlayerJoinListener implements Listener {

    private static final String PACK_URL =
            "https://github.com/Goodfellows-Engineering-Department/Goodfellows-Resourcepack/releases/latest/download/resourcepack.zip";

    private final Plugin plugin;
    private byte[] cachedHash = null;
    private long lastFetch = 0;
    private static final long CACHE_DURATION = 5 * 60 * 1000; // 5 minutes

    public PlayerJoinListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        fetchAndApply(event);
    }

    private void fetchAndApply(PlayerJoinEvent event) {
        event.getPlayer().getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                long now = System.currentTimeMillis();

                if (cachedHash == null || (now - lastFetch) > CACHE_DURATION) {
                    cachedHash = computeSHA1(PACK_URL);
                    lastFetch = now;
                }

                final byte[] hash = cachedHash;

                event.getPlayer().getServer().getScheduler().runTask(plugin,
                        () -> event.getPlayer().setResourcePack(
                                PACK_URL,
                                hash,
                                net.kyori.adventure.text.Component.text(
                                        "§6You must accept the resource pack to play on this server."),
                                true
                        )
                );

            } catch (Exception e) {
                e.printStackTrace();
                event.getPlayer().getServer().getScheduler().runTask(plugin,
                        () -> event.getPlayer().kick(
                                net.kyori.adventure.text.Component.text(
                                        "§cFailed to apply resource pack. Please rejoin.")));
            }
        });
    }

    private byte[] computeSHA1(String fileUrl) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) URI.create(fileUrl)
                .toURL().openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "BetterandBluer-Plugin");
        conn.setConnectTimeout(15000);
        conn.setReadTimeout(30000);
        conn.setInstanceFollowRedirects(true);

        MessageDigest digest = MessageDigest.getInstance("SHA-1");

        try (var inputStream = conn.getInputStream()) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }
        }

        return digest.digest();
    }
}