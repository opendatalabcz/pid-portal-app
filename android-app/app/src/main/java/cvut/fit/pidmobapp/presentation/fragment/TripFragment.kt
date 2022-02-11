package cvut.fit.pidmobapp.presentation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.google.android.material.bottomsheet.BottomSheetBehavior
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.databinding.FragmentTripBinding
import cvut.fit.pidmobapp.domain.viewmodel.MapsSharedViewModel
import cvut.fit.pidmobapp.domain.actions.DeleteFavouriteAction
import cvut.fit.pidmobapp.domain.actions.GetFavouriteTripByUidAction
import cvut.fit.pidmobapp.domain.actions.SaveFavouriteTripAction
import cvut.fit.pidmobapp.config.Config
import cvut.fit.pidmobapp.utils.mapper.TripMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.SimpleDateFormat

class TripFragment : BaseFragment() {

    private lateinit var binding: FragmentTripBinding
    override val bottomSheetState = BottomSheetBehavior.STATE_HALF_EXPANDED
    override val name = Config.TRIP_FRAGMENT_NAME

    private val getFavouriteTripByUidAction: GetFavouriteTripByUidAction by inject()
    private val saveFavouriteTripAction: SaveFavouriteTripAction by inject()
    private val deleteFavouriteAction: DeleteFavouriteAction by inject()

    private val mViewModelMaps: MapsSharedViewModel by sharedViewModel()

    private var selectedTrip: Trip? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTripBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences(Config.SHARED_PREFERENCES,
            Context.MODE_PRIVATE)
        val token = sharedPreferences.getString(Config.SP_TOKEN, null)
        if (token != null) {
            binding.likeIb.visibility = View.VISIBLE
            binding.likeIb.setOnClickListener{
                selectedTrip?.let {
                    CoroutineScope(Dispatchers.Default).launch {
                        val trip = getFavouriteTripByUidAction.execute(it.uid)

                        if (trip != null) {
                            deleteFavouriteAction.execute(it, token)
                            setUnLike()
                        } else {
                            saveFavouriteTripAction.execute(it, token)
                            setLike()
                        }
                    }
                }
            }
        }

        val pattern = SimpleDateFormat("hh:mm")

        mViewModelMaps.liveDataTripVehicle.observe(viewLifecycleOwner, {
            binding.routeNameTv.text = "Route: " + it.vehicle.originRouteName + "\nTrip ID: " + it.trip.uid
            binding.directionNameTv.text = it.vehicle.nextStop.name
            binding.nextBusArrivalTv.text = pattern.format(it.vehicle.nextStopArrival)
            binding.delayVariableTv.text = it.vehicle.delay.toString()

            if (it.delays.isNotEmpty()) {
                if (it.delays.isNotEmpty()) {
                    binding.delay1Tv.text = "Delay for " + it.delays[0].date
                    binding.delayVariable1Tv.text = it.delays[0].delayMin.toString() + " mins"
                } else {
                    binding.delay1Tv.isVisible = false
                    binding.delayVariable1Tv.isVisible = false
                }

                if (it.delays.size > 1) {
                    binding.delay2Tv.text = "Delay for " + it.delays[1].date
                    binding.delayVariable2Tv.text = it.delays[1].delayMin.toString() + " mins"
                } else {
                    binding.delay2Tv.isVisible = false
                    binding.delayVariable2Tv.isVisible = false
                }

                if (it.delays.size > 2) {
                    binding.delay3Tv.text = "Delay for " + it.delays[2].date
                    binding.delayVariable3Tv.text = it.delays[2].delayMin.toString() + " mins"
                } else {
                    binding.delay3Tv.isVisible = false
                    binding.delayVariable3Tv.isVisible = false
                }
                if (it.delays.size > 3) {
                    binding.delay4Tv.text = "Delay for " + it.delays[3].date
                    binding.delayVariable4Tv.text = it.delays[3].delayMin.toString() + " mins"
                } else {
                    binding.delay4Tv.isVisible = false
                    binding.delayVariable4Tv.isVisible = false
                }

                if (it.delays.size > 4) {
                    binding.delay5Tv.text = "Delay for " + it.delays[4].date
                    binding.delayVariable5Tv.text = it.delays[4].delayMin.toString() + " mins"
                } else {
                    binding.delay5Tv.isVisible = false
                    binding.delayVariable5Tv.isVisible = false
                }

                if (it.delays.size > 5) {
                    binding.delay6Tv.text = "Delay for " + it.delays[5].date
                    binding.delayVariable6Tv.text = it.delays[5].delayMin.toString() + " mins"
                } else {
                    binding.delay6Tv.isVisible = false
                    binding.delayVariable6Tv.isVisible = false
                }

                if (it.delays.size > 6) {
                    binding.delay7Tv.text = "Delay for " + it.delays[6].date
                    binding.delayVariable7Tv.text = it.delays[6].delayMin.toString() + " mins"
                } else {
                    binding.delay7Tv.isVisible = false
                    binding.delayVariable7Tv.isVisible = false
                }

                var sum = 0.0
                for (delay in it.delays) {
                    sum += delay.delayMin
                }
                sum /= it.delays.size
                binding.delayAverVariableTv.text = sum.toString() + "mins"
            } else {
                binding.delay1Tv.isVisible = false
                binding.delayVariable1Tv.isVisible = false
                binding.delay2Tv.isVisible = false
                binding.delayVariable2Tv.isVisible = false
                binding.delay3Tv.isVisible = false
                binding.delayVariable3Tv.isVisible = false
                binding.delay4Tv.isVisible = false
                binding.delayVariable4Tv.isVisible = false
                binding.delay5Tv.isVisible = false
                binding.delayVariable5Tv.isVisible = false
                binding.delay6Tv.isVisible = false
                binding.delayVariable6Tv.isVisible = false
                binding.delay7Tv.isVisible = false
                binding.delayVariable7Tv.isVisible = false
                binding.delayAverTv.isVisible = false
                binding.delayAverVariableTv.isVisible = false
            }

            selectedTrip = TripMapper.toTrip(it.vehicle.trip)

            if (token != null) {
                CoroutineScope(Dispatchers.Default).launch {
                    val favouriteRoute = getFavouriteTripByUidAction.execute(tripUid = it.trip.uid)

                    favouriteRoute?.let {
                        setLike()
                    }
                }
            }
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