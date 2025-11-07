package com.coui.appcompat.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: COUIFlingLocateHelper.java */
/* renamed from: com.coui.appcompat.widget.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class COUIFlingLocateHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIRecyclerView f8107a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private OrientationHelper f8109c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RecyclerView.AbstractC0693i f8110d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f8111e;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f8108b = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RecyclerView.AbstractC0698n f8112f = new RecyclerView.AbstractC0698n() { // from class: com.coui.appcompat.widget.COUIBaseListPopupWindow_11.1

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f8113a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
        public void onScrollStateChanged(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
            super.onScrollStateChanged(recyclerView, OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 0 && this.f8113a) {
                this.f8113a = false;
                COUIFlingLocateHelper.this.m7774b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
        public void onScrolled(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
                return;
            }
            this.f8113a = true;
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7780a(COUIRecyclerView cOUIRecyclerView) {
        this.f8107a = cOUIRecyclerView;
        this.f8111e = cOUIRecyclerView.getContext();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7779a(int OplusGLSurfaceView_13) {
        this.f8108b = OplusGLSurfaceView_13;
        this.f8107a.addOnScrollListener(this.f8112f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m7777a() {
        return this.f8108b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7774b() {
        View viewM7778a;
        int iMo4498a;
        int iMo4505d;
        RecyclerView.AbstractC0693i abstractC0693iM7776c = m7776c();
        if (abstractC0693iM7776c == null || (viewM7778a = m7778a(abstractC0693iM7776c)) == null) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f8108b;
        if (OplusGLSurfaceView_13 == 2) {
            int iMo4505d2 = m7773b(abstractC0693iM7776c).mo4505d() + (m7773b(abstractC0693iM7776c).mo4511g() / 2);
            int itemCount = abstractC0693iM7776c.getItemCount() - 1;
            if (abstractC0693iM7776c.getPosition(viewM7778a) == 0) {
                iMo4505d2 = m7771a(this.f8111e) ? m7773b(abstractC0693iM7776c).mo4507e() - (m7773b(abstractC0693iM7776c).mo4508e(viewM7778a) / 2) : m7773b(abstractC0693iM7776c).mo4505d() + (m7773b(abstractC0693iM7776c).mo4508e(viewM7778a) / 2);
            }
            if (abstractC0693iM7776c.getPosition(viewM7778a) == itemCount) {
                iMo4505d2 = m7771a(this.f8111e) ? m7773b(abstractC0693iM7776c).mo4505d() + (m7773b(abstractC0693iM7776c).mo4508e(viewM7778a) / 2) : m7773b(abstractC0693iM7776c).mo4507e() - (m7773b(abstractC0693iM7776c).mo4508e(viewM7778a) / 2);
            }
            int iMo4498a2 = (m7773b(abstractC0693iM7776c).mo4498a(viewM7778a) + (m7773b(abstractC0693iM7776c).mo4508e(viewM7778a) / 2)) - iMo4505d2;
            if (Math.abs(iMo4498a2) > 1.0f) {
                this.f8107a.smoothScrollBy(iMo4498a2, 0);
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (m7771a(this.f8111e)) {
                iMo4498a = m7773b(abstractC0693iM7776c).mo4501b(viewM7778a);
                iMo4505d = m7773b(abstractC0693iM7776c).mo4507e();
            } else {
                iMo4498a = m7773b(abstractC0693iM7776c).mo4498a(viewM7778a);
                iMo4505d = m7773b(abstractC0693iM7776c).mo4505d();
            }
            int i2 = iMo4498a - iMo4505d;
            if (Math.abs(i2) > 1.0f) {
                this.f8107a.smoothScrollBy(i2, 0);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m7769a(RecyclerView.AbstractC0693i abstractC0693i, OrientationHelper abstractC0727n) {
        int childCount = abstractC0693i.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int OplusGLSurfaceView_13 = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = abstractC0693i.getChildAt(i3);
            int position = abstractC0693i.getPosition(childAt);
            if (position != -1 && position != abstractC0693i.getItemCount() - 1 && position != 0) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > OplusGLSurfaceView_13) {
                    view2 = childAt;
                    OplusGLSurfaceView_13 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(abstractC0727n.mo4501b(view), abstractC0727n.mo4501b(view2)) - Math.min(abstractC0727n.mo4498a(view), abstractC0727n.mo4498a(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((OplusGLSurfaceView_13 - i2) + 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m7778a(RecyclerView.AbstractC0693i abstractC0693i) {
        if (abstractC0693i.canScrollHorizontally()) {
            int OplusGLSurfaceView_13 = this.f8108b;
            if (OplusGLSurfaceView_13 == 2) {
                return m7775c(abstractC0693i, m7773b(abstractC0693i));
            }
            if (OplusGLSurfaceView_13 == 1) {
                return m7772b(abstractC0693i, m7773b(abstractC0693i));
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private OrientationHelper m7773b(RecyclerView.AbstractC0693i abstractC0693i) {
        OrientationHelper abstractC0727n = this.f8109c;
        if (abstractC0727n == null || abstractC0727n.m4499a() != abstractC0693i) {
            this.f8109c = OrientationHelper.m4495a(abstractC0693i);
        }
        return this.f8109c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RecyclerView.AbstractC0693i m7776c() {
        RecyclerView.AbstractC0693i abstractC0693i = this.f8110d;
        if (abstractC0693i == null || abstractC0693i != this.f8107a.getLayoutManager()) {
            this.f8110d = this.f8107a.getLayoutManager();
        }
        return this.f8110d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View m7772b(RecyclerView.AbstractC0693i abstractC0693i, OrientationHelper abstractC0727n) {
        int iMo4505d;
        int childCount = abstractC0693i.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (abstractC0693i instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) abstractC0693i).findFirstCompletelyVisibleItemPosition() == abstractC0693i.getItemCount() - 1) {
                return null;
            }
        }
        if (m7771a(this.f8111e)) {
            iMo4505d = abstractC0727n.mo4507e();
        } else {
            iMo4505d = abstractC0727n.mo4505d();
        }
        int OplusGLSurfaceView_13 = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = abstractC0693i.getChildAt(i2);
            int iAbs = Math.abs((m7771a(this.f8111e) ? abstractC0727n.mo4501b(childAt) : abstractC0727n.mo4498a(childAt)) - iMo4505d);
            if (iAbs < OplusGLSurfaceView_13) {
                view = childAt;
                OplusGLSurfaceView_13 = iAbs;
            }
        }
        return view;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View m7775c(RecyclerView.AbstractC0693i abstractC0693i, OrientationHelper abstractC0727n) {
        int childCount = abstractC0693i.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int iMo4505d = abstractC0727n.mo4505d() + (abstractC0727n.mo4511g() / 2);
        int OplusGLSurfaceView_13 = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = abstractC0693i.getChildAt(i2);
            int iAbs = Math.abs((abstractC0727n.mo4498a(childAt) + (abstractC0727n.mo4508e(childAt) / 2)) - iMo4505d);
            if (iAbs < OplusGLSurfaceView_13) {
                view = childAt;
                OplusGLSurfaceView_13 = iAbs;
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m7781b(int OplusGLSurfaceView_13) {
        View viewM7778a;
        int iRound;
        int iMo4498a;
        RecyclerView.AbstractC0693i abstractC0693iM7776c = m7776c();
        int itemCount = abstractC0693iM7776c.getItemCount();
        if (itemCount == 0 || (viewM7778a = m7778a(abstractC0693iM7776c)) == null) {
            return -1;
        }
        int position = abstractC0693iM7776c.getPosition(viewM7778a);
        int i2 = itemCount - 1;
        PointF pointFComputeScrollVectorForPosition = ((RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) abstractC0693iM7776c).computeScrollVectorForPosition(i2);
        if (pointFComputeScrollVectorForPosition == null) {
            return -1;
        }
        float fM7769a = 1.0f;
        if (abstractC0693iM7776c.canScrollHorizontally()) {
            fM7769a = m7769a(abstractC0693iM7776c, m7773b(abstractC0693iM7776c));
            iRound = Math.round(OplusGLSurfaceView_13 / fM7769a);
            if (pointFComputeScrollVectorForPosition.x < 0.0f) {
                iRound = -iRound;
            }
        } else {
            iRound = 0;
        }
        int i3 = iRound + position;
        if (i3 != position && i3 >= 0 && i3 < itemCount) {
            int i4 = this.f8108b;
            if (i4 == 2) {
                View childAt = null;
                if (abstractC0693iM7776c.getPosition(viewM7778a) == 0 && abstractC0693iM7776c.getChildCount() != 0) {
                    childAt = abstractC0693iM7776c.getChildAt(abstractC0693iM7776c.getChildCount() - 1);
                }
                if (abstractC0693iM7776c.getPosition(viewM7778a) == i2 && abstractC0693iM7776c.getChildCount() != 0) {
                    childAt = abstractC0693iM7776c.getChildAt(0);
                }
                int iMo4505d = m7773b(abstractC0693iM7776c).mo4505d() + (m7773b(abstractC0693iM7776c).mo4511g() / 2);
                if (childAt != null) {
                    iMo4498a = m7773b(abstractC0693iM7776c).mo4498a(childAt) + (m7773b(abstractC0693iM7776c).mo4508e(childAt) / 2) + (m7771a(this.f8111e) ? -((int) ((i3 - abstractC0693iM7776c.getPosition(childAt)) * fM7769a)) : (int) ((i3 - abstractC0693iM7776c.getPosition(childAt)) * fM7769a));
                } else {
                    iMo4498a = m7773b(abstractC0693iM7776c).mo4498a(viewM7778a) + (m7773b(abstractC0693iM7776c).mo4508e(viewM7778a) / 2) + (m7771a(this.f8111e) ? -((int) ((i3 - abstractC0693iM7776c.getPosition(viewM7778a)) * fM7769a)) : (int) ((i3 - abstractC0693iM7776c.getPosition(viewM7778a)) * fM7769a));
                }
                return iMo4498a - iMo4505d;
            }
            if (i4 == 1) {
                return ((m7771a(this.f8111e) ? m7773b(abstractC0693iM7776c).mo4501b(viewM7778a) : m7773b(abstractC0693iM7776c).mo4498a(viewM7778a)) + (m7771a(this.f8111e) ? -((int) ((i3 - position) * fM7769a)) : (int) ((i3 - position) * fM7769a))) - (m7771a(this.f8111e) ? m7773b(abstractC0693iM7776c).mo4507e() : m7773b(abstractC0693iM7776c).mo4505d());
            }
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7771a(Context context) {
        return context != null && Build.VERSION.SDK_INT > 16 && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }
}
