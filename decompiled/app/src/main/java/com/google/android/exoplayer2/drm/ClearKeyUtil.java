package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
final class ClearKeyUtil {
    private static final java.lang.String TAG = "ClearKeyUtil";

    private ClearKeyUtil() {
    }

    public static byte[] adjustRequestData(byte[] bArr) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 27 ? bArr : com.google.android.exoplayer2.util.Util.getUtf8Bytes(base64ToBase64Url(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr)));
    }

    public static byte[] adjustResponseData(byte[] bArr) throws org.json.JSONException {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 27) {
            return bArr;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr));
            java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"keys\":[");
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i_renamed = 0; i_renamed < jSONArray.length(); i_renamed++) {
                if (i_renamed != 0) {
                    sb.append(",");
                }
                org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i_renamed);
                sb.append("{\"k_renamed\":\"");
                sb.append(base64UrlToBase64(jSONObject2.getString("k_renamed")));
                sb.append("\",\"kid\":\"");
                sb.append(base64UrlToBase64(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return com.google.android.exoplayer2.util.Util.getUtf8Bytes(sb.toString());
        } catch (org.json.JSONException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Failed to adjust response data: " + com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr), e_renamed);
            return bArr;
        }
    }

    private static java.lang.String base64ToBase64Url(java.lang.String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static java.lang.String base64UrlToBase64(java.lang.String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
