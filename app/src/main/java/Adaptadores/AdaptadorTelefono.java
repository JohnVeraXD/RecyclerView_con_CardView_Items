package Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview_con_cardview_items.MainActivity2ListaImagenes;
import com.example.recyclerview_con_cardview_items.R;

import java.util.List;

import Modelos.Telefonos;

public class AdaptadorTelefono extends RecyclerView.Adapter<AdaptadorTelefono.TelefonoViewHolder> {

    private Context Ctx;
    private List<Telefonos> lstTelefonos;

    public AdaptadorTelefono(Context mCtx, List<Telefonos> telefonos) {
        this.lstTelefonos = telefonos;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public AdaptadorTelefono.TelefonoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.layitemview, null);
        return new TelefonoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorTelefono.TelefonoViewHolder holder, int position) {
        Telefonos telefonos = lstTelefonos.get(position);
        holder.texttitle.setText(telefonos.getTitle());
        holder.textPrice.setText(telefonos.getPrice());
        holder.textRating.setText(telefonos.getRating());
        holder.textDescription.setText(telefonos.getDescription());

        holder.cardimages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putStringArray("Images", telefonos.getImages());

                Intent intent = new Intent(Ctx, MainActivity2ListaImagenes.class);
                intent.putExtras(b);
                Ctx.startActivity(intent);
            }
        });


        Glide.with(Ctx)
                .load(telefonos.getThumbnail())
                .into(holder.imagethumbnail);

    }

    @Override
    public int getItemCount() {
        return lstTelefonos.size();
    }

    class TelefonoViewHolder extends RecyclerView.ViewHolder {
        TextView texttitle, textPrice, textRating,textDescription;
        ImageView imagethumbnail;

        CardView cardimages;

        public TelefonoViewHolder(View itemView) {
            super(itemView);
            texttitle = itemView.findViewById(R.id.txttitle);
            textPrice = itemView.findViewById(R.id.txtPrice);
            textRating = itemView.findViewById(R.id.txtRating);
            textDescription = itemView.findViewById(R.id.txtdescription);
            imagethumbnail = itemView.findViewById(R.id.imgthumbnail);
            cardimages = itemView.findViewById(R.id.listImage);
        }
    }
}
