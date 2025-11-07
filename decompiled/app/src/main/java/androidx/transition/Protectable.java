package androidx.transition;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class c_renamed extends androidx.transition.m_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final android.util.Property<androidx.transition.c_renamed.a_renamed, android.graphics.PointF> f1693c;
    private static final android.util.Property<androidx.transition.c_renamed.a_renamed, android.graphics.PointF> d_renamed;
    private static final android.util.Property<android.view.View, android.graphics.PointF> e_renamed;
    private static final android.util.Property<android.view.View, android.graphics.PointF> f_renamed;
    private int[] h_renamed = new int[2];
    private boolean i_renamed = false;
    private boolean j_renamed = false;

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f1691a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.util.Property<android.graphics.drawable.Drawable, android.graphics.PointF> f1692b = new android.util.Property<android.graphics.drawable.Drawable, android.graphics.PointF>(android.graphics.PointF.class, "boundsOrigin") { // from class: androidx.transition.c_renamed.1

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.graphics.Rect f1694a = new android.graphics.Rect();

        @Override // android.util.Property
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void set(android.graphics.drawable.Drawable drawable, android.graphics.PointF pointF) {
            drawable.copyBounds(this.f1694a);
            this.f1694a.offsetTo(java.lang.Math.round(pointF.x_renamed), java.lang.Math.round(pointF.y_renamed));
            drawable.setBounds(this.f1694a);
        }

        @Override // android.util.Property
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public android.graphics.PointF get(android.graphics.drawable.Drawable drawable) {
            drawable.copyBounds(this.f1694a);
            return new android.graphics.PointF(this.f1694a.left, this.f1694a.top);
        }
    };
    private static final android.util.Property<android.view.View, android.graphics.PointF> g_renamed = new android.util.Property<android.view.View, android.graphics.PointF>(android.graphics.PointF.class, "position") { // from class: androidx.transition.c_renamed.7
        @Override // android.util.Property
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public android.graphics.PointF get(android.view.View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void set(android.view.View view, android.graphics.PointF pointF) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            int iRound = java.lang.Math.round(pointF.x_renamed);
            int iRound2 = java.lang.Math.round(pointF.y_renamed);
            androidx.transition.ad_renamed.a_renamed(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    };
    private static androidx.transition.j_renamed k_renamed = new androidx.transition.j_renamed();

    static {
        java.lang.String str = "topLeft";
        f1693c = new android.util.Property<androidx.transition.c_renamed.a_renamed, android.graphics.PointF>(android.graphics.PointF.class, str) { // from class: androidx.transition.c_renamed.3
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public android.graphics.PointF get(androidx.transition.c_renamed.a_renamed aVar) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(androidx.transition.c_renamed.a_renamed aVar, android.graphics.PointF pointF) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                aVar.a_renamed(pointF);
            }
        };
        java.lang.String str2 = "bottomRight";
        d_renamed = new android.util.Property<androidx.transition.c_renamed.a_renamed, android.graphics.PointF>(android.graphics.PointF.class, str2) { // from class: androidx.transition.c_renamed.4
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public android.graphics.PointF get(androidx.transition.c_renamed.a_renamed aVar) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(androidx.transition.c_renamed.a_renamed aVar, android.graphics.PointF pointF) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                aVar.b_renamed(pointF);
            }
        };
        e_renamed = new android.util.Property<android.view.View, android.graphics.PointF>(android.graphics.PointF.class, str2) { // from class: androidx.transition.c_renamed.5
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public android.graphics.PointF get(android.view.View view) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(android.view.View view, android.graphics.PointF pointF) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                androidx.transition.ad_renamed.a_renamed(view, view.getLeft(), view.getTop(), java.lang.Math.round(pointF.x_renamed), java.lang.Math.round(pointF.y_renamed));
            }
        };
        f_renamed = new android.util.Property<android.view.View, android.graphics.PointF>(android.graphics.PointF.class, str) { // from class: androidx.transition.c_renamed.6
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public android.graphics.PointF get(android.view.View view) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(android.view.View view, android.graphics.PointF pointF) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                androidx.transition.ad_renamed.a_renamed(view, java.lang.Math.round(pointF.x_renamed), java.lang.Math.round(pointF.y_renamed), view.getRight(), view.getBottom());
            }
        };
    }

    @Override // androidx.transition.m_renamed
    public java.lang.String[] getTransitionProperties() {
        return f1691a;
    }

    private void a_renamed(androidx.transition.t_renamed tVar) {
        android.view.View view = tVar.f1755b;
        if (!androidx.core.h_renamed.v_renamed.A_renamed(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        tVar.f1754a.put("android:changeBounds:bounds", new android.graphics.Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        tVar.f1754a.put("android:changeBounds:parent", tVar.f1755b.getParent());
        if (this.j_renamed) {
            tVar.f1755b.getLocationInWindow(this.h_renamed);
            tVar.f1754a.put("android:changeBounds:windowX", java.lang.Integer.valueOf(this.h_renamed[0]));
            tVar.f1754a.put("android:changeBounds:windowY", java.lang.Integer.valueOf(this.h_renamed[1]));
        }
        if (this.i_renamed) {
            tVar.f1754a.put("android:changeBounds:clip", androidx.core.h_renamed.v_renamed.C_renamed(view));
        }
    }

    @Override // androidx.transition.m_renamed
    public void captureStartValues(androidx.transition.t_renamed tVar) {
        a_renamed(tVar);
    }

    @Override // androidx.transition.m_renamed
    public void captureEndValues(androidx.transition.t_renamed tVar) {
        a_renamed(tVar);
    }

    private boolean a_renamed(android.view.View view, android.view.View view2) {
        if (!this.j_renamed) {
            return true;
        }
        androidx.transition.t_renamed matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f1755b) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.m_renamed
    public android.animation.Animator createAnimator(final android.view.ViewGroup viewGroup, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int i_renamed;
        final android.view.View view;
        int i2;
        android.graphics.Rect rect;
        android.animation.ObjectAnimator objectAnimatorOfObject;
        android.animation.Animator animatorA;
        if (tVar == null || tVar2 == null) {
            return null;
        }
        java.util.Map<java.lang.String, java.lang.Object> map = tVar.f1754a;
        java.util.Map<java.lang.String, java.lang.Object> map2 = tVar2.f1754a;
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) map.get("android:changeBounds:parent");
        android.view.ViewGroup viewGroup3 = (android.view.ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final android.view.View view2 = tVar2.f1755b;
        if (a_renamed(viewGroup2, viewGroup3)) {
            android.graphics.Rect rect2 = (android.graphics.Rect) tVar.f1754a.get("android:changeBounds:bounds");
            android.graphics.Rect rect3 = (android.graphics.Rect) tVar2.f1754a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            final int i4 = rect3.left;
            int i5 = rect2.top;
            final int i6 = rect3.top;
            int i7 = rect2.right;
            final int i8 = rect3.right;
            int i9 = rect2.bottom;
            final int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            android.graphics.Rect rect4 = (android.graphics.Rect) tVar.f1754a.get("android:changeBounds:clip");
            final android.graphics.Rect rect5 = (android.graphics.Rect) tVar2.f1754a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i_renamed = 0;
            } else {
                i_renamed = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i_renamed++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i_renamed++;
            }
            if (i_renamed <= 0) {
                return null;
            }
            if (!this.i_renamed) {
                view = view2;
                androidx.transition.ad_renamed.a_renamed(view, i3, i5, i7, i9);
                if (i_renamed == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animatorA = androidx.transition.f_renamed.a_renamed(view, g_renamed, getPathMotion().a_renamed(i3, i5, i4, i6));
                    } else {
                        final androidx.transition.c_renamed.a_renamed aVar = new androidx.transition.c_renamed.a_renamed(view);
                        android.animation.ObjectAnimator objectAnimatorA = androidx.transition.f_renamed.a_renamed(aVar, f1693c, getPathMotion().a_renamed(i3, i5, i4, i6));
                        android.animation.ObjectAnimator objectAnimatorA2 = androidx.transition.f_renamed.a_renamed(aVar, d_renamed, getPathMotion().a_renamed(i7, i9, i8, i10));
                        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
                        animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
                        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.transition.c_renamed.8
                            private androidx.transition.c_renamed.a_renamed mViewBounds;

                            {
                                this.mViewBounds = aVar;
                            }
                        });
                        animatorA = animatorSet;
                    }
                } else if (i3 != i4 || i5 != i6) {
                    animatorA = androidx.transition.f_renamed.a_renamed(view, f_renamed, getPathMotion().a_renamed(i3, i5, i4, i6));
                } else {
                    animatorA = androidx.transition.f_renamed.a_renamed(view, e_renamed, getPathMotion().a_renamed(i7, i9, i8, i10));
                }
            } else {
                view = view2;
                androidx.transition.ad_renamed.a_renamed(view, i3, i5, java.lang.Math.max(i11, i13) + i3, java.lang.Math.max(i12, i14) + i5);
                android.animation.ObjectAnimator objectAnimatorA3 = (i3 == i4 && i5 == i6) ? null : androidx.transition.f_renamed.a_renamed(view, g_renamed, getPathMotion().a_renamed(i3, i5, i4, i6));
                if (rect4 == null) {
                    i2 = 0;
                    rect = new android.graphics.Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect4;
                }
                android.graphics.Rect rect6 = rect5 == null ? new android.graphics.Rect(i2, i2, i13, i14) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimatorOfObject = null;
                } else {
                    androidx.core.h_renamed.v_renamed.a_renamed(view, rect);
                    androidx.transition.j_renamed jVar = k_renamed;
                    java.lang.Object[] objArr = new java.lang.Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect6;
                    objectAnimatorOfObject = android.animation.ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                    objectAnimatorOfObject.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.transition.c_renamed.9
                        private boolean h_renamed;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(android.animation.Animator animator) {
                            this.h_renamed = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                            if (this.h_renamed) {
                                return;
                            }
                            androidx.core.h_renamed.v_renamed.a_renamed(view, rect5);
                            androidx.transition.ad_renamed.a_renamed(view, i4, i6, i8, i10);
                        }
                    });
                }
                animatorA = androidx.transition.s_renamed.a_renamed(objectAnimatorA3, objectAnimatorOfObject);
            }
            if (view.getParent() instanceof android.view.ViewGroup) {
                final android.view.ViewGroup viewGroup4 = (android.view.ViewGroup) view.getParent();
                androidx.transition.y_renamed.a_renamed(viewGroup4, true);
                addListener(new androidx.transition.n_renamed() { // from class: androidx.transition.c_renamed.10

                    /* renamed from: a_renamed, reason: collision with root package name */
                    boolean f1695a = false;

                    @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
                    public void a_renamed(androidx.transition.m_renamed mVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                        androidx.transition.y_renamed.a_renamed(viewGroup4, false);
                        this.f1695a = true;
                    }

                    @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
                    public void b_renamed(androidx.transition.m_renamed mVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                        if (!this.f1695a) {
                            androidx.transition.y_renamed.a_renamed(viewGroup4, false);
                        }
                        mVar.removeListener(this);
                    }

                    @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
                    public void c_renamed(androidx.transition.m_renamed mVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                        androidx.transition.y_renamed.a_renamed(viewGroup4, false);
                    }

                    @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
                    public void d_renamed(androidx.transition.m_renamed mVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                        androidx.transition.y_renamed.a_renamed(viewGroup4, true);
                    }
                });
            }
            return animatorA;
        }
        int iIntValue = ((java.lang.Integer) tVar.f1754a.get("android:changeBounds:windowX")).intValue();
        int iIntValue2 = ((java.lang.Integer) tVar.f1754a.get("android:changeBounds:windowY")).intValue();
        int iIntValue3 = ((java.lang.Integer) tVar2.f1754a.get("android:changeBounds:windowX")).intValue();
        int iIntValue4 = ((java.lang.Integer) tVar2.f1754a.get("android:changeBounds:windowY")).intValue();
        if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.h_renamed);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        view2.draw(new android.graphics.Canvas(bitmapCreateBitmap));
        final android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(bitmapCreateBitmap);
        final float fC_renamed = androidx.transition.ad_renamed.c_renamed(view2);
        androidx.transition.ad_renamed.a_renamed(view2, 0.0f);
        androidx.transition.ad_renamed.a_renamed(viewGroup).a_renamed(bitmapDrawable);
        androidx.transition.g_renamed pathMotion = getPathMotion();
        int[] iArr = this.h_renamed;
        android.animation.ObjectAnimator objectAnimatorOfPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, androidx.transition.i_renamed.a_renamed(f1692b, pathMotion.a_renamed(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
        objectAnimatorOfPropertyValuesHolder.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.transition.c_renamed.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                androidx.transition.ad_renamed.a_renamed(viewGroup).b_renamed(bitmapDrawable);
                androidx.transition.ad_renamed.a_renamed(view2, fC_renamed);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* compiled from: ChangeBounds.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f1706a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f1707b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f1708c;
        private int d_renamed;
        private android.view.View e_renamed;
        private int f_renamed;
        private int g_renamed;

        a_renamed(android.view.View view) {
            this.e_renamed = view;
        }

        void a_renamed(android.graphics.PointF pointF) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            this.f1706a = java.lang.Math.round(pointF.x_renamed);
            this.f1707b = java.lang.Math.round(pointF.y_renamed);
            this.f_renamed++;
            if (this.f_renamed == this.g_renamed) {
                a_renamed();
            }
        }

        void b_renamed(android.graphics.PointF pointF) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            this.f1708c = java.lang.Math.round(pointF.x_renamed);
            this.d_renamed = java.lang.Math.round(pointF.y_renamed);
            this.g_renamed++;
            if (this.f_renamed == this.g_renamed) {
                a_renamed();
            }
        }

        private void a_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            androidx.transition.ad_renamed.a_renamed(this.e_renamed, this.f1706a, this.f1707b, this.f1708c, this.d_renamed);
            this.f_renamed = 0;
            this.g_renamed = 0;
        }
    }
}
