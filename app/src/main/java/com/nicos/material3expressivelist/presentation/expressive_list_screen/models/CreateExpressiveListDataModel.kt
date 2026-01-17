package com.nicos.material3expressivelist.presentation.expressive_list_screen.models

import android.content.Context
import com.nicos.material3expressivelist.R
import com.nicos.material3expressivelist.presentation.navigation.ButtonGroupsScreen
import com.nicos.material3expressivelist.presentation.navigation.FabMenuScreen
import com.nicos.material3expressivelist.presentation.navigation.FabMenuWithListScreen
import com.nicos.material3expressivelist.presentation.navigation.FloatingToolBarScreen
import com.nicos.material3expressivelist.presentation.navigation.FloatingToolBarWithListScreen
import com.nicos.material3expressivelist.presentation.navigation.LoadingProgressIndicatorScreen
import com.nicos.material3expressivelist.presentation.navigation.SliderScreen
import com.nicos.material3expressivelist.presentation.navigation.SplitButtonsScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CreateExpressiveListDataModel(
    private val context: Context
) {

    fun createExpressiveListDataModel(): Flow<MutableList<ExpressiveListDataModel>> {
        return flow {
            val list = mutableListOf<ExpressiveListDataModel>()

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.button_groups),
                    screenRoutes = ButtonGroupsScreen
                )
            )

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.split_buttons),
                    screenRoutes = SplitButtonsScreen
                )
            )

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.loading_progress_indicator),
                    screenRoutes = LoadingProgressIndicatorScreen
                )
            )

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.fab_menu_with_list),
                    screenRoutes = FabMenuWithListScreen
                )
            )

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.fab_menu),
                    screenRoutes = FabMenuScreen
                )
            )

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.floating_toolbar_with_list),
                    screenRoutes = FloatingToolBarWithListScreen
                )
            )

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.floating_toolbar),
                    screenRoutes = FloatingToolBarScreen
                )
            )

            list.add(
                ExpressiveListDataModel(
                    context.getString(R.string.sliders),
                    screenRoutes = SliderScreen
                )
            )

            emit(list)
        }
    }
}