package androidx.transition;

/* compiled from: ViewOverlayApi14.java */
/* loaded from: classes.dex */
class aa_renamed implements androidx.transition.ac_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected androidx.transition.aa_renamed.a_renamed f1661a;

    aa_renamed(android.content.Context context, android.view.ViewGroup viewGroup, android.view.View view) {
        this.f1661a = new androidx.transition.aa_renamed.a_renamed(context, viewGroup, view, this);
    }

    static android.view.ViewGroup c_renamed(android.view.View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof android.view.ViewGroup)) {
                return (android.view.ViewGroup) view;
            }
            if (view.getParent() instanceof android.view.ViewGroup) {
                view = (android.view.ViewGroup) view.getParent();
            }
        }
        return null;
    }

    static androidx.transition.aa_renamed d_renamed(android.view.View view) {
        android.view.ViewGroup viewGroupC = c_renamed(view);
        if (viewGroupC == null) {
            return null;
        }
        int childCount = viewGroupC.getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = viewGroupC.getChildAt(i_renamed);
            if (childAt instanceof androidx.transition.aa_renamed.a_renamed) {
                return ((androidx.transition.aa_renamed.a_renamed) childAt).e_renamed;
            }
        }
        return new androidx.transition.v_renamed(viewGroupC.getContext(), viewGroupC, view);
    }

    @Override // androidx.transition.ac_renamed
    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.f1661a.a_renamed(drawable);
    }

    @Override // androidx.transition.ac_renamed
    public void b_renamed(android.graphics.drawable.Drawable drawable) {
        this.f1661a.b_renamed(drawable);
    }

    /* compiled from: ViewOverlayApi14.java */
    static class a_renamed extends android.view.ViewGroup {

        /* renamed from: a_renamed, reason: collision with root package name */
        static java.lang.reflect.Method f1662a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.view.ViewGroup f1663b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.view.View f1664c;
        java.util.ArrayList<android.graphics.drawable.Drawable> d_renamed;
        androidx.transition.aa_renamed e_renamed;
        private boolean f_renamed;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        }

        static {
            try {
                f1662a = android.view.ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", java.lang.Integer.TYPE, java.lang.Integer.TYPE, android.graphics.Rect.class);
            } catch (java.lang.NoSuchMethodException unused) {
            }
        }

        a_renamed(android.content.Context context, android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.aa_renamed aaVar) {
            super(context);
            this.d_renamed = null;
            this.f1663b = viewGroup;
            this.f1664c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.e_renamed = aaVar;
        }

        public void a_renamed(android.graphics.drawable.Drawable drawable) {
            a_renamed();
            if (this.d_renamed == null) {
                this.d_renamed = new java.util.ArrayList<>();
            }
            if (this.d_renamed.contains(drawable)) {
                return;
            }
            this.d_renamed.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b_renamed(android.graphics.drawable.Drawable drawable) {
            java.util.ArrayList<android.graphics.drawable.Drawable> arrayList = this.d_renamed;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                b_renamed();
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
            java.util.ArrayList<android.graphics.drawable.Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.d_renamed) != null && arrayList.contains(drawable));
        }

        public void a_renamed(android.view.View view) {
            a_renamed();
            if (view.getParent() instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
                if (viewGroup != this.f1663b && viewGroup.getParent() != null && androidx.core.h_renamed.v_renamed.D_renamed(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f1663b.getLocationOnScreen(iArr2);
                    androidx.core.h_renamed.v_renamed.f_renamed(view, iArr[0] - iArr2[0]);
                    androidx.core.h_renamed.v_renamed.e_renamed(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public void b_renamed(android.view.View view) {
            super.removeView(view);
            b_renamed();
        }

        private void a_renamed() {
            if (this.f_renamed) {
                throw new java.lang.IllegalStateException("This overlay was disposed already. Please use a_renamed new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void b_renamed() {
            if (getChildCount() == 0) {
                java.util.ArrayList<android.graphics.drawable.Drawable> arrayList = this.d_renamed;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f_renamed = true;
                    this.f1663b.removeView(this);
                }
            }
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            this.f1663b.getLocationOnScreen(new int[2]);
            this.f1664c.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new android.graphics.Rect(0, 0, this.f1664c.getWidth(), this.f1664c.getHeight()));
            super.dispatchDraw(canvas);
            java.util.ArrayList<android.graphics.drawable.Drawable> arrayList = this.d_renamed;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.d_renamed.get(i_renamed).draw(canvas);
            }
        }

        private void a_renamed(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f1663b.getLocationOnScreen(iArr2);
            this.f1664c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public android.view.ViewParent invalidateChildInParent(int[] iArr, android.graphics.Rect rect) {
            if (this.f1663b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f1663b instanceof android.view.ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                a_renamed(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
