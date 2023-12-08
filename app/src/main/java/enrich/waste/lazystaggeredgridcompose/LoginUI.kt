package enrich.waste.lazystaggeredgridcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dehaze
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUI() {
    var nameValue = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Memory Blocks", fontSize = 30.sp)
        }


        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 17.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Vrindavan Chale?...", fontSize = 25.sp)
            Icon(
                imageVector = Icons.Filled.Dehaze,
                contentDescription = "",
                tint = Color.LightGray,
                modifier = Modifier
                    .padding(end = 18.dp)
                    .size(25.dp)
            )
        }


        LazyStaggerdGrid()


    }
}


@Composable
fun LazyStaggerdGrid() {

    val items = (1..100).map {
        ListItem(
            height = Random.nextInt(100, 300).dp,
            color = Color(
                Random.nextLong(0xFFFFFFFF)
            ).copy(alpha = 1f),
            image = images.random()
        )
    }
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {

        items(items) { item ->
            RandomColorBox(item = item)
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
    R.drawable.img_10,
    R.drawable.img_4,
    R.drawable.img_3,
    R.drawable.img_5,
    R.drawable.img_6,
    R.drawable.img_7,
    R.drawable.img_9,
    R.drawable.img_11,
    R.drawable.img_12


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

