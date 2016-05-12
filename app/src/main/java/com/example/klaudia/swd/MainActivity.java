package com.example.klaudia.swd;

        import android.app.ActionBar;
        import android.app.Activity;
        import android.app.DatePickerDialog;
        import android.app.Dialog;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.DatePicker;
        import android.widget.ImageButton;
        import android.widget.LinearLayout;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int day;
    private int month;
    private int year;
    private TextView editText;
    private boolean czyMorze = false;
    private boolean czyGory = false;
    private boolean czyJezioro = false;
    private boolean czyMiasto = false;
    private boolean czyOpalanie = false;
    private boolean czyZwiedzanie = false;
    private boolean czySport = false;
    private ImageButton morzeButton;
    private ImageButton goryButton;
    private ImageButton jezioroButton;
    private ImageButton miastoButton;
    private ImageButton opalanieButton;
    private ImageButton zwiedzanieButton;
    private ImageButton sportButton;

    private LinearLayout zwiedzanieLayout;
    private LinearLayout sportLayout;

    private Spinner cenySpinner;
    private final int color = Color.argb(100, 51, 153, 255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        ImageButton button = (ImageButton) findViewById(R.id.imageButton1);
        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        editText = (TextView) findViewById(R.id.editText);
        morzeButton = (ImageButton) findViewById(R.id.morze);
        goryButton = (ImageButton) findViewById(R.id.gory);
        jezioroButton = (ImageButton) findViewById(R.id.jezioro);
        miastoButton = (ImageButton) findViewById(R.id.miasto);
        opalanieButton = (ImageButton) findViewById(R.id.opalanie);
        zwiedzanieButton = (ImageButton) findViewById(R.id.zwiedzanie);
        sportButton = (ImageButton) findViewById(R.id.sport);
        zwiedzanieLayout = (LinearLayout) findViewById(R.id.zwiedzanieLayout);
        sportLayout = (LinearLayout) findViewById(R.id.sportLayout);
        cenySpinner = (Spinner) findViewById(R.id.ceny);
        button.setOnClickListener(this);
        morzeButton.setOnClickListener(this);
        goryButton.setOnClickListener(this);
        jezioroButton.setOnClickListener(this);
        miastoButton.setOnClickListener(this);
        opalanieButton.setOnClickListener(this);
        zwiedzanieButton.setOnClickListener(this);
        sportButton.setOnClickListener(this);

        this.setFilters();
        this.createList();
        //button.setColorFilter(Color.argb(100, 51, 153, 255));
    }

    private void createList() {
        List<String> cenyL = new ArrayList<>();
        cenyL.add("Do 1000 zł");
        cenyL.add("Od 1000 do 3000 zł");
        cenyL.add("Od 3000 zł do 5000 zł");
        cenyL.add("Od 5000 zł do 8000 zł");
        cenyL.add("Powyżej 8000 zł");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cenyL);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cenySpinner.setAdapter(adapter);

    }

    private void setFilters(){
        morzeButton.setColorFilter(color);
        goryButton.setColorFilter(color);
        jezioroButton.setColorFilter(color);
        miastoButton.setColorFilter(color);
        opalanieButton.setColorFilter(color);
        zwiedzanieButton.setColorFilter(color);
        sportButton.setColorFilter(color);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editText:
                showDialog(0);
                break;
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
            case R.id.jezioro:
                if(czyJezioro){
                    jezioroButton.clearColorFilter();
                    czyJezioro = false;
                }
                else{
                    jezioroButton.setColorFilter(color);
                    czyJezioro = true;
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
                    zwiedzanieLayout.setVisibility(View.GONE);
                }
                else{
                    zwiedzanieButton.setColorFilter(color);
                    czyZwiedzanie = true;
                    zwiedzanieLayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.sport:
                if(czySport){
                    sportButton.clearColorFilter();
                    czySport = false;
                    sportLayout.setVisibility(View.GONE);
                }
                else{
                    sportButton.setColorFilter(color);
                    czySport = true;
                    sportLayout.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id){
        return new DatePickerDialog(this, dateSetListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            editText.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };

    public void wyznacz(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        MainActivity.this.startActivity(intent);
    }
}