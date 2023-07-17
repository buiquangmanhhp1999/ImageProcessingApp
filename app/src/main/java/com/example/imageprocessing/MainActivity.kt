package com.example.imageprocessing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imageprocessing.ui.theme.ImageProcessingTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import com.example.imageprocessing.Visualize.drawRectangle
import org.opencv.android.OpenCVLoader
import org.opencv.core.Point
import org.opencv.core.Scalar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpenCVLoader.initDebug();
        setContent {
            ImageProcessingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    displayImage(
                        description = "Original Image: ",
                        imageID = R.drawable.sample1
                    )
                }
            }
        }
    }
}


// on below line we are creating a
// function to read image from file path.
@Composable
fun displayImage(
    description: String,
    imageID: Int
) {

    // on below line we are creating a column on below sides.
    Column(
        // on below line we are adding padding
        // padding for our column and filling the max size.
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        // on below line we are adding
        // horizontal alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        // on below line we are adding
        // vertical arrangement for our column
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            // on below line we are specifying text to display.
            text = description,

            // on below line we are specifying
            // modifier to fill max width.
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            // on below line we are
            // specifying text alignment.
            textAlign = TextAlign.Center,

            // on below line we are
            // specifying color for our text.
            color = Color.Black,

            // on below line we are
            // specifying font weight
            fontWeight = FontWeight.Bold,

            // on below line we
            // are updating font size.
            fontSize = 25.sp,
        )

        // read image from image resource ans display it on screen
        val oriImageBitmap = ImageBitmap.imageResource(id = imageID)
        val oriImageWidth = oriImageBitmap.width.toDouble()

        drawRectangle(
            oriImageBitmap.asAndroidBitmap(),
            Point(0.0,  7 * oriImageWidth / 8),
            Point(oriImageWidth, oriImageWidth),
            Scalar( 0.0, 255.0, 255.0 ),
            -1,
            8,
        )

        Image(
            painter = BitmapPainter(image = oriImageBitmap),
            contentDescription = description,
            contentScale = ContentScale.Crop,
            modifier = Modifier.wrapContentSize()
        )

        // apply image processing algorithms into given image


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageProcessingTheme {
        displayImage(
            description = "Original Image: ",
            imageID = R.drawable.sample1
        )
    }
}