package enrich.waste.lazystaggeredgridcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import enrich.waste.lazystaggeredgridcompose.ui.theme.LazyStaggeredGridComposeTheme
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = (1..100).map {
            ListItem(
                height = Random.nextInt(100, 300).dp,
                color = Color(
                    Random.nextLong(0xFFFFFFFF)
                ).copy(alpha = 1f),
                image = images.random()
            )
        }
        setContent {
            LazyStaggeredGridComposeTheme {
                LazyVerticalStaggeredGrid(
//                    columns = StaggeredGridCells.Adaptive(50.dp),
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalItemSpacing = 16.dp
//                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    items(items) { item ->
                        RandomColorBox(item = item)
                    }

                }
            }
        }
    }
}


data class ListItem(
    val height: Dp,
    val image: Int,
    val color: androidx.compose.ui.graphics.Color
)


val images = listOf(
    R.drawable.img,
    R.drawable.img_1,
    R.drawable.img_2,
    R.drawable.img_3,
    R.drawable.img_4
)


@Composable
fun RandomColorBox(item: ListItem) {

    val context = LocalContext.current





    Box(
        modifier = Modifier

            .height(item.height)
            .clip(RoundedCornerShape(10.dp))
            .background(item.color)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 5.dp)
        )
    }
}

