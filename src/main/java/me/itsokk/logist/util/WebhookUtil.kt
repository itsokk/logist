package me.itsokk.logist.util

import me.itsokk.logist.util.ChatUtil.consoleMessage
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.bukkit.configuration.Configuration


object WebhookUtil {
    var client: OkHttpClient = OkHttpClient()
    fun sendLogHook(user: String, content: String, config: Configuration) {
        val craftedJson = "{\"content\":\"$content\",\"username\":\"$user\",\"avatar_url\":\"${config.getString("webhook.avatar")}\"}"
        val body: RequestBody = craftedJson
            .toRequestBody("application/json".toMediaTypeOrNull())
        val request = config.getString("webhook.url")?.let {
            okhttp3.Request.Builder()
                .url(it)
                .post(body)
                .build()
        }
        if (request != null) {
            val call: Response = client.newCall(request).execute()
            if (!call.isSuccessful) {
                consoleMessage("Failed to send webhook | $user")
            } else {
                consoleMessage("Sent webhook | $user")
            }
        }
    }
}