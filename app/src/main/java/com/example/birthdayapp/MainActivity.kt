package com.example.birthdayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdayapp.ui.theme.HappyBirthdayTheme
import com.example.birthdayapp.ui.theme.q1
import com.example.birthdayapp.ui.theme.q2
import com.example.birthdayapp.ui.theme.q3
import com.example.birthdayapp.ui.theme.q4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetQuadrants()             }
            }
        }
    }
}

@Composable
fun SetQuadrants(){
    Column(Modifier.fillMaxWidth()){

        Row(Modifier.weight(1f)) {
            Quadrant(title = stringResource(id = R.string.title1),
                para = stringResource(id = R.string.para1), color = q1, Modifier.weight(1f))
            Quadrant(title = stringResource(id = R.string.title2),
                para = stringResource(id = R.string.para2), color = q2, Modifier.weight(1f))
        }

        Row(Modifier.weight(1f)) {
            Quadrant(title = stringResource(id = R.string.title3),
                para = stringResource(id = R.string.para3), color = q3, Modifier.weight(1f))
            Quadrant(title = stringResource(id = R.string.title2),
                para = stringResource(id = R.string.para4), color = q4, Modifier.weight(1f))
        }
    }
}

@Composable
fun Quadrant(title: String, para: String, color: Color, modifier: Modifier){
    Column(
        modifier
            .background(color)
            .padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Text(text = title, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .align(Alignment.CenterHorizontally))

        Text(text = para, textAlign = TextAlign.Justify)
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){

  Column(
      verticalArrangement = Arrangement.Center,
      modifier = modifier
  ){
      Text(
          text = message,
          fontSize = 100.sp,
          lineHeight = 116.sp,
          textAlign = TextAlign.Center
      )

      Text(text = from,
          fontSize = 36.sp,
          modifier = Modifier
              .padding(16.dp)
              .align(Alignment.CenterHorizontally)
      )
  }

}

@Composable
fun GreetingImage(message: String,
                  from: String,
                  modifier: Modifier = Modifier){

    val image = painterResource(id = R.drawable.androidparty)

    //box is used to show ui component above other ui component
    Box{
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f)
        GreetingText(message = message, from = from,
            modifier
                .fillMaxSize()
                .padding(8.dp))
    }

}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        SetQuadrants()
    }
}