package org.andresoviedo.android_3d_model_engine.p230b;

import android.opengl.Matrix;
import com.p094b.p095a.Log;
import com.p094b.p095a.WavefrontLoaderO3d;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import org.andresoviedo.android_3d_model_engine.p229a.RendererFactory;
import org.andresoviedo.p225a.p226a.GL;
import org.andresoviedo.p225a.p227b.IOUtils;

/* compiled from: Object3DData.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class Object3DData {

    /* renamed from: A */
    private final float[] f24934A;

    /* renamed from: B */
    private float[] f24935B;

    /* renamed from: C */
    private final float[] f24936C;

    /* renamed from: D */
    private boolean f24937D;

    /* renamed from: E */
    private Dimensions f24938E;

    /* renamed from: F */
    private List<String> f24939F;

    /* renamed from: G */
    private WavefrontLoaderO3d f24940G;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected FloatBuffer f24942b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected List<Element> f24943c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected float[] f24944d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected float[] f24945e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected float[] f24946f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected Dimensions f24947g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f24948h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f24949i;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f24953m;

    /* renamed from: OplusGLSurfaceView_11 */
    private FloatBuffer f24954n;

    /* renamed from: o */
    private FloatBuffer f24955o;

    /* renamed from: p */
    private FloatBuffer f24956p;

    /* renamed from: q */
    private FloatBuffer f24957q;

    /* renamed from: r */
    private FloatBuffer f24958r;

    /* renamed from: s */
    private byte[] f24959s;

    /* renamed from: t */
    private Material f24960t;

    /* renamed from: u */
    private IntBuffer f24961u;

    /* renamed from: v */
    private ShortBuffer f24962v;

    /* renamed from: w */
    private List<int[]> f24963w;

    /* renamed from: x */
    private float[] f24964x;

    /* renamed from: y */
    private float[] f24965y;

    /* renamed from: z */
    private float[] f24966z;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f24950j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f24951k = true;

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean f24941a = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f24952l = true;

    /* renamed from: L */
    protected void m26214L() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m26224a(EventObject eventObject) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26225a(RendererFactory c4053c, float[] fArr, float[] fArr2) {
    }

    /* renamed from: p */
    public int m26248p() {
        return 0;
    }

    /* compiled from: Object3DData.java */
    /* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    protected static class PlatformImplementations.kt_3 extends EventObject {
        PlatformImplementations.kt_3(Object obj) {
            super(obj);
        }
    }

    public Object3DData() {
        GL c4047c = GL.f24804a;
        this.f24953m = 0;
        this.f24942b = null;
        this.f24954n = null;
        this.f24955o = null;
        this.f24956p = null;
        this.f24957q = null;
        this.f24958r = null;
        this.f24943c = null;
        this.f24959s = null;
        this.f24960t = new Material("default");
        this.f24961u = null;
        this.f24962v = null;
        this.f24963w = null;
        this.f24944d = new float[]{1.0f, 1.0f, 1.0f};
        this.f24945e = new float[]{0.0f, 0.0f, 0.0f};
        this.f24946f = new float[]{0.0f, 0.0f, 0.0f};
        this.f24964x = null;
        this.f24965y = null;
        this.f24966z = null;
        this.f24934A = new float[16];
        this.f24936C = new float[16];
        Matrix.setIdentityM(this.f24934A, 0);
        Matrix.setIdentityM(this.f24936C, 0);
        this.f24938E = null;
        this.f24947g = null;
        this.f24939F = new ArrayList();
    }

    public Object3DData(FloatBuffer floatBuffer, IntBuffer intBuffer) {
        GL c4047c = GL.f24804a;
        this.f24953m = 0;
        this.f24942b = null;
        this.f24954n = null;
        this.f24955o = null;
        this.f24956p = null;
        this.f24957q = null;
        this.f24958r = null;
        this.f24943c = null;
        this.f24959s = null;
        this.f24960t = new Material("default");
        this.f24961u = null;
        this.f24962v = null;
        this.f24963w = null;
        this.f24944d = new float[]{1.0f, 1.0f, 1.0f};
        this.f24945e = new float[]{0.0f, 0.0f, 0.0f};
        this.f24946f = new float[]{0.0f, 0.0f, 0.0f};
        this.f24964x = null;
        this.f24965y = null;
        this.f24966z = null;
        this.f24934A = new float[16];
        this.f24936C = new float[16];
        Matrix.setIdentityM(this.f24934A, 0);
        Matrix.setIdentityM(this.f24936C, 0);
        this.f24938E = null;
        this.f24947g = null;
        this.f24939F = new ArrayList();
        this.f24942b = floatBuffer;
        this.f24961u = intBuffer;
        m26220a(false);
        m26214L();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object3DData m26218a(String str) {
        this.f24948h = str;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public String m26237g() {
        return this.f24948h;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public String m26239h() {
        return this.f24949i;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m26241i() {
        return this.f24950j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object3DData m26220a(boolean z) {
        this.f24950j = z;
        return this;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public Material m26242j() {
        return this.f24960t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26227a(Material c4059f) {
        this.f24960t = c4059f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26226a(Dimensions c4057d) {
        this.f24947g = c4057d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26223a(WavefrontLoaderO3d c1244o) {
        this.f24940G = c1244o;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public WavefrontLoaderO3d m26243k() {
        return this.f24940G;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26222a(WavefrontLoaderO3d.IntrinsicsJvm.kt_4 bVar) {
        this.f24938E = new Dimensions(bVar.f6288a, bVar.f6289b, bVar.f6290c, bVar.f6291d, bVar.f6293f, bVar.f6292e);
        Log.m6277c("Object3DData", "New fixed dimensions for " + m26237g() + ": " + this.f24938E);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Dimensions mo26167d() {
        if (this.f24947g == null) {
            float[] fArr = new float[4];
            float[] fArr2 = new float[4];
            Dimensions c4057d = new Dimensions();
            Log.m6278d("Object3DData", "id_renamed:" + m26237g() + ", elements:" + this.f24943c);
            List<Element> list = this.f24943c;
            if (list == null || list.isEmpty()) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f24942b.capacity(); OplusGLSurfaceView_13 += 3) {
                    fArr[0] = this.f24942b.get(OplusGLSurfaceView_13);
                    fArr[1] = this.f24942b.get(OplusGLSurfaceView_13 + 1);
                    fArr[2] = this.f24942b.get(OplusGLSurfaceView_13 + 2);
                    fArr[3] = 1.0f;
                    Matrix.multiplyMV(fArr2, 0, m26205C(), 0, fArr, 0);
                    c4057d.m26193a(fArr2[0], fArr2[1], fArr2[2]);
                }
            } else {
                Iterator<Element> it = m26216N().iterator();
                while (it.hasNext()) {
                    int i2 = 0;
                    for (IntBuffer intBufferM26196a = it.next().m26196a(); i2 < intBufferM26196a.capacity(); intBufferM26196a = intBufferM26196a) {
                        int i3 = intBufferM26196a.get(i2) * 3;
                        fArr[0] = this.f24942b.get(i3);
                        fArr[1] = this.f24942b.get(i3 + 1);
                        fArr[2] = this.f24942b.get(i3 + 2);
                        fArr[3] = 1.0f;
                        Matrix.multiplyMV(fArr2, 0, m26205C(), 0, fArr, 0);
                        c4057d.m26193a(fArr2[0], fArr2[1], fArr2[2]);
                        i2++;
                    }
                }
            }
            this.f24947g = c4057d;
            Log.m6277c("Object3DData", "Calculated current dimensions for '" + m26237g() + "': " + this.f24947g);
        }
        return this.f24947g;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m26244l() {
        return this.f24951k;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m26245m() {
        return this.f24937D;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26231b(boolean z) {
        this.f24937D = z;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public float[] m26246n() {
        return m26242j().m26201c();
    }

    /* renamed from: o */
    public int m26247o() {
        return this.f24953m;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object3DData m26217a(int OplusGLSurfaceView_13) {
        this.f24953m = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: q */
    public byte[] m26249q() {
        return this.f24959s;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26229a(byte[] bArr) {
        this.f24959s = bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object3DData m26221a(float[] fArr) {
        this.f24946f = fArr;
        m26202a();
        m26214L();
        this.f24937D = true;
        return this;
    }

    /* renamed from: r */
    public float[] m26250r() {
        return this.f24946f;
    }

    /* renamed from: s */
    public float m26251s() {
        float[] fArr = this.f24946f;
        if (fArr != null) {
            return fArr[0];
        }
        return 0.0f;
    }

    /* renamed from: t */
    public float m26252t() {
        float[] fArr = this.f24946f;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    /* renamed from: u */
    public float m26253u() {
        float[] fArr = this.f24946f;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    /* renamed from: v */
    public float[] m26254v() {
        return this.f24945e;
    }

    /* renamed from: w */
    public float m26255w() {
        return this.f24945e[2];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Object3DData m26230b(float[] fArr) {
        this.f24944d = fArr;
        m26202a();
        m26214L();
        this.f24937D = true;
        return this;
    }

    /* renamed from: x */
    public float[] m26256x() {
        return this.f24944d;
    }

    /* renamed from: y */
    public float m26257y() {
        return m26256x()[0];
    }

    /* renamed from: z */
    public float m26258z() {
        return m26256x()[1];
    }

    /* renamed from: A */
    public float m26203A() {
        return m26256x()[2];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Object3DData m26233c(float[] fArr) {
        this.f24945e = fArr;
        m26202a();
        return this;
    }

    /* renamed from: B */
    public float[] m26204B() {
        return this.f24965y;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26202a() {
        float[] fArr;
        Matrix.setIdentityM(this.f24934A, 0);
        float[] fArr2 = this.f24964x;
        if (fArr2 != null) {
            Matrix.rotateM(this.f24934A, 0, fArr2[1], 0.0f, 1.0f, 0.0f);
        }
        if (m26250r() != null) {
            Matrix.translateM(this.f24934A, 0, m26251s(), m26252t(), m26253u());
        }
        if (this.f24965y != null && (fArr = this.f24966z) != null) {
            Matrix.translateM(this.f24934A, 0, fArr[0], fArr[1], fArr[2]);
            Matrix.rotateM(this.f24934A, 0, m26204B()[0], 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.f24934A, 0, m26204B()[1], 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.f24934A, 0, m26204B()[2], 0.0f, 0.0f, 1.0f);
            float[] fArr3 = this.f24934A;
            float[] fArr4 = this.f24966z;
            Matrix.translateM(fArr3, 0, -fArr4[0], -fArr4[1], -fArr4[2]);
        }
        if (m26254v() != null) {
            Matrix.rotateM(this.f24934A, 0, m26254v()[0], 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.f24934A, 0, m26254v()[1], 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.f24934A, 0, m26255w(), 0.0f, 0.0f, 1.0f);
        }
        if (m26256x() != null) {
            Matrix.scaleM(this.f24934A, 0, m26257y(), m26258z(), m26203A());
        }
        float[] fArr5 = this.f24935B;
        if (fArr5 == null) {
            System.arraycopy(this.f24934A, 0, this.f24936C, 0, 16);
        } else {
            Matrix.multiplyMM(this.f24936C, 0, this.f24934A, 0, fArr5, 0);
        }
        m26224a(new PlatformImplementations.kt_3(this));
    }

    /* renamed from: C */
    public float[] m26205C() {
        return this.f24936C;
    }

    /* renamed from: D */
    public IntBuffer m26206D() {
        return this.f24961u;
    }

    /* renamed from: E */
    public ShortBuffer m26207E() {
        IntBuffer intBuffer;
        if (this.f24962v == null && (intBuffer = this.f24961u) != null) {
            this.f24962v = IOUtils.m26130b(intBuffer.capacity());
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f24961u.capacity(); OplusGLSurfaceView_13++) {
                this.f24962v.put((short) this.f24961u.get(OplusGLSurfaceView_13));
            }
        }
        return this.f24962v;
    }

    /* renamed from: F */
    public FloatBuffer m26208F() {
        return this.f24957q;
    }

    /* renamed from: G */
    public FloatBuffer m26209G() {
        return this.f24942b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Object3DData m26232c(FloatBuffer floatBuffer) {
        this.f24942b = floatBuffer;
        m26214L();
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Object3DData m26234d(FloatBuffer floatBuffer) {
        this.f24958r = floatBuffer;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Object3DData m26235e(FloatBuffer floatBuffer) {
        this.f24957q = floatBuffer;
        return this;
    }

    /* renamed from: H */
    public FloatBuffer m26210H() {
        return this.f24954n;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Object3DData m26236f(FloatBuffer floatBuffer) {
        this.f24954n = floatBuffer;
        return this;
    }

    /* renamed from: I */
    public FloatBuffer m26211I() {
        return this.f24956p;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Object3DData m26238g(FloatBuffer floatBuffer) {
        this.f24956p = floatBuffer;
        return this;
    }

    /* renamed from: J */
    public List<int[]> m26212J() {
        return this.f24963w;
    }

    /* renamed from: K */
    public FloatBuffer m26213K() {
        return this.f24958r;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public Object3DData m26240h(FloatBuffer floatBuffer) {
        if (floatBuffer != null && floatBuffer.capacity() % 4 != 0) {
            throw new IllegalArgumentException("Color buffer not multiple of 4 floats");
        }
        this.f24955o = floatBuffer;
        return this;
    }

    /* renamed from: M */
    public List<String> m26215M() {
        return this.f24939F;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object3DData m26219a(List<Element> list) {
        this.f24943c = list;
        m26214L();
        return this;
    }

    /* renamed from: N */
    public List<Element> m26216N() {
        if (this.f24943c == null && m26206D() != null) {
            Element c4058e = new Element(m26237g(), m26206D(), null);
            c4058e.m26197a(m26242j());
            this.f24943c = Collections.singletonList(c4058e);
        }
        return this.f24943c;
    }

    @Override // 
    /* renamed from: COUIBaseListPopupWindow_12, reason: merged with bridge method [inline-methods] */
    public Object3DData clone() {
        Object3DData c4060g = new Object3DData();
        m26228a(c4060g);
        return c4060g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m26228a(Object3DData c4060g) {
        c4060g.m26218a(m26237g());
        c4060g.m26221a((float[]) m26250r().clone());
        c4060g.m26230b((float[]) m26256x().clone());
        c4060g.m26233c((float[]) m26254v().clone());
        c4060g.m26226a(mo26167d());
        c4060g.m26232c(m26209G());
        c4060g.m26236f(m26210H());
        c4060g.m26240h(m26213K());
        c4060g.m26238g(m26211I());
        c4060g.m26227a(m26242j());
        c4060g.m26219a(m26216N());
        c4060g.m26217a(m26247o());
        c4060g.m26220a(m26241i());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Object3DData{id_renamed='");
        sb.append(this.f24948h);
        sb.append("', name=");
        sb.append(m26239h());
        sb.append(", isVisible=");
        sb.append(this.f24951k);
        sb.append(", color=");
        sb.append(Arrays.toString(m26242j().m26201c()));
        sb.append(", position=");
        sb.append(Arrays.toString(this.f24946f));
        sb.append(", scale=");
        sb.append(Arrays.toString(this.f24944d));
        sb.append(", indexed=");
        sb.append(!m26241i());
        sb.append(", vertices: ");
        FloatBuffer floatBuffer = this.f24942b;
        sb.append(floatBuffer != null ? floatBuffer.capacity() / 3 : 0);
        sb.append(", normals: ");
        FloatBuffer floatBuffer2 = this.f24954n;
        sb.append(floatBuffer2 != null ? floatBuffer2.capacity() / 3 : 0);
        sb.append(", dimensions: ");
        sb.append(this.f24938E);
        sb.append(", current dimensions: ");
        sb.append(this.f24947g);
        sb.append(", material=");
        sb.append(m26242j());
        sb.append(", elements=");
        sb.append(m26216N());
        sb.append('}');
        return sb.toString();
    }
}
