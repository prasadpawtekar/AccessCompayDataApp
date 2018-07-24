package com.netwintest.accesscompaydata.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.netwintest.accesscompaydata.R;
import com.netwintest.accesscompaydata.data.MessageData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 7/24/2018.
 */

public class MessageHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvMessage)
    TextView tvMessage;

    public MessageHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Context context, MessageData msg) {
        tvMessage.setText(msg.getMessage());
    }
}
