package com.oplus.camera.timelapsepro.adapter;

/* loaded from: classes2.dex */
public class BaseViewHolder extends androidx.recyclerview.widget.RecyclerView.w_renamed {
    public BaseViewHolder(android.view.View view) {
        super(view);
    }

    public void setItemClickCallback(android.view.View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.itemView.setOnClickListener(onClickListener);
        }
    }
}
