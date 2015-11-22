package com.example.madjerbo.comernarua.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madjerbo.comernarua.R;
import com.example.madjerbo.comernarua.helpers.ItemListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madjerbo on 11/15/15.
 */

public class AdapterListView extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ItemListView> itens;
    public AdapterListView(Context context, ArrayList<ItemListView> itens) {
        //Itens do listview
        this.itens = itens;
        // Objeto responsável por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }
    public int getCount() {
        return itens.size();
    }
    public ItemListView getItem(int position) {
        return itens.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.food_truck_item_list, null);
            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ItemSuporte();
            itemHolder.itemTitle = ((TextView) view.findViewById(R.id.itemTitle));
            itemHolder.itemDesc = ((TextView) view.findViewById(R.id.itemDesc));
            itemHolder.imgIcon = ((ImageView) view.findViewById(R.id.imagemview));
            itemHolder.imgLegenda = ((ImageView) view.findViewById(R.id.legenda));
             //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (ItemSuporte) view.getTag();
        }
        //pega os dados da lista
        // e define os valores nos itens.
        ItemListView item = itens.get(position);
        itemHolder.itemTitle.setText(item.getTitle());
        itemHolder.imgIcon.setImageResource(item.getIconeRid());
        itemHolder.itemDesc.setText(item.getDesc());
        if (item.getOpen()) {
            itemHolder.imgLegenda.setImageResource(R.drawable.open);
        } else {
            itemHolder.imgLegenda.setImageResource(R.drawable.close);
        }

        //retorna a view com as informações
        return view;
    }
    /** * Classe de suporte para os itens do layout. */
    private class ItemSuporte {
        ImageView imgIcon;
        TextView itemDesc;
        TextView itemTitle;
        ImageView imgLegenda;
    }
}
