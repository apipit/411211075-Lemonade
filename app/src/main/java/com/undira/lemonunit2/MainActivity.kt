package com.undira.lemonunit2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.undira.lemonunit2.ui.theme.LemonUnit2Theme
import java.lang.Math.random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonUnit2Theme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
    LemonTombol()
                }
            }
        }
    }
    companion object{
        var count = 0
        var squeezeTimes = (random() * 4).toInt()
}

    @Composable
    fun TextHeader() {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            color = MaterialTheme.colorScheme.primary // Use primary color from theme
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Fills entire width
                    .padding(horizontal = 16.dp) // Add padding after centering
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimary // Use contrasting color for text
                )
            }

        }
    }

@Composable
fun LemonTombol(){
    Column {
        TextHeader()
    }

    var lemonStep by remember { mutableStateOf(0)}
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LemonText(lemonStep)
        LemonImage(lemonStep){
            lemonStep = ClickBehavior(lemonStep)
        }
    }
}
//    logika lemonn set dah
    fun ClickBehavior(lemonStep: Int):Int {

        Log.d("count", "${count}")
        Log.d("lemonStep", "${lemonStep}")

        return when(lemonStep){
            0 -> {
                1
            }
            1 -> {
                if (count < MainActivity.squeezeTimes){
                    count++
                    1
                } else {
                    2
                }
            }
            2 -> {
                3
            }
            else -> {
                count = 0
                MainActivity.squeezeTimes = (random() * 4).toInt()
                0
            }
        }
    }


//ini kenapa kebalik ya zzz - 411211075

    @Composable
    fun LemonImage(
        lemonStep: Int,
        OnTap: () -> Unit) {
        var lemonImages = listOf(
            R.drawable.lemon_tree,
            R.drawable.lemon_squeeze,
            R.drawable.lemon_drink,
            R.drawable.lemon_restart
        )

        Image(
            painter = painterResource(id = lemonImages[lemonStep]),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    OnTap()
                }
                .clip(RoundedCornerShape(8.dp))
        )
    }
    @Composable
    fun LemonText(lemonStep: Int){
        var lemonTexts = listOf(
            R.string.Lemon_tree,
            R.string.Lemon,
            R.string.Glass_of_lemonade,
            R.string.Empty_glass
        )

        Text(
            text = stringResource(lemonTexts[lemonStep])
        )

    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonUnit2Theme {
        LemonTombol()
    }
}}