package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Size;
import android.widget.RelativeLayout;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.ScreenModeFacade;

/* compiled from: FullScreenModeRotate.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public abstract class FullScreenModeRotate extends FullScreenMode {
    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16504a() {
        return false;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        this.f16005b = ScreenModeConst.f16035b;
        this.f16006c = ScreenModeConst.f16034a;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) screenRelativeLayout.getLayoutParams();
        layoutParams.addRule(13);
        layoutParams.topMargin = (-(this.f16006c - this.f16005b)) / 2;
        layoutParams.bottomMargin = (-(this.f16006c - this.f16005b)) / 2;
        layoutParams.leftMargin = (this.f16006c - this.f16005b) / 2;
        layoutParams.rightMargin = (this.f16006c - this.f16005b) / 2;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        super.mo16499a(activity, c2949c);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16556a(Activity activity, boolean z, float COUIBaseListPopupWindow_12, float f2) {
        Resources resources = activity.getResources();
        return f2 <= ((float) (ScreenModeConst.f16035b - (resources.getDimensionPixelSize(R.dimen.control_panel_margin_right) + resources.getDimensionPixelSize(R.dimen.shutter_button_length))));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16555a(Activity activity, Rect rect) {
        Resources resources = activity.getResources();
        return ((float) rect.bottom) <= ((float) (ScreenModeConst.f16035b - (resources.getDimensionPixelSize(R.dimen.control_panel_margin_right) + resources.getDimensionPixelSize(R.dimen.shutter_button_length))));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo16561b(Activity activity, Rect rect) {
        Resources resources = activity.getResources();
        return ((float) rect.centerY()) >= ((float) (ScreenModeConst.f16035b - (resources.getDimensionPixelSize(R.dimen.control_panel_margin_right) + resources.getDimensionPixelSize(R.dimen.shutter_button_length))));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RotableTextView mo16550a(Activity activity, RelativeLayout relativeLayout, int OplusGLSurfaceView_13) {
        activity.getLayoutInflater().inflate(R.layout.burst_fold, relativeLayout);
        RotableTextView rotableTextView = (RotableTextView) activity.findViewById(R.id_renamed.burst_num_view_fold);
        if (OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) {
            rotableTextView.setBackground(activity.getResources().getDrawable(R.drawable.burst_num_bg_fold_white, null));
        } else {
            rotableTextView.setBackground(activity.getResources().getDrawable(R.drawable.burst_num_bg_fold_black, null));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rotableTextView.getLayoutParams();
        layoutParams.addRule(12);
        layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(R.dimen.fold_full_first_level_burst_num_view_margin_bottom_rotate);
        return rotableTextView;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo16575d(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16529a(CameraUIInterface cameraUIInterface, int OplusGLSurfaceView_13, int i2) {
        return i2 > this.f16009d && i2 < this.f16006c - this.f16009d;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16557a(Size size, Size size2) {
        return new int[]{this.f16005b, (int) (this.f16005b / (size.getWidth() / size.getHeight())), this.f16005b, (int) (this.f16005b / (size2.getWidth() / size2.getHeight()))};
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    @Override // com.oplus.camera.screen.p164b.BaseScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo16507b(android.app.Activity r8, int r9) {
        /*
            r7 = this;
            r7 = 2131296935(0x7f0902a7, float:1.82118E38)
            r0 = 2131297042(0x7f090312, float:1.8212018E38)
            r1 = 2131296418(0x7f0900a2, float:1.8210752E38)
            r2 = 2131296581(0x7f090145, float:1.8211083E38)
            r3 = 2131296616(0x7f090168, float:1.8211154E38)
            r4 = 0
            r5 = 1
            if (r9 == 0) goto L48
            if (r9 == r5) goto L2c
            r6 = 2
            if (r9 == r6) goto L48
            r5 = 6
            if (r9 == r5) goto L1c
            goto L57
        L1c:
            com.oplus.camera.util.Util.m24256a(r8, r3, r4)
            com.oplus.camera.util.Util.m24256a(r8, r2, r4)
            com.oplus.camera.util.Util.m24256a(r8, r1, r4)
            com.oplus.camera.util.Util.m24256a(r8, r0, r4)
            com.oplus.camera.util.Util.m24256a(r8, r7, r4)
            goto L57
        L2c:
            com.oplus.camera.util.Util.m24256a(r8, r3, r5)
            com.oplus.camera.util.Util.m24256a(r8, r2, r5)
            com.oplus.camera.util.Util.m24256a(r8, r1, r5)
            com.oplus.camera.util.Util.m24256a(r8, r0, r5)
            com.oplus.camera.util.Util.m24256a(r8, r7, r5)
            r7 = 2131297219(0x7f0903c3, float:1.8212377E38)
            com.oplus.camera.util.Util.m24256a(r8, r7, r5)
            r7 = 2131297216(0x7f0903c0, float:1.821237E38)
            com.oplus.camera.util.Util.m24256a(r8, r7, r5)
            goto L57
        L48:
            com.oplus.camera.util.Util.m24256a(r8, r3, r4)
            com.oplus.camera.util.Util.m24256a(r8, r2, r4)
            com.oplus.camera.util.Util.m24256a(r8, r1, r4)
            com.oplus.camera.util.Util.m24256a(r8, r0, r5)
            com.oplus.camera.util.Util.m24256a(r8, r7, r5)
        L57:
            r7 = 2131297156(0x7f090384, float:1.8212249E38)
            r9 = 2131232319(0x7f08063f, float:1.8080744E38)
            com.oplus.camera.util.Util.m24255a(r8, r7, r9)
            r7 = 2131296417(0x7f0900a1, float:1.821075E38)
            com.oplus.camera.util.Util.m24255a(r8, r7, r9)
            r7 = 2131297305(0x7f090419, float:1.8212551E38)
            com.oplus.camera.util.Util.m24255a(r8, r7, r9)
            r7 = 2131296999(0x7f0902e7, float:1.821193E38)
            com.oplus.camera.util.Util.m24255a(r8, r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.screen.p164b.FullScreenModeRotate.mo16507b(android.app.Activity, int):void");
    }
}
