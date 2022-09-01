package tk.alateka.factucoco.libs;

import android.content.Context;
import tk.alateka.factucoco.App;
import tk.alateka.factucoco.model.Invoice;

import java.io.*;

public class Utils {

    private Context cnx;

    public Utils(Context cnx) {
        this.cnx = cnx;
    }

    public void writeToFactudata()
    {
        try {
            OutputStreamWriter writeFactudata = new OutputStreamWriter(
                    cnx.openFileOutput("Factudata.data", Context.MODE_PRIVATE));

            for (Invoice invoice : App.invoices) {
                writeFactudata.write(
                        invoice.getId()+":"+
                            invoice.getName()+":"+
                            invoice.getDate()+":"+
                            invoice.getVatRate()+":"+
                            invoice.getVat()+":"+
                            invoice.getAmount()+":"+
                            invoice.getTotal()+":"+
                            invoice.getDescription()+";;;"

                );
            }
            writeFactudata.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFactudata() {
        String result = "";
        try {
            InputStreamReader factudata = new InputStreamReader(cnx.openFileInput("Factudata.data"));
            BufferedReader readFactudata = new BufferedReader(factudata);

            String line = readFactudata.readLine();
            while (line != null) {
                result += line;
                line = readFactudata.readLine();
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
