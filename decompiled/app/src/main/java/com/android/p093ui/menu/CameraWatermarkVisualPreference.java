package com.android.p093ui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.ImageView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.SloganUtil;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.CameraLog;
import com.oplus.camera.LocationManager;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.util.Util;
import java.util.HashSet;

/* loaded from: classes.dex */
public class CameraWatermarkVisualPreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    private ImageView f5983a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Bitmap f5984b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f5985c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f5986d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f5987e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Paint f5988f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Canvas f5989g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f5990h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Bitmap f5991i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Bitmap f5992j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Bitmap f5993k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f5994l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f5995m;

    /* renamed from: OplusGLSurfaceView_11 */
    private BaseSloganUtil f5996n;

    public CameraWatermarkVisualPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f5983a = null;
        this.f5984b = null;
        this.f5985c = false;
        this.f5986d = false;
        this.f5987e = true;
        this.f5988f = null;
        this.f5989g = null;
        this.f5990h = null;
        this.f5991i = null;
        this.f5992j = null;
        this.f5993k = null;
        this.f5994l = 0.0f;
        this.f5995m = true;
        this.f5996n = null;
    }

    public CameraWatermarkVisualPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f5983a = null;
        this.f5984b = null;
        this.f5985c = false;
        this.f5986d = false;
        this.f5987e = true;
        this.f5988f = null;
        this.f5989g = null;
        this.f5990h = null;
        this.f5991i = null;
        this.f5992j = null;
        this.f5993k = null;
        this.f5994l = 0.0f;
        this.f5995m = true;
        this.f5996n = null;
    }

    public CameraWatermarkVisualPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5983a = null;
        this.f5984b = null;
        this.f5985c = false;
        this.f5986d = false;
        this.f5987e = true;
        this.f5988f = null;
        this.f5989g = null;
        this.f5990h = null;
        this.f5991i = null;
        this.f5992j = null;
        this.f5993k = null;
        this.f5994l = 0.0f;
        this.f5995m = true;
        this.f5996n = null;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        ImageView imageView;
        this.f5983a = (ImageView) c0668l.m4007a(R.id_renamed.imageView_watermark_visual);
        m6212b();
        Bitmap bitmap = this.f5984b;
        if (bitmap == null || (imageView = this.f5983a) == null || !this.f5985c) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        this.f5985c = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6212b() {
        if (this.f5986d && this.f5983a != null && Util.m24498u()) {
            Resources resources = m3800K().getResources();
            RecyclerView.C0694j c0694j = (RecyclerView.C0694j) this.f5983a.getLayoutParams();
            if (c0694j == null) {
                c0694j = new RecyclerView.C0694j(-1, -2);
            }
            c0694j.setMarginStart(resources.getDimensionPixelOffset(R.dimen.watermark_visualization_margin_left_vertical));
            c0694j.setMarginEnd(resources.getDimensionPixelOffset(R.dimen.watermark_visualization_margin_left_vertical));
            c0694j.bottomMargin = resources.getDimensionPixelOffset(R.dimen.watermark_visualization_margin_bottom);
            this.f5983a.setLayoutParams(c0694j);
            this.f5983a.setScaleType(ImageView.ScaleType.FIT_START);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6209a(ComboPreferences comboPreferences) {
        if (this.f5991i == null) {
            this.f5991i = Util.m24217a(m3800K(), R.drawable.bg_watermark_visualization, 1.0f, Util.f22962a);
            this.f5991i.setDensity(m3800K().getResources().getDisplayMetrics().densityDpi);
        }
        if (this.f5993k == null) {
            this.f5993k = this.f5996n.mo11280a(m3800K(), 1.0f);
            this.f5993k.setDensity(m3800K().getResources().getDisplayMetrics().densityDpi);
        }
        if (this.f5995m || Util.m24349al()) {
            this.f5992j = this.f5993k;
        } else {
            this.f5992j = Bitmap.createBitmap(1, this.f5993k.getHeight(), Bitmap.Config.ARGB_8888);
        }
        this.f5994l = Util.m24202a(m3800K(), R.dimen.watermark_preview_logo_corner_portrait_interval, Util.f22962a) + (this.f5992j.getHeight() / 2.0f);
        if (this.f5988f == null) {
            this.f5988f = new Paint();
            this.f5988f.setAntiAlias(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private BaseSloganUtil.PlatformImplementations.kt_3 m6211b(ComboPreferences comboPreferences) {
        BaseSloganUtil.COUIBaseListPopupWindow_8 eVar = new BaseSloganUtil.COUIBaseListPopupWindow_8();
        eVar.f12655f = 0;
        eVar.f12650a = new Size((!this.f5995m || Util.m24349al()) ? this.f5991i.getWidth() : (this.f5991i.getWidth() - this.f5993k.getWidth()) + 5, this.f5991i.getHeight());
        eVar.f12652c = BaseSloganUtil.m11687f();
        eVar.f12657h = true;
        eVar.f12658i = this.f5995m;
        eVar.f12653d = LocationManager.m16155a().m16177b();
        eVar.f12659j = this.f5987e;
        return this.f5996n.mo11281a(m3800K(), comboPreferences, eVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6216a(Activity activity, ComboPreferences comboPreferences) {
        if (comboPreferences == null) {
            return;
        }
        this.f5995m = comboPreferences.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet()).contains(m3800K().getResources().getStringArray(R.array.camera_setting_watermark_display_info_values)[0]);
        if (this.f5996n == null) {
            this.f5996n = new SloganUtil(activity, comboPreferences, 0);
        }
        m6209a(comboPreferences);
        BaseSloganUtil.PlatformImplementations.kt_3 aVarM6211b = m6211b(comboPreferences);
        this.f5990h = comboPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "bottom_left_corner");
        CameraLog.m12954a("CameraWatermarkVisualPreference", "updatePreview, watermarkHold: " + aVarM6211b);
        final Bitmap bitmapM24215a = Util.m24215a(this.f5991i.getWidth(), this.f5991i.getHeight(), Bitmap.Config.ARGB_8888);
        bitmapM24215a.setDensity(m3800K().getResources().getDisplayMetrics().densityDpi);
        Bitmap bitmapM6206a = null;
        if (aVarM6211b != null) {
            aVarM6211b.m11720f().setDensity(m3800K().getResources().getDisplayMetrics().densityDpi);
            bitmapM6206a = m6206a(aVarM6211b);
        }
        if (!this.f5995m && bitmapM6206a != null && !Util.m24349al()) {
            this.f5994l = ((Util.m24202a(m3800K(), R.dimen.watermark_preview_logo_corner_portrait_interval, Util.f22962a) + (this.f5992j.getHeight() / 2.0f)) - ((this.f5992j.getHeight() - bitmapM6206a.getHeight()) / 2)) - 4.0f;
        }
        this.f5989g = new Canvas(bitmapM24215a);
        m6208a(bitmapM6206a, aVarM6211b);
        if (this.f5983a == null) {
            this.f5985c = true;
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f5983a.setImageBitmap(bitmapM24215a);
        } else {
            this.f5983a.post(new Runnable() { // from class: com.android.ui.menu.CameraWatermarkVisualPreference.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraWatermarkVisualPreference.this.f5983a.setImageBitmap(bitmapM24215a);
                }
            });
        }
        this.f5984b = bitmapM24215a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6217a(boolean z, ComboPreferences comboPreferences) {
        if (comboPreferences == null) {
            return;
        }
        CameraLog.m12954a("CameraWatermarkVisualPreference", "updateMakeupPreview, mDisplayBitmap: " + this.f5984b);
        if (this.f5984b == null) {
            if (this.f5991i == null) {
                this.f5991i = Util.m24217a(m3800K(), R.drawable.bg_watermark_makeup_visualization, 1.0f, Util.f22962a);
                this.f5991i.setDensity(m3800K().getResources().getDisplayMetrics().densityDpi);
            }
            BaseSloganUtil.COUIBaseListPopupWindow_8 eVar = new BaseSloganUtil.COUIBaseListPopupWindow_8();
            eVar.f12650a = new Size(this.f5991i.getWidth(), this.f5991i.getHeight());
            eVar.f12657h = true;
            BaseSloganUtil.PlatformImplementations.kt_3 aVarM11664a = BaseSloganUtil.m11664a(m3800K(), eVar, comboPreferences);
            if (aVarM11664a == null) {
                CameraLog.m12954a("CameraWatermarkVisualPreference", "updateMakeupPreview, hold is null");
                return;
            }
            Bitmap bitmapM24215a = Util.m24215a(this.f5991i.getWidth(), this.f5991i.getHeight(), Bitmap.Config.ARGB_8888);
            bitmapM24215a.setDensity(m3800K().getResources().getDisplayMetrics().densityDpi);
            aVarM11664a.m11720f().setDensity(m3800K().getResources().getDisplayMetrics().densityDpi);
            this.f5989g = new Canvas(bitmapM24215a);
            this.f5989g.drawBitmap(this.f5991i, 0.0f, 0.0f, this.f5988f);
            this.f5989g.drawBitmap(aVarM11664a.m11720f(), aVarM11664a.m11716d(), (this.f5991i.getHeight() - aVarM11664a.m11718e()) - aVarM11664a.m11720f().getHeight(), this.f5988f);
            this.f5984b = bitmapM24215a;
        }
        if (this.f5983a == null) {
            this.f5985c = true;
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f5983a.setImageBitmap(this.f5984b);
        } else {
            this.f5983a.post(new Runnable() { // from class: com.android.ui.menu.CameraWatermarkVisualPreference.2
                @Override // java.lang.Runnable
                public void run() {
                    CameraWatermarkVisualPreference.this.f5983a.setImageBitmap(CameraWatermarkVisualPreference.this.f5984b);
                }
            });
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6218e(boolean z) {
        this.f5987e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6208a(Bitmap bitmap, BaseSloganUtil.PlatformImplementations.kt_3 aVar) {
        m6213b(bitmap, aVar);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6213b(Bitmap bitmap, BaseSloganUtil.PlatformImplementations.kt_3 aVar) {
        this.f5989g.drawBitmap(this.f5991i, 0.0f, 0.0f, this.f5988f);
        if (aVar == null || bitmap == null) {
            return;
        }
        m6214c(bitmap, aVar);
        m6215d(bitmap, aVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap m6206a(com.oplus.camera.BaseSloganUtil.PlatformImplementations.kt_3 r11) {
        /*
            r10 = this;
            android.graphics.Bitmap r0 = r11.m11720f()
            int r0 = r0.getWidth()
            android.graphics.Bitmap r1 = r11.m11720f()
            int r1 = r1.getHeight()
            int r2 = r11.m11722g()
            int r3 = r11.m11722g()
            int r4 = r0 - r2
            int r5 = r1 - r3
            r6 = 1
            if (r4 == 0) goto Lb1
            if (r5 == 0) goto Lb1
            if (r1 == 0) goto Lb1
            if (r0 != 0) goto L27
            goto Lb1
        L27:
            java.lang.String r10 = r10.f5990h
            r7 = -1
            int r8 = r10.hashCode()
            r9 = 0
            switch(r8) {
                case -1580828439: goto L78;
                case -1364013995: goto L6e;
                case -1297425040: goto L65;
                case -1027670443: goto L5b;
                case -994491540: goto L51;
                case -264573066: goto L47;
                case 495696886: goto L3d;
                case 643307897: goto L33;
                default: goto L32;
            }
        L32:
            goto L82
        L33:
            java.lang.String r6 = "bottom_left_corner"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = r9
            goto L83
        L3d:
            java.lang.String r6 = "oplus_c_watermark_position"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 7
            goto L83
        L47:
            java.lang.String r6 = "oplus_left_bottom_watermark_position"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 6
            goto L83
        L51:
            java.lang.String r6 = "bottom_right_corner"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 2
            goto L83
        L5b:
            java.lang.String r6 = "upper_right_corner"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 3
            goto L83
        L65:
            java.lang.String r8 = "upper_left_corner"
            boolean r10 = r10.equals(r8)
            if (r10 == 0) goto L82
            goto L83
        L6e:
            java.lang.String r6 = "center"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 4
            goto L83
        L78:
            java.lang.String r6 = "bottom_center"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L82
            r6 = 5
            goto L83
        L82:
            r6 = r7
        L83:
            switch(r6) {
                case 0: goto La8;
                case 1: goto La8;
                case 2: goto L9f;
                case 3: goto L9f;
                case 4: goto L96;
                case 5: goto L91;
                case 6: goto L88;
                case 7: goto L88;
                default: goto L86;
            }
        L86:
            r10 = 0
            goto Lb0
        L88:
            android.graphics.Bitmap r10 = r11.m11720f()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r9, r9, r0, r1)
            goto Lb0
        L91:
            android.graphics.Bitmap r10 = r11.m11720f()
            goto Lb0
        L96:
            android.graphics.Bitmap r10 = r11.m11720f()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r9, r3, r0, r5)
            goto Lb0
        L9f:
            android.graphics.Bitmap r10 = r11.m11720f()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r9, r9, r4, r1)
            goto Lb0
        La8:
            android.graphics.Bitmap r10 = r11.m11720f()
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r2, r9, r4, r1)
        Lb0:
            return r10
        Lb1:
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r10 = com.oplus.camera.util.Util.m24215a(r6, r6, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.p093ui.menu.CameraWatermarkVisualPreference.m6206a(com.oplus.camera.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3):android.graphics.Bitmap");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6214c(android.graphics.Bitmap r10, com.oplus.camera.BaseSloganUtil.PlatformImplementations.kt_3 r11) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.p093ui.menu.CameraWatermarkVisualPreference.m6214c(android.graphics.Bitmap, com.oplus.camera.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6215d(android.graphics.Bitmap r9, com.oplus.camera.BaseSloganUtil.PlatformImplementations.kt_3 r10) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.p093ui.menu.CameraWatermarkVisualPreference.m6215d(android.graphics.Bitmap, com.oplus.camera.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3):void");
    }
}
