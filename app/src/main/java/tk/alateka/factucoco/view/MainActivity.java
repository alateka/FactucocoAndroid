package tk.alateka.factucoco.view;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import tk.alateka.factucoco.App;
import tk.alateka.factucoco.R;
import tk.alateka.factucoco.libs.Utils;
import tk.alateka.factucoco.model.Invoice;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils utils = new Utils(this);
        reloadInvoices(utils);

        InvoiceAdapter adapter = new InvoiceAdapter(App.invoices);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.invoice_add_action) {
            Intent launchCreateEditActivity = new Intent(this, CreateEditActivity.class);
            startActivity(launchCreateEditActivity);
            return true;
        }
        if (id == R.id.about_action) {
            Intent launchAboutActivity = new Intent(this, AboutActivity.class);
            startActivity(launchAboutActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void reloadInvoices(Utils utils) {
        App.factudata = utils.readFromFactudata();
        String[] data = App.factudata.split(";;;");
        if (App.factudata.length() > 0)
            for (String invoiceData : data) {
                String[] value = invoiceData.split(":");
                App.invoices.add(new Invoice(Integer.parseInt(
                        value[0]),
                        value[1],
                        value[2],
                        Float.parseFloat(value[3]),
                        Float.parseFloat(value[4]),
                        Float.parseFloat(value[5])
                ));
            }
    }
}