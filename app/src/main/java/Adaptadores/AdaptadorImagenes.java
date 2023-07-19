package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview_con_cardview_items.R;

import java.util.List;

import Modelos.Telefonos;

public class AdaptadorImagenes extends RecyclerView.Adapter<AdaptadorImagenes.ImageViewHolder> {

    private Context Ctx;
    private List<String> lstImages;

    public AdaptadorImagenes(Context mCtx, List<String> imagenes) {
        this.lstImages = imagenes;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.laylistimage, null);
        return new AdaptadorImagenes.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        String imagenes = lstImages.get(position);

        Glide.with(Ctx)
                .load(imagenes)
                .into(holder.imagethumbnail);
    }

    @Override
    public int getItemCount() {return lstImages.size();}


    class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imagethumbnail;
        CardView cardimages;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imagethumbnail = itemView.findViewById(R.id.imgthumbnail);
            cardimages = itemView.findViewById(R.id.listImage);
        }
    }
}
