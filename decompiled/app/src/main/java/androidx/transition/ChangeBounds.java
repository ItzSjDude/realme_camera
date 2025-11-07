package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p036h.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Property<PlatformImplementations.kt_3, PointF> f4564c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Property<PlatformImplementations.kt_3, PointF> f4565d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final Property<View, PointF> f4566e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final Property<View, PointF> f4567f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f4570h = new int[2];

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f4571i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f4572j = false;

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f4562a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Property<Drawable, PointF> f4563b = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.IntrinsicsJvm.kt_3.1

        /* renamed from: PlatformImplementations.kt_3 */
        private Rect f4573a = new Rect();

        @Override // android.util.Property
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f4573a);
            this.f4573a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f4573a);
        }

        @Override // android.util.Property
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f4573a);
            return new PointF(this.f4573a.left, this.f4573a.top);
        }
    };

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final Property<View, PointF> f4568g = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.IntrinsicsJvm.kt_3.7
        @Override // android.util.Property
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            ViewUtils.m4730a(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    };

    /* renamed from: OplusGLSurfaceView_5 */
    private static RectEvaluator f4569k = new RectEvaluator();

    static {
        String str = "topLeft";
        f4564c = new Property<PlatformImplementations.kt_3, PointF>(PointF.class, str) { // from class: androidx.transition.IntrinsicsJvm.kt_3.3
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public PointF get(PlatformImplementations.kt_3 aVar) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(PlatformImplementations.kt_3 aVar, PointF pointF) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                aVar.m4780a(pointF);
            }
        };
        String str2 = "bottomRight";
        f4565d = new Property<PlatformImplementations.kt_3, PointF>(PointF.class, str2) { // from class: androidx.transition.IntrinsicsJvm.kt_3.4
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public PointF get(PlatformImplementations.kt_3 aVar) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(PlatformImplementations.kt_3 aVar, PointF pointF) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                aVar.m4781b(pointF);
            }
        };
        f4566e = new Property<View, PointF>(PointF.class, str2) { // from class: androidx.transition.IntrinsicsJvm.kt_3.5
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(View view, PointF pointF) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                ViewUtils.m4730a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        f4567f = new Property<View, PointF>(PointF.class, str) { // from class: androidx.transition.IntrinsicsJvm.kt_3.6
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(View view, PointF pointF) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                ViewUtils.m4730a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f4562a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4765a(TransitionValues c0797t) {
        View view = c0797t.f4664b;
        if (!ViewCompat.m2823A(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        c0797t.f4663a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        c0797t.f4663a.put("android:changeBounds:parent", c0797t.f4664b.getParent());
        if (this.f4572j) {
            c0797t.f4664b.getLocationInWindow(this.f4570h);
            c0797t.f4663a.put("android:changeBounds:windowX", Integer.valueOf(this.f4570h[0]));
            c0797t.f4663a.put("android:changeBounds:windowY", Integer.valueOf(this.f4570h[1]));
        }
        if (this.f4571i) {
            c0797t.f4663a.put("android:changeBounds:clip", ViewCompat.m2825C(view));
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues c0797t) {
        m4765a(c0797t);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues c0797t) {
        m4765a(c0797t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m4766a(View view, View view2) {
        if (!this.f4572j) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f4664b) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(final ViewGroup viewGroup, TransitionValues c0797t, TransitionValues c0797t2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int OplusGLSurfaceView_13;
        final View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorM4825a;
        if (c0797t == null || c0797t2 == null) {
            return null;
        }
        Map<String, Object> map = c0797t.f4663a;
        Map<String, Object> map2 = c0797t2.f4663a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = c0797t2.f4664b;
        if (m4766a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) c0797t.f4663a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) c0797t2.f4663a.get("android:changeBounds:bounds");
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
            Rect rect4 = (Rect) c0797t.f4663a.get("android:changeBounds:clip");
            final Rect rect5 = (Rect) c0797t2.f4663a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                OplusGLSurfaceView_13 = 0;
            } else {
                OplusGLSurfaceView_13 = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    OplusGLSurfaceView_13++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                OplusGLSurfaceView_13++;
            }
            if (OplusGLSurfaceView_13 <= 0) {
                return null;
            }
            if (!this.f4571i) {
                view = view2;
                ViewUtils.m4730a(view, i3, i5, i7, i9);
                if (OplusGLSurfaceView_13 == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animatorM4825a = ObjectAnimatorUtils.m4786a(view, f4568g, getPathMotion().mo4787a(i3, i5, i4, i6));
                    } else {
                        final PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(view);
                        ObjectAnimator objectAnimatorM4786a = ObjectAnimatorUtils.m4786a(aVar, f4564c, getPathMotion().mo4787a(i3, i5, i4, i6));
                        ObjectAnimator objectAnimatorM4786a2 = ObjectAnimatorUtils.m4786a(aVar, f4565d, getPathMotion().mo4787a(i7, i9, i8, i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorM4786a, objectAnimatorM4786a2);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.IntrinsicsJvm.kt_3.8
                            private PlatformImplementations.kt_3 mViewBounds;

                            {
                                this.mViewBounds = aVar;
                            }
                        });
                        animatorM4825a = animatorSet;
                    }
                } else if (i3 != i4 || i5 != i6) {
                    animatorM4825a = ObjectAnimatorUtils.m4786a(view, f4567f, getPathMotion().mo4787a(i3, i5, i4, i6));
                } else {
                    animatorM4825a = ObjectAnimatorUtils.m4786a(view, f4566e, getPathMotion().mo4787a(i7, i9, i8, i10));
                }
            } else {
                view = view2;
                ViewUtils.m4730a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                ObjectAnimator objectAnimatorM4786a3 = (i3 == i4 && i5 == i6) ? null : ObjectAnimatorUtils.m4786a(view, f4568g, getPathMotion().mo4787a(i3, i5, i4, i6));
                if (rect4 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimatorOfObject = null;
                } else {
                    ViewCompat.m2849a(view, rect);
                    RectEvaluator c0788j = f4569k;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect6;
                    objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", c0788j, objArr);
                    objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.IntrinsicsJvm.kt_3.9

                        /* renamed from: COUIBaseListPopupWindow_10 */
                        private boolean f4591h;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            this.f4591h = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            if (this.f4591h) {
                                return;
                            }
                            ViewCompat.m2849a(view, rect5);
                            ViewUtils.m4730a(view, i4, i6, i8, i10);
                        }
                    });
                }
                animatorM4825a = TransitionUtils.m4825a(objectAnimatorM4786a3, objectAnimatorOfObject);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.m4832a(viewGroup4, true);
                addListener(new TransitionListenerAdapter() { // from class: androidx.transition.IntrinsicsJvm.kt_3.10

                    /* renamed from: PlatformImplementations.kt_3 */
                    boolean f4574a = false;

                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo4762a(Transition abstractC0791m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        ViewGroupUtils.m4832a(viewGroup4, false);
                        this.f4574a = true;
                    }

                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
                    /* renamed from: IntrinsicsJvm.kt_4 */
                    public void mo4757b(Transition abstractC0791m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        if (!this.f4574a) {
                            ViewGroupUtils.m4832a(viewGroup4, false);
                        }
                        abstractC0791m.removeListener(this);
                    }

                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
                    /* renamed from: IntrinsicsJvm.kt_3 */
                    public void mo4758c(Transition abstractC0791m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        ViewGroupUtils.m4832a(viewGroup4, false);
                    }

                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
                    /* renamed from: IntrinsicsJvm.kt_5 */
                    public void mo4759d(Transition abstractC0791m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        ViewGroupUtils.m4832a(viewGroup4, true);
                    }
                });
            }
            return animatorM4825a;
        }
        int iIntValue = ((Integer) c0797t.f4663a.get("android:changeBounds:windowX")).intValue();
        int iIntValue2 = ((Integer) c0797t.f4663a.get("android:changeBounds:windowY")).intValue();
        int iIntValue3 = ((Integer) c0797t2.f4663a.get("android:changeBounds:windowX")).intValue();
        int iIntValue4 = ((Integer) c0797t2.f4663a.get("android:changeBounds:windowY")).intValue();
        if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f4570h);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(bitmapCreateBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
        final float fM4734c = ViewUtils.m4734c(view2);
        ViewUtils.m4728a(view2, 0.0f);
        ViewUtils.m4727a(viewGroup).mo4718a(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.f4570h;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.m4790a(f4563b, pathMotion.mo4787a(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.IntrinsicsJvm.kt_3.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewUtils.m4727a(viewGroup).mo4719b(bitmapDrawable);
                ViewUtils.m4728a(view2, fM4734c);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: androidx.transition.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f4592a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f4593b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f4594c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f4595d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private View f4596e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f4597f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f4598g;

        PlatformImplementations.kt_3(View view) {
            this.f4596e = view;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4780a(PointF pointF) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f4592a = Math.round(pointF.x);
            this.f4593b = Math.round(pointF.y);
            this.f4597f++;
            if (this.f4597f == this.f4598g) {
                m4779a();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4781b(PointF pointF) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f4594c = Math.round(pointF.x);
            this.f4595d = Math.round(pointF.y);
            this.f4598g++;
            if (this.f4597f == this.f4598g) {
                m4779a();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4779a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ViewUtils.m4730a(this.f4596e, this.f4592a, this.f4593b, this.f4594c, this.f4595d);
            this.f4597f = 0;
            this.f4598g = 0;
        }
    }
}
