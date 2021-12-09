package sv.edu.usam.api_bomberos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText email, contraseña;


    String str_email,str_password;
    String url = "https://apibomberos.000webhostapp.com/datos/usuario.php";
    //String url = "http://login.corporacionefransac.com/login.php";
    //String URL = "http://192.168.0.7/USAM_API/api/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.edtmail);
        contraseña = findViewById(R.id.edtnombre);
    }

    public void Login(View view) {

        if(email.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(contraseña.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{


            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Por favor espera...");

            progressDialog.show();

            str_email = email.getText().toString().trim();
            str_password = contraseña.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();



                    if (!response.equalsIgnoreCase("{\"mensaje\":\"error\"}")) {
                        JSONObject respuestaObj = new JSONObject();
                        try {
                            respuestaObj = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        email.setText("");
                        contraseña.setText("");
                        String nombre = "";
                        try {
                            nombre = respuestaObj.getString("nombre");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        startActivity(new Intent(getApplicationContext(), Inicio.class));
                        Toast.makeText(MainActivity.this, "Hola "+nombre, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("correo",str_email);
                    params.put("clave",str_password);
                    params.put("accion","login");
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);
        }
    }

    public void moveToRegistration(View view) {
        startActivity(new Intent(getApplicationContext(), RegistroSesion.class));
        finish();
    }
}