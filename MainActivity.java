package com.example.guill.compt10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    TextView affiche;
    int memoire;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.affiche = findViewById(R.id.affiche);
        this.button = findViewById(R.id.button);
    }



    public void showPopup(View view){
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.quitter:
                finish();break;
            case R.id.reset:
                affiche.setText("0");
                memoire = 0;break;

        }
        return true;
    }


    public void add1(View view) {
        button.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view){
                showPopup(view);
                return true;
            }
        });
        memoire ++;
        this.affiche.setText(String.valueOf(memoire));
    }
}
