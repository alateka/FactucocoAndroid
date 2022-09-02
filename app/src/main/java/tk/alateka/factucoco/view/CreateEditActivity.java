package tk.alateka.factucoco.view;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import tk.alateka.factucoco.App;
import tk.alateka.factucoco.R;
import tk.alateka.factucoco.libs.Utils;
import tk.alateka.factucoco.model.Invoice;

public class CreateEditActivity extends AppCompatActivity {

    private Invoice invoice;
    private Utils utils;
    private int id;

    private TextView inputName;
    private TextView inputDate;
    private TextView inputVatRate;
    private TextView inputVat;
    private TextView inputAmount;
    private TextView inputTotal;
    private TextView inputDescription;

    private MenuItem editItem;
    private MenuItem createItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit);

        utils = new Utils(this);

        inputName = findViewById(R.id.inputName);
        inputDate = findViewById(R.id.inputDate);
        inputVatRate = findViewById(R.id.inputVatRate);
        inputVat = findViewById(R.id.inputVat);
        inputAmount = findViewById(R.id.inputAmount);
        inputTotal = findViewById(R.id.inputTotal);
        inputDescription = findViewById(R.id.inputDescription);

        id = getIntent().getIntExtra("id", 999);
        if ( id != 999 ) {
            invoice = App.invoices.get(id);
            inputName.setText(invoice.getName());
            inputDate.setText(invoice.getDate());
            inputVatRate.setText(String.valueOf(invoice.getVatRate()));
            inputVat.setText(String.valueOf(invoice.getVat()));
            inputAmount.setText(String.valueOf(invoice.getAmount()));
            inputTotal.setText(String.valueOf(invoice.getTotal()));
            inputDescription.setText(invoice.getDescription());
        }
    }

    public void createInvoice()
    {
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
        Toast.makeText(this, R.string.created_invoice, Toast.LENGTH_SHORT).show();
        finish();
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    public void editInvoice()
    {
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
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);
        editItem = menu.findItem(R.id.edit_action);
        createItem = menu.findItem(R.id.create_action);
        if (id != 999)
            editItem.setVisible(true);
        else
            createItem.setVisible(true);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.create_action) {
            createInvoice();
        }
        if (id == R.id.edit_action) {
            editInvoice();
        }
        if (id == R.id.cancel_action) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}