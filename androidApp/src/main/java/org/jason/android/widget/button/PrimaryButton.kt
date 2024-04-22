package org.jason.android.widget.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jason.android.R


@Composable
fun PrimaryButton(
    label: String,
    onClick: () -> Unit
) {

    Button(
        modifier =
        Modifier
            .padding()
            .fillMaxWidth()
            .height(50.dp),
        onClick = {},
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primary),
            contentColor = Color.White
        )
    ) {
        Text(label, fontWeight = FontWeight.Bold)
    }


}