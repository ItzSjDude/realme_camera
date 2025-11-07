package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: A */
    private boolean f3732A;

    /* renamed from: B */
    private boolean f3733B;

    /* renamed from: C */
    private boolean f3734C;

    /* renamed from: D */
    private boolean f3735D;

    /* renamed from: E */
    private boolean f3736E;

    /* renamed from: F */
    private boolean f3737F;

    /* renamed from: G */
    private int f3738G;

    /* renamed from: H */
    private int f3739H;

    /* renamed from: I */
    private InterfaceC0643a f3740I;

    /* renamed from: J */
    private List<Preference> f3741J;

    /* renamed from: K */
    private PreferenceGroup f3742K;

    /* renamed from: L */
    private boolean f3743L;

    /* renamed from: M */
    private boolean f3744M;

    /* renamed from: N */
    private MenuItemOnMenuItemClickListenerC0646d f3745N;

    /* renamed from: O */
    private InterfaceC0647e f3746O;

    /* renamed from: P */
    private final View.OnClickListener f3747P;

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f3748a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PreferenceManager f3749b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PreferenceDataStore f3750c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private long f3751d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f3752e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private InterfaceC0644b f3753f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private InterfaceC0645c f3754g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f3755h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f3756i;

    /* renamed from: OplusGLSurfaceView_15 */
    private CharSequence f3757j;

    /* renamed from: OplusGLSurfaceView_5 */
    private CharSequence f3758k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f3759l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Drawable f3760m;

    /* renamed from: OplusGLSurfaceView_11 */
    private String f3761n;

    /* renamed from: o */
    private Intent f3762o;

    /* renamed from: p */
    private String f3763p;

    /* renamed from: q */
    private Bundle f3764q;

    /* renamed from: r */
    private boolean f3765r;

    /* renamed from: s */
    private boolean f3766s;

    /* renamed from: t */
    private boolean f3767t;

    /* renamed from: u */
    private String f3768u;

    /* renamed from: v */
    private Object f3769v;

    /* renamed from: w */
    private boolean f3770w;

    /* renamed from: x */
    private boolean f3771x;

    /* renamed from: y */
    private boolean f3772y;

    /* renamed from: z */
    private boolean f3773z;

    /* renamed from: androidx.preference.Preference$PlatformImplementations.kt_3 */
    interface InterfaceC0643a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3861a(Preference preference);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo3862b(Preference preference);
    }

    /* renamed from: androidx.preference.Preference$IntrinsicsJvm.kt_4 */
    public interface InterfaceC0644b {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    /* renamed from: androidx.preference.Preference$IntrinsicsJvm.kt_3 */
    public interface InterfaceC0645c {
        boolean onPreferenceClick(Preference preference);
    }

    /* renamed from: androidx.preference.Preference$COUIBaseListPopupWindow_8 */
    public interface InterfaceC0647e<T extends Preference> {
        /* renamed from: PlatformImplementations.kt_3 */
        CharSequence mo3762a(T t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected Object mo3749a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        return null;
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3815a(AccessibilityNodeInfoCompat c0483d) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3751a(Object obj) {
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo3743g() {
    }

    public Preference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        this.f3755h = Integer.MAX_VALUE;
        this.f3756i = 0;
        this.f3765r = true;
        this.f3766s = true;
        this.f3767t = true;
        this.f3770w = true;
        this.f3771x = true;
        this.f3772y = true;
        this.f3773z = true;
        this.f3732A = true;
        this.f3734C = true;
        this.f3737F = true;
        this.f3738G = R.layout.preference;
        this.f3747P = new View.OnClickListener() { // from class: androidx.preference.Preference.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Preference.this.mo3735a(view);
            }
        };
        this.f3748a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, OplusGLSurfaceView_13, i2);
        this.f3759l = TypedArrayUtils.m2318b(typedArrayObtainStyledAttributes, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.f3761n = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.f3757j = TypedArrayUtils.m2323c(typedArrayObtainStyledAttributes, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.f3758k = TypedArrayUtils.m2323c(typedArrayObtainStyledAttributes, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.f3755h = TypedArrayUtils.m2307a(typedArrayObtainStyledAttributes, R.styleable.Preference_order, R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.f3763p = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        this.f3738G = TypedArrayUtils.m2318b(typedArrayObtainStyledAttributes, R.styleable.Preference_layout, R.styleable.Preference_android_layout, R.layout.preference);
        this.f3739H = TypedArrayUtils.m2318b(typedArrayObtainStyledAttributes, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.f3765r = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        this.f3766s = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        this.f3767t = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        this.f3768u = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        this.f3773z = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_allowDividerAbove, R.styleable.Preference_allowDividerAbove, this.f3766s);
        this.f3732A = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_allowDividerBelow, R.styleable.Preference_allowDividerBelow, this.f3766s);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.Preference_defaultValue)) {
            this.f3769v = mo3749a(typedArrayObtainStyledAttributes, R.styleable.Preference_defaultValue);
        } else if (typedArrayObtainStyledAttributes.hasValue(R.styleable.Preference_android_defaultValue)) {
            this.f3769v = mo3749a(typedArrayObtainStyledAttributes, R.styleable.Preference_android_defaultValue);
        }
        this.f3737F = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        this.f3733B = typedArrayObtainStyledAttributes.hasValue(R.styleable.Preference_singleLineTitle);
        if (this.f3733B) {
            this.f3734C = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_singleLineTitle, R.styleable.Preference_android_singleLineTitle, true);
        }
        this.f3735D = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        this.f3772y = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_isPreferenceVisible, R.styleable.Preference_isPreferenceVisible, true);
        this.f3736E = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.Preference_enableCopying, R.styleable.Preference_enableCopying, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3812a(Intent intent) {
        this.f3762o = intent;
    }

    /* renamed from: q */
    public Intent m3849q() {
        return this.f3762o;
    }

    /* renamed from: r */
    public String m3850r() {
        return this.f3763p;
    }

    /* renamed from: s */
    public PreferenceDataStore m3851s() {
        PreferenceDataStore abstractC0661e = this.f3750c;
        if (abstractC0661e != null) {
            return abstractC0661e;
        }
        PreferenceManager c0666j = this.f3749b;
        if (c0666j != null) {
            return c0666j.m3997b();
        }
        return null;
    }

    /* renamed from: t */
    public Bundle m3852t() {
        if (this.f3764q == null) {
            this.f3764q = new Bundle();
        }
        return this.f3764q;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3811a(int OplusGLSurfaceView_13) {
        this.f3738G = OplusGLSurfaceView_13;
    }

    /* renamed from: u */
    public final int m3853u() {
        return this.f3738G;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3826b(int OplusGLSurfaceView_13) {
        this.f3739H = OplusGLSurfaceView_13;
    }

    /* renamed from: v */
    public final int m3854v() {
        return this.f3739H;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        Integer numValueOf;
        View view = c0668l.itemView;
        view.setOnClickListener(this.f3747P);
        view.setId(this.f3756i);
        TextView textView = (TextView) c0668l.m4007a(android.R.id_renamed.summary);
        if (textView != null) {
            CharSequence charSequenceMo3769n = mo3769n();
            if (!TextUtils.isEmpty(charSequenceMo3769n)) {
                textView.setText(charSequenceMo3769n);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            } else {
                textView.setVisibility(8);
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) c0668l.m4007a(android.R.id_renamed.title);
        if (textView2 != null) {
            CharSequence charSequenceM3856x = m3856x();
            if (!TextUtils.isEmpty(charSequenceM3856x)) {
                textView2.setText(charSequenceM3856x);
                textView2.setVisibility(0);
                if (this.f3733B) {
                    textView2.setSingleLine(this.f3734C);
                }
                if (!m3858z() && mo3857y() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            } else {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) c0668l.m4007a(android.R.id_renamed.icon);
        if (imageView != null) {
            if (this.f3759l != 0 || this.f3760m != null) {
                if (this.f3760m == null) {
                    this.f3760m = AppCompatResources.m732b(this.f3748a, this.f3759l);
                }
                Drawable drawable = this.f3760m;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f3760m != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.f3735D ? 4 : 8);
            }
        }
        View viewM4007a = c0668l.m4007a(R.id_renamed.icon_frame);
        if (viewM4007a == null) {
            viewM4007a = c0668l.m4007a(android.R.id_renamed.icon_frame);
        }
        if (viewM4007a != null) {
            if (this.f3760m != null) {
                viewM4007a.setVisibility(0);
            } else {
                viewM4007a.setVisibility(this.f3735D ? 4 : 8);
            }
        }
        if (this.f3737F) {
            m3784a(view, mo3857y());
        } else {
            m3784a(view, true);
        }
        boolean zM3858z = m3858z();
        view.setFocusable(zM3858z);
        view.setClickable(zM3858z);
        c0668l.m4008a(this.f3773z);
        c0668l.m4010b(this.f3732A);
        boolean zM3795F = m3795F();
        if (zM3795F && this.f3745N == null) {
            this.f3745N = new MenuItemOnMenuItemClickListenerC0646d(this);
        }
        view.setOnCreateContextMenuListener(zM3795F ? this.f3745N : null);
        view.setLongClickable(zM3795F);
        if (!zM3795F || zM3858z) {
            return;
        }
        ViewCompat.m2850a(view, (Drawable) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3784a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m3784a(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m3835c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f3755h) {
            this.f3755h = OplusGLSurfaceView_13;
            m3802M();
        }
    }

    /* renamed from: w */
    public int m3855w() {
        return this.f3755h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3829b(CharSequence charSequence) {
        if ((charSequence != null || this.f3757j == null) && (charSequence == null || charSequence.equals(this.f3757j))) {
            return;
        }
        this.f3757j = charSequence;
        mo3748i();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m3840d(int OplusGLSurfaceView_13) {
        mo3829b((CharSequence) this.f3748a.getString(OplusGLSurfaceView_13));
    }

    /* renamed from: x */
    public CharSequence m3856x() {
        return this.f3757j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3813a(Drawable drawable) {
        if (this.f3760m != drawable) {
            this.f3760m = drawable;
            this.f3759l = 0;
            mo3748i();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m3845e(int OplusGLSurfaceView_13) {
        m3813a(AppCompatResources.m732b(this.f3748a, OplusGLSurfaceView_13));
        this.f3759l = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public CharSequence mo3769n() {
        if (m3796G() != null) {
            return m3796G().mo3762a(this);
        }
        return this.f3758k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3764a(CharSequence charSequence) {
        if (m3796G() != null) {
            throw new IllegalStateException("Preference already has PlatformImplementations.kt_3 SummaryProvider set.");
        }
        if (TextUtils.equals(this.f3758k, charSequence)) {
            return;
        }
        this.f3758k = charSequence;
        mo3748i();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m3846f(int OplusGLSurfaceView_13) {
        mo3764a((CharSequence) this.f3748a.getString(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3824a(boolean z) {
        if (this.f3765r != z) {
            this.f3765r = z;
            mo3830b(mo3754j());
            mo3748i();
        }
    }

    /* renamed from: y */
    public boolean mo3857y() {
        return this.f3765r && this.f3770w && this.f3771x;
    }

    /* renamed from: z */
    public boolean m3858z() {
        return this.f3766s;
    }

    /* renamed from: A */
    public final boolean m3790A() {
        return this.f3772y;
    }

    /* renamed from: c_ */
    long mo3839c_() {
        return this.f3751d;
    }

    /* renamed from: B */
    public String m3791B() {
        return this.f3761n;
    }

    /* renamed from: C */
    public boolean m3792C() {
        return !TextUtils.isEmpty(this.f3761n);
    }

    /* renamed from: D */
    public boolean m3793D() {
        return this.f3767t;
    }

    /* renamed from: E */
    protected boolean m3794E() {
        return this.f3749b != null && m3793D() && m3792C();
    }

    /* renamed from: F */
    public boolean m3795F() {
        return this.f3736E;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m3819a(InterfaceC0647e interfaceC0647e) {
        this.f3746O = interfaceC0647e;
        mo3748i();
    }

    /* renamed from: G */
    public final InterfaceC0647e m3796G() {
        return this.f3746O;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3831b(Object obj) {
        InterfaceC0644b interfaceC0644b = this.f3753f;
        return interfaceC0644b == null || interfaceC0644b.onPreferenceChange(this, obj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3817a(InterfaceC0644b interfaceC0644b) {
        this.f3753f = interfaceC0644b;
    }

    /* renamed from: H */
    public InterfaceC0644b m3797H() {
        return this.f3753f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3818a(InterfaceC0645c interfaceC0645c) {
        this.f3754g = interfaceC0645c;
    }

    /* renamed from: I */
    public InterfaceC0645c m3798I() {
        return this.f3754g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3735a(View view) {
        m3799J();
    }

    /* renamed from: J */
    public void m3799J() {
        PreferenceManager.IntrinsicsJvm.kt_3 cVarM4003h;
        if (mo3857y() && m3858z()) {
            mo3743g();
            InterfaceC0645c interfaceC0645c = this.f3754g;
            if (interfaceC0645c == null || !interfaceC0645c.onPreferenceClick(this)) {
                PreferenceManager c0666jM3803N = m3803N();
                if ((c0666jM3803N == null || (cVarM4003h = c0666jM3803N.m4003h()) == null || !cVarM4003h.mo3940a(this)) && this.f3762o != null) {
                    m3800K().startActivity(this.f3762o);
                }
            }
        }
    }

    /* renamed from: K */
    public Context m3800K() {
        return this.f3748a;
    }

    /* renamed from: L */
    public SharedPreferences m3801L() {
        if (this.f3749b == null || m3851s() != null) {
            return null;
        }
        return this.f3749b.m3998c();
    }

    @Override // java.lang.Comparable
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int OplusGLSurfaceView_13 = this.f3755h;
        int i2 = preference.f3755h;
        if (OplusGLSurfaceView_13 != i2) {
            return OplusGLSurfaceView_13 - i2;
        }
        CharSequence charSequence = this.f3757j;
        CharSequence charSequence2 = preference.f3757j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f3757j.toString());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m3816a(InterfaceC0643a interfaceC0643a) {
        this.f3740I = interfaceC0643a;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected void mo3748i() {
        InterfaceC0643a interfaceC0643a = this.f3740I;
        if (interfaceC0643a != null) {
            interfaceC0643a.mo3861a(this);
        }
    }

    /* renamed from: M */
    protected void m3802M() {
        InterfaceC0643a interfaceC0643a = this.f3740I;
        if (interfaceC0643a != null) {
            interfaceC0643a.mo3862b(this);
        }
    }

    /* renamed from: N */
    public PreferenceManager m3803N() {
        return this.f3749b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m3822a(PreferenceManager c0666j) {
        this.f3749b = c0666j;
        if (!this.f3752e) {
            this.f3751d = c0666j.m3987a();
        }
        m3789d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m3823a(PreferenceManager c0666j, long OplusGLSurfaceView_15) {
        this.f3751d = OplusGLSurfaceView_15;
        this.f3752e = true;
        try {
            m3822a(c0666j);
        } finally {
            this.f3752e = false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3821a(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.f3742K != null) {
            throw new IllegalStateException("This preference already has PlatformImplementations.kt_3 parent. You must remove the existing parent before assigning PlatformImplementations.kt_3 new one.");
        }
        this.f3742K = preferenceGroup;
    }

    /* renamed from: O */
    public void mo3804O() {
        m3785b();
    }

    /* renamed from: P */
    public void mo3805P() {
        m3787c();
        this.f3743L = true;
    }

    /* renamed from: Q */
    final void m3806Q() {
        this.f3743L = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3785b() {
        if (TextUtils.isEmpty(this.f3768u)) {
            return;
        }
        Preference preferenceM3833c = m3833c(this.f3768u);
        if (preferenceM3833c != null) {
            preferenceM3833c.m3786b(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.f3768u + "\" not found for preference \"" + this.f3761n + "\" (title: \"" + ((Object) this.f3757j) + "\"");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3787c() {
        Preference preferenceM3833c;
        String str = this.f3768u;
        if (str == null || (preferenceM3833c = m3833c(str)) == null) {
            return;
        }
        preferenceM3833c.m3788c(this);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected <T extends Preference> T m3833c(String str) {
        PreferenceManager c0666j = this.f3749b;
        if (c0666j == null) {
            return null;
        }
        return (T) c0666j.m3988a((CharSequence) str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3786b(Preference preference) {
        if (this.f3741J == null) {
            this.f3741J = new ArrayList();
        }
        this.f3741J.add(preference);
        preference.m3820a(this, mo3754j());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3788c(Preference preference) {
        List<Preference> list = this.f3741J;
        if (list != null) {
            list.remove(preference);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3830b(boolean z) {
        List<Preference> list = this.f3741J;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            list.get(OplusGLSurfaceView_13).m3820a(this, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3820a(Preference preference, boolean z) {
        if (this.f3770w == z) {
            this.f3770w = !z;
            mo3830b(mo3754j());
            mo3748i();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3828b(Preference preference, boolean z) {
        if (this.f3771x == z) {
            this.f3771x = !z;
            mo3830b(mo3754j());
            mo3748i();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo3754j() {
        return !mo3857y();
    }

    /* renamed from: R */
    public PreferenceGroup m3807R() {
        return this.f3742K;
    }

    /* renamed from: S */
    protected void m3808S() {
        m3787c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m3837c(Object obj) {
        this.f3769v = obj;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3789d() {
        if (m3851s() != null) {
            mo3825a(true, this.f3769v);
            return;
        }
        if (!m3794E() || !m3801L().contains(this.f3761n)) {
            Object obj = this.f3769v;
            if (obj != null) {
                mo3825a(false, obj);
                return;
            }
            return;
        }
        mo3825a(true, (Object) null);
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3825a(boolean z, Object obj) {
        mo3751a(obj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3783a(SharedPreferences.Editor editor) {
        if (this.f3749b.m4001f()) {
            editor.apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean m3842d(String str) {
        if (!m3794E()) {
            return false;
        }
        if (TextUtils.equals(str, m3844e((String) null))) {
            return true;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            abstractC0661eM3851s.m3921a(this.f3761n, str);
        } else {
            SharedPreferences.Editor editorM4000e = this.f3749b.m4000e();
            editorM4000e.putString(this.f3761n, str);
            m3783a(editorM4000e);
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected String m3844e(String str) {
        if (!m3794E()) {
            return str;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            return abstractC0661eM3851s.m3925b(this.f3761n, str);
        }
        return this.f3749b.m3998c().getString(this.f3761n, str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3832b(Set<String> set) {
        if (!m3794E()) {
            return false;
        }
        if (set.equals(m3834c((Set<String>) null))) {
            return true;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            abstractC0661eM3851s.m3922a(this.f3761n, set);
        } else {
            SharedPreferences.Editor editorM4000e = this.f3749b.m4000e();
            editorM4000e.putStringSet(this.f3761n, set);
            m3783a(editorM4000e);
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Set<String> m3834c(Set<String> set) {
        if (!m3794E()) {
            return set;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            return abstractC0661eM3851s.m3926b(this.f3761n, set);
        }
        return this.f3749b.m3998c().getStringSet(this.f3761n, set);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected boolean m3847g(int OplusGLSurfaceView_13) {
        if (!m3794E()) {
            return false;
        }
        if (OplusGLSurfaceView_13 == m3848h(~OplusGLSurfaceView_13)) {
            return true;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            abstractC0661eM3851s.m3920a(this.f3761n, OplusGLSurfaceView_13);
        } else {
            SharedPreferences.Editor editorM4000e = this.f3749b.m4000e();
            editorM4000e.putInt(this.f3761n, OplusGLSurfaceView_13);
            m3783a(editorM4000e);
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int m3848h(int OplusGLSurfaceView_13) {
        if (!m3794E()) {
            return OplusGLSurfaceView_13;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            return abstractC0661eM3851s.m3924b(this.f3761n, OplusGLSurfaceView_13);
        }
        return this.f3749b.m3998c().getInt(this.f3761n, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean mo3838c(boolean z) {
        if (!m3794E()) {
            return false;
        }
        if (z == mo3843d(!z)) {
            return true;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            abstractC0661eM3851s.m3923a(this.f3761n, z);
        } else {
            SharedPreferences.Editor editorM4000e = this.f3749b.m4000e();
            editorM4000e.putBoolean(this.f3761n, z);
            m3783a(editorM4000e);
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean mo3843d(boolean z) {
        if (!m3794E()) {
            return z;
        }
        PreferenceDataStore abstractC0661eM3851s = m3851s();
        if (abstractC0661eM3851s != null) {
            return abstractC0661eM3851s.m3927b(this.f3761n, z);
        }
        return this.f3749b.m3998c().getBoolean(this.f3761n, z);
    }

    public String toString() {
        return m3809T().toString();
    }

    /* renamed from: T */
    StringBuilder m3809T() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceM3856x = m3856x();
        if (!TextUtils.isEmpty(charSequenceM3856x)) {
            sb.append(charSequenceM3856x);
            sb.append(' ');
        }
        CharSequence charSequenceMo3769n = mo3769n();
        if (!TextUtils.isEmpty(charSequenceMo3769n)) {
            sb.append(charSequenceMo3769n);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3814a(Bundle bundle) {
        mo3827b(bundle);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo3827b(Bundle bundle) {
        if (m3792C()) {
            this.f3744M = false;
            Parcelable parcelableMo3755k = mo3755k();
            if (!this.f3744M) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableMo3755k != null) {
                bundle.putParcelable(this.f3761n, parcelableMo3755k);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        this.f3744M = true;
        return BaseSavedState.EMPTY_STATE;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m3836c(Bundle bundle) {
        mo3841d(bundle);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo3841d(Bundle bundle) {
        Parcelable parcelable;
        if (!m3792C() || (parcelable = bundle.getParcelable(this.f3761n)) == null) {
            return;
        }
        this.f3744M = false;
        mo3750a(parcelable);
        if (!this.f3744M) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3750a(Parcelable parcelable) {
        this.f3744M = true;
        if (parcelable != BaseSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() { // from class: androidx.preference.Preference.BaseSavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public BaseSavedState[] newArray(int OplusGLSurfaceView_13) {
                return new BaseSavedState[OplusGLSurfaceView_13];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: androidx.preference.Preference$IntrinsicsJvm.kt_5 */
    private static class MenuItemOnMenuItemClickListenerC0646d implements MenuItem.OnMenuItemClickListener, View.OnCreateContextMenuListener {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Preference f3775a;

        MenuItemOnMenuItemClickListenerC0646d(Preference preference) {
            this.f3775a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence charSequenceMo3769n = this.f3775a.mo3769n();
            if (!this.f3775a.m3795F() || TextUtils.isEmpty(charSequenceMo3769n)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceMo3769n);
            contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f3775a.m3800K().getSystemService("clipboard");
            CharSequence charSequenceMo3769n = this.f3775a.mo3769n();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceMo3769n));
            Toast.makeText(this.f3775a.m3800K(), this.f3775a.m3800K().getString(R.string.preference_copied, charSequenceMo3769n), 0).show();
            return true;
        }
    }
}
