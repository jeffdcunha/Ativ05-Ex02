package com.fatec.zl.ativ05_ex02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 *@author:Jefferson Dantas da Cunha
 *@RA: 1110482323044
 */

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private RadioButton rbBytes;
    private RadioButton rbKB;
    private RadioButton rbMB;
    private RadioButton rbGB;
    private RadioButton rbTB;
    private Button btnConverter;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValor = findViewById(R.id.etValor);
        rbBytes = findViewById(R.id.rbBytes);
        rbKB = findViewById(R.id.rbKB);
        rbMB = findViewById(R.id.rbMB);
        rbGB = findViewById(R.id.rbGB);
        rbTB = findViewById(R.id.rbTB);
        btnConverter = findViewById(R.id.btnConverter);
        tvRes = findViewById(R.id.tvResultado);

        btnConverter.setOnClickListener(op -> converter());
    }

    protected void converter(){
        StringBuffer buffer = new StringBuffer();
        double valor = Double.parseDouble(etValor.getText().toString());
        double resultado;
        if(rbBytes.isChecked()){
            resultado = valor / 8;
            buffer.append(resultado + " bytes");
        }else if(rbKB.isChecked()){
            resultado = valor / 8 / 1024;
            buffer.append(resultado + " Kb");
        }
        else if(rbMB.isChecked()){
            resultado = valor / 8 / 1024 / 1024;
            buffer.append(resultado + " Mb");
        }
        else if(rbGB.isChecked()){
            resultado = valor / 8 / 1024 / 1024 / 1024;
            buffer.append(resultado + " GB");
        }
        else if(rbTB.isChecked()){
            resultado = valor / 8 / 1024 / 1024 / 1024 / 1024;
            buffer.append(resultado + " TB");
        }
        tvRes.setText(buffer.toString());
    }
}