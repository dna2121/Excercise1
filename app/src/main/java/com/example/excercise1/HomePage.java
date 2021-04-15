package com.example.excercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;
    private ListviewAdapter adapter;
    String[] listNama;
    //SearchView searchView;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //searchView = findViewById(R.id.search_bar);
        listNama = new String[]{"Jimin", "Yasmin", "Sekara", "Karin", "Jungkook",
                "Taehyung", "Suga", "Seokjin", "Namjoon", "Hoba"};

        list = findViewById(R.id.listkontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i< listNama.length; i++){
            ClassNama classNama = new ClassNama((listNama[i]));
            classNamaArrayList.add(classNama);
        }

        adapter = new ListviewAdapter(this, classNamaArrayList);
        list.setAdapter(adapter);

        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.filter(s);
                return false;
            }
        });*/

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a", nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                pm.setOnMenuItemClickListener(HomePage.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.mnviewphone:
                String nama = bundle.getString("a");
                if (nama.equals("Jimin")){
                    Toast.makeText(getApplicationContext(),"0812345678",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Yasmin")){
                    Toast.makeText(getApplicationContext(),"0812345679",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Sekara")){
                    Toast.makeText(getApplicationContext(),"0812345670",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Karin")){
                    Toast.makeText(getApplicationContext(),"0812345677",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Jungkook")){
                    Toast.makeText(getApplicationContext(),"0812345676",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Taehyung")){
                    Toast.makeText(getApplicationContext(),"0812345675",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Suga")){
                    Toast.makeText(getApplicationContext(),"0812345674",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Seokjin")){
                    Toast.makeText(getApplicationContext(),"0812345673",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Namjoon")){
                    Toast.makeText(getApplicationContext(),"0812345672",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals("Hoba")){
                    Toast.makeText(getApplicationContext(),"0812345671",Toast.LENGTH_LONG).show();
                }

                break;
        }
        return false;
    }
}