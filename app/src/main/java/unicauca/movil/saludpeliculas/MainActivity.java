package unicauca.movil.saludpeliculas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.saludpeliculas.adapters.PeliculaAdapter;
import unicauca.movil.saludpeliculas.models.Pelicula;
import unicauca.movil.saludpeliculas.util.Data;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    PeliculaAdapter adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        Data.data = new ArrayList<>();
        adapter = new PeliculaAdapter(getLayoutInflater(), Data.data);
        list.setAdapter(adapter);

        loadPeliculas();
    }

    public void loadPeliculas(){
        Pelicula p1 = new Pelicula();
        p1.setNombre("Pelicula 1");
        p1.setDescripcion("La mejor pelicula, 1");
        p1.setDuracion(120);
        p1.setFechaEstreno("21 de Abril");
        p1.setImagen("http://www.deculture.es/wp-content/uploads/2016/07/liga-de-la-justicia-grupo-completo-e1469551868773.jpg");

        Pelicula p2 = new Pelicula();
        p2.setNombre("Pelicula 2");
        p2.setDescripcion("La mejor pelicula, 2");
        p2.setDuracion(140);
        p2.setFechaEstreno("22 de Abril");
        p2.setImagen("http://www.oconowocc.com/wp-content/uploads/2016/10/Guardianes-de-la-Galaxia-2-Nebula-tendr%C3%A1-un-papel-m%C3%A1s-notable.jpg");

        Pelicula p3 = new Pelicula();
        p3.setNombre("Pelicula 3");
        p3.setDescripcion("La mejor pelicula, 3");
        p3.setDuracion(110);
        p3.setFechaEstreno("23 de Abril");
        p3.setImagen("http://qiibo.qiibo.netdna-cdn.com/wp-content/uploads/2017/03/Pennywise-It-traje.jpg");

        Data.data.add(p1);
        Data.data.add(p2);
        Data.data.add(p3);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, PeliculaActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
        // finish();
    }
}
