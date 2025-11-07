package a_renamed.a_renamed.b_renamed;

/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f3a;

    public static int a_renamed() {
        int i_renamed;
        synchronized (a_renamed.a_renamed.b_renamed.a_renamed.class) {
            try {
                i_renamed = f3a / 90;
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return i_renamed % 4;
    }

    public static java.util.List<android.graphics.Bitmap> a_renamed(android.content.res.Resources resources, android.graphics.Bitmap bitmap, java.util.List<java.lang.String> list) {
        return a_renamed(resources, bitmap, list, 1.0f, 0.0f);
    }

    public static java.util.List<android.graphics.Bitmap> a_renamed(android.content.res.Resources resources, android.graphics.Bitmap bitmap, java.util.List<java.lang.String> list, float f_renamed, float f2) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || list == null || list.isEmpty()) {
            return null;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("renderBitmaps::idList=%s_renamed::filterIntensity=%f_renamed", list.toString(), java.lang.Float.valueOf(f_renamed));
        a_renamed.a_renamed.b_renamed.c_renamed.c_renamed cVar = new a_renamed.a_renamed.b_renamed.c_renamed.c_renamed();
        cVar.a_renamed(100, 100);
        a_renamed.a_renamed.b_renamed.d_renamed dVar = new a_renamed.a_renamed.b_renamed.d_renamed();
        dVar.a_renamed(resources, bitmap.getWidth(), bitmap.getHeight(), true, 0);
        dVar.f_renamed();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(dVar.a_renamed(bitmap, it.next(), f_renamed, f2));
        }
        dVar.u_renamed();
        cVar.a_renamed();
        return arrayList;
    }

    public static void a_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("setupVignetteParams::vignette_amount=%f_renamed::vignette_feather=%f_renamed::vignette_highlights=%f_renamed::vignette_exposure=%f_renamed::vignette_roundness=%f_renamed::vignette_size=%f_renamed", java.lang.Float.valueOf(f_renamed), java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3), java.lang.Float.valueOf(f4), java.lang.Float.valueOf(f5), java.lang.Float.valueOf(f6));
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.r_renamed = f_renamed;
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.s_renamed = f2;
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.t_renamed = f3;
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.u_renamed = f4;
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.v_renamed = f5;
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.w_renamed = f6;
    }

    public static void a_renamed(int i_renamed) {
        synchronized (a_renamed.a_renamed.b_renamed.a_renamed.class) {
            try {
                a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("PolarrRenderImpl::updateGlobalScreenOrientation = %d_renamed", java.lang.Integer.valueOf(i_renamed));
                f3a = i_renamed;
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public static void a_renamed(int i_renamed, int i2, int i3) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("clearTextureHelper::textureId=%d_renamed::width=%d_renamed::height=%d_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i2 * i3 * 4);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, byteBufferAllocate);
        android.opengl.GLES20.glBindTexture(3553, 0);
    }

    public static void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        if (dVar == null) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar.f34a);
    }

    public static void a_renamed(android.content.res.Resources resources, int i_renamed, int i2, int i3, co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath, int i4) {
        if (i_renamed <= 0) {
            return;
        }
        a_renamed("start magicEraserOneTime");
        if (magicEraserPath == null) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("doMagicEraserOneTime::applyTextureId=%d_renamed::width=%d_renamed::height=%d_renamed::path=%s_renamed::compatibleLevel=%d_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), magicEraserPath, java.lang.Integer.valueOf(i4));
        boolean zGlIsEnabled = android.opengl.GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            android.opengl.GLES20.glDisable(3089);
        }
        int[] iArr = new int[4];
        android.opengl.GLES20.glGetIntegerv(2978, iArr, 0);
        a_renamed.a_renamed.b_renamed.f_renamed.z_renamed zVar = new a_renamed.a_renamed.b_renamed.f_renamed.z_renamed(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(resources));
        zVar.b_renamed(i_renamed, i2, i3, i4);
        zVar.a_renamed(i_renamed, magicEraserPath);
        zVar.a_renamed();
        zVar.b_renamed();
        android.opengl.GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        if (zGlIsEnabled) {
            android.opengl.GLES20.glEnable(3089);
        }
        a_renamed("end magicEraserOneTime");
    }

    public static void a_renamed(java.lang.String str) {
        while (true) {
            int iGlGetError = android.opengl.GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            } else {
                a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(str, iGlGetError);
            }
        }
    }

    public static void a_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed(z_renamed);
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("enableLogger::enableLogger=%b_renamed", java.lang.Boolean.valueOf(z_renamed));
    }

    public static byte[] a_renamed(android.content.Context context, byte[] bArr, int i_renamed, int i2, java.lang.String str, float f_renamed, boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("renderNV21::width=%d_renamed::height=%d_renamed::filterId=%s_renamed::filterIntensity=%f_renamed::isUseVignette=%b_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), str, java.lang.Float.valueOf(f_renamed), java.lang.Boolean.valueOf(z_renamed));
        boolean zA = co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(str, "vignette_amount");
        boolean zA2 = co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(str, "overlay_amount");
        if (z_renamed || zA || zA2) {
            a_renamed(context, bArr, i_renamed, i2, str, false);
            throw null;
        }
        co_renamed.polarr.renderer.entities.Cube cubeB = co_renamed.polarr.renderer.FilterPackageUtil.b_renamed(context.getAssets(), str);
        a_renamed.a_renamed.a_renamed.a_renamed.a_renamed(i_renamed, i2, i_renamed, i2, false, -1, cubeB.data, bArr, false, cubeB.size);
        throw null;
    }

    public static byte[] a_renamed(android.content.Context context, byte[] bArr, int i_renamed, int i2, java.lang.String str, boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("renderNV12::getGlobalScreenOrientation=%d_renamed", java.lang.Integer.valueOf(a_renamed()));
        co_renamed.polarr.renderer.entities.Cube cubeB = co_renamed.polarr.renderer.FilterPackageUtil.b_renamed(context.getAssets(), str);
        boolean zA = co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(str, "vignette_amount");
        boolean zA2 = co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(str, "overlay_amount");
        if (zA) {
            co_renamed.polarr.renderer.entities.FilterItem filterItemA = a_renamed.a_renamed.b_renamed.e_renamed.a_renamed().a_renamed(str);
            a_renamed.a_renamed.a_renamed.a_renamed.a_renamed(i_renamed, i2, i_renamed, i2, false, -1, cubeB.data, bArr, z_renamed, cubeB.size, ((java.lang.Float) filterItemA.state.get("vignette_amount")).floatValue(), ((java.lang.Float) filterItemA.state.get("vignette_feather")).floatValue(), ((java.lang.Float) filterItemA.state.get("vignette_highlights")).floatValue(), ((java.lang.Float) filterItemA.state.get("vignette_exposure")).floatValue(), ((java.lang.Float) filterItemA.state.get("vignette_roundness")).floatValue(), ((java.lang.Float) filterItemA.state.get("vignette_size")).floatValue(), true, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.x_renamed, a_renamed(), 0.08f, 0.6f, 0.88f, 0.2f);
            throw null;
        }
        if (zA2) {
            a_renamed.a_renamed.a_renamed.a_renamed.a_renamed(i_renamed, i2, i_renamed, i2, false, -2, cubeB.data, bArr, z_renamed, cubeB.size, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.y_renamed, a_renamed());
            throw null;
        }
        a_renamed.a_renamed.a_renamed.a_renamed.a_renamed(i_renamed, i2, i_renamed, i2, false, 0, cubeB.data, bArr, z_renamed, cubeB.size, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.r_renamed, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.s_renamed, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.t_renamed, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.u_renamed, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.v_renamed, a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.w_renamed, false, new byte[0], a_renamed());
        throw null;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> b_renamed(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Object> mapA = a_renamed.a_renamed.b_renamed.f_renamed.j_renamed.a_renamed(str);
        for (java.lang.String str2 : mapA.keySet()) {
            mapA.put(str2, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(str2, mapA.get(str2)));
        }
        return mapA;
    }

    public static byte[] b_renamed(android.content.Context context, byte[] bArr, int i_renamed, int i2, java.lang.String str, float f_renamed, boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("renderNV12::width=%d_renamed::height=%d_renamed::filterId=%s_renamed::filterIntensity=%f_renamed::isUseVignette=%b_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), str, java.lang.Float.valueOf(f_renamed), java.lang.Boolean.valueOf(z_renamed));
        boolean zA = co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(str, "vignette_amount");
        boolean zA2 = co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(str, "overlay_amount");
        if (z_renamed || zA || zA2) {
            a_renamed(context, bArr, i_renamed, i2, str, true);
            throw null;
        }
        co_renamed.polarr.renderer.entities.Cube cubeB = co_renamed.polarr.renderer.FilterPackageUtil.b_renamed(context.getAssets(), str);
        a_renamed.a_renamed.a_renamed.a_renamed.a_renamed(i_renamed, i2, i_renamed, i2, false, -1, cubeB.data, bArr, true, cubeB.size);
        throw null;
    }
}
