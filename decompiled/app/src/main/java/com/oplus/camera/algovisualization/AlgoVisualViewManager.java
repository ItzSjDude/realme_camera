package com.oplus.camera.algovisualization;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.IntentFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.util.Util;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.SystemPropertiesNative;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.ArrayList;

/* compiled from: AlgoVisualViewManager.java */
/* renamed from: com.oplus.camera.algovisualization.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class AlgoVisualViewManager implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f12441a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private OneCamera f12442b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TextView f12443c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f12444d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Button f12445e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Button f12446f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Button f12447g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private LinearLayout f12448h;

    /* renamed from: OplusGLSurfaceView_13 */
    private RelativeLayout f12449i;

    /* renamed from: OplusGLSurfaceView_15 */
    private VisualizationStatePreferenceHelper f12450j;

    /* renamed from: OplusGLSurfaceView_5 */
    private BatteryChangedReceiver f12451k;

    /* renamed from: OplusGLSurfaceView_14 */
    private IntentFilter f12452l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12453m = 500;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f12454n = 0;

    /* renamed from: o */
    private final int f12455o = 2;

    /* renamed from: p */
    private final int f12456p = 10;

    /* renamed from: q */
    private final int f12457q = 35;

    public AlgoVisualViewManager(Activity activity, OneCamera interfaceC2694d) {
        this.f12441a = activity;
        this.f12442b = interfaceC2694d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11607a() {
        m11611b();
        m11612c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11611b() {
        this.f12443c = (TextView) this.f12441a.findViewById(R.id_renamed.mTxtAlgoKey);
        this.f12444d = (TextView) this.f12441a.findViewById(R.id_renamed.mTxtAlgoValue);
        this.f12445e = (Button) this.f12441a.findViewById(R.id_renamed.mBtnVisualInterface);
        this.f12446f = (Button) this.f12441a.findViewById(R.id_renamed.mBtnVisualFunction);
        this.f12447g = (Button) this.f12441a.findViewById(R.id_renamed.mBtnPictureVisual);
        this.f12448h = (LinearLayout) this.f12441a.findViewById(R.id_renamed.basemode_display);
        this.f12449i = (RelativeLayout) this.f12441a.findViewById(R.id_renamed.camera_algo_visual_relativeLayout);
        this.f12443c.setEnabled(false);
        this.f12444d.setEnabled(false);
        this.f12448h.setEnabled(false);
        this.f12449i.setEnabled(false);
        this.f12450j = new VisualizationStatePreferenceHelper(this.f12441a);
        if (AuthenticationUtils.m11616a(this.f12450j.m11642d())) {
            this.f12450j.m11638b(false);
            this.f12450j.m11636a(false);
            this.f12450j.m11640c(false);
        }
        if (this.f12450j.m11639b()) {
            this.f12449i.setVisibility(0);
            this.f12449i.setEnabled(true);
            if (this.f12450j.m11637a()) {
                this.f12445e.setText(R.string.basemode_textview_close);
                this.f12448h.setVisibility(0);
                this.f12448h.setEnabled(true);
            } else {
                this.f12445e.setText(R.string.basemode_textview_open);
                this.f12448h.setVisibility(8);
                this.f12448h.setEnabled(false);
            }
            if (this.f12450j.m11641c()) {
                this.f12447g.setText(R.string.basemode_pic_textview_close);
                return;
            } else {
                this.f12447g.setText(R.string.basemode_pic_textview_open);
                return;
            }
        }
        this.f12449i.setVisibility(8);
        this.f12449i.setEnabled(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11612c() {
        this.f12445e.setOnClickListener(this);
        this.f12446f.setOnClickListener(this);
        this.f12447g.setOnClickListener(this);
        this.f12445e.setOnTouchListener(this);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11613d() {
        AlgoVisualAPSProcessor c2618b = new AlgoVisualAPSProcessor(this.f12442b, this.f12450j.m11637a(), this.f12450j.m11641c());
        c2618b.m11601a();
        c2618b.m11602b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11608a(Activity activity, final int OplusGLSurfaceView_13) {
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.algovisualization.IntrinsicsJvm.kt_3.1
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder("CameraID: ");
                AlgoVisualViewManager viewOnClickListenerC2619c = AlgoVisualViewManager.this;
                viewOnClickListenerC2619c.m11609a(viewOnClickListenerC2619c.f12443c, sb, null);
                StringBuilder sb2 = new StringBuilder(String.valueOf(OplusGLSurfaceView_13));
                AlgoVisualViewManager viewOnClickListenerC2619c2 = AlgoVisualViewManager.this;
                viewOnClickListenerC2619c2.m11609a(viewOnClickListenerC2619c2.f12444d, sb2, null);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11610a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str3, int OplusGLSurfaceView_13) {
        if (this.f12450j == null) {
            this.f12450j = new VisualizationStatePreferenceHelper(this.f12441a);
        }
        if (this.f12450j.m11637a()) {
            int iIntValue = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_FRAME_ID)).intValue();
            m11605e();
            int iM11620a = this.f12451k.m11620a();
            if (this.f12454n == iIntValue % 10) {
                try {
                    if (SystemPropertiesNative.getBoolean("show.preview.info", true)) {
                        this.f12441a.runOnUiThread(new PlatformImplementations.kt_3(str, str2, str3, iIntValue, iM11620a, arrayList, arrayList2, OplusGLSurfaceView_13));
                    }
                } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            m11606f();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m11605e() {
        if (this.f12451k == null) {
            this.f12451k = new BatteryChangedReceiver();
        }
        if (this.f12452l == null) {
            this.f12452l = new IntentFilter();
            this.f12452l.addAction("android.intent.action.BATTERY_CHANGED");
        }
        this.f12441a.registerReceiver(this.f12451k, this.f12452l);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m11606f() {
        BatteryChangedReceiver c2622f = this.f12451k;
        if (c2622f != null) {
            this.f12441a.unregisterReceiver(c2622f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11609a(TextView textView, StringBuilder sb, SpannableStringBuilder spannableStringBuilder) {
        textView.setTextSize(0, 35.0f);
        textView.setTypeface(Util.m24473l(this.f12441a));
        textView.setEnabled(true);
        textView.setTextColor(-1);
        if (spannableStringBuilder == null) {
            textView.setText(sb);
        }
        if (sb == null) {
            textView.setText(spannableStringBuilder);
        }
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"NonConstantResourceId"})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id_renamed.mBtnPictureVisual /* 2131296820 */:
                if (this.f12445e.getText().equals("off")) {
                    if (this.f12447g.getText().equals("PIC ON")) {
                        this.f12450j.m11640c(true);
                        this.f12447g.setText(R.string.basemode_pic_textview_close);
                        break;
                    } else {
                        this.f12450j.m11640c(false);
                        this.f12447g.setText(R.string.basemode_pic_textview_open);
                        break;
                    }
                }
                break;
            case R.id_renamed.mBtnVisualFunction /* 2131296821 */:
                this.f12450j.m11638b(false);
                this.f12450j.m11636a(false);
                this.f12450j.m11640c(false);
                this.f12448h.setVisibility(8);
                this.f12448h.setEnabled(false);
                this.f12449i.setVisibility(8);
                this.f12449i.setEnabled(false);
                break;
            case R.id_renamed.mBtnVisualInterface /* 2131296822 */:
                if (this.f12445e.getText().equals("on")) {
                    this.f12445e.setText(R.string.basemode_textview_close);
                    this.f12448h.setVisibility(0);
                    this.f12448h.setEnabled(true);
                    this.f12450j.m11636a(true);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(this.f12453m);
                    this.f12448h.setAnimation(alphaAnimation);
                    break;
                } else {
                    this.f12445e.setText(R.string.basemode_textview_open);
                    this.f12448h.setVisibility(8);
                    this.f12448h.setEnabled(false);
                    this.f12450j.m11636a(false);
                    if (this.f12447g.getText().equals("PIC OFF")) {
                        this.f12450j.m11640c(false);
                        this.f12447g.setText(R.string.basemode_pic_textview_open);
                    }
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation2.setDuration(this.f12453m);
                    this.f12448h.setAnimation(alphaAnimation2);
                    break;
                }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) != 2) {
            return false;
        }
        float x = this.f12445e.getX();
        float y = this.f12445e.getY() + this.f12445e.getHeight();
        float y2 = this.f12445e.getY();
        float x2 = this.f12445e.getX() + this.f12445e.getWidth();
        float x3 = this.f12445e.getX() + (this.f12445e.getWidth() * 2);
        this.f12448h.setY(y);
        this.f12448h.setX(x);
        this.f12447g.setY(y2);
        this.f12447g.setX(x2);
        this.f12446f.setY(y2);
        this.f12446f.setX(x3);
        return false;
    }

    /* compiled from: AlgoVisualViewManager.java */
    /* renamed from: com.oplus.camera.algovisualization.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f12461b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private String f12462c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f12463d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f12464e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f12465f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f12466g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private ArrayList<String> f12467h;

        /* renamed from: OplusGLSurfaceView_13 */
        private ArrayList<String> f12468i;

        /* renamed from: OplusGLSurfaceView_15 */
        private final int f12469j = 0;

        /* renamed from: OplusGLSurfaceView_5 */
        private final int f12470k = 1;

        public PlatformImplementations.kt_3(String str, String str2, String str3, int OplusGLSurfaceView_13, int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i3) {
            this.f12461b = str;
            this.f12462c = str2;
            this.f12463d = str3;
            this.f12464e = OplusGLSurfaceView_13;
            this.f12465f = i2;
            this.f12467h = arrayList;
            this.f12468i = arrayList2;
            this.f12466g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlgoVisualViewManager.this.f12443c != null) {
                ArrayList<SpannableStringBuilder> arrayListM11597a = AlgoListProcessor.m11597a(this.f12461b, this.f12462c, this.f12467h, this.f12468i, this.f12465f, this.f12463d, String.valueOf(this.f12464e), this.f12466g);
                if (arrayListM11597a.isEmpty()) {
                    return;
                }
                if (!TextUtils.isEmpty(arrayListM11597a.get(0))) {
                    CameraLog.m12959b("AlgoVisualViewManager", "visualViewRunnable, algo key: " + ((Object) arrayListM11597a.get(0)));
                    AlgoVisualViewManager viewOnClickListenerC2619c = AlgoVisualViewManager.this;
                    viewOnClickListenerC2619c.m11609a(viewOnClickListenerC2619c.f12443c, null, arrayListM11597a.get(0));
                }
                if (TextUtils.isEmpty(arrayListM11597a.get(1))) {
                    return;
                }
                CameraLog.m12959b("AlgoVisualViewManager", "visualViewRunnable, algo value: " + ((Object) arrayListM11597a.get(1)));
                AlgoVisualViewManager viewOnClickListenerC2619c2 = AlgoVisualViewManager.this;
                viewOnClickListenerC2619c2.m11609a(viewOnClickListenerC2619c2.f12444d, null, arrayListM11597a.get(1));
            }
        }
    }
}
