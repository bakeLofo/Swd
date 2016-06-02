package com.example.klaudia.swd;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button zapiszButton;
    private int index = -1;
    private boolean czyMorze = false;
    private boolean czyEgzotyka=false;
    private boolean czyGory = false;
    private boolean czyMiasto = false;
    private boolean czyOpalanie = false;
    private boolean czyZwiedzanie = false;
    private boolean czySport = false;
    private boolean czyCieply = false;
    private boolean czyUmiarkowany = false;
    private boolean czyZimny = false;

    private ImageButton cieplyKlimat;
    private ImageButton umiarkowanyKlimat;
    private ImageButton zimnyKlimat;
    private ImageButton morzeButton;
    private ImageButton goryButton;
    private ImageButton miastoButton;
    private ImageButton opalanieButton;
    private ImageButton zwiedzanieButton;
    private ImageButton sportButton;
    private ImageButton egzotykaButton;

    private final int color = Color.argb(100, 0, 204, 102);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        zapiszButton = (Button)findViewById(R.id.zapisz_button);
        morzeButton = (ImageButton) findViewById(R.id.morze);
        goryButton = (ImageButton) findViewById(R.id.gory);
        miastoButton = (ImageButton) findViewById(R.id.miasto);
        opalanieButton = (ImageButton) findViewById(R.id.opalanie);
        zwiedzanieButton = (ImageButton) findViewById(R.id.zwiedzanie);
        sportButton = (ImageButton) findViewById(R.id.sport);
        cieplyKlimat = (ImageButton) findViewById(R.id.cieplo);
        umiarkowanyKlimat = (ImageButton) findViewById(R.id.umiarkowanie);
        zimnyKlimat = (ImageButton) findViewById(R.id.zimno);
        egzotykaButton= (ImageButton) findViewById(R.id.egzotyka);

        morzeButton.setOnClickListener(this);
        goryButton.setOnClickListener(this);
        miastoButton.setOnClickListener(this);
        opalanieButton.setOnClickListener(this);
        zwiedzanieButton.setOnClickListener(this);
        sportButton.setOnClickListener(this);
        cieplyKlimat.setOnClickListener(this);
        umiarkowanyKlimat.setOnClickListener(this);
        zimnyKlimat.setOnClickListener(this);
        egzotykaButton.setOnClickListener(this);

        //this.setFilters();

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            Option editable = (Option) extras.getSerializable("editable");
            if (editable != null) {
                index = extras.getInt("pos");
                this.setSelected(editable);
            }
        }
        //button.setColorFilter(Color.argb(100, 51, 153, 255));
    }

    private void setFilters(){
        morzeButton.setColorFilter(color);
        goryButton.setColorFilter(color);
        miastoButton.setColorFilter(color);
        opalanieButton.setColorFilter(color);
        zwiedzanieButton.setColorFilter(color);
        sportButton.setColorFilter(color);
        egzotykaButton.setColorFilter(color);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.morze:
                if(czyMorze){
                    morzeButton.clearColorFilter();
                    czyMorze = false;
                }
                else{
                    morzeButton.setColorFilter(color);
                    czyMorze = true;
                }
                break;
            case R.id.gory:
                if(czyGory){
                    goryButton.clearColorFilter();
                    czyGory = false;
                }
                else{
                    goryButton.setColorFilter(color);
                    czyGory = true;
                }
                break;
            case R.id.miasto:
                if(czyMiasto){
                    miastoButton.clearColorFilter();
                    czyMiasto = false;
                }
                else{
                    miastoButton.setColorFilter(color);
                    czyMiasto = true;
                }
                break;
            case R.id.egzotyka:
                if(czyEgzotyka){
                    egzotykaButton.clearColorFilter();
                    czyEgzotyka = false;
                }
                else{
                    egzotykaButton.setColorFilter(color);
                    czyEgzotyka = true;
                }
                break;
            case R.id.opalanie:
                if(czyOpalanie){
                    opalanieButton.clearColorFilter();
                    czyOpalanie = false;
                }
                else{
                    opalanieButton.setColorFilter(color);
                    czyOpalanie = true;
                }
                break;
            case R.id.zwiedzanie:
                if(czyZwiedzanie){
                    zwiedzanieButton.clearColorFilter();
                    czyZwiedzanie = false;
                }
                else{
                    zwiedzanieButton.setColorFilter(color);
                    czyZwiedzanie = true;
                }
                break;
            case R.id.sport:
                if(czySport){
                    sportButton.clearColorFilter();
                    czySport = false;
                }
                else{
                    sportButton.setColorFilter(color);
                    czySport = true;
                }
                break;
            case R.id.cieplo:
                if(czyCieply){
                    cieplyKlimat.clearColorFilter();
                    czyCieply = false;
                }
                else{
                    cieplyKlimat.setColorFilter(color);
                    czyCieply = true;
                }
                break;
            case R.id.umiarkowanie:
                if(czyUmiarkowany){
                    umiarkowanyKlimat.clearColorFilter();
                    czyUmiarkowany = false;
                }
                else{
                    umiarkowanyKlimat.setColorFilter(color);
                    czyUmiarkowany = true;
                }
                break;
            case R.id.zimno:
                if(czyZimny){
                    zimnyKlimat.clearColorFilter();
                    czyZimny = false;
                }
                else{
                    zimnyKlimat.setColorFilter(color);
                    czyZimny = true;
                }
                break;
        }
    }

    public void zapisz(View view) {
        List<Aktywnosc> aktywnoscList = new ArrayList<>();
        List<Lokalizacja> lokalizacjaList = new ArrayList<>();
        Klimat klimat = null;

        if(czySport){
            aktywnoscList.add(Aktywnosc.SPORT);
        }
        if(czyZwiedzanie){
            aktywnoscList.add(Aktywnosc.ZWIEDZANIE);
        }
        if(czyOpalanie){
            aktywnoscList.add(Aktywnosc.OPALANIE);
        }
        if(czyMiasto){
            lokalizacjaList.add(Lokalizacja.MIASTO);
        }
        if(czyGory){
            lokalizacjaList.add(Lokalizacja.GORY);
        }
        if(czyMorze){
            lokalizacjaList.add(Lokalizacja.MORZE);
        }
        if(czyEgzotyka){
            lokalizacjaList.add(Lokalizacja.EGZOTYKA);
        }
        if(czyCieply){
            klimat = Klimat.CIEPLY;
        }
        else if(czyUmiarkowany){
            klimat = Klimat.UMIARKOWANY;
        }
        else if(czyZimny){
            klimat = Klimat.ZIMNY;
        }
       final Option option = new Option(klimat, aktywnoscList, lokalizacjaList);
        if(index > -1){

            if(option.isEmpty(option)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));
                builder.setMessage(R.string.message).setTitle("Pusty wybór zostanie usunięty, jesteś pewny?");
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Main activity","usunieto opcje" );
                        ListActivity.adapter.remove(option);
                        ListActivity.adapter.notifyDataSetChanged();
                        Intent intent = new Intent(MainActivity.this, ListActivity.class);
                        //intent.putExtra("created", option);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                dialog.setCancelable(false);


            }else {
                ListActivity.options.set(index, option);
                ListActivity.adapter.notifyDataSetChanged();
                Log.d("Main activity","zmieniono opcje" );
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                //intent.putExtra("created", option);
                this.finish();
                startActivity(intent);
            }
        }
        else{
            ListActivity.options.add(option);
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            //intent.putExtra("created", option);
            this.finish();
            startActivity(intent);
        }

    }

    private void setSelected(Option option){
        Klimat klimat = option.getKlimat();
        List<Aktywnosc> aktywnoscList = option.getAktywnoscList();
        List<Lokalizacja> lokalizacjaList = option.getLokalizacjaList();

        if(klimat != null){
            if(klimat == Klimat.CIEPLY){
                this.setButtonSelected(cieplyKlimat);
                czyCieply = true;
            }
            else if(klimat == Klimat.UMIARKOWANY){
                this.setButtonSelected(umiarkowanyKlimat);
                czyUmiarkowany = true;
            }
            else{
                this.setButtonSelected(zimnyKlimat);
                czyZimny = true;
            }
        }

        if(aktywnoscList != null && !aktywnoscList.isEmpty()){
            for(Aktywnosc akt : aktywnoscList){
                if(akt == Aktywnosc.OPALANIE){
                    this.setButtonSelected(opalanieButton);
                    czyOpalanie = true;
                }
                else if(akt == Aktywnosc.SPORT){
                    this.setButtonSelected(sportButton);
                    czySport = true;
                }
                else{
                    this.setButtonSelected(zwiedzanieButton);
                    czyZwiedzanie = true;
                }
            }
        }

        if(lokalizacjaList != null && !lokalizacjaList.isEmpty()){
            for(Lokalizacja lok : lokalizacjaList){
                if(lok == Lokalizacja.GORY){
                    this.setButtonSelected(goryButton);
                    czyGory = true;
                }
                else if(lok == Lokalizacja.MIASTO){
                    this.setButtonSelected(miastoButton);
                    czyMiasto = true;
                }
                else if(lok == Lokalizacja.EGZOTYKA){
                    this.setButtonSelected(egzotykaButton);
                    czyEgzotyka = true;
                }
                else{
                    this.setButtonSelected(morzeButton);
                    czyMorze = true;
                }
            }
        }
    }

    private void setButtonSelected(ImageButton button){
        button.setSelected(true);
        button.setColorFilter(color);
    }
}