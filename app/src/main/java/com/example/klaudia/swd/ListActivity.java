package com.example.klaudia.swd;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public class ListActivity extends AppCompatActivity implements View.OnClickListener{

    static List<Option> options = new ArrayList<>();
    static OptionAdapter adapter;

    public OptionAdapter getAdapter() {
        return adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        Button dodajOpcje = (Button) findViewById(R.id.dodajOpcje);
        dodajOpcje.setOnClickListener(this);
        final ListView lista = (ListView) findViewById(R.id.lista);
        //ArrayList<Option> list = new ArrayList<>();

        Log.d("ListActivity" ,"czy sa opcje w onCreate" +options);

            adapter = new OptionAdapter(this, options);
            lista.setAdapter(adapter);
            lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    return onLongClick(view, position, id);
                }
            });
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onClick(view, position, id);
                }
            });

    }

    private void onClick(View view, int position, long id) {
        Option option = options.get(position);
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        intent.putExtra("editable", option);
        intent.putExtra("pos", position);
        ListActivity.this.startActivity(intent);
    }

    private boolean onLongClick(View view, final int position, long id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.message).setTitle("Usunąć?");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                options.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        //Option option = options.get(position);
        return true;
    }
    public void wyznacz(View view){

        lrw2 l = new lrw2();
        List<List<Integer>> choices = new ArrayList<>();
        Log.d("ListActivity","options size"+options.size());
        for(Option o: options){
            choices.add(o.convertOptionToNumbers(o));
        }
        for (List<Integer> choice : choices){
            Log.d("ListActivity","co zawiera wybor"+choice);
        }

        for(List<Integer> choice : choices) {
           // System.out.println("Wybor: ");
            //  choice.
            // choice.forEach(c -> System.out.print(c + " "));
           // System.out.println();
            String o="";
            Log.d("ListActivity","Wynik: ");
            for (List<Boolean> lista : l.policz(choice)) {
                for (Boolean b : lista) {
                    o= o+"  "+  b.toString();
                }
            }
            Log.d("ListActivity"," "+o);
        }

    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        ListActivity.this.startActivity(intent);
    }
}
