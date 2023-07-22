package com.example.birthdayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.font.FontWeight
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
                    TaskManage(
                        title1 = stringResource(id = R.string.all_task_completed), title2 = stringResource(
                            id = R.string.nice_work
                        )
                    )
//                    GreetingImage(message = stringResource(R.string.happy_birthday_puttan), from = stringResource(
//                        R.string.from_pratik))              }
            }
        }
    }
}

@Composable
fun TaskManage(title1: String, title2:String, modifier: Modifier = Modifier){

     Column(verticalArrangement = Arrangement.Center,
         modifier = modifier) {

         Image(painter = painterResource(id = R.drawable.ic_task_completed),
             contentDescription = null,
             Modifier.align(Alignment.CenterHorizontally))

         Text(text = title1, Modifier.align(Alignment.CenterHorizontally)
             .padding(0.dp, 24.dp, 0.dp, 8.dp),
         fontWeight = FontWeight.Bold)

         Text(text = title2,  Modifier.align(Alignment.CenterHorizontally), fontSize = 16.sp)

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

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        TaskManage(
            title1 = stringResource(id = R.string.all_task_completed), title2 = stringResource(
                id = R.string.nice_work
            )
        )
//        GreetingImage(message = stringResource(R.string.happy_birthday_puttan), from = stringResource(
//                    R.string.from_pratik)
//                )
    }
}
}