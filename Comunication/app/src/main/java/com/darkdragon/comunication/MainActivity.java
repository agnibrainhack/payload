package com.darkdragon.comunication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnMessageReadListener, MVPContractMainActivity.View{
    private TextView textView;
    private Button button;
    MessageFragment messageFragment;
    Presenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt_display_message);
        button = findViewById(R.id.hit);

        presenter = new Presenter(this);
        //Activity activity = (Activity) getBaseContext();


        if(findViewById(R.id.fragment_container) != null ){

            if(savedInstanceState != null){
                return;
            }
            messageFragment = new MessageFragment();

            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, messageFragment, "tagg");
            fragmentTransaction.commit();

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MessageFragment)messageFragment).change("hit");

            }
        });

    }

    @Override
    public void onMessageRead(String message) {

        presenter.presenterlogic(message);                 //not really necessary,    but in any-case


    }


    @Override
    public void viewlogic(String message) {
        textView.setText(message);
    }
}
