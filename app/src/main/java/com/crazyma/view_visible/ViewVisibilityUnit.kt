package com.crazyma.view_visible

import androidx.collection.ArrayMap


/**
 * @author Batu
 */
class ViewVisibilityUnit {

    var isVisible: Boolean = false
        set(value) {
            field = value

            children.forEach { (viewVisibilityUnit, b) ->
                viewVisibilityUnit.isVisible = value
            }
        }
    var parent: ViewVisibilityUnit? = null
    var children = ArrayMap<ViewVisibilityUnit, Boolean>()


}