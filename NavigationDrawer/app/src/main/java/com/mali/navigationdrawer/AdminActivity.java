package com.mali.navigationdrawer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    DrawerLayout cekmece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        cekmece=findViewById(R.id.cekmece_arkaplan);
    }
    public void MenuyeTiklama(View view)
    {
        MainActivity.cekmeceyiAc(cekmece);
    }
    public void LogoyaTiklama(View view)
    {
       MainActivity.cekmeceyiKapat(cekmece);
    }
    public void AnaSayfaTiklama(View view)
    {
        Intent anaSayfa = new Intent(AdminActivity.this,MainActivity.class);
        startActivity(anaSayfa);
    }
    public void YonetimTiklama(View view)
    {
        recreate();
    }
    public void HakkimizdaTiklama(View view)
    {
        Intent Hakkımızda = new Intent(AdminActivity.this,HakkimizdaActivity.class);
        startActivity(Hakkımızda);
    }
    public void CikisTiklama(View view)
    {
        AlertDialog.Builder uyariPenceresi = new AlertDialog.Builder(AdminActivity.this);
        uyariPenceresi.setTitle("Çıkış");
        uyariPenceresi.setMessage("Çıkış Yapılsın Mı ?");


        uyariPenceresi.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
                System.exit(0);
            }
        });



        uyariPenceresi.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        uyariPenceresi.show();
    }

    @Override
    protected void onPause() {
        MainActivity.cekmeceyiKapat(cekmece);
        super.onPause();
    }
}