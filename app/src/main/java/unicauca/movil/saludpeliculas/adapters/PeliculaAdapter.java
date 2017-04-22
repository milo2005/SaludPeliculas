package unicauca.movil.saludpeliculas.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import unicauca.movil.saludpeliculas.R;
import unicauca.movil.saludpeliculas.models.Pelicula;

public class PeliculaAdapter extends BaseAdapter{

    LayoutInflater inflater;
    List<Pelicula> data;

    public PeliculaAdapter(LayoutInflater inflater, List<Pelicula> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Recuperamos Template
        View v = convertView;
        if(v == null)
            v = inflater.inflate(R.layout.template_pelicula, parent, false);

        //Objeto en la posicion
        Pelicula p = data.get(position);

        //Recuperamos los Views del template
        ImageView img = (ImageView) v.findViewById(R.id.img);
        TextView titulo = (TextView) v.findViewById(R.id.titulo);
        TextView duracion = (TextView) v.findViewById(R.id.duracion);
        TextView estreno = (TextView) v.findViewById(R.id.estreno);

        //Asignamos información del objeto a los Views
        titulo.setText(p.getNombre());
        estreno.setText(p.getFechaEstreno());
        duracion.setText(""+p.getDuracion());

        Picasso.with(img.getContext())
                .load(Uri.parse(p.getImagen()))
                .into(img);

        return v;
    }
}
