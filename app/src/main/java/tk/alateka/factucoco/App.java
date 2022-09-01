package tk.alateka.factucoco;

import android.app.Application;
import android.content.Context;
import tk.alateka.factucoco.model.Invoice;

import java.util.ArrayList;

public class App extends Application {
    public static ArrayList<Invoice> invoices = new ArrayList<>();
    public static String factudata = "";
    public static boolean refresh = true;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
