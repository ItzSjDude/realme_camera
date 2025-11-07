package com.coui.appcompat.widget;

/* compiled from: ChoiceListCursorAdapter.java */
/* loaded from: classes.dex */
public class w_renamed extends androidx.b_renamed.a_renamed.a_renamed {
    private int j_renamed;
    private boolean k_renamed;
    private java.util.HashSet<java.lang.Integer> l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private java.lang.String p_renamed;
    private java.lang.String q_renamed;
    private java.lang.String r_renamed;

    public w_renamed(android.content.Context context, android.database.Cursor cursor, int i_renamed, java.lang.String str, java.lang.String str2) {
        this(context, cursor, i_renamed, str, null, str2, false);
    }

    public w_renamed(android.content.Context context, android.database.Cursor cursor, int i_renamed, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed) {
        this(context, cursor);
        this.k_renamed = z_renamed;
        this.p_renamed = str;
        this.r_renamed = str3;
        this.q_renamed = str2;
        this.j_renamed = i_renamed;
        this.l_renamed = new java.util.HashSet<>();
        this.m_renamed = cursor.getColumnIndexOrThrow(this.p_renamed);
        java.lang.String str4 = this.r_renamed;
        if (str4 != null) {
            this.o_renamed = cursor.getColumnIndexOrThrow(str4);
        }
        if (z_renamed) {
            this.n_renamed = cursor.getColumnIndexOrThrow(this.q_renamed);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    if (cursor.getInt(this.n_renamed) == 1) {
                        this.l_renamed.add(java.lang.Integer.valueOf(cursor.getPosition()));
                    }
                } while (cursor.moveToNext());
            }
            cursor.moveToFirst();
        }
    }

    public w_renamed(android.content.Context context, android.database.Cursor cursor) {
        super(context, cursor);
        this.k_renamed = false;
        this.n_renamed = 0;
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed
    public android.view.View a_renamed(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        return ((android.view.LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.j_renamed, viewGroup, false);
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed
    public void a_renamed(android.view.View view, android.content.Context context, android.database.Cursor cursor) {
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(android.R_renamed.id_renamed.text1);
        android.widget.TextView textView2 = (android.widget.TextView) view.findViewById(coui.support.appcompat.R_renamed.id_renamed.summary_text2);
        int i_renamed = this.l_renamed.contains(java.lang.Integer.valueOf(cursor.getPosition())) ? 2 : 0;
        if (this.k_renamed) {
            ((com.coui.appcompat.widget.COUICheckBox) view.findViewById(coui.support.appcompat.R_renamed.id_renamed.checkbox)).setState(i_renamed);
        }
        textView.setText(cursor.getString(this.m_renamed));
        if (this.r_renamed == null) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(cursor.getString(this.o_renamed));
        }
    }

    public void a_renamed(int i_renamed, int i2, android.widget.ListView listView) {
        int firstVisiblePosition = i2 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0) {
            ((com.coui.appcompat.widget.COUICheckBox) listView.getChildAt(firstVisiblePosition).findViewById(coui.support.appcompat.R_renamed.id_renamed.checkbox)).setState(i_renamed);
            if (i_renamed == 2) {
                this.l_renamed.add(java.lang.Integer.valueOf(i2));
            } else {
                this.l_renamed.remove(java.lang.Integer.valueOf(i2));
            }
        }
    }
}
