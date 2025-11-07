package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.p036h.ActionProvider;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    final C0267a f1551a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final FrameLayout f1552b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final FrameLayout f1553c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    ActionProvider f1554d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final DataSetObserver f1555e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    PopupWindow.OnDismissListener f1556f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean f1557g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    int f1558h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final ViewOnClickListenerC0268b f1559i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final View f1560j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final ImageView f1561k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final int f1562l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final ViewTreeObserver.OnGlobalLayoutListener f1563m;

    /* renamed from: OplusGLSurfaceView_11 */
    private ListPopupWindow f1564n;

    /* renamed from: o */
    private boolean f1565o;

    /* renamed from: p */
    private int f1566p;

    public void setActivityChooserModel(ActivityChooserModel c0331c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f1551a.m1291a(c0331c);
        if (m1288c()) {
            m1287b();
            m1286a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1561k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int OplusGLSurfaceView_13) {
        this.f1561k.setContentDescription(getContext().getString(OplusGLSurfaceView_13));
    }

    public void setProvider(ActionProvider abstractC0491b) {
        this.f1554d = abstractC0491b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1286a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (m1288c() || !this.f1565o) {
            return false;
        }
        this.f1557g = false;
        m1285a(this.f1558h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
    /* renamed from: PlatformImplementations.kt_3 */
    void m1285a(int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f1551a.m1296d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1563m);
        ?? r0 = this.f1553c.getVisibility() == 0 ? 1 : 0;
        int iM1295c = this.f1551a.m1295c();
        if (OplusGLSurfaceView_13 != Integer.MAX_VALUE && iM1295c > OplusGLSurfaceView_13 + r0) {
            this.f1551a.m1292a(true);
            this.f1551a.m1290a(OplusGLSurfaceView_13 - 1);
        } else {
            this.f1551a.m1292a(false);
            this.f1551a.m1290a(OplusGLSurfaceView_13);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.mo1142c()) {
            return;
        }
        if (this.f1557g || r0 == 0) {
            this.f1551a.m1293a(true, r0);
        } else {
            this.f1551a.m1293a(false, false);
        }
        listPopupWindow.m1441h(Math.min(this.f1551a.m1289a(), this.f1562l));
        listPopupWindow.mo1136a_();
        ActionProvider abstractC0491b = this.f1554d;
        if (abstractC0491b != null) {
            abstractC0491b.m2769a(true);
        }
        listPopupWindow.mo1140b_().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        listPopupWindow.mo1140b_().setSelector(new ColorDrawable(0));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m1287b() {
        if (!m1288c()) {
            return true;
        }
        getListPopupWindow().mo1137b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1563m);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m1288c() {
        return getListPopupWindow().mo1142c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel c0331cM1296d = this.f1551a.m1296d();
        if (c0331cM1296d != null) {
            c0331cM1296d.registerObserver(this.f1555e);
        }
        this.f1565o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel c0331cM1296d = this.f1551a.m1296d();
        if (c0331cM1296d != null) {
            c0331cM1296d.unregisterObserver(this.f1555e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1563m);
        }
        if (m1288c()) {
            m1287b();
        }
        this.f1565o = false;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        View view = this.f1560j;
        if (this.f1553c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, OplusGLSurfaceView_13, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f1560j.layout(0, 0, i3 - OplusGLSurfaceView_13, i4 - i2);
        if (m1288c()) {
            return;
        }
        m1287b();
    }

    public ActivityChooserModel getDataModel() {
        return this.f1551a.m1296d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1556f = onDismissListener;
    }

    public void setInitialActivityCount(int OplusGLSurfaceView_13) {
        this.f1558h = OplusGLSurfaceView_13;
    }

    public void setDefaultActionButtonContentDescription(int OplusGLSurfaceView_13) {
        this.f1566p = OplusGLSurfaceView_13;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.f1564n == null) {
            this.f1564n = new ListPopupWindow(getContext());
            this.f1564n.mo1311a(this.f1551a);
            this.f1564n.m1432b(this);
            this.f1564n.m1430a(true);
            this.f1564n.m1428a((AdapterView.OnItemClickListener) this.f1559i);
            this.f1564n.m1429a((PopupWindow.OnDismissListener) this.f1559i);
        }
        return this.f1564n;
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$IntrinsicsJvm.kt_4 */
    private class ViewOnClickListenerC0268b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ ActivityChooserView f1574a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            int itemViewType = ((C0267a) adapterView.getAdapter()).getItemViewType(OplusGLSurfaceView_13);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    this.f1574a.m1285a(Integer.MAX_VALUE);
                    return;
                }
                throw new IllegalArgumentException();
            }
            this.f1574a.m1287b();
            if (this.f1574a.f1557g) {
                if (OplusGLSurfaceView_13 > 0) {
                    this.f1574a.f1551a.m1296d().m1639c(OplusGLSurfaceView_13);
                    return;
                }
                return;
            }
            if (!this.f1574a.f1551a.m1297e()) {
                OplusGLSurfaceView_13++;
            }
            Intent intentM1637b = this.f1574a.f1551a.m1296d().m1637b(OplusGLSurfaceView_13);
            if (intentM1637b != null) {
                intentM1637b.addFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
                this.f1574a.getContext().startActivity(intentM1637b);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (view == this.f1574a.f1553c) {
                this.f1574a.m1287b();
                Intent intentM1637b = this.f1574a.f1551a.m1296d().m1637b(this.f1574a.f1551a.m1296d().m1635a(this.f1574a.f1551a.m1294b()));
                if (intentM1637b != null) {
                    intentM1637b.addFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
                    this.f1574a.getContext().startActivity(intentM1637b);
                    return;
                }
                return;
            }
            if (view == this.f1574a.f1552b) {
                ActivityChooserView activityChooserView = this.f1574a;
                activityChooserView.f1557g = false;
                activityChooserView.m1285a(activityChooserView.f1558h);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (view == this.f1574a.f1553c) {
                if (this.f1574a.f1551a.getCount() > 0) {
                    ActivityChooserView activityChooserView = this.f1574a;
                    activityChooserView.f1557g = true;
                    activityChooserView.m1285a(activityChooserView.f1558h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m1298a();
            if (this.f1574a.f1554d != null) {
                this.f1574a.f1554d.m2769a(false);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m1298a() {
            if (this.f1574a.f1556f != null) {
                this.f1574a.f1556f.onDismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$PlatformImplementations.kt_3 */
    private class C0267a extends BaseAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ ActivityChooserView f1568a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ActivityChooserModel f1569b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f1570c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f1571d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f1572e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f1573f;

        @Override // android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1291a(ActivityChooserModel c0331c) {
            ActivityChooserModel c0331cM1296d = this.f1568a.f1551a.m1296d();
            if (c0331cM1296d != null && this.f1568a.isShown()) {
                c0331cM1296d.unregisterObserver(this.f1568a.f1555e);
            }
            this.f1569b = c0331c;
            if (c0331c != null && this.f1568a.isShown()) {
                c0331c.registerObserver(this.f1568a.f1555e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int OplusGLSurfaceView_13) {
            return (this.f1573f && OplusGLSurfaceView_13 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iM1634a = this.f1569b.m1634a();
            if (!this.f1571d && this.f1569b.m1638b() != null) {
                iM1634a--;
            }
            int iMin = Math.min(iM1634a, this.f1570c);
            return this.f1573f ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int OplusGLSurfaceView_13) {
            int itemViewType = getItemViewType(OplusGLSurfaceView_13);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f1571d && this.f1569b.m1638b() != null) {
                OplusGLSurfaceView_13++;
            }
            return this.f1569b.m1636a(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(OplusGLSurfaceView_13);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View viewInflate = LayoutInflater.from(this.f1568a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((TextView) viewInflate.findViewById(R.id_renamed.title)).setText(this.f1568a.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                    return viewInflate;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != R.id_renamed.list_item) {
                view = LayoutInflater.from(this.f1568a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = this.f1568a.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R.id_renamed.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(OplusGLSurfaceView_13);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R.id_renamed.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f1571d && OplusGLSurfaceView_13 == 0 && this.f1572e) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m1289a() {
            int OplusGLSurfaceView_13 = this.f1570c;
            this.f1570c = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int iMax = 0;
            View view = null;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f1570c = OplusGLSurfaceView_13;
            return iMax;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1290a(int OplusGLSurfaceView_13) {
            if (this.f1570c != OplusGLSurfaceView_13) {
                this.f1570c = OplusGLSurfaceView_13;
                notifyDataSetChanged();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public ResolveInfo m1294b() {
            return this.f1569b.m1638b();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1292a(boolean z) {
            if (this.f1573f != z) {
                this.f1573f = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m1295c() {
            return this.f1569b.m1634a();
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public ActivityChooserModel m1296d() {
            return this.f1569b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1293a(boolean z, boolean z2) {
            if (this.f1571d == z && this.f1572e == z2) {
                return;
            }
            this.f1571d = z;
            this.f1572e = z2;
            notifyDataSetChanged();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean m1297e() {
            return this.f1571d;
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final int[] f1567a = {android.R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray c0322arM1540a = TintTypedArray.m1540a(context, attributeSet, f1567a);
            setBackgroundDrawable(c0322arM1540a.m1546a(0));
            c0322arM1540a.m1551b();
        }
    }
}
