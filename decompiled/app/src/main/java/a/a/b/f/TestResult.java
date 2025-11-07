package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static float f87a = -1.0f;

    public static float a_renamed(co_renamed.polarr.renderer.entities.Context context, int i_renamed, int i2, boolean z_renamed, float[] fArr) {
        if (context.imageTexture == null) {
            return 1.0f;
        }
        float[] fArrA = a_renamed(context);
        float[] fArr2 = context.margins;
        float f_renamed = context.margin;
        if (fArr == null) {
            fArr = b_renamed(context);
        }
        return java.lang.Math.min(1.0f, java.lang.Math.min(((i_renamed - ((fArr2[0] + fArr2[2]) * c_renamed(context))) - f_renamed) / ((context.cropMode || z_renamed) ? fArr[0] : fArrA[2]), ((i2 - ((fArr2[1] + fArr2[3]) * c_renamed(context))) - f_renamed) / ((context.cropMode || z_renamed) ? fArr[1] : fArrA[3])));
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, float f_renamed, float f2) {
        float fMax = java.lang.Math.max(100.0f, f_renamed);
        float fMax2 = java.lang.Math.max(100.0f, f2);
        context.fov = (float) java.lang.Math.tan(0.3926991f);
        context.invFov = (-1.0f) / context.fov;
        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArrA, 0.7853982f, 1, 0.1f, 1000);
        android.opengl.Matrix.scaleM(fArrA, 0, fArrA, 0, 1.0f / (fMax / 2.0f), 1.0f / (fMax2 / 2.0f), 1.0f);
        context.perspectiveMatrix = fArrA;
    }

    public static float[] a_renamed(co_renamed.polarr.renderer.entities.Context context) {
        if (context.imageTexture == null) {
            return new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        }
        float[] fArrB = b_renamed(context);
        float f_renamed = fArrB[0];
        float f2 = fArrB[1];
        float[] fArr = (float[]) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("crop", context.renderStates);
        if (fArr == null) {
            fArr = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        }
        return new float[]{fArr[0] * f_renamed, fArr[1] * f2, fArr[2] * f_renamed, fArr[3] * f2};
    }

    public static float[] b_renamed(co_renamed.polarr.renderer.entities.Context context) {
        int iFloatValue;
        if (context.imageTexture == null) {
            return new float[]{0.0f, 0.0f};
        }
        if (context.renderStates.containsKey("rotate90")) {
            try {
                iFloatValue = (int) ((java.lang.Float) context.renderStates.get("rotate90")).floatValue();
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        } else {
            iFloatValue = 0;
        }
        if (java.lang.Math.abs(iFloatValue) % 2 > 0) {
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.imageTexture;
            return new float[]{dVar.f36c, dVar.f35b};
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.imageTexture;
        return new float[]{dVar2.f35b, dVar2.f36c};
    }

    public static float c_renamed(co_renamed.polarr.renderer.entities.Context context) {
        if (f87a == -1.0f) {
            f87a = context.resources.getDisplayMetrics().density;
        }
        return f87a;
    }

    public static void d_renamed(co_renamed.polarr.renderer.entities.Context context) {
        float fRound;
        float f_renamed;
        float f2;
        float fRound2;
        float f3;
        float f4;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.imageTexture;
        if (dVar == null) {
            return;
        }
        float f5 = dVar.f35b;
        float f6 = dVar.f36c;
        float[] fArr = (float[]) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("crop", context.renderStates);
        float[] fArrA = a_renamed(context);
        float f7 = context.screen.zoom;
        float f8 = context.cropScale;
        float f9 = (f5 * f7) / f8;
        float f10 = (f6 * f7) / f8;
        float fFloatValue = context.rotation + context.screen.rotation[2] + (((int) ((java.lang.Float) context.renderStates.get("rotate90")).floatValue()) * 90);
        float[] fArrB = b_renamed(context);
        if (context.cropMode) {
            fRound2 = java.lang.Math.round(f9 / 2.0f);
            fRound = java.lang.Math.round(f10 / 2.0f);
            float[] fArr2 = context.screen.rotation;
            float f11 = fArr2[0];
            f4 = fArr2[1];
            f3 = f11;
            f2 = 0.0f;
            f_renamed = 0.0f;
        } else {
            float fRound3 = java.lang.Math.round((fArrA[2] / 2.0f) * context.screen.zoom);
            fRound = java.lang.Math.round((fArrA[3] / 2.0f) * context.screen.zoom);
            float f12 = (1.0f - fArr[2]) / 2.0f;
            float f13 = fArr[0];
            float f14 = fArrB[0];
            float f15 = context.screen.zoom;
            f_renamed = (f12 - f13) * f14 * f15;
            f2 = f15 * (((1.0f - fArr[3]) / 2.0f) - fArr[1]) * fArrB[1];
            fRound2 = fRound3;
            f3 = 0.0f;
            f4 = 0.0f;
        }
        float[] fArr3 = context.margins;
        co_renamed.polarr.renderer.entities.Context.Screen screen = context.screen;
        float fC_renamed = ((-screen.offset[0]) + screen.center[0]) - (((fArr3[0] - fArr3[2]) * c_renamed(context)) / 2.0f);
        co_renamed.polarr.renderer.entities.Context.Screen screen2 = context.screen;
        float fC2 = ((-screen2.offset[1]) - screen2.center[1]) - (((fArr3[1] - fArr3[3]) * c_renamed(context)) / 2.0f);
        co_renamed.polarr.renderer.entities.Context.Overlay overlay = context.overlay;
        overlay.imageWidth = fArrB[0];
        overlay.imageHeight = fArrB[1];
        overlay.width = f9;
        overlay.height = f10;
        overlay.rotation = fFloatValue;
        java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("flip_x", context.renderStates);
        boolean zBooleanValue = objA instanceof java.lang.Boolean ? ((java.lang.Boolean) objA).booleanValue() : false;
        java.lang.Object objA2 = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("flip_y", context.renderStates);
        boolean zBooleanValue2 = objA2 instanceof java.lang.Boolean ? ((java.lang.Boolean) objA2).booleanValue() : false;
        context.overlay.flipX = zBooleanValue ? -1 : 1;
        context.overlay.flipY = zBooleanValue2 ? -1 : 1;
        co_renamed.polarr.renderer.entities.Context.Overlay overlay2 = context.overlay;
        overlay2.tx_renamed = f_renamed + fC_renamed;
        overlay2.ty_renamed = fC2 - f2;
        float f16 = context.invFov;
        float[] fArr4 = {fC_renamed, fC2, f16};
        float[] fArr5 = {fRound2, fRound, 1.0f};
        float[] fArr6 = {overlay2.tx_renamed, overlay2.ty_renamed, f16};
        float[] fArr7 = {f9 * overlay2.flipX * 0.5f, f10 * overlay2.flipY * 0.5f, 1.0f};
        float[] fArr8 = context.screenMatrix;
        android.opengl.Matrix.setIdentityM(fArr8, 0);
        android.opengl.Matrix.rotateM(fArr8, 0, context.perspectiveMatrix, 0, -context.screen.orientation, 0.0f, 0.0f, 1.0f);
        android.opengl.Matrix.translateM(context.overlayMatrix, 0, context.perspectiveMatrix, 0, fArr6[0], fArr6[1], fArr6[2]);
        android.opengl.Matrix.translateM(fArr8, 0, context.perspectiveMatrix, 0, fArr4[0], fArr4[1], fArr4[2]);
        if (context.cropMode) {
            android.opengl.Matrix.rotateM(fArr8, 0, fArr8, 0, -fFloatValue, 0.0f, 0.0f, 1.0f);
            android.opengl.Matrix.scaleM(fArr8, 0, fArr8, 0, fArr5[0], fArr5[1], fArr5[2]);
            android.opengl.Matrix.rotateM(fArr8, 0, fArr8, 0, f3, 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.rotateM(fArr8, 0, fArr8, 0, f4, 0.0f, 1.0f, 0.0f);
        } else {
            android.opengl.Matrix.scaleM(fArr8, 0, fArr8, 0, fArr5[0], fArr5[1], fArr5[2]);
        }
        float[] fArr9 = context.overlayMatrix;
        android.opengl.Matrix.rotateM(fArr9, 0, fArr9, 0, -fFloatValue, 0.0f, 0.0f, 1.0f);
        float[] fArr10 = context.overlayMatrix;
        android.opengl.Matrix.scaleM(fArr10, 0, fArr10, 0, fArr7[0], fArr7[1], fArr7[2]);
        a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArr8, false, true);
    }
}
