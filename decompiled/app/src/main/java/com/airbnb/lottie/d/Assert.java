package com.airbnb.lottie.d_renamed;

/* compiled from: DefaultLottieFetchResult.java */
/* loaded from: classes.dex */
public class a_renamed implements com.airbnb.lottie.d_renamed.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.net.HttpURLConnection f2146a;

    public a_renamed(java.net.HttpURLConnection httpURLConnection) {
        this.f2146a = httpURLConnection;
    }

    @Override // com.airbnb.lottie.d_renamed.d_renamed
    public boolean a_renamed() {
        try {
            return this.f2146a.getResponseCode() / 100 == 2;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    @Override // com.airbnb.lottie.d_renamed.d_renamed
    public java.io.InputStream b_renamed() throws java.io.IOException {
        return this.f2146a.getInputStream();
    }

    @Override // com.airbnb.lottie.d_renamed.d_renamed
    public java.lang.String c_renamed() {
        return this.f2146a.getContentType();
    }

    @Override // com.airbnb.lottie.d_renamed.d_renamed
    public java.lang.String d_renamed() {
        try {
            if (a_renamed()) {
                return null;
            }
            return "Unable to fetch " + this.f2146a.getURL() + ". Failed with " + this.f2146a.getResponseCode() + "\n_renamed" + a_renamed(this.f2146a);
        } catch (java.io.IOException e_renamed) {
            com.airbnb.lottie.f_renamed.d_renamed.a_renamed("get error failed ", e_renamed);
            return e_renamed.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2146a.disconnect();
    }

    private java.lang.String a_renamed(java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getErrorStream()));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            try {
                try {
                    java.lang.String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\n_renamed');
                    } else {
                        try {
                            break;
                        } catch (java.lang.Exception unused) {
                        }
                    }
                } catch (java.lang.Exception e_renamed) {
                    throw e_renamed;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (java.lang.Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
