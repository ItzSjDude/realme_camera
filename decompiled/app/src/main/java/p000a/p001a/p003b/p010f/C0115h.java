package p000a.p001a.p003b.p010f;

import android.opengl.Matrix;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p007c.C0094d;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class C0115h {

    /* renamed from: PlatformImplementations.kt_3 */
    public static float f525a = -1.0f;

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m494a(Context context, int OplusGLSurfaceView_13, int i2, boolean z, float[] fArr) {
        if (context.imageTexture == null) {
            return 1.0f;
        }
        float[] fArrM496a = m496a(context);
        float[] fArr2 = context.margins;
        float COUIBaseListPopupWindow_12 = context.margin;
        if (fArr == null) {
            fArr = m497b(context);
        }
        return Math.min(1.0f, Math.min(((OplusGLSurfaceView_13 - ((fArr2[0] + fArr2[2]) * m498c(context))) - COUIBaseListPopupWindow_12) / ((context.cropMode || z) ? fArr[0] : fArrM496a[2]), ((i2 - ((fArr2[1] + fArr2[3]) * m498c(context))) - COUIBaseListPopupWindow_12) / ((context.cropMode || z) ? fArr[1] : fArrM496a[3])));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m495a(Context context, float COUIBaseListPopupWindow_12, float f2) {
        float fMax = Math.max(100.0f, COUIBaseListPopupWindow_12);
        float fMax2 = Math.max(100.0f, f2);
        context.fov = (float) Math.tan(0.3926991f);
        context.invFov = (-1.0f) / context.fov;
        float[] fArrM596a = C0125r.m596a();
        C0125r.m593a(fArrM596a, 0.7853982f, 1, 0.1f, 1000);
        Matrix.scaleM(fArrM596a, 0, fArrM596a, 0, 1.0f / (fMax / 2.0f), 1.0f / (fMax2 / 2.0f), 1.0f);
        context.perspectiveMatrix = fArrM596a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m496a(Context context) {
        if (context.imageTexture == null) {
            return new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        }
        float[] fArrM497b = m497b(context);
        float COUIBaseListPopupWindow_12 = fArrM497b[0];
        float f2 = fArrM497b[1];
        float[] fArr = (float[]) C0106f.m462a("crop", context.renderStates);
        if (fArr == null) {
            fArr = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        }
        return new float[]{fArr[0] * COUIBaseListPopupWindow_12, fArr[1] * f2, fArr[2] * COUIBaseListPopupWindow_12, fArr[3] * f2};
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float[] m497b(Context context) {
        int iFloatValue;
        if (context.imageTexture == null) {
            return new float[]{0.0f, 0.0f};
        }
        if (context.renderStates.containsKey("rotate90")) {
            try {
                iFloatValue = (int) ((Float) context.renderStates.get("rotate90")).floatValue();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        } else {
            iFloatValue = 0;
        }
        if (Math.abs(iFloatValue) % 2 > 0) {
            C0094d c0094d = context.imageTexture;
            return new float[]{c0094d.f389c, c0094d.f388b};
        }
        C0094d c0094d2 = context.imageTexture;
        return new float[]{c0094d2.f388b, c0094d2.f389c};
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float m498c(Context context) {
        if (f525a == -1.0f) {
            f525a = context.resources.getDisplayMetrics().density;
        }
        return f525a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m499d(Context context) {
        float fRound;
        float COUIBaseListPopupWindow_12;
        float f2;
        float fRound2;
        float f3;
        float f4;
        C0094d c0094d = context.imageTexture;
        if (c0094d == null) {
            return;
        }
        float f5 = c0094d.f388b;
        float f6 = c0094d.f389c;
        float[] fArr = (float[]) C0106f.m462a("crop", context.renderStates);
        float[] fArrM496a = m496a(context);
        float f7 = context.screen.zoom;
        float f8 = context.cropScale;
        float f9 = (f5 * f7) / f8;
        float f10 = (f6 * f7) / f8;
        float fFloatValue = context.rotation + context.screen.rotation[2] + (((int) ((Float) context.renderStates.get("rotate90")).floatValue()) * 90);
        float[] fArrM497b = m497b(context);
        if (context.cropMode) {
            fRound2 = Math.round(f9 / 2.0f);
            fRound = Math.round(f10 / 2.0f);
            float[] fArr2 = context.screen.rotation;
            float f11 = fArr2[0];
            f4 = fArr2[1];
            f3 = f11;
            f2 = 0.0f;
            COUIBaseListPopupWindow_12 = 0.0f;
        } else {
            float fRound3 = Math.round((fArrM496a[2] / 2.0f) * context.screen.zoom);
            fRound = Math.round((fArrM496a[3] / 2.0f) * context.screen.zoom);
            float f12 = (1.0f - fArr[2]) / 2.0f;
            float f13 = fArr[0];
            float f14 = fArrM497b[0];
            float f15 = context.screen.zoom;
            COUIBaseListPopupWindow_12 = (f12 - f13) * f14 * f15;
            f2 = f15 * (((1.0f - fArr[3]) / 2.0f) - fArr[1]) * fArrM497b[1];
            fRound2 = fRound3;
            f3 = 0.0f;
            f4 = 0.0f;
        }
        float[] fArr3 = context.margins;
        Context.Screen screen = context.screen;
        float fM498c = ((-screen.offset[0]) + screen.center[0]) - (((fArr3[0] - fArr3[2]) * m498c(context)) / 2.0f);
        Context.Screen screen2 = context.screen;
        float fM498c2 = ((-screen2.offset[1]) - screen2.center[1]) - (((fArr3[1] - fArr3[3]) * m498c(context)) / 2.0f);
        Context.Overlay overlay = context.overlay;
        overlay.imageWidth = fArrM497b[0];
        overlay.imageHeight = fArrM497b[1];
        overlay.width = f9;
        overlay.height = f10;
        overlay.rotation = fFloatValue;
        Object objM462a = C0106f.m462a("flip_x", context.renderStates);
        boolean zBooleanValue = objM462a instanceof Boolean ? ((Boolean) objM462a).booleanValue() : false;
        Object objM462a2 = C0106f.m462a("flip_y", context.renderStates);
        boolean zBooleanValue2 = objM462a2 instanceof Boolean ? ((Boolean) objM462a2).booleanValue() : false;
        context.overlay.flipX = zBooleanValue ? -1 : 1;
        context.overlay.flipY = zBooleanValue2 ? -1 : 1;
        Context.Overlay overlay2 = context.overlay;
        overlay2.f5143tx = COUIBaseListPopupWindow_12 + fM498c;
        overlay2.f5144ty = fM498c2 - f2;
        float f16 = context.invFov;
        float[] fArr4 = {fM498c, fM498c2, f16};
        float[] fArr5 = {fRound2, fRound, 1.0f};
        float[] fArr6 = {overlay2.f5143tx, overlay2.f5144ty, f16};
        float[] fArr7 = {f9 * overlay2.flipX * 0.5f, f10 * overlay2.flipY * 0.5f, 1.0f};
        float[] fArr8 = context.screenMatrix;
        Matrix.setIdentityM(fArr8, 0);
        Matrix.rotateM(fArr8, 0, context.perspectiveMatrix, 0, -context.screen.orientation, 0.0f, 0.0f, 1.0f);
        Matrix.translateM(context.overlayMatrix, 0, context.perspectiveMatrix, 0, fArr6[0], fArr6[1], fArr6[2]);
        Matrix.translateM(fArr8, 0, context.perspectiveMatrix, 0, fArr4[0], fArr4[1], fArr4[2]);
        if (context.cropMode) {
            Matrix.rotateM(fArr8, 0, fArr8, 0, -fFloatValue, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(fArr8, 0, fArr8, 0, fArr5[0], fArr5[1], fArr5[2]);
            Matrix.rotateM(fArr8, 0, fArr8, 0, f3, 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(fArr8, 0, fArr8, 0, f4, 0.0f, 1.0f, 0.0f);
        } else {
            Matrix.scaleM(fArr8, 0, fArr8, 0, fArr5[0], fArr5[1], fArr5[2]);
        }
        float[] fArr9 = context.overlayMatrix;
        Matrix.rotateM(fArr9, 0, fArr9, 0, -fFloatValue, 0.0f, 0.0f, 1.0f);
        float[] fArr10 = context.overlayMatrix;
        Matrix.scaleM(fArr10, 0, fArr10, 0, fArr7[0], fArr7[1], fArr7[2]);
        C0125r.m597a(fArr8, false, true);
    }
}
