package com.example.madjerbo.comernarua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.madjerbo.comernarua.Adapters.AdapterListView;
import com.example.madjerbo.comernarua.helpers.ItemListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.foodTruckList);
        String[] titles = new String[] {
                "El chancho",
                "Spot Churros",
                "Black Pizza",
                "Dulê",
                "Eat on the Streets",
                "General Chicken",
                "My waffel"};

        boolean[] aberto = new boolean[]{
                true,
                true,
                true,
                true,
                false,
                false,
                false
        };
        String[] descricao = new String[] {
                "CHANCHO CREW, Baixa Gastronomia, Cozinha com Amor!! Comida de Rua , Fortaleza- Ce \uD83D\uDD2A\uD83D\uDD2A \uD83D\uDC16 85 99794-8310",
                "\uD83D\uDCCDR. Frederico Borges, 293 \uD83D\uDCCDAv. Des Moreira, 1011 \uD83D\uDCCDFood Carts Itinerantes ✉️ spotchurros@hotmail.com www.spotchurros.com.br",
                "\uD83D\uDE9AFood Truck ✉️blackpizzafoodtruck@gmail.com \uD83D\uDCF1(85) 99937.8519 \uD83C\uDF0E Fortaleza-CE",
                "Dulê Churros \uD83D\uDD38 Dulê Churros - Food Cart Itinerante \uD83D\uDD38 Fortaleza - CE \uD83D\uDCDE (85) 997333787 \uD83D\uDCE8 dulechurros@gmail.com www.facebook.com/dulechurros",
                "EAT On The Streets Firetruck Cozinha Contemporânea Itinerante Burgers Addicted #foodonfire #fireontheroads #truckON! Contato para eventos: 85 991735619 wpp",
                "General Chicken Sim, nós temos boa comida! \uD83D\uDE9A\uD83D\uDC13\uD83D\uDD2A\uD83C\uDF57\uD83C\uDF54\uD83C\uDDE7\uD83C\uDDF7 \uD83D\uDCE9 generalchickenfoodtruck@gmail.com \uD83D\uDCDE (85) 99629-8995 Fortaleza-CE",
                "My waffle \"A vida é curta demais para esperar pela sobremesa\" eat ❤ smile ❤ repeat Contato: mywafflebrasil@hotmail.com"
        };

        final ArrayList<ItemListView> list = new ArrayList<ItemListView>();
        for (int i = 0; i < titles.length; ++i) {
            list.add(new ItemListView(titles[i], 1, descricao[i], aberto[i]));
        }
        final AdapterListView adapter = new AdapterListView(this, list);
        listView.setAdapter(adapter);

    }
}
