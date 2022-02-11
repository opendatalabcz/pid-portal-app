package cvut.fit.pidmobapp.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.databinding.FragmentFavouriteRoutesBinding
import cvut.fit.pidmobapp.domain.viewmodel.MapsSharedViewModel
import cvut.fit.pidmobapp.presentation.adapter.SearchResultAdapter
import cvut.fit.pidmobapp.presentation.interfaces.OnRouteSelectListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavouriteRoutesFragment : DialogFragment(), OnRouteSelectListener {

    private lateinit var binding: FragmentFavouriteRoutesBinding

    private val viewModelMaps: MapsSharedViewModel by sharedViewModel()

    private var searchResultAdapter = SearchResultAdapter(this)
    private lateinit var routeRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteRoutesBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        routeRecyclerView = binding.routesRv
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        routeRecyclerView.layoutManager = llm
        routeRecyclerView.adapter = searchResultAdapter

        viewModelMaps.getFavouriteRoutes()
        viewModelMaps.liveDataFavouriteRoutes.observe(viewLifecycleOwner, {
            searchResultAdapter.setRoutes(it)
        })
    }

    override fun onRouteSelect(stopId: String, route: Route) {
        viewModelMaps.onRouteSelect(route)
        dismiss()
    }
}