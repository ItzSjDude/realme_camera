package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.oplus.camera.capmode.VideoMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0097g;
import p000a.p001a.p003b.p008d.C0100b;
import p000a.p001a.p003b.p010f.C0113f;
import p000a.p001a.p003b.p010f.C0120m;
import p000a.p001a.p003b.p010f.C0123p;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ba */
/* loaded from: classes.dex */
public class C0039ba extends C0009b {

    /* renamed from: q */
    public static LruCache<Map<String, Object>, byte[]> f174q = new LruCache<>(10);

    /* renamed from: r */
    public static final Map<String, String> f175r = new HashMap();

    /* renamed from: s */
    public C0094d f176s;

    /* renamed from: t */
    public byte[] f177t;

    /* renamed from: u */
    public Map<String, Float> f178u;

    /* renamed from: v */
    public boolean f179v;

    static {
        f175r.put("hue_red", "hue");
        f175r.put("hue_orange", "hue");
        f175r.put("hue_yellow", "hue");
        f175r.put("hue_green", "hue");
        f175r.put("hue_aqua", "hue");
        f175r.put("hue_blue", "hue");
        f175r.put("hue_purple", "hue");
        f175r.put("hue_magenta", "hue");
        f175r.put("saturation_red", "saturation");
        f175r.put("saturation_orange", "saturation");
        f175r.put("saturation_yellow", "saturation");
        f175r.put("saturation_green", "saturation");
        f175r.put("saturation_aqua", "saturation");
        f175r.put("saturation_blue", "saturation");
        f175r.put("saturation_purple", "saturation");
        f175r.put("saturation_magenta", "saturation");
        f175r.put("luminance_red", "luminance");
        f175r.put("luminance_orange", "luminance");
        f175r.put("luminance_yellow", "luminance");
        f175r.put("luminance_green", "luminance");
        f175r.put("luminance_aqua", "luminance");
        f175r.put("luminance_blue", "luminance");
        f175r.put("luminance_purple", "luminance");
        f175r.put("luminance_magenta", "luminance");
    }

    public C0039ba(Resources resources, Context context) {
        super(resources, C0120m.m524a("hsl"), context);
        this.f178u = new HashMap();
        Map<String, Float> map = this.f178u;
        Float fValueOf = Float.valueOf(0.0f);
        map.put("hue_red", fValueOf);
        this.f178u.put("hue_orange", fValueOf);
        this.f178u.put("hue_yellow", fValueOf);
        this.f178u.put("hue_green", fValueOf);
        this.f178u.put("hue_aqua", fValueOf);
        this.f178u.put("hue_blue", fValueOf);
        this.f178u.put("hue_purple", fValueOf);
        this.f178u.put("hue_magenta", fValueOf);
        this.f178u.put("saturation_red", fValueOf);
        this.f178u.put("saturation_orange", fValueOf);
        this.f178u.put("saturation_yellow", fValueOf);
        this.f178u.put("saturation_green", fValueOf);
        this.f178u.put("saturation_aqua", fValueOf);
        this.f178u.put("saturation_blue", fValueOf);
        this.f178u.put("saturation_purple", fValueOf);
        this.f178u.put("saturation_magenta", fValueOf);
        this.f178u.put("luminance_red", fValueOf);
        this.f178u.put("luminance_orange", fValueOf);
        this.f178u.put("luminance_yellow", fValueOf);
        this.f178u.put("luminance_green", fValueOf);
        this.f178u.put("luminance_aqua", fValueOf);
        this.f178u.put("luminance_blue", fValueOf);
        this.f178u.put("luminance_purple", fValueOf);
        this.f178u.put("luminance_magenta", fValueOf);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[][] m142a(String str, Map<String, Float> map) {
        return new float[][]{new float[]{0.0f, 30.0f, 60.0f, 90.0f, 180.0f, 240.0f, 270.0f, 300.0f, 360.0f}, new float[]{((map.get(str + "_red").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_orange").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_yellow").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_green").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_aqua").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_blue").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_purple").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_magenta").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_red").floatValue() / 2.0f) + 0.5f) * 255.0f}};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m143a(String str, float COUIBaseListPopupWindow_12, boolean z) {
        if (z || this.f178u.get(str).floatValue() != COUIBaseListPopupWindow_12) {
            this.f178u.put(str, Float.valueOf(COUIBaseListPopupWindow_12));
            String str2 = f175r.get(str);
            char c2 = 65535;
            int iHashCode = str2.hashCode();
            int OplusGLSurfaceView_13 = 2;
            if (iHashCode != -230491182) {
                if (iHashCode != 103672) {
                    if (iHashCode == 1178092792 && str2.equals("luminance")) {
                        c2 = 2;
                    }
                } else if (str2.equals("hue")) {
                    c2 = 0;
                }
            } else if (str2.equals("saturation")) {
                c2 = 1;
            }
            if (c2 == 0) {
                OplusGLSurfaceView_13 = 0;
            } else if (c2 == 1) {
                OplusGLSurfaceView_13 = 1;
            } else if (c2 != 2) {
                return;
            }
            float[][] fArrM142a = m142a(str2, this.f178u);
            C0100b c0100b = new C0100b(fArrM142a[0], fArrM142a[1]);
            for (int i2 = 0; i2 <= 359; i2++) {
                this.f177t[(i2 * 3) + OplusGLSurfaceView_13] = (byte) C0123p.m567a(c0100b.m437a(i2), 0.0d, 255.0d);
            }
        }
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo57a(String str, Object obj) {
        this.f179v = true;
        synchronized (this.f177t) {
            if (obj instanceof Integer) {
                m143a(str, ((Integer) obj).intValue(), false);
            } else {
                m143a(str, ((Float) obj).floatValue(), false);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m144a(Map<String, Object> map) {
        byte[] bArr = f174q.get(map);
        if (bArr == null || bArr.length != this.f177t.length) {
            return false;
        }
        this.f179v = true;
        this.f177t = bArr;
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m145b(Map<String, Object> map) {
        LruCache<Map<String, Object>, byte[]> lruCache = f174q;
        byte[] bArr = this.f177t;
        lruCache.put(map, Arrays.copyOf(bArr, bArr.length));
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        super.mo52g();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        C0097g.m306c(iArr[0]);
        this.f177t = new byte[VideoMode.VIDEO_1080P_HEIGHT];
        this.f176s = C0113f.m486b(iArr[0], 6407, 360, 1);
        GLES20.glBindTexture(3553, this.f176s.f387a);
        C0113f.m487b();
        GLES20.glBindTexture(3553, 0);
        this.f179v = true;
        for (String str : this.f178u.keySet()) {
            m143a(str, ((Float) C0106f.m462a(str, this.f21a.renderStates)).floatValue(), true);
        }
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        if (this.f179v) {
            synchronized (this.f177t) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.f177t.length);
                byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
                byteBufferAllocateDirect.put(this.f177t);
                byteBufferAllocateDirect.position(0);
                GLES20.glBindTexture(3553, this.f176s.f387a);
                GLES20.glPixelStorei(3317, 4);
                GLES20.glTexImage2D(3553, 0, this.f176s.f390d, this.f176s.f388b, this.f176s.f389c, 0, this.f176s.f390d, 5121, byteBufferAllocateDirect);
                GLES20.glBindTexture(3553, 0);
            }
            this.f179v = false;
        }
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "map");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f176s.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo24l() {
        Map<String, Float> map = this.f178u;
        if (map == null) {
            return true;
        }
        Iterator<Float> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next().floatValue() != 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m146m() {
        m147n();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        C0097g.m306c(iArr[0]);
        this.f177t = new byte[VideoMode.VIDEO_1080P_HEIGHT];
        this.f176s = C0113f.m486b(iArr[0], 6407, 360, 1);
        GLES20.glBindTexture(3553, this.f176s.f387a);
        C0113f.m487b();
        GLES20.glBindTexture(3553, 0);
        this.f179v = true;
        for (String str : this.f178u.keySet()) {
            Object objM462a = C0106f.m462a(str, this.f21a.renderStates);
            if (objM462a != null && (objM462a instanceof Float)) {
                m143a(str, ((Float) objM462a).floatValue(), true);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m147n() {
        C0094d c0094d = this.f176s;
        if (c0094d != null) {
            C0097g.m288a(c0094d);
            C0097g.m312e(this.f176s.f387a);
        }
    }
}
