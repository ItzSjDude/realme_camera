package p000a.p001a.p003b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.TimingLogger;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.Orientation;
import co.polarr.renderer.PacmanFilter;
import co.polarr.renderer.entities.Adjustment;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.DrawingItem;
import co.polarr.renderer.entities.FaceItem;
import co.polarr.renderer.entities.LutItem;
import co.polarr.renderer.entities.MagicEraserPath;
import co.polarr.renderer.entities.SpotItem;
import co.polarr.renderer.entities.TextItem;
import co.polarr.renderer.filters.Basic;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import p000a.p001a.p003b.p005b.C0013ab;
import p000a.p001a.p003b.p005b.C0014ac;
import p000a.p001a.p003b.p005b.C0016ae;
import p000a.p001a.p003b.p005b.C0017af;
import p000a.p001a.p003b.p005b.C0021aj;
import p000a.p001a.p003b.p005b.C0022ak;
import p000a.p001a.p003b.p005b.C0024am;
import p000a.p001a.p003b.p005b.C0025an;
import p000a.p001a.p003b.p005b.C0026ao;
import p000a.p001a.p003b.p005b.C0027ap;
import p000a.p001a.p003b.p005b.C0030as;
import p000a.p001a.p003b.p005b.C0031at;
import p000a.p001a.p003b.p005b.C0032au;
import p000a.p001a.p003b.p005b.C0034aw;
import p000a.p001a.p003b.p005b.C0036ay;
import p000a.p001a.p003b.p005b.C0037az;
import p000a.p001a.p003b.p005b.C0039ba;
import p000a.p001a.p003b.p005b.C0040bb;
import p000a.p001a.p003b.p005b.C0042bd;
import p000a.p001a.p003b.p005b.C0043be;
import p000a.p001a.p003b.p005b.C0045bg;
import p000a.p001a.p003b.p005b.C0048bj;
import p000a.p001a.p003b.p005b.C0049bk;
import p000a.p001a.p003b.p005b.C0050bl;
import p000a.p001a.p003b.p005b.C0052bn;
import p000a.p001a.p003b.p005b.C0053bo;
import p000a.p001a.p003b.p005b.C0055bq;
import p000a.p001a.p003b.p005b.C0060bv;
import p000a.p001a.p003b.p005b.C0061bw;
import p000a.p001a.p003b.p005b.C0067d;
import p000a.p001a.p003b.p005b.C0068e;
import p000a.p001a.p003b.p005b.C0070g;
import p000a.p001a.p003b.p005b.C0071h;
import p000a.p001a.p003b.p005b.C0072i;
import p000a.p001a.p003b.p005b.C0076m;
import p000a.p001a.p003b.p005b.C0080q;
import p000a.p001a.p003b.p005b.C0082s;
import p000a.p001a.p003b.p005b.C0085v;
import p000a.p001a.p003b.p005b.C0088y;
import p000a.p001a.p003b.p005b.C0089z;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p005b.p006a.C0010c;
import p000a.p001a.p003b.p005b.p006a.C0011d;
import p000a.p001a.p003b.p007c.C0091a;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0096f;
import p000a.p001a.p003b.p007c.C0097g;
import p000a.p001a.p003b.p010f.C0110c;
import p000a.p001a.p003b.p010f.C0113f;
import p000a.p001a.p003b.p010f.C0114g;
import p000a.p001a.p003b.p010f.C0117j;
import p000a.p001a.p003b.p010f.C0119l;
import p000a.p001a.p003b.p010f.C0120m;
import p000a.p001a.p003b.p010f.C0121n;
import p000a.p001a.p003b.p010f.C0123p;
import p000a.p001a.p003b.p010f.C0125r;
import p000a.p001a.p003b.p010f.C0126s;
import p000a.p001a.p003b.p010f.C0127t;
import p000a.p001a.p003b.p010f.C0130w;
import p000a.p001a.p003b.p010f.C0132y;
import p000a.p001a.p003b.p010f.C0133z;
import p000a.p001a.p003b.p010f.InterfaceC0108aa;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class C0098d implements InterfaceC0108aa, PacmanFilter {

    /* renamed from: A */
    public C0017af f438A;

    /* renamed from: B */
    public C0021aj f439B;

    /* renamed from: I */
    public C0094d f446I;

    /* renamed from: J */
    public C0094d f447J;

    /* renamed from: K */
    public C0094d f448K;

    /* renamed from: L */
    public C0133z f449L;

    /* renamed from: N */
    public boolean f451N;

    /* renamed from: O */
    public int[] f452O;

    /* renamed from: P */
    public byte[] f453P;

    /* renamed from: Q */
    public Bitmap f454Q;

    /* renamed from: PlatformImplementations.kt_3 */
    public C0053bo f456a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public C0025an f457b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Basic f458c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public C0090c f460e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public C0006b f461f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean f463h;

    /* renamed from: OplusGLSurfaceView_15 */
    public Handler f465j;

    /* renamed from: OplusGLSurfaceView_5 */
    public ByteBuffer f466k;

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean f467l;

    /* renamed from: OplusGLSurfaceView_6 */
    public C0055bq f468m;

    /* renamed from: p */
    public float f471p;

    /* renamed from: q */
    public float f472q;

    /* renamed from: r */
    public float f473r;

    /* renamed from: s */
    public C0011d f474s;

    /* renamed from: t */
    public Context f475t;

    /* renamed from: u */
    public int f476u;

    /* renamed from: v */
    public int f477v;

    /* renamed from: w */
    public List<C0009b> f478w;

    /* renamed from: x */
    public C0130w f479x;

    /* renamed from: y */
    public Resources f480y;

    /* renamed from: z */
    public C0010c f481z;

    /* renamed from: C */
    public int f440C = 0;

    /* renamed from: D */
    public int f441D = 0;

    /* renamed from: E */
    public boolean f442E = true;

    /* renamed from: F */
    public boolean f443F = false;

    /* renamed from: G */
    public boolean f444G = false;

    /* renamed from: H */
    public boolean f445H = true;

    /* renamed from: M */
    public int f450M = 0;

    /* renamed from: R */
    public boolean f455R = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f459d = true;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f462g = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    public Map<String, Object> f464i = new HashMap();

    /* renamed from: OplusGLSurfaceView_11 */
    public C0126s f469n = new C0126s(10);

    /* renamed from: o */
    public C0126s f470o = new C0126s(20);

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        public final /* synthetic */ byte[] f487a;

        public PlatformImplementations.kt_3(byte[] bArr) {
            this.f487a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0098d.this.f467l = true;
            Map<String, Float> mapM540a = C0121n.m540a(300, 300, this.f487a, C0098d.this.f475t.renderStates, false);
            HashMap map = new HashMap();
            map.putAll(mapM540a);
            if (!C0098d.this.f442E) {
                map.remove("highlights");
                map.remove("shadows");
                map.remove("clarity");
                map.remove("dehaze");
            }
            Map<String, Object> mapGetRefStates = FilterPackageUtil.GetRefStates(map, 0.5f);
            synchronized (C0098d.this.f464i) {
                C0098d.this.f464i.clear();
                C0098d.this.f464i.putAll(mapGetRefStates);
            }
            C0098d.this.f467l = false;
        }
    }

    public C0098d() {
        this.f470o.m600a(false);
        this.f471p = 0.0f;
        this.f472q = 0.0f;
        this.f473r = 1.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<PointF> m343a(List<PointF> list, float COUIBaseListPopupWindow_12, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        float f4 = (f3 - 1.0f) / 2.0f;
        for (PointF pointF : list) {
            PointF pointF2 = new PointF();
            pointF2.x = ((pointF.x + f4) - (COUIBaseListPopupWindow_12 / 2.0f)) / f3;
            pointF2.y = ((pointF.y + f4) - (f2 / 2.0f)) / f3;
            arrayList.add(pointF2);
        }
        return arrayList;
    }

    /* renamed from: A */
    public final void m347A() {
        Map<String, C0094d> map;
        Context context = this.f475t;
        if (context != null && (map = context.patterns) != null) {
            Iterator<C0094d> it = map.values().iterator();
            while (it.hasNext()) {
                C0001a.m9a(it.next());
            }
        }
        Context context2 = this.f475t;
        if (context2 != null) {
            context2.patterns = null;
        }
    }

    /* renamed from: B */
    public final byte[] m348B() {
        C0113f.m490b(this.f475t.intermediateTexture, 300, 300);
        if (this.f466k == null) {
            this.f466k = ByteBuffer.allocate(360000);
        }
        C0010c c0010cM59a = C0010c.m59a((Context) null);
        c0010cM59a.m64b(this.f475t.intermediateTexture.f387a);
        c0010cM59a.m48c(300, 300);
        c0010cM59a.m70s();
        Basic basic = Basic.getInstance(this.f480y);
        basic.setInputTextureId(this.f475t.imageTexture.f387a);
        basic.draw();
        GLES20.glReadPixels(0, 0, 300, 300, 6408, 5121, this.f466k);
        c0010cM59a.m65n();
        byte[] bArrArray = this.f466k.array();
        this.f466k.rewind();
        return bArrArray;
    }

    @Override // p000a.p001a.p003b.p010f.InterfaceC0108aa
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo349a() {
        C0010c c0010c = this.f481z;
        if (c0010c == null) {
            return 0;
        }
        return c0010c.m68q();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m350a(List<PointF> list) {
        this.f479x.m640a(m343a(list, this.f471p, this.f472q, this.f473r), this.f471p, this.f472q, this.f473r);
        return this.f475t.writableTexture.f387a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0094d m351a(Context context, C0026ao c0026ao, C0094d c0094d, C0094d c0094d2, float COUIBaseListPopupWindow_12, Float f2) {
        if (c0094d2 == null) {
            c0094d2 = c0094d;
        }
        if (f2 == null) {
            f2 = Float.valueOf(COUIBaseListPopupWindow_12);
        }
        float f3 = 1.0f / c0094d2.f388b;
        float fFloatValue = f2.floatValue();
        float fFloatValue2 = f2.floatValue();
        c0026ao.f120r = new float[]{f3 * COUIBaseListPopupWindow_12, 0.0f, f3 * fFloatValue, 0.0f};
        c0026ao.f121s = Context.overlayMesh;
        mo366a(c0026ao, c0094d.f387a, context.readableTexture);
        c0026ao.f120r = new float[]{0.0f, (1.0f / c0094d2.f389c) * COUIBaseListPopupWindow_12, 0.0f, (1.0f / c0094d2.f389c) * fFloatValue2};
        c0026ao.f121s = Context.overlayMesh;
        mo366a(c0026ao, context.readableTexture.f387a, c0094d2);
        return c0094d2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0094d m352a(Context context, C0031at c0031at, C0061bw c0061bw, C0094d c0094d, C0094d c0094d2) {
        if (c0094d2 == null) {
            c0094d2 = c0094d;
        }
        c0031at.f154r = new float[]{(1.0f / c0094d2.f388b) * 8.0f, 0.0f};
        c0031at.f155s = Context.overlayMesh;
        mo366a(c0031at, c0094d.f387a, context.readableTexture);
        c0061bw.f291r = new float[]{0.0f, (1.0f / c0094d2.f389c) * 8.0f};
        c0061bw.f292s = Context.overlayMesh;
        mo366a(c0061bw, context.readableTexture.f387a, c0094d2);
        return c0094d2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m353a(Bitmap bitmap, String str) {
        return m354a(bitmap, str, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m354a(Bitmap bitmap, String str, float COUIBaseListPopupWindow_12) {
        return m355a(bitmap, str, COUIBaseListPopupWindow_12, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m355a(Bitmap bitmap, String str, float COUIBaseListPopupWindow_12, float f2) {
        C0001a.m11a("start render bitmap");
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        C0114g.m492a("fastRenderBitmap::filterId=%s::fastRenderBitmap=%COUIBaseListPopupWindow_12", str, Float.valueOf(COUIBaseListPopupWindow_12));
        GLES20.glBindTexture(3553, this.f440C);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        boolean z = this.f445H;
        this.f445H = false;
        m389b();
        this.f445H = z;
        m400c(f2);
        m395b(str, COUIBaseListPopupWindow_12);
        m417j();
        GLES20.glFinish();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(C0113f.m474a(this.f475t.readableTexture.f387a, bitmap.getWidth(), bitmap.getHeight()));
        C0001a.m11a("end render bitmap");
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m356a(Bitmap bitmap, Map<String, Object> map) {
        C0001a.m11a("start render bitmap");
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        C0114g.m492a("renderBitmap::renderStates=%s", map == null ? "null" : map.toString());
        GLES20.glBindTexture(3553, this.f440C);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        boolean z = this.f445H;
        this.f445H = false;
        m389b();
        this.f445H = z;
        m397b(map);
        m368a((android.content.Context) null, false);
        GLES20.glFinish();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(C0113f.m474a(this.f475t.readableTexture.f387a, bitmap.getWidth(), bitmap.getHeight()));
        C0001a.m11a("end render bitmap");
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Map<String, Object> m357a(float COUIBaseListPopupWindow_12) {
        C0114g.m492a("autoEnhanceGlobalForFace::percent=%COUIBaseListPopupWindow_12", Float.valueOf(COUIBaseListPopupWindow_12));
        C0001a.m11a("start auto enhance global face");
        Map<String, Object> mapGetRefStates = FilterPackageUtil.GetRefStates((Map) C0119l.m520b(C0121n.f553a), COUIBaseListPopupWindow_12);
        C0001a.m11a("end auto enhance global face");
        return mapGetRefStates;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Map<String, Object> m358a(float COUIBaseListPopupWindow_12, Map<String, Object> map) {
        int OplusGLSurfaceView_13;
        C0114g.m492a("autoEnhanceGlobal::percent=%COUIBaseListPopupWindow_12", Float.valueOf(COUIBaseListPopupWindow_12));
        C0001a.m11a("start auto enhance global");
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        C0094d c0094d = this.f475t.imageTexture;
        float f2 = c0094d.f388b;
        float f3 = c0094d.f389c;
        HashMap map2 = new HashMap();
        if (this.f453P == null || this.f454Q == null) {
            int i2 = (int) f2;
            int i3 = (int) f3;
            this.f453P = C0091a.m269b(this.f480y, this.f475t.imageTexture, i2, i3);
            this.f454Q = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f454Q.copyPixelsFromBuffer(ByteBuffer.wrap(this.f453P));
        }
        int i4 = 80;
        if (f2 > f3) {
            OplusGLSurfaceView_13 = (int) (80 * (f2 / f3));
        } else {
            i4 = (int) (80 * (f3 / f2));
            OplusGLSurfaceView_13 = 80;
        }
        Bitmap bitmapM573a = C0123p.m573a(this.f454Q, OplusGLSurfaceView_13, i4);
        byte[] bArrM578a = C0123p.m578a(bitmapM573a);
        List<FaceItem> list = null;
        if (map != null && map.get("faces") != null) {
            list = (List) map.get("faces");
        }
        Map<String, Float> mapM540a = C0121n.m540a(bitmapM573a.getWidth(), bitmapM573a.getHeight(), bArrM578a, this.f475t.renderStates, (list == null || list.isEmpty()) ? false : true);
        if (list != null) {
            HashMap map3 = new HashMap();
            for (FaceItem faceItem : list) {
                int height = this.f454Q.getHeight();
                int width = this.f454Q.getWidth();
                float[] fArr = faceItem.boundaries;
                float f4 = width;
                int i5 = (int) (fArr[0] * f4);
                float f5 = height;
                int i6 = (int) (fArr[1] * f5);
                int i7 = (int) (fArr[2] * f4);
                int i8 = (int) (fArr[3] * f5);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f454Q, i5, i6, i7, i8);
                if (i7 > 50 || i8 > 50) {
                    bitmapCreateBitmap = C0123p.m573a(bitmapCreateBitmap, 50.0f, 50.0f);
                }
                Map<String, Float> mapM539a = C0121n.m539a(bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), C0123p.m578a(bitmapCreateBitmap), this.f475t.renderStates);
                for (String str : mapM539a.keySet()) {
                    map3.put(str, !map3.containsKey(str) ? mapM539a.get(str) : Float.valueOf(Math.min(((Float) map3.get(str)).floatValue(), mapM539a.get(str).floatValue())));
                }
            }
            for (Map.Entry entry : map3.entrySet()) {
                C0121n.m548a(mapM540a, (String) entry.getKey(), ((Float) entry.getValue()).floatValue());
            }
        }
        map2.putAll(mapM540a);
        if (!this.f442E) {
            map2.remove("highlights");
            map2.remove("shadows");
            map2.remove("clarity");
            map2.remove("dehaze");
        }
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        Map<String, Object> mapGetRefStates = FilterPackageUtil.GetRefStates(map2, COUIBaseListPopupWindow_12);
        C0001a.m11a("end auto enhance global");
        return mapGetRefStates;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m359a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        this.f471p = COUIBaseListPopupWindow_12;
        this.f472q = f2;
        this.f473r = f3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m360a(int OplusGLSurfaceView_13) {
        this.f479x.m628a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m361a(int OplusGLSurfaceView_13, int i2) {
        this.f479x.m629a(OplusGLSurfaceView_13, i2, this.f471p, this.f472q, this.f473r);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m362a(int OplusGLSurfaceView_13, int i2, int i3) {
        C0114g.m492a("clearTexture::textureId=%IntrinsicsJvm.kt_5::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3));
        GLES20.glDisable(3089);
        this.f481z.m64b(OplusGLSurfaceView_13);
        this.f481z.m42a(C0125r.m596a());
        this.f481z.m48c(i2, i3);
        this.f481z.m70s();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f481z.m65n();
    }

    @Override // p000a.p001a.p003b.p010f.InterfaceC0108aa
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo363a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (this.f458c == null) {
            this.f458c = new Basic(this.f480y, this.f475t);
            this.f458c.m30a();
        }
        this.f458c.setNeedClear(true);
        Matrix.setIdentityM(this.f458c.getMatrix(), 0);
        m365a(this.f458c, OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // p000a.p001a.p003b.p010f.InterfaceC0108aa
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo364a(int OplusGLSurfaceView_13, int i2, float[] fArr, int i3, int i4) {
        if (this.f458c == null) {
            this.f458c = new Basic(this.f480y, this.f475t);
            this.f458c.m30a();
        }
        this.f458c.setNeedClear(true);
        this.f458c.m42a(fArr);
        m365a(this.f458c, OplusGLSurfaceView_13, i2, i3, i4);
        Matrix.setIdentityM(this.f458c.getMatrix(), 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m365a(AbstractC0008a abstractC0008a, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f481z.m64b(i2);
        this.f481z.m42a(C0125r.m596a());
        this.f481z.m48c(i3, i4);
        this.f481z.m63a(abstractC0008a);
        if (OplusGLSurfaceView_13 != 0) {
            this.f481z.m31a(OplusGLSurfaceView_13);
        }
        this.f481z.draw();
        C0001a.m11a("render tex out id_renamed");
    }

    @Override // p000a.p001a.p003b.p010f.InterfaceC0108aa
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo366a(AbstractC0008a abstractC0008a, int OplusGLSurfaceView_13, C0094d c0094d) {
        if (abstractC0008a == null) {
            return;
        }
        C0114g.m492a("renderTexture::inputTextureID=%IntrinsicsJvm.kt_5::outputTexture=%s", Integer.valueOf(OplusGLSurfaceView_13), c0094d.toString());
        this.f481z.m64b(c0094d.f387a);
        this.f481z.m42a(C0125r.m596a());
        this.f481z.m48c(c0094d.f388b, c0094d.f389c);
        this.f481z.m63a(abstractC0008a);
        if (OplusGLSurfaceView_13 != 0) {
            this.f481z.m31a(OplusGLSurfaceView_13);
        }
        this.f481z.draw();
        C0001a.m11a("render tex");
    }

    @Override // p000a.p001a.p003b.p010f.InterfaceC0108aa
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo367a(AbstractC0008a abstractC0008a, int OplusGLSurfaceView_13, C0094d c0094d, int i2, int i3, int i4, int i5) {
        if (abstractC0008a == null) {
            return;
        }
        C0114g.m492a("renderTexture::inputTextureID=%IntrinsicsJvm.kt_5::outputTexture=%s", Integer.valueOf(OplusGLSurfaceView_13), c0094d.toString());
        this.f481z.m64b(c0094d.f387a);
        this.f481z.m42a(C0125r.m596a());
        this.f481z.m48c(c0094d.f388b, c0094d.f389c);
        this.f481z.m63a(abstractC0008a);
        if (OplusGLSurfaceView_13 != 0) {
            this.f481z.m31a(OplusGLSurfaceView_13);
        }
        this.f481z.m62a(i2, i3, i4, i5);
        this.f481z.draw();
        this.f481z.m69r();
        C0001a.m11a("render tex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m368a(android.content.Context context, boolean z) {
        int OplusGLSurfaceView_13;
        C0114g.m492a("render::fastDraw=%IntrinsicsJvm.kt_4", Boolean.valueOf(z));
        if (this.f474s == null) {
            Log.COUIBaseListPopupWindow_8("PPE_RENDER", "getBitmap: Renderer was not set.");
        }
        if (!z) {
            m370a(this.f480y);
        }
        C0001a.m11a("render blur");
        m369a(context, z, z);
        C0001a.m11a("do render");
        if (z || (OplusGLSurfaceView_13 = this.f441D) == 0) {
            return;
        }
        this.f481z.m64b(OplusGLSurfaceView_13);
        this.f481z.m48c(this.f476u, this.f477v);
        this.f481z.m70s();
        GLES20.glViewport(0, 0, this.f476u, this.f477v);
        Basic basicM5425a = Basic.m5425a(this.f480y, this.f475t);
        basicM5425a.m31a(this.f475t.readableTexture.f387a);
        Matrix.translateM(basicM5425a.getMatrix(), 0, this.f471p, this.f472q, 0.0f);
        float[] matrix = basicM5425a.getMatrix();
        float COUIBaseListPopupWindow_12 = this.f473r;
        Matrix.scaleM(matrix, 0, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, 1.0f);
        basicM5425a.draw();
        this.f481z.m65n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m369a(android.content.Context context, boolean z, boolean z2) {
        Context.WatermarkOptions watermarkOptions;
        Context context2;
        Resources resources;
        List list;
        C0021aj c0021aj;
        boolean z3 = false;
        C0114g.m492a("render::needSkip=%IntrinsicsJvm.kt_4::fastDraw=%IntrinsicsJvm.kt_4", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.f474s == null) {
            Log.COUIBaseListPopupWindow_8("PPE_RENDER", "getBitmap: Renderer was not set.");
        }
        if (!z2) {
            this.f479x.m637a(this.f475t, false);
            C0110c.m467a(this.f475t, this.f480y);
        }
        if (!z2) {
            Context context3 = this.f475t;
            int[] iArr = context3.textures;
            AbstractC0008a abstractC0008aM160a = (iArr == null || iArr.length <= 0) ? C0048bj.m160a(this.f480y, this.f475t) : C0030as.m130a(this.f480y, context3);
            abstractC0008aM160a.m42a(this.f475t.matrix);
            if (this.f481z == null) {
                this.f481z = C0010c.m59a(this.f475t);
            }
            this.f481z.m63a(abstractC0008aM160a);
            this.f481z.m64b(this.f475t.readableTexture.f387a);
            C0010c c0010c = this.f481z;
            C0094d c0094d = this.f475t.readableTexture;
            c0010c.m48c(c0094d.f388b, c0094d.f389c);
            this.f481z.m31a(this.f475t.imageTexture.f387a);
            this.f481z.draw();
        }
        System.currentTimeMillis();
        this.f474s.m31a(this.f475t.readableTexture.f387a);
        this.f474s.m91w();
        if (z2) {
            C0011d c0011d = this.f474s;
            Context context4 = this.f475t;
            c0011d.m78d(context4.readableTexture.f387a, context4.writableTexture.f387a);
            if (this.f440C != 0) {
                this.f474s.m88t();
                Basic basicM5425a = Basic.m5425a(this.f480y, this.f475t);
                basicM5425a.m31a(this.f440C);
                basicM5425a.draw();
            }
        }
        if (!z2 && (list = (List) this.f475t.renderStates.get("spots")) != null && !list.isEmpty()) {
            Context context5 = this.f475t;
            int[] iArr2 = context5.textures;
            if (iArr2 == null || iArr2.length <= 0) {
                C0021aj c0021aj2 = this.f439B;
                if (c0021aj2 == null) {
                    this.f439B = C0021aj.m105b(this.f480y, this.f475t);
                } else {
                    c0021aj2.m56a(this.f475t);
                }
                c0021aj = this.f439B;
            } else {
                C0017af c0017af = this.f438A;
                if (c0017af == null) {
                    this.f438A = C0017af.m101a(this.f480y, context5);
                } else {
                    c0017af.m56a(context5);
                }
                c0021aj = this.f438A;
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
                SpotItem spotItem = (SpotItem) list.get(OplusGLSurfaceView_13);
                c0021aj.f96s = spotItem.feather;
                c0021aj.f97t = spotItem.size;
                c0021aj.f98u = C0123p.m580a(spotItem.position);
                c0021aj.f99v = C0123p.m580a(spotItem.sourcePosition);
                c0021aj.f100w = spotItem.angle;
                c0021aj.f101x = spotItem.opacity;
                c0021aj.f102y = spotItem.mode;
                this.f474s.m77b(c0021aj);
            }
        }
        this.f474s.m83o();
        if (!z2) {
            Context context6 = this.f475t;
            if (context6.faceMasks != null) {
                List list2 = (List) context6.renderStates.get("faces");
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if (this.f475t.faceMasks.length > i2) {
                        FaceItem faceItem = (FaceItem) list2.get(i2);
                        Context context7 = this.f475t;
                        C0096f c0096f = context7.faceMasks[i2];
                        if (faceItem.adjustments != null) {
                            C0055bq c0055bqM210a = C0055bq.m210a(this.f480y, context7);
                            c0055bqM210a.f281r = c0096f;
                            c0055bqM210a.f282s = faceItem.adjustments;
                            this.f474s.m77b(c0055bqM210a);
                        }
                    }
                }
            }
        }
        if (!z2) {
            C0097g.m283a(this.f480y, this.f475t, this.f474s, this.f478w);
        }
        if (z) {
            this.f474s.m84p();
            if (z2) {
                int iM86r = this.f474s.m86r();
                context2 = this.f475t;
                if (iM86r != context2.writableTexture.f387a) {
                    return;
                } else {
                    resources = this.f480y;
                }
            } else {
                resources = this.f480y;
                context2 = this.f475t;
            }
            mo366a(Basic.m5425a(resources, context2), this.f474s.m86r(), this.f475t.readableTexture);
            return;
        }
        Object obj = this.f475t.renderStates.get("blur_opacity");
        if (((obj instanceof Integer) && ((Integer) obj).intValue() != 0) || ((obj instanceof Float) && ((Float) obj).floatValue() != 0.0f)) {
            z3 = true;
        }
        if (z3) {
            Context context8 = this.f475t;
            if (context8.lensBlurTexture.f388b != 1) {
                this.f474s.m77b(C0088y.m256a(this.f480y, context8));
            }
        }
        ArrayList arrayList = (ArrayList) this.f475t.renderStates.get(MimeTypes.BASE_TYPE_TEXT);
        this.f475t.renderStates.remove("zPrevText");
        C0097g.m290a(context, this.f480y, this.f475t, (ArrayList<TextItem>) arrayList);
        this.f474s.m84p();
        mo366a(Basic.m5425a(this.f480y, this.f475t), this.f474s.m86r(), this.f475t.readableTexture);
        C0097g.m313e(this.f480y, this.f475t);
        Context context9 = this.f475t;
        if (context9.watermarkTexture == null || (watermarkOptions = context9.watermarkOptions) == null) {
            return;
        }
        if (watermarkOptions.enabled || watermarkOptions.preview) {
            C0032au c0032auM134a = C0032au.m134a(this.f480y, this.f475t);
            c0032auM134a.m42a(this.f475t.matrix);
            this.f481z.m63a(c0032auM134a);
            this.f481z.m64b(this.f475t.writableTexture.f387a);
            C0010c c0010c2 = this.f481z;
            C0094d c0094d2 = this.f475t.readableTexture;
            c0010c2.m48c(c0094d2.f388b, c0094d2.f389c);
            this.f481z.m31a(this.f475t.readableTexture.f387a);
            this.f481z.draw();
            C0097g.m304b(this.f475t);
            C0097g.m315f(this.f480y, this.f475t);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m370a(Resources resources) {
        boolean z;
        Context context = this.f475t;
        List<Adjustment> list = (List) context.renderStates.get("local_adjustments");
        boolean z2 = false;
        if (list != null && !list.isEmpty()) {
            loop0: while (true) {
                for (Adjustment adjustment : list) {
                    z = z || adjustment.adjustments.blur != 0.0f;
                }
            }
            if (z) {
                C0094d c0094d = context.readableTexture;
                int OplusGLSurfaceView_13 = c0094d.f388b;
                int i2 = c0094d.f389c;
                int i3 = OplusGLSurfaceView_13 >> 1;
                int i4 = i2 >> 1;
                C0113f.m490b(c0094d, i3, i4);
                C0113f.m490b(context.writableTexture, i3, i4);
                C0113f.m490b(context.lensBlurTexture, i3, i4);
                float[] fArr = context.matrix;
                context.matrix = C0125r.m596a();
                m369a((android.content.Context) null, true, false);
                C0097g.m307c(resources, context);
                C0097g.m293a(resources, context, context.lensBlurTexture);
                C0113f.m490b(context.readableTexture, OplusGLSurfaceView_13, i2);
                C0113f.m490b(context.writableTexture, OplusGLSurfaceView_13, i2);
                context.matrix = fArr;
            }
            z2 = z;
        }
        if (z2) {
            return;
        }
        C0113f.m490b(context.lensBlurTexture, 1, 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m371a(Resources resources, int OplusGLSurfaceView_13, int i2, Map<String, Object> map) throws JSONException, IOException {
        this.f476u = OplusGLSurfaceView_13;
        this.f477v = i2;
        this.f480y = resources;
        TimingLogger timingLogger = new TimingLogger("Polarr", "nativeInit_width/height=" + OplusGLSurfaceView_13 + "/" + i2);
        this.f475t = new Context(this.f451N);
        this.f475t.shaderUtil = new C0120m();
        this.f475t.shaderUtil.m532b(resources);
        timingLogger.addSplit("shaderUtil.init");
        if (this.f450M == 1) {
            this.f475t.isOES = true;
        }
        this.f475t.resources = resources;
        if (!this.f451N) {
            m386a(map, false, false);
            C0097g.m294a(resources, this.f475t, new Point(OplusGLSurfaceView_13, i2));
            this.f474s = new C0011d(this.f475t, resources);
            for (AbstractC0008a abstractC0008a : C0120m.m525a(resources, this.f475t)) {
                this.f474s.m74a(abstractC0008a);
                if (abstractC0008a instanceof C0053bo) {
                    this.f456a = (C0053bo) abstractC0008a;
                }
            }
            this.f474s.m30a();
            this.f474s.m48c(this.f476u, this.f477v);
        }
        if (this.f451N) {
            int[] iArr = new int[7];
            C0113f.m480a(iArr.length, iArr, 0, 6408, OplusGLSurfaceView_13, i2);
            this.f475t.imageTexture = C0113f.m486b(iArr[0], 6408, OplusGLSurfaceView_13, i2);
            this.f475t.readableTexture = C0113f.m486b(iArr[1], 6408, OplusGLSurfaceView_13, i2);
            this.f475t.writableTexture = C0113f.m486b(iArr[2], 6408, OplusGLSurfaceView_13, i2);
            this.f475t.dehazeTexture = C0113f.m486b(iArr[2], 6408, OplusGLSurfaceView_13, i2);
            this.f475t.denoiseTexture = C0113f.m486b(iArr[3], 6408, OplusGLSurfaceView_13, i2);
            this.f475t.grainTexture = C0113f.m486b(iArr[4], 6408, 1024, 1024);
            this.f475t.overlayTexture = C0113f.m486b(iArr[5], 6408, 1000, 1000);
            timingLogger.addSplit("outScreenContext.denoiseTexture");
            this.f457b = new C0025an(resources, this.f475t);
            this.f457b.m30a();
            timingLogger.addSplit("BasicOes.create");
            this.f456a = new C0053bo(resources, this.f475t);
            this.f456a.m178a(this);
            timingLogger.addSplit("lookup2DFilter.create");
            this.f456a.m30a();
            timingLogger.addSplit("lookup2DFilter.create()");
        } else {
            this.f478w = C0120m.m528b(resources, this.f475t);
            for (C0009b c0009b : this.f478w) {
                c0009b.m30a();
                c0009b.m48c(this.f476u, this.f477v);
            }
            this.f479x = new C0130w(this.f475t, resources);
            this.f479x.m645b(this.f475t.denoiseTexture);
            C0097g.m311d(this.f475t);
            C0097g.m314e(this.f475t);
            C0097g.m298a(this.f475t, this.f476u, this.f477v, this.f445H, true, (float[]) null);
        }
        this.f481z = C0010c.m59a(this.f475t);
        timingLogger.addSplit("RenderTextureFilter.getInstance");
        if (!this.f451N) {
            float fMin = Math.min(1.0f, 512.0f / Math.max(OplusGLSurfaceView_13, i2));
            int i3 = (int) (OplusGLSurfaceView_13 * fMin);
            int i4 = (int) (i2 * fMin);
            int[] iArr2 = new int[3];
            C0113f.m480a(iArr2.length, iArr2, 0, 6408, i3, i4);
            this.f446I = C0113f.m486b(iArr2[0], 6408, i3, i4);
            this.f447J = C0113f.m486b(iArr2[1], 6408, i3, i4);
            this.f448K = C0113f.m486b(iArr2[2], 6408, i3, i4);
        }
        timingLogger.dumpToLog();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m372a(Resources resources, int OplusGLSurfaceView_13, int i2, boolean z) {
        m373a(resources, OplusGLSurfaceView_13, i2, z, z ? 1 : 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m373a(Resources resources, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        this.f473r = 1.0f;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0114g.m492a("initRender::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5::fastMode=%IntrinsicsJvm.kt_4::textureType=%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
        C0001a.m11a("start init");
        if (resources == null || OplusGLSurfaceView_13 <= 0 || i2 <= 0) {
            return;
        }
        this.f451N = z;
        this.f442E = !z;
        this.f450M = i3;
        if (z) {
            m371a(resources, 1, 1, (Map<String, Object>) null);
        } else {
            m371a(resources, 800, 800, (Map<String, Object>) null);
        }
        Context context = this.f475t;
        context.isSDK = true;
        this.f445H = false;
        if (!z) {
            C0113f.m490b(context.lensBlurTexture, 1, 1);
        }
        m402c(OplusGLSurfaceView_13, i2);
        if (z) {
            m428s();
        }
        Context.backgroundColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        C0001a.m11a("end init");
        C0114g.m492a("End of initRender, time = %IntrinsicsJvm.kt_5 ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m374a(Resources resources, Context context, int OplusGLSurfaceView_13, boolean z) {
        C0094d c0094d;
        C0094d c0094d2 = context.imageTexture;
        int i2 = c0094d2.f388b;
        int i3 = c0094d2.f389c;
        int iMax = Math.max(0, (int) (Math.log(OplusGLSurfaceView_13) / Math.log(2.0d)));
        int iMax2 = Math.max(i2 >> iMax, 1);
        int iMax3 = Math.max(i3 >> iMax, 1);
        C0113f.m490b(context.writableTexture, iMax2, iMax3);
        C0113f.m490b(context.readableTexture, iMax2, iMax3);
        C0113f.m490b(context.dehazeTexture, iMax2, iMax3);
        C0113f.m490b(context.denoiseTexture, iMax2, iMax3);
        if (!z) {
            float fMax = 1024.0f / Math.max(i2, i3);
            int iFloor = (int) Math.floor(i2 * fMax);
            int iFloor2 = (int) Math.floor(i3 * fMax);
            C0113f.m490b(context.paintTexture, iFloor, iFloor2);
            C0113f.m490b(context.intermediateTexture, iFloor, iFloor2);
        }
        GLES20.glDisable(3042);
        int[] iArr = context.textures;
        if (iArr == null || iArr.length <= 0) {
            c0094d = context.imageTexture;
        } else {
            mo366a(C0072i.m231a(resources, context), 0, context.readableTexture);
            c0094d = context.readableTexture;
        }
        float[] fArr = new float[15];
        float COUIBaseListPopupWindow_12 = 1.0f / 15;
        float f2 = 1.0f / i2;
        float f3 = 1.0f / i3;
        for (int i4 = 0; i4 <= 7; i4++) {
            float fExp = (float) Math.exp((-(i4 * i4)) * COUIBaseListPopupWindow_12);
            fArr[7 - i4] = fExp;
            fArr[i4 + 7] = fExp;
        }
        C0068e c0068eM225a = C0068e.m225a(resources, context);
        c0068eM225a.mo57a("delta", Float.valueOf(f2));
        c0068eM225a.f310r = fArr;
        C0089z c0089zM258a = C0089z.m258a(resources, context);
        c0089zM258a.mo57a("delta", Float.valueOf(f3));
        c0089zM258a.f359r = fArr;
        mo366a(c0068eM225a, c0094d.f387a, context.writableTexture);
        mo366a(c0089zM258a, context.writableTexture.f387a, context.denoiseTexture);
        m377a(context, resources, z ? 4 : 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m375a(BrushItem brushItem) {
        if (this.f473r != 1.0f) {
            brushItem = brushItem.copy();
            brushItem.size /= this.f473r;
            brushItem.mosaicSize = Math.min(brushItem.mosaicSize, 3.0f);
        }
        C0130w c0130w = this.f479x;
        Context context = this.f475t;
        c0130w.m634a(context, brushItem, context.writableTexture);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m376a(BrushItem brushItem, PointF pointF) {
        C0114g.m492a("addBrushPathPoint::brushItem=%s::point", brushItem, pointF);
        if (brushItem == null) {
            return;
        }
        if (brushItem.points == null) {
            brushItem.points = new ArrayList();
        }
        synchronized (brushItem.points) {
            C0130w.m625a(brushItem, pointF, this.f475t.paintTexture.f388b, this.f475t.paintTexture.f389c);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m377a(Context context, Resources resources, int OplusGLSurfaceView_13) {
        C0026ao c0026aoM112a = C0026ao.m112a(resources, context);
        C0031at c0031atM132a = C0031at.m132a(resources, context);
        C0061bw c0061bwM215a = C0061bw.m215a(resources, context);
        C0037az c0037azM140a = C0037az.m140a(resources, context);
        C0013ab c0013abM95a = C0013ab.m95a(resources, context);
        C0067d c0067dM223a = C0067d.m223a(resources, context);
        C0080q c0080qM242a = C0080q.m242a(resources, context);
        C0094d c0094d = context.imageTexture;
        float COUIBaseListPopupWindow_12 = c0094d.f388b;
        float f2 = c0094d.f389c;
        float fMin = Math.min(1.0f, (512.0f / OplusGLSurfaceView_13) / Math.max(COUIBaseListPopupWindow_12, f2));
        int i2 = (int) (COUIBaseListPopupWindow_12 * fMin);
        int i3 = (int) (f2 * fMin);
        C0113f.m490b(context.writableTexture, i2, i3);
        C0113f.m490b(context.readableTexture, i2, i3);
        C0113f.m490b(this.f446I, i2, i3);
        C0113f.m490b(this.f447J, i2, i3);
        C0113f.m490b(this.f448K, i2, i3);
        C0094d c0094d2 = context.denoiseTexture;
        m352a(context, c0031atM132a, c0061bwM215a, c0094d2, this.f448K);
        c0080qM242a.f339r = Context.overlayMesh;
        mo366a(c0080qM242a, c0094d2.f387a, this.f447J);
        this.f446I = m351a(context, c0026aoM112a, c0094d2, this.f446I, 8.0f, (Float) null);
        C0094d c0094d3 = this.f447J;
        this.f447J = m351a(context, c0026aoM112a, c0094d3, c0094d3, 8.0f, (Float) null);
        C0094d c0094d4 = this.f448K;
        this.f448K = m351a(context, c0026aoM112a, c0094d4, c0094d4, 48.0f, (Float) null);
        c0013abM95a.f61r = this.f446I.f387a;
        c0013abM95a.f62s = this.f447J.f387a;
        c0013abM95a.f63t = this.f448K.f387a;
        c0013abM95a.f64u = Context.overlayMesh;
        mo366a(c0013abM95a, 0, context.writableTexture);
        C0094d c0094d5 = context.writableTexture;
        c0067dM223a.f305r = this.f446I.f387a;
        c0067dM223a.f306s = this.f448K.f387a;
        c0067dM223a.f307t = c0094d5.f387a;
        c0067dM223a.f308u = Context.overlayMesh;
        mo366a(c0067dM223a, 0, this.f447J);
        C0094d c0094d6 = this.f447J;
        Float fValueOf = Float.valueOf(48.0f);
        C0094d c0094dM351a = m351a(context, c0026aoM112a, c0094d5, c0094d5, 8.0f, fValueOf);
        C0094d c0094dM351a2 = m351a(context, c0026aoM112a, c0094d6, c0094d6, 8.0f, fValueOf);
        c0037azM140a.f166r = c0094dM351a.f387a;
        c0037azM140a.f167s = c0094dM351a2.f387a;
        c0037azM140a.f168t = c0094d2.f387a;
        c0037azM140a.f169u = Context.overlayMesh;
        mo366a(c0037azM140a, 0, context.dehazeTexture);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m378a(MagicEraserPath magicEraserPath, int OplusGLSurfaceView_13, int i2, int i3) {
        C0114g.m492a("magicEraserPathOverLay::path=%s::outputTexture=%IntrinsicsJvm.kt_5::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5", magicEraserPath, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.f449L == null) {
            Context context = this.f475t;
            this.f449L = new C0133z(context.resources, context.shaderUtil);
            this.f449L.m687b(this.f475t.imageTexture.f387a, i2, i3, 0);
        }
        this.f449L.m678a(this.f475t.intermediateTexture, OplusGLSurfaceView_13, magicEraserPath, i2, i3, 0.0f, 0.0f, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m379a(String str) {
        C0114g.m492a("fastUpdateFilter::filterID=%s", str);
        m395b(str, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m380a(String str, float COUIBaseListPopupWindow_12) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            if (!c0053bo.m188c(str)) {
                this.f456a.m182a(FilterPackageUtil.m5387b(this.f480y.getAssets(), str));
            }
            this.f456a.m177a(COUIBaseListPopupWindow_12);
            this.f456a.m196p();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m381a(List<FaceItem> list, float COUIBaseListPopupWindow_12) {
        C0114g.m492a("updateFaces::faceItems=%s::faceAdjustIntensity=%COUIBaseListPopupWindow_12", list, Float.valueOf(COUIBaseListPopupWindow_12));
        if (!list.isEmpty()) {
            C0132y.m655a(this.f476u, this.f477v, list, this.f480y, this.f475t);
        }
        this.f475t.renderStates.put("faces", list);
        if (this.f452O == null) {
            this.f452O = C0091a.m267a(this.f480y, this.f475t.imageTexture, 300, 300);
        }
        int size = list.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            C0121n.m547a(300, 300, this.f452O, list.get(OplusGLSurfaceView_13), null, COUIBaseListPopupWindow_12, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m382a(List<DrawingItem> list, int OplusGLSurfaceView_13) {
        m383a(list, OplusGLSurfaceView_13, false, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m383a(List<DrawingItem> list, int OplusGLSurfaceView_13, boolean z, float COUIBaseListPopupWindow_12, float f2, float f3) {
        boolean z2;
        int i2;
        if (list == null || list.isEmpty() || OplusGLSurfaceView_13 <= 0) {
            return;
        }
        int[] iArr = new int[2];
        GLES31.glGetTexLevelParameteriv(3553, 0, 4096, iArr, 0);
        GLES31.glGetTexLevelParameteriv(3553, 0, 4097, iArr, 1);
        C0114g.m492a("drawFiltersFrame::drawingItems=%s::outputTexture=%IntrinsicsJvm.kt_5::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5", list.toString(), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        C0001a.m11a("start draw filter frame");
        boolean zGlIsEnabled = GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            GLES20.glDisable(3089);
        }
        Rect rect = list.get(0).rect;
        int i3 = this.f441D;
        this.f441D = 0;
        Iterator<DrawingItem> it = list.iterator();
        while (it.hasNext()) {
            Bitmap bitmap = it.next().thumbBitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        int i4 = this.f476u;
        int i5 = this.f477v;
        if (this.f459d) {
            if (this.f460e == null) {
                this.f460e = new C0090c(this.f480y, this.f475t);
            }
            if (z2 && this.f475t.isOES) {
                Matrix.setIdentityM(this.f457b.getMatrix(), 0);
                mo366a(this.f457b, this.f440C, this.f475t.writableTexture);
            } else {
                int i6 = this.f440C;
                C0094d c0094d = this.f475t.writableTexture;
                mo363a(i6, c0094d.f387a, c0094d.f388b, c0094d.f389c);
            }
            i2 = this.f460e.m260a(this.f475t.writableTexture, rect.width(), rect.height()).f387a;
            m402c(rect.width(), rect.height());
        } else {
            C0090c c0090c = this.f460e;
            if (c0090c != null) {
                c0090c.close();
                this.f460e = null;
            }
            m402c(rect.width(), rect.height());
            if (z2 && this.f475t.isOES) {
                Matrix.setIdentityM(this.f457b.getMatrix(), 0);
                mo366a(this.f457b, this.f440C, this.f475t.writableTexture);
                i2 = this.f475t.writableTexture.f387a;
            } else {
                i2 = this.f440C;
            }
        }
        Matrix.setIdentityM(this.f456a.getMatrix(), 0);
        Matrix.scaleM(this.f456a.getMatrix(), 0, -1.0f, -1.0f, 1.0f);
        this.f481z.m64b(OplusGLSurfaceView_13);
        this.f481z.m48c(rect.width(), rect.height());
        this.f481z.m70s();
        this.f456a.f263ac = false;
        for (DrawingItem drawingItem : list) {
            Bitmap bitmap2 = drawingItem.thumbBitmap;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.f456a.m31a(i2);
            } else {
                this.f456a.m31a(this.f469n.m598a(drawingItem.thumbBitmap));
            }
            m395b(drawingItem.filterId, drawingItem.intensity);
            Rect rect2 = drawingItem.rect;
            GLES20.glViewport(rect2.left, rect2.top, rect2.width(), drawingItem.rect.height());
            this.f456a.m183a(z, (drawingItem.rect.width() <= drawingItem.rect.height() ? drawingItem.rect.width() : drawingItem.rect.height()) * COUIBaseListPopupWindow_12, f2 * drawingItem.rect.width(), f3 * drawingItem.rect.height(), drawingItem.rect.width(), drawingItem.rect.height());
            Bitmap bitmap3 = drawingItem.overlayBitmap;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                int width = drawingItem.overlayBitmap.getWidth();
                int height = drawingItem.overlayBitmap.getHeight();
                if (this.f458c == null) {
                    this.f458c = new Basic(this.f480y, this.f475t);
                    this.f458c.m30a();
                }
                this.f458c.setNeedClear(false);
                this.f458c.m31a(this.f470o.m598a(drawingItem.overlayBitmap));
                Rect rect3 = drawingItem.rect;
                GLES20.glViewport(rect3.left + drawingItem.overlayLeft, rect3.top + drawingItem.overlayTop, width, height);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(1, 771);
                this.f458c.draw();
                GLES20.glDisable(3042);
            }
        }
        this.f481z.m65n();
        this.f441D = i3;
        m402c(i4, i5);
        GLES20.glGetError();
        if (zGlIsEnabled) {
            GLES20.glEnable(3089);
        }
        C0001a.m11a("end draw filter frame");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m384a(Map<String, Object> map) {
        m386a(map, true, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m385a(Map<String, Object> map, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, boolean z) {
        C0001a.m11a("start auto enhance face");
        if (map == null) {
            return;
        }
        C0114g.m492a("autoEnhanceFace::faceStates=%s::faceIndex=%IntrinsicsJvm.kt_5::percent=%COUIBaseListPopupWindow_12::needReduceGlobal=%IntrinsicsJvm.kt_4", map, Integer.valueOf(OplusGLSurfaceView_13), Float.valueOf(COUIBaseListPopupWindow_12), Boolean.valueOf(z));
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        List list = (List) map.get("faces");
        List list2 = (List) map.get("face_features");
        if (list != null && list2 != null && !list.isEmpty() && !list2.isEmpty()) {
            if (this.f452O == null) {
                this.f452O = C0091a.m267a(this.f480y, this.f475t.imageTexture, 300, 300);
            }
            if (OplusGLSurfaceView_13 == -1) {
                int iMin = Math.min(list.size(), list2.size());
                for (int i2 = 0; i2 < iMin; i2++) {
                    C0121n.m547a(300, 300, this.f452O, (FaceItem) list.get(i2), (Context.FaceFeaturesState) list2.get(i2), COUIBaseListPopupWindow_12, z);
                }
            } else if (list.size() > OplusGLSurfaceView_13 && list2.size() > OplusGLSurfaceView_13) {
                C0121n.m547a(300, 300, this.f452O, (FaceItem) list.get(OplusGLSurfaceView_13), (Context.FaceFeaturesState) list2.get(OplusGLSurfaceView_13), COUIBaseListPopupWindow_12, z);
            }
        }
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        C0001a.m11a("end auto enhance face");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m386a(Map<String, Object> map, boolean z, boolean z2) {
        C0011d c0011d;
        C0114g.m492a("updateStates::renderStates=%s::needUpdateFilter=%IntrinsicsJvm.kt_4::fastUpdate=%IntrinsicsJvm.kt_4", map == null ? "null" : map.toString(), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z2) {
            this.f475t.renderStates.putAll(map);
            if (z && (c0011d = this.f474s) != null) {
                C0039ba c0039ba = (C0039ba) C0106f.m460a(c0011d.m85q(), C0039ba.class);
                C0085v c0085v = (C0085v) C0106f.m460a(this.f474s.m85q(), C0085v.class);
                if (c0039ba != null && c0085v != null && (!c0039ba.m144a(map) || !c0085v.m252a(map))) {
                    for (String str : map.keySet()) {
                        C0106f.m463a(this.f474s.m85q(), str, this.f475t.renderStates.get(str));
                    }
                    c0039ba.m145b(map);
                    c0085v.m253b(map);
                }
            }
        } else {
            Object obj = this.f475t.renderStates.get("prevFaces");
            Object obj2 = this.f475t.renderStates.get("prevFaceFeatures");
            C0106f.m464a(this.f475t.renderStates);
            C0053bo c0053bo = this.f456a;
            if (c0053bo != null) {
                c0053bo.m195o();
            }
            if (map != null) {
                for (String str2 : map.keySet()) {
                    Object objM523a = C0120m.m523a(str2, map.get(str2));
                    if (str2.equals("lut_id")) {
                        m395b((String) map.get(str2), ((Float) C0120m.m523a("lookup_intensity", map.get("lookup_intensity"))).floatValue());
                    } else {
                        this.f475t.renderStates.put(str2, objM523a);
                    }
                }
            }
            this.f475t.renderStates.remove("prevFaceFeatures");
            this.f475t.renderStates.remove("prevFaces");
            this.f475t.renderStates.remove("prevBrushes");
            this.f475t.renderStates.remove("zPrevSpots");
            this.f475t.renderStates.put("prevFaces", obj);
            this.f475t.renderStates.put("prevFaceFeatures", obj2);
            if (map != null) {
                if (!this.f475t.isSDK && map.containsKey("distortion_mesh")) {
                    C0127t.m603a(this.f475t, (float[]) this.f475t.renderStates.get("distortion_mesh"));
                }
                if (z) {
                    for (String str3 : this.f475t.renderStates.keySet()) {
                        C0106f.m463a(this.f474s.m85q(), str3, this.f475t.renderStates.get(str3));
                    }
                }
            }
            m399c();
        }
        C0001a.m11a("do update states");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m387a(boolean z) {
        m368a((android.content.Context) null, z);
        if (this.f444G) {
            Basic basicM5425a = Basic.m5425a(this.f480y, this.f475t);
            basicM5425a.m31a(this.f475t.readableTexture.f387a);
            Matrix.setIdentityM(basicM5425a.getMatrix(), 0);
            C0125r.m597a(basicM5425a.getMatrix(), false, true);
            basicM5425a.draw();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m388a(int[] iArr) {
        boolean z;
        int[] iArr2 = this.f475t.textures;
        if (iArr2 == null || iArr2.length != 4) {
            z = false;
        } else {
            int length = iArr2.length;
            z = true;
            int OplusGLSurfaceView_13 = 0;
            int i2 = 0;
            while (OplusGLSurfaceView_13 < length) {
                if (iArr2[OplusGLSurfaceView_13] != iArr[i2]) {
                    z = false;
                }
                OplusGLSurfaceView_13++;
                i2++;
            }
        }
        if (!z) {
            this.f475t.textures = iArr;
        }
        this.f440C = 0;
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m389b() {
        C0114g.m492a("updateInputTexture", new Object[0]);
        C0001a.m11a("start update input");
        boolean zGlIsEnabled = GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            GLES20.glDisable(3089);
        }
        this.f452O = null;
        this.f453P = null;
        this.f454Q = null;
        if (this.f451N || this.f443F) {
            m419k();
            return;
        }
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        m411g();
        GLES20.glGetError();
        C0001a.m11a("updated input texture");
        this.f475t.renderStates.remove("prevFaces");
        this.f475t.renderStates.remove("prevFaceFeatures");
        if (this.f442E) {
            m374a(this.f480y, this.f475t, 2, false);
            C0097g.m298a(this.f475t, this.f476u, this.f477v, this.f445H, true, (float[]) null);
            C0001a.m11a("input render maps");
            m399c();
            C0001a.m11a("input update others");
        }
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        if (zGlIsEnabled) {
            GLES20.glEnable(3089);
        }
        C0001a.m11a("end update input");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m390b(float COUIBaseListPopupWindow_12) {
        C0114g.m492a("setFilterIntensity::intensity=%COUIBaseListPopupWindow_12", Float.valueOf(COUIBaseListPopupWindow_12));
        C0053bo c0053bo = this.f456a;
        if (c0053bo == null || c0053bo.m173A()) {
            return;
        }
        this.f456a.m177a(COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m391b(int OplusGLSurfaceView_13) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m184b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m392b(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 * OplusGLSurfaceView_13;
        Context context = Context.LutContext;
        C0094d c0094d = context.imageTexture;
        c0094d.f388b = i3;
        c0094d.f389c = OplusGLSurfaceView_13;
        context.renderStates = this.f475t.renderStates;
        this.f474s.m75a(context);
        this.f474s.m48c(i3, OplusGLSurfaceView_13);
        this.f474s.m31a(i2);
        this.f474s.m91w();
        this.f474s.m83o();
        this.f474s.m84p();
        m365a(Basic.m5425a(this.f480y, this.f475t), this.f474s.m86r(), i2, i3, OplusGLSurfaceView_13);
        this.f474s.m75a(this.f475t);
        this.f474s.m48c(this.f476u, this.f477v);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m393b(BrushItem brushItem) {
        C0114g.m492a("updateBrushPoints::brushItem=%s", brushItem);
        if (brushItem == null) {
            return;
        }
        if (brushItem.points == null) {
            brushItem.points = new ArrayList();
        }
        synchronized (brushItem.points) {
            C0130w.m627a(brushItem.touchPoints, brushItem, this.f475t.paintTexture.f388b, this.f475t.paintTexture.f389c);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m394b(String str) {
        C0114g.m492a("updateStates::stateString=%s", str);
        C0001a.m11a("start update states json");
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        m397b(C0117j.m514a(str));
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        C0001a.m11a("end update states json");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m395b(String str, float COUIBaseListPopupWindow_12) {
        C0114g.m492a("fastUpdateFilter::filterID=%s::filterIntensity=%COUIBaseListPopupWindow_12", str, Float.valueOf(COUIBaseListPopupWindow_12));
        String[] strArrM5386a = FilterPackageUtil.m5386a(this.f480y.getAssets(), str);
        if (strArrM5386a == null) {
            m380a(str, COUIBaseListPopupWindow_12);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrM5386a) {
            LutItem lutItem = new LutItem();
            lutItem.filterId = str2;
            lutItem.intensity = 1.0f;
            arrayList.add(lutItem);
        }
        if (COUIBaseListPopupWindow_12 >= 0.3f) {
            arrayList.get(0).intensity = (COUIBaseListPopupWindow_12 - 0.3f) / 0.7f;
            arrayList.get(1).intensity = 1.0f;
        } else {
            arrayList.get(0).intensity = 0.0f;
            arrayList.get(1).intensity = COUIBaseListPopupWindow_12 / 0.3f;
        }
        m396b(arrayList);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m396b(List<LutItem> list) {
        C0094d c0094dM202v = this.f456a.m202v();
        C0094d c0094dM203w = this.f456a.m203w();
        this.f456a.m198r();
        C0053bo c0053bo = this.f456a;
        float COUIBaseListPopupWindow_12 = c0053bo.f265ae;
        c0053bo.f265ae = 0.0f;
        for (LutItem lutItem : list) {
            if (lutItem != null && !TextUtils.isEmpty(lutItem.filterId)) {
                m380a(lutItem.filterId, lutItem.intensity);
                this.f481z.m63a(this.f456a);
                this.f481z.m64b(c0094dM203w.f387a);
                this.f481z.m48c(c0094dM202v.f388b, c0094dM202v.f389c);
                this.f481z.m31a(c0094dM202v.f387a);
                this.f481z.draw();
                C0113f.m484a(c0094dM202v, c0094dM203w);
            }
        }
        C0053bo c0053bo2 = this.f456a;
        c0053bo2.f265ae = COUIBaseListPopupWindow_12;
        c0053bo2.m188c("COMBAIN_FILTER");
        this.f456a.m177a(1.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m397b(Map<String, Object> map) {
        String str;
        if (map == null) {
            return;
        }
        C0114g.m492a("updateStates::renderStates=%s", map.toString());
        C0001a.m11a("start update states");
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        if (this.f451N) {
            m384a(map);
            str = "end fast update states";
        } else {
            m386a(map, true, false);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            str = "end update states";
        }
        C0001a.m11a(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m398b(boolean z) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m187c(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m399c() {
        if (this.f475t.renderStates.containsKey("faces")) {
            C0132y.m659a((List<FaceItem>) this.f475t.renderStates.get("faces"), this.f480y, this.f475t);
            if (this.f475t.renderStates.containsKey("face_features")) {
                Context context = this.f475t;
                C0127t.m602a(context, (List<Context.FaceFeaturesState>) context.renderStates.get("face_features"));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m400c(float COUIBaseListPopupWindow_12) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.f236B = COUIBaseListPopupWindow_12 != 0.0f;
            this.f456a.f265ae = COUIBaseListPopupWindow_12;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m401c(int OplusGLSurfaceView_13) {
        C0114g.m492a("setInputTexture::inputTexture=%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13));
        C0001a.m11a("start set input");
        this.f440C = OplusGLSurfaceView_13;
        this.f475t.textures = null;
        this.f455R = false;
        C0001a.m11a("end set input");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m402c(int OplusGLSurfaceView_13, int i2) {
        C0114g.m492a("updateSize::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        C0001a.m11a("start update size");
        this.f476u = OplusGLSurfaceView_13;
        this.f477v = i2;
        C0113f.m490b(this.f475t.imageTexture, this.f476u, this.f477v);
        if (!this.f451N) {
            C0011d c0011d = this.f474s;
            if (c0011d != null) {
                c0011d.m48c(this.f476u, this.f477v);
            }
            for (C0009b c0009b : this.f478w) {
                c0009b.m30a();
                c0009b.m48c(this.f476u, this.f477v);
            }
        }
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m48c(this.f476u, this.f477v);
        }
        C0097g.m311d(this.f475t);
        C0097g.m314e(this.f475t);
        C0097g.m298a(this.f475t, this.f476u, this.f477v, this.f445H, true, (float[]) null);
        C0001a.m11a("end update size");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m403c(boolean z) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m191d(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m404d() {
        this.f479x.m648d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m405d(int OplusGLSurfaceView_13) {
        C0001a.m11a("start set output");
        C0114g.m492a("setOutputTexture::outTexture=%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13));
        this.f441D = OplusGLSurfaceView_13;
        C0001a.m11a("end set output");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m406d(boolean z) {
        this.f459d = z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m407e() {
        this.f469n.m599a();
        this.f470o.m599a();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m408e(boolean z) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m192e(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m409f() {
        C0114g.m492a("createInputTexture", new Object[0]);
        C0001a.m11a("start create input");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f440C = iArr[0];
        C0097g.m306c(this.f440C);
        GLES20.glBindTexture(3553, this.f440C);
        C0113f.m487b();
        this.f455R = true;
        C0001a.m11a("end create input");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m410f(boolean z) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m193f(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final void m411g() {
        if (!this.f451N && this.f450M == 1) {
            if (this.f461f == null) {
                this.f461f = new C0006b();
                this.f461f.m19a();
            }
            int OplusGLSurfaceView_13 = this.f440C;
            if (OplusGLSurfaceView_13 != 0) {
                this.f461f.m20a(OplusGLSurfaceView_13);
                this.f481z.m64b(this.f475t.imageTexture.f387a);
                this.f481z.m48c(this.f476u, this.f477v);
                this.f481z.m70s();
                this.f461f.m21a((SurfaceTexture) null, (float[]) null);
                this.f481z.m65n();
                return;
            }
            return;
        }
        if (this.f451N || this.f440C == 0) {
            if (this.f450M == 1) {
                Matrix.setIdentityM(this.f457b.getMatrix(), 0);
                mo366a(this.f457b, this.f440C, this.f475t.imageTexture);
                return;
            } else {
                int i2 = this.f440C;
                C0094d c0094d = this.f475t.imageTexture;
                mo363a(i2, c0094d.f387a, c0094d.f388b, c0094d.f389c);
                return;
            }
        }
        this.f481z.m64b(this.f475t.imageTexture.f387a);
        C0094d c0094d2 = this.f475t.imageTexture;
        int i3 = this.f476u;
        c0094d2.f388b = i3;
        int i4 = this.f477v;
        c0094d2.f389c = i4;
        this.f481z.m48c(i3, i4);
        this.f481z.m70s();
        Basic basicM5425a = Basic.m5425a(this.f480y, this.f475t);
        basicM5425a.m31a(this.f440C);
        basicM5425a.draw();
        this.f481z.m65n();
        this.f479x.m647c(this.f475t.imageTexture);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m412g(boolean z) {
        C0114g.m492a("enableRealTimeAutoEnhancement::isEnable=%IntrinsicsJvm.kt_4", Boolean.valueOf(z));
        this.f442E = !z;
        this.f443F = z;
        if (this.f443F && !this.f451N) {
            if (this.f457b == null) {
                this.f457b = new C0025an(this.f480y, this.f475t);
                this.f457b.m30a();
            }
            if (this.f456a == null) {
                this.f456a = new C0053bo(this.f480y, this.f475t);
                this.f456a.m178a(this);
                this.f456a.m30a();
            }
            m428s();
        }
        if (this.f443F && this.f465j == null) {
            HandlerThread handlerThread = new HandlerThread("PO_AE_THEREAD");
            handlerThread.start();
            this.f465j = new Handler(handlerThread.getLooper());
        }
        if (this.f442E) {
            return;
        }
        C0113f.m490b(this.f475t.dehazeTexture, 1, 1);
    }

    @Override // co.polarr.renderer.PacmanFilter
    public String getSeed() {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            return c0053bo.m205y();
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m413h() {
        C0114g.m492a("drawFrame", new Object[0]);
        C0001a.m11a("start draw frame");
        boolean zGlIsEnabled = GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            GLES20.glDisable(3089);
        }
        if (!this.f451N && !this.f443F) {
            if (this.f450M == 1) {
                m387a(false);
                return;
            }
            GLES20.glGetError();
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            m368a((android.content.Context) null, false);
            if (this.f444G) {
                Basic basicM5425a = Basic.m5425a(this.f480y, this.f475t);
                basicM5425a.m31a(this.f475t.readableTexture.f387a);
                Matrix.setIdentityM(basicM5425a.getMatrix(), 0);
                basicM5425a.draw();
            }
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            if (zGlIsEnabled) {
                GLES20.glEnable(3089);
            }
            C0001a.m11a("end draw frame");
            return;
        }
        if (this.f463h) {
            if (this.f462g >= 1) {
                PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(m348B());
                if (this.f462g > 1) {
                    aVar.run();
                } else if (!this.f467l) {
                    this.f465j.post(aVar);
                }
            }
            synchronized (this.f464i) {
                if (!this.f464i.isEmpty()) {
                    m397b(this.f464i);
                    m416i(true);
                    this.f464i.clear();
                }
            }
            this.f462g--;
            if (this.f462g <= 0) {
                this.f462g = 1;
            }
        }
        m417j();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m414h(boolean z) {
        C0114g.m492a("autoEnhanceGlobal::isEnable=%IntrinsicsJvm.kt_4", Boolean.valueOf(z));
        this.f463h = z;
        if (this.f463h) {
            this.f462g = 2;
        } else {
            m416i(false);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m415i() {
        this.f456a.f264ad = true;
        m413h();
        this.f456a.f264ad = false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m416i(boolean z) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            if (!z) {
                c0053bo.m188c("default");
                return;
            }
            C0094d c0094dM201u = c0053bo.m201u();
            m392b(c0094dM201u.f389c, c0094dM201u.f387a);
            this.f456a.m188c("AUTO_ENHANCE_FILTER");
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public final void m417j() {
        int OplusGLSurfaceView_13;
        AbstractC0008a abstractC0008a;
        int i2;
        C0094d c0094d;
        C0114g.m492a("fastDrawFrame", new Object[0]);
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.f263ac = true;
            Matrix.setIdentityM(c0053bo.getMatrix(), 0);
            Context context = this.f475t;
            if (context.isOES) {
                Matrix.scaleM(this.f456a.getMatrix(), 0, -1.0f, -1.0f, 1.0f);
                if (this.f441D != 0) {
                    mo366a(this.f457b, this.f440C, this.f475t.readableTexture);
                    abstractC0008a = this.f456a;
                    c0094d = this.f475t.readableTexture;
                    i2 = c0094d.f387a;
                    OplusGLSurfaceView_13 = this.f441D;
                    m365a(abstractC0008a, i2, OplusGLSurfaceView_13, c0094d.f388b, c0094d.f389c);
                } else {
                    Context context2 = this.f475t;
                    C0094d c0094d2 = context2.imageTexture;
                    C0094d c0094d3 = context2.writableTexture;
                    List list = (List) context2.renderStates.get("faces");
                    if (this.f468m != null && list != null && !list.isEmpty()) {
                        C0094d c0094d4 = c0094d3;
                        C0094d c0094d5 = c0094d2;
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            FaceItem faceItem = (FaceItem) list.get(i3);
                            C0096f c0096f = this.f475t.faceMasks[i3];
                            Context.FaceState faceState = faceItem.adjustments;
                            if (faceState != null) {
                                C0055bq c0055bq = this.f468m;
                                c0055bq.f281r = c0096f;
                                c0055bq.f282s = faceState;
                                mo366a(c0055bq, c0094d5.f387a, c0094d4);
                                C0094d c0094d6 = c0094d4;
                                c0094d4 = c0094d5;
                                c0094d5 = c0094d6;
                            }
                        }
                        c0094d2 = c0094d5;
                    }
                    mo366a(this.f456a, c0094d2.f387a, this.f475t.readableTexture);
                }
            } else {
                OplusGLSurfaceView_13 = this.f441D;
                if (OplusGLSurfaceView_13 != 0) {
                    abstractC0008a = this.f456a;
                    i2 = this.f440C;
                    c0094d = context.readableTexture;
                    m365a(abstractC0008a, i2, OplusGLSurfaceView_13, c0094d.f388b, c0094d.f389c);
                } else {
                    mo366a(this.f456a, this.f440C, context.readableTexture);
                }
            }
        }
        if (this.f444G) {
            Basic basicM5425a = Basic.m5425a(this.f480y, this.f475t);
            basicM5425a.m31a(this.f475t.readableTexture.f387a);
            Matrix.setIdentityM(basicM5425a.getMatrix(), 0);
            basicM5425a.draw();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m418j(boolean z) {
        this.f444G = z;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public final void m419k() {
        m411g();
        GLES20.glGetError();
        C0001a.m11a("fast update texture");
        if (this.f442E) {
            m374a(this.f480y, this.f475t, 2, false);
            C0113f.m490b(this.f475t.readableTexture, this.f476u, this.f477v);
            C0113f.m490b(this.f475t.writableTexture, this.f476u, this.f477v);
            C0001a.m11a("update texture for maps");
        }
        Context context = this.f475t;
        Basic.m5425a(context.resources, context);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m420k(boolean z) {
        this.f445H = z;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m421l() {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m188c("COMBAIN_FILTER");
            this.f456a.m177a(1.0f);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public int m422m() {
        return this.f479x.m646c().f387a;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public int m423n() {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            return c0053bo.m204x();
        }
        return 0;
    }

    /* renamed from: o */
    public C0053bo m424o() {
        return this.f456a;
    }

    /* renamed from: p */
    public int m425p() {
        C0114g.m492a("getOutputId", new Object[0]);
        int OplusGLSurfaceView_13 = this.f441D;
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 : this.f475t.readableTexture.f387a;
    }

    /* renamed from: q */
    public PacmanFilter m426q() {
        C0053bo c0053bo = this.f456a;
        if (c0053bo == null || !c0053bo.m174B()) {
            return null;
        }
        return this;
    }

    /* renamed from: r */
    public int m427r() {
        C0114g.m492a("getTextureId", new Object[0]);
        return this.f440C;
    }

    @Deprecated
    /* renamed from: s */
    public void m428s() {
        C0114g.m492a("initAllFilters", new Object[0]);
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m197q();
            this.f456a.m198r();
            if (this.f456a.m188c("default")) {
                return;
            }
            this.f456a.m182a(FilterPackageUtil.m5387b(this.f480y.getAssets(), "default"));
        }
    }

    @Override // co.polarr.renderer.PacmanFilter
    public void setOrientation(Orientation orientation) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m181a(orientation);
        }
    }

    @Override // co.polarr.renderer.PacmanFilter
    public void setSeed(String str) {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m190d(str);
        }
    }

    /* renamed from: t */
    public void m429t() {
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.m175C();
        }
    }

    /* renamed from: u */
    public void m430u() {
        C0114g.m492a("release", new Object[0]);
        C0001a.m11a("start release");
        m433x();
        m435z();
        C0001a.m11a("end release");
    }

    /* renamed from: v */
    public final void m431v() {
        Basic.m5426m();
        C0050bl.m165m();
        C0088y.m257m();
        C0048bj.m161m();
        C0030as.m131m();
        C0055bq.m211m();
        C0071h.m230m();
        C0027ap.m115m();
        C0022ak.m109m();
        C0014ac.m98m();
        C0043be.m153m();
        C0082s.m245m();
        C0021aj.m106n();
        C0040bb.m149m();
        C0017af.m102m();
        C0045bg.m157m();
        C0060bv.m214l();
        C0016ae.m100l();
        C0076m.m236m();
        C0032au.m135m();
        C0052bn.m169m();
        C0072i.m232m();
        C0026ao.m113m();
        C0031at.m133m();
        C0061bw.m216m();
        C0037az.m141m();
        C0013ab.m96m();
        C0067d.m224m();
        C0080q.m243m();
        C0068e.m226m();
        C0089z.m259m();
        C0070g.m228m();
        C0010c.m61m();
        C0042bd.m151m();
        C0024am.m111m();
        C0036ay.m139m();
        C0049bk.m163m();
        C0034aw.m137m();
    }

    /* renamed from: w */
    public final void m432w() {
        Map<String, C0094d> map;
        Context context = this.f475t;
        if (context != null && (map = context.brushes) != null) {
            Iterator<C0094d> it = map.values().iterator();
            while (it.hasNext()) {
                C0001a.m9a(it.next());
            }
        }
        Context context2 = this.f475t;
        if (context2 != null) {
            context2.brushes = null;
        }
    }

    /* renamed from: x */
    public void m433x() {
        C0114g.m492a("releaseGLRes", new Object[0]);
        C0001a.m11a("start release gl");
        C0090c c0090c = this.f460e;
        if (c0090c != null) {
            c0090c.close();
            this.f460e = null;
        }
        C0053bo c0053bo = this.f456a;
        if (c0053bo != null) {
            c0053bo.close();
            this.f456a = null;
        }
        this.f469n.m599a();
        this.f470o.m599a();
        C0011d c0011d = this.f474s;
        if (c0011d != null) {
            C0039ba c0039ba = (C0039ba) C0106f.m460a(c0011d.m85q(), C0039ba.class);
            C0085v c0085v = (C0085v) C0106f.m460a(this.f474s.m85q(), C0085v.class);
            if (c0039ba != null) {
                c0039ba.m147n();
            }
            C0001a.m11a("releaseGLRes filter1");
            if (c0085v != null) {
                c0085v.m255n();
            }
            C0001a.m11a("releaseGLRes filter2");
            this.f474s.m89u();
            C0001a.m11a("releaseGLRes filter3");
        }
        C0010c.m59a(this.f475t).m71t();
        C0096f[] c0096fArr = this.f475t.faceMasks;
        if (c0096fArr != null) {
            for (C0096f c0096f : c0096fArr) {
                C0001a.m9a(c0096f);
            }
        }
        List<C0094d> list = this.f475t.textLayers;
        if (list != null) {
            Iterator<C0094d> it = list.iterator();
            while (it.hasNext()) {
                C0001a.m9a(it.next());
            }
        }
        int[] iArr = this.f475t.textures;
        if (iArr != null) {
            for (int OplusGLSurfaceView_13 : iArr) {
                C0113f.m476a(OplusGLSurfaceView_13);
            }
        }
        C0094d[] c0094dArr = this.f475t.brushTextures;
        if (c0094dArr != null) {
            for (C0094d c0094d : c0094dArr) {
                C0001a.m9a(c0094d);
            }
        }
        C0001a.m9a(this.f446I);
        C0001a.m9a(this.f447J);
        C0001a.m9a(this.f448K);
        C0001a.m9a(this.f475t.imageTexture);
        C0001a.m9a(this.f475t.dehazeTexture);
        C0001a.m9a(this.f475t.denoiseTexture);
        C0001a.m9a(this.f475t.cacheTexture);
        if (!this.f451N || this.f441D == 0) {
            C0001a.m9a(this.f475t.readableTexture);
        }
        C0001a.m9a(this.f475t.writableTexture);
        C0001a.m9a(this.f475t.paintTexture);
        C0001a.m9a(this.f475t.retouchTexture);
        C0001a.m9a(this.f475t.lensBlurTexture);
        C0001a.m9a(this.f475t.intermediateTexture);
        C0001a.m9a(this.f475t.grainTexture);
        C0001a.m9a(this.f475t.overlayTexture);
        m347A();
        C0001a.m11a("releaseGLRes pattern");
        m432w();
        C0001a.m11a("releaseGLRes brushes");
        m434y();
        C0133z c0133z = this.f449L;
        if (c0133z != null) {
            c0133z.m672a();
        }
        C0001a.m11a("releaseGLRes patch");
        C0130w c0130w = this.f479x;
        if (c0130w != null) {
            c0130w.m649e();
        }
        C0001a.m11a("releaseGLRes brush");
        C0097g.m301b();
        C0001a.m11a("releaseGLRes render");
        GLES20.glFlush();
        this.f475t.shaderUtil.m531a();
        C0001a.m11a("end release gl");
    }

    /* renamed from: y */
    public void m434y() {
        int OplusGLSurfaceView_13;
        if (this.f455R && (OplusGLSurfaceView_13 = this.f440C) != 0) {
            C0113f.m476a(OplusGLSurfaceView_13);
            C0097g.m312e(this.f440C);
        }
        this.f440C = 0;
    }

    /* renamed from: z */
    public void m435z() {
        C0114g.m492a("releaseNonGLRes", new Object[0]);
        C0001a.m11a("start release non-gl");
        this.f452O = null;
        this.f453P = null;
        this.f454Q = null;
        m431v();
        C0133z c0133z = this.f449L;
        if (c0133z != null) {
            c0133z.m686b();
        }
        C0001a.m11a("end release non-gl");
    }
}
