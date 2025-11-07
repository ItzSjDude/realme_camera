package com.oplus.camera.soloop;

/* compiled from: SoloopDataRequest.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5406a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f5407b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private okhttp3.Call f5408c = null;

    protected a_renamed(android.content.Context context) {
        this.f5406a = null;
        this.f5407b = null;
        this.f5406a = context;
        this.f5407b = com.oplus.camera.util.Util.l_renamed().getSharedPreferences("soloop_info", 0);
    }

    protected void a_renamed() {
        java.lang.String md5;
        if (this.f5406a == null) {
            return;
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
            com.oplus.camera.e_renamed.f_renamed("SoloopDataRequest", "soloopUpdateRequest, project config is_renamed off.");
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        com.oplus.camera.soloop.SoloopRequest.ClientMeta clientMeta = new com.oplus.camera.soloop.SoloopRequest.ClientMeta();
        com.oplus.camera.soloop.SoloopRequest.Upgrades upgrades = new com.oplus.camera.soloop.SoloopRequest.Upgrades();
        com.oplus.camera.soloop.SoloopRequest soloopRequest = new com.oplus.camera.soloop.SoloopRequest();
        com.google.gson.Gson gson = new com.google.gson.Gson();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        try {
            md5 = com.oplus.camera.update.MD5Utils.getMD5("camera" + jCurrentTimeMillis + "3cba827273b563e6884dec9b0ebacb");
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("SoloopDataRequest", "soloopUpdateRequest error, message: " + e_renamed.getMessage());
            md5 = "";
        }
        com.oplus.camera.sticker.b_renamed.a_renamed aVar = new com.oplus.camera.sticker.b_renamed.a_renamed(this.f5406a.getApplicationContext());
        java.lang.String strE = com.oplus.camera.l_renamed.a_renamed.e_renamed();
        if (strE == null || strE.isEmpty()) {
            com.oplus.camera.e_renamed.f_renamed("SoloopDataRequest", "soloopUpdateRequest, routeURL is_renamed null");
            return;
        }
        java.lang.String str = strE + "/camera/getSoloopUpdate";
        clientMeta.androidVersionCode = android.os.Build.VERSION.SDK_INT;
        clientMeta.channel = "2101";
        clientMeta.oplusOsCode = com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().c_renamed();
        clientMeta.language = com.oplus.camera.util.Util.aM_renamed();
        clientMeta.model = com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().b_renamed();
        clientMeta.region = com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().f_renamed();
        upgrades.pkgName = "com.oplus.videoeditor";
        upgrades.verCode = 0L;
        soloopRequest.clientMeta = clientMeta;
        arrayList.add(upgrades);
        soloopRequest.upgrades = arrayList;
        builder.addHeader("sign", md5 != null ? md5 : "").addHeader("openid", "camera").addHeader("ts", java.lang.String.valueOf(jCurrentTimeMillis)).addHeader("appVersion", java.lang.String.valueOf(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().a_renamed(this.f5406a))).addHeader("model", com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().b_renamed()).addHeader("oplusOSVersion", com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().c_renamed()).addHeader("uRegion", com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().f_renamed()).addHeader("androidVersion", java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT)).addHeader("ulang", com.oplus.camera.util.Util.ax_renamed()).post(okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/json;charset=utf-8"), gson.toJson(soloopRequest))).url(str);
        com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed cVar = new com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed() { // from class: com.oplus.camera.soloop.a_renamed.1
            @Override // com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed
            public void a_renamed(okhttp3.ResponseBody responseBody) throws org.json.JSONException {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONObject(responseBody.string()).getJSONArray("data");
                    if (jSONArray.length() == 0) {
                        com.oplus.camera.soloop.a_renamed.this.c_renamed();
                    } else {
                        boolean z_renamed = false;
                        java.lang.String string = ((org.json.JSONObject) jSONArray.get(0)).getString("verCode");
                        int i_renamed = ((org.json.JSONObject) jSONArray.get(0)).getInt("verCode");
                        boolean z2 = !android.text.TextUtils.isEmpty(string);
                        com.oplus.camera.soloop.a_renamed.this.a_renamed("key_is_soloop_in_market", z2);
                        com.oplus.camera.soloop.a_renamed aVar2 = com.oplus.camera.soloop.a_renamed.this;
                        if (z2 && 12400 <= i_renamed) {
                            z_renamed = true;
                        }
                        aVar2.a_renamed("key_market_soloop_support_jump", z_renamed);
                    }
                } catch (java.lang.Exception e2) {
                    com.oplus.camera.e_renamed.b_renamed("SoloopDataRequest", "soloopUpdateRequest, exception: " + e2 + ", responseBody: " + responseBody.toString());
                    com.oplus.camera.soloop.a_renamed.this.c_renamed();
                }
            }

            @Override // com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed
            public void a_renamed(java.lang.String str2) {
                com.oplus.camera.e_renamed.b_renamed("SoloopDataRequest", "soloopUpdateRequest, errorMsg: " + str2);
                com.oplus.camera.soloop.a_renamed.this.c_renamed();
            }
        };
        this.f5408c = aVar.a_renamed(builder.build());
        aVar.a_renamed(this.f5408c, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed() {
        a_renamed("key_is_soloop_in_market", false);
        a_renamed("key_market_soloop_support_jump", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, boolean z_renamed) {
        android.content.SharedPreferences sharedPreferences = this.f5407b;
        if (sharedPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z_renamed);
            editorEdit.apply();
        }
    }

    protected void b_renamed() {
        okhttp3.Call call = this.f5408c;
        if (call != null) {
            call.cancel();
        }
        if (this.f5407b != null) {
            this.f5407b = null;
        }
        this.f5406a = null;
    }
}
