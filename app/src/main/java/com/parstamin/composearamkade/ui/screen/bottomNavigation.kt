package com.parstamin.composearamkade.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.parstamin.composearamkade.data.model.BottommenuItme
import com.parstamin.composearamkade.ui.theme.bac
import com.parstamin.composearamkade.ui.theme.bacc
import com.parstamin.composearamkade.ui.theme.bottomNav


private fun PeapareItemMenu(): List<BottommenuItme> {
    val bottomNavMenuItem = arrayListOf<BottommenuItme>()
    bottomNavMenuItem.add(BottommenuItme("home", Icons.Filled.Home))
    bottomNavMenuItem.add(BottommenuItme("setting", Icons.Filled.Settings))
    bottomNavMenuItem.add(BottommenuItme("music", Icons.Filled.Face))

    return bottomNavMenuItem
}


@Composable
fun Bottom_navigation() {
    val bottomnavitem = PeapareItemMenu()
    val contex = LocalContext.current.applicationContext
    var selectitem by remember {
        mutableStateOf("home")
    }

    Box(modifier = Modifier.fillMaxSize()) {

        BottomNavigation(
            Modifier.align(Alignment.BottomCenter),
            backgroundColor= bottomNav
        ) {
            bottomnavitem.forEach { menuitem ->
                BottomNavigationItem(
                    selected = (selectitem == menuitem.lable),
                    onClick = {
                        selectitem = menuitem.lable
                        Toast.makeText(contex, menuitem.lable, Toast.LENGTH_SHORT).show()
                    },
                    icon = {
                        Icon(
                            imageVector = menuitem.image,
                            contentDescription = menuitem.lable


                        )
                    },
                    label = { Text(text = menuitem.lable) },
                    enabled = true,
                    unselectedContentColor = Color.White,
                    selectedContentColor = Color.White


                )

            }


        }
    }

}