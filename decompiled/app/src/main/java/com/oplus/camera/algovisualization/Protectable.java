package com.oplus.camera.algovisualization;

/* compiled from: AlgoVisualViewManager.java */
/* loaded from: classes2.dex */
public class c_renamed implements android.view.View.OnClickListener, android.view.View.OnTouchListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f4145a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.e_renamed.d_renamed f4146b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.TextView f4147c;
    private android.widget.TextView d_renamed;
    private android.widget.Button e_renamed;
    private android.widget.Button f_renamed;
    private android.widget.Button g_renamed;
    private android.widget.LinearLayout h_renamed;
    private android.widget.RelativeLayout i_renamed;
    private com.oplus.camera.algovisualization.j_renamed j_renamed;
    private com.oplus.camera.algovisualization.f_renamed k_renamed;
    private android.content.IntentFilter l_renamed;
    private int m_renamed = 500;
    private int n_renamed = 0;
    private final int o_renamed = 2;
    private final int p_renamed = 10;
    private final int q_renamed = 35;

    public c_renamed(android.app.Activity activity, com.oplus.camera.e_renamed.d_renamed dVar) {
        this.f4145a = activity;
        this.f4146b = dVar;
    }

    public void a_renamed() {
        b_renamed();
        c_renamed();
    }

    public void b_renamed() {
        this.f4147c = (android.widget.TextView) this.f4145a.findViewById(com.oplus.camera.R_renamed.id_renamed.mTxtAlgoKey);
        this.d_renamed = (android.widget.TextView) this.f4145a.findViewById(com.oplus.camera.R_renamed.id_renamed.mTxtAlgoValue);
        this.e_renamed = (android.widget.Button) this.f4145a.findViewById(com.oplus.camera.R_renamed.id_renamed.mBtnVisualInterface);
        this.f_renamed = (android.widget.Button) this.f4145a.findViewById(com.oplus.camera.R_renamed.id_renamed.mBtnVisualFunction);
        this.g_renamed = (android.widget.Button) this.f4145a.findViewById(com.oplus.camera.R_renamed.id_renamed.mBtnPictureVisual);
        this.h_renamed = (android.widget.LinearLayout) this.f4145a.findViewById(com.oplus.camera.R_renamed.id_renamed.basemode_display);
        this.i_renamed = (android.widget.RelativeLayout) this.f4145a.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_algo_visual_relativeLayout);
        this.f4147c.setEnabled(false);
        this.d_renamed.setEnabled(false);
        this.h_renamed.setEnabled(false);
        this.i_renamed.setEnabled(false);
        this.j_renamed = new com.oplus.camera.algovisualization.j_renamed(this.f4145a);
        if (com.oplus.camera.algovisualization.e_renamed.a_renamed(this.j_renamed.d_renamed())) {
            this.j_renamed.b_renamed(false);
            this.j_renamed.a_renamed(false);
            this.j_renamed.c_renamed(false);
        }
        if (this.j_renamed.b_renamed()) {
            this.i_renamed.setVisibility(0);
            this.i_renamed.setEnabled(true);
            if (this.j_renamed.a_renamed()) {
                this.e_renamed.setText(com.oplus.camera.R_renamed.string.basemode_textview_close);
                this.h_renamed.setVisibility(0);
                this.h_renamed.setEnabled(true);
            } else {
                this.e_renamed.setText(com.oplus.camera.R_renamed.string.basemode_textview_open);
                this.h_renamed.setVisibility(8);
                this.h_renamed.setEnabled(false);
            }
            if (this.j_renamed.c_renamed()) {
                this.g_renamed.setText(com.oplus.camera.R_renamed.string.basemode_pic_textview_close);
                return;
            } else {
                this.g_renamed.setText(com.oplus.camera.R_renamed.string.basemode_pic_textview_open);
                return;
            }
        }
        this.i_renamed.setVisibility(8);
        this.i_renamed.setEnabled(false);
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void c_renamed() {
        this.e_renamed.setOnClickListener(this);
        this.f_renamed.setOnClickListener(this);
        this.g_renamed.setOnClickListener(this);
        this.e_renamed.setOnTouchListener(this);
    }

    public void d_renamed() {
        com.oplus.camera.algovisualization.b_renamed bVar = new com.oplus.camera.algovisualization.b_renamed(this.f4146b, this.j_renamed.a_renamed(), this.j_renamed.c_renamed());
        bVar.a_renamed();
        bVar.b_renamed();
    }

    public void a_renamed(android.app.Activity activity, final int i_renamed) {
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.algovisualization.c_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("CameraID: ");
                com.oplus.camera.algovisualization.c_renamed cVar = com.oplus.camera.algovisualization.c_renamed.this;
                cVar.a_renamed(cVar.f4147c, sb, null);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(i_renamed));
                com.oplus.camera.algovisualization.c_renamed cVar2 = com.oplus.camera.algovisualization.c_renamed.this;
                cVar2.a_renamed(cVar2.d_renamed, sb2, null);
            }
        });
    }

    public void a_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, java.lang.String str, java.lang.String str2, java.util.ArrayList<java.lang.String> arrayList, java.util.ArrayList<java.lang.String> arrayList2, java.lang.String str3, int i_renamed) {
        if (this.j_renamed == null) {
            this.j_renamed = new com.oplus.camera.algovisualization.j_renamed(this.f4145a);
        }
        if (this.j_renamed.a_renamed()) {
            int iIntValue = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_FRAME_ID)).intValue();
            e_renamed();
            int iA = this.k_renamed.a_renamed();
            if (this.n_renamed == iIntValue % 10) {
                try {
                    if (com.oplus.compat.os.SystemPropertiesNative.getBoolean("show.preview.info", true)) {
                        this.f4145a.runOnUiThread(new com.oplus.camera.algovisualization.c_renamed.a_renamed(str, str2, str3, iIntValue, iA, arrayList, arrayList2, i_renamed));
                    }
                } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
            f_renamed();
        }
    }

    private void e_renamed() {
        if (this.k_renamed == null) {
            this.k_renamed = new com.oplus.camera.algovisualization.f_renamed();
        }
        if (this.l_renamed == null) {
            this.l_renamed = new android.content.IntentFilter();
            this.l_renamed.addAction("android.intent.action.BATTERY_CHANGED");
        }
        this.f4145a.registerReceiver(this.k_renamed, this.l_renamed);
    }

    private void f_renamed() {
        com.oplus.camera.algovisualization.f_renamed fVar = this.k_renamed;
        if (fVar != null) {
            this.f4145a.unregisterReceiver(fVar);
        }
    }

    public void a_renamed(android.widget.TextView textView, java.lang.StringBuilder sb, android.text.SpannableStringBuilder spannableStringBuilder) {
        textView.setTextSize(0, 35.0f);
        textView.setTypeface(com.oplus.camera.util.Util.l_renamed(this.f4145a));
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
    @android.annotation.SuppressLint({"NonConstantResourceId"})
    public void onClick(android.view.View view) {
        switch (view.getId()) {
            case com.oplus.camera.R_renamed.id_renamed.mBtnPictureVisual /* 2131296820 */:
                if (this.e_renamed.getText().equals("off")) {
                    if (this.g_renamed.getText().equals("PIC ON_renamed")) {
                        this.j_renamed.c_renamed(true);
                        this.g_renamed.setText(com.oplus.camera.R_renamed.string.basemode_pic_textview_close);
                        break;
                    } else {
                        this.j_renamed.c_renamed(false);
                        this.g_renamed.setText(com.oplus.camera.R_renamed.string.basemode_pic_textview_open);
                        break;
                    }
                }
                break;
            case com.oplus.camera.R_renamed.id_renamed.mBtnVisualFunction /* 2131296821 */:
                this.j_renamed.b_renamed(false);
                this.j_renamed.a_renamed(false);
                this.j_renamed.c_renamed(false);
                this.h_renamed.setVisibility(8);
                this.h_renamed.setEnabled(false);
                this.i_renamed.setVisibility(8);
                this.i_renamed.setEnabled(false);
                break;
            case com.oplus.camera.R_renamed.id_renamed.mBtnVisualInterface /* 2131296822 */:
                if (this.e_renamed.getText().equals("on_renamed")) {
                    this.e_renamed.setText(com.oplus.camera.R_renamed.string.basemode_textview_close);
                    this.h_renamed.setVisibility(0);
                    this.h_renamed.setEnabled(true);
                    this.j_renamed.a_renamed(true);
                    android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(this.m_renamed);
                    this.h_renamed.setAnimation(alphaAnimation);
                    break;
                } else {
                    this.e_renamed.setText(com.oplus.camera.R_renamed.string.basemode_textview_open);
                    this.h_renamed.setVisibility(8);
                    this.h_renamed.setEnabled(false);
                    this.j_renamed.a_renamed(false);
                    if (this.g_renamed.getText().equals("PIC OFF")) {
                        this.j_renamed.c_renamed(false);
                        this.g_renamed.setText(com.oplus.camera.R_renamed.string.basemode_pic_textview_open);
                    }
                    android.view.animation.AlphaAnimation alphaAnimation2 = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation2.setDuration(this.m_renamed);
                    this.h_renamed.setAnimation(alphaAnimation2);
                    break;
                }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) != 2) {
            return false;
        }
        float x_renamed = this.e_renamed.getX();
        float y_renamed = this.e_renamed.getY() + this.e_renamed.getHeight();
        float y2 = this.e_renamed.getY();
        float x2 = this.e_renamed.getX() + this.e_renamed.getWidth();
        float x3 = this.e_renamed.getX() + (this.e_renamed.getWidth() * 2);
        this.h_renamed.setY(y_renamed);
        this.h_renamed.setX(x_renamed);
        this.g_renamed.setY(y2);
        this.g_renamed.setX(x2);
        this.f_renamed.setY(y2);
        this.f_renamed.setX(x3);
        return false;
    }

    /* compiled from: AlgoVisualViewManager.java */
    class a_renamed implements java.lang.Runnable {

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f4151b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.lang.String f4152c;
        private java.lang.String d_renamed;
        private int e_renamed;
        private int f_renamed;
        private int g_renamed;
        private java.util.ArrayList<java.lang.String> h_renamed;
        private java.util.ArrayList<java.lang.String> i_renamed;
        private final int j_renamed = 0;
        private final int k_renamed = 1;

        public a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, java.util.ArrayList<java.lang.String> arrayList, java.util.ArrayList<java.lang.String> arrayList2, int i3) {
            this.f4151b = str;
            this.f4152c = str2;
            this.d_renamed = str3;
            this.e_renamed = i_renamed;
            this.f_renamed = i2;
            this.h_renamed = arrayList;
            this.i_renamed = arrayList2;
            this.g_renamed = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.oplus.camera.algovisualization.c_renamed.this.f4147c != null) {
                java.util.ArrayList<android.text.SpannableStringBuilder> arrayListA = com.oplus.camera.algovisualization.a_renamed.a_renamed(this.f4151b, this.f4152c, this.h_renamed, this.i_renamed, this.f_renamed, this.d_renamed, java.lang.String.valueOf(this.e_renamed), this.g_renamed);
                if (arrayListA.isEmpty()) {
                    return;
                }
                if (!android.text.TextUtils.isEmpty(arrayListA.get(0))) {
                    com.oplus.camera.e_renamed.b_renamed("AlgoVisualViewManager", "visualViewRunnable, algo key: " + ((java.lang.Object) arrayListA.get(0)));
                    com.oplus.camera.algovisualization.c_renamed cVar = com.oplus.camera.algovisualization.c_renamed.this;
                    cVar.a_renamed(cVar.f4147c, null, arrayListA.get(0));
                }
                if (android.text.TextUtils.isEmpty(arrayListA.get(1))) {
                    return;
                }
                com.oplus.camera.e_renamed.b_renamed("AlgoVisualViewManager", "visualViewRunnable, algo value: " + ((java.lang.Object) arrayListA.get(1)));
                com.oplus.camera.algovisualization.c_renamed cVar2 = com.oplus.camera.algovisualization.c_renamed.this;
                cVar2.a_renamed(cVar2.d_renamed, null, arrayListA.get(1));
            }
        }
    }
}
