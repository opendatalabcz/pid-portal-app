package cvut.fit.pidmobapp.presentation.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.databinding.FragmentRouteBinding
import cvut.fit.pidmobapp.domain.viewmodel.MapsSharedViewModel
import cvut.fit.pidmobapp.domain.actions.DeleteFavouriteRouteAction
import cvut.fit.pidmobapp.domain.actions.GetFavouriteRouteByUidAction
import cvut.fit.pidmobapp.domain.actions.SaveFavouriteRouteAction
import cvut.fit.pidmobapp.config.Config
import cvut.fit.pidmobapp.config.Config.SP_TOKEN
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RouteFragment : BaseFragment() {

    private lateinit var binding: FragmentRouteBinding
    override val name = Config.ROUTE_FRAGMENT_NAME
    override val bottomSheetState = BottomSheetBehavior.STATE_HALF_EXPANDED

    private val getFavouriteRouteByUidAction: GetFavouriteRouteByUidAction by inject()
    private val deleteFavouriteRouteAction: DeleteFavouriteRouteAction by inject()
    private val saveFavouriteRoute: SaveFavouriteRouteAction by inject()

    private var selectedRoute: Route? = null
    private lateinit var sharedPreferences: SharedPreferences

    private val mViewModelMaps: MapsSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRouteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences(Config.SHARED_PREFERENCES,Context.MODE_PRIVATE)

        val token = sharedPreferences.getString(SP_TOKEN, null)
        if (token != null) {

            binding.likeIb.visibility = View.VISIBLE

            binding.likeIb.setOnClickListener{
                selectedRoute?.let {

                    CoroutineScope(Dispatchers.Default).launch {
                        val route = getFavouriteRouteByUidAction.execute(it.uid)

                        if (route != null) {
                            deleteFavouriteRouteAction.execute(selectedRoute!!, token)
                            setUnLike()
                        } else {
                            saveFavouriteRoute.execute(selectedRoute!!, token)
                            setLike()
                        }
                    }

                }
            }
        }

        mViewModelMaps.liveDataRoute.observe(viewLifecycleOwner, {
            binding.routeShortNameTv.text = it.shortName
            binding.routeLongNameTv.text = it.longName

            if (token != null){
                CoroutineScope(Dispatchers.Default).launch {
                    val favouriteRoute = getFavouriteRouteByUidAction.execute(routeUid = it.uid)

                    favouriteRoute?.let {
                        setLike()
                    }
                }
            }

            selectedRoute = it
        })
    }

    private fun setLike() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.likeIb.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }

    private fun setUnLike() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.likeIb.setImageResource(R.drawable.ic_favorite_border)
        }
    }
}