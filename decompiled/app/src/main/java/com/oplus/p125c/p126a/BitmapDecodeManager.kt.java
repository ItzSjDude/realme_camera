package com.oplus.p125c.p126a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.ParcelFileDescriptor;
import com.oplus.p125c.p126a.p127a.BitmapCacheManager.kt;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import com.oplus.p125c.p126a.p135e.Utils;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import kotlinx.coroutines.Dispatchers.kt;
import kotlinx.coroutines.CoroutineScope.kt;
import kotlinx.coroutines.Builders.common.kt;
import kotlinx.coroutines.CoroutineScope.kt_2;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.p065a.C0914b;
import p061c.p064c.p066b.p067a.ContinuationImpl.kt_3;
import p061c.p069e.Closeable.kt;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: BitmapDecodeManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class BitmapDecodeManager.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final BitmapDecodeManager.kt f10510a = new BitmapDecodeManager.kt();

    private BitmapDecodeManager.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Bitmap m9421a(Context context, MediaItem.kt c2436a, int OplusGLSurfaceView_13) throws Throwable {
        Throwable th;
        FileDescriptor fileDescriptor;
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "item");
        Utils.m9511a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM9510a = Utils.m9510a(c2436a);
        BitmapCacheManager.kt c2428aM9378a = BitmapCacheManager.kt.f10468a.m9378a(context);
        Intrinsics.m5297a((Object) strM9510a, "key");
        Bitmap bitmapM9374a = c2428aM9378a.m9374a(strM9510a);
        if (bitmapM9374a != null) {
            Debugger.kt.m9503a("BitmapDecodeManager", "getImageBitmap key = " + strM9510a + ", has cache cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return bitmapM9374a;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = OplusGLSurfaceView_13;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(c2436a.m9434g(), "r");
            Throwable th2 = (Throwable) null;
            try {
                try {
                    ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorOpenFileDescriptor;
                    if (parcelFileDescriptor2 != null) {
                        try {
                            fileDescriptor = parcelFileDescriptor2.getFileDescriptor();
                        } catch (Throwable th3) {
                            th2 = th3;
                            parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                            try {
                                throw th2;
                            } catch (Throwable th4) {
                                th = th4;
                                th = th2;
                                Closeable.kt.m5285a(parcelFileDescriptor, th);
                                throw th;
                            }
                        }
                    } else {
                        fileDescriptor = null;
                    }
                    Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    try {
                        if (bitmapDecodeFileDescriptor != null) {
                            Bitmap bitmapM9422a = f10510a.m9422a(bitmapDecodeFileDescriptor, c2436a.m9435h());
                            parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                            try {
                                Builders.common.kt.m25810a(CoroutineScope.kt.f24589a, Dispatchers.kt.m25603c(), null, new PlatformImplementations.kt_3(bitmapM9422a, null, c2436a, options, strM9510a, context, jCurrentTimeMillis, OplusGLSurfaceView_13, c2436a), 2, null);
                                Debugger.kt.m9503a("BitmapDecodeManager", "getImageBitmap decode , total time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
                                Closeable.kt.m5285a(parcelFileDescriptor, th2);
                                return bitmapM9422a;
                            } catch (Throwable th5) {
                                th = th5;
                                th = th2;
                            }
                        } else {
                            parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                            th = th2;
                            try {
                                Debugger.kt.m9503a("BitmapDecodeManager", "getImageBitmap decodeFileDescriptor failed ");
                                Unit.kt c1025s = Unit.kt.f5071a;
                                Closeable.kt.m5285a(parcelFileDescriptor, th);
                                Debugger.kt.m9503a("BitmapDecodeManager", "getImageBitmap openFileDescriptor failed ");
                                return null;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th;
                        throw th2;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    th = th2;
                    Closeable.kt.m5285a(parcelFileDescriptor, th);
                    throw th;
                }
                Closeable.kt.m5285a(parcelFileDescriptor, th);
                throw th;
            } catch (Throwable th9) {
                th = th9;
                parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Debugger.kt.m9508c("BitmapDecodeManager", "getImageBitmap", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* compiled from: BitmapDecodeManager.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 extends ContinuationImpl.kt_3 implements Functions.kt_19<CoroutineScope.kt_2, Continuation.kt_2<? super Unit.kt>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ MediaItem.kt $item$inlined;
        final /* synthetic */ String $key$inlined;
        final /* synthetic */ BitmapFactory.Options $options$inlined;
        final /* synthetic */ int $simpleSize$inlined;
        final /* synthetic */ MediaItem.kt $this_apply$inlined;
        final /* synthetic */ long $time$inlined;
        int label;

        /* renamed from: p$ */
        private CoroutineScope.kt_2 f10511p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        PlatformImplementations.kt_3(Bitmap bitmap, Continuation.kt_2 interfaceC0929d, MediaItem.kt c2436a, BitmapFactory.Options options, String str, Context context, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, MediaItem.kt c2436a2) {
            super(2, interfaceC0929d);
            this.$bitmap = bitmap;
            this.$this_apply$inlined = c2436a;
            this.$options$inlined = options;
            this.$key$inlined = str;
            this.$context$inlined = context;
            this.$time$inlined = OplusGLSurfaceView_15;
            this.$simpleSize$inlined = OplusGLSurfaceView_13;
            this.$item$inlined = c2436a2;
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        public final Continuation.kt_2<Unit.kt> create(Object obj, Continuation.kt_2<?> interfaceC0929d) {
            Intrinsics.m5303c(interfaceC0929d, "completion");
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(this.$bitmap, interfaceC0929d, this.$this_apply$inlined, this.$options$inlined, this.$key$inlined, this.$context$inlined, this.$time$inlined, this.$simpleSize$inlined, this.$item$inlined);
            aVar.f10511p$ = (CoroutineScope.kt_2) obj;
            return aVar;
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public final Object invoke(CoroutineScope.kt_2 interfaceC3963y, Continuation.kt_2<? super Unit.kt> interfaceC0929d) {
            return ((PlatformImplementations.kt_3) create(interfaceC3963y, interfaceC0929d)).invokeSuspend(Unit.kt.f5071a);
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        public final Object invokeSuspend(Object obj) {
            C0914b.m5252a();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result.kt_4.m5381a(obj);
            CoroutineScope.kt_2 interfaceC3963y = this.f10511p$;
            BitmapCacheManager.kt c2428aM9378a = BitmapCacheManager.kt.f10468a.m9378a(this.$context$inlined);
            String str = this.$key$inlined;
            Intrinsics.m5297a((Object) str, "key");
            c2428aM9378a.m9376a(str, this.$bitmap);
            return Unit.kt.f5071a;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final int[] m9423b(Context context, MediaItem.kt c2436a, int OplusGLSurfaceView_13) throws FileNotFoundException {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "item");
        Utils.m9511a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM9510a = Utils.m9510a(c2436a);
        BitmapCacheManager.kt c2428aM9378a = BitmapCacheManager.kt.f10468a.m9378a(context);
        Intrinsics.m5297a((Object) strM9510a, "key");
        Bitmap bitmapM9374a = c2428aM9378a.m9374a(strM9510a);
        if (bitmapM9374a != null) {
            Debugger.kt.m9503a("BitmapDecodeManager", "getImageBitmapSize from cache");
            return new int[]{bitmapM9374a.getWidth(), bitmapM9374a.getHeight()};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = OplusGLSurfaceView_13;
        options.inJustDecodeBounds = true;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(c2436a.m9434g(), "r");
            Throwable th = (Throwable) null;
            try {
                ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                if (BitmapFactory.decodeFileDescriptor(parcelFileDescriptor != null ? parcelFileDescriptor.getFileDescriptor() : null, null, options) != null) {
                    Debugger.kt.m9503a("BitmapDecodeManager", "getImageBitmapSize decode  , total time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    Unit.kt c1025s = Unit.kt.f5071a;
                }
                Closeable.kt.m5285a(parcelFileDescriptorOpenFileDescriptor, th);
                Debugger.kt.m9503a("BitmapDecodeManager", "getImageBitmapSize from decode");
                return new int[]{options.outWidth, options.outHeight};
            } catch (Throwable th2) {
                Closeable.kt.m5285a(parcelFileDescriptorOpenFileDescriptor, th);
                throw th2;
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Debugger.kt.m9508c("BitmapDecodeManager", "getImageBitmap", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Bitmap m9422a(Bitmap bitmap, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(OplusGLSurfaceView_13);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Intrinsics.m5297a((Object) bitmapCreateBitmap, "Bitmap.createBitmap(bitm…, width, height, OplusGLSurfaceView_6, true)");
        return bitmapCreateBitmap;
    }
}
