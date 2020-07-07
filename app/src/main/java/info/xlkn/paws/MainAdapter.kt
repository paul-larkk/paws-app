package info.xlkn.paws

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_layout.view.*

class MainAdapter(val feed: Feed): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
      return feed.results.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowCell = layoutInflater.inflate(R.layout.image_layout, parent, false)
        return CustomViewHolder(rowCell)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val photo = feed.results.get(position)
        val mainImageView = holder.itemView.imageView_mainImage
        Picasso.get().load(photo.urls.full).into(mainImageView)

        val thumbnailImageView = holder.itemView.imageView_thumbnail
        Picasso.get().load(photo.urls.thumb).into(thumbnailImageView)

        holder.itemView.textview_profile_name.text = photo.user.name
        holder.itemView.textview_location.text = photo.user.location

        holder.results = photo
    }

}

class CustomViewHolder(val view: View, var results: Results? = null): RecyclerView.ViewHolder(view){

}