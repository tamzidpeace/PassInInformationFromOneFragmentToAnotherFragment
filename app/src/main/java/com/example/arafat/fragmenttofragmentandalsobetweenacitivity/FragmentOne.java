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

public class FragmentOne extends Fragment {

    private FragmentOneListener listener;
    private EditText editText;
    private Button buttonOK;

    public interface FragmentOneListener {
        void onInputOneSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        editText = view.findViewById(R.id.edit_text);
        buttonOK = view.findViewById(R.id.send);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.onInputOneSent(input);
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

        if(context instanceof FragmentOneListener) {
            listener = (FragmentOneListener) context;
        } else {
            throw new RuntimeException(context.toString()
            + "must implement FragmentOneListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
