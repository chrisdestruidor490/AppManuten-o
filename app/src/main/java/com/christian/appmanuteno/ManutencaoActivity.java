package com.christian.appmanuteno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


public class ManutencaoActivity extends AppCompatActivity {
    private EditText etNome, etDefeito, etValor;
    private CheckBox cbFinalizado;
    private RadioButton rbServiço, rbOrçamento;
    private Button btnFinalizar;

    private Spinner spinnerCategorias;

    private ArrayAdapter adapter;
    private String[] listaCategorias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencao);
        etNome = (EditText) findViewById(R.id.etNome);
        etDefeito = (EditText) findViewById(R.id.etDefeito);
        etValor = (EditText) findViewById(R.id.etValor);

        cbFinalizado = (CheckBox) findViewById(R.id.cbFinalizado);

        rbServiço = (RadioButton) findViewById(R.id.rbServiço);
        rbOrçamento = (RadioButton) findViewById(R.id.rbOrçamento);

        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);


        spinnerCategorias = (Spinner) findViewById(R.id.spCategoria);

        spinnerCategorias.setEnabled(false);

        listaCategorias = new String[]{
                getResources().getString(R.string.selecioneEstado) };

        adapter = new ArrayAdapter( this ,
                android.R.layout.simple_list_item_1, listaCategorias);
        spinnerCategorias.setAdapter(adapter);


        spinnerCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                carregarCategorias();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void carregarCategorias(){
        String selecione = getResources().getString(R.string.selecione);
        String selecioneEstado = getResources().getString(R.string.selecioneEstado);




        int posicao = spinnerCategorias.getSelectedItemPosition();


        }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_manutencao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_sair) {
            finish();
        }

        if (item.getItemId() == R.id.menu_limpar) {
            limpar();
        }

        return super.onOptionsItemSelected(item);
    }

    private void limpar() {
        etNome.setText("");
        etDefeito.setText("");
        etValor.setText("");


        cbFinalizado.setChecked(false);
        rbServiço.setChecked(false);
        rbOrçamento.setChecked(false);
        spinnerCategorias.setSelection(0);
    }
    }

