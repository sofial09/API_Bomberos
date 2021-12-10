package sv.edu.usam.api_bomberos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistroSesion extends AppCompatActivity {

    /*
    EditText txtName,txtEmail,pass;
    Button btn_insert;*/
    EditText nombre,email, clave, telefono;
    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_sesion);

        nombre = findViewById(R.id.edtnombre);
        email = findViewById(R.id.edtmail);
        clave = findViewById(R.id.edtclave);
        telefono = findViewById(R.id.edtcel);
        btn_insert = findViewById(R.id.btn_register);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {

        final String name = nombre.getText().toString().trim();
        final String mail = email.getText().toString().trim();
        final String pass = clave.getText().toString().trim();
        final String tel = telefono.getText().toString().trim();
        final String type = "2";


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(name.isEmpty()){
            nombre.setError("complete los campos");
            return;
        }

        else if(mail.isEmpty()){
            email.setError("complete los campos");
            return;
        }

        else if(pass.isEmpty()){
            clave.setError("complete los campos");
            return;
        }

        else if(tel.isEmpty()){
            telefono.setError("complete los campos");
            return;
        }

        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://apibomberos.000webhostapp.com/datos/usuario.php?accion=insertar",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Datos insertados")){

                                Toast.makeText(RegistroSesion.this, "Datos insertados", Toast.LENGTH_SHORT).show();

                                progressDialog.dismiss();

                                Intent intent=new Intent(RegistroSesion.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(RegistroSesion.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Toast.makeText(RegistroSesion.this, "No se puede insertar", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegistroSesion.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();
                    params.put("nombre", name);
                    params.put("correo", mail);
                    params.put("clave", pass);
                    params.put("telefono", tel);
                    params.put("tipo", type);
                    /*
                        https://apibomberos.000webhostapp.com/datos/
                        https://apibomberos.000webhostapp.com/datos/usuario.php?accion=login&correo=alvaro@alvaro.com&clave=1234
                    */
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(RegistroSesion.this);
            requestQueue.add(request);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public  void  login(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}