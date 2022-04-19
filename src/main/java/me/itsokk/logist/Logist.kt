package me.itsokk.logist

import me.itsokk.logist.listener.PlayerListener
import me.itsokk.logist.util.ChatUtil.consoleMessage
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level

@Suppress("unused")
class Logist : JavaPlugin() {
    override fun onEnable() {
        this.saveDefaultConfig()
        Bukkit.getServer().pluginManager.registerEvents(PlayerListener(this.config), this)
        consoleMessage("Enabled! " + this.description.version)
        if(config.getString("webhook.url") == "") Bukkit.getLogger().log(Level.SEVERE, "[Logist] NO WEBHOOK SPECIFIED IN THE CONFIG! Please shutdown your server and change the value!")
    }
    override fun onDisable() {
        consoleMessage("Disabled! " + this.description.version)
    }
}