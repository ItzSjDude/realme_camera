package androidx.core.h_renamed;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class z_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    java.lang.Runnable f1004a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.Runnable f1005b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1006c = -1;
    private java.lang.ref.WeakReference<android.view.View> d_renamed;

    z_renamed(android.view.View view) {
        this.d_renamed = new java.lang.ref.WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    static class a_renamed implements androidx.core.h_renamed.aa_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.core.h_renamed.z_renamed f1013a;

        /* renamed from: b_renamed, reason: collision with root package name */
        boolean f1014b;

        a_renamed(androidx.core.h_renamed.z_renamed zVar) {
            this.f1013a = zVar;
        }

        @Override // androidx.core.h_renamed.aa_renamed
        public void a_renamed(android.view.View view) {
            this.f1014b = false;
            if (this.f1013a.f1006c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f1013a.f1004a != null) {
                java.lang.Runnable runnable = this.f1013a.f1004a;
                this.f1013a.f1004a = null;
                runnable.run();
            }
            java.lang.Object tag = view.getTag(2113929216);
            androidx.core.h_renamed.aa_renamed aaVar = tag instanceof androidx.core.h_renamed.aa_renamed ? (androidx.core.h_renamed.aa_renamed) tag : null;
            if (aaVar != null) {
                aaVar.a_renamed(view);
            }
        }

        @Override // androidx.core.h_renamed.aa_renamed
        @android.annotation.SuppressLint({"WrongConstant"})
        public void b_renamed(android.view.View view) {
            if (this.f1013a.f1006c > -1) {
                view.setLayerType(this.f1013a.f1006c, null);
                this.f1013a.f1006c = -1;
            }
            if (android.os.Build.VERSION.SDK_INT >= 16 || !this.f1014b) {
                if (this.f1013a.f1005b != null) {
                    java.lang.Runnable runnable = this.f1013a.f1005b;
                    this.f1013a.f1005b = null;
                    runnable.run();
                }
                java.lang.Object tag = view.getTag(2113929216);
                androidx.core.h_renamed.aa_renamed aaVar = tag instanceof androidx.core.h_renamed.aa_renamed ? (androidx.core.h_renamed.aa_renamed) tag : null;
                if (aaVar != null) {
                    aaVar.b_renamed(view);
                }
                this.f1014b = true;
            }
        }

        @Override // androidx.core.h_renamed.aa_renamed
        public void c_renamed(android.view.View view) {
            java.lang.Object tag = view.getTag(2113929216);
            androidx.core.h_renamed.aa_renamed aaVar = tag instanceof androidx.core.h_renamed.aa_renamed ? (androidx.core.h_renamed.aa_renamed) tag : null;
            if (aaVar != null) {
                aaVar.c_renamed(view);
            }
        }
    }

    public androidx.core.h_renamed.z_renamed a_renamed(long j_renamed) {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().setDuration(j_renamed);
        }
        return this;
    }

    public androidx.core.h_renamed.z_renamed a_renamed(float f_renamed) {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().alpha(f_renamed);
        }
        return this;
    }

    public androidx.core.h_renamed.z_renamed b_renamed(float f_renamed) {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().translationY(f_renamed);
        }
        return this;
    }

    public long a_renamed() {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public androidx.core.h_renamed.z_renamed a_renamed(android.view.animation.Interpolator interpolator) {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public androidx.core.h_renamed.z_renamed b_renamed(long j_renamed) {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().setStartDelay(j_renamed);
        }
        return this;
    }

    public androidx.core.h_renamed.z_renamed c_renamed(float f_renamed) {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().rotation(f_renamed);
        }
        return this;
    }

    public void b_renamed() {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c_renamed() {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public androidx.core.h_renamed.z_renamed a_renamed(androidx.core.h_renamed.aa_renamed aaVar) {
        android.view.View view = this.d_renamed.get();
        if (view != null) {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                a_renamed(view, aaVar);
            } else {
                view.setTag(2113929216, aaVar);
                a_renamed(view, new androidx.core.h_renamed.z_renamed.a_renamed(this));
            }
        }
        return this;
    }

    private void a_renamed(final android.view.View view, final androidx.core.h_renamed.aa_renamed aaVar) {
        if (aaVar != null) {
            view.animate().setListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.core.h_renamed.z_renamed.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    aaVar.c_renamed(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    aaVar.b_renamed(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    aaVar.a_renamed(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public androidx.core.h_renamed.z_renamed a_renamed(final androidx.core.h_renamed.ac_renamed acVar) {
        final android.view.View view = this.d_renamed.get();
        if (view != null && android.os.Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(acVar != null ? new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.h_renamed.z_renamed.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    acVar.a_renamed(view);
                }
            } : null);
        }
        return this;
    }
}
