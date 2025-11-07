package org.andresoviedo.android_3d_model_engine.a_renamed;

/* compiled from: RendererFactory.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.Map<java.lang.String, java.lang.String> f7964a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.Map<java.lang.String, org.andresoviedo.android_3d_model_engine.a_renamed.a_renamed> f7965b = new java.util.HashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String[] f7966c = new java.lang.String[3];

    public c_renamed(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.io.IOException, java.lang.IllegalArgumentException {
        android.util.Log.i_renamed("RendererFactory", "Discovering shaders...");
        java.lang.Object[] fields = org.andresoviedo.android_3d_model_engine.R_renamed.raw.class.getFields();
        for (int i_renamed = 0; i_renamed < fields.length; i_renamed++) {
            java.lang.String name = fields[i_renamed].getName();
            android.util.Log.v_renamed("RendererFactory", "Loading shader... " + name);
            this.f7964a.put(name, new java.lang.String(org.andresoviedo.a_renamed.b_renamed.a_renamed.a_renamed(context.getResources().openRawResource(fields[i_renamed].getInt(fields[i_renamed])))));
        }
        android.util.Log.i_renamed("RendererFactory", "Shaders loaded: " + this.f7964a.size());
    }

    public org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5) {
        java.lang.String[] strArrA = a_renamed(z_renamed, false, z3 && !(gVar.H_renamed() == null && gVar.H_renamed() == null), (!z2 || gVar.q_renamed() == null || gVar.I_renamed() == null) ? false : true, (!z5 || gVar == null || gVar.K_renamed() == null) ? false : true);
        org.andresoviedo.android_3d_model_engine.a_renamed.a_renamed aVar = this.f7965b.get(strArrA[0]);
        if (aVar != null) {
            return aVar;
        }
        java.lang.String str = this.f7964a.get(strArrA[1]);
        java.lang.String str2 = this.f7964a.get(strArrA[2]);
        if (str == null || str2 == null) {
            android.util.Log.e_renamed("RendererFactory", "Shaders not found for " + strArrA[0]);
            return null;
        }
        java.lang.String strReplace = str.replace("void main(){", "void main(){\n_renamed\tgl_PointSize = 5.0;").replace("const int MAX_JOINTS = 60;", "const int MAX_JOINTS = gl_MaxVertexUniformVectors > 60 ? 60 : gl_MaxVertexUniformVectors;");
        android.util.Log.v_renamed("RendererFactory", "\n_renamed---------- Vertex shader ----------\n_renamed");
        android.util.Log.v_renamed("RendererFactory", strReplace);
        android.util.Log.v_renamed("RendererFactory", "---------- Fragment shader ----------\n_renamed");
        android.util.Log.v_renamed("RendererFactory", str2);
        android.util.Log.v_renamed("RendererFactory", "-------------------------------------\n_renamed");
        org.andresoviedo.android_3d_model_engine.a_renamed.a_renamed aVarA = org.andresoviedo.android_3d_model_engine.a_renamed.a_renamed.a_renamed(strArrA[0], strReplace, str2);
        this.f7965b.put(strArrA[0], aVarA);
        return aVarA;
    }

    private java.lang.String[] a_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (z2) {
            if (z3) {
                if (z4) {
                    if (z5) {
                        java.lang.String[] strArr = this.f7966c;
                        strArr[0] = "shader_anim_light_texture_colors_";
                        strArr[1] = "shader_anim_light_texture_colors_vert";
                        strArr[2] = "shader_anim_light_texture_colors_frag";
                    } else {
                        java.lang.String[] strArr2 = this.f7966c;
                        strArr2[0] = "shader_anim_light_texture_";
                        strArr2[1] = "shader_anim_light_texture_vert";
                        strArr2[2] = "shader_anim_light_texture_frag";
                    }
                } else if (z5) {
                    java.lang.String[] strArr3 = this.f7966c;
                    strArr3[0] = "shader_anim_light_colors_";
                    strArr3[1] = "shader_anim_light_colors_vert";
                    strArr3[2] = "shader_anim_light_colors_frag";
                } else {
                    java.lang.String[] strArr4 = this.f7966c;
                    strArr4[0] = "shader_anim_light_";
                    strArr4[1] = "shader_anim_light_vert";
                    strArr4[2] = "shader_anim_light_frag";
                }
            } else if (z4) {
                if (z5) {
                    java.lang.String[] strArr5 = this.f7966c;
                    strArr5[0] = "shader_anim_texture_colors_";
                    strArr5[1] = "shader_anim_texture_colors_vert";
                    strArr5[2] = "shader_anim_texture_colors_frag";
                } else {
                    java.lang.String[] strArr6 = this.f7966c;
                    strArr6[0] = "shader_anim_texture_";
                    strArr6[1] = "shader_anim_texture_vert";
                    strArr6[2] = "shader_anim_texture_frag";
                }
            } else if (z5) {
                java.lang.String[] strArr7 = this.f7966c;
                strArr7[0] = "shader_anim_colors_";
                strArr7[1] = "shader_anim_colors_vert";
                strArr7[2] = "shader_anim_colors_frag";
            } else {
                java.lang.String[] strArr8 = this.f7966c;
                strArr8[0] = "shader_anim_";
                strArr8[1] = "shader_anim_vert";
                strArr8[2] = "shader_anim_frag";
            }
        } else if (z3) {
            if (z4) {
                if (z5) {
                    java.lang.String[] strArr9 = this.f7966c;
                    strArr9[0] = "shader_light_texture_colors_";
                    strArr9[1] = "shader_light_texture_colors_vert";
                    strArr9[2] = "shader_light_texture_colors_frag";
                } else {
                    java.lang.String[] strArr10 = this.f7966c;
                    strArr10[0] = "shader_light_texture_";
                    strArr10[1] = "shader_light_texture_vert";
                    strArr10[2] = "shader_light_texture_frag";
                }
            } else if (z5) {
                java.lang.String[] strArr11 = this.f7966c;
                strArr11[0] = "shader_light_colors_";
                strArr11[1] = "shader_light_colors_vert";
                strArr11[2] = "shader_light_colors_frag";
            } else {
                java.lang.String[] strArr12 = this.f7966c;
                strArr12[0] = "shader_light_";
                strArr12[1] = "shader_light_vert";
                strArr12[2] = "shader_light_frag";
            }
        } else if (z4) {
            if (z5) {
                java.lang.String[] strArr13 = this.f7966c;
                strArr13[0] = "shader_texture_colors_";
                strArr13[1] = "shader_texture_colors_layer_vert";
                strArr13[2] = "shader_texture_colors_layer_frag";
            } else {
                java.lang.String[] strArr14 = this.f7966c;
                strArr14[0] = "shader_texture_";
                strArr14[1] = "shader_texture_vert";
                strArr14[2] = "shader_texture_frag";
            }
        } else if (z5) {
            java.lang.String[] strArr15 = this.f7966c;
            strArr15[0] = "shader_colors_";
            strArr15[1] = "shader_colors_vert";
            strArr15[2] = "shader_colors_frag";
        } else {
            java.lang.String[] strArr16 = this.f7966c;
            strArr16[0] = "shader_";
            strArr16[1] = "shader_vert";
            strArr16[2] = "shader_frag";
        }
        return this.f7966c;
    }

    public org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed a_renamed() {
        return a_renamed(null, false, false, false, false, false);
    }
}
