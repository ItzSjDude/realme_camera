package com.oplus.camera.timelapsepro.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class BaseViewHolder extends RecyclerView.AbstractC0707w {
    public BaseViewHolder(View view) {
        super(view);
    }

    public void setItemClickCallback(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.itemView.setOnClickListener(onClickListener);
        }
    }
}
