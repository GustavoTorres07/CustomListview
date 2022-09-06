package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListViewContacto;
    List<Contacto> lst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewContacto = findViewById(R.id.ListViewContacto);

        CustomAdapter adapter = new CustomAdapter(this, GetData());
        ListViewContacto.setAdapter(adapter);

        ListViewContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contacto c = lst.get(i);
                Toast.makeText(getBaseContext(), c.nombre, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<Contacto> GetData() {

        lst = new ArrayList<>();

        lst.add(new Contacto(1, R.drawable.user, "Gustavo", "+54 9 2954 216751"));
        lst.add(new Contacto(1, R.drawable.user, "Juan", "+54 9 2302 541269"));

        return lst;
    }
}