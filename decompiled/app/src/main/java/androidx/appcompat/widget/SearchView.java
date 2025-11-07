package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.p036h.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.p021b.p022a.CursorAdapter;
import com.google.android.exoplayer2.C1547C;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: OplusGLSurfaceView_13 */
    static final C0290a f1618i = new C0290a();

    /* renamed from: A */
    private InterfaceC0292c f1619A;

    /* renamed from: B */
    private InterfaceC0291b f1620B;

    /* renamed from: C */
    private InterfaceC0293d f1621C;

    /* renamed from: D */
    private View.OnClickListener f1622D;

    /* renamed from: E */
    private boolean f1623E;

    /* renamed from: F */
    private boolean f1624F;

    /* renamed from: G */
    private boolean f1625G;

    /* renamed from: H */
    private CharSequence f1626H;

    /* renamed from: I */
    private boolean f1627I;

    /* renamed from: J */
    private boolean f1628J;

    /* renamed from: K */
    private int f1629K;

    /* renamed from: L */
    private boolean f1630L;

    /* renamed from: M */
    private CharSequence f1631M;

    /* renamed from: N */
    private CharSequence f1632N;

    /* renamed from: O */
    private boolean f1633O;

    /* renamed from: P */
    private int f1634P;

    /* renamed from: Q */
    private Bundle f1635Q;

    /* renamed from: R */
    private final Runnable f1636R;

    /* renamed from: S */
    private Runnable f1637S;

    /* renamed from: T */
    private final WeakHashMap<String, Drawable.ConstantState> f1638T;

    /* renamed from: U */
    private final View.OnClickListener f1639U;

    /* renamed from: V */
    private final TextView.OnEditorActionListener f1640V;

    /* renamed from: W */
    private final AdapterView.OnItemClickListener f1641W;

    /* renamed from: PlatformImplementations.kt_3 */
    final SearchAutoComplete f1642a;

    /* renamed from: aa */
    private final AdapterView.OnItemSelectedListener f1643aa;

    /* renamed from: ab */
    private TextWatcher f1644ab;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final ImageView f1645b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final ImageView f1646c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final ImageView f1647d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final ImageView f1648e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    View.OnFocusChangeListener f1649f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    CursorAdapter f1650g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    SearchableInfo f1651h;

    /* renamed from: OplusGLSurfaceView_15 */
    View.OnKeyListener f1652j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final View f1653k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final View f1654l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final View f1655m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final View f1656n;

    /* renamed from: o */
    private C0294e f1657o;

    /* renamed from: p */
    private Rect f1658p;

    /* renamed from: q */
    private Rect f1659q;

    /* renamed from: r */
    private int[] f1660r;

    /* renamed from: s */
    private int[] f1661s;

    /* renamed from: t */
    private final ImageView f1662t;

    /* renamed from: u */
    private final Drawable f1663u;

    /* renamed from: v */
    private final int f1664v;

    /* renamed from: w */
    private final int f1665w;

    /* renamed from: x */
    private final Intent f1666x;

    /* renamed from: y */
    private final Intent f1667y;

    /* renamed from: z */
    private final CharSequence f1668z;

    /* renamed from: androidx.appcompat.widget.SearchView$IntrinsicsJvm.kt_4 */
    public interface InterfaceC0291b {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m1373a();
    }

    /* renamed from: androidx.appcompat.widget.SearchView$IntrinsicsJvm.kt_3 */
    public interface InterfaceC0292c {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m1374a(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m1375b(String str);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$IntrinsicsJvm.kt_5 */
    public interface InterfaceC0293d {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m1376a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m1377b(int OplusGLSurfaceView_13);
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f1658p = new Rect();
        this.f1659q = new Rect();
        this.f1660r = new int[2];
        this.f1661s = new int[2];
        this.f1636R = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.m1357d();
            }
        };
        this.f1637S = new Runnable() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.f1650g instanceof SuggestionsAdapter) {
                    SearchView.this.f1650g.mo1526a((Cursor) null);
                }
            }
        };
        this.f1638T = new WeakHashMap<>();
        this.f1639U = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (view == SearchView.this.f1645b) {
                    SearchView.this.m1360g();
                    return;
                }
                if (view == SearchView.this.f1647d) {
                    SearchView.this.m1359f();
                    return;
                }
                if (view == SearchView.this.f1646c) {
                    SearchView.this.m1358e();
                } else if (view == SearchView.this.f1648e) {
                    SearchView.this.m1361h();
                } else if (view == SearchView.this.f1642a) {
                    SearchView.this.m1364k();
                }
            }
        };
        this.f1652j = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.f1651h == null) {
                    return false;
                }
                if (SearchView.this.f1642a.isPopupShowing() && SearchView.this.f1642a.getListSelection() != -1) {
                    return SearchView.this.m1354a(view, i2, keyEvent);
                }
                if (SearchView.this.f1642a.m1368a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView = SearchView.this;
                searchView.m1349a(0, (String) null, searchView.f1642a.getText().toString());
                return true;
            }
        };
        this.f1640V = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.m1358e();
                return true;
            }
        };
        this.f1641W = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                SearchView.this.m1353a(i2, 0, (String) null);
            }
        };
        this.f1643aa = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                SearchView.this.m1352a(i2);
            }
        };
        this.f1644ab = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.m1355b(charSequence);
            }
        };
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(context, attributeSet, R.styleable.SearchView, OplusGLSurfaceView_13, 0);
        LayoutInflater.from(context).inflate(c0322arM1541a.m1560g(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        this.f1642a = (SearchAutoComplete) findViewById(R.id_renamed.search_src_text);
        this.f1642a.setSearchView(this);
        this.f1653k = findViewById(R.id_renamed.search_edit_frame);
        this.f1654l = findViewById(R.id_renamed.search_plate);
        this.f1655m = findViewById(R.id_renamed.submit_area);
        this.f1645b = (ImageView) findViewById(R.id_renamed.search_button);
        this.f1646c = (ImageView) findViewById(R.id_renamed.search_go_btn);
        this.f1647d = (ImageView) findViewById(R.id_renamed.search_close_btn);
        this.f1648e = (ImageView) findViewById(R.id_renamed.search_voice_btn);
        this.f1662t = (ImageView) findViewById(R.id_renamed.search_mag_icon);
        ViewCompat.m2850a(this.f1654l, c0322arM1541a.m1546a(R.styleable.SearchView_queryBackground));
        ViewCompat.m2850a(this.f1655m, c0322arM1541a.m1546a(R.styleable.SearchView_submitBackground));
        this.f1645b.setImageDrawable(c0322arM1541a.m1546a(R.styleable.SearchView_searchIcon));
        this.f1646c.setImageDrawable(c0322arM1541a.m1546a(R.styleable.SearchView_goIcon));
        this.f1647d.setImageDrawable(c0322arM1541a.m1546a(R.styleable.SearchView_closeIcon));
        this.f1648e.setImageDrawable(c0322arM1541a.m1546a(R.styleable.SearchView_voiceIcon));
        this.f1662t.setImageDrawable(c0322arM1541a.m1546a(R.styleable.SearchView_searchIcon));
        this.f1663u = c0322arM1541a.m1546a(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.m1605a(this.f1645b, getResources().getString(R.string.abc_searchview_description_search));
        this.f1664v = c0322arM1541a.m1560g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.f1665w = c0322arM1541a.m1560g(R.styleable.SearchView_commitIcon, 0);
        this.f1645b.setOnClickListener(this.f1639U);
        this.f1647d.setOnClickListener(this.f1639U);
        this.f1646c.setOnClickListener(this.f1639U);
        this.f1648e.setOnClickListener(this.f1639U);
        this.f1642a.setOnClickListener(this.f1639U);
        this.f1642a.addTextChangedListener(this.f1644ab);
        this.f1642a.setOnEditorActionListener(this.f1640V);
        this.f1642a.setOnItemClickListener(this.f1641W);
        this.f1642a.setOnItemSelectedListener(this.f1643aa);
        this.f1642a.setOnKeyListener(this.f1652j);
        this.f1642a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f1649f != null) {
                    SearchView.this.f1649f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(c0322arM1541a.m1547a(R.styleable.SearchView_iconifiedByDefault, true));
        int iM1556e = c0322arM1541a.m1556e(R.styleable.SearchView_android_maxWidth, -1);
        if (iM1556e != -1) {
            setMaxWidth(iM1556e);
        }
        this.f1668z = c0322arM1541a.m1553c(R.styleable.SearchView_defaultQueryHint);
        this.f1626H = c0322arM1541a.m1553c(R.styleable.SearchView_queryHint);
        int iM1544a = c0322arM1541a.m1544a(R.styleable.SearchView_android_imeOptions, -1);
        if (iM1544a != -1) {
            setImeOptions(iM1544a);
        }
        int iM1544a2 = c0322arM1541a.m1544a(R.styleable.SearchView_android_inputType, -1);
        if (iM1544a2 != -1) {
            setInputType(iM1544a2);
        }
        setFocusable(c0322arM1541a.m1547a(R.styleable.SearchView_android_focusable, true));
        c0322arM1541a.m1551b();
        this.f1666x = new Intent("android.speech.action.WEB_SEARCH");
        this.f1666x.addFlags(C1547C.ENCODING_PCM_MU_LAW);
        this.f1666x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f1667y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1667y.addFlags(C1547C.ENCODING_PCM_MU_LAW);
        this.f1656n = findViewById(this.f1642a.getDropDownAnchor());
        View view = this.f1656n;
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.5
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    SearchView.this.m1363j();
                }
            });
        }
        m1333a(this.f1623E);
        m1346q();
    }

    int getSuggestionRowLayout() {
        return this.f1664v;
    }

    int getSuggestionCommitIconResId() {
        return this.f1665w;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1651h = searchableInfo;
        if (this.f1651h != null) {
            m1347r();
            m1346q();
        }
        this.f1630L = m1341l();
        if (this.f1630L) {
            this.f1642a.setPrivateImeOptions("nm");
        }
        m1333a(m1356c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1635Q = bundle;
    }

    public void setImeOptions(int OplusGLSurfaceView_13) {
        this.f1642a.setImeOptions(OplusGLSurfaceView_13);
    }

    public int getImeOptions() {
        return this.f1642a.getImeOptions();
    }

    public void setInputType(int OplusGLSurfaceView_13) {
        this.f1642a.setInputType(OplusGLSurfaceView_13);
    }

    public int getInputType() {
        return this.f1642a.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int OplusGLSurfaceView_13, Rect rect) {
        if (this.f1628J || !isFocusable()) {
            return false;
        }
        if (!m1356c()) {
            boolean zRequestFocus = this.f1642a.requestFocus(OplusGLSurfaceView_13, rect);
            if (zRequestFocus) {
                m1333a(false);
            }
            return zRequestFocus;
        }
        return super.requestFocus(OplusGLSurfaceView_13, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f1628J = true;
        super.clearFocus();
        this.f1642a.clearFocus();
        this.f1642a.setImeVisibility(false);
        this.f1628J = false;
    }

    public void setOnQueryTextListener(InterfaceC0292c interfaceC0292c) {
        this.f1619A = interfaceC0292c;
    }

    public void setOnCloseListener(InterfaceC0291b interfaceC0291b) {
        this.f1620B = interfaceC0291b;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1649f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(InterfaceC0293d interfaceC0293d) {
        this.f1621C = interfaceC0293d;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1622D = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1642a.getText();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1351a(CharSequence charSequence, boolean z) {
        this.f1642a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1642a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1632N = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m1358e();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1626H = charSequence;
        m1346q();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1626H;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1651h;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.f1651h.getHintId());
        }
        return this.f1668z;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1623E == z) {
            return;
        }
        this.f1623E = z;
        m1333a(z);
        m1346q();
    }

    public void setIconified(boolean z) {
        if (z) {
            m1359f();
        } else {
            m1360g();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m1356c() {
        return this.f1624F;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1625G = z;
        m1333a(m1356c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1627I = z;
        CursorAdapter abstractC0355a = this.f1650g;
        if (abstractC0355a instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) abstractC0355a).m1525a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(CursorAdapter abstractC0355a) {
        this.f1650g = abstractC0355a;
        this.f1642a.setAdapter(this.f1650g);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f1650g;
    }

    public void setMaxWidth(int OplusGLSurfaceView_13) {
        this.f1629K = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1629K;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int i3;
        if (m1356c()) {
            super.onMeasure(OplusGLSurfaceView_13, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.f1629K;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f1629K;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.f1629K) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        if (z) {
            m1332a(this.f1642a, this.f1658p);
            this.f1659q.set(this.f1658p.left, 0, this.f1658p.right, i4 - i2);
            C0294e c0294e = this.f1657o;
            if (c0294e == null) {
                this.f1657o = new C0294e(this.f1659q, this.f1658p, this.f1642a);
                setTouchDelegate(this.f1657o);
            } else {
                c0294e.m1378a(this.f1659q, this.f1658p);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1332a(View view, Rect rect) {
        view.getLocationInWindow(this.f1660r);
        getLocationInWindow(this.f1661s);
        int[] iArr = this.f1660r;
        int OplusGLSurfaceView_13 = iArr[1];
        int[] iArr2 = this.f1661s;
        int i2 = OplusGLSurfaceView_13 - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1333a(boolean z) {
        this.f1624F = z;
        int OplusGLSurfaceView_13 = 8;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f1642a.getText());
        this.f1645b.setVisibility(i2);
        m1337b(z2);
        this.f1653k.setVisibility(z ? 8 : 0);
        if (this.f1662t.getDrawable() != null && !this.f1623E) {
            OplusGLSurfaceView_13 = 0;
        }
        this.f1662t.setVisibility(OplusGLSurfaceView_13);
        m1344o();
        m1340c(z2 ? false : true);
        m1343n();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m1341l() {
        SearchableInfo searchableInfo = this.f1651h;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1651h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1666x;
        } else if (this.f1651h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1667y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean m1342m() {
        return (this.f1625G || this.f1630L) && !m1356c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1337b(boolean z) {
        this.f1646c.setVisibility((this.f1625G && m1342m() && hasFocus() && (z || !this.f1630L)) ? 0 : 8);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m1343n() {
        this.f1655m.setVisibility((m1342m() && (this.f1646c.getVisibility() == 0 || this.f1648e.getVisibility() == 0)) ? 0 : 8);
    }

    /* renamed from: o */
    private void m1344o() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1642a.getText());
        if (!z2 && (!this.f1623E || this.f1633O)) {
            z = false;
        }
        this.f1647d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f1647d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: p */
    private void m1345p() {
        post(this.f1636R);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m1357d() {
        int[] iArr = this.f1642a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f1654l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1655m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1636R);
        post(this.f1637S);
        super.onDetachedFromWindow();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1350a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m1354a(View view, int OplusGLSurfaceView_13, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f1651h != null && this.f1650g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (OplusGLSurfaceView_13 == 66 || OplusGLSurfaceView_13 == 84 || OplusGLSurfaceView_13 == 61) {
                return m1353a(this.f1642a.getListSelection(), 0, (String) null);
            }
            if (OplusGLSurfaceView_13 == 21 || OplusGLSurfaceView_13 == 22) {
                this.f1642a.setSelection(OplusGLSurfaceView_13 == 21 ? 0 : this.f1642a.length());
                this.f1642a.setListSelection(0);
                this.f1642a.clearListSelection();
                f1618i.m1371a(this.f1642a, true);
                return true;
            }
            if (OplusGLSurfaceView_13 != 19 || this.f1642a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence m1339c(CharSequence charSequence) {
        if (!this.f1623E || this.f1663u == null) {
            return charSequence;
        }
        int textSize = (int) (this.f1642a.getTextSize() * 1.25d);
        this.f1663u.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1663u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: q */
    private void m1346q() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1642a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m1339c(queryHint));
    }

    /* renamed from: r */
    private void m1347r() {
        this.f1642a.setThreshold(this.f1651h.getSuggestThreshold());
        this.f1642a.setImeOptions(this.f1651h.getImeOptions());
        int inputType = this.f1651h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1651h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM;
            }
        }
        this.f1642a.setInputType(inputType);
        CursorAdapter abstractC0355a = this.f1650g;
        if (abstractC0355a != null) {
            abstractC0355a.mo1526a((Cursor) null);
        }
        if (this.f1651h.getSuggestAuthority() != null) {
            this.f1650g = new SuggestionsAdapter(getContext(), this, this.f1651h, this.f1638T);
            this.f1642a.setAdapter(this.f1650g);
            ((SuggestionsAdapter) this.f1650g).m1525a(this.f1627I ? 2 : 1);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m1340c(boolean z) {
        int OplusGLSurfaceView_13;
        if (this.f1630L && !m1356c() && z) {
            OplusGLSurfaceView_13 = 0;
            this.f1646c.setVisibility(8);
        } else {
            OplusGLSurfaceView_13 = 8;
        }
        this.f1648e.setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1355b(CharSequence charSequence) {
        Editable text = this.f1642a.getText();
        this.f1632N = text;
        boolean z = !TextUtils.isEmpty(text);
        m1337b(z);
        m1340c(z ? false : true);
        m1344o();
        m1343n();
        if (this.f1619A != null && !TextUtils.equals(charSequence, this.f1631M)) {
            this.f1619A.m1375b(charSequence.toString());
        }
        this.f1631M = charSequence.toString();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m1358e() {
        Editable text = this.f1642a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        InterfaceC0292c interfaceC0292c = this.f1619A;
        if (interfaceC0292c == null || !interfaceC0292c.m1374a(text.toString())) {
            if (this.f1651h != null) {
                m1349a(0, (String) null, text.toString());
            }
            this.f1642a.setImeVisibility(false);
            m1348s();
        }
    }

    /* renamed from: s */
    private void m1348s() {
        this.f1642a.dismissDropDown();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    void m1359f() {
        if (TextUtils.isEmpty(this.f1642a.getText())) {
            if (this.f1623E) {
                InterfaceC0291b interfaceC0291b = this.f1620B;
                if (interfaceC0291b == null || !interfaceC0291b.m1373a()) {
                    clearFocus();
                    m1333a(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f1642a.setText("");
        this.f1642a.requestFocus();
        this.f1642a.setImeVisibility(true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    void m1360g() {
        m1333a(false);
        this.f1642a.requestFocus();
        this.f1642a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1622D;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m1361h() {
        SearchableInfo searchableInfo = this.f1651h;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(m1328a(this.f1666x, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(m1335b(this.f1667y, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    void m1362i() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m1333a(m1356c());
        m1345p();
        if (this.f1642a.hasFocus()) {
            m1364k();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m1345p();
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1059b() {
        m1351a("", false);
        clearFocus();
        m1333a(true);
        this.f1642a.setImeOptions(this.f1634P);
        this.f1633O = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1058a() {
        if (this.f1633O) {
            return;
        }
        this.f1633O = true;
        this.f1634P = this.f1642a.getImeOptions();
        this.f1642a.setImeOptions(this.f1634P | 33554432);
        this.f1642a.setText("");
        setIconified(false);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        boolean isIconified;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isIconified = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeValue(Boolean.valueOf(this.isIconified));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isIconified = m1356c();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m1333a(savedState.isIconified);
        requestLayout();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    void m1363j() {
        int OplusGLSurfaceView_13;
        if (this.f1656n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1654l.getPaddingLeft();
            Rect rect = new Rect();
            boolean zM1623a = ViewUtils_2.m1623a(this);
            int dimensionPixelSize = this.f1623E ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1642a.getDropDownBackground().getPadding(rect);
            if (zM1623a) {
                OplusGLSurfaceView_13 = -rect.left;
            } else {
                OplusGLSurfaceView_13 = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f1642a.setDropDownHorizontalOffset(OplusGLSurfaceView_13);
            this.f1642a.setDropDownWidth((((this.f1656n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m1353a(int OplusGLSurfaceView_13, int i2, String str) {
        InterfaceC0293d interfaceC0293d = this.f1621C;
        if (interfaceC0293d != null && interfaceC0293d.m1377b(OplusGLSurfaceView_13)) {
            return false;
        }
        m1338b(OplusGLSurfaceView_13, 0, null);
        this.f1642a.setImeVisibility(false);
        m1348s();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m1352a(int OplusGLSurfaceView_13) {
        InterfaceC0293d interfaceC0293d = this.f1621C;
        if (interfaceC0293d != null && interfaceC0293d.m1376a(OplusGLSurfaceView_13)) {
            return false;
        }
        m1336b(OplusGLSurfaceView_13);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1336b(int OplusGLSurfaceView_13) {
        Editable text = this.f1642a.getText();
        Cursor cursorMo1764a = this.f1650g.mo1764a();
        if (cursorMo1764a == null) {
            return;
        }
        if (cursorMo1764a.moveToPosition(OplusGLSurfaceView_13)) {
            CharSequence charSequenceMo1528b = this.f1650g.mo1528b(cursorMo1764a);
            if (charSequenceMo1528b != null) {
                setQuery(charSequenceMo1528b);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m1338b(int OplusGLSurfaceView_13, int i2, String str) {
        Cursor cursorMo1764a = this.f1650g.mo1764a();
        if (cursorMo1764a == null || !cursorMo1764a.moveToPosition(OplusGLSurfaceView_13)) {
            return false;
        }
        m1331a(m1329a(cursorMo1764a, i2, str));
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1331a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("SearchView", "Failed launch activity: " + intent, COUIBaseListPopupWindow_8);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1642a.setText(charSequence);
        this.f1642a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1349a(int OplusGLSurfaceView_13, String str, String str2) {
        getContext().startActivity(m1330a("android.intent.action.SEARCH", null, null, str2, OplusGLSurfaceView_13, str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Intent m1330a(String str, Uri uri, String str2, String str3, int OplusGLSurfaceView_13, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(C1547C.ENCODING_PCM_MU_LAW);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1632N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1635Q;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (OplusGLSurfaceView_13 != 0) {
            intent.putExtra("action_key", OplusGLSurfaceView_13);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1651h.getSearchActivity());
        return intent;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Intent m1328a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Intent m1335b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1635Q;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Intent m1329a(Cursor cursor, int OplusGLSurfaceView_13, String str) {
        int position;
        String strM1509a;
        try {
            String strM1509a2 = SuggestionsAdapter.m1509a(cursor, "suggest_intent_action");
            if (strM1509a2 == null) {
                strM1509a2 = this.f1651h.getSuggestIntentAction();
            }
            if (strM1509a2 == null) {
                strM1509a2 = "android.intent.action.SEARCH";
            }
            String str2 = strM1509a2;
            String strM1509a3 = SuggestionsAdapter.m1509a(cursor, "suggest_intent_data");
            if (strM1509a3 == null) {
                strM1509a3 = this.f1651h.getSuggestIntentData();
            }
            if (strM1509a3 != null && (strM1509a = SuggestionsAdapter.m1509a(cursor, "suggest_intent_data_id")) != null) {
                strM1509a3 = strM1509a3 + "/" + Uri.encode(strM1509a);
            }
            return m1330a(str2, strM1509a3 == null ? null : Uri.parse(strM1509a3), SuggestionsAdapter.m1509a(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.m1509a(cursor, "suggest_intent_query"), OplusGLSurfaceView_13, str);
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    void m1364k() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1642a.refreshAutoCompleteResults();
        } else {
            f1618i.m1370a(this.f1642a);
            f1618i.m1372b(this.f1642a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m1334a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: androidx.appcompat.widget.SearchView$COUIBaseListPopupWindow_8 */
    private static class C0294e extends TouchDelegate {

        /* renamed from: PlatformImplementations.kt_3 */
        private final View f1687a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Rect f1688b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Rect f1689c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final Rect f1690d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final int f1691e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f1692f;

        public C0294e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1691e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1688b = new Rect();
            this.f1690d = new Rect();
            this.f1689c = new Rect();
            m1378a(rect, rect2);
            this.f1687a = view;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1378a(Rect rect, Rect rect2) {
            this.f1688b.set(rect);
            this.f1690d.set(rect);
            Rect rect3 = this.f1690d;
            int OplusGLSurfaceView_13 = this.f1691e;
            rect3.inset(-OplusGLSurfaceView_13, -OplusGLSurfaceView_13);
            this.f1689c.set(rect2);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        @Override // android.view.TouchDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L2e
                if (r2 == r4) goto L20
                if (r2 == r3) goto L20
                r6 = 3
                if (r2 == r6) goto L1b
                goto L3a
            L1b:
                boolean r2 = r7.f1692f
                r7.f1692f = r5
                goto L3b
            L20:
                boolean r2 = r7.f1692f
                if (r2 == 0) goto L3b
                android.graphics.Rect r6 = r7.f1690d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L3b
                r4 = r5
                goto L3b
            L2e:
                android.graphics.Rect r2 = r7.f1688b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L3a
                r7.f1692f = r4
                r2 = r4
                goto L3b
            L3a:
                r2 = r5
            L3b:
                if (r2 == 0) goto L70
                if (r4 == 0) goto L5b
                android.graphics.Rect r2 = r7.f1689c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L5b
                android.view.View r0 = r7.f1687a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f1687a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L6a
            L5b:
                android.graphics.Rect r2 = r7.f1689c
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r7.f1689c
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r8.setLocation(r0, r1)
            L6a:
                android.view.View r7 = r7.f1687a
                boolean r5 = r7.dispatchTouchEvent(r8)
            L70:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.C0294e.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: PlatformImplementations.kt_3 */
        final Runnable f1679a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f1680b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private SearchView f1681c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f1682d;

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
            super(context, attributeSet, OplusGLSurfaceView_13);
            this.f1679a = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.m1369b();
                }
            };
            this.f1680b = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f1681c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int OplusGLSurfaceView_13) {
            super.setThreshold(OplusGLSurfaceView_13);
            this.f1680b = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m1368a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z);
            if (z && this.f1681c.hasFocus() && getVisibility() == 0) {
                this.f1682d = true;
                if (SearchView.m1334a(getContext())) {
                    SearchView.f1618i.m1371a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int OplusGLSurfaceView_13, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z, OplusGLSurfaceView_13, rect);
            this.f1681c.m1362i();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1680b <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
            if (OplusGLSurfaceView_13 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1681c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(OplusGLSurfaceView_13, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int OplusGLSurfaceView_13 = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (OplusGLSurfaceView_13 >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (OplusGLSurfaceView_13 < 600) {
                return (OplusGLSurfaceView_13 < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1682d) {
                removeCallbacks(this.f1679a);
                post(this.f1679a);
            }
            return inputConnectionOnCreateInputConnection;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m1369b() {
            if (this.f1682d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1682d = false;
            }
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f1682d = false;
                removeCallbacks(this.f1679a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f1682d = false;
                    removeCallbacks(this.f1679a);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f1682d = true;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$PlatformImplementations.kt_3 */
    private static class C0290a {

        /* renamed from: PlatformImplementations.kt_3 */
        private Method f1684a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Method f1685b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Method f1686c;

        C0290a() {
            try {
                this.f1684a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1684a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f1685b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1685b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.f1686c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1686c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m1370a(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f1684a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m1372b(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f1685b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m1371a(AutoCompleteTextView autoCompleteTextView, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f1686c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }
}
