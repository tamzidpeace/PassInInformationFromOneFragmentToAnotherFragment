package com.example.arafat.fragmenttofragmentandalsobetweenacitivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentTwo extends Fragment {

    private  FragmentTowListener listener;
    private EditText editText;
    private Button buttonSend;


    public interface FragmentTowListener {
        void onInputTwoSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        editText = view.findViewById(R.id.edit_text);
        buttonSend = view.findViewById(R.id.send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.onInputTwoSent(input);

            }
        });

        return view;
    }

    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof FragmentTowListener) {
            listener = (FragmentTowListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement FragmentTwoListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }
}
