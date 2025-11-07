package com.oplus.camera.p161r;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.util.storage.MediaStoreUtil;
import com.oplus.ocs.camera.CameraParameter;
import com.p097c.MeicamVideoEngine;
import com.p097c.MeicamVideoEngineListener;

/* compiled from: SLVFps960Mode.java */
/* renamed from: com.oplus.camera.r.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class SLVFps960Mode extends SLVBaseMode {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f15862d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private MeicamVideoEngine f15863e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f15864f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f15865g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final MeicamVideoEngineListener f15866h;

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: PlatformImplementations.kt_3 */
    int mo16219a() {
        return CameraParameter.VideoFps.FPS_960;
    }

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo16224b() {
        return true;
    }

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo16225c() {
        return 2250;
    }

    public SLVFps960Mode(Activity activity, CameraUIInterface cameraUIInterface) {
        super(activity, cameraUIInterface);
        this.f15862d = false;
        this.f15866h = new MeicamVideoEngineListener() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_8.1

            /* renamed from: IntrinsicsJvm.kt_4 */
            private boolean f15868b = false;

            @Override // com.p097c.MeicamVideoEngineListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo6379a(int OplusGLSurfaceView_13) {
                String str;
                if (OplusGLSurfaceView_13 == 1) {
                    this.f15868b = false;
                    return;
                }
                if (OplusGLSurfaceView_13 != 2) {
                    if (OplusGLSurfaceView_13 != 3) {
                        return;
                    }
                    str = SLVFps960Mode.this.f15863e != null ? SLVFps960Mode.this.f15865g : null;
                    this.f15868b = true;
                    SLVFps960Mode.this.f15861c.mo16229b(str);
                    CameraLog.m12967f("SLVFps960Mode", "onCompileStatusChange, compile failed!");
                    return;
                }
                if (!this.f15868b) {
                    str = SLVFps960Mode.this.f15863e != null ? SLVFps960Mode.this.f15865g : null;
                    CameraLog.m12959b("SLVFps960Mode", "onCompileStatusChange mbStopped: " + SLVFps960Mode.this.f15862d);
                    if (SLVFps960Mode.this.f15862d) {
                        SLVFps960Mode.this.f15862d = false;
                        SLVFps960Mode.this.f15861c.mo16229b(str);
                    } else {
                        SLVFps960Mode.this.f15861c.mo16228a(str);
                    }
                    CameraLog.m12959b("SLVFps960Mode", "onCompileStatusChange, STATUS_COMPILE_FINISHED CostTime: " + (System.currentTimeMillis() - SLVFps960Mode.this.f15863e.m6378c()));
                    return;
                }
                CameraLog.m12959b("SLVFps960Mode", "onCompileStatusChange, compile finished, but already failed!");
            }
        };
        m16236f();
        CameraLog.m12959b("SLVFps960Mode", "SLVFps960Mode, new MeicamVideoEngine");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m16236f() {
        this.f15859a.runOnUiThread(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_8.2
            @Override // java.lang.Runnable
            public void run() {
                if (SLVFps960Mode.this.f15863e == null) {
                    SLVFps960Mode c2915e = SLVFps960Mode.this;
                    c2915e.f15863e = new MeicamVideoEngine(c2915e.f15859a, SLVFps960Mode.this.f15866h);
                }
            }
        });
    }

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo16226d() {
        this.f15862d = true;
        MeicamVideoEngine c1245a = this.f15863e;
        if (c1245a != null) {
            c1245a.m6374a();
        }
    }

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo16227e() {
        this.f15859a.runOnUiThread(new Runnable() { // from class: com.oplus.camera.r.COUIBaseListPopupWindow_8.3
            @Override // java.lang.Runnable
            public void run() {
                if (SLVFps960Mode.this.f15863e != null) {
                    SLVFps960Mode.this.f15863e.m6377b();
                    SLVFps960Mode.this.f15863e = null;
                    CameraLog.m12959b("SLVFps960Mode", "exit, releaseMeicamVideoEngine");
                }
            }
        });
        super.mo16227e();
    }

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: PlatformImplementations.kt_3 */
    public MainShutterButtonInfo mo16220a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 2) {
            return new MainShutterButtonInfo(3, "button_color_inside_none", "button_shape_dial_still", 1);
        }
        return super.mo16220a(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16223a(int OplusGLSurfaceView_13, Uri uri, ContentValues contentValues, String str) {
        boolean zM6376a = false;
        this.f15862d = false;
        if (this.f15863e != null && !TextUtils.isEmpty(this.f15864f) && uri != null && contentValues != null) {
            String strReplace = String.valueOf(contentValues.get("_display_name")).replace("VID", "Slow");
            ContentValues contentValues2 = new ContentValues(7);
            contentValues2.put("title", str);
            contentValues2.put("_display_name", strReplace);
            contentValues2.put("mime_type", String.valueOf(contentValues.get("mime_type")));
            contentValues2.put("relative_path", Storage.m11140e(null));
            contentValues2.put("is_pending", (Integer) 1);
            this.f15865g = MediaStoreUtil.m24650a(this.f15859a, this.f15859a.getContentResolver(), contentValues2).toString();
            this.f15863e.m6375a(OplusGLSurfaceView_13);
            zM6376a = this.f15863e.m6376a(uri.toString(), this.f15865g, CameraParameter.VideoFps.FPS_960 / Integer.parseInt(this.f15864f));
        }
        if (!zM6376a) {
            this.f15861c.mo16229b(null);
        }
        return zM6376a;
    }

    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected String mo16221a(String str) {
        this.f15864f = str;
        return "slow_motion_platform_" + str + "_960";
    }
}
