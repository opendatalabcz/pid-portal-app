package cvut.fit.pidmobapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.databinding.FragmentFavouriteRoutesBinding
import cvut.fit.pidmobapp.domain.viewmodel.MapsSharedViewModel
import cvut.fit.pidmobapp.presentation.adapter.TripAdapter
import cvut.fit.pidmobapp.presentation.interfaces.OnTripSelectListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavouriteTripsFragment: DialogFragment(), OnTripSelectListener {

    private lateinit var binding: FragmentFavouriteRoutesBinding
    private val viewModelMaps: MapsSharedViewModel by sharedViewModel()
    private var tripAdapter = TripAdapter(this)
    private lateinit var routeRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteRoutesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        routeRecyclerView = binding.routesRv
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        routeRecyclerView.layoutManager = llm
        routeRecyclerView.adapter = tripAdapter

        viewModelMaps.getFavouriteTrips()
        viewModelMaps.liveDataFavouriteTrips.observe(viewLifecycleOwner, {
            tripAdapter.setTrips(it)
        })
    }

    override fun onTripSelect(trip: Trip) {
        viewModelMaps.onTripSelect(trip)
        dismiss()
    }
}