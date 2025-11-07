package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class MultiFocusView extends android.view.View implements com.oplus.camera.ui.preview.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f6804a = {0, 0};
    private android.graphics.drawable.Drawable A_renamed;
    private java.util.concurrent.CopyOnWriteArrayList<android.graphics.RectF> B_renamed;
    private int[] C_renamed;
    private com.oplus.camera.gl_renamed.l_renamed D_renamed;
    private android.util.Size E_renamed;
    private com.oplus.camera.ui.preview.x_renamed F_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6805b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6806c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private boolean i_renamed;
    private float j_renamed;
    private int[] k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private java.util.ArrayList<java.lang.Integer> s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private int w_renamed;
    private android.graphics.Matrix x_renamed;
    private android.graphics.RectF y_renamed;
    private android.graphics.Rect z_renamed;

    public MultiFocusView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6805b = 0;
        this.f6806c = -1;
        this.d_renamed = 255;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 4;
        this.h_renamed = this.g_renamed / 2;
        this.i_renamed = true;
        this.j_renamed = 0.0f;
        this.k_renamed = null;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = null;
        this.t_renamed = 0;
        this.u_renamed = 0;
        this.v_renamed = 0;
        this.w_renamed = 0;
        this.x_renamed = new android.graphics.Matrix();
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.C_renamed = new int[]{0, 0};
        this.D_renamed = new com.oplus.camera.gl_renamed.l_renamed();
        this.E_renamed = null;
        this.F_renamed = new com.oplus.camera.ui.preview.x_renamed() { // from class: com.oplus.camera.ui.preview.MultiFocusView.2
            @Override // com.oplus.camera.ui.preview.x_renamed
            public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, boolean z_renamed) {
            }

            @Override // com.oplus.camera.ui.preview.x_renamed
            public void b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, boolean z_renamed) {
                if (com.oplus.camera.ui.preview.MultiFocusView.this.i_renamed) {
                    return;
                }
                if (z_renamed) {
                    com.oplus.camera.ui.preview.MultiFocusView.this.B_renamed.clear();
                }
                if (1 != com.oplus.camera.ui.preview.MultiFocusView.this.f6806c || com.oplus.camera.ui.preview.MultiFocusView.this.B_renamed.isEmpty()) {
                    return;
                }
                java.util.Iterator it = com.oplus.camera.ui.preview.MultiFocusView.this.B_renamed.iterator();
                while (it.hasNext()) {
                    com.oplus.camera.ui.preview.MultiFocusView.this.a_renamed(hVar, (android.graphics.RectF) it.next());
                }
            }
        };
        android.content.res.Resources resources = context.getResources();
        this.A_renamed = com.oplus.camera.util.Util.b_renamed(context, com.oplus.camera.R_renamed.drawable.icon_face_detecte);
        this.j_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.multi_focus_view_rect_space);
        this.f_renamed = com.oplus.camera.util.Util.A_renamed(context);
        this.y_renamed = new android.graphics.RectF();
        this.z_renamed = new android.graphics.Rect();
        this.s_renamed = new java.util.ArrayList<>();
        this.D_renamed.a_renamed(this.f_renamed);
        this.D_renamed.a_renamed(this.g_renamed);
    }

    public void a_renamed(int[] iArr, android.util.Size size) {
        if (this.i_renamed || iArr == null) {
            return;
        }
        int[] iArr2 = this.k_renamed;
        if (iArr2 == null || iArr2.length <= 0 || !java.util.Arrays.equals(iArr, iArr2)) {
            int[] iArr3 = this.k_renamed;
            if (iArr3 != null && iArr3.length > 0 && iArr[0] != iArr3[0]) {
                b_renamed();
            }
            this.k_renamed = iArr;
            if (iArr.length != 0) {
                switch (iArr[0]) {
                    case 2:
                    case 3:
                        this.f6806c = 0;
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        this.f6806c = 1;
                        break;
                    default:
                        this.f6806c = -1;
                        return;
                }
                this.x_renamed.reset();
                this.x_renamed.setTranslate((-getHeight()) / 2, (-getWidth()) / 2);
                this.x_renamed.postRotate(this.f6805b);
                this.x_renamed.postTranslate(getWidth() / 2, getHeight() / 2);
                int i_renamed = this.f6806c;
                if (i_renamed == 0) {
                    this.z_renamed.setEmpty();
                    this.B_renamed.clear();
                    float width = size.getHeight() != 0 ? getWidth() / size.getHeight() : 1.0f;
                    this.t_renamed = (int) (iArr[1] * width);
                    this.u_renamed = (int) (iArr[2] * width);
                    this.v_renamed = (int) (iArr[3] * width);
                    this.w_renamed = (int) (iArr[4] * width);
                    this.y_renamed.set(this.t_renamed, this.u_renamed, r12 + this.v_renamed, r1 + this.w_renamed);
                    this.x_renamed.mapRect(this.y_renamed);
                    this.y_renamed.round(this.z_renamed);
                } else if (1 == i_renamed) {
                    this.l_renamed = iArr[1];
                    this.m_renamed = iArr[2];
                    this.n_renamed = iArr[3];
                    this.o_renamed = iArr[4];
                    this.p_renamed = iArr[5];
                    this.q_renamed = iArr[6];
                    this.r_renamed = iArr[7];
                    if (this.m_renamed <= 0) {
                        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "setPosition, Face info is_renamed error");
                        return;
                    }
                    if (com.oplus.camera.util.Util.t_renamed() && getWidth() > 0) {
                        this.e_renamed = getWidth() / this.m_renamed;
                    } else {
                        this.e_renamed = com.oplus.camera.util.Util.getScreenWidth() / this.m_renamed;
                    }
                    this.s_renamed = a_renamed(this.r_renamed);
                    this.z_renamed.setEmpty();
                    this.B_renamed.clear();
                    java.util.Iterator<java.lang.Integer> it = this.s_renamed.iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        int i2 = this.n_renamed;
                        int i3 = this.p_renamed;
                        int i4 = this.e_renamed;
                        float f_renamed = this.j_renamed;
                        int i5 = this.o_renamed;
                        android.graphics.RectF rectF = new android.graphics.RectF((((iIntValue % (i3 - i2)) + i2) * i4) + f_renamed, (((iIntValue / (i3 - i2)) + i5) * i4) + f_renamed, ((((iIntValue % (i3 - i2)) + i2) + 1) * i4) - f_renamed, (((i5 + (iIntValue / (i3 - i2))) + 1) * i4) - f_renamed);
                        this.x_renamed.mapRect(rectF);
                        this.B_renamed.add(rectF);
                    }
                }
            }
            invalidate();
        }
    }

    public boolean a_renamed() {
        return 1 == this.f6806c;
    }

    public void setDisplayOrientation(int i_renamed) {
        this.f6805b = i_renamed;
        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "setDisplayOrientation, mDisplayOrientation: " + this.f6805b);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Rect rect;
        if (this.f6806c != 0 || (rect = this.z_renamed) == null) {
            return;
        }
        this.A_renamed.setBounds(rect);
        this.A_renamed.setAlpha(this.d_renamed);
        this.A_renamed.draw(canvas);
    }

    @Override // com.oplus.camera.ui.preview.m_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "showSuccess");
        invalidate();
    }

    public void b_renamed() {
        if (this.k_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "clear");
            if (this.k_renamed != null) {
                this.k_renamed = null;
            }
            android.graphics.Rect rect = this.z_renamed;
            if (rect != null) {
                rect.setEmpty();
            }
            android.graphics.RectF rectF = this.y_renamed;
            if (rectF != null) {
                rectF.setEmpty();
            }
            java.util.ArrayList<java.lang.Integer> arrayList = this.s_renamed;
            if (arrayList != null) {
                arrayList.clear();
            }
            android.graphics.Matrix matrix = this.x_renamed;
            if (matrix != null) {
                matrix.reset();
            }
            this.B_renamed.clear();
            this.f6806c = -1;
            postInvalidate();
        }
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", com.oplus.camera.statistics.model.VideoRecordMsgData.EVENT_PAUSE);
        b_renamed();
        this.i_renamed = true;
        this.C_renamed = f6804a;
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "resume");
        b_renamed();
        this.i_renamed = false;
        getLocationOnScreen(this.C_renamed);
        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "resume, x_renamed: " + this.C_renamed[0] + ", y_renamed: " + this.C_renamed[1]);
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "releaseMultiFocusView");
        b_renamed();
        this.i_renamed = true;
        if (this.A_renamed != null) {
            this.A_renamed = null;
        }
        if (this.x_renamed != null) {
            this.x_renamed = null;
        }
        if (this.k_renamed != null) {
            this.k_renamed = null;
        }
        if (this.y_renamed != null) {
            this.y_renamed = null;
        }
        if (this.z_renamed != null) {
            this.z_renamed = null;
        }
        java.util.ArrayList<java.lang.Integer> arrayList = this.s_renamed;
        if (arrayList != null) {
            arrayList.clear();
            this.s_renamed = null;
        }
    }

    public boolean f_renamed() {
        int[] iArr;
        return (this.i_renamed || (iArr = this.k_renamed) == null || iArr.length <= 0) ? false : true;
    }

    private java.util.ArrayList a_renamed(int i_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        while (i_renamed != 0) {
            if (1 == (i_renamed & 1)) {
                arrayList.add(java.lang.Integer.valueOf(i2));
            }
            i2++;
            i_renamed >>>= 1;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, android.graphics.RectF rectF) {
        android.graphics.PointF pointF = new android.graphics.PointF(this.C_renamed[0] + rectF.left, this.C_renamed[1] + rectF.top);
        android.graphics.PointF pointF2 = new android.graphics.PointF(pointF.x_renamed, pointF.y_renamed + rectF.height());
        android.graphics.PointF pointF3 = new android.graphics.PointF(pointF2.x_renamed + rectF.width(), pointF2.y_renamed);
        android.graphics.PointF pointF4 = new android.graphics.PointF(pointF3.x_renamed, pointF3.y_renamed - rectF.height());
        android.graphics.PointF pointF5 = new android.graphics.PointF(pointF4.x_renamed - rectF.width(), pointF4.y_renamed);
        if (a_renamed(pointF) && a_renamed(pointF2) && a_renamed(pointF2) && a_renamed(pointF3) && a_renamed(pointF3) && a_renamed(pointF4) && a_renamed(pointF4) && a_renamed(pointF5)) {
            hVar.a_renamed(pointF.x_renamed, pointF.y_renamed, pointF2.x_renamed, pointF2.y_renamed + this.h_renamed, this.D_renamed);
            hVar.a_renamed(pointF2.x_renamed, pointF2.y_renamed, pointF3.x_renamed + this.h_renamed, pointF3.y_renamed, this.D_renamed);
            hVar.a_renamed(pointF3.x_renamed, pointF3.y_renamed, pointF4.x_renamed, pointF4.y_renamed - this.h_renamed, this.D_renamed);
            hVar.a_renamed(pointF4.x_renamed, pointF4.y_renamed, pointF5.x_renamed - this.h_renamed, pointF5.y_renamed, this.D_renamed);
        }
    }

    protected com.oplus.camera.ui.preview.x_renamed getListener() {
        return this.F_renamed;
    }

    private boolean a_renamed(android.graphics.PointF pointF) {
        int[] iArr = this.C_renamed;
        int i_renamed = iArr[0];
        int i2 = iArr[1];
        return pointF.x_renamed >= ((float) i_renamed) && pointF.x_renamed <= ((float) (i_renamed + getWidth())) && pointF.y_renamed >= ((float) i2) && pointF.y_renamed <= ((float) (i2 + getHeight()));
    }

    public void g_renamed() {
        if (!this.i_renamed) {
            b_renamed();
            post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.MultiFocusView.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.preview.MultiFocusView multiFocusView = com.oplus.camera.ui.preview.MultiFocusView.this;
                    multiFocusView.getLocationOnScreen(multiFocusView.C_renamed);
                }
            });
        }
        com.oplus.camera.e_renamed.b_renamed("MultiFocusView", "onPreviewLayoutChanged, x_renamed: " + this.C_renamed[0] + ", y_renamed: " + this.C_renamed[1] + ", mbPause: " + this.i_renamed);
    }
}
