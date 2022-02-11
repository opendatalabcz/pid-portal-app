package cvut.fit.pidmobapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.databinding.FragmentSearchResultsBinding
import cvut.fit.pidmobapp.domain.viewmodel.MapsSharedViewModel
import cvut.fit.pidmobapp.domain.actions.GetFavouriteRoutesAction
import cvut.fit.pidmobapp.presentation.adapter.SearchResultAdapter
import cvut.fit.pidmobapp.presentation.interfaces.OnRouteSelectListener
import cvut.fit.pidmobapp.config.Config
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchResultsFragment : BaseFragment(), OnRouteSelectListener {

    private val viewModelMaps: MapsSharedViewModel by sharedViewModel()
    private val getFavouriteRoutesAction: GetFavouriteRoutesAction by inject()
    private var searchResultAdapter = SearchResultAdapter(this)
    private var favouriteRoutesAdapter = SearchResultAdapter(this)
    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var favouriteRoutesRecyclerView: RecyclerView
    private lateinit var binding: FragmentSearchResultsBinding

    override val bottomSheetState: Int
        get() = BottomSheetBehavior.STATE_EXPANDED

    override val name: String
        get() = Config.SEARCH_FRAGMENT_NAME

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSearchResultsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchRecyclerView = binding.searchResultsRv
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        searchRecyclerView.layoutManager = llm
        searchRecyclerView.adapter = searchResultAdapter

        viewModelMaps.liveDataSearchRoute.observe(viewLifecycleOwner, {
            searchResultAdapter.setRoutes(it)
        })
    }

    override fun onRouteSelect(stopId: String, route: Route) {
        viewModelMaps.onRouteSelect(route)
    }
}