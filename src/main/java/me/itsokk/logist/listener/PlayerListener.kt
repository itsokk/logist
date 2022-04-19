package me.itsokk.logist.listener

import me.itsokk.logist.util.WebhookUtil.sendLogHook
import org.bukkit.configuration.Configuration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerAdvancementDoneEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerListener(val config: Configuration): Listener {
    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        if(config.getBoolean("logging.enabled") && config.getBoolean("logging.log-player-quit")) {
            sendLogHook("PlayerQuitEvent", ("Player quit: " + event.player.name + " (" + event.reason + ")"), config)
        }
    }
    @EventHandler
    fun onAsyncPlayerJoin(event: AsyncPlayerPreLoginEvent) {
        if(config.getBoolean("logging.enabled") && config.getBoolean("logging.log-player-join")) {
            sendLogHook("AsyncPlayerPreLoginEvent", ("Player joined: " + event.name + " (" + (event.address.toString().split(".")[0] + ".XX.XX." + event.address.toString().split(".")[1]) + ")"), config)
        }
    }
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        if(config.getBoolean("logging.enabled") && config.getBoolean("logging.log-player-death")) {
            sendLogHook("PlayerDeathEvent", ("Player died: " + event.player.name + " (" + event.deathMessage + ")"), config)
        }
    }
    @EventHandler
    fun onPlayerAdvancement(event: PlayerAdvancementDoneEvent) {
        if(config.getBoolean("logging.enabled") && config.getBoolean("logging.log-player-advancement")) {
            sendLogHook("PlayerAdvancementDoneEvent", ("Player advancement: " + event.player.name + " (" + event.advancement.key.key + ")"), config)
        }
    }
}
