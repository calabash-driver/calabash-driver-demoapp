package sh.calabash.demoproject;

import sh.calabash.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
/**
 * Demo project to verify new created calabash actions.
 * @author ddary
 *
 */
public class HelloAndroidActivity extends Activity {
  private static final int DIALOG_ALERT = 10;
  private static String TAG = "calabash-driver-demoapp";

  /**
   * Called when the activity is first created.
   * 
   * @param savedInstanceState If the activity is being re-initialized after previously being shut
   *        down then this Bundle contains the data it most recently supplied in
   *        onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "onCreate");
    setContentView(R.layout.main);
  }


  public void onClick(View view) {
    showDialog(DIALOG_ALERT);
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    switch (id) {
      case DIALOG_ALERT:
        // Create out AlterDialog
        Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This will end the activity");
        builder.setCancelable(true);
        builder.setPositiveButton("I agree", new OkOnClickListener());
        builder.setNegativeButton("No, no", new CancelOnClickListener());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    return super.onCreateDialog(id);
  }

  private final class CancelOnClickListener implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialog, int which) {
      Toast.makeText(getApplicationContext(), "Activity will continue", Toast.LENGTH_LONG).show();
    }
  }

  private final class OkOnClickListener implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialog, int which) {
      HelloAndroidActivity.this.finish();
    }
  }

}
