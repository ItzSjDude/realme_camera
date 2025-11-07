package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface LoaderErrorThrower {

    public static final class Dummy implements com.google.android.exoplayer2.upstream.LoaderErrorThrower {
        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws java.io.IOException {
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i_renamed) throws java.io.IOException {
        }
    }

    void maybeThrowError() throws java.io.IOException;

    void maybeThrowError(int i_renamed) throws java.io.IOException;
}
