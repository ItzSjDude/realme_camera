package p000a.p001a.p003b.p005b.p006a;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.LinkedHashMap;
import p000a.p001a.p003b.C0106f;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class C0009b extends AbstractC0008a {
    public static final String defaultVertexShader = "vertex.glsl";

    /* renamed from: OplusGLSurfaceView_11 */
    public String f33n;

    /* renamed from: o */
    public String f34o;

    /* renamed from: p */
    public LinkedHashMap<String, Float> f35p;

    public C0009b(Resources resources, String str, Context context) {
        super(context, resources);
        this.f35p = new LinkedHashMap<>();
        this.f33n = str;
        this.f34o = defaultVertexShader;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m56a(Context context) {
        this.f21a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo57a(String str, Object obj) {
        this.f35p.put(str, (Float) obj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m58a(String[] strArr) {
        LinkedHashMap<String, Float> linkedHashMap;
        float fFloatValue;
        if (strArr != null) {
            for (String str : strArr) {
                if (C0106f.f516a.containsKey(str)) {
                    linkedHashMap = this.f35p;
                    fFloatValue = ((Float) C0106f.f516a.get(str)).floatValue();
                } else {
                    linkedHashMap = this.f35p;
                    fFloatValue = 0.0f;
                }
                linkedHashMap.put(str, Float.valueOf(fFloatValue));
            }
        }
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo44b(int OplusGLSurfaceView_13, int i2) {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
        float[] fArr = Context.backgroundColor;
        GLES20.glClearColor(fArr[0], fArr[1], fArr[2], 1.0f);
        GLES20.glClear(16384);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        m45b(this.f34o, this.f33n);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        if (this.f35p.isEmpty()) {
            return;
        }
        for (String str : this.f35p.keySet()) {
            int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, str);
            Object objM462a = C0106f.m462a(str, this.f21a.renderStates);
            GLES20.glUniform1f(iGlGetUniformLocation, objM462a != null ? Float.parseFloat(objM462a.toString()) : this.f35p.get(str).floatValue());
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo24l() {
        if (this.f35p.isEmpty()) {
            return false;
        }
        for (String str : this.f35p.keySet()) {
            Object objM462a = C0106f.m462a(str, this.f21a.renderStates);
            if (objM462a == null) {
                objM462a = this.f35p.get(str);
            }
            if (((Float) C0106f.f516a.get(str)).floatValue() != Float.parseFloat(objM462a.toString())) {
                return false;
            }
        }
        return true;
    }
}
