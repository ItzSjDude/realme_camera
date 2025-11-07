package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public co_renamed.polarr.renderer.entities.DistortionBrushItem f116a = new co_renamed.polarr.renderer.entities.DistortionBrushItem();

    /* renamed from: b_renamed, reason: collision with root package name */
    public float[] f117b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    public float f118c = 1.0f;
    public boolean d_renamed = false;
    public java.lang.Runnable e_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.t_renamed.a_renamed();

    public class a_renamed implements java.lang.Runnable {
        public a_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a_renamed.a_renamed.b_renamed.f_renamed.t_renamed tVar = a_renamed.a_renamed.b_renamed.f_renamed.t_renamed.this;
            float[] fArr = tVar.f117b;
            if (fArr != null) {
                tVar.a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a, fArr, false);
            }
            a_renamed.a_renamed.b_renamed.f_renamed.t_renamed tVar2 = a_renamed.a_renamed.b_renamed.f_renamed.t_renamed.this;
            if (tVar2.d_renamed) {
                a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a.glRenderView.f_renamed();
            } else {
                tVar2.a_renamed();
            }
        }
    }

    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f120a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public float f121b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f122c;
        public float d_renamed;
        public float e_renamed;
        public float f_renamed;
        public float g_renamed;
        public float h_renamed;
        public float i_renamed;

        public b_renamed() {
            this.f120a = 0.0f;
            this.f121b = 0.0f;
            this.f122c = 0.0f;
            this.d_renamed = 0.0f;
            this.e_renamed = 0.0f;
            this.f_renamed = 0.0f;
            this.g_renamed = 0.0f;
            this.h_renamed = 0.0f;
            this.i_renamed = 0.0f;
        }

        public /* synthetic */ b_renamed(a_renamed.a_renamed.b_renamed.f_renamed.t_renamed.a_renamed aVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a_renamed(co_renamed.polarr.renderer.entities.Context r28, java.util.List<co_renamed.polarr.renderer.entities.Context.FaceFeaturesState> r29) {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.f_renamed.t_renamed.a_renamed(co_renamed.polarr.renderer.entities.Context, java.util.List):void");
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, float[] fArr) {
        if (fArr != null) {
            context.mesh.distortion = fArr;
        } else {
            context.mesh.setDistortionPoints(context.distortionVertices);
        }
        context.mesh.compile();
    }

    public final void a_renamed() {
        this.d_renamed = false;
        a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a.currentRender.a_renamed(this.e_renamed);
        a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a.glRenderView.f_renamed();
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Context context, float[] fArr, boolean z_renamed) {
        float[] fArrA;
        char c2;
        float f_renamed = 1.0f;
        char c3 = 1;
        if (z_renamed) {
            fArr[0] = (fArr[0] * 2.0f) - 1.0f;
            fArr[1] = (fArr[1] * 2.0f) - 1.0f;
            fArrA = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(fArr);
        } else {
            fArrA = fArr;
        }
        if (this.f117b == null) {
            this.f117b = fArrA;
        }
        float f2 = fArrA[0];
        float[] fArr2 = this.f117b;
        float f3 = fArr2[0];
        float f4 = fArrA[1];
        float f5 = fArr2[1];
        float[][] distortionPoints = context.mesh.getDistortionPoints();
        float[][] fArr3 = new float[distortionPoints.length][];
        int i_renamed = 0;
        while (i_renamed < distortionPoints.length) {
            float[] fArr4 = distortionPoints[i_renamed];
            if (java.lang.Math.abs(fArr4[0]) == f_renamed || java.lang.Math.abs(fArr4[c3]) == f_renamed) {
                c2 = c3;
                fArr3[i_renamed] = fArr4;
            } else {
                float f6 = fArrA[0];
                float f7 = this.f118c;
                float fA_renamed = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(new float[]{f6 * f7, fArrA[c3]}, new float[]{fArr4[0] * f7, fArr4[c3]});
                float f8 = this.f116a.radius;
                if (fA_renamed <= f8) {
                    float fA2 = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(java.lang.Math.min(1.0f, fA_renamed / f8));
                    co_renamed.polarr.renderer.entities.DistortionBrushItem distortionBrushItem = this.f116a;
                    float f9 = fA2 * distortionBrushItem.strength;
                    if (distortionBrushItem.mode.equals("pinch")) {
                        float f10 = 1.0f - (f9 * this.f116a.rate);
                        fArr3[i_renamed] = new float[]{((fArr4[0] - fArrA[0]) * f10) + fArrA[0], ((fArr4[1] - fArrA[1]) * f10) + fArrA[1]};
                    } else if (this.f116a.mode.equals("bulge")) {
                        float f11 = (this.f116a.rate * f9) + 1.0f;
                        fArr3[i_renamed] = new float[]{((fArr4[0] - fArrA[0]) * f11) + fArrA[0], ((fArr4[1] - fArrA[1]) * f11) + fArrA[1]};
                    } else if (this.f116a.mode.equals("restore")) {
                        fArr3[i_renamed] = new float[2];
                        a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(fArr3[i_renamed], fArr4, context.distortionVertices[i_renamed], f9 * 0.5f);
                    } else {
                        c2 = 1;
                        fArr3[i_renamed] = new float[]{fArr4[0] + ((f2 - f3) * f9), fArr4[1] + (f9 * (f4 - f5))};
                    }
                    c2 = 1;
                } else {
                    c2 = 1;
                    fArr3[i_renamed] = fArr4;
                }
            }
            i_renamed++;
            c3 = c2;
            f_renamed = 1.0f;
        }
        context.mesh.setDistortionPoints(fArr3);
        context.renderStates.put("distortion_mesh", context.mesh.distortion);
        context.mesh.compile();
        this.f117b = fArrA;
    }
}
