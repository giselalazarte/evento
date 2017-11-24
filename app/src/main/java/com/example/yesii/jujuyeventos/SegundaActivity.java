package com.example.yesii.jujuyeventos;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.app.FragmentTransaction;

import android.widget.EditText;
import android.widget.Toast;

import com.example.yesii.jujuyeventos.interfaces.IComunicateFragment;


public class SegundaActivity extends AppCompatActivity  implements ProximosFragment.OnFragmentInteractionListener, DetalleFragment.OnFragmentInteractionListener, IComunicateFragment{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    IComunicateFragment interfaceComunicateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());



        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.containerId);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        if (savedInstanceState == null) {
            ProximosFragment f1= new ProximosFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragm, f1)
                    .addToBackStack(null)
                    .commit();

        }
//        FragmentManager manager = getSupportFragmentManager();
//        Fragment fragment = manager.findFragmentById(R.id.fragm);
//
//        if (fragment == null) {
//            fragment = new DetalleFragment();
//        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nosotros:

                break;

            case R.id.contactar:
                Toast.makeText(getApplicationContext(),"Para contactarnos dirigirse a...",Toast.LENGTH_LONG).show();
                break;

            case R.id.salir:
                finish();
                break;
        }        return super.onOptionsItemSelected(item);
    }

    @Override
    public void enviarEvento(Evento evento) {
//        System.out.println("HOLA");
//        DetalleFragment detalle = new DetalleFragment();
//        Bundle bundleEnvio = new Bundle();
//        bundleEnvio.putSerializable("objeto",evento);
//        detalle.setArguments(bundleEnvio);
////        this.getSupportFragmentManager().beginTransaction().replace(R.id.containerId,detalle).commit();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.containerId, detalle)
//                .addToBackStack(null)
//                .commit();
        Intent intent = new Intent(this, DetalleActivity.class);
        intent.putExtra("titulo", evento.getTitulo());
        intent.putExtra("lugar1", evento.getLugar1());
        intent.putExtra("lugar2", evento.getLugar2());
        intent.putExtra("fecha", evento.getFecha());
        intent.putExtra("hora1", evento.getHora1());
        intent.putExtra("hora2", evento.getHora2());
        intent.putExtra("detalle", evento.getDetalle());
        intent.putExtra("precio1", evento.getPrecio1());
        intent.putExtra("precio2", evento.getPrecio2());
        intent.putExtra("categoria", evento.getCategoria());
        intent.putExtra("videoView", evento.getVideoView());
//        intent.putExtra("eventoBdl", bundleEnvio); // No se puede enviar el Bundle porque Evento posee una imagen y no es serializable.
        startActivity(intent);
    }




    @Override
    public void onFragmentInteraction(Uri uri) {

    }





    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ProximosFragment proximosFragment= new ProximosFragment();
                    return proximosFragment;
                case 1:
                    CategoriasFragment categoriasFragment=new CategoriasFragment();

                    return categoriasFragment;
            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "EVENTOS PROXIMOS";
                case 1:
                    return "CATEGORIAS";
            }
            return null;
        }


    }
}
