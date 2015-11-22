package mobile.shenkar.com.broadcastrecieverexample.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import mobile.shenkar.com.broadcastrecieverexample.R;
import mobile.shenkar.com.broadcastrecieverexample.bl.MainController;

public class MainActivity extends Activity {

    private MainController controller;
    private EditText editText;
    private EditText etWhen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.etText);
        etWhen = (EditText) findViewById(R.id.etWhen);
        controller = new MainController(this);

    }

    public void remindMeClick(View v) {
        int sec = -1;
        try {
             sec = Integer.parseInt(etWhen.getText().toString());
        }catch (Exception e){
            Toast.makeText(this,"Invalid second number",Toast.LENGTH_SHORT).show();
            return;
        }
        String message = editText.getText().toString();
        controller.createAlarm(message,sec);
    }
}
