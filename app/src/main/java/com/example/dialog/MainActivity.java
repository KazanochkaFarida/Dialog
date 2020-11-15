package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//прописываем переменные
    Button btnFon;
    ConstraintLayout constraintLayot;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //связываем переменные с элементами на экране
        btnFon = (Button)findViewById(R.id.idbtn);
        constraintLayot = (ConstraintLayout)findViewById(R.id.idconstl);
        context = MainActivity.this;
        btnFon.setOnClickListener(this);

        //добавляем события OnClick
    }

    @Override
    public void onClick(View v) {

        //создаем переменную, которая сформирует список из имеющихся строк
        final CharSequence[] items = {getText(R.string.red),getText(R.string.yellow),getText(R.string.green)};

        //создаем диалоговое окно
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
               switch (item){
                   case 0:
                       constraintLayot.setBackgroundResource(R.color.redColor);
                       Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                       break;
                   case 1:
                       constraintLayot.setBackgroundResource(R.color.yellowColor);
                       Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                       break;
                   case 2:
                       constraintLayot.setBackgroundResource(R.color.greenColor);
                       Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                       break;

               }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}