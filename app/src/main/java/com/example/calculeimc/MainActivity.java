package com.example.calculeimc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText Poids,Taille,Age;
    TextView Classe_de_poids,Poid_ideal,IMC_ideal;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Poids=(EditText) findViewById(R.id.Poids);
        Taille=(EditText) findViewById(R.id.Taille);
        Age=(EditText) findViewById(R.id.Age);
        Classe_de_poids=(TextView)findViewById(R.id.Classe_de_poids);
        Poid_ideal=(android.widget.TextView)findViewById(R.id.Poids_ideal);
        IMC_ideal=(TextView)findViewById(R.id.IMC_ideal);
        button=(Button)findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String S1,S2;
                String s_P=Poids.getText().toString();
                Double v_P=Double.parseDouble(s_P);
                String s_T=Taille.getText().toString();
                Double v_T=Double.parseDouble(s_T);
                String s_A=Age.getText().toString();
                Double v_A=Double.parseDouble(s_A);
                Double PI =(v_T -100+(v_A/10))*0.9;
                Double IMC =(v_P/v_T);

                if (IMC < 18.5){
                    S1="État de maigreur";
                }
                else if (18.5 <=IMC && IMC< 24.9 ){
                    S1="Poids normal ";
                }
                else if (25.0 <=IMC && IMC < 30 ){
                    S1="Surpoids ";
                }
                else if (30.0 <=IMC && IMC < 35 ){
                    S1="Obésité modérée";
                }
                else if (35.0 <=IMC && IMC < 40 ){
                    S1="Obésité sévère";
                }
                else if (IMC >= 40){
                    S1="Obésité morbide";
                }
                else {
                    S1="Error!!";
                }
                if(19 <= v_A && v_A<= 24 ){
                    S2="[19 - 24]";
                }
                else if(25 <= v_A && v_A<= 34 ){
                    S2="[20 - 25]";
                }
                else if(35 <= v_A && v_A<= 44 ){
                    S2="[21 - 26]";
                }
                else if(45 <= v_A && v_A<= 54 ){
                    S2="[22 - 27]";
                }
                else if(55 <= v_A && v_A<= 64 ){
                    S2="[ 23 - 28 ]";
                }
                else{
                    S2="Error!!";
                }
                Classe_de_poids.setText(S1);
                Poid_ideal.setText(S2);
                IMC_ideal.setText(PI.toString());

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}