package com.example.yesii.jujuyeventos;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gisela on 02/11/2017.
 */


public class AdapterProximo extends RecyclerView.Adapter<AdapterProximo.ProximosViewHolder> {

    ArrayList<Evento> eventoList;
    CustomFilter filter;
    ArrayList<Evento> filterList;
//    private View.OnClickListener listener;
    private final OnItemClickListener listener;


    public AdapterProximo(ArrayList<Evento> eventoList, OnItemClickListener listener) {
        this.eventoList = eventoList;
        filterList = eventoList;
        this.listener = listener;
    }

    @Override
    public ProximosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proximos, null, false);

        return new ProximosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProximosViewHolder holder, int position) {
        holder.bind(eventoList.get(position), listener);
//        holder.titulo.setText(eventoList.get(position).getTitulo());
//        holder.fecha.setText(eventoList.get(position).getFecha());
//        holder.detalle.setText(eventoList.get(position).getDetalle());
//        holder.image.setImageDrawable(eventoList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return eventoList.size();
    }

    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter();
        }
        return filter;

    }

//    public void setOnClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//
//    }

//    @Override
//    public void onClick(View v) {
//        if (listener != null) {
//            listener.onItemClick(v);
//        }
//    }

    public interface OnItemClickListener {
        void onItemClick(Evento item);
    }

    public class ProximosViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, fecha, detalle;
        ImageView image;

        public ProximosViewHolder(View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.tituloTxt);
            fecha = (TextView) itemView.findViewById(R.id.fechaTxt);
            detalle = (TextView) itemView.findViewById(R.id.detalleTxt);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }


        public void bind(final Evento evento, final OnItemClickListener listener) {
            titulo.setText(evento.getTitulo());
            fecha.setText(evento.getFecha());
            detalle.setText(evento.getDetalle());
            image.setImageDrawable(evento.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(evento);
                }
            });
        }
    }


    class CustomFilter extends Filter {
        public CustomFilter() {
            filterList = eventoList;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults resultado = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<Evento> filters = new ArrayList<Evento>();
                for (int i = 0; i < filterList.size(); i++) {
                    if ((filterList.get(i).getTitulo().toLowerCase().contains(constraint) ||
                            filterList.get(i).getTitulo().toUpperCase().contains(constraint)) ||
                            (filterList.get(i).getFecha().contains(constraint))) {
                        Evento e = new Evento(filterList.get(i).getTitulo(),
                                filterList.get(i).getLugar1(),
                                filterList.get(i).getFecha(),
                                filterList.get(i).getHora1(),
                                filterList.get(i).getDetalle(),
                                filterList.get(i).getPrecio1(),
                                filterList.get(i).getImage(),
                                filterList.get(i).getVideoView(),
                                filterList.get(i).getCategoria(),
                                filterList.get(i).getLugar2(),
                                filterList.get(i).getHora2(),
                                filterList.get(i).getPrecio2());
                        filters.add(e);


                    }

                }

                resultado.count = filters.size();
                resultado.values = filters;

            } else {
                resultado.count = filterList.size();
                resultado.values = filterList;
            }
            return resultado;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            eventoList = (ArrayList<Evento>) results.values;
            notifyDataSetChanged();


        }
    }
}
