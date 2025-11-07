package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.p036h.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: ViewOverlayApi14.java */
/* renamed from: androidx.transition.aa */
/* loaded from: classes.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    protected PlatformImplementations.kt_3 f4521a;

    ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.f4521a = new PlatformImplementations.kt_3(context, viewGroup, view, this);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static ViewGroup m4716c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static ViewOverlayApi14 m4717d(View view) {
        ViewGroup viewGroupM4716c = m4716c(view);
        if (viewGroupM4716c == null) {
            return null;
        }
        int childCount = viewGroupM4716c.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = viewGroupM4716c.getChildAt(OplusGLSurfaceView_13);
            if (childAt instanceof PlatformImplementations.kt_3) {
                return ((PlatformImplementations.kt_3) childAt).f4526e;
            }
        }
        return new ViewGroupOverlayApi14(viewGroupM4716c.getContext(), viewGroupM4716c, view);
    }

    @Override // androidx.transition.ViewOverlayImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4718a(Drawable drawable) {
        this.f4521a.m4723a(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4719b(Drawable drawable) {
        this.f4521a.m4725b(drawable);
    }

    /* compiled from: ViewOverlayApi14.java */
    /* renamed from: androidx.transition.aa$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends ViewGroup {

        /* renamed from: PlatformImplementations.kt_3 */
        static Method f4522a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        ViewGroup f4523b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        View f4524c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        ArrayList<Drawable> f4525d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        ViewOverlayApi14 f4526e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f4527f;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        }

        static {
            try {
                f4522a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        PlatformImplementations.kt_3(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 c0766aa) {
            super(context);
            this.f4525d = null;
            this.f4523b = viewGroup;
            this.f4524c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f4526e = c0766aa;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4723a(Drawable drawable) {
            m4720a();
            if (this.f4525d == null) {
                this.f4525d = new ArrayList<>();
            }
            if (this.f4525d.contains(drawable)) {
                return;
            }
            this.f4525d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4725b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f4525d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                m4722b();
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f4525d) != null && arrayList.contains(drawable));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4724a(View view) {
            m4720a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f4523b && viewGroup.getParent() != null && ViewCompat.m2826D(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f4523b.getLocationOnScreen(iArr2);
                    ViewCompat.m2884f(view, iArr[0] - iArr2[0]);
                    ViewCompat.m2882e(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4726b(View view) {
            super.removeView(view);
            m4722b();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4720a() {
            if (this.f4527f) {
                throw new IllegalStateException("This overlay was disposed already. Please use PlatformImplementations.kt_3 new one via ViewGroupUtils.getOverlay()");
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m4722b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f4525d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f4527f = true;
                    this.f4523b.removeView(this);
                }
            }
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f4523b.getLocationOnScreen(new int[2]);
            this.f4524c.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f4524c.getWidth(), this.f4524c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f4525d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f4525d.get(OplusGLSurfaceView_13).draw(canvas);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4721a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f4523b.getLocationOnScreen(iArr2);
            this.f4524c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f4523b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f4523b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                m4721a(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
