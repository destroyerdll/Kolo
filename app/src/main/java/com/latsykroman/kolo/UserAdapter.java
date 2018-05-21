package com.latsykroman.kolo;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Latsyk Roman on 05.04.2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<UserModel> list;
    public UserAdapter(List<UserModel> list) {
        this.list = list;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position) {
           UserModel user = list.get(position);
           holder.text_id.setText(position + "");
           holder.text_kilkist.setText(user.kilkist + "");
           holder.text_name.setText(user.name);;
           holder.text_client.setText(user.client);
           holder.text_author.setText(user.author);
           holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
               @Override
               public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                   menu.add(holder.getAdapterPosition(), 0, 0,  "Видалити");
               }
           });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView text_name, text_kilkist, text_id, text_client, text_author;
        public UserViewHolder(View itemView) {
            super(itemView);

            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_kilkist = (TextView) itemView.findViewById(R.id.text_kilkist);
            text_id = (TextView) itemView.findViewById(R.id.text_id);
            text_client = (TextView) itemView.findViewById(R.id.text_zamovnyk);
            text_author = (TextView) itemView.findViewById(R.id.text_author);

        }
    }
}
