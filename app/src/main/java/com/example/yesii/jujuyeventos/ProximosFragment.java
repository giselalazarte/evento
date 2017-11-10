package com.example.yesii.jujuyeventos;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.yesii.jujuyeventos.interfaces.IComunicateFragment;

import java.util.ArrayList;
import java.util.List;



public class ProximosFragment extends Fragment {

    RecyclerView recyclerView;
    AdapterProximo adapterProximo;
    ArrayList<Evento> eventos;
    SearchView sv;

    Activity activity;
    IComunicateFragment interfaceComunicateFragment;
    SegundaActivity segundaActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_proximos, container, false);
        eventos = new ArrayList<>();
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getEventoList();

        adapterProximo= new AdapterProximo(eventos);
        recyclerView.setAdapter(adapterProximo);

        sv=(SearchView) view.findViewById(R.id.searchView);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                System.out.println("aqui comienzo");
                System.out.println(query);
                adapterProximo.getFilter().filter(query);
                return false;
            }

        });

        adapterProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interfaceComunicateFragment.enviarEvento(eventos.get(recyclerView.getChildAdapterPosition(v)));
            }
        });


        return view;

    }

    public void getEventoList(){

        eventos.add(new Evento(getString(R.string.event1_titulo),"Cine Teatro Alfa" , getString(R.string.event1_fecha),getString(R.string.event1_hora),getString(R.string.event1_detalle),"$45", getResources().getDrawable(R.drawable.cars3), Uri.parse("android.resource://"+getContext().getPackageName()+"/"+R.raw.cars), getString(R.string.event1_categoria), "Cine Anuar Shopping", " 14:00hs y 17hs", "$55"));
        eventos.add(new Evento(getString(R.string.event2_titulo),"Cine Teatro Alfa" , getString(R.string.event2_fecha),getString(R.string.event2_hora),getString(R.string.event2_detalle), "$45", getResources().getDrawable(R.drawable.condorito2),Uri.parse("android.resource://"+getContext().getPackageName()+"/"+R.raw.condor), getString(R.string.event2_categoria), "Cine Anuar Shopping", " 14:00hs y 17hs", "$55"));
        eventos.add(new Evento(getString(R.string.event3_titulo),getString(R.string.event3_lugar) , getString(R.string.event3_fecha),getString(R.string.event3_hora),getString(R.string.event3_detalle),getString(R.string.event3_precio), getResources().getDrawable(R.drawable.ninayo),null,getString(R.string.event3_categoria),null,null,null));
        eventos.add(new Evento(getString(R.string.event4_titulo),getString(R.string.event4_lugar) , getString(R.string.event4_fecha),getString(R.string.event4_hora),getString(R.string.event4_detalle),getString(R.string.event4_precio), getResources().getDrawable(R.drawable.festigaucho),null, getString(R.string.event4_categoria),null,null,null));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.activity= (Activity) context;
            interfaceComunicateFragment= (IComunicateFragment) this.activity;
        }
    }


    public AdapterProximo getAdapterProximo() {
        return adapterProximo;
    }

    public void setAdapterProximo(AdapterProximo adapterProximo) {
        this.adapterProximo = adapterProximo;
    }

    public interface OnFragmentInteractionListener {
    }
}
