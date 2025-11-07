package com.oplus.camera.p172ui.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class PreferenceMenuOptionInfo extends CameraMenuOptionInfo {
    private static final String TAG = "PreferenceMenuOptionInfo";

    public PreferenceMenuOptionInfo(Context context, AttributeSet attributeSet) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraMenuOptionInfo, 0, 0);
        initMenuOptionInfo(context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initMenuOptionInfo(android.content.Context r14, android.content.res.TypedArray r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.PreferenceMenuOptionInfo.initMenuOptionInfo(android.content.Context, android.content.res.TypedArray):void");
    }

    private boolean checkTypedArray(TypedArray typedArray) {
        return typedArray != null && typedArray.length() > 0;
    }
}
