package com.example.yesii.jujuyeventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button entrar = (Button) findViewById(R.id.entrar);
        entrar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.nosotros:

                break;
            case R.id.contactar:
                Toast.makeText(getApplicationContext(), "Para contactarnos dirigirse a...",Toast.LENGTH_LONG).show();
                break;
            case R.id.salir:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick (View v){
        switch (v.getId()){
            case R.id.entrar:
                Intent segundaPantalla = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(segundaPantalla);
                break;
        }
    }
}
