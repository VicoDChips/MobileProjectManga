package com.example.mobileprojectmanga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mobileprojectmanga.data.HomeDetail
import com.example.mobileprojectmanga.data.HomeList
import com.example.mobileprojectmanga.data.ProfileScreen
import com.example.mobileprojectmanga.data.SearchScreen
import com.example.mobileprojectmanga.data.Tab
import com.example.mobileprojectmanga.presentation.HomeDetailPage
import com.example.mobileprojectmanga.presentation.HomeListPage
import com.example.mobileprojectmanga.presentation.ProfilePage
import com.example.mobileprojectmanga.presentation.SearchPage
import com.example.mobileprojectmanga.ui.theme.MobileProjectMangaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileProjectMangaTheme {
                MangaAppMain()
            }
        }
    }
}

@Composable
fun MangaAppMain() {
    var selectedTab by rememberSaveable() { mutableStateOf(Tab.HOME) }
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == Tab.HOME,
                    onClick = { selectedTab = Tab.HOME },
                    icon = {
                        Icon(
                            painterResource(R.drawable.ic_action_name), contentDescription = null
                        )
                    },
                    label = { Text(text = "Acceuil") })
                NavigationBarItem(
                    selected = selectedTab == Tab.SEARCH,
                    onClick = { selectedTab = Tab.SEARCH },
                    icon = {
                        Icon(
                            painterResource(R.drawable.outline_feature_search_24),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Recherche") })
                NavigationBarItem(
                    selected = selectedTab == Tab.PROFILE,
                    onClick = { selectedTab = Tab.PROFILE },
                    icon = {
                        Icon(
                            painterResource(R.drawable.outline_account_circle_24),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Profile") })
            }

        })


    { padding ->

        val homeBackStack =
            rememberNavBackStack(HomeList)
        val searchBackStack =
            rememberNavBackStack(SearchScreen)
        val profileBackStack =
            rememberNavBackStack(ProfileScreen)


        Box(Modifier.padding(padding)) {
            when (selectedTab) {
                Tab.HOME -> HomeTabNavDisplay(homeBackStack)
                Tab.SEARCH -> NavDisplay(
                    backStack = searchBackStack, entryProvider = entryProvider {
                        entry<SearchScreen> { SearchPage() }
                    })

                Tab.PROFILE -> NavDisplay(
                    backStack = profileBackStack, entryProvider = entryProvider {
                        entry<ProfileScreen> { ProfilePage() }
                    })
            }
        }
    }
}

@Composable
fun HomeTabNavDisplay(backStack: NavBackStack<NavKey>){
    NavDisplay(
        backStack=backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider= entryProvider {
            entry<HomeList>{
                HomeListPage(
                    onItemClick={ id: String->backStack.add(HomeDetail(id)) }
                )
            }
            entry<HomeDetail>{key ->
                HomeDetailPage(
                    id = key.id,
                    onBack={backStack.removeLastOrNull()}
                )
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileProjectMangaTheme {
        Greeting("Android")
    }
}