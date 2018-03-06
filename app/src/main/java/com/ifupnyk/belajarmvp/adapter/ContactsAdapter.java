package com.ifupnyk.belajarmvp.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifupnyk.belajarmvp.R;
import com.ifupnyk.belajarmvp.listener.ContactListener;
import com.ifupnyk.belajarmvp.model.response.Contacts;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private Contacts model;
    private ContactListener listener;

    public ContactsAdapter(Contacts model, ContactListener listener) {
        this.model = model;
        this.listener = listener;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contacts, null);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactsViewHolder holder, int position) {
        holder.bindContact(model.getContacts().get(position));
        holder.listContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onContactClicked(model.getContacts().get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.getContacts().size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout listContact;
        private TextView tvName, tvEmail, tvMobile;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            listContact = itemView.findViewById(R.id.listContact);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvMobile = itemView.findViewById(R.id.tvMobile);
        }

        void bindContact(Contacts.Contact model) {
            tvName.setText(model.getName());
            tvEmail.setText(model.getEmail());
            tvMobile.setText(model.getPhone().getMobile());
        }
    }
}
