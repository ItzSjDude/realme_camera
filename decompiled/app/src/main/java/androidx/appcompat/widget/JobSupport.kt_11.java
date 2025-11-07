package androidx.appcompat.widget;

/* compiled from: SuggestionsAdapter.java */
@android.annotation.SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class al_renamed extends androidx.b_renamed.a_renamed.c_renamed implements android.view.View.OnClickListener {
    private final android.app.SearchManager j_renamed;
    private final androidx.appcompat.widget.SearchView k_renamed;
    private final android.app.SearchableInfo l_renamed;
    private final android.content.Context m_renamed;
    private final java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable.ConstantState> n_renamed;
    private final int o_renamed;
    private boolean p_renamed;
    private int q_renamed;
    private android.content.res.ColorStateList r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private int w_renamed;
    private int x_renamed;

    @Override // androidx.b_renamed.a_renamed.a_renamed, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public al_renamed(android.content.Context context, androidx.appcompat.widget.SearchView searchView, android.app.SearchableInfo searchableInfo, java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.p_renamed = false;
        this.q_renamed = 1;
        this.s_renamed = -1;
        this.t_renamed = -1;
        this.u_renamed = -1;
        this.v_renamed = -1;
        this.w_renamed = -1;
        this.x_renamed = -1;
        this.j_renamed = (android.app.SearchManager) this.d_renamed.getSystemService("search");
        this.k_renamed = searchView;
        this.l_renamed = searchableInfo;
        this.o_renamed = searchView.getSuggestionCommitIconResId();
        this.m_renamed = context;
        this.n_renamed = weakHashMap;
    }

    public void a_renamed(int i_renamed) {
        this.q_renamed = i_renamed;
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed, androidx.b_renamed.a_renamed.b_renamed.a_renamed
    public android.database.Cursor a_renamed(java.lang.CharSequence charSequence) {
        java.lang.String string = charSequence == null ? "" : charSequence.toString();
        if (this.k_renamed.getVisibility() == 0 && this.k_renamed.getWindowVisibility() == 0) {
            try {
                android.database.Cursor cursorA = a_renamed(this.l_renamed, string, 50);
                if (cursorA != null) {
                    cursorA.getCount();
                    return cursorA;
                }
            } catch (java.lang.RuntimeException e_renamed) {
                android.util.Log.w_renamed("SuggestionsAdapter", "Search suggestions query threw an_renamed exception.", e_renamed);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        d_renamed(a_renamed());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        d_renamed(a_renamed());
    }

    private void d_renamed(android.database.Cursor cursor) {
        android.os.Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed, androidx.b_renamed.a_renamed.b_renamed.a_renamed
    public void a_renamed(android.database.Cursor cursor) {
        if (this.p_renamed) {
            android.util.Log.w_renamed("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a_renamed(cursor);
            if (cursor != null) {
                this.s_renamed = cursor.getColumnIndex("suggest_text_1");
                this.t_renamed = cursor.getColumnIndex("suggest_text_2");
                this.u_renamed = cursor.getColumnIndex("suggest_text_2_url");
                this.v_renamed = cursor.getColumnIndex("suggest_icon_1");
                this.w_renamed = cursor.getColumnIndex("suggest_icon_2");
                this.x_renamed = cursor.getColumnIndex("suggest_flags");
            }
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("SuggestionsAdapter", "error changing cursor and caching columns", e_renamed);
        }
    }

    @Override // androidx.b_renamed.a_renamed.c_renamed, androidx.b_renamed.a_renamed.a_renamed
    public android.view.View a_renamed(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        android.view.View viewA = super.a_renamed(context, cursor, viewGroup);
        viewA.setTag(new androidx.appcompat.widget.al_renamed.a_renamed(viewA));
        ((android.widget.ImageView) viewA.findViewById(androidx.appcompat.R_renamed.id_renamed.edit_query)).setImageResource(this.o_renamed);
        return viewA;
    }

    /* compiled from: SuggestionsAdapter.java */
    private static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final android.widget.TextView f564a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final android.widget.TextView f565b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final android.widget.ImageView f566c;
        public final android.widget.ImageView d_renamed;
        public final android.widget.ImageView e_renamed;

        public a_renamed(android.view.View view) {
            this.f564a = (android.widget.TextView) view.findViewById(android.R_renamed.id_renamed.text1);
            this.f565b = (android.widget.TextView) view.findViewById(android.R_renamed.id_renamed.text2);
            this.f566c = (android.widget.ImageView) view.findViewById(android.R_renamed.id_renamed.icon1);
            this.d_renamed = (android.widget.ImageView) view.findViewById(android.R_renamed.id_renamed.icon2);
            this.e_renamed = (android.widget.ImageView) view.findViewById(androidx.appcompat.R_renamed.id_renamed.edit_query);
        }
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed
    public void a_renamed(android.view.View view, android.content.Context context, android.database.Cursor cursor) {
        java.lang.CharSequence charSequenceA;
        androidx.appcompat.widget.al_renamed.a_renamed aVar = (androidx.appcompat.widget.al_renamed.a_renamed) view.getTag();
        int i_renamed = this.x_renamed;
        int i2 = i_renamed != -1 ? cursor.getInt(i_renamed) : 0;
        if (aVar.f564a != null) {
            a_renamed(aVar.f564a, a_renamed(cursor, this.s_renamed));
        }
        if (aVar.f565b != null) {
            java.lang.String strA = a_renamed(cursor, this.u_renamed);
            if (strA != null) {
                charSequenceA = b_renamed((java.lang.CharSequence) strA);
            } else {
                charSequenceA = a_renamed(cursor, this.t_renamed);
            }
            if (android.text.TextUtils.isEmpty(charSequenceA)) {
                if (aVar.f564a != null) {
                    aVar.f564a.setSingleLine(false);
                    aVar.f564a.setMaxLines(2);
                }
            } else if (aVar.f564a != null) {
                aVar.f564a.setSingleLine(true);
                aVar.f564a.setMaxLines(1);
            }
            a_renamed(aVar.f565b, charSequenceA);
        }
        if (aVar.f566c != null) {
            a_renamed(aVar.f566c, e_renamed(cursor), 4);
        }
        if (aVar.d_renamed != null) {
            a_renamed(aVar.d_renamed, f_renamed(cursor), 8);
        }
        int i3 = this.q_renamed;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            aVar.e_renamed.setVisibility(0);
            aVar.e_renamed.setTag(aVar.f564a.getText());
            aVar.e_renamed.setOnClickListener(this);
            return;
        }
        aVar.e_renamed.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        java.lang.Object tag = view.getTag();
        if (tag instanceof java.lang.CharSequence) {
            this.k_renamed.a_renamed((java.lang.CharSequence) tag);
        }
    }

    private java.lang.CharSequence b_renamed(java.lang.CharSequence charSequence) {
        if (this.r_renamed == null) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.d_renamed.getTheme().resolveAttribute(androidx.appcompat.R_renamed.attr.textColorSearchUrl, typedValue, true);
            this.r_renamed = this.d_renamed.getResources().getColorStateList(typedValue.resourceId);
        }
        android.text.SpannableString spannableString = new android.text.SpannableString(charSequence);
        spannableString.setSpan(new android.text.style.TextAppearanceSpan(null, 0, 0, this.r_renamed, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void a_renamed(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        textView.setText(charSequence);
        if (android.text.TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private android.graphics.drawable.Drawable e_renamed(android.database.Cursor cursor) throws java.lang.NumberFormatException, java.io.IOException {
        int i_renamed = this.v_renamed;
        if (i_renamed == -1) {
            return null;
        }
        android.graphics.drawable.Drawable drawableA = a_renamed(cursor.getString(i_renamed));
        return drawableA != null ? drawableA : g_renamed(cursor);
    }

    private android.graphics.drawable.Drawable f_renamed(android.database.Cursor cursor) {
        int i_renamed = this.w_renamed;
        if (i_renamed == -1) {
            return null;
        }
        return a_renamed(cursor.getString(i_renamed));
    }

    private void a_renamed(android.widget.ImageView imageView, android.graphics.drawable.Drawable drawable, int i_renamed) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i_renamed);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed, androidx.b_renamed.a_renamed.b_renamed.a_renamed
    public java.lang.CharSequence b_renamed(android.database.Cursor cursor) {
        java.lang.String strA;
        java.lang.String strA2;
        if (cursor == null) {
            return null;
        }
        java.lang.String strA3 = a_renamed(cursor, "suggest_intent_query");
        if (strA3 != null) {
            return strA3;
        }
        if (this.l_renamed.shouldRewriteQueryFromData() && (strA2 = a_renamed(cursor, "suggest_intent_data")) != null) {
            return strA2;
        }
        if (!this.l_renamed.shouldRewriteQueryFromText() || (strA = a_renamed(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strA;
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed, android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        try {
            return super.getView(i_renamed, view, viewGroup);
        } catch (java.lang.RuntimeException e_renamed) {
            android.util.Log.w_renamed("SuggestionsAdapter", "Search suggestions cursor threw exception.", e_renamed);
            android.view.View viewA = this.a_renamed(this.d_renamed, this.f656c, viewGroup);
            if (viewA != null) {
                ((androidx.appcompat.widget.al_renamed.a_renamed) viewA.getTag()).f564a.setText(e_renamed.toString());
            }
            return viewA;
        }
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public android.view.View getDropDownView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i_renamed, view, viewGroup);
        } catch (java.lang.RuntimeException e_renamed) {
            android.util.Log.w_renamed("SuggestionsAdapter", "Search suggestions cursor threw exception.", e_renamed);
            android.view.View viewB = this.b_renamed(this.d_renamed, this.f656c, viewGroup);
            if (viewB != null) {
                ((androidx.appcompat.widget.al_renamed.a_renamed) viewB.getTag()).f564a.setText(e_renamed.toString());
            }
            return viewB;
        }
    }

    private android.graphics.drawable.Drawable a_renamed(java.lang.String str) throws java.lang.NumberFormatException, java.io.IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i_renamed = java.lang.Integer.parseInt(str);
            java.lang.String str2 = "android.resource://" + this.m_renamed.getPackageName() + "/" + i_renamed;
            android.graphics.drawable.Drawable drawableB = b_renamed(str2);
            if (drawableB != null) {
                return drawableB;
            }
            android.graphics.drawable.Drawable drawableA = androidx.core.a_renamed.a_renamed.a_renamed(this.m_renamed, i_renamed);
            a_renamed(str2, drawableA);
            return drawableA;
        } catch (android.content.res.Resources.NotFoundException unused) {
            android.util.Log.w_renamed("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (java.lang.NumberFormatException unused2) {
            android.graphics.drawable.Drawable drawableB2 = b_renamed(str);
            if (drawableB2 != null) {
                return drawableB2;
            }
            android.graphics.drawable.Drawable drawableB3 = b_renamed(android.net.Uri.parse(str));
            a_renamed(str, drawableB3);
            return drawableB3;
        }
    }

    private android.graphics.drawable.Drawable b_renamed(android.net.Uri uri) throws java.io.IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return a_renamed(uri);
                } catch (android.content.res.Resources.NotFoundException unused) {
                    throw new java.io.FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            java.io.InputStream inputStreamOpenInputStream = this.m_renamed.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new java.io.FileNotFoundException("Failed to open " + uri);
            }
            try {
                return android.graphics.drawable.Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (java.io.IOException e_renamed) {
                    android.util.Log.e_renamed("SuggestionsAdapter", "Error closing icon stream for " + uri, e_renamed);
                }
            }
        } catch (java.io.FileNotFoundException e2) {
            android.util.Log.w_renamed("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        android.util.Log.w_renamed("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    private android.graphics.drawable.Drawable b_renamed(java.lang.String str) {
        android.graphics.drawable.Drawable.ConstantState constantState = this.n_renamed.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a_renamed(java.lang.String str, android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.n_renamed.put(str, drawable.getConstantState());
        }
    }

    private android.graphics.drawable.Drawable g_renamed(android.database.Cursor cursor) throws android.content.pm.PackageManager.NameNotFoundException {
        android.graphics.drawable.Drawable drawableA = a_renamed(this.l_renamed.getSearchActivity());
        return drawableA != null ? drawableA : this.d_renamed.getPackageManager().getDefaultActivityIcon();
    }

    private android.graphics.drawable.Drawable a_renamed(android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String strFlattenToShortString = componentName.flattenToShortString();
        if (this.n_renamed.containsKey(strFlattenToShortString)) {
            android.graphics.drawable.Drawable.ConstantState constantState = this.n_renamed.get(strFlattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.m_renamed.getResources());
        }
        android.graphics.drawable.Drawable drawableB = b_renamed(componentName);
        this.n_renamed.put(strFlattenToShortString, drawableB != null ? drawableB.getConstantState() : null);
        return drawableB;
    }

    private android.graphics.drawable.Drawable b_renamed(android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageManager packageManager = this.d_renamed.getPackageManager();
        try {
            android.content.pm.ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            android.graphics.drawable.Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            android.util.Log.w_renamed("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            android.util.Log.w_renamed("SuggestionsAdapter", e_renamed.toString());
            return null;
        }
    }

    public static java.lang.String a_renamed(android.database.Cursor cursor, java.lang.String str) {
        return a_renamed(cursor, cursor.getColumnIndex(str));
    }

    private static java.lang.String a_renamed(android.database.Cursor cursor, int i_renamed) {
        if (i_renamed == -1) {
            return null;
        }
        try {
            return cursor.getString(i_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e_renamed);
            return null;
        }
    }

    android.graphics.drawable.Drawable a_renamed(android.net.Uri uri) throws android.content.pm.PackageManager.NameNotFoundException, java.lang.NumberFormatException, java.io.FileNotFoundException {
        int identifier;
        java.lang.String authority = uri.getAuthority();
        if (android.text.TextUtils.isEmpty(authority)) {
            throw new java.io.FileNotFoundException("No authority: " + uri);
        }
        try {
            android.content.res.Resources resourcesForApplication = this.d_renamed.getPackageManager().getResourcesForApplication(authority);
            java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new java.io.FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = java.lang.Integer.parseInt(pathSegments.get(0));
                } catch (java.lang.NumberFormatException unused) {
                    throw new java.io.FileNotFoundException("Single path segment is_renamed not a_renamed resource ID_renamed: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new java.io.FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier == 0) {
                throw new java.io.FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(identifier);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
            throw new java.io.FileNotFoundException("No package found for authority: " + uri);
        }
    }

    android.database.Cursor a_renamed(android.app.SearchableInfo searchableInfo, java.lang.String str, int i_renamed) {
        java.lang.String suggestAuthority;
        java.lang.String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        android.net.Uri.Builder builderFragment = new android.net.Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        java.lang.String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        java.lang.String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new java.lang.String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        java.lang.String[] strArr2 = strArr;
        if (i_renamed > 0) {
            builderFragment.appendQueryParameter("limit", java.lang.String.valueOf(i_renamed));
        }
        return this.d_renamed.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }
}
