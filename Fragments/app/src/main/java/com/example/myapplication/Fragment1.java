package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class Fragment1 extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_1, container, false);

        Button button = rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = rootView.findViewById(R.id.editTextText1);
                String userInput = editText.getText().toString();

                Bundle result = new Bundle();
                result.putString("data_from_fragment1", userInput);

                getParentFragmentManager().setFragmentResult("request_key", result);

                editText.setText("");
            }
        });

        return rootView;
    }
}
