package cvut.fit.pidmobapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.model.dto.StopRouteNextTripTimeDto
import cvut.fit.pidmobapp.presentation.interfaces.OnRouteSelectListener

class RoutesAdapter(val onRouteSelectListener: OnRouteSelectListener) : RecyclerView.Adapter<RoutesAdapter.ViewHolder>() {

    private var routeNextTripTimeDto: List<StopRouteNextTripTimeDto>? = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setRoutes(routeNextTripTimeDto : List<StopRouteNextTripTimeDto>){
        this.routeNextTripTimeDto = routeNextTripTimeDto
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val routeNameTv : TextView = itemView.findViewById(R.id.route_name_tv)
        val nextInTv : TextView = itemView.findViewById(R.id.delay_min_tv)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = layoutPosition
            routeNextTripTimeDto?.get(position)
            if (position != RecyclerView.NO_POSITION) {
                routeNextTripTimeDto?.let {
                    onRouteSelectListener.onRouteSelect(routeNextTripTimeDto!![position].stop, routeNextTripTimeDto!![position].route)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.routes_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val routeNextArrive = routeNextTripTimeDto?.get(position)
        if (routeNextArrive != null) {
            holder.routeNameTv.text = routeNextArrive.route.shortName + ": " + routeNextArrive.route.longName
            holder.nextInTv.text = routeNextArrive.expectedArrival
        }
    }

    override fun getItemCount(): Int {
        return routeNextTripTimeDto?.size ?: 0
    }
}