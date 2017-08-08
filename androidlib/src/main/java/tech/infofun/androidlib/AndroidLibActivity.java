package tech.infofun.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;


public class AndroidLibActivity extends AppCompatActivity {

    public final static String EXTRA_JOKE = "EXTRA_JOKE";
    private TextView myText;
    private ImageView avatar;
    private int id_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_lib_main);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(EXTRA_JOKE);

        avatar = (ImageView) findViewById(R.id.iv_avatar);

        id_avatar = new Random().nextInt();

        Picasso.with(this)
                .load("https://api.adorable.io/avatars/285/" + id_avatar + ".png")
                .into(avatar);

        myText = (TextView) findViewById(R.id.myText);
        myText.setText(joke);
    }
}
