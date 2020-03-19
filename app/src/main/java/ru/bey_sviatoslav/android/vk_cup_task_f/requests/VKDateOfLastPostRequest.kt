package ru.bey_sviatoslav.android.vk_cup_task_f.requests

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONArray
import org.json.JSONObject
import ru.bey_sviatoslav.android.vkcuptask1.models.VKGroup

class VKDateOfLastPostRequest : VKRequest<Int>{
    constructor(vkGroupId : Int) : super("wall.get"){
        addParam("owner_id", -vkGroupId)
    }

    override fun parse(r: JSONObject): Int {
        val response = r.getJSONObject("response")
        val count = response.getInt("count")
        var result : JSONArray
        if(count > 0){
            result = response.getJSONArray("items")
            return result.getJSONObject(0).getInt("date")
        }
        return -1
    }
}