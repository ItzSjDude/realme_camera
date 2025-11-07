package com.oplus.camera.soloop;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p153l.MyRegionAdapter;
import com.oplus.camera.soloop.SoloopRequest;
import com.oplus.camera.sticker.p166b.HttpRequestHelper;
import com.oplus.camera.sticker.p167c.DeviceInfo;
import com.oplus.camera.update.MD5Utils;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoloopDataRequest.java */
/* renamed from: com.oplus.camera.soloop.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class SoloopDataRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f16123a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SharedPreferences f16124b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Call f16125c = null;

    protected SoloopDataRequest(Context context) {
        this.f16123a = null;
        this.f16124b = null;
        this.f16123a = context;
        this.f16124b = Util.m24472l().getSharedPreferences("soloop_info", 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m16716a() {
        String md5;
        if (this.f16123a == null) {
            return;
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
            CameraLog.m12967f("SoloopDataRequest", "soloopUpdateRequest, project config is off.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Request.Builder builder = new Request.Builder();
        SoloopRequest.ClientMeta clientMeta = new SoloopRequest.ClientMeta();
        SoloopRequest.Upgrades upgrades = new SoloopRequest.Upgrades();
        SoloopRequest soloopRequest = new SoloopRequest();
        Gson gson = new Gson();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            md5 = MD5Utils.getMD5("camera" + jCurrentTimeMillis + "3cba827273b563e6884dec9b0ebacb");
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("SoloopDataRequest", "soloopUpdateRequest error, message: " + COUIBaseListPopupWindow_8.getMessage());
            md5 = "";
        }
        HttpRequestHelper c2975a = new HttpRequestHelper(this.f16123a.getApplicationContext());
        String strM14515e = MyRegionAdapter.m14515e();
        if (strM14515e == null || strM14515e.isEmpty()) {
            CameraLog.m12967f("SoloopDataRequest", "soloopUpdateRequest, routeURL is null");
            return;
        }
        String str = strM14515e + "/camera/getSoloopUpdate";
        clientMeta.androidVersionCode = Build.VERSION.SDK_INT;
        clientMeta.channel = "2101";
        clientMeta.oplusOsCode = DeviceInfo.m16801a().m16805c();
        clientMeta.language = Util.m24324aM();
        clientMeta.model = DeviceInfo.m16801a().m16803b();
        clientMeta.region = DeviceInfo.m16801a().m16808f();
        upgrades.pkgName = "com.oplus.videoeditor";
        upgrades.verCode = 0L;
        soloopRequest.clientMeta = clientMeta;
        arrayList.add(upgrades);
        soloopRequest.upgrades = arrayList;
        builder.addHeader("sign", md5 != null ? md5 : "").addHeader("openid", "camera").addHeader("ts", String.valueOf(jCurrentTimeMillis)).addHeader("appVersion", String.valueOf(DeviceInfo.m16801a().m16802a(this.f16123a))).addHeader("model", DeviceInfo.m16801a().m16803b()).addHeader("oplusOSVersion", DeviceInfo.m16801a().m16805c()).addHeader("uRegion", DeviceInfo.m16801a().m16808f()).addHeader("androidVersion", String.valueOf(Build.VERSION.SDK_INT)).addHeader("ulang", Util.m24361ax()).post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"), gson.toJson(soloopRequest))).url(str);
        HttpRequestHelper.IntrinsicsJvm.kt_3 cVar = new HttpRequestHelper.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.soloop.PlatformImplementations.kt_3.1
            @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.IntrinsicsJvm.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo16719a(ResponseBody responseBody) throws JSONException {
                try {
                    JSONArray jSONArray = new JSONObject(responseBody.string()).getJSONArray("data");
                    if (jSONArray.length() == 0) {
                        SoloopDataRequest.this.m16715c();
                    } else {
                        boolean z = false;
                        String string = ((JSONObject) jSONArray.get(0)).getString("verCode");
                        int OplusGLSurfaceView_13 = ((JSONObject) jSONArray.get(0)).getInt("verCode");
                        boolean z2 = !TextUtils.isEmpty(string);
                        SoloopDataRequest.this.m16714a("key_is_soloop_in_market", z2);
                        SoloopDataRequest c2962a = SoloopDataRequest.this;
                        if (z2 && 12400 <= OplusGLSurfaceView_13) {
                            z = true;
                        }
                        c2962a.m16714a("key_market_soloop_support_jump", z);
                    }
                } catch (Exception e2) {
                    CameraLog.m12959b("SoloopDataRequest", "soloopUpdateRequest, exception: " + e2 + ", responseBody: " + responseBody.toString());
                    SoloopDataRequest.this.m16715c();
                }
            }

            @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.IntrinsicsJvm.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo16718a(String str2) {
                CameraLog.m12959b("SoloopDataRequest", "soloopUpdateRequest, errorMsg: " + str2);
                SoloopDataRequest.this.m16715c();
            }
        };
        this.f16125c = c2975a.m16786a(builder.build());
        c2975a.m16789a(this.f16125c, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16715c() {
        m16714a("key_is_soloop_in_market", false);
        m16714a("key_market_soloop_support_jump", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16714a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f16124b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m16717b() {
        Call call = this.f16125c;
        if (call != null) {
            call.cancel();
        }
        if (this.f16124b != null) {
            this.f16124b = null;
        }
        this.f16123a = null;
    }
}
