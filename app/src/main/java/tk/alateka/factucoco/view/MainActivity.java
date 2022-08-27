package tk.alateka.factucoco.view;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import org.jetbrains.annotations.NotNull;
import tk.alateka.factucoco.R;
import tk.alateka.factucoco.model.Invoice;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, "Patata pdf", "21/24/2021", 21, 300, 305));
        invoices.add(new Invoice(2, "Pepe jpeg", "21/24/2021", 21, 123, 451));
        invoices.add(new Invoice(3, "cjpe", "12/07/2021", 21, 654, 874));

        InvoiceAdapter adapter = new InvoiceAdapter(invoices);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
        });
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.invoice_add_action) {
            Toast.makeText(this, "Añadida", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.about_action) {
            Intent launchAboutActivity = new Intent(this, AboutActivity.class);
            startActivity(launchAboutActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}