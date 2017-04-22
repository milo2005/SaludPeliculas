package unicauca.movil.saludpeliculas;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import unicauca.movil.saludpeliculas.models.Pelicula;
import unicauca.movil.saludpeliculas.util.Data;

public class PeliculaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        int pos = getIntent().getExtras().getInt("pos");
        Pelicula p = Data.data.get(pos);

        ImageView img = (ImageView) findViewById(R.id.img);
        TextView titulo = (TextView) findViewById(R.id.titulo);
        TextView descripcion = (TextView) findViewById(R.id.descripcion);

        titulo.setText(p.getNombre());
        descripcion.setText(p.getDescripcion());
        Picasso.with(this)
                .load(Uri.parse(p.getImagen()))
                .into(img);
    }
}
