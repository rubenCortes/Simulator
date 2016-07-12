package bennucybercafe.com.ve.simulator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import layout.Principal;

public class MainActivity extends AppCompatActivity
        implements Principal.OnFragmentInteractionListener {

    private Fragment fragmentoPrincipal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String primerArgumento = "Primer argumento de fragmento";
        String segundoArgumento = "Segundo argumento de fragmento";

        fragmentoPrincipal = Principal.newInstance(primerArgumento,segundoArgumento);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction();

        transaccion.replace(R.id.cuerpo_fragmento, fragmentoPrincipal);

        transaccion.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(View vista) {
       // Button boton = (Button) vista;
        Toast.makeText(MainActivity.this, "Fue presionado el boton: " + ((Button) vista).getText() , Toast.LENGTH_LONG).show();

    }
}
