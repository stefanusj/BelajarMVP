package com.ifupnyk.belajarmvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifupnyk.belajarmvp.model.response.ContactModel;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private ContactModel model;

    public ContactsAdapter(ContactModel model) {
        this.model = model;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contacts, null);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        holder.bindContacts(model.getContacts().get(position));
    }

    @Override
    public int getItemCount() {
        return model.getContacts().size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvEmail, tvMobile;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvMobile = itemView.findViewById(R.id.tvMobile);
        }

        void bindContacts(ContactModel.Contact model) {
            tvName.setText(model.getName());
            tvEmail.setText(model.getEmail());
            tvMobile.setText(model.getPhone().getMobile());
        }
    }
}
