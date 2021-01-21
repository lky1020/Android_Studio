package com.example.lesson_2.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lesson_2.R;

public class AFragment extends Fragment {

    private TextView tvTitle;
    private Button btnMessage;
    private Button btnChange;
    private Button btnReset;
    private BFragment bFragment;
    private IONMessageClick listener;

    public static AFragment newInstance(String title){
        AFragment fragment = new AFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title", title);

        fragment.setArguments(bundle); //fragment is use setArguments, activity is use putExtras
        return fragment;
    }

    public interface IONMessageClick{
        void onClick(String text);
    }

    @Override
    //Need to be implements in the ContainerActivity
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener = (IONMessageClick) context;
        }
        catch(ClassCastException e){
            throw new ClassCastException("Activity 必须实现");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Set the view for fragment (different from the activity)
        View view = inflater.inflate(R.layout.layout_fragment_a, container, false);

        Log.d("AFragment", "--- onCreateView ---");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle = view.findViewById(R.id.tv_title);
        btnMessage = view.findViewById(R.id.btn_message);
        btnChange = view.findViewById(R.id.btn_change);
        btnReset = view.findViewById(R.id.btn_reset);

        btnMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(getActivity() != null){
                    //((ContainerActivity) getActivity()).setData("你好");
                    listener.onClick("你好");
                }
            }
        });

        btnChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();

                    Fragment fragment = getFragmentManager().findFragmentByTag("a");
                    if(fragment != null){
                        //if got AFragment been created, hide it first, and then add BFragment (to prevent created new view for AFragment when return from BFragment)
                        getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();

                    }else{
                        //if got AFragment not created, directly add BFragment
                        getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();

                    }
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvTitle.setText("我是新文字");
            }
        });

        if(getArguments() != null){
            tvTitle.setText(getArguments().getString("title"));
        }
    }

}
