package cvut.fit.pidmobapp.utils

import com.google.maps.android.clustering.ClusterItem

abstract class BaseClusterItem : ClusterItem {

    abstract val drawable: Int
    abstract val color: Int

}