package com.nicos.material3expressivelist.presentation.navigation.navigation_3

import androidx.navigation3.runtime.NavKey

/**
 * Handles navigation events (forward and back) by updating the navigation state.
 */
class Navigator(val state: NavigationState) {
    fun navigate(route: NavKey) {
        state.stacksInUse.add(route)
    }

    fun goBack() {
        if (state.stacksInUse.size > 1)
            state.stacksInUse.removeLastOrNull()
    }
}