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
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mobileprojectmanga.data.HomeDetail
import com.example.mobileprojectmanga.data.DiscoverScreen
import com.example.mobileprojectmanga.data.FriendsScreen
import com.example.mobileprojectmanga.data.ProfileScreen
import com.example.mobileprojectmanga.data.LibraryScreen
import com.example.mobileprojectmanga.data.Tab
import com.example.mobileprojectmanga.presentation.FriendsPage
import com.example.mobileprojectmanga.presentation.HomeDetailPage
import com.example.mobileprojectmanga.presentation.HomeListPage
import com.example.mobileprojectmanga.presentation.ProfilePage
import com.example.mobileprojectmanga.presentation.LibraryPage
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
                            painterResource(R.drawable.compass), contentDescription = null
                        )
                    },
                    label = { Text(text = "Découvrir") })
                NavigationBarItem(
                    selected = selectedTab == Tab.LIBRARY,
                    onClick = { selectedTab = Tab.LIBRARY },
                    icon = {
                        Icon(
                            painterResource(R.drawable.book),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Bibliothèque") })
                NavigationBarItem(
                    selected = selectedTab == Tab.FRIENDS,
                    onClick = { selectedTab = Tab.FRIENDS },
                    icon = {
                        Icon(
                            painterResource(R.drawable.friends),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Amis") })
                NavigationBarItem(
                    selected = selectedTab == Tab.PROFILE,
                    onClick = { selectedTab = Tab.PROFILE },
                    icon = {
                        Icon(
                            painterResource(R.drawable.profile),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Profil") })
            }

        })


    { padding ->

        val homeBackStack =
            rememberNavBackStack(DiscoverScreen)
        val libraryBackStack =
            rememberNavBackStack(LibraryScreen)
        val friendsBackStack =
            rememberNavBackStack(FriendsScreen)
        val profileBackStack =
            rememberNavBackStack(ProfileScreen)


        Box(Modifier.padding(horizontal = 8.dp, vertical = 40.dp)) {
            when (selectedTab) {
                Tab.HOME -> HomeTabNavDisplay(homeBackStack)
                Tab.LIBRARY -> NavDisplay(
                    backStack = libraryBackStack, entryProvider = entryProvider {
                        entry<LibraryScreen> { LibraryPage() }
                    })

                Tab.FRIENDS -> NavDisplay(
                    backStack = friendsBackStack, entryProvider = entryProvider {
                        entry<FriendsScreen> { FriendsPage() }
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
            entry<DiscoverScreen>{
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