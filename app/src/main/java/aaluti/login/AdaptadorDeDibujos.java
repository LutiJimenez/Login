package aaluti.login;

/**
 * Created by xIS13864 on 05/08/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class AdaptadorDeDibujos extends BaseAdapter{
    private Context context;

    public AdaptadorDeDibujos(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return dibujos.ITEMS.length;
    }

    @Override
    public dibujos getItem(int position) {
        return dibujos.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenDibujo = (ImageView) view.findViewById(R.id.imagen_dibujo);
        TextView nombreDibujo = (TextView) view.findViewById(R.id.nombre_dibujo);

        final dibujos item = getItem(position);
        imagenDibujo.setImageResource(item.getIdDrawable());
        nombreDibujo.setText(item.getNombre());

        return view;
    }
}
