package com.oplus.epona.ipc.cursor;

/* loaded from: classes2.dex */
public class ProviderCursor extends android.database.MatrixCursor {
    public static final java.lang.String[] DEFAULT_COLUMNS = {"col"};
    public static final java.lang.String TAG = "ProviderCursor";
    private android.os.Bundle binderExtras;

    public ProviderCursor(java.lang.String[] strArr, android.os.Bundle bundle) {
        super(strArr);
        this.binderExtras = new android.os.Bundle(bundle);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public android.os.Bundle getExtras() {
        return this.binderExtras;
    }

    public static com.oplus.epona.ipc.cursor.ProviderCursor generateCursor(android.os.Bundle bundle) {
        return new com.oplus.epona.ipc.cursor.ProviderCursor(DEFAULT_COLUMNS, bundle);
    }

    public static android.os.Bundle stripBundle(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return cursor.getExtras();
    }
}
