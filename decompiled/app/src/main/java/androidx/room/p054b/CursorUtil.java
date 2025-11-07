package androidx.room.p054b;

import android.database.Cursor;
import android.database.MatrixCursor;

/* compiled from: CursorUtil.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class CursorUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m4594a(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < cursor.getColumnCount(); OplusGLSurfaceView_13++) {
                    int type = cursor.getType(OplusGLSurfaceView_13);
                    if (type == 0) {
                        objArr[OplusGLSurfaceView_13] = null;
                    } else if (type == 1) {
                        objArr[OplusGLSurfaceView_13] = Long.valueOf(cursor.getLong(OplusGLSurfaceView_13));
                    } else if (type == 2) {
                        objArr[OplusGLSurfaceView_13] = Double.valueOf(cursor.getDouble(OplusGLSurfaceView_13));
                    } else if (type == 3) {
                        objArr[OplusGLSurfaceView_13] = cursor.getString(OplusGLSurfaceView_13);
                    } else if (type == 4) {
                        objArr[OplusGLSurfaceView_13] = cursor.getBlob(OplusGLSurfaceView_13);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m4593a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }
}
