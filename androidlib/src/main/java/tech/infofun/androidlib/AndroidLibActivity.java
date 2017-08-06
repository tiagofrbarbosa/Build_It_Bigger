package tech.infofun.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class AndroidLibActivity extends AppCompatActivity {

    public final static String EXTRA_JOKE = "EXTRA_JOKE";
    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_lib_main);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(EXTRA_JOKE);

        myText = (TextView) findViewById(R.id.myText);
        myText.setText(joke);
    }
}
