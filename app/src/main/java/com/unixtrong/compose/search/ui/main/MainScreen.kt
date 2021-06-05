package com.unixtrong.compose.search.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        var keyword by remember { mutableStateOf("") }
        SearchBar(
            onFilter = { keyword = it },
            onSearch = { keyword = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider()
        Spacer(modifier = Modifier.height(5.dp))
        ResultList(keyword)
    }

}