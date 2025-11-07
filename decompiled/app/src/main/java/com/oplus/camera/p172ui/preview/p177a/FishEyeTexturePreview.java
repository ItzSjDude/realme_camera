package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.util.OpenGLUtils;

/* compiled from: FishEyeTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class FishEyeTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21391a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Bitmap f21392b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f21393c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21394d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21395k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f21396l;

    /* renamed from: OplusGLSurfaceView_6 */
    private TexturePreviewRequest f21397m;

    /* renamed from: OplusGLSurfaceView_11 */
    private RawTexture f21398n;

    /* renamed from: o */
    private RawTexture f21399o;

    /* renamed from: p */
    private RawTexture f21400p;

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 2048;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    /* compiled from: FishEyeTexturePreview.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_11$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends Drawable {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f21401a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Paint f21402b = new Paint(1);

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f21403c;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
            this.f21402b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.f21401a = OplusGLSurfaceView_13;
            this.f21403c = COUIBaseListPopupWindow_12;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int iSave = canvas.save();
            canvas.drawColor(this.f21401a);
            canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.f21403c, this.f21402b);
            canvas.restoreToCount(iSave);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int OplusGLSurfaceView_13) {
            this.f21402b.setAlpha(OplusGLSurfaceView_13);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f21402b.setColorFilter(colorFilter);
        }
    }

    public FishEyeTexturePreview(Context context) {
        super(context);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa;
        if (mo22673a_(OplusGLSurfaceView_13) && (c3397aa = this.f21397m) != null) {
            return c3397aa.m22371c();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        this.f21397m = c3397aa;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21399o;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21400p;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("FishEyeTexturePreview", "newTextures");
        this.f21392b = Bitmap.createBitmap(this.f21395k, this.f21394d, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f21392b);
        this.f21393c = new PlatformImplementations.kt_3(this.f21546j.getColor(R.color.fish_eye_cover), (this.f21394d / 2) - 6);
        this.f21393c.setBounds(0, 0, this.f21395k, this.f21394d);
        this.f21393c.draw(canvas);
        this.f21398n = new RawTexture(this.f21395k, this.f21394d, false);
        this.f21399o = new RawTexture(this.f21395k, this.f21394d, true);
        this.f21400p = new RawTexture(this.f21395k, this.f21394d, true);
        this.f21396l = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        Bitmap bitmap;
        RawTexture c2768s = this.f21398n;
        if (c2768s != null && !c2768s.m13943n() && (bitmap = this.f21392b) != null) {
            this.f21398n.m14189a(interfaceC2757h, OpenGLUtils.m24588a(bitmap));
            CameraLog.m12954a("FishEyeTexturePreview", "prepareTextures, mFishEyeCoverTexture.getId: " + this.f21398n.m13934e());
        }
        RawTexture c2768s2 = this.f21399o;
        if (c2768s2 != null && !c2768s2.m13943n()) {
            this.f21399o.m14193c(interfaceC2757h);
            CameraLog.m12954a("FishEyeTexturePreview", "prepareTextures, mInputTexture.getId: " + this.f21399o.m13934e());
        }
        RawTexture c2768s3 = this.f21400p;
        if (c2768s3 == null || c2768s3.m13943n()) {
            return;
        }
        this.f21400p.m14193c(interfaceC2757h);
        CameraLog.m12954a("FishEyeTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.f21400p.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        long jM11591a = AlgoListProcessor.m11591a();
        if (aVar == null) {
            return false;
        }
        aVar.f21547a.mo13975a(this.f21400p);
        aVar.f21547a.mo13973a(this.f21398n, aVar.f21555i, 0, 0, this.f21395k, this.f21394d);
        aVar.f21547a.mo13987h();
        f21391a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("FishEyeTexturePreview", "recycleTextures");
        if (this.f21396l) {
            RawTexture c2768s = this.f21398n;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21398n = null;
            }
            Bitmap bitmap = this.f21392b;
            if (bitmap != null) {
                bitmap.recycle();
                this.f21392b = null;
            }
            RawTexture c2768s2 = this.f21399o;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21399o = null;
            }
            RawTexture c2768s3 = this.f21400p;
            if (c2768s3 != null) {
                c2768s3.mo13944o();
                this.f21400p = null;
            }
            this.f21396l = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22532a(RawTexture c2768s) {
        CameraLog.m12966e("FishEyeTexturePreview", "setOutputTexture");
        this.f21400p = c2768s;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("FishEyeTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21395k = i2;
        this.f21394d = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: a_ */
    public boolean mo22673a_(int OplusGLSurfaceView_13) {
        return (mo22289d() & OplusGLSurfaceView_13) != 0;
    }
}
