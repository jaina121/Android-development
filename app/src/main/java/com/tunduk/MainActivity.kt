package com.tunduk

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "onCreate called")
        setContent {
            // Применяем фоновый цвет ко всему приложению
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFD2E8D4) // Светло-зеленый фон
            ) {
                BusinessCardApp()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy called")
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Верхняя/центральная часть с именем и должностью
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MainInfoSection()
        }

        // Нижняя часть с контактной информацией
        ContactInfoSection()
        
        // Отступ снизу
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun MainInfoSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Логотип (Box с иконкой внутри)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color(0xFF073042), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Color(0xFF3DDC84),
                modifier = Modifier.size(80.dp)
            )
        }
        
        // Имя
        Text(
            text = "Jaina joodonbecova",
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        
        // Должность
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006D3B)
        )
    }
}

@Composable
fun ContactInfoSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ContactRow(
            icon = Icons.Default.Phone,
            text = "+11 (123) 444 555 666"
        )
        ContactRow(
            icon = Icons.Default.Share,
            text = "@AndroidDev"
        )
        ContactRow(
            icon = Icons.Default.Email,
            text = "jen.doe@android.com"
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFD2E8D4)
    ) {
        BusinessCardApp()
    }
}
