// Author ==> Alberto Pérez Fructuoso
// File   ==> AboutActivity.java
// Date   ==> 2022/05/29

package tk.alateka.factucoco.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import org.jetbrains.annotations.NotNull;
import tk.alateka.factucoco.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

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