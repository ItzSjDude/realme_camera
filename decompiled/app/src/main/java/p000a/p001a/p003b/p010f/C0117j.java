package p000a.p001a.p003b.p010f;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class C0117j {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m511a(Object obj) {
        return obj instanceof JsonObject ? m513a((JsonObject) obj) : obj instanceof JsonArray ? m512a((JsonArray) obj) : obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<Object> m512a(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(m511a(it.next()));
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Map<String, Object> m513a(JsonObject jsonObject) {
        HashMap map = new HashMap();
        if (jsonObject != null) {
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                map.put(entry.getKey(), m511a(entry.getValue()));
            }
        }
        return map;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Map<String, Object> m514a(String str) {
        return m513a((JsonObject) C0109b.m465a(str, JsonObject.class));
    }
}
