package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.p027a.ContextCompat;
import androidx.p021b.p022a.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.al */
/* loaded from: classes.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {

    /* renamed from: OplusGLSurfaceView_15 */
    private final SearchManager f1835j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final SearchView f1836k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final SearchableInfo f1837l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final Context f1838m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final WeakHashMap<String, Drawable.ConstantState> f1839n;

    /* renamed from: o */
    private final int f1840o;

    /* renamed from: p */
    private boolean f1841p;

    /* renamed from: q */
    private int f1842q;

    /* renamed from: r */
    private ColorStateList f1843r;

    /* renamed from: s */
    private int f1844s;

    /* renamed from: t */
    private int f1845t;

    /* renamed from: u */
    private int f1846u;

    /* renamed from: v */
    private int f1847v;

    /* renamed from: w */
    private int f1848w;

    /* renamed from: x */
    private int f1849x;

    @Override // androidx.p021b.p022a.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1841p = false;
        this.f1842q = 1;
        this.f1844s = -1;
        this.f1845t = -1;
        this.f1846u = -1;
        this.f1847v = -1;
        this.f1848w = -1;
        this.f1849x = -1;
        this.f1835j = (SearchManager) this.f2026d.getSystemService("search");
        this.f1836k = searchView;
        this.f1837l = searchableInfo;
        this.f1840o = searchView.getSuggestionCommitIconResId();
        this.f1838m = context;
        this.f1839n = weakHashMap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1525a(int OplusGLSurfaceView_13) {
        this.f1842q = OplusGLSurfaceView_13;
    }

    @Override // androidx.p021b.p022a.CursorAdapter, androidx.p021b.p022a.CursorFilter.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor mo1522a(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f1836k.getVisibility() == 0 && this.f1836k.getWindowVisibility() == 0) {
            try {
                Cursor cursorM1521a = m1521a(this.f1837l, string, 50);
                if (cursorM1521a != null) {
                    cursorM1521a.getCount();
                    return cursorM1521a;
                }
            } catch (RuntimeException COUIBaseListPopupWindow_8) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", COUIBaseListPopupWindow_8);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1517d(mo1764a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1517d(mo1764a());
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m1517d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // androidx.p021b.p022a.CursorAdapter, androidx.p021b.p022a.CursorFilter.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1526a(Cursor cursor) {
        if (this.f1841p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo1526a(cursor);
            if (cursor != null) {
                this.f1844s = cursor.getColumnIndex("suggest_text_1");
                this.f1845t = cursor.getColumnIndex("suggest_text_2");
                this.f1846u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1847v = cursor.getColumnIndex("suggest_icon_1");
                this.f1848w = cursor.getColumnIndex("suggest_icon_2");
                this.f1849x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("SuggestionsAdapter", "error changing cursor and caching columns", COUIBaseListPopupWindow_8);
        }
    }

    @Override // androidx.p021b.p022a.ResourceCursorAdapter, androidx.p021b.p022a.CursorAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo1524a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewMo1524a = super.mo1524a(context, cursor, viewGroup);
        viewMo1524a.setTag(new PlatformImplementations.kt_3(viewMo1524a));
        ((ImageView) viewMo1524a.findViewById(R.id_renamed.edit_query)).setImageResource(this.f1840o);
        return viewMo1524a;
    }

    /* compiled from: SuggestionsAdapter.java */
    /* renamed from: androidx.appcompat.widget.al$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final TextView f1850a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final TextView f1851b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final ImageView f1852c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public final ImageView f1853d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public final ImageView f1854e;

        public PlatformImplementations.kt_3(View view) {
            this.f1850a = (TextView) view.findViewById(android.R.id_renamed.text1);
            this.f1851b = (TextView) view.findViewById(android.R.id_renamed.text2);
            this.f1852c = (ImageView) view.findViewById(android.R.id_renamed.icon1);
            this.f1853d = (ImageView) view.findViewById(android.R.id_renamed.icon2);
            this.f1854e = (ImageView) view.findViewById(R.id_renamed.edit_query);
        }
    }

    @Override // androidx.p021b.p022a.CursorAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1527a(View view, Context context, Cursor cursor) {
        CharSequence charSequenceM1508a;
        PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) view.getTag();
        int OplusGLSurfaceView_13 = this.f1849x;
        int i2 = OplusGLSurfaceView_13 != -1 ? cursor.getInt(OplusGLSurfaceView_13) : 0;
        if (aVar.f1850a != null) {
            m1511a(aVar.f1850a, m1508a(cursor, this.f1844s));
        }
        if (aVar.f1851b != null) {
            String strM1508a = m1508a(cursor, this.f1846u);
            if (strM1508a != null) {
                charSequenceM1508a = m1516b((CharSequence) strM1508a);
            } else {
                charSequenceM1508a = m1508a(cursor, this.f1845t);
            }
            if (TextUtils.isEmpty(charSequenceM1508a)) {
                if (aVar.f1850a != null) {
                    aVar.f1850a.setSingleLine(false);
                    aVar.f1850a.setMaxLines(2);
                }
            } else if (aVar.f1850a != null) {
                aVar.f1850a.setSingleLine(true);
                aVar.f1850a.setMaxLines(1);
            }
            m1511a(aVar.f1851b, charSequenceM1508a);
        }
        if (aVar.f1852c != null) {
            m1510a(aVar.f1852c, m1518e(cursor), 4);
        }
        if (aVar.f1853d != null) {
            m1510a(aVar.f1853d, m1519f(cursor), 8);
        }
        int i3 = this.f1842q;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            aVar.f1854e.setVisibility(0);
            aVar.f1854e.setTag(aVar.f1850a.getText());
            aVar.f1854e.setOnClickListener(this);
            return;
        }
        aVar.f1854e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1836k.m1350a((CharSequence) tag);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence m1516b(CharSequence charSequence) {
        if (this.f1843r == null) {
            TypedValue typedValue = new TypedValue();
            this.f2026d.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.f1843r = this.f2026d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1843r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1511a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Drawable m1518e(Cursor cursor) throws NumberFormatException, IOException {
        int OplusGLSurfaceView_13 = this.f1847v;
        if (OplusGLSurfaceView_13 == -1) {
            return null;
        }
        Drawable drawableM1507a = m1507a(cursor.getString(OplusGLSurfaceView_13));
        return drawableM1507a != null ? drawableM1507a : m1520g(cursor);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable m1519f(Cursor cursor) {
        int OplusGLSurfaceView_13 = this.f1848w;
        if (OplusGLSurfaceView_13 == -1) {
            return null;
        }
        return m1507a(cursor.getString(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1510a(ImageView imageView, Drawable drawable, int OplusGLSurfaceView_13) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(OplusGLSurfaceView_13);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // androidx.p021b.p022a.CursorAdapter, androidx.p021b.p022a.CursorFilter.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence mo1528b(Cursor cursor) {
        String strM1509a;
        String strM1509a2;
        if (cursor == null) {
            return null;
        }
        String strM1509a3 = m1509a(cursor, "suggest_intent_query");
        if (strM1509a3 != null) {
            return strM1509a3;
        }
        if (this.f1837l.shouldRewriteQueryFromData() && (strM1509a2 = m1509a(cursor, "suggest_intent_data")) != null) {
            return strM1509a2;
        }
        if (!this.f1837l.shouldRewriteQueryFromText() || (strM1509a = m1509a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strM1509a;
    }

    @Override // androidx.p021b.p022a.CursorAdapter, android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        try {
            return super.getView(OplusGLSurfaceView_13, view, viewGroup);
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", COUIBaseListPopupWindow_8);
            View viewMo1524a = this.mo1524a(this.f2026d, this.f2025c, viewGroup);
            if (viewMo1524a != null) {
                ((PlatformImplementations.kt_3) viewMo1524a.getTag()).f1850a.setText(COUIBaseListPopupWindow_8.toString());
            }
            return viewMo1524a;
        }
    }

    @Override // androidx.p021b.p022a.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(OplusGLSurfaceView_13, view, viewGroup);
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", COUIBaseListPopupWindow_8);
            View viewB = this.mo1766b(this.f2026d, this.f2025c, viewGroup);
            if (viewB != null) {
                ((PlatformImplementations.kt_3) viewB.getTag()).f1850a.setText(COUIBaseListPopupWindow_8.toString());
            }
            return viewB;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m1507a(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int OplusGLSurfaceView_13 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1838m.getPackageName() + "/" + OplusGLSurfaceView_13;
            Drawable drawableM1515b = m1515b(str2);
            if (drawableM1515b != null) {
                return drawableM1515b;
            }
            Drawable drawableM2248a = ContextCompat.m2248a(this.f1838m, OplusGLSurfaceView_13);
            m1512a(str2, drawableM2248a);
            return drawableM2248a;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableM1515b2 = m1515b(str);
            if (drawableM1515b2 != null) {
                return drawableM1515b2;
            }
            Drawable drawableM1514b = m1514b(Uri.parse(str));
            m1512a(str, drawableM1514b);
            return drawableM1514b;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable m1514b(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m1523a(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f1838m.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8("SuggestionsAdapter", "Error closing icon stream for " + uri, COUIBaseListPopupWindow_8);
                }
            }
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable m1515b(String str) {
        Drawable.ConstantState constantState = this.f1839n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1512a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1839n.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Drawable m1520g(Cursor cursor) throws PackageManager.NameNotFoundException {
        Drawable drawableM1506a = m1506a(this.f1837l.getSearchActivity());
        return drawableM1506a != null ? drawableM1506a : this.f2026d.getPackageManager().getDefaultActivityIcon();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m1506a(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (this.f1839n.containsKey(strFlattenToShortString)) {
            Drawable.ConstantState constantState = this.f1839n.get(strFlattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.f1838m.getResources());
        }
        Drawable drawableM1513b = m1513b(componentName);
        this.f1839n.put(strFlattenToShortString, drawableM1513b != null ? drawableM1513b.getConstantState() : null);
        return drawableM1513b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable m1513b(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f2026d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            Log.w("SuggestionsAdapter", COUIBaseListPopupWindow_8.toString());
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m1509a(Cursor cursor, String str) {
        return m1508a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m1508a(Cursor cursor, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -1) {
            return null;
        }
        try {
            return cursor.getString(OplusGLSurfaceView_13);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Drawable m1523a(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f2026d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not PlatformImplementations.kt_3 resource ID: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(identifier);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Cursor m1521a(SearchableInfo searchableInfo, String str, int OplusGLSurfaceView_13) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (OplusGLSurfaceView_13 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(OplusGLSurfaceView_13));
        }
        return this.f2026d.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }
}
