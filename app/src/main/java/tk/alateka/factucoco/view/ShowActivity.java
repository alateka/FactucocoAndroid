package tk.alateka.factucoco.view;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import tk.alateka.factucoco.App;
import tk.alateka.factucoco.R;
import tk.alateka.factucoco.model.Invoice;

public class ShowActivity extends AppCompatActivity {

    private Invoice invoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView inputName = findViewById(R.id.inputName);
        TextView inputDate = findViewById(R.id.inputDate);
        TextView inputVatRate = findViewById(R.id.inputVatRate);
        TextView inputVat = findViewById(R.id.inputVat);
        TextView inputAmount = findViewById(R.id.inputAmount);
        TextView inputTotal = findViewById(R.id.inputTotal);
        TextView inputDescription = findViewById(R.id.inputDescription);

        int id = getIntent().getIntExtra("id", 999);
        invoice = App.invoices.get(id);
        inputName.setText(invoice.getName());
        inputDate.setText(invoice.getDate());
        inputVatRate.setText(String.valueOf(invoice.getVatRate()));
        inputVat.setText(String.valueOf(invoice.getVat()));
        inputAmount.setText(String.valueOf(invoice.getAmount()));
        inputTotal.setText(String.valueOf(invoice.getTotal()));
        inputDescription.setText(invoice.getDescription());
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.back_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.back_action) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}