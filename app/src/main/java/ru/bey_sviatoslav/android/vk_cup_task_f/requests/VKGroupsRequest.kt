package ru.bey_sviatoslav.android.vk_cup_task_f.requests

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.bey_sviatoslav.android.vkcuptask1.models.VKGroup

class VKGroupsRequest: VKRequest<List<VKGroup>> {
    constructor() : super("groups.get"){
        addParam("extended", 1)
        addParam("fields", listOf("members_count","description", "is_member"))
    }

    override fun parse(r: JSONObject): List<VKGroup> {
        val response = r.getJSONObject("response")
        val groups = response.getJSONArray("items")
        val result = ArrayList<VKGroup>()
        for (i in 0 until groups.length()) {
            if(VKGroup.parse(groups.getJSONObject(i)).isMember == 1)
                result.add(VKGroup.parse(groups.getJSONObject(i)))
        }
        return result.reversed()
    }
}