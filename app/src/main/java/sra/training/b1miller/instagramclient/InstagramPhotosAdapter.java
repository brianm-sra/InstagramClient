package sra.training.b1miller.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by b1.miller on 12/6/2015.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {

    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        InstagramPhoto photo = getItem(position);
        // Check if we are using a recycled view, if not we need to inflate
        if (convertView == null) {
            // create a new view from template
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);

        }
        // Lookup the views for populating the data (image, caption)
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        TextView tvNumLikes = (TextView) convertView.findViewById(R.id.tvNumLikes);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        String numLikesStr = getContext().getResources().getString(R.string.likes);

        // Insert the model data into each of the view items
        tvUsername.setText(photo.getUsername());
        tvCaption.setText(photo.getCaption());
        tvNumLikes.setText(photo.getLikesCount() + numLikesStr);
        // Clear out the ImageView
        ivPhoto.setImageResource(0);
        // Insert the image using Picasso
        Picasso.with(getContext()).load(photo.getImageUrl()).into(ivPhoto);

        // Return the created item as a view
        return convertView;
    }
}
