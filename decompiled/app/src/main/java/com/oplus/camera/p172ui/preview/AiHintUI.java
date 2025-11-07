package com.oplus.camera.p172ui.preview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIListener;

/* compiled from: AiHintUI.java */
/* renamed from: com.oplus.camera.ui.preview.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AiHintUI {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f21894a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraUIListener f21897d;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f21902i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RelativeLayout f21895b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private AiTextHintView f21896c = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f21898e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f21899f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f21900g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f21901h = 0;

    public AiHintUI(Activity activity, int OplusGLSurfaceView_13, CameraUIListener cameraUIListener) {
        this.f21894a = null;
        this.f21897d = null;
        this.f21902i = 0;
        this.f21894a = activity;
        this.f21902i = OplusGLSurfaceView_13;
        this.f21897d = cameraUIListener;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m23166e() {
        this.f21895b = (RelativeLayout) this.f21894a.findViewById(R.id_renamed.camera);
        if (this.f21895b == null) {
            return;
        }
        PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f21894a.findViewById(R.id_renamed.frame_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        LayoutInflater layoutInflater = this.f21894a.getLayoutInflater();
        if (this.f21896c == null) {
            this.f21896c = (AiTextHintView) layoutInflater.inflate(R.layout.ai_hint_layout, (ViewGroup) null);
            this.f21895b.addView(this.f21896c);
            this.f21896c.m22076a(this.f21898e, top, height, 0, this.f21902i, this.f21897d);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m23167f() {
        AiTextHintView aiTextHintView;
        this.f21895b = (RelativeLayout) this.f21894a.findViewById(R.id_renamed.camera);
        RelativeLayout relativeLayout = this.f21895b;
        if (relativeLayout == null || (aiTextHintView = this.f21896c) == null) {
            return;
        }
        relativeLayout.removeView(aiTextHintView);
        this.f21896c = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23170a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f21898e = OplusGLSurfaceView_13;
        this.f21900g = i2;
        this.f21901h = i3;
        this.f21899f = i4;
        m23167f();
        m23166e();
        AiTextHintView aiTextHintView = this.f21896c;
        if (aiTextHintView != null) {
            aiTextHintView.m22075a(this.f21898e, this.f21899f, i2, i3);
            this.f21896c.clearAnimation();
            this.f21896c.startAnimation(this.f21896c.m22073a(0.0f, 1.0f));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23171a(boolean z) {
        AiTextHintView aiTextHintView = this.f21896c;
        if (aiTextHintView != null && aiTextHintView.getVisibility() == 0) {
            this.f21896c.clearAnimation();
            this.f21896c.startAnimation(this.f21896c.m22073a(1.0f, 0.0f));
            this.f21896c.m22074a();
        }
        if (z) {
            m23167f();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m23168a() {
        return this.f21902i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23169a(int OplusGLSurfaceView_13) {
        this.f21902i = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23173b() {
        AiTextHintView aiTextHintView = this.f21896c;
        return aiTextHintView != null && aiTextHintView.m22077b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23172b(int OplusGLSurfaceView_13) {
        this.f21899f = OplusGLSurfaceView_13;
        AiTextHintView aiTextHintView = this.f21896c;
        if (aiTextHintView == null || aiTextHintView.getVisibility() != 0) {
            return;
        }
        m23171a(true);
        m23170a(this.f21898e, this.f21900g, this.f21901h, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m23174c() {
        int OplusGLSurfaceView_13 = this.f21900g;
        return R.string.camera_ai_scene_super_text_hint == OplusGLSurfaceView_13 || R.string.camera_ai_scene_ultra_wide_tip == OplusGLSurfaceView_13 || R.string.camera_ai_scene_portrait_mode_hint == OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23175d() {
        this.f21894a = null;
    }
}
