package cvut.fit.pidmobapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.presentation.interfaces.OnTripSelectListener

class TripAdapter(val onTripSelectListener: OnTripSelectListener): RecyclerView.Adapter<TripAdapter.ViewHolder>() {

    private var trips: List<Trip>? = emptyList()


    @SuppressLint("NotifyDataSetChanged")
    fun setTrips(trips : List<Trip>){
        this.trips = trips
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val trip_name_tv : TextView = itemView.findViewById(R.id.trip_name_tv)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = layoutPosition
            trips?.get(position)
            if (position != RecyclerView.NO_POSITION) {
                trips?.let {
                    onTripSelectListener.onTripSelect(trips!![position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trip_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trip = trips?.get(position)

        if (trip != null) {
            holder.trip_name_tv.text = "Route ID: "+trip.routeId + "Trip ID: " + trip.uid
        }
    }

    override fun getItemCount(): Int {
        return trips?.size ?: 0
    }
}