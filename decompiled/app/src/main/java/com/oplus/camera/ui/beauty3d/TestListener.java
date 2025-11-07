package com.oplus.camera.ui.beauty3d;

/* compiled from: Beauty3DUI.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f5941a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.beauty3d.f_renamed f5942b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.beauty3d.d_renamed f5943c = null;
    private com.oplus.camera.d_renamed.a_renamed d_renamed = null;
    private com.oplus.camera.ui.beauty3d.g_renamed.a_renamed e_renamed = null;
    private android.widget.RelativeLayout f_renamed = null;
    private android.view.ViewGroup g_renamed = null;
    private android.widget.PopupWindow h_renamed = null;
    private com.oplus.camera.ui.beauty3d.e_renamed i_renamed = new com.oplus.camera.ui.beauty3d.e_renamed() { // from class: com.oplus.camera.ui.beauty3d.g_renamed.1
        @Override // com.oplus.camera.ui.beauty3d.e_renamed
        public void a_renamed() {
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.a_renamed();
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.e_renamed
        public void b_renamed() {
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.b_renamed();
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.e_renamed
        public void a_renamed(java.lang.String str, int[] iArr) {
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.a_renamed(str, iArr);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.e_renamed
        public void a_renamed(boolean z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DUI", "onScanCancel, isUserCancel: " + z_renamed);
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.a_renamed(z_renamed);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.e_renamed
        public void c_renamed() {
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.i_renamed();
            }
        }
    };
    private com.oplus.camera.ui.beauty3d.i_renamed j_renamed = new com.oplus.camera.ui.beauty3d.i_renamed() { // from class: com.oplus.camera.ui.beauty3d.g_renamed.2
        @Override // com.oplus.camera.ui.beauty3d.i_renamed
        public void a_renamed(java.lang.String str, int[] iArr) {
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.a_renamed(str, iArr);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.i_renamed
        public void a_renamed() {
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.h_renamed();
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.c_renamed();
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.i_renamed
        public void b_renamed() {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DUI", "onSave");
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.d_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.d_renamed.d_renamed();
            }
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.e_renamed();
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.i_renamed
        public void c_renamed() {
            if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.d_renamed();
            }
        }
    };

    /* compiled from: Beauty3DUI.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(java.lang.String str, int[] iArr);

        void a_renamed(boolean z_renamed);

        void b_renamed();

        void c_renamed();

        void d_renamed();

        void e_renamed();

        void f_renamed();

        void g_renamed();

        void h_renamed();

        void i_renamed();
    }

    public g_renamed(android.app.Activity activity) {
        this.f5941a = null;
        this.f5941a = activity;
    }

    public void a_renamed(com.oplus.camera.ui.beauty3d.g_renamed.a_renamed aVar) {
        this.g_renamed = (android.view.ViewGroup) this.f5941a.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        this.f_renamed = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.f5941a.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        this.e_renamed = aVar;
        this.f5942b = new com.oplus.camera.ui.beauty3d.f_renamed(this.f5941a, this.f_renamed, this.g_renamed);
        this.f5942b.a_renamed(this.i_renamed);
        this.f5943c = new com.oplus.camera.ui.beauty3d.d_renamed(this.f5941a, this.j_renamed, this.f_renamed);
        this.d_renamed = new com.oplus.camera.d_renamed.a_renamed(this.f5941a, this.f5943c);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        if (this.f5942b.b_renamed()) {
            return;
        }
        this.f5942b.b_renamed(i_renamed, z_renamed, i2, i3);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.f5942b.a_renamed(i_renamed, z_renamed);
    }

    public void b_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        this.f5942b.a_renamed(i_renamed, z_renamed, i2, i3);
    }

    public void a_renamed(boolean z_renamed) {
        b_renamed(z_renamed);
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
        if (dVar != null) {
            dVar.b_renamed(i_renamed, this.d_renamed.a_renamed());
        }
        com.oplus.camera.ui.beauty3d.g_renamed.a_renamed aVar = this.e_renamed;
        if (aVar != null) {
            aVar.f_renamed();
        }
    }

    public void a_renamed() {
        com.oplus.camera.d_renamed.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.b_renamed();
        }
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
        if (dVar != null) {
            dVar.j_renamed();
        }
    }

    public void b_renamed() {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.a_renamed(0);
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.a_renamed(z_renamed, true);
        }
    }

    public boolean c_renamed() {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            return fVar.a_renamed();
        }
        return false;
    }

    public void d_renamed() {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null && fVar.b_renamed()) {
            this.f5942b.e_renamed();
        } else {
            com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
            if (dVar != null) {
                dVar.a_renamed(false);
            }
        }
        j_renamed();
    }

    public void e_renamed() {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.d_renamed();
        }
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
        if (dVar != null) {
            dVar.l_renamed();
        }
        this.f5942b = null;
        this.f5943c = null;
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.b_renamed(i_renamed);
        }
    }

    public void a_renamed(java.lang.String str, int[] iArr) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.d_renamed.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.a_renamed(str, iArr);
        }
    }

    public boolean b_renamed(int i_renamed) {
        com.oplus.camera.ui.beauty3d.d_renamed dVar;
        com.oplus.camera.e_renamed.a_renamed("Beauty3DUI", "onBackPressed, status: " + i_renamed);
        if (i_renamed >= 1 && i_renamed <= 4) {
            a_renamed(true);
            return true;
        }
        if (i_renamed <= 6 || i_renamed > 10 || (dVar = this.f5943c) == null || this.e_renamed == null) {
            return false;
        }
        dVar.a_renamed(true);
        this.e_renamed.d_renamed();
        return true;
    }

    public void c_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.c_renamed(i_renamed, z_renamed, i2, i3);
        }
    }

    public void a_renamed(java.lang.Integer num) {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.a_renamed(num);
        }
    }

    public void f_renamed() {
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
        if (dVar != null) {
            dVar.i_renamed();
        }
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
        if (dVar != null) {
            dVar.c_renamed(z_renamed);
        }
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.b_renamed(z_renamed);
        }
    }

    public java.util.HashMap<java.lang.String, int[]> g_renamed() {
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
        if (dVar != null) {
            return dVar.q_renamed();
        }
        return null;
    }

    public void h_renamed() {
        com.oplus.camera.d_renamed.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.e_renamed();
        }
    }

    public void i_renamed() {
        if (this.h_renamed == null) {
            this.h_renamed = a_renamed(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.g_renamed.3
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.oplus.camera.e_renamed.a_renamed("Beauty3DUI", "onClick, beauty3d edit");
                    com.oplus.camera.ui.beauty3d.g_renamed.this.j_renamed();
                    if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                        com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.g_renamed();
                    }
                }
            }, new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.g_renamed.4
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.oplus.camera.e_renamed.a_renamed("Beauty3DUI", "onClick, beauty3d data delete");
                    com.oplus.camera.ui.beauty3d.g_renamed.this.j_renamed();
                    if (com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed != null) {
                        com.oplus.camera.ui.beauty3d.g_renamed.this.e_renamed.h_renamed();
                    }
                }
            });
        }
        if (this.h_renamed.isShowing()) {
            return;
        }
        try {
            int screenWidth = (com.oplus.camera.util.Util.getScreenWidth() / 2) - (this.h_renamed.getWidth() / 2);
            if (screenWidth <= 0) {
                screenWidth = 0;
            }
            this.h_renamed.showAtLocation(this.g_renamed, 83, screenWidth, this.f5941a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_type_beauty3d_edit_offset_y));
        } catch (android.view.WindowManager.BadTokenException e_renamed) {
            if (this.h_renamed.isShowing()) {
                this.h_renamed.dismiss();
            }
            com.oplus.camera.e_renamed.e_renamed("Beauty3DUI", "showEditChooseMenu, exception: " + e_renamed.getMessage());
        }
    }

    public void j_renamed() {
        android.widget.PopupWindow popupWindow = this.h_renamed;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.h_renamed.dismiss();
    }

    private android.widget.PopupWindow a_renamed(android.view.View.OnClickListener onClickListener, android.view.View.OnClickListener onClickListener2) {
        android.view.View viewInflate = android.view.LayoutInflater.from(this.f5941a).inflate(com.oplus.camera.R_renamed.layout.beauty3d_edit_choose_menu, (android.view.ViewGroup) null);
        android.widget.ImageView imageView = (android.widget.ImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.edit);
        android.widget.ImageView imageView2 = (android.widget.ImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.delete);
        android.view.View.OnTouchListener onTouchListener = new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.g_renamed.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                if (!view.isEnabled()) {
                    return false;
                }
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    view.setAlpha(0.5f);
                } else if (actionMasked == 1) {
                    view.setAlpha(1.0f);
                }
                return false;
            }
        };
        imageView.setOnClickListener(onClickListener);
        imageView.setOnTouchListener(onTouchListener);
        imageView2.setOnClickListener(onClickListener2);
        imageView2.setOnTouchListener(onTouchListener);
        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(this.f5941a);
        popupWindow.setWidth(this.f5941a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.beauty3d_edit_choose_menu_width));
        popupWindow.setHeight(-2);
        popupWindow.setContentView(viewInflate);
        popupWindow.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable());
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(com.oplus.camera.R_renamed.style.PopupWindowStyle);
        return popupWindow;
    }

    public void e_renamed(final boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DUI", "enableEditChooseMenu enable: " + z_renamed);
        android.widget.PopupWindow popupWindow = this.h_renamed;
        if (popupWindow != null) {
            popupWindow.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.g_renamed.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return !z_renamed;
                }
            });
        }
    }

    public int k_renamed() {
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f5943c;
        if (dVar != null) {
            return dVar.o_renamed();
        }
        return 0;
    }

    public void l_renamed() {
        com.oplus.camera.ui.beauty3d.f_renamed fVar = this.f5942b;
        if (fVar != null) {
            fVar.h_renamed();
        }
    }
}
