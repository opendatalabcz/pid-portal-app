package cvut.fit.pidmobapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.presentation.adapter.RoutesAdapter
import cvut.fit.pidmobapp.databinding.FragmentStopBinding
import cvut.fit.pidmobapp.presentation.interfaces.OnRouteSelectListener
import cvut.fit.pidmobapp.domain.viewmodel.MapsSharedViewModel
import cvut.fit.pidmobapp.config.Config
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class StopFragment : BaseFragment(), OnRouteSelectListener {

    private lateinit var binding: FragmentStopBinding
    private lateinit var recyclerView: RecyclerView
    private var routesAdapter = RoutesAdapter(this)
    override val bottomSheetState = BottomSheetBehavior.STATE_HALF_EXPANDED
    override val name = Config.STOP_FRAGMENT_NAME

    private val viewModelMaps: MapsSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStopBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.routeRv

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = llm
        recyclerView.adapter = routesAdapter

        viewModelMaps.liveDataStopRoutesDto.observe( viewLifecycleOwner, {
            routesAdapter.setRoutes(it)
        })
    }

    override fun onRouteSelect(stopId: String, route: Route) {
        viewModelMaps.onClosestTrip(stopId, route)
    }
}