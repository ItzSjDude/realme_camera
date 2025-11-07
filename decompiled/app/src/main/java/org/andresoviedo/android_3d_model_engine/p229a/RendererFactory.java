package org.andresoviedo.android_3d_model_engine.p229a;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.andresoviedo.android_3d_model_engine.R;
import org.andresoviedo.android_3d_model_engine.p230b.Object3DData;
import org.andresoviedo.p225a.p227b.IOUtils;

/* compiled from: RendererFactory.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class RendererFactory {

    /* renamed from: PlatformImplementations.kt_3 */
    private Map<String, String> f24872a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Map<String, GLES20Renderer> f24873b = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String[] f24874c = new String[3];

    public RendererFactory(Context context) throws IllegalAccessException, SecurityException, IOException, IllegalArgumentException {
        Log.OplusGLSurfaceView_13("RendererFactory", "Discovering shaders...");
        Object[] fields = R.raw.class.getFields();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fields.length; OplusGLSurfaceView_13++) {
            String name = fields[OplusGLSurfaceView_13].getName();
            Log.v("RendererFactory", "Loading shader... " + name);
            this.f24872a.put(name, new String(IOUtils.m26129a(context.getResources().openRawResource(fields[OplusGLSurfaceView_13].getInt(fields[OplusGLSurfaceView_13])))));
        }
        Log.OplusGLSurfaceView_13("RendererFactory", "Shaders loaded: " + this.f24872a.size());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Renderer m26161a(Object3DData c4060g, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        String[] strArrM26159a = m26159a(z, false, z3 && !(c4060g.m26210H() == null && c4060g.m26210H() == null), (!z2 || c4060g.m26249q() == null || c4060g.m26211I() == null) ? false : true, (!z5 || c4060g == null || c4060g.m26213K() == null) ? false : true);
        GLES20Renderer c4051a = this.f24873b.get(strArrM26159a[0]);
        if (c4051a != null) {
            return c4051a;
        }
        String str = this.f24872a.get(strArrM26159a[1]);
        String str2 = this.f24872a.get(strArrM26159a[2]);
        if (str == null || str2 == null) {
            Log.COUIBaseListPopupWindow_8("RendererFactory", "Shaders not found for " + strArrM26159a[0]);
            return null;
        }
        String strReplace = str.replace("void main(){", "void main(){\OplusGLSurfaceView_11\tgl_PointSize = 5.0;").replace("const int MAX_JOINTS = 60;", "const int MAX_JOINTS = gl_MaxVertexUniformVectors > 60 ? 60 : gl_MaxVertexUniformVectors;");
        Log.v("RendererFactory", "\OplusGLSurfaceView_11---------- Vertex shader ----------\OplusGLSurfaceView_11");
        Log.v("RendererFactory", strReplace);
        Log.v("RendererFactory", "---------- Fragment shader ----------\OplusGLSurfaceView_11");
        Log.v("RendererFactory", str2);
        Log.v("RendererFactory", "-------------------------------------\OplusGLSurfaceView_11");
        GLES20Renderer c4051aM26133a = GLES20Renderer.m26133a(strArrM26159a[0], strReplace, str2);
        this.f24873b.put(strArrM26159a[0], c4051aM26133a);
        return c4051aM26133a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String[] m26159a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (z2) {
            if (z3) {
                if (z4) {
                    if (z5) {
                        String[] strArr = this.f24874c;
                        strArr[0] = "shader_anim_light_texture_colors_";
                        strArr[1] = "shader_anim_light_texture_colors_vert";
                        strArr[2] = "shader_anim_light_texture_colors_frag";
                    } else {
                        String[] strArr2 = this.f24874c;
                        strArr2[0] = "shader_anim_light_texture_";
                        strArr2[1] = "shader_anim_light_texture_vert";
                        strArr2[2] = "shader_anim_light_texture_frag";
                    }
                } else if (z5) {
                    String[] strArr3 = this.f24874c;
                    strArr3[0] = "shader_anim_light_colors_";
                    strArr3[1] = "shader_anim_light_colors_vert";
                    strArr3[2] = "shader_anim_light_colors_frag";
                } else {
                    String[] strArr4 = this.f24874c;
                    strArr4[0] = "shader_anim_light_";
                    strArr4[1] = "shader_anim_light_vert";
                    strArr4[2] = "shader_anim_light_frag";
                }
            } else if (z4) {
                if (z5) {
                    String[] strArr5 = this.f24874c;
                    strArr5[0] = "shader_anim_texture_colors_";
                    strArr5[1] = "shader_anim_texture_colors_vert";
                    strArr5[2] = "shader_anim_texture_colors_frag";
                } else {
                    String[] strArr6 = this.f24874c;
                    strArr6[0] = "shader_anim_texture_";
                    strArr6[1] = "shader_anim_texture_vert";
                    strArr6[2] = "shader_anim_texture_frag";
                }
            } else if (z5) {
                String[] strArr7 = this.f24874c;
                strArr7[0] = "shader_anim_colors_";
                strArr7[1] = "shader_anim_colors_vert";
                strArr7[2] = "shader_anim_colors_frag";
            } else {
                String[] strArr8 = this.f24874c;
                strArr8[0] = "shader_anim_";
                strArr8[1] = "shader_anim_vert";
                strArr8[2] = "shader_anim_frag";
            }
        } else if (z3) {
            if (z4) {
                if (z5) {
                    String[] strArr9 = this.f24874c;
                    strArr9[0] = "shader_light_texture_colors_";
                    strArr9[1] = "shader_light_texture_colors_vert";
                    strArr9[2] = "shader_light_texture_colors_frag";
                } else {
                    String[] strArr10 = this.f24874c;
                    strArr10[0] = "shader_light_texture_";
                    strArr10[1] = "shader_light_texture_vert";
                    strArr10[2] = "shader_light_texture_frag";
                }
            } else if (z5) {
                String[] strArr11 = this.f24874c;
                strArr11[0] = "shader_light_colors_";
                strArr11[1] = "shader_light_colors_vert";
                strArr11[2] = "shader_light_colors_frag";
            } else {
                String[] strArr12 = this.f24874c;
                strArr12[0] = "shader_light_";
                strArr12[1] = "shader_light_vert";
                strArr12[2] = "shader_light_frag";
            }
        } else if (z4) {
            if (z5) {
                String[] strArr13 = this.f24874c;
                strArr13[0] = "shader_texture_colors_";
                strArr13[1] = "shader_texture_colors_layer_vert";
                strArr13[2] = "shader_texture_colors_layer_frag";
            } else {
                String[] strArr14 = this.f24874c;
                strArr14[0] = "shader_texture_";
                strArr14[1] = "shader_texture_vert";
                strArr14[2] = "shader_texture_frag";
            }
        } else if (z5) {
            String[] strArr15 = this.f24874c;
            strArr15[0] = "shader_colors_";
            strArr15[1] = "shader_colors_vert";
            strArr15[2] = "shader_colors_frag";
        } else {
            String[] strArr16 = this.f24874c;
            strArr16[0] = "shader_";
            strArr16[1] = "shader_vert";
            strArr16[2] = "shader_frag";
        }
        return this.f24874c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Renderer m26160a() {
        return m26161a(null, false, false, false, false, false);
    }
}
