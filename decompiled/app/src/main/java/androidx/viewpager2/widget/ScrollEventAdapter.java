package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: ScrollEventAdapter.java */
/* renamed from: androidx.viewpager2.widget.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
final class ScrollEventAdapter extends RecyclerView.AbstractC0698n {

    /* renamed from: PlatformImplementations.kt_3 */
    private ViewPager2.AbstractC0845e f4931a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ViewPager2 f4932b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final RecyclerView f4933c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final LinearLayoutManager f4934d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f4935e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f4936f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f4937g = new PlatformImplementations.kt_3();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f4938h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f4939i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f4940j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f4941k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f4942l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f4943m;

    ScrollEventAdapter(ViewPager2 viewPager2) {
        this.f4932b = viewPager2;
        this.f4933c = this.f4932b.f4887e;
        this.f4934d = (LinearLayoutManager) this.f4933c.getLayoutManager();
        m5095f();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m5095f() {
        this.f4935e = 0;
        this.f4936f = 0;
        this.f4937g.m5106a();
        this.f4938h = -1;
        this.f4939i = -1;
        this.f4940j = false;
        this.f4941k = false;
        this.f4943m = false;
        this.f4942l = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
    public void onScrollStateChanged(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
        boolean z = true;
        if ((this.f4935e != 1 || this.f4936f != 1) && OplusGLSurfaceView_13 == 1) {
            m5093a(false);
            return;
        }
        if (m5097h() && OplusGLSurfaceView_13 == 2) {
            if (this.f4941k) {
                m5091a(2);
                this.f4940j = true;
                return;
            }
            return;
        }
        if (m5097h() && OplusGLSurfaceView_13 == 0) {
            m5096g();
            if (!this.f4941k) {
                if (this.f4937g.f4944a != -1) {
                    m5092a(this.f4937g.f4944a, 0.0f, 0);
                }
            } else if (this.f4937g.f4946c != 0) {
                z = false;
            } else if (this.f4938h != this.f4937g.f4944a) {
                m5094b(this.f4937g.f4944a);
            }
            if (z) {
                m5091a(0);
                m5095f();
            }
        }
        if (this.f4935e == 2 && OplusGLSurfaceView_13 == 0 && this.f4942l) {
            m5096g();
            if (this.f4937g.f4946c == 0) {
                if (this.f4939i != this.f4937g.f4944a) {
                    m5094b(this.f4937g.f4944a == -1 ? 0 : this.f4937g.f4944a);
                }
                m5091a(0);
                m5095f();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f4941k = r4
            r3.m5096g()
            boolean r0 = r3.f4940j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L41
            r3.f4940j = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f4932b
            boolean r6 = r6.m5047b()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = r2
            goto L23
        L22:
            r5 = r4
        L23:
            if (r5 == 0) goto L31
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4946c
            if (r5 == 0) goto L31
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4944a
            int r5 = r5 + r4
            goto L35
        L31:
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4944a
        L35:
            r3.f4939i = r5
            int r5 = r3.f4938h
            int r6 = r3.f4939i
            if (r5 == r6) goto L4f
            r3.m5094b(r6)
            goto L4f
        L41:
            int r5 = r3.f4935e
            if (r5 != 0) goto L4f
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4944a
            if (r5 != r1) goto L4c
            r5 = r2
        L4c:
            r3.m5094b(r5)
        L4f:
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4944a
            if (r5 != r1) goto L57
            r5 = r2
            goto L5b
        L57:
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4944a
        L5b:
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r6 = r3.f4937g
            float r6 = r6.f4945b
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r0 = r3.f4937g
            int r0 = r0.f4946c
            r3.m5092a(r5, r6, r0)
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4944a
            int r6 = r3.f4939i
            if (r5 == r6) goto L70
            if (r6 != r1) goto L80
        L70:
            androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 r5 = r3.f4937g
            int r5 = r5.f4946c
            if (r5 != 0) goto L80
            int r5 = r3.f4936f
            if (r5 == r4) goto L80
            r3.m5091a(r2)
            r3.m5095f()
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m5096g() {
        int top;
        PlatformImplementations.kt_3 aVar = this.f4937g;
        aVar.f4944a = this.f4934d.findFirstVisibleItemPosition();
        if (aVar.f4944a == -1) {
            aVar.m5106a();
            return;
        }
        View viewFindViewByPosition = this.f4934d.findViewByPosition(aVar.f4944a);
        if (viewFindViewByPosition == null) {
            aVar.m5106a();
            return;
        }
        int leftDecorationWidth = this.f4934d.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.f4934d.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.f4934d.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.f4934d.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + viewFindViewByPosition.getWidth() + leftDecorationWidth;
        if (this.f4934d.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f4933c.getPaddingLeft();
            if (this.f4932b.m5047b()) {
                top = -top;
            }
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f4933c.getPaddingTop();
            width = height;
        }
        aVar.f4946c = -top;
        if (aVar.f4946c < 0) {
            if (new AnimateLayoutChangeDetector(this.f4934d).m5083a()) {
                throw new IllegalStateException("Page(s) contain PlatformImplementations.kt_3 ViewGroup with PlatformImplementations.kt_3 LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with PlatformImplementations.kt_3 LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by PlatformImplementations.kt_3 positive amount, not by %IntrinsicsJvm.kt_5", Integer.valueOf(aVar.f4946c)));
        }
        aVar.f4945b = width == 0 ? 0.0f : aVar.f4946c / width;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5093a(boolean z) {
        this.f4943m = z;
        this.f4935e = z ? 4 : 1;
        int OplusGLSurfaceView_13 = this.f4939i;
        if (OplusGLSurfaceView_13 != -1) {
            this.f4938h = OplusGLSurfaceView_13;
            this.f4939i = -1;
        } else if (this.f4938h == -1) {
            this.f4938h = m5098i();
        }
        m5091a(1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5099a() {
        this.f4942l = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5100a(int OplusGLSurfaceView_13, boolean z) {
        this.f4935e = z ? 2 : 3;
        this.f4943m = false;
        boolean z2 = this.f4939i != OplusGLSurfaceView_13;
        this.f4939i = OplusGLSurfaceView_13;
        m5091a(2);
        if (z2) {
            m5094b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5101a(ViewPager2.AbstractC0845e abstractC0845e) {
        this.f4931a = abstractC0845e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    int m5102b() {
        return this.f4936f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m5103c() {
        return this.f4936f == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m5104d() {
        return this.f4943m;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m5097h() {
        int OplusGLSurfaceView_13 = this.f4935e;
        return OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 4;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    double m5105e() {
        m5096g();
        return this.f4937g.f4944a + this.f4937g.f4945b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5091a(int OplusGLSurfaceView_13) {
        if ((this.f4935e == 3 && this.f4936f == 0) || this.f4936f == OplusGLSurfaceView_13) {
            return;
        }
        this.f4936f = OplusGLSurfaceView_13;
        ViewPager2.AbstractC0845e abstractC0845e = this.f4931a;
        if (abstractC0845e != null) {
            abstractC0845e.onPageScrollStateChanged(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5094b(int OplusGLSurfaceView_13) {
        ViewPager2.AbstractC0845e abstractC0845e = this.f4931a;
        if (abstractC0845e != null) {
            abstractC0845e.onPageSelected(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5092a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        ViewPager2.AbstractC0845e abstractC0845e = this.f4931a;
        if (abstractC0845e != null) {
            abstractC0845e.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private int m5098i() {
        return this.f4934d.findFirstVisibleItemPosition();
    }

    /* compiled from: ScrollEventAdapter.java */
    /* renamed from: androidx.viewpager2.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4944a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f4945b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f4946c;

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m5106a() {
            this.f4944a = -1;
            this.f4945b = 0.0f;
            this.f4946c = 0;
        }
    }
}
