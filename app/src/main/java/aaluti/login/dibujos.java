package aaluti.login;

/**
 * Created by xIS13864 on 05/08/2016.
 */
public class dibujos {
    private String nombre;
    private int idDrawable;

    public dibujos(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static dibujos[] ITEMS = {
            new dibujos("Batman ps", R.drawable.batman_app),
            new dibujos("Molino Café", R.drawable.ilustracion_cafe),
            new dibujos("DareDevil Óleo", R.drawable.daredevil),
            new dibujos("Porsche 911 GTS", R.drawable.porsche_911_gts),
            new dibujos("BMW Serie 6", R.drawable.bmw_serie6_cabrio_2015),
            new dibujos("Ford Mondeo", R.drawable.ford_mondeo),
            new dibujos("Volvo V60 Cross Country", R.drawable.volvo_v60_crosscountry),
            new dibujos("Jaguar XE", R.drawable.jaguar_xe),
            new dibujos("VW Golf R Variant", R.drawable.volkswagen_golf_r_variant_2015),
            new dibujos("Seat León ST Cupra", R.drawable.seat_leon_st_cupra),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static dibujos getItem(int id) {
        for (dibujos item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
