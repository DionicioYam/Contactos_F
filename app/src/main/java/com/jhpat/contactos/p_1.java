package com.jhpat.contactos;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class p_1 extends AppCompatActivity {

    EditText u,c;
    ConexionSQLiteHelper conn;
    public static String x1=" ",x2=" ";



Button r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_1);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_usuarios", null, 1);

        u = findViewById(R.id.editText3);
        c = findViewById(R.id.editText4);
        r = findViewById(R.id.button2);



        r=findViewById(R.id.button2);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarSql();
            }
        });
    }













    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String [] parametros={u.getText().toString()};
        String [] campos={Utilidades.CAMPO_USUARIO,Utilidades.CAMPO_CONTRASEÑA};
        try{
            Cursor cursor=db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_USUARIO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            x1= cursor.getString(0);
            x2= cursor.getString(1);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();

        }

    }

    private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={u.getText().toString()};

        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+Utilidades.CAMPO_CONTRASEÑA+
                    " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_USUARIO+"=? ",parametros);

            cursor.moveToFirst();
            x2= cursor.getString(0);

            if(1>0){
                u.setText(cursor.getString(0));
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
        }

    }
}

