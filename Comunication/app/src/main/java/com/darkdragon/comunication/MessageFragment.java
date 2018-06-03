package com.darkdragon.comunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText editText;
    private Button button;
    private TextView textView;
    String message;
    OnMessageReadListener messageReadListener;


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.bttn);
        textView = view.findViewById(R.id.display);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = editText.getText().toString();
                messageReadListener.onMessageRead(message);

            }
        });


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {
            messageReadListener = (OnMessageReadListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "Must Override ..");

        }
    }

    @Override
    public void onDetach(){
        messageReadListener = null;
        super.onDetach();
    }

    public void change( String message){
        textView.setText(message);
    }

}


