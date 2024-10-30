package com.example.beupdated.registration.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.beupdated.R
import com.example.beupdated.common.route.AuthScreenRoute
import com.example.beupdated.common.route.SignUpScreenRouteD
import com.example.beupdated.registration.presentation.composables.AlertDialogEmailOTP
import com.example.beupdated.registration.presentation.composables.AlertDialogErrorMessage
import com.example.beupdated.registration.presentation.composables.AlertDialogSMSOTP

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenA(
    onReturnAuthScreen: () -> Unit,
    state: SignUpState,
    action: (SignUpAction) -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 25.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.gold).copy(alpha = 0f)
                ),
                title = {
                    Text(
                        text = "Create Account",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onReturnAuthScreen()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) { _ ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.bgimagesignup),
                contentDescription = "Image Background SignUp",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.padding(top = 130.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "What's your name?",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(10.dp))

                Text(
                    text = "Enter the name you use in real life.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    modifier = Modifier.width(280.dp),
                    value = state.firstName,
                    onValueChange = {
                        action(SignUpAction.OnFirstNameChange(it))
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedPlaceholderColor = Color.Black,
                    ),
                    placeholder = {
                        Text("First Name")
                    },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    modifier = Modifier.width(280.dp),
                    value = state.lastName,
                    onValueChange = {
                        action(SignUpAction.OnLastNameChange(it))
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedPlaceholderColor = Color.Black,
                    ),
                    placeholder = {
                        Text("Last Name")
                    },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    modifier = Modifier.width(280.dp),
                    value = state.middleName,
                    onValueChange = {
                        action(SignUpAction.OnMiddleNameChange(it))
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedPlaceholderColor = Color.Black,
                    ),
                    placeholder = {
                        Text("Middle Name")
                    },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(Modifier.height(10.dp))

                Button(
                    modifier = Modifier.width(280.dp),
                    onClick = {
                        action(SignUpAction.OnScreenB)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.blue)
                    )
                ) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp
                    )
                }

                TextButton(
                    onClick = {
                        // TODO:
                    }
                ) {
                    Text(
                        text = "Already have an account?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                }
            }
        }
    }

    if (state.errorMessage.isNotEmpty()) {
        AlertDialogErrorMessage(
            action = action,
            errorMessage = state.errorMessage
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenB(
    onReturnAuthScreen: () -> Unit,
    state: SignUpState,
    action: (SignUpAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 25.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.gold).copy(alpha = 0f)
                ),
                title = {
                    Text(
                        text = "Create Account",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            action(SignUpAction.OnReturnScreenA)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) { _ ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.bgimagesignup),
                contentDescription = "Image Background SignUp",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.padding(top = 130.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.width(330.dp),
                    text = "Enter your email and school ID",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 65.dp),
                    text = "Enter your school email address where you can be reached and your present student ID.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    modifier = Modifier.width(280.dp),
                    value = state.emailAddress,
                    onValueChange = {
                        action(SignUpAction.OnEmailAddressChange(it))
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedPlaceholderColor = Color.Black,
                    ),
                    placeholder = {
                        Text("Email Address")
                    },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    modifier = Modifier.width(280.dp),
                    value = state.studentID,
                    onValueChange = {
                        action(SignUpAction.OnStudentIdChange(it))
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedPlaceholderColor = Color.Black,
                    ),
                    placeholder = {
                        Text("Student ID")
                    },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(Modifier.height(10.dp))

                Button(
                    modifier = Modifier.width(280.dp),
                    onClick = {
                        action(SignUpAction.OnScreenC)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.blue)
                    )
                ) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp
                    )
                }

                TextButton(
                    onClick = {
                        onReturnAuthScreen()
                    }
                ) {
                    Text(
                        text = "Already have an account?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                }
            }
        }
    }

    if (state.errorMessage.isNotEmpty()) {
        AlertDialogErrorMessage(
            action = action,
            errorMessage = state.errorMessage
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenC(
    onReturnAuthScreen: () -> Unit,
    state: SignUpState,
    action: (SignUpAction) -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 25.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.gold).copy(alpha = 0f)
                ),
                title = {
                    Text(
                        text = "Create Account",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            action(SignUpAction.OnReturnScreenB)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) { _ ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.bgimagesignup),
                contentDescription = "Image Background SignUp",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.padding(top = 130.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 50.dp),
                    text = "Enter your phone number",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp
                )
                Spacer(Modifier.height(10.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 65.dp),
                    text = "Enter your phone number where you can be reached.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    modifier = Modifier.width(280.dp),
                    value = state.phoneNumber,
                    onValueChange = {
                        action(SignUpAction.OnPhoneNumberChange(it))
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedPlaceholderColor = Color.Black,
                    ),
                    placeholder = {
                        Text("Phone Number")
                    },
                    shape = RoundedCornerShape(15.dp),
                    leadingIcon = {
                        Text(
                            text = "+63"
                        )
                    }
                )

                Spacer(Modifier.height(10.dp))

                Button(
                    modifier = Modifier.width(280.dp),
                    onClick = {
                        action(SignUpAction.OnScreenD)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.blue)
                    )
                ) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp
                    )
                }

                TextButton(
                    onClick = {
                        onReturnAuthScreen()
                    }
                ) {
                    Text(
                        text = "Already have an account?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                }
            }
        }
    }
    if (state.errorMessage.isNotEmpty()) {
        AlertDialogErrorMessage(
            action = action,
            errorMessage = state.errorMessage
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenD(
    onReturnAuthScreen: () -> Unit,
    state: SignUpState,
    action: (SignUpAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 25.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.gold).copy(alpha = 0f)
                ),
                title = {
                    Text(
                        text = "Create Account",
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            action(SignUpAction.OnReturnScreenC)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) { _ ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.bgimagesignup),
                contentDescription = "Image Background SignUp",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.padding(top = 130.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Enter your password",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 65.dp),
                    text = "Create a password with at least 8 characters. It should be something others couldn’t guess.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    modifier = Modifier.width(280.dp),
                    value = state.password,
                    onValueChange = {
                        action(SignUpAction.OnPasswordChange(it))
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedPlaceholderColor = Color.Black,
                    ),
                    placeholder = {
                        Text("Password")
                    },
                    shape = RoundedCornerShape(15.dp),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(Modifier.height(10.dp))

                Button(
                    modifier = Modifier.width(280.dp),
                    onClick = {
                        action(SignUpAction.OnScreenVerification)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.blue)
                    )
                ) {
                    Text(
                        text = "SignUp",
                        fontSize = 16.sp
                    )
                }

                TextButton(
                    onClick = {
                        onReturnAuthScreen()
                    }
                ) {
                    Text(
                        text = "Already have an account?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                }
            }
        }
    }

    if (state.onSmsOtp) {
        AlertDialogSMSOTP(
            title = "SMS OTP",
            description = "We sent a 6-digit SMS OTP to your mobile number. Please enter the code below within 5 minutes.",
            action = action
        )
    }

    if (state.onEmailOtp) {
        AlertDialogEmailOTP(
            title = "Email OTP",
            description = "We sent a 6-digit email OTP to your email address. Please enter the code below within 5 minutes.",
            action = action,
        )
    }

    if (state.errorMessage.isNotEmpty()) {
        AlertDialogErrorMessage(
            action = action,
            errorMessage = state.errorMessage
        )
    }
}


@PreviewLightDark
@Composable
private fun SignUpScreenCPrev() {
    SignUpScreenB(
        onReturnAuthScreen = {},
        state = SignUpState(),
        action = {}
    )
}