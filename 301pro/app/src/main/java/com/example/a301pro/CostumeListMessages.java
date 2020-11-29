package com.example.a301pro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a301pro.Utilities.GetUserFromDB;

import java.util.ArrayList;


public class CostumeListMessages extends ArrayAdapter<Message> {
    private ArrayList<Message> messages;
    private Context context;


    public CostumeListMessages(@NonNull Context context, ArrayList<Message> messages) {
        super(context,0, messages);
        this.messages = messages;
        this.context = context;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //to create the view that we want as a item, and later we will add this to the Adapter
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content_message_center, parent, false);
        }

        Message message = messages.get(position);

        TextView timeStamp = view.findViewById(R.id.messageTime);
        TextView messageDetail = view.findViewById(R.id.messageDetail);
        TextView MessageStatus = view.findViewById(R.id.new_message);

        if (message.getReadStatus().equals("new")){
            MessageStatus.setVisibility(View.VISIBLE);
        }

        else{
            MessageStatus.setVisibility(View.GONE);
        }

        timeStamp.setText(message.getTimeMST());
        messageDetail.setText(message.getMessage());

        return view;
    }
}
