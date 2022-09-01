// Author ==> Alberto Pérez Fructuoso
// File   ==> InvoiceAdapter.java
// Date   ==> 2022/05/29

package tk.alateka.factucoco.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import tk.alateka.factucoco.App;
import tk.alateka.factucoco.R;
import tk.alateka.factucoco.libs.Utils;
import tk.alateka.factucoco.model.Invoice;

import java.util.ArrayList;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.ViewHolder>{
    private ArrayList<Invoice> invoicesList;
    private Utils utils;

    public InvoiceAdapter(ArrayList<Invoice> invoicesList) {
        this.invoicesList = invoicesList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.invoice_card, parent, false);
        return new ViewHolder(listItem);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Invoice invoice = invoicesList.get(position);

        holder.invoiceName.setText(invoice.getName());
        holder.invoiceDate.setText(invoice.getDate());

        holder.invoiceType.setImageResource(R.drawable.office_document_type);

        if (invoice.getName().contains("pdf"))
            holder.invoiceType.setImageResource(R.drawable.pdf_type);

        final LinearLayout relativeLayout = holder.relativeLayout;
        holder.relativeLayout.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(v.getContext(), relativeLayout);
            popup.inflate(R.menu.document_option_menu);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.show_invoice:
                        Intent launchShowActivity = new Intent(v.getContext(), ShowActivity.class);
                        launchShowActivity.putExtra("id", position);
                        v.getContext().startActivity(launchShowActivity);
                        return true;
                    case R.id.edit_invoice:
                        Intent launchCreateEditActivity = new Intent(v.getContext(), CreateEditActivity.class);
                        launchCreateEditActivity.putExtra("id", position);
                        v.getContext().startActivity(launchCreateEditActivity);
                        return true;
                    case R.id.delete_invoice:
                        App.invoices.remove(position);
                        utils = new Utils(v.getContext());
                        Toast.makeText(relativeLayout.getContext(), R.string.toast_deleted_invoice, Toast.LENGTH_SHORT).show();
                        utils.writeToFactudata();
                        Intent back = new Intent(v.getContext(), MainActivity.class);
                        v.getContext().startActivity(back);
                        return true;
                }
                return false;
            });
            popup.show();
        });
    }


    @Override
    public int getItemCount() {
        return invoicesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView invoiceID;
        public ImageView invoiceType;
        public TextView invoiceName;
        public TextView invoiceDate;
        public LinearLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            invoiceID = itemView.findViewById(R.id.invoice_id);
            invoiceType = itemView.findViewById(R.id.invoice_type);
            invoiceName = itemView.findViewById(R.id.invoice_name);
            invoiceDate = itemView.findViewById(R.id.invoice_date);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}  
