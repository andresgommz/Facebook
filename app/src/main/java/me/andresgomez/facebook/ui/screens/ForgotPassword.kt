package me.andresgomez.facebook.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FacebookBlueLink = Color(0xFF0064E0)
private val FacebookFieldBorder = Color(0xFFCCD0D5)
private val FacebookPlaceholderColor = Color(0xFF8A8D91)
private val FacebookSubtextColor = Color(0xFF4B4C4F)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    accountInfo: String = "andresgomez • Facebook",
    email: String = "",
    newPassword: String = "",
    retypePassword: String = "",
    onEmailChange: (String) -> Unit = {},
    onNewPasswordChange: (String) -> Unit = {},
    onRetypePasswordChange: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onBackToLoginClick: () -> Unit = {},
    onChangePasswordClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Ir atrás",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF7F9FC)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFF7F9FC))
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Identificador de cuenta / Facebook
            Text(
                text = accountInfo,
                fontSize = 14.sp,
                color = FacebookSubtextColor,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Título principal: Cambiar contraseña
            Text(
                text = "Cambiar contraseña",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Subtítulo / Descripción
            Text(
                text = "Tu contraseña debe tener al menos seis caracteres e incluir una combinación de números, letras y caracteres especiales (!$@%).",
                fontSize = 15.sp,
                color = FacebookSubtextColor,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo 1: Ingresa tu correo
            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
                placeholder = {
                    Text(
                        text = "Ingresa tu correo",
                        color = FacebookPlaceholderColor,
                        fontSize = 15.sp
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = FacebookBlueLink,
                    unfocusedBorderColor = FacebookFieldBorder
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo 2: Ingresa tu nueva contraseña
            OutlinedTextField(
                value = newPassword,
                onValueChange = onNewPasswordChange,
                placeholder = {
                    Text(
                        text = "Ingresa tu nueva contraseña",
                        color = FacebookPlaceholderColor,
                        fontSize = 15.sp
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = FacebookBlueLink,
                    unfocusedBorderColor = FacebookFieldBorder
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo 3: Repite tu nueva contraseña
            OutlinedTextField(
                value = retypePassword,
                onValueChange = onRetypePasswordChange,
                placeholder = {
                    Text(
                        text = "Repite tu nueva contraseña",
                        color = FacebookPlaceholderColor,
                        fontSize = 15.sp
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = FacebookBlueLink,
                    unfocusedBorderColor = FacebookFieldBorder
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Enlace "Volver a iniciar sesión"
            Text(
                text = "Volver a iniciar sesión",
                color = FacebookBlueLink,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { onBackToLoginClick() }
            )

            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(32.dp))

            // Botón inferior: Cambiar contraseña
            val isButtonEnabled = email.isNotBlank() && newPassword.isNotBlank() && retypePassword.isNotBlank()
            val buttonColor = if (isButtonEnabled) Color(0xFF0064E0) else Color(0xFFA8C7FA)

            Button(
                onClick = onChangePasswordClick,
                enabled = isButtonEnabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFFA8C7FA),
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "Cambiar contraseña",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun ForgotPassword(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
) {
    var email by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var retypePassword by remember { mutableStateOf("") }

    ForgotPasswordScreen(
        modifier = modifier,
        email = email,
        newPassword = newPassword,
        retypePassword = retypePassword,
        onEmailChange = { email = it },
        onNewPasswordChange = { newPassword = it },
        onRetypePasswordChange = { retypePassword = it },
        onBackClick = onBackClick,
        onBackToLoginClick = onBackClick,
        onChangePasswordClick = {
            onBackClick()
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}
