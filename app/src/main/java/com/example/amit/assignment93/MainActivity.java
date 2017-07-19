package com.example.amit.assignment93;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int call=0;
    public static final int sendSMS=1;
ListView list;
    String[]name={"Amit Roy","Sumit Mondal","Sujoy Dey","Bidyut Mondal","Sourin Bairagi"};
    String[]number={"8013207158","9007463481","9836579692","9903144449","8013230462"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        Adapter Adapter=new Adapter(this,name,number);
        list.setAdapter(Adapter);
        registerForContextMenu(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this,"Click On....." +name[position]+"& Number is:"+number[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(Menu.NONE,call,Menu.NONE,"Call");
        menu.add(Menu.NONE,sendSMS,Menu.NONE,"Send SMS");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==call) {
            Toast.makeText(MainActivity.this, "Click On Call", Toast.LENGTH_SHORT).show();
        }else if(id==sendSMS){
            Toast.makeText(MainActivity.this, "Click On Send SMS", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
