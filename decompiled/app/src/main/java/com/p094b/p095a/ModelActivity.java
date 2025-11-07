package com.p094b.p095a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import android.widget.Toast;
import com.android.providers.downloads.Downloads;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.p094b.p095a.p096a.AnimID;
import java.io.File;
import org.andresoviedo.p225a.p226a.ContentUtils;

/* compiled from: ModelActivity.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class ModelActivity {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f6103a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static O3DPHOTO_MODEL f6104b = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final String f6105g = "IntrinsicsJvm.kt_3";

    /* renamed from: p */
    private static ModelActivity f6106p;

    /* renamed from: q */
    private static final PlatformImplementations.kt_3[] f6107q = {new PlatformImplementations.kt_3(AnimID.FixedGaze, ErrorCode.REASON_DS_ASSET, 1000), new PlatformImplementations.kt_3(AnimID.DollyZoom, ErrorCode.REASON_DS_ASSET, 1000), new PlatformImplementations.kt_3(AnimID.Circle, 5000, 1000), new PlatformImplementations.kt_3(AnimID.Swing, 5000, 1000)};

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Activity f6108c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public ModelViewConnection f6109d;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6113i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Uri f6114j;

    /* renamed from: OplusGLSurfaceView_6 */
    private ModelSurfaceView f6117m;

    /* renamed from: OplusGLSurfaceView_11 */
    private SceneLoader f6118n;

    /* renamed from: o */
    private Handler f6119o;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f6112h = -1;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f6115k = true;

    /* renamed from: OplusGLSurfaceView_14 */
    private float[] f6116l = {0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_8 */
    long f6110e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    Runnable f6111f = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public static ModelActivity m6280a() {
        if (f6106p == null) {
            f6106p = new ModelActivity();
        }
        return f6106p;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m6281b() {
        Log.m6278d("ModelActivity", "release");
        ModelActivity c1232c = f6106p;
        c1232c.f6117m = null;
        c1232c.f6118n = null;
        c1232c.f6119o = null;
        c1232c.f6108c = null;
        c1232c.f6109d = null;
        f6104b = null;
        f6106p = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6283a(ModelViewConnection interfaceC1235f, Surface surface, int OplusGLSurfaceView_13, int i2, SurfaceListener interfaceC1240k) {
        Log.m6278d("ModelActivity", "init");
        this.f6109d = interfaceC1235f;
        this.f6108c = interfaceC1235f.mo6314a();
        Bundle bundle = new Bundle();
        bundle.putInt(CameraParameter.TiltShiftParamKeys.TYPE, 0);
        String str = f6103a;
        if (str != null && str.startsWith("/")) {
            File file = new File(f6103a);
            ContentUtils.m26075a(file.getParentFile());
            bundle.putString(Downloads.Impl.COLUMN_URI, "file://" + file.getAbsolutePath());
        } else {
            bundle.putString(Downloads.Impl.COLUMN_URI, f6103a);
        }
        if (bundle.getString(Downloads.Impl.COLUMN_URI) != null) {
            this.f6114j = Uri.parse(bundle.getString(Downloads.Impl.COLUMN_URI));
        }
        this.f6113i = bundle.getInt(CameraParameter.TiltShiftParamKeys.TYPE, 0);
        this.f6115k = "true".equalsIgnoreCase(bundle.getString("immersiveMode"));
        try {
            String[] strArrSplit = bundle.getString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR).split(" ");
            this.f6116l[0] = Float.parseFloat(strArrSplit[0]);
            this.f6116l[1] = Float.parseFloat(strArrSplit[1]);
            this.f6116l[2] = Float.parseFloat(strArrSplit[2]);
            this.f6116l[3] = Float.parseFloat(strArrSplit[3]);
        } catch (Exception unused) {
        }
        Log.m6278d("Renderer", "Params: uri '" + this.f6114j + "'");
        this.f6119o = new Handler(this.f6108c.getMainLooper());
        this.f6118n = new SceneLoader(this);
        this.f6118n.m6330a();
        try {
            this.f6117m = new ModelSurfaceView(this, surface, OplusGLSurfaceView_13, i2, interfaceC1240k);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Toast.makeText(this.f6108c, "Error loading OpenGL view:\OplusGLSurfaceView_11" + COUIBaseListPopupWindow_8.getMessage(), 1).show();
        }
        m6282g();
    }

    public ModelActivity() {
        Log.m6278d("ModelActivity", "default constructor");
    }

    @TargetApi(16)
    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m6282g() {
        if (Build.VERSION.SDK_INT < 16) {
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SceneLoader m6284c() {
        return this.f6118n;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public ModelSurfaceView m6285d() {
        return this.f6117m;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6286e() {
        ModelSurfaceView c1234eM6285d = m6285d();
        if (c1234eM6285d != null) {
            c1234eM6285d.m6309a();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m6287f() {
        ModelSurfaceView c1234eM6285d = m6285d();
        if (c1234eM6285d != null) {
            c1234eM6285d.m6310b();
        }
    }

    /* compiled from: ModelActivity.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        AnimID f6120a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f6121b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f6122c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f6123d = false;

        PlatformImplementations.kt_3(AnimID enumC1223d, int OplusGLSurfaceView_13, int i2) {
            this.f6120a = enumC1223d;
            this.f6121b = OplusGLSurfaceView_13;
            this.f6122c = i2;
        }
    }
}
