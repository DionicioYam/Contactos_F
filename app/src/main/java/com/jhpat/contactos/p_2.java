package com.jhpat.contactos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class p_2 extends AppCompatActivity implements View.OnClickListener {
    EditText n,u,c,e;
    Button btn_r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_2);
        n=findViewById(R.id.p_c1);
        u=findViewById(R.id.p_c2);
        c=findViewById(R.id.p_c3);
        e=findViewById(R.id.p_c4);
        btn_r=findViewById(R.id.r);

        btn_r.setOnClickListener(this);
    }


    public void onClick(View view) {
        registrarUsuarios();
        //registrarUsuariosSql();
        Intent intent=new Intent(p_2.this,p_1.class);
        p_2.this.startActivity(intent);
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,n.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO,u.getText().toString());
        values.put(Utilidades.CAMPO_CONTRASEÑA,c.getText().toString());
        values.put(Utilidades.CAMPO_EDAD,e.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_USUARIO,values);

        Toast.makeText(getApplicationContext(),"Name Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }

}
