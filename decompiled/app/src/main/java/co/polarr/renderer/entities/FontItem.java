package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class FontItem {
    public java.lang.String fontFamily;
    public java.lang.String src;
    public java.lang.String style;
    public int weight;

    public FontItem(java.lang.String str, int i_renamed, java.lang.String str2) {
        this.fontFamily = str;
        this.weight = i_renamed;
        this.style = "normal";
        this.src = str2;
    }

    public FontItem(java.lang.String str, int i_renamed, java.lang.String str2, java.lang.String str3) {
        this.fontFamily = str;
        this.weight = i_renamed;
        this.style = str2;
        this.src = str3;
    }

    public FontItem(java.lang.String str, java.lang.String str2) {
        this.fontFamily = str;
        this.weight = 600;
        this.style = "normal";
        this.src = str2;
    }

    public FontItem(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.fontFamily = str;
        this.weight = 600;
        this.style = str2;
        this.src = str3;
    }
}
