package me.itsokk.logist.util

import org.bukkit.entity.Player

object ChatUtil {
    val PREFIX = "&c[ogist]&d:&r "
    val CONSOLE_PREFIX = "[logist] "
    fun sendChatMessage(msg: String, p: Player) {
        p.sendMessage(PREFIX + msg)
    }
    fun consoleMessage(msg: String) {
        println(CONSOLE_PREFIX + msg)
    }
}