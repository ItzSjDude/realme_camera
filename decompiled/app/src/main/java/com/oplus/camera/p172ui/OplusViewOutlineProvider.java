package com.oplus.camera.p172ui;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.oplus.camera.CameraLog;

/* compiled from: OplusViewOutlineProvider.java */
/* renamed from: com.oplus.camera.ui.q */
/* loaded from: classes2.dex */
public class OplusViewOutlineProvider extends ViewOutlineProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    String f22478a = "Rect";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f22479b = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Rect f22480c = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public OplusViewOutlineProvider m23898a(Rect rect, float COUIBaseListPopupWindow_12) {
        this.f22478a = "RoundRect";
        this.f22479b = COUIBaseListPopupWindow_12;
        this.f22480c = rect;
        CameraLog.m12967f("OplusViewOutlineProvider", "setRountRect, mOutLineRect: " + this.f22480c.toString());
        if (m23897a(this.f22480c)) {
            return this;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m23897a(Rect rect) {
        if (rect != null && rect.left >= 0 && rect.top >= 0 && rect.width() > 0 && rect.height() > 0) {
            return true;
        }
        CameraLog.m12967f("OplusViewOutlineProvider", "checkArgumentNonnegative, value is invalid");
        return false;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        if (this.f22480c == null || !"RoundRect".equals(this.f22478a)) {
            return;
        }
        outline.setRoundRect(this.f22480c, this.f22479b);
    }
}
