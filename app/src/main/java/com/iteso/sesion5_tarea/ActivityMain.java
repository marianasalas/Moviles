package com.iteso.sesion5_tarea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {


    Spinner escolaridad;
    AutoCompleteTextView textView;
    EditText name, phone;
    String  strGenero;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    CheckBox deporte;
    RadioButton mainButton1, mainButton2;
    Alumno alumno;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.activity_main_libro);
        String[] book = getResources().getStringArray(R.array.Libros);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,book);
        textView.setAdapter(adap);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        mainButton1= findViewById(R.id.activity_main_button1);
        mainButton2= findViewById(R.id.activity_main_button2);
        escolaridad =findViewById(R.id.escolaridad);
        deporte = findViewById(R.id.activity_main_check);

    }

    public void onRadioButtonClicked (View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.activity_main_button1:
                if (checked)
                    strGenero = "femenino";
                break;

            case R.id.activity_main_button2:
                if (checked)
                    strGenero = "masculino";
                break;
        }
    }

    public void onCheckBoxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()){
            case R.id.activity_main_check:
                if(checked)
                    break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.save:
                Guardar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Guardar(){
        alumno = new Alumno(name.getText().toString(), phone.getText().toString(), escolaridad.getSelectedItem().toString(),
                strGenero, textView.getText().toString(), deporte.isChecked());
        Toast.makeText(getApplicationContext(), alumno.toString(), Toast.LENGTH_LONG).show();
        Limpiar();
    }
    public void Limpiar(){
        name.getText().clear();
        phone.getText().clear();
        textView.getText().clear();
        escolaridad.setSelection(0);
        deporte.setChecked(false);
        mainButton1.setChecked(false);
        mainButton2.setChecked(false);
    }

    public void onLimpiarClicked(View view){
        onCreateDialog();
    }

    public void onCreateDialog(){
        builder =new AlertDialog.Builder(ActivityMain.this);
        builder.setMessage(R.string.limpiar_dialog).setCancelable(true)
                .setPositiveButton(R.string.Aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Limpiar();
                    }
                })
                .setNegativeButton(R.string.Cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        dialog = builder.create();
        dialog.show();
    }

}

