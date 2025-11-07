package com.oplus.camera.ui.widget;

/* compiled from: SlowVideoModeSeekBar.java */
/* loaded from: classes2.dex */
public class b_renamed extends android.view.View implements androidx.dynamicanimation.a_renamed.c_renamed.DynamicAnimation_3 {
    private android.graphics.PointF A_renamed;
    private com.oplus.camera.ui.widget.b_renamed.SlowVideoModeSeekBar_2 B_renamed;
    private androidx.dynamicanimation.a_renamed.f_renamed C_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7258a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7259b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7260c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private long t_renamed;
    private long u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;
    private android.graphics.Paint x_renamed;
    private java.util.List<com.oplus.camera.ui.widget.b_renamed.a_renamed> y_renamed;
    private java.util.List<android.graphics.PointF> z_renamed;

    /* compiled from: SlowVideoModeSeekBar.java */
    /* renamed from: com.oplus.camera.ui.widget.b_renamed$b_renamed, reason: collision with other inner class name */
    public interface SlowVideoModeSeekBar_2 {
        void onSlowVideoFrameChange(int i_renamed);
    }

    public b_renamed(android.content.Context context) {
        super(context);
        this.f7258a = 0;
        this.f7259b = 0;
        this.f7260c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = -1;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = 0;
        this.t_renamed = 0L;
        this.u_renamed = 0L;
        this.v_renamed = false;
        this.w_renamed = false;
        this.x_renamed = null;
        this.y_renamed = new java.util.ArrayList();
        this.z_renamed = new java.util.ArrayList();
        this.A_renamed = new android.graphics.PointF();
        this.B_renamed = null;
        this.C_renamed = null;
        a_renamed(context, (android.util.AttributeSet) null, 0);
    }

    private void a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        b_renamed(context, attributeSet, i_renamed);
    }

    private void b_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.SlowVideoModeSeekBar, i_renamed, 0);
        android.content.res.Resources resources = context.getResources();
        try {
            try {
                this.f7258a = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_line_width));
                this.f7259b = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_line_height));
                this.f7260c = typedArrayObtainStyledAttributes.getColor(11, context.getColor(com.oplus.camera.R_renamed.color.slow_video_seekbar_line_color));
                this.d_renamed = typedArrayObtainStyledAttributes.getInt(10, 76);
                this.e_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_node_unselected_size));
                this.f_renamed = typedArrayObtainStyledAttributes.getColor(6, context.getColor(com.oplus.camera.R_renamed.color.slow_video_seekbar_node_unselected_color));
                this.g_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_node_selected_outer_size));
                this.h_renamed = typedArrayObtainStyledAttributes.getColor(2, com.oplus.camera.util.Util.A_renamed(context));
                this.i_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_node_selected_inner_size));
                this.j_renamed = typedArrayObtainStyledAttributes.getColor(0, context.getColor(com.oplus.camera.R_renamed.color.slow_video_seekbar_node_selected_inner_color));
                this.k_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_node_unselected_text_size));
                this.l_renamed = typedArrayObtainStyledAttributes.getColor(8, context.getColor(com.oplus.camera.R_renamed.color.slow_video_seekbar_node_unselected_text_color));
                this.m_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_node_selected_text_size));
                this.n_renamed = typedArrayObtainStyledAttributes.getColor(4, com.oplus.camera.util.Util.A_renamed(context));
            } catch (android.content.res.Resources.NotFoundException e_renamed) {
                e_renamed.printStackTrace();
            }
            typedArrayObtainStyledAttributes.recycle();
            this.x_renamed = new android.graphics.Paint();
            this.x_renamed.setAntiAlias(true);
            this.x_renamed.setStyle(android.graphics.Paint.Style.FILL);
        } catch (java.lang.Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        this.A_renamed.x_renamed = getLineStartX() + (this.p_renamed * (this.f7258a / (this.y_renamed.size() - 1)));
        this.A_renamed.y_renamed = getLineStartY();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        a_renamed();
        c_renamed(canvas);
        b_renamed(canvas);
        a_renamed(canvas);
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        for (int i_renamed = 0; i_renamed < this.y_renamed.size(); i_renamed++) {
            if (b_renamed(i_renamed)) {
                this.x_renamed.setColor(this.n_renamed);
                this.x_renamed.setTextSize(this.m_renamed);
            } else {
                this.x_renamed.setColor(this.l_renamed);
                this.x_renamed.setTextSize(this.k_renamed);
            }
            java.lang.String strB = this.y_renamed.get(i_renamed).b_renamed();
            float fMeasureText = this.x_renamed.measureText(strB);
            android.graphics.Paint.FontMetrics fontMetrics = this.x_renamed.getFontMetrics();
            android.graphics.PointF pointF = this.z_renamed.get(i_renamed);
            float f_renamed = pointF.x_renamed - (fMeasureText / 2.0f);
            float dimension = pointF.y_renamed + getContext().getResources().getDimension(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_node_text_margin_top) + (this.f7259b >> 1);
            float f2 = dimension - fontMetrics.top;
            float f3 = pointF.x_renamed;
            float f4 = dimension + ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
            canvas.save();
            canvas.rotate(-this.r_renamed, f3, f4);
            canvas.drawText(strB, f_renamed, f2, this.x_renamed);
            canvas.restore();
        }
    }

    private boolean b_renamed(int i_renamed) {
        return this.p_renamed == i_renamed;
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        this.x_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.x_renamed.setAlpha(255);
        this.x_renamed.setColor(this.f_renamed);
        float lineStartX = getLineStartX();
        for (int i_renamed = 0; i_renamed < this.y_renamed.size(); i_renamed++) {
            float size = (i_renamed * (this.f7258a / (this.y_renamed.size() - 1))) + lineStartX;
            float lineStartY = getLineStartY();
            canvas.drawCircle(size, lineStartY, this.e_renamed >> 1, this.x_renamed);
            if (this.z_renamed.size() != this.y_renamed.size()) {
                this.z_renamed.add(new android.graphics.PointF(size, lineStartY));
            }
        }
        float f_renamed = this.A_renamed.x_renamed;
        float f2 = this.A_renamed.y_renamed;
        if (this.w_renamed) {
            this.x_renamed.setColor(this.f_renamed);
            canvas.drawCircle(f_renamed, f2, this.e_renamed >> 1, this.x_renamed);
        } else {
            this.x_renamed.setColor(this.h_renamed);
            canvas.drawCircle(f_renamed, f2, this.g_renamed >> 1, this.x_renamed);
            this.x_renamed.setColor(this.j_renamed);
            canvas.drawCircle(f_renamed, f2, this.i_renamed >> 1, this.x_renamed);
        }
    }

    private void c_renamed(android.graphics.Canvas canvas) {
        this.x_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.x_renamed.setStrokeWidth(this.f7259b);
        this.x_renamed.setColor(this.f7260c);
        this.x_renamed.setAlpha(this.d_renamed);
        float lineStartX = getLineStartX();
        float lineStartY = getLineStartY();
        canvas.drawLine(lineStartX, lineStartY, lineStartX + this.f7258a, lineStartY, this.x_renamed);
    }

    private float getLineStartY() {
        return getMeasuredHeight() * 0.26667f;
    }

    private int getLineStartX() {
        return (getMeasuredWidth() - this.f7258a) >> 1;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x0079  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.widget.b_renamed.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void a_renamed(float f_renamed, float f2) {
        androidx.dynamicanimation.a_renamed.f_renamed fVar = this.C_renamed;
        if (fVar != null) {
            fVar.b_renamed(this);
            this.C_renamed.b_renamed();
        }
        this.C_renamed = new androidx.dynamicanimation.a_renamed.f_renamed(new androidx.dynamicanimation.a_renamed.e_renamed(f_renamed));
        androidx.dynamicanimation.a_renamed.g_renamed gVar = new androidx.dynamicanimation.a_renamed.g_renamed(f2);
        gVar.a_renamed(1500.0f);
        gVar.b_renamed(0.5f);
        this.C_renamed.a_renamed(gVar);
        android.graphics.PointF pointF = this.z_renamed.get(0);
        android.graphics.PointF pointF2 = this.z_renamed.get(r4.size() - 1);
        this.C_renamed.e_renamed(pointF.x_renamed - this.e_renamed);
        this.C_renamed.f_renamed(pointF2.x_renamed + this.e_renamed);
        this.C_renamed.a_renamed(this);
        this.C_renamed.a_renamed();
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed.DynamicAnimation_3
    public void a_renamed(androidx.dynamicanimation.a_renamed.c_renamed cVar, float f_renamed, float f2) {
        this.A_renamed.x_renamed = f_renamed;
        postInvalidate();
    }

    private void a_renamed() {
        int i_renamed;
        if (this.r_renamed != this.s_renamed) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.u_renamed) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.t_renamed);
                int i3 = this.q_renamed;
                if (!this.v_renamed) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 > 0) {
                    i_renamed = i4 % 360;
                } else {
                    i_renamed = (i4 % 360) + 360;
                }
                this.r_renamed = i_renamed;
                invalidate();
                return;
            }
            this.r_renamed = this.s_renamed;
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2 = i_renamed > 0 ? i_renamed % 360 : (i_renamed % 360) + 360;
        if (i2 == this.s_renamed) {
            return;
        }
        this.s_renamed = i2;
        if (z_renamed) {
            this.q_renamed = this.r_renamed;
            this.t_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.s_renamed - this.r_renamed;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.v_renamed = i3 >= 0;
            this.u_renamed = this.t_renamed + ((java.lang.Math.abs(i3) * 1000) / 360);
        } else {
            this.r_renamed = this.q_renamed;
        }
        invalidate();
    }

    public void setFrameList(java.util.List<com.oplus.camera.ui.widget.b_renamed.a_renamed> list) {
        if (list != null && !list.isEmpty()) {
            this.z_renamed.clear();
            this.y_renamed.clear();
            this.y_renamed.addAll(list);
        }
        com.oplus.camera.e_renamed.b_renamed("SlowVideoModeSeekBar", "setFrameList: " + list);
    }

    public void a_renamed(int i_renamed) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.y_renamed.size()) {
                break;
            }
            if (this.y_renamed.get(i2).a_renamed() == i_renamed) {
                this.p_renamed = i2;
                this.o_renamed = this.y_renamed.get(this.p_renamed).a_renamed();
                break;
            }
            i2++;
        }
        int i3 = this.p_renamed;
        if (i3 < 0 || i3 >= this.y_renamed.size()) {
            this.p_renamed = this.y_renamed.size() - 1;
            this.o_renamed = this.y_renamed.get(this.p_renamed).a_renamed();
            com.oplus.camera.e_renamed.e_renamed("SlowVideoModeSeekBar", "updateSelectedFrame, default index not found, use last index");
        }
        com.oplus.camera.e_renamed.b_renamed("SlowVideoModeSeekBar", "updateSelectedFrame, frame: " + i_renamed + ", mSelectedIndex: " + this.p_renamed);
    }

    public void setModeFrameChangeListener(com.oplus.camera.ui.widget.b_renamed.SlowVideoModeSeekBar_2 interfaceC0135b) {
        this.B_renamed = interfaceC0135b;
    }

    /* compiled from: SlowVideoModeSeekBar.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f7261a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f7262b;

        public a_renamed(int i_renamed, java.lang.String str) {
            this.f7261a = 0;
            this.f7262b = "";
            this.f7261a = i_renamed;
            this.f7262b = str;
        }

        public int a_renamed() {
            return this.f7261a;
        }

        public java.lang.String b_renamed() {
            return this.f7262b;
        }
    }
}
