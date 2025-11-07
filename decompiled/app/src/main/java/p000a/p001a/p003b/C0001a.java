package p000a.p001a.p003b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.entities.Cube;
import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.MagicEraserPath;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000a.p001a.p002a.C0000a;
import p000a.p001a.p003b.p005b.C0053bo;
import p000a.p001a.p003b.p007c.C0093c;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0113f;
import p000a.p001a.p003b.p010f.C0114g;
import p000a.p001a.p003b.p010f.C0117j;
import p000a.p001a.p003b.p010f.C0120m;
import p000a.p001a.p003b.p010f.C0123p;
import p000a.p001a.p003b.p010f.C0133z;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class C0001a {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f0a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m3a() {
        int OplusGLSurfaceView_13;
        synchronized (C0001a.class) {
            try {
                OplusGLSurfaceView_13 = f0a / 90;
            } catch (Throwable th) {
                throw th;
            }
        }
        return OplusGLSurfaceView_13 % 4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<Bitmap> m4a(Resources resources, Bitmap bitmap, List<String> list) {
        return m5a(resources, bitmap, list, 1.0f, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<Bitmap> m5a(Resources resources, Bitmap bitmap, List<String> list, float COUIBaseListPopupWindow_12, float f2) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || list == null || list.isEmpty()) {
            return null;
        }
        C0114g.m492a("renderBitmaps::idList=%s::filterIntensity=%COUIBaseListPopupWindow_12", list.toString(), Float.valueOf(COUIBaseListPopupWindow_12));
        C0093c c0093c = new C0093c();
        c0093c.m278a(100, 100);
        C0098d c0098d = new C0098d();
        c0098d.m373a(resources, bitmap.getWidth(), bitmap.getHeight(), true, 0);
        c0098d.m409f();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c0098d.m355a(bitmap, it.next(), COUIBaseListPopupWindow_12, f2));
        }
        c0098d.m430u();
        c0093c.m280a();
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        C0114g.m492a("setupVignetteParams::vignette_amount=%COUIBaseListPopupWindow_12::vignette_feather=%COUIBaseListPopupWindow_12::vignette_highlights=%COUIBaseListPopupWindow_12::vignette_exposure=%COUIBaseListPopupWindow_12::vignette_roundness=%COUIBaseListPopupWindow_12::vignette_size=%COUIBaseListPopupWindow_12", Float.valueOf(COUIBaseListPopupWindow_12), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6));
        C0053bo.f227r = COUIBaseListPopupWindow_12;
        C0053bo.f228s = f2;
        C0053bo.f229t = f3;
        C0053bo.f230u = f4;
        C0053bo.f231v = f5;
        C0053bo.f232w = f6;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m7a(int OplusGLSurfaceView_13) {
        synchronized (C0001a.class) {
            try {
                C0114g.m492a("PolarrRenderImpl::updateGlobalScreenOrientation = %IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13));
                f0a = OplusGLSurfaceView_13;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8a(int OplusGLSurfaceView_13, int i2, int i3) {
        C0114g.m492a("clearTextureHelper::textureId=%IntrinsicsJvm.kt_5::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2 * i3 * 4);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, byteBufferAllocate);
        GLES20.glBindTexture(3553, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9a(C0094d c0094d) {
        if (c0094d == null) {
            return;
        }
        C0113f.m476a(c0094d.f387a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m10a(Resources resources, int OplusGLSurfaceView_13, int i2, int i3, MagicEraserPath magicEraserPath, int i4) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        m11a("start magicEraserOneTime");
        if (magicEraserPath == null) {
            return;
        }
        C0114g.m492a("doMagicEraserOneTime::applyTextureId=%IntrinsicsJvm.kt_5::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5::path=%s::compatibleLevel=%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), magicEraserPath, Integer.valueOf(i4));
        boolean zGlIsEnabled = GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            GLES20.glDisable(3089);
        }
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        C0133z c0133z = new C0133z(resources, C0120m.m522a(resources));
        c0133z.m687b(OplusGLSurfaceView_13, i2, i3, i4);
        c0133z.m675a(OplusGLSurfaceView_13, magicEraserPath);
        c0133z.m672a();
        c0133z.m686b();
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        if (zGlIsEnabled) {
            GLES20.glEnable(3089);
        }
        m11a("end magicEraserOneTime");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11a(String str) {
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            } else {
                C0123p.m576a(str, iGlGetError);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m12a(boolean z) {
        C0114g.m493a(z);
        C0114g.m492a("enableLogger::enableLogger=%IntrinsicsJvm.kt_4", Boolean.valueOf(z));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m13a(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2, String str, float COUIBaseListPopupWindow_12, boolean z) {
        C0114g.m492a("renderNV21::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5::filterId=%s::filterIntensity=%COUIBaseListPopupWindow_12::isUseVignette=%IntrinsicsJvm.kt_4", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), str, Float.valueOf(COUIBaseListPopupWindow_12), Boolean.valueOf(z));
        boolean zM5385a = FilterPackageUtil.m5385a(str, "vignette_amount");
        boolean zM5385a2 = FilterPackageUtil.m5385a(str, "overlay_amount");
        if (z || zM5385a || zM5385a2) {
            m14a(context, bArr, OplusGLSurfaceView_13, i2, str, false);
            throw null;
        }
        Cube cubeM5387b = FilterPackageUtil.m5387b(context.getAssets(), str);
        C0000a.m0a(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2, false, -1, cubeM5387b.data, bArr, false, cubeM5387b.size);
        throw null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m14a(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2, String str, boolean z) {
        C0114g.m492a("renderNV12::getGlobalScreenOrientation=%IntrinsicsJvm.kt_5", Integer.valueOf(m3a()));
        Cube cubeM5387b = FilterPackageUtil.m5387b(context.getAssets(), str);
        boolean zM5385a = FilterPackageUtil.m5385a(str, "vignette_amount");
        boolean zM5385a2 = FilterPackageUtil.m5385a(str, "overlay_amount");
        if (zM5385a) {
            FilterItem filterItemM439a = C0101e.m438a().m439a(str);
            C0000a.m2a(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2, false, -1, cubeM5387b.data, bArr, z, cubeM5387b.size, ((Float) filterItemM439a.state.get("vignette_amount")).floatValue(), ((Float) filterItemM439a.state.get("vignette_feather")).floatValue(), ((Float) filterItemM439a.state.get("vignette_highlights")).floatValue(), ((Float) filterItemM439a.state.get("vignette_exposure")).floatValue(), ((Float) filterItemM439a.state.get("vignette_roundness")).floatValue(), ((Float) filterItemM439a.state.get("vignette_size")).floatValue(), true, C0053bo.f233x, m3a(), 0.08f, 0.6f, 0.88f, 0.2f);
            throw null;
        }
        if (zM5385a2) {
            C0000a.m1a(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2, false, -2, cubeM5387b.data, bArr, z, cubeM5387b.size, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true, C0053bo.f234y, m3a());
            throw null;
        }
        C0000a.m1a(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2, false, 0, cubeM5387b.data, bArr, z, cubeM5387b.size, C0053bo.f227r, C0053bo.f228s, C0053bo.f229t, C0053bo.f230u, C0053bo.f231v, C0053bo.f232w, false, new byte[0], m3a());
        throw null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Map<String, Object> m15b(String str) {
        Map<String, Object> mapM514a = C0117j.m514a(str);
        for (String str2 : mapM514a.keySet()) {
            mapM514a.put(str2, C0120m.m523a(str2, mapM514a.get(str2)));
        }
        return mapM514a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m16b(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2, String str, float COUIBaseListPopupWindow_12, boolean z) {
        C0114g.m492a("renderNV12::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5::filterId=%s::filterIntensity=%COUIBaseListPopupWindow_12::isUseVignette=%IntrinsicsJvm.kt_4", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), str, Float.valueOf(COUIBaseListPopupWindow_12), Boolean.valueOf(z));
        boolean zM5385a = FilterPackageUtil.m5385a(str, "vignette_amount");
        boolean zM5385a2 = FilterPackageUtil.m5385a(str, "overlay_amount");
        if (z || zM5385a || zM5385a2) {
            m14a(context, bArr, OplusGLSurfaceView_13, i2, str, true);
            throw null;
        }
        Cube cubeM5387b = FilterPackageUtil.m5387b(context.getAssets(), str);
        C0000a.m0a(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2, false, -1, cubeM5387b.data, bArr, true, cubeM5387b.size);
        throw null;
    }
}
