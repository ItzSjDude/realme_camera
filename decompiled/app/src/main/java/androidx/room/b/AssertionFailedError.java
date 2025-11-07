package androidx.room.b_renamed;

/* compiled from: CursorUtil.java */
/* loaded from: classes.dex */
public class b_renamed {
    public static android.database.Cursor a_renamed(android.database.Cursor cursor) {
        try {
            android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                java.lang.Object[] objArr = new java.lang.Object[cursor.getColumnCount()];
                for (int i_renamed = 0; i_renamed < cursor.getColumnCount(); i_renamed++) {
                    int type = cursor.getType(i_renamed);
                    if (type == 0) {
                        objArr[i_renamed] = null;
                    } else if (type == 1) {
                        objArr[i_renamed] = java.lang.Long.valueOf(cursor.getLong(i_renamed));
                    } else if (type == 2) {
                        objArr[i_renamed] = java.lang.Double.valueOf(cursor.getDouble(i_renamed));
                    } else if (type == 3) {
                        objArr[i_renamed] = cursor.getString(i_renamed);
                    } else if (type == 4) {
                        objArr[i_renamed] = cursor.getBlob(i_renamed);
                    } else {
                        throw new java.lang.IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    public static int a_renamed(android.database.Cursor cursor, java.lang.String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }
}
