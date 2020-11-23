package com.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.View_Holder> {

    private ArrayList<Contacts> mContactsArrayList = new ArrayList<>();
    private Context mContext;

    public ContactsAdapter(MainActivity context, ArrayList<Contacts> contactsArrayList) {
        this.mContactsArrayList = contactsArrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ContactsAdapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contacts_child_view, parent, false);
        return new View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.View_Holder holder, int position) {
        holder.tv_name.setText(mContactsArrayList.get(position).getName());
        holder.tv_phno.setText(mContactsArrayList.get(position).getPhno());
    }

    @Override
    public int getItemCount() {
        return mContactsArrayList.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_phno;
        public View_Holder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phno = itemView.findViewById(R.id.tv_phno);
        }
    }
}
