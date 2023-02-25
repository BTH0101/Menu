package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.button);
        btn2= findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu =new PopupMenu(MainActivity.this, btn2);
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.maudo:
                constraintLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.mauvang:
                constraintLayout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.mauxanh:
                constraintLayout.setBackgroundColor(Color.BLUE);
                break;
        }
        return false;
    }
});
                popupMenu.show();
            }
        });
        constraintLayout= findViewById(R.id.constraint);
registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    getMenuInflater().inflate(R.menu.menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()){
          case R.id.maudo:
constraintLayout.setBackgroundColor(Color.RED);
              break;
          case R.id.mauvang:
              constraintLayout.setBackgroundColor(Color.YELLOW);
              break;
          case R.id.mauxanh:
              constraintLayout.setBackgroundColor(Color.BLUE);
              break;
      }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

      getMenuInflater().inflate(R.menu.menu,menu);  return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()){
          case R.id.maudo:
              Toast.makeText(this,""+item.getTitle().toString(),Toast.LENGTH_SHORT).show();

              break;
          case R.id.mauxanh:
              Toast.makeText(this,""+item.getTitle().toString(),Toast.LENGTH_SHORT).show();
              break;
          case R.id.mauvang:
              Toast.makeText(this,""+item.getTitle().toString(),Toast.LENGTH_SHORT).show();
              break;
      }

        return super.onOptionsItemSelected(item);
    }

}