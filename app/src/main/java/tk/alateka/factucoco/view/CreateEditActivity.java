package tk.alateka.factucoco.view;

import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tk.alateka.factucoco.App;
import tk.alateka.factucoco.R;
import tk.alateka.factucoco.libs.Utils;
import tk.alateka.factucoco.model.Invoice;

public class CreateEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit);

        Utils utils = new Utils(this);

        TextView inputName = findViewById(R.id.inputName);
        TextView inputDate = findViewById(R.id.inputDate);
        TextView inputVatRate = findViewById(R.id.inputVatRate);
        TextView inputVat = findViewById(R.id.inputVat);
        TextView inputTotal = findViewById(R.id.inputTotal);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view -> {
            App.invoices.add(new Invoice(
                    App.invoices.size(),
                    inputName.getText().toString(),
                    inputDate.getText().toString(),
                    Float.parseFloat(inputVatRate.getText().toString()),
                    Float.parseFloat(inputVat.getText().toString()),
                    Float.parseFloat(inputTotal.getText().toString())
            ));
            utils.writeToFactudata();
            finish();
        });
    }
}