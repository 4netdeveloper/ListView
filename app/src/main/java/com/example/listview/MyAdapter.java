package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    List<String> names;

    public MyAdapter(Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    //es la cantidad de iteraciones que tiene q hacer la lista
    public int getCount() {
        return this.names.size();
    }

    @Override
    //devuelve un item de la posicion que se le da
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    //devuelve el ID de la posicion que se le da
    public long getItemId(int id) {
        return id;
    }

    @Override
    //convertView es cada una de las vistas q se van a dibujar
    //viewGroup es la ListView propiamente dicha
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if(convertView == null){
            //se infla la vista con el layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            holder.nameTextView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //traemos el valor actual dependiente de la posicion
        String currentName = names.get(position);

        //referenciamos el elemento a modificar y lo rellenamos
        holder.nameTextView.setText(currentName);

        //devolvemos la vista inflada y modificada con nuestros datos
        return convertView;
    }

    static class ViewHolder{
        private TextView nameTextView;
    }
}

