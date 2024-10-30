package com.example.beupdated.search.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beupdated.authentication.presentation.AuthAction
import com.example.beupdated.registration.presentation.SignUpAction

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    description: String
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = description,
            fontSize = 18.sp
        )
        IconButton(
            onClick = {}
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = Icons.Default.Clear,
                contentDescription = null
            )
        }
    }
}



@Preview
@Composable
private fun Prev() {
    SearchItem(
        description = "Pokoloko"
    )
}