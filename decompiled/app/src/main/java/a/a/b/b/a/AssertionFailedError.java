package a_renamed.a_renamed.b_renamed.b_renamed.a_renamed;

/* loaded from: classes.dex */
public class b_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed {
    public static final java.lang.String defaultVertexShader = "vertex.glsl";
    public java.lang.String n_renamed;
    public java.lang.String o_renamed;
    public java.util.LinkedHashMap<java.lang.String, java.lang.Float> p_renamed;

    public b_renamed(android.content.res.Resources resources, java.lang.String str, co_renamed.polarr.renderer.entities.Context context) {
        super(context, resources);
        this.p_renamed = new java.util.LinkedHashMap<>();
        this.n_renamed = str;
        this.o_renamed = defaultVertexShader;
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Context context) {
        this.f15a = context;
    }

    public void a_renamed(java.lang.String str, java.lang.Object obj) {
        this.p_renamed.put(str, (java.lang.Float) obj);
    }

    public void a_renamed(java.lang.String[] strArr) {
        java.util.LinkedHashMap<java.lang.String, java.lang.Float> linkedHashMap;
        float fFloatValue;
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                if (a_renamed.a_renamed.b_renamed.f_renamed.f79a.containsKey(str)) {
                    linkedHashMap = this.p_renamed;
                    fFloatValue = ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.f79a.get(str)).floatValue();
                } else {
                    linkedHashMap = this.p_renamed;
                    fFloatValue = 0.0f;
                }
                linkedHashMap.put(str, java.lang.Float.valueOf(fFloatValue));
            }
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
        float[] fArr = co_renamed.polarr.renderer.entities.Context.backgroundColor;
        android.opengl.GLES20.glClearColor(fArr[0], fArr[1], fArr[2], 1.0f);
        android.opengl.GLES20.glClear(16384);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        b_renamed(this.o_renamed, this.n_renamed);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        if (this.p_renamed.isEmpty()) {
            return;
        }
        for (java.lang.String str : this.p_renamed.keySet()) {
            int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, str);
            java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(str, this.f15a.renderStates);
            android.opengl.GLES20.glUniform1f(iGlGetUniformLocation, objA != null ? java.lang.Float.parseFloat(objA.toString()) : this.p_renamed.get(str).floatValue());
        }
    }

    public boolean l_renamed() {
        if (this.p_renamed.isEmpty()) {
            return false;
        }
        for (java.lang.String str : this.p_renamed.keySet()) {
            java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(str, this.f15a.renderStates);
            if (objA == null) {
                objA = this.p_renamed.get(str);
            }
            if (((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.f79a.get(str)).floatValue() != java.lang.Float.parseFloat(objA.toString())) {
                return false;
            }
        }
        return true;
    }
}
