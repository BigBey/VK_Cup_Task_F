package ru.bey_sviatoslav.android.vk_cup_task_f.requests

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.bey_sviatoslav.android.vkcuptask1.models.VKGroup

class VKLeaveGroupRequest : VKRequest<Int> {
    constructor(groupId: Int) : super("groups.leave"){
        addParam("group_id", groupId)
    }

    override fun parse(r: JSONObject): Int{
        val result = r.getInt("response")
        return result
    }
}