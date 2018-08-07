package com.badasspsycho.localcontactloader.view.adapter;

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

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ContactHolder extends RecyclerView.ViewHolder {

        private ImageView imageContact;
        private TextView textContactName;
        private TextView textContactPhone;
        private ToggleButton buttonFavorite;
        private ImageView imageCall;
        private ImageView imageMessage;

        public ContactHolder(View itemView) {
            super(itemView);
            imageContact = itemView.findViewById(R.id.image_contact);
            textContactName = itemView.findViewById(R.id.text_contact_name);
            textContactPhone = itemView.findViewById(R.id.text_contact_phone);
            buttonFavorite = itemView.findViewById(R.id.button_favorite);
            imageCall = itemView.findViewById(R.id.image_call);
            imageMessage = itemView.findViewById(R.id.image_sms);
        }

        public void bindData(Contact contact) {
            textContactName.setText(contact.getName());
            textContactPhone.setText(contact.getPhone());
        }
    }
}
