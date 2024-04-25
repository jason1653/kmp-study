package org.jason.android.widget.textfield

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jason.android.R

@Composable
fun DefaultTextField(
    label: String,
    titleKey: String,
    secured: Boolean,
    errorMessage: String?,
    text: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            color = if (errorMessage != null && text.isNotEmpty()) Color.Red else Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text,
            onValueChange = {
                Log.d("TEST", it)
                Log.d("TEST", "TextField 입력")
                onValueChange(it)
            },
            placeholder = { Text(text = titleKey) },
            singleLine = true,
            visualTransformation = if (secured) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),

            shape = RoundedCornerShape(5.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = Color.Black,
                unfocusedBorderColor = colorResource(id = R.color.gray),
                focusedBorderColor = colorResource(id = R.color.gray),
            )
        )

        if (errorMessage != null && text.isNotEmpty()) {
            Text(
                text = errorMessage,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp),
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp, start = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true, name = "DefaultTextField Preview")
@Composable
fun PreviewDefaultTextField() {
    // LocalContext는 Composable 함수에서 Context를 참조할 때 사용됩니다.
    val context = LocalContext.current
    val textState by remember { mutableStateOf("") }

    DefaultTextField(
        label = "Email",
        titleKey = "Enter your email",
        secured = false,
        errorMessage = "Invalid email format",
        text = textState,
        onValueChange = {

        }
    )
}