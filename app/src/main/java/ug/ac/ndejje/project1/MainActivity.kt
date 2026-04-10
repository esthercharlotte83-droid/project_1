package ug.ac.ndejje.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ug.ac.ndejje.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Project1Theme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    StudentID()
                }
            }
        }
    }
}

@Composable
fun StudentID() {
    // Note: I've used ic_launcher_background as a placeholder. 
    // Please ensure ndu_logo, uganda_flag, and student_photo are added to your res/drawable folder.
    val logoPlaceholder = R.drawable.ic_launcher_background
    val flagPlaceholder = R.drawable.ic_launcher_background
    val photoPlaceholder = R.drawable.ic_launcher_background

    ElevatedCard(
        modifier = Modifier
            .width(340.dp)
            .height(180.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {

        Box {
            // WATERMARK BACKGROUND
            Image(
                painter = painterResource(id = R.drawable.ndu_ndejje_logo),
                contentDescription = "watermark",
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.CenterStart)
                    .alpha(0.08f)
            )

            Image(
                painter = painterResource(id = R.drawable.ndu_ndejje_logo),
                contentDescription = "watermark",
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.CenterEnd)
                    .alpha(0.08f)
            )

            Column {
                // HEADER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color(0xFF8B1E1E))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ndu_ndejje_logo),
                            contentDescription = "ndu-ndejje-logo",
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .background(color = Color.White, CircleShape)
                                .size(45.dp)
                                .clip(CircleShape)
                        )

                        Image(
                            painter = painterResource(R.drawable.uganda_flag),
                            contentDescription = "uganda-flag",
                            modifier = Modifier.size(45.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // DETAILS
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "NAKAZIBA ESTHER CHARLOTTE",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 12.sp
                    )

                    Text(
                        text = "Programme: BSc in Information Technology",
                        fontSize = 11.sp,
                        lineHeight = 12.sp
                    )

                    Text(
                        text = "Registration Number: 24/2/314/D/041J",
                        fontSize = 11.sp,
                        lineHeight = 12.sp
                    )

                    Text(
                        text = "Issue: 01/02/2026   Expiry: 01/02/2029",
                        fontSize = 11.sp,
                        lineHeight = 12.sp
                    )

                    // BARCODE PLACEHOLDER
                    Row(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .padding(bottom = 4.dp)
                            .height(20.dp)
                            .fillMaxWidth(0.95f),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(85) { index ->
                            Box(
                                modifier = Modifier
                                    .width(1.dp)
                                    .fillMaxHeight()
                                    .background(Color.Black)
                            )
                            Spacer(modifier = Modifier.width(1.dp))
                        }
                    }
                }

                // FOOTER COLOR (same as header)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .background(Color(0xFF8B1E1E))
                )
            }

            // PHOTO
            Image(
                painter = painterResource(id = R.drawable.student_photo),
                contentDescription = "student-photo",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF8B1E1E), CircleShape)
                    .align(Alignment.TopCenter)
                    .offset(y = 1.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IDPreview() {
    Project1Theme {
        StudentID()
    }
}
