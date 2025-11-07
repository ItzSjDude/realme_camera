package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class j_renamed {
    public static java.lang.Object a_renamed(java.lang.Object obj) {
        return obj instanceof com.google.gson.JsonObject ? a_renamed((com.google.gson.JsonObject) obj) : obj instanceof com.google.gson.JsonArray ? a_renamed((com.google.gson.JsonArray) obj) : obj;
    }

    public static java.util.List<java.lang.Object> a_renamed(com.google.gson.JsonArray jsonArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.google.gson.JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(a_renamed(it.next()));
        }
        return arrayList;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> a_renamed(com.google.gson.JsonObject jsonObject) {
        java.util.HashMap map = new java.util.HashMap();
        if (jsonObject != null) {
            for (java.util.Map.Entry<java.lang.String, com.google.gson.JsonElement> entry : jsonObject.entrySet()) {
                map.put(entry.getKey(), a_renamed(entry.getValue()));
            }
        }
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> a_renamed(java.lang.String str) {
        return a_renamed((com.google.gson.JsonObject) a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(str, com.google.gson.JsonObject.class));
    }
}
