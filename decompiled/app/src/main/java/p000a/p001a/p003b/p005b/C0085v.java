package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0097g;
import p000a.p001a.p003b.p008d.C0099a;
import p000a.p001a.p003b.p010f.C0113f;
import p000a.p001a.p003b.p010f.C0120m;
import p000a.p001a.p003b.p010f.C0123p;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.v */
/* loaded from: classes.dex */
public class C0085v extends C0009b {

    /* renamed from: q */
    public static LruCache<Map<String, Object>, int[]> f349q = new LruCache<>(10);

    /* renamed from: r */
    public static List<String> f350r = new ArrayList();

    /* renamed from: s */
    public C0094d f351s;

    /* renamed from: t */
    public int[] f352t;

    /* renamed from: u */
    public Map<String, float[][]> f353u;

    /* renamed from: v */
    public boolean f354v;

    static {
        f350r.add("curves_red");
        f350r.add("curves_green");
        f350r.add("curves_blue");
        f350r.add("curves_all");
    }

    public C0085v(Resources resources, Context context) {
        super(resources, C0120m.m524a("curves"), context);
        this.f353u = new HashMap();
        this.f353u.put("curves_red", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.f353u.put("curves_green", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.f353u.put("curves_blue", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.f353u.put("curves_all", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m248a(C0099a c0099a, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float fM436a = c0099a.m436a(OplusGLSurfaceView_13);
        return fM436a == -1.0f ? (int) COUIBaseListPopupWindow_12 : (int) Math.round(C0123p.m567a(fM436a, 0.0d, 255.0d));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[][] m249a(float[][] fArr) {
        float[][] fArr2 = {new float[fArr.length], new float[fArr.length]};
        int OplusGLSurfaceView_13 = 0;
        for (float[] fArr3 : fArr) {
            fArr2[0][OplusGLSurfaceView_13] = fArr3[0];
            fArr2[1][OplusGLSurfaceView_13] = fArr3[1];
            OplusGLSurfaceView_13++;
        }
        return fArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m250b(int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = 0;
        int i5 = 3;
        while (i5 >= 0) {
            i4 += (i5 == i2 ? i3 & 255 : (OplusGLSurfaceView_13 >> (i5 * 8)) & 255) << (i5 * 8);
            i5--;
        }
        return i4;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo57a(String str, Object obj) {
        this.f354v = true;
        synchronized (this.f352t) {
            m251a(str, (float[][]) obj, false);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: PlatformImplementations.kt_3 */
    public final void m251a(String str, float[][] fArr, boolean z) {
        if (z || !(this.f353u.get(str) == fArr || Arrays.deepEquals(this.f353u.get(str), fArr))) {
            this.f353u.put(str, fArr);
            char c2 = 65535;
            int OplusGLSurfaceView_13 = 2;
            switch (str.hashCode()) {
                case -1917275032:
                    if (str.equals("curves_green")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1829931962:
                    if (str.equals("curves_all")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1829915850:
                    if (str.equals("curves_red")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -893285803:
                    if (str.equals("curves_blue")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                OplusGLSurfaceView_13 = 0;
            } else if (c2 == 1) {
                OplusGLSurfaceView_13 = 1;
            } else if (c2 != 2) {
                if (c2 != 3) {
                    return;
                } else {
                    OplusGLSurfaceView_13 = 3;
                }
            }
            try {
                float[][] fArrM249a = m249a(fArr);
                C0099a c0099a = new C0099a(fArrM249a[0], fArrM249a[1], null, null);
                int iM248a = (int) fArrM249a[1][0];
                for (int i2 = 0; i2 <= 255; i2++) {
                    iM248a = m248a(c0099a, i2, iM248a);
                    this.f352t[i2] = m250b(this.f352t[i2], OplusGLSurfaceView_13, iM248a);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m252a(Map<String, Object> map) {
        int[] iArr = f349q.get(map);
        if (iArr == null || iArr.length != this.f352t.length) {
            return false;
        }
        this.f354v = true;
        this.f352t = iArr;
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m253b(Map<String, Object> map) {
        LruCache<Map<String, Object>, int[]> lruCache = f349q;
        int[] iArr = this.f352t;
        lruCache.put(map, Arrays.copyOf(iArr, iArr.length));
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        super.mo52g();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        C0097g.m306c(iArr[0]);
        this.f352t = new int[256];
        this.f351s = C0113f.m486b(iArr[0], 6408, 256, 1);
        GLES20.glBindTexture(3553, this.f351s.f387a);
        C0113f.m487b();
        GLES20.glBindTexture(3553, 0);
        this.f354v = true;
        for (String str : this.f353u.keySet()) {
            m251a(str, (float[][]) C0106f.m462a(str, this.f21a.renderStates), true);
        }
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        if (this.f354v) {
            synchronized (this.f352t) {
                IntBuffer intBufferAsIntBuffer = ByteBuffer.allocateDirect(this.f352t.length * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
                intBufferAsIntBuffer.put(this.f352t);
                intBufferAsIntBuffer.position(0);
                GLES20.glBindTexture(3553, this.f351s.f387a);
                GLES20.glPixelStorei(3317, 8);
                GLES20.glTexImage2D(3553, 0, this.f351s.f390d, this.f351s.f388b, this.f351s.f389c, 0, this.f351s.f390d, 5121, intBufferAsIntBuffer);
                GLES20.glBindTexture(3553, 0);
                GLES20.glPixelStorei(3317, 4);
                this.f354v = false;
            }
        }
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "map");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f351s.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo24l() {
        Map<String, float[][]> map = this.f353u;
        if (map != null) {
            for (float[][] fArr : map.values()) {
                if (fArr.length != 2) {
                    return false;
                }
                float[] fArr2 = fArr[0];
                if (fArr2[0] == 0.0f && fArr2[1] == 0.0f) {
                    float[] fArr3 = fArr[1];
                    if (fArr3[0] != 255.0f || fArr3[1] != 255.0f) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m254m() {
        m255n();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f352t = new int[256];
        this.f351s = C0113f.m486b(iArr[0], 6408, 256, 1);
        C0097g.m306c(iArr[0]);
        this.f354v = true;
        GLES20.glBindTexture(3553, this.f351s.f387a);
        C0113f.m487b();
        GLES20.glBindTexture(3553, 0);
        for (String str : this.f353u.keySet()) {
            m251a(str, (float[][]) C0106f.m462a(str, this.f21a.renderStates), true);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m255n() {
        C0094d c0094d = this.f351s;
        if (c0094d != null) {
            C0097g.m288a(c0094d);
            C0097g.m312e(this.f351s.f387a);
        }
    }
}
