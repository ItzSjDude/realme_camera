package com.oplus.camera.p146gl;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import com.oplus.camera.util.Util;
import java.util.HashMap;

/* compiled from: UploadedTexture.java */
/* renamed from: com.oplus.camera.gl.x */
/* loaded from: classes2.dex */
public abstract class UploadedTexture extends BasicTexture {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static HashMap<PlatformImplementations.kt_3, Bitmap> f14309h = new HashMap<>();

    /* renamed from: OplusGLSurfaceView_15 */
    private static PlatformImplementations.kt_3 f14310j = new PlatformImplementations.kt_3();

    /* renamed from: OplusGLSurfaceView_5 */
    private static int f14311k;

    /* renamed from: OplusGLSurfaceView_13 */
    protected Bitmap f14312i;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f14313l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f14314m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f14315n;

    /* renamed from: o */
    private boolean f14316o;

    /* renamed from: p */
    private int f14317p;

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo13947a(Bitmap bitmap);

    /* renamed from: d_ */
    protected abstract Bitmap mo13948d_();

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: OplusGLSurfaceView_6 */
    public int mo13942m() {
        return 3553;
    }

    protected UploadedTexture(boolean z) {
        super(null, 0, 0);
        this.f14313l = true;
        this.f14314m = false;
        this.f14315n = true;
        this.f14316o = false;
        if (z) {
            m13929a(true);
            this.f14317p = 1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m14278a(boolean z, Bitmap.Config config, int OplusGLSurfaceView_13) {
        Bitmap bitmapM24215a;
        PlatformImplementations.kt_3 aVar = f14310j;
        aVar.f14318a = z;
        aVar.f14319b = config;
        aVar.f14320c = OplusGLSurfaceView_13;
        Bitmap bitmap = f14309h.get(aVar);
        if (bitmap != null) {
            return bitmap;
        }
        if (z) {
            bitmapM24215a = Util.m24215a(1, OplusGLSurfaceView_13, config);
        } else {
            bitmapM24215a = Util.m24215a(OplusGLSurfaceView_13, 1, config);
        }
        Bitmap bitmap2 = bitmapM24215a;
        f14309h.put(aVar.clone(), bitmap2);
        return bitmap2;
    }

    /* renamed from: s */
    public static void m14280s() {
        f14311k = 0;
    }

    /* renamed from: t */
    public static boolean m14281t() {
        return f14311k > 100;
    }

    /* renamed from: v */
    private Bitmap m14282v() {
        if (this.f14312i == null) {
            this.f14312i = mo13948d_();
            int width = this.f14312i.getWidth() + (this.f14317p * 2);
            int height = this.f14312i.getHeight() + (this.f14317p * 2);
            if (this.f13967a == -1) {
                m13925a(width, height);
            }
        }
        return this.f14312i;
    }

    /* renamed from: w */
    private void m14283w() {
        mo13947a(this.f14312i);
        this.f14312i = null;
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: COUIBaseListPopupWindow_12 */
    public int mo13935f() {
        if (this.f13967a == -1) {
            m14282v();
        }
        return this.f13967a;
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: COUIBaseListPopupWindow_11 */
    public int mo13936g() {
        if (this.f13967a == -1) {
            m14282v();
        }
        return this.f13968b;
    }

    /* renamed from: u */
    public boolean m14285u() {
        return m13943n() && this.f14313l;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14284c(GLCanvas interfaceC2757h) {
        if (!m13943n()) {
            if (this.f14316o) {
                int OplusGLSurfaceView_13 = f14311k + 1;
                f14311k = OplusGLSurfaceView_13;
                if (OplusGLSurfaceView_13 > 100) {
                    return;
                }
            }
            m14279d(interfaceC2757h);
            return;
        }
        if (this.f14313l) {
            return;
        }
        Bitmap bitmapM14282v = m14282v();
        int internalFormat = GLUtils.getInternalFormat(bitmapM14282v);
        int type = GLUtils.getType(bitmapM14282v);
        int i2 = this.f14317p;
        interfaceC2757h.mo13969a(this, i2, i2, bitmapM14282v, internalFormat, type);
        m14283w();
        this.f14313l = true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m14279d(GLCanvas interfaceC2757h) {
        boolean z;
        Bitmap bitmapM14282v = m14282v();
        try {
            if (bitmapM14282v != null) {
                try {
                    int width = bitmapM14282v.getWidth();
                    int height = bitmapM14282v.getHeight();
                    int OplusGLSurfaceView_13 = this.f14317p;
                    int i2 = this.f14317p;
                    int iH = m13937h();
                    int i3 = m13938i();
                    this.f13969c = interfaceC2757h.mo13957a().mo14020b();
                    interfaceC2757h.mo13980b(this);
                    if (width == iH && height == i3) {
                        interfaceC2757h.mo13970a(this, bitmapM14282v);
                    } else {
                        int internalFormat = GLUtils.getInternalFormat(bitmapM14282v);
                        int type = GLUtils.getType(bitmapM14282v);
                        Bitmap.Config config = bitmapM14282v.getConfig();
                        interfaceC2757h.mo13967a(this, internalFormat, type);
                        interfaceC2757h.mo13969a(this, this.f14317p, this.f14317p, bitmapM14282v, internalFormat, type);
                        if (this.f14317p > 0) {
                            z = false;
                            interfaceC2757h.mo13969a(this, 0, 0, m14278a(true, config, i3), internalFormat, type);
                            interfaceC2757h.mo13969a(this, 0, 0, m14278a(false, config, iH), internalFormat, type);
                        } else {
                            z = false;
                        }
                        if (this.f14317p + width < iH) {
                            interfaceC2757h.mo13969a(this, this.f14317p + width, 0, m14278a(true, config, i3), internalFormat, type);
                        }
                        if (this.f14317p + height < i3) {
                            interfaceC2757h.mo13969a(this, 0, this.f14317p + height, m14278a(z, config, iH), internalFormat, type);
                        }
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                m14283w();
                m13927a(interfaceC2757h);
                this.f13970d = 1;
                this.f14313l = true;
                return;
            }
            this.f13970d = -1;
            throw new RuntimeException("Texture load fail, no bitmap");
        } catch (Throwable th) {
            m14283w();
            throw th;
        }
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean mo13931b(GLCanvas interfaceC2757h) {
        m14284c(interfaceC2757h);
        return m14285u();
    }

    @Override // com.oplus.camera.p146gl.Texture
    /* renamed from: r */
    public boolean mo13954r() {
        return this.f14315n;
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: o */
    public void mo13944o() {
        super.mo13944o();
        if (this.f14312i != null) {
            m14283w();
        }
    }

    /* compiled from: UploadedTexture.java */
    /* renamed from: com.oplus.camera.gl.x$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 implements Cloneable {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f14318a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public Bitmap.Config f14319b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f14320c;

        private PlatformImplementations.kt_3() {
        }

        public int hashCode() {
            int iHashCode = this.f14319b.hashCode() ^ this.f14320c;
            return this.f14318a ? iHashCode : -iHashCode;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlatformImplementations.kt_3)) {
                return false;
            }
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) obj;
            return this.f14318a == aVar.f14318a && this.f14319b == aVar.f14319b && this.f14320c == aVar.f14320c;
        }

        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 clone() {
            try {
                return (PlatformImplementations.kt_3) super.clone();
            } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
                throw new AssertionError(COUIBaseListPopupWindow_8);
            }
        }
    }
}
