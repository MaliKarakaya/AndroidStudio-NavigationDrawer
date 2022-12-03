package com.mali.navigationdrawer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout cekmece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cekmece=findViewById(R.id.cekmece_arkaplan);
    }
    public void MenuyeTiklama(View view)
    {
        cekmeceyiAc(cekmece);
    }

    public static void cekmeceyiAc(DrawerLayout cekmece)
    {
        cekmece.openDrawer(GravityCompat.START);
    }
    public void LogoyaTiklama(View view)
    {
        cekmeceyiKapat(cekmece);
    }

    public static void cekmeceyiKapat(DrawerLayout cekmece)
    {
        if(cekmece.isDrawerOpen(GravityCompat.START))
        {
            cekmece.closeDrawer(GravityCompat.START);
        }
    }

    public void AnaSayfaTiklama(View view)
    {
        recreate();
    }
    public void YonetimTiklama(View view)
    {
        Intent Admin = new Intent(MainActivity.this,AdminActivity.class);
        startActivity(Admin);
    }

    public void HakkimizdaTiklama(View view)
    {
        Intent Hakkımızda = new Intent(MainActivity.this,HakkimizdaActivity.class);
        startActivity(Hakkımızda);
    }
    public void CikisTiklama(View view)
    {
        AlertDialog.Builder uyariPenceresi = new AlertDialog.Builder(MainActivity.this);
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
        cekmeceyiKapat(cekmece);
        super.onPause();
    }


}