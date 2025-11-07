package com.oplus.camera.t_renamed;

/* compiled from: StreetTrackLayout.java */
/* loaded from: classes2.dex */
public class h_renamed extends android.widget.RelativeLayout implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.view.View.OnTouchListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5619a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5620b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5621c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private float i_renamed;
    private float j_renamed;
    private float k_renamed;
    private float l_renamed;
    private double m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private com.oplus.camera.ui.control.MainShutterButton s_renamed;
    private com.oplus.camera.t_renamed.h_renamed.a_renamed t_renamed;
    private android.graphics.Paint u_renamed;
    private com.oplus.camera.t_renamed.h_renamed.b_renamed v_renamed;

    /* compiled from: StreetTrackLayout.java */
    interface b_renamed {
        void a_renamed();

        void a_renamed(int i_renamed);

        boolean b_renamed();

        void c_renamed();

        void d_renamed();

        void e_renamed();
    }

    public h_renamed(android.content.Context context) {
        super(context);
        this.f5619a = 0;
        this.f5620b = 0;
        this.f5621c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = -1;
        this.h_renamed = 0;
        this.i_renamed = -1.0f;
        this.j_renamed = -1.0f;
        this.k_renamed = 0.0f;
        this.l_renamed = 0.0f;
        this.m_renamed = 0.0d;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = true;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.f5620b = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_button_size) / 2;
        this.f5619a = (context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height) / 2) - this.f5620b;
        this.e_renamed = (this.f5619a * 2) / 20;
        this.m_renamed = java.lang.Math.tan(java.lang.Math.toRadians(20.0d));
        this.s_renamed = (com.oplus.camera.ui.control.MainShutterButton) ((android.app.Activity) getContext()).findViewById(com.oplus.camera.R_renamed.id_renamed.shutter_button);
        g_renamed();
        setOnClickListener(this);
        setOnLongClickListener(this);
        setOnTouchListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        com.oplus.camera.e_renamed.a_renamed("StreetTrackLayout", "onLongClick");
        com.oplus.camera.t_renamed.h_renamed.b_renamed bVar = this.v_renamed;
        if (bVar != null && bVar.b_renamed()) {
            this.r_renamed = false;
            this.s_renamed.setPressed(false);
            return true;
        }
        this.r_renamed = true;
        this.s_renamed.setVisibility(4);
        a_renamed();
        com.oplus.camera.t_renamed.h_renamed.b_renamed bVar2 = this.v_renamed;
        if (bVar2 != null) {
            bVar2.c_renamed();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.oplus.camera.t_renamed.h_renamed.b_renamed bVar = this.v_renamed;
        if (bVar != null) {
            bVar.a_renamed();
        }
    }

    private int a_renamed(float f_renamed, float f2, float f3, float f4) {
        float fAbs = java.lang.Math.abs(f_renamed - f3);
        float fAbs2 = java.lang.Math.abs(f2 - f4);
        int i_renamed = this.e_renamed;
        if (fAbs < i_renamed && fAbs2 < i_renamed) {
            return -1;
        }
        this.i_renamed = f_renamed;
        this.j_renamed = f2;
        if (0.0f == fAbs || 0.0f == fAbs2) {
            if (0.0f == fAbs) {
                this.g_renamed = f2 >= f4 ? 1 : 0;
            } else if (0.0f == fAbs2) {
                this.g_renamed = f_renamed >= f3 ? 3 : 2;
            }
            return this.g_renamed;
        }
        if (f_renamed <= f3 && f2 < f4) {
            double d_renamed = fAbs2 / fAbs;
            double d2 = this.m_renamed;
            if (d_renamed < d2) {
                this.g_renamed = 2;
            } else if (fAbs / fAbs2 < d2) {
                this.g_renamed = 0;
            }
        } else if (f_renamed > f3 && f2 <= f4) {
            double d3 = fAbs2 / fAbs;
            double d4 = this.m_renamed;
            if (d3 < d4) {
                this.g_renamed = 3;
            } else if (fAbs / fAbs2 < d4) {
                this.g_renamed = 0;
            }
        } else if (f_renamed < f3 && f2 >= f4) {
            double d5 = fAbs2 / fAbs;
            double d6 = this.m_renamed;
            if (d5 < d6) {
                this.g_renamed = 2;
            } else if (fAbs / fAbs2 < d6) {
                this.g_renamed = 1;
            }
        } else if (f_renamed >= f3 && f2 > f4) {
            double d7 = fAbs2 / fAbs;
            double d8 = this.m_renamed;
            if (d7 < d8) {
                this.g_renamed = 3;
            } else if (fAbs / fAbs2 < d8) {
                this.g_renamed = 1;
            }
        }
        return this.g_renamed;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        if (this.p_renamed) {
            this.f5621c = getWidth() / 2;
            this.d_renamed = getHeight() / 2;
        }
    }

    public void a_renamed() {
        this.p_renamed = true;
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height), getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height)));
        c_renamed();
        b_renamed(this.k_renamed, this.l_renamed);
        h_renamed();
        d_renamed();
    }

    private void b_renamed(float f_renamed, float f2) {
        if (this.t_renamed != null) {
            int i_renamed = this.f5620b;
            this.t_renamed.setX(((f_renamed + (getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height) / 2)) - (getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length) / 2)) - i_renamed);
            this.t_renamed.setY(((f2 + (getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height) / 2)) - (getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length) / 2)) - i_renamed);
        }
    }

    public void b_renamed() {
        this.p_renamed = false;
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length), getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length)));
        c_renamed();
        i_renamed();
        e_renamed();
    }

    public void c_renamed() {
        int[] iArr = new int[2];
        this.s_renamed.getLocationInWindow(iArr);
        float width = (iArr[0] + (this.s_renamed.getWidth() / 2)) - (getLayoutParams().width / 2);
        float height = (iArr[1] + (this.s_renamed.getHeight() / 2)) - (getLayoutParams().height / 2);
        setX(width);
        setY(height);
    }

    public boolean a_renamed(float f_renamed, float f2) {
        return java.lang.Math.sqrt(java.lang.Math.pow((double) java.lang.Math.abs(((float) this.f5621c) - f_renamed), 2.0d) + java.lang.Math.pow((double) java.lang.Math.abs(((float) this.d_renamed) - f2), 2.0d)) <= ((double) this.f5619a);
    }

    private void g_renamed() {
        if (this.t_renamed == null) {
            this.t_renamed = new com.oplus.camera.t_renamed.h_renamed.a_renamed(getContext());
            int i_renamed = this.f5620b;
            this.t_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(i_renamed * 2, i_renamed * 2));
            addView(this.t_renamed);
        }
    }

    private void h_renamed() {
        com.oplus.camera.t_renamed.h_renamed.a_renamed aVar = this.t_renamed;
        if (aVar != null) {
            aVar.setVisibility(0);
        }
    }

    private void i_renamed() {
        com.oplus.camera.t_renamed.h_renamed.a_renamed aVar = this.t_renamed;
        if (aVar != null) {
            aVar.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.n_renamed) {
            a_renamed(canvas);
        }
    }

    public void a_renamed(android.graphics.Canvas canvas) {
        if (this.u_renamed == null) {
            this.u_renamed = new android.graphics.Paint();
            this.u_renamed.setAntiAlias(true);
        }
        this.u_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.street_trace_layout_background_color));
        this.u_renamed.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f5619a, this.u_renamed);
        this.u_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.street_trace_layout_background_edge_color));
        this.u_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.u_renamed.setStrokeWidth(2.0f);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f5619a + 1, this.u_renamed);
    }

    public void d_renamed() {
        this.n_renamed = true;
        setAlpha(0.8f);
        setBackgroundColor(0);
    }

    public void e_renamed() {
        this.n_renamed = false;
        setBackgroundColor(0);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:59:0x012e  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.t_renamed.h_renamed.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void j_renamed() {
        this.s_renamed.setPressed(false);
        this.s_renamed.setVisibility(0);
        this.s_renamed.performClick();
    }

    private int a_renamed(int i_renamed, float f_renamed, float f2) {
        int i2;
        int i3;
        if (-1 == i_renamed && (((2 == (i2 = this.g_renamed) || 3 == i2) && f_renamed > f2) || (((i3 = this.g_renamed) == 0 || 1 == i3) && f_renamed < f2))) {
            return this.h_renamed;
        }
        if (2 == this.h_renamed && 3 == i_renamed) {
            this.h_renamed = 2;
        } else if (3 == this.h_renamed && 2 == i_renamed) {
            this.h_renamed = 3;
        } else if (this.h_renamed == 0 && 1 == i_renamed) {
            this.h_renamed = 0;
        } else if (1 == this.h_renamed && i_renamed == 0) {
            this.h_renamed = 1;
        } else {
            this.h_renamed = i_renamed;
        }
        return this.h_renamed;
    }

    public boolean f_renamed() {
        return this.p_renamed;
    }

    /* compiled from: StreetTrackLayout.java */
    class a_renamed extends android.widget.ImageView {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.graphics.Paint f5623b;

        public a_renamed(android.content.Context context) {
            super(context);
            this.f5623b = new android.graphics.Paint();
            this.f5623b.setAntiAlias(true);
            this.f5623b.setColor(getContext().getColor(com.oplus.camera.R_renamed.color.street_trace_button_background_color));
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(android.graphics.Canvas canvas) {
            super.onDraw(canvas);
            a_renamed(canvas);
        }

        private void a_renamed(android.graphics.Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.f5623b);
        }
    }

    public int getTrackMaxRadius() {
        return this.f5619a;
    }

    public void setTrackListener(com.oplus.camera.t_renamed.h_renamed.b_renamed bVar) {
        this.v_renamed = bVar;
    }
}
