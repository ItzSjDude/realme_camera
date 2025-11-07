package com.coui.appcompat.widget.popupwindow;

/* compiled from: COUIBaseListPopupWindow.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f3036a;
    private android.os.Handler A_renamed;
    private android.graphics.Rect B_renamed;
    private boolean C_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f3037b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.coui.appcompat.widget.popupwindow.b_renamed f3038c;
    int d_renamed;
    private android.widget.ListAdapter e_renamed;
    private com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private boolean k_renamed;
    private int l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private android.view.View o_renamed;
    private int p_renamed;
    private android.database.DataSetObserver q_renamed;
    private android.view.View r_renamed;
    private android.graphics.drawable.Drawable s_renamed;
    private android.widget.AdapterView.OnItemClickListener t_renamed;
    private android.widget.AdapterView.OnItemSelectedListener u_renamed;
    private final com.coui.appcompat.widget.popupwindow.a_renamed.h_renamed v_renamed;
    private final com.coui.appcompat.widget.popupwindow.a_renamed.g_renamed w_renamed;
    private final com.coui.appcompat.widget.popupwindow.a_renamed.f_renamed x_renamed;
    private final com.coui.appcompat.widget.popupwindow.a_renamed.d_renamed y_renamed;
    private java.lang.Runnable z_renamed;

    static {
        try {
            f3036a = com.coui.appcompat.widget.popupwindow.b_renamed.class.getDeclaredMethod("setClipToScreenEnabled", java.lang.Boolean.TYPE);
        } catch (java.lang.NoSuchMethodException unused) {
            android.util.Log.i_renamed("BaseListPopupWindow", "Could not find method setClipToScreenEnabled() on_renamed PopupWindow. Oh well.");
        }
    }

    public void a_renamed(android.widget.ListAdapter listAdapter) {
        android.database.DataSetObserver dataSetObserver = this.q_renamed;
        if (dataSetObserver == null) {
            this.q_renamed = new com.coui.appcompat.widget.popupwindow.a_renamed.e_renamed(this, null);
        } else {
            android.widget.ListAdapter listAdapter2 = this.e_renamed;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.e_renamed = listAdapter;
        if (this.e_renamed != null) {
            listAdapter.registerDataSetObserver(this.q_renamed);
        }
        com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed bVar = this.f_renamed;
        if (bVar != null) {
            bVar.setAdapter((android.widget.ListAdapter) new com.coui.appcompat.widget.popupwindow.a_renamed.COUIBaseListPopupWindow_6(this.e_renamed));
        }
    }

    public android.graphics.drawable.Drawable e_renamed() {
        return this.f3038c.getBackground();
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.f3038c.setBackgroundDrawable(drawable);
    }

    public android.view.View l_renamed() {
        return this.r_renamed;
    }

    public int g_renamed() {
        return this.i_renamed;
    }

    public void b_renamed(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    public int f_renamed() {
        if (this.k_renamed) {
            return this.j_renamed;
        }
        return 0;
    }

    public void a_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
        this.k_renamed = true;
    }

    public int m_renamed() {
        return this.h_renamed;
    }

    public void c_renamed(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public void d_renamed(int i_renamed) {
        android.graphics.drawable.Drawable background = this.f3038c.getBackground();
        if (background != null) {
            background.getPadding(this.B_renamed);
            this.h_renamed = this.B_renamed.left + this.B_renamed.right + i_renamed;
        } else {
            c_renamed(i_renamed);
        }
    }

    public void e_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.a_renamed.h_renamed():void");
    }

    public void c_renamed() {
        this.f3038c.dismiss();
        a_renamed();
        this.f3038c.setContentView(null);
        this.f_renamed = null;
        this.A_renamed.removeCallbacks(this.v_renamed);
    }

    public void a_renamed(com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed aVar) {
        this.f3038c.a_renamed(aVar);
    }

    private void a_renamed() {
        android.view.View view = this.o_renamed;
        if (view != null) {
            android.view.ViewParent parent = view.getParent();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).removeView(this.o_renamed);
            }
        }
    }

    public void f_renamed(int i_renamed) {
        this.f3038c.setInputMethodMode(i_renamed);
    }

    public void g_renamed(int i_renamed) {
        com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed bVar = this.f_renamed;
        if (!d_renamed() || bVar == null) {
            return;
        }
        bVar.f_renamed = false;
        bVar.setSelection(i_renamed);
        if (android.os.Build.VERSION.SDK_INT < 11 || bVar.getChoiceMode() == 0) {
            return;
        }
        bVar.setItemChecked(i_renamed, true);
    }

    public void n_renamed() {
        com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed bVar = this.f_renamed;
        if (bVar != null) {
            bVar.f_renamed = true;
            bVar.requestLayout();
        }
    }

    public boolean d_renamed() {
        return this.f3038c.isShowing();
    }

    public boolean o_renamed() {
        return this.f3038c.getInputMethodMode() == 2;
    }

    public android.widget.ListView p_renamed() {
        return this.f_renamed;
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.a_renamed$1, reason: invalid class name */
    class SceneLoader_2 extends com.coui.appcompat.widget.popupwindow.a_renamed.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.popupwindow.a_renamed f3039a;

        @Override // com.coui.appcompat.widget.popupwindow.a_renamed.c_renamed
        public com.coui.appcompat.widget.popupwindow.a_renamed a_renamed() {
            return this.f3039a;
        }
    }

    protected int j_renamed() {
        int measuredHeight;
        int iMakeMeasureSpec;
        int i_renamed = 0;
        if (this.f_renamed == null) {
            android.content.Context context = this.f3037b;
            this.z_renamed = new java.lang.Runnable() { // from class: com.coui.appcompat.widget.popupwindow.a_renamed.2
                @Override // java.lang.Runnable
                public void run() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                    android.view.View viewL = com.coui.appcompat.widget.popupwindow.a_renamed.this.l_renamed();
                    if (viewL == null || viewL.getWindowToken() == null) {
                        return;
                    }
                    com.coui.appcompat.widget.popupwindow.a_renamed.this.h_renamed();
                }
            };
            this.f_renamed = new com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed(context, !this.C_renamed);
            android.graphics.drawable.Drawable drawable = this.s_renamed;
            if (drawable != null) {
                this.f_renamed.setSelector(drawable);
            }
            this.f_renamed.setAdapter((android.widget.ListAdapter) new com.coui.appcompat.widget.popupwindow.a_renamed.COUIBaseListPopupWindow_6(this.e_renamed));
            this.f_renamed.setOnItemClickListener(this.t_renamed);
            this.f_renamed.setFocusable(true);
            this.f_renamed.setFocusableInTouchMode(true);
            this.f_renamed.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() { // from class: com.coui.appcompat.widget.popupwindow.a_renamed.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i2, long j_renamed) {
                    com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed bVar;
                    if (i2 == -1 || (bVar = com.coui.appcompat.widget.popupwindow.a_renamed.this.f_renamed) == null) {
                        return;
                    }
                    bVar.f_renamed = false;
                }
            });
            this.f_renamed.setOnScrollListener(this.x_renamed);
            android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener = this.u_renamed;
            if (onItemSelectedListener != null) {
                this.f_renamed.setOnItemSelectedListener(onItemSelectedListener);
            }
            android.view.View view = this.f_renamed;
            android.view.View view2 = this.o_renamed;
            if (view2 != null) {
                android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
                linearLayout.setOrientation(1);
                android.view.ViewGroup.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i2 = this.p_renamed;
                if (i2 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i2 == 1) {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                } else {
                    android.util.Log.e_renamed("BaseListPopupWindow", "Invalid hint position " + this.p_renamed);
                }
                view2.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.h_renamed, Integer.MIN_VALUE), 0);
                android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = layoutParams2.bottomMargin + view2.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f3038c.setContentView(view);
        } else {
            android.view.View view3 = this.o_renamed;
            if (view3 != null) {
                android.widget.LinearLayout.LayoutParams layoutParams3 = (android.widget.LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        android.graphics.drawable.Drawable background = this.f3038c.getBackground();
        if (background != null) {
            background.getPadding(this.B_renamed);
            i_renamed = this.B_renamed.top + this.B_renamed.bottom;
            if (!this.k_renamed) {
                this.j_renamed = -this.B_renamed.top;
            }
        } else {
            this.B_renamed.setEmpty();
        }
        this.f3038c.getInputMethodMode();
        int maxAvailableHeight = this.f3038c.getMaxAvailableHeight(l_renamed(), this.j_renamed);
        if (this.m_renamed || this.g_renamed == -1) {
            return maxAvailableHeight + i_renamed;
        }
        int i3 = this.h_renamed;
        if (i3 == -2) {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.f3037b.getResources().getDisplayMetrics().widthPixels - (this.B_renamed.left + this.B_renamed.right), Integer.MIN_VALUE);
        } else if (i3 == -1) {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.f3037b.getResources().getDisplayMetrics().widthPixels - (this.B_renamed.left + this.B_renamed.right), 1073741824);
        } else {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        int iA = this.f_renamed.a_renamed(iMakeMeasureSpec, 0, -1, maxAvailableHeight - measuredHeight, -1);
        if (iA > 0) {
            measuredHeight += i_renamed;
        }
        return iA + measuredHeight;
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    public static abstract class c_renamed implements android.view.View.OnTouchListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final float f3044a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f3045b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f3046c;
        private final android.view.View d_renamed;
        private java.lang.Runnable e_renamed;
        private java.lang.Runnable f_renamed;
        private boolean g_renamed;
        private boolean h_renamed;
        private int i_renamed;
        private final int[] j_renamed;

        public abstract com.coui.appcompat.widget.popupwindow.a_renamed a_renamed();

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            boolean zB;
            boolean z_renamed = this.g_renamed;
            if (z_renamed) {
                zB = this.h_renamed ? b_renamed(motionEvent) : b_renamed(motionEvent) || !c_renamed();
            } else {
                zB = a_renamed(motionEvent) && b_renamed();
                if (zB) {
                    long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                    android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.d_renamed.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
            }
            this.g_renamed = zB;
            return zB || z_renamed;
        }

        protected boolean b_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            com.coui.appcompat.widget.popupwindow.a_renamed aVarA = a_renamed();
            if (aVarA == null || aVarA.d_renamed()) {
                return true;
            }
            aVarA.h_renamed();
            return true;
        }

        protected boolean c_renamed() {
            com.coui.appcompat.widget.popupwindow.a_renamed aVarA = a_renamed();
            if (aVarA == null || !aVarA.d_renamed()) {
                return true;
            }
            aVarA.c_renamed();
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x003d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean a_renamed(android.view.MotionEvent r6) {
            /*
                r5 = this;
                android.view.View r0 = r5.d_renamed
                boolean r1 = r0.isEnabled()
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                int r1 = androidx.core.h_renamed.h_renamed.a_renamed(r6)
                if (r1 == 0) goto L41
                r3 = 1
                if (r1 == r3) goto L3d
                r4 = 2
                if (r1 == r4) goto L1a
                r6 = 3
                if (r1 == r6) goto L3d
                goto L70
            L1a:
                int r1 = r5.i_renamed
                int r1 = r6.findPointerIndex(r1)
                if (r1 < 0) goto L70
                float r4 = r6.getX(r1)
                float r6 = r6.getY(r1)
                float r1 = r5.f3044a
                boolean r6 = a_renamed(r0, r4, r6, r1)
                if (r6 != 0) goto L70
                r5.d_renamed()
                android.view.ViewParent r5 = r0.getParent()
                r5.requestDisallowInterceptTouchEvent(r3)
                return r3
            L3d:
                r5.d_renamed()
                goto L70
            L41:
                int r6 = r6.getPointerId(r2)
                r5.i_renamed = r6
                r5.h_renamed = r2
                java.lang.Runnable r6 = r5.e_renamed
                r1 = 0
                if (r6 != 0) goto L55
                com.coui.appcompat.widget.popupwindow.a_renamed$c_renamed$a_renamed r6 = new com.coui.appcompat.widget.popupwindow.a_renamed$c_renamed$a_renamed
                r6.<init>(r5, r1)
                r5.e_renamed = r6
            L55:
                java.lang.Runnable r6 = r5.e_renamed
                int r3 = r5.f3045b
                long r3 = (long) r3
                r0.postDelayed(r6, r3)
                java.lang.Runnable r6 = r5.f_renamed
                if (r6 != 0) goto L68
                com.coui.appcompat.widget.popupwindow.a_renamed$c_renamed$b_renamed r6 = new com.coui.appcompat.widget.popupwindow.a_renamed$c_renamed$b_renamed
                r6.<init>(r5, r1)
                r5.f_renamed = r6
            L68:
                java.lang.Runnable r6 = r5.f_renamed
                int r5 = r5.f3046c
                long r3 = (long) r5
                r0.postDelayed(r6, r3)
            L70:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.a_renamed.c_renamed.a_renamed(android.view.MotionEvent):boolean");
        }

        private void d_renamed() {
            java.lang.Runnable runnable = this.f_renamed;
            if (runnable != null) {
                this.d_renamed.removeCallbacks(runnable);
            }
            java.lang.Runnable runnable2 = this.e_renamed;
            if (runnable2 != null) {
                this.d_renamed.removeCallbacks(runnable2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e_renamed() {
            d_renamed();
            android.view.View view = this.d_renamed;
            if (view.isEnabled() && !view.isLongClickable() && b_renamed()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                this.g_renamed = true;
                this.h_renamed = true;
            }
        }

        private boolean b_renamed(android.view.MotionEvent motionEvent) {
            com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed bVar;
            android.view.View view = this.d_renamed;
            com.coui.appcompat.widget.popupwindow.a_renamed aVarA = a_renamed();
            if (aVarA == null || !aVarA.d_renamed() || (bVar = aVarA.f_renamed) == null || !bVar.isShown()) {
                return false;
            }
            android.view.MotionEvent motionEventObtainNoHistory = android.view.MotionEvent.obtainNoHistory(motionEvent);
            b_renamed(view, motionEventObtainNoHistory);
            a_renamed(bVar, motionEventObtainNoHistory);
            boolean zA = bVar.a_renamed(motionEventObtainNoHistory, this.i_renamed);
            motionEventObtainNoHistory.recycle();
            int iA = androidx.core.h_renamed.h_renamed.a_renamed(motionEvent);
            return zA && (iA != 1 && iA != 3);
        }

        private static boolean a_renamed(android.view.View view, float f_renamed, float f2, float f3) {
            float f4 = -f3;
            return f_renamed >= f4 && f2 >= f4 && f_renamed < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        private boolean a_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
            view.getLocationOnScreen(this.j_renamed);
            motionEvent.offsetLocation(-r1[0], -r1[1]);
            return true;
        }

        private boolean b_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
            view.getLocationOnScreen(this.j_renamed);
            motionEvent.offsetLocation(r1[0], r1[1]);
            return true;
        }

        /* compiled from: COUIBaseListPopupWindow.java */
        /* renamed from: com.coui.appcompat.widget.popupwindow.a_renamed$c_renamed$a_renamed, reason: collision with other inner class name */
        private class COUIBaseListPopupWindow_4 implements java.lang.Runnable {
            private COUIBaseListPopupWindow_4() {
            }

            /* synthetic */ COUIBaseListPopupWindow_4(com.coui.appcompat.widget.popupwindow.a_renamed.c_renamed cVar, com.coui.appcompat.widget.popupwindow.a_renamed.SceneLoader_2 anonymousClass1) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                com.coui.appcompat.widget.popupwindow.a_renamed.c_renamed.this.d_renamed.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* compiled from: COUIBaseListPopupWindow.java */
        private class b_renamed implements java.lang.Runnable {
            private b_renamed() {
            }

            /* synthetic */ b_renamed(com.coui.appcompat.widget.popupwindow.a_renamed.c_renamed cVar, com.coui.appcompat.widget.popupwindow.a_renamed.SceneLoader_2 anonymousClass1) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                com.coui.appcompat.widget.popupwindow.a_renamed.c_renamed.this.e_renamed();
            }
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.a_renamed$a_renamed, reason: collision with other inner class name */
    private class COUIBaseListPopupWindow_6 implements android.widget.ListAdapter {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.widget.ListAdapter f3043b;

        public COUIBaseListPopupWindow_6(android.widget.ListAdapter listAdapter) {
            this.f3043b = listAdapter;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i_renamed) {
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter == null) {
                return null;
            }
            return listAdapter.getItem(i_renamed);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i_renamed) {
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter == null) {
                return 0L;
            }
            return listAdapter.getItemId(i_renamed);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            android.widget.ListAdapter listAdapter = this.f3043b;
            return listAdapter != null && listAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter == null) {
                return null;
            }
            android.view.View view2 = listAdapter.getView(i_renamed, view, viewGroup);
            if (view2 == null) {
                return view2;
            }
            view2.setAlpha(0.0f);
            view2.animate().alpha(1.0f).setInterpolator(androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.33f, 0.0f, 0.66f, 1.0f)).setDuration(350L).setStartDelay(150L).start();
            return view2;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i_renamed) {
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getItemViewType(i_renamed);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            if (this.f3043b == null) {
                if (com.coui.appcompat.widget.popupwindow.a_renamed.this.e_renamed != null) {
                    android.util.Log.d_renamed("COUIBaseListPopupWindow", "getViewTypeCount:listAdapter = null,mAdapter = " + com.coui.appcompat.widget.popupwindow.a_renamed.this.e_renamed + ",typeCount = " + com.coui.appcompat.widget.popupwindow.a_renamed.this.e_renamed.getViewTypeCount());
                } else {
                    android.util.Log.d_renamed("COUIBaseListPopupWindow", "getViewTypeCount:listAdapter = null,mAdapter = " + com.coui.appcompat.widget.popupwindow.a_renamed.this.e_renamed);
                }
            } else {
                android.util.Log.d_renamed("COUIBaseListPopupWindow", "listAdapter.typeCount = " + this.f3043b.getViewTypeCount());
            }
            android.widget.ListAdapter listAdapter = this.f3043b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getViewTypeCount();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            android.widget.ListAdapter listAdapter = this.f3043b;
            return listAdapter != null && listAdapter.isEmpty();
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            android.widget.ListAdapter listAdapter = this.f3043b;
            return listAdapter != null && listAdapter.areAllItemsEnabled();
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i_renamed) {
            android.widget.ListAdapter listAdapter = this.f3043b;
            return listAdapter != null && listAdapter.isEnabled(i_renamed);
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    private static class b_renamed extends com.coui.appcompat.widget.i_renamed {
        private boolean f_renamed;
        private boolean g_renamed;
        private boolean h_renamed;
        private androidx.core.h_renamed.z_renamed i_renamed;
        private androidx.core.widget.f_renamed j_renamed;

        public b_renamed(android.content.Context context, boolean z_renamed) {
            super(context, null, coui.support.appcompat.R_renamed.attr.dropDownListViewStyle);
            this.g_renamed = z_renamed;
            setCacheColorHint(0);
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x0011  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a_renamed(android.view.MotionEvent r8, int r9) {
            /*
                r7 = this;
                int r0 = androidx.core.h_renamed.h_renamed.a_renamed(r8)
                r1 = 0
                r2 = 1
                if (r0 == r2) goto L16
                r3 = 2
                if (r0 == r3) goto L14
                r9 = 3
                if (r0 == r9) goto L11
            Le:
                r9 = r1
                r3 = r2
                goto L46
            L11:
                r9 = r1
                r3 = r9
                goto L46
            L14:
                r3 = r2
                goto L17
            L16:
                r3 = r1
            L17:
                int r9 = r8.findPointerIndex(r9)
                if (r9 >= 0) goto L1e
                goto L11
            L1e:
                float r4 = r8.getX(r9)
                int r4 = (int) r4
                float r9 = r8.getY(r9)
                int r9 = (int) r9
                int r5 = r7.pointToPosition(r4, r9)
                r6 = -1
                if (r5 != r6) goto L31
                r9 = r2
                goto L46
            L31:
                int r3 = r7.getFirstVisiblePosition()
                int r3 = r5 - r3
                android.view.View r3 = r7.getChildAt(r3)
                float r4 = (float) r4
                float r9 = (float) r9
                r7.a_renamed(r3, r5, r4, r9)
                if (r0 != r2) goto Le
                r7.a_renamed(r3, r5)
                goto Le
            L46:
                if (r3 == 0) goto L4a
                if (r9 == 0) goto L4d
            L4a:
                r7.d_renamed()
            L4d:
                if (r3 == 0) goto L65
                androidx.core.widget.f_renamed r9 = r7.j_renamed
                if (r9 != 0) goto L5a
                androidx.core.widget.f_renamed r9 = new androidx.core.widget.f_renamed
                r9.<init>(r7)
                r7.j_renamed = r9
            L5a:
                androidx.core.widget.f_renamed r9 = r7.j_renamed
                r9.a_renamed(r2)
                androidx.core.widget.f_renamed r9 = r7.j_renamed
                r9.onTouch(r7, r8)
                goto L6c
            L65:
                androidx.core.widget.f_renamed r7 = r7.j_renamed
                if (r7 == 0) goto L6c
                r7.a_renamed(r1)
            L6c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.a_renamed.b_renamed.a_renamed(android.view.MotionEvent, int):boolean");
        }

        private void a_renamed(android.view.View view, int i_renamed) {
            performItemClick(view, i_renamed, getItemIdAtPosition(i_renamed));
        }

        private void d_renamed() {
            this.h_renamed = false;
            setPressed(false);
            drawableStateChanged();
            androidx.core.h_renamed.z_renamed zVar = this.i_renamed;
            if (zVar != null) {
                zVar.b_renamed();
                this.i_renamed = null;
            }
        }

        private void a_renamed(android.view.View view, int i_renamed, float f_renamed, float f2) {
            this.h_renamed = true;
            setPressed(true);
            layoutChildren();
            setSelection(i_renamed);
            a_renamed(i_renamed, view, f_renamed, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        @Override // com.coui.appcompat.widget.i_renamed
        protected boolean c_renamed() {
            return this.h_renamed || super.c_renamed();
        }

        @Override // android.view.View
        public boolean isInTouchMode() {
            return (this.g_renamed && this.f_renamed) || super.isInTouchMode();
        }

        @Override // android.view.View
        public boolean hasWindowFocus() {
            return this.g_renamed || super.hasWindowFocus();
        }

        @Override // android.view.View
        public boolean isFocused() {
            return this.g_renamed || super.isFocused();
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            return this.g_renamed || super.hasFocus();
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    private class e_renamed extends android.database.DataSetObserver {
        private e_renamed() {
        }

        /* synthetic */ e_renamed(com.coui.appcompat.widget.popupwindow.a_renamed aVar, com.coui.appcompat.widget.popupwindow.a_renamed.SceneLoader_2 anonymousClass1) {
            this();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (com.coui.appcompat.widget.popupwindow.a_renamed.this.d_renamed()) {
                com.coui.appcompat.widget.popupwindow.a_renamed.this.h_renamed();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            com.coui.appcompat.widget.popupwindow.a_renamed.this.c_renamed();
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    private class d_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.popupwindow.a_renamed f3049a;

        @Override // java.lang.Runnable
        public void run() {
            this.f3049a.n_renamed();
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    private class h_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.popupwindow.a_renamed f3053a;

        @Override // java.lang.Runnable
        public void run() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (this.f3053a.f_renamed == null || this.f3053a.f_renamed.getCount() <= this.f3053a.f_renamed.getChildCount() || this.f3053a.f_renamed.getChildCount() > this.f3053a.d_renamed) {
                return;
            }
            this.f3053a.f3038c.setInputMethodMode(2);
            this.f3053a.h_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: COUIBaseListPopupWindow.java */
    public class g_renamed implements android.view.View.OnTouchListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.popupwindow.a_renamed f3052a;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x_renamed = (int) motionEvent.getX();
            int y_renamed = (int) motionEvent.getY();
            if (action == 0 && this.f3052a.f3038c != null && this.f3052a.f3038c.isShowing() && x_renamed >= 0 && x_renamed < this.f3052a.f3038c.getWidth() && y_renamed >= 0 && y_renamed < this.f3052a.f3038c.getHeight()) {
                this.f3052a.A_renamed.postDelayed(this.f3052a.v_renamed, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            this.f3052a.A_renamed.removeCallbacks(this.f3052a.v_renamed);
            return false;
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    private class f_renamed implements android.widget.AbsListView.OnScrollListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.popupwindow.a_renamed f3051a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(android.widget.AbsListView absListView, int i_renamed, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(android.widget.AbsListView absListView, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (i_renamed != 1 || this.f3051a.o_renamed() || this.f3051a.f3038c.getContentView() == null) {
                return;
            }
            this.f3051a.A_renamed.removeCallbacks(this.f3051a.v_renamed);
            this.f3051a.v_renamed.run();
        }
    }

    private void a_renamed(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = f3036a;
        if (method != null) {
            try {
                method.invoke(this.f3038c, java.lang.Boolean.valueOf(z_renamed));
            } catch (java.lang.Exception unused) {
                android.util.Log.i_renamed("BaseListPopupWindow", "Could not call setClipToScreenEnabled() on_renamed PopupWindow. Oh well.");
            }
        }
    }
}
