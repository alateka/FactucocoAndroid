package tk.alateka.factucoco.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tk.alateka.factucoco.App;
import tk.alateka.factucoco.R;
import tk.alateka.factucoco.libs.Utils;
import tk.alateka.factucoco.model.Invoice;

public class CreateEditActivity extends AppCompatActivity {

    private Invoice invoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit);

        Utils utils = new Utils(this);

        TextView inputName = findViewById(R.id.inputName);
        TextView inputDate = findViewById(R.id.inputDate);
        TextView inputVatRate = findViewById(R.id.inputVatRate);
        TextView inputVat = findViewById(R.id.inputVat);
        TextView inputAmount = findViewById(R.id.inputAmount);
        TextView inputTotal = findViewById(R.id.inputTotal);
        TextView inputDescription = findViewById(R.id.inputDescription);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnEdit = findViewById(R.id.btnEdit);

        int id = getIntent().getIntExtra("id", 999);
        if ( id != 999 ) {
            btnEdit.setVisibility(View.VISIBLE);
            invoice = App.invoices.get(id);
            inputName.setText(invoice.getName());
            inputDate.setText(invoice.getDate());
            inputVatRate.setText(String.valueOf(invoice.getVatRate()));
            inputVat.setText(String.valueOf(invoice.getVat()));
            inputAmount.setText(String.valueOf(invoice.getAmount()));
            inputTotal.setText(String.valueOf(invoice.getTotal()));
            inputDescription.setText(invoice.getDescription());
        } else
            btnSave.setVisibility(View.VISIBLE);

        btnSave.setOnClickListener(view -> {
            App.invoices.add(new Invoice(
                    App.invoices.size(),
                    inputName.getText().toString(),
                    inputDate.getText().toString(),
                    Float.parseFloat(inputVatRate.getText().toString()),
                    Float.parseFloat(inputVat.getText().toString()),
                    Float.parseFloat(inputAmount.getText().toString()),
                    Float.parseFloat(inputTotal.getText().toString()),
                    inputDescription.getText().toString()
            ));
            utils.writeToFactudata();
            Toast.makeText(this, R.string.modified_invoice, Toast.LENGTH_SHORT).show();
            finish();
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        });

        btnEdit.setOnClickListener(view -> {
            invoice = App.invoices.get(id);
            invoice.setName(inputName.getText().toString());
            invoice.setDate(inputDate.getText().toString());
            invoice.setVatRate(Float.parseFloat(inputVatRate.getText().toString()));
            invoice.setVat(Float.parseFloat(inputVat.getText().toString()));
            invoice.setAmount(Float.parseFloat(inputAmount.getText().toString()));
            invoice.setTotal(Float.parseFloat(inputTotal.getText().toString()));
            invoice.setDescription(inputDescription.getText().toString());
            utils.writeToFactudata();
            Toast.makeText(this, R.string.modified_invoice, Toast.LENGTH_SHORT).show();
            finish();
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        });
    }
}