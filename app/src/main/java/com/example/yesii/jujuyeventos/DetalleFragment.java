package com.example.yesii.jujuyeventos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class DetalleFragment extends Fragment {
    TextView txtTitulo,txtLugar1,txtFecha,txtHora1,txtDetalle,txtPrecio1,txtLugar2,txtHora2,txtPrecio2;
    ImageView imageView;
    VideoView videoView;
    OnFragmentInteractionListener mListener;

    public static final String ARG_ITEM_ID = "item_id";
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String mParam1;
//    private String mParam2;


    public DetalleFragment() {
        // Required empty public constructor
    }

//    public static DetalleFragment newInstance(String param1, String param2) {
//        DetalleFragment fragment = new DetalleFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments().containsKey(ARG_ITEM_ID)) {
//            int index = Integer.valueOf(getArguments().getString(ARG_ITEM_ID));
//            evento=(Evento) PersonaContent.getPersonList().get(index);
//        }
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("GIIIIII");
        View view=inflater.inflate(R.layout.fragment_detalle, container, false);
        Bundle objetoEvent = getArguments();
        Evento evento;
        if (objetoEvent != null){
            evento=(Evento) objetoEvent.getSerializable("objeto");
            if("cine".equals(evento.getCategoria())) {
                View view1=inflater.inflate(R.layout.fragment_detallecine, container, false);
                view=view1;
                videoView = (VideoView) view.findViewById(R.id.videoView);
                txtLugar2 =(TextView) view.findViewById(R.id.lugar2Txt);
                txtHora2 =(TextView) view.findViewById(R.id.hora2Txt);
                txtPrecio2 =(TextView) view.findViewById(R.id.precio2Txt);
                txtLugar2.setText("LUGAR: " + evento.getLugar1());
                txtHora2.setText("HORA: " + evento.getHora1());
                txtPrecio2.setText("PRECIO: " + evento.getPrecio1());
                videoView.setVideoURI(evento.getVideoView());
                videoView.setMediaController(new MediaController(getContext()));
                videoView.start();
                videoView.requestFocus();
            }else {
                imageView = (ImageView) view.findViewById(R.id.imageViewImg);
                imageView.setImageDrawable(evento.getImage());
            }
            txtTitulo =(TextView) view.findViewById(R.id.tituloTxt);
            txtLugar1 =(TextView) view.findViewById(R.id.lugar1Txt);
            txtFecha =(TextView) view.findViewById(R.id.fechaTxt);
            txtHora1 =(TextView) view.findViewById(R.id.hora1Txt);
            txtDetalle =(TextView) view.findViewById(R.id.detalleTxt);
            txtPrecio1 =(TextView) view.findViewById(R.id.precio1Txt);
            txtTitulo.setText(evento.getTitulo());
            System.out.println("TITULO EN DETALLE: " + evento.getTitulo());
            System.out.println("TITULO EN DETALLE: " + txtTitulo.getText());
            txtLugar1.setText("LUGAR: " + evento.getLugar1());
//            txtFecha.setText("FECHA: " + evento.getFecha());
            txtHora1.setText("HORA: " + evento.getHora1());
            txtDetalle.setText(evento.getDetalle());
            txtPrecio1.setText("PRECIO: " + evento.getPrecio1());
        }
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface OnFragmentInteractionListenerIComunicateFragment {
    }

}
