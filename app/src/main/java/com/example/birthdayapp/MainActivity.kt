package com.example.birthdayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdayapp.ui.theme.HappyBirthdayTheme

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
                    ComposeArticle(title = stringResource(id = R.string.title), para1 = stringResource(
                        id = R.string.para1
                    ), para2 = stringResource(id = R.string.para2) )           }
            }
        }
    }
}

@Composable
fun ComposeArticle(title: String, para1: String, para2: String,modifier: Modifier = Modifier){

  Column(
      modifier = modifier
  ){

      Image(painter = painterResource(id = R.drawable.bg_compose_background),
          contentDescription = null,
      modifier = Modifier.fillMaxWidth())

      Text(
          text = title,
          modifier = Modifier.padding(16.dp),
          fontSize = 25.sp
      )

      Text(text = para1,
          modifier = Modifier
              .padding(16.dp, 0.dp, 16.dp, 0.dp),
          textAlign = TextAlign.Justify
      )

      Text(text = para2,
          modifier = Modifier.padding(16.dp),
          textAlign = TextAlign.Justify
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
//        GreetingText(message = message, from = from,  modifier.fillMaxSize().padding(8.dp))
    }

}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        ComposeArticle(title = stringResource(id = R.string.title), para1 = stringResource(
            id = R.string.para1
        ), para2 = stringResource(id = R.string.para2) )
    }
}