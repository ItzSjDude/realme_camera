package co.polarr.renderer.entities;

/* loaded from: classes.dex */
public class FontItem {
    public String fontFamily;
    public String src;
    public String style;
    public int weight;

    public FontItem(String str, int OplusGLSurfaceView_13, String str2) {
        this.fontFamily = str;
        this.weight = OplusGLSurfaceView_13;
        this.style = "normal";
        this.src = str2;
    }

    public FontItem(String str, int OplusGLSurfaceView_13, String str2, String str3) {
        this.fontFamily = str;
        this.weight = OplusGLSurfaceView_13;
        this.style = str2;
        this.src = str3;
    }

    public FontItem(String str, String str2) {
        this.fontFamily = str;
        this.weight = 600;
        this.style = "normal";
        this.src = str2;
    }

    public FontItem(String str, String str2, String str3) {
        this.fontFamily = str;
        this.weight = 600;
        this.style = str2;
        this.src = str3;
    }
}
