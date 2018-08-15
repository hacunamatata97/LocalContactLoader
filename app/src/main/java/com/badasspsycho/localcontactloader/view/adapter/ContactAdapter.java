package com.badasspsycho.localcontactloader.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.badasspsycho.localcontactloader.R;
import com.badasspsycho.localcontactloader.model.Contact;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private ArrayList<Contact> mContacts;
    private Context mContext;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        this.mContext = context;
        this.mContacts = contacts;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.bindData(mContext, contact);
    }

    @Override
    public int getItemCount() {
        return mContacts != null ? mContacts.size() : 0;
    }

    public class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageContact;
        private TextView mTextContactName;
        private TextView mTextContactPhone;
        private ToggleButton mButtonFavorite;
        private ImageView mImageCall;
        private ImageView mImageMessage;
        private Context mContext;

        public ContactHolder(View itemView) {
            super(itemView);
            mImageContact = itemView.findViewById(R.id.image_contact);
            mTextContactName = itemView.findViewById(R.id.text_contact_name);
            mTextContactPhone = itemView.findViewById(R.id.text_contact_phone);
            mButtonFavorite = itemView.findViewById(R.id.button_favorite);
            mImageCall = itemView.findViewById(R.id.image_call);
            mImageMessage = itemView.findViewById(R.id.image_sms);
        }

        public void bindData(Context context, Contact contact) {
            mContext = context;
            mTextContactName.setText(contact.getName());
            mTextContactPhone.setText(contact.getPhone());

            mImageCall.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_call:
                    break;
            }
        }
    }
}
