package com.unixtrong.compose.search.ui.main

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onFilter: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    var keyword by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(IntrinsicSize.Min)
    ) {
        OutlinedTextField(
            value = keyword,
            onValueChange = {
                keyword = it
                onFilter.invoke(it)
            },
            label = { Text(text = "Search") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearch.invoke(keyword)
            }),
            modifier = Modifier.weight(2F)
        )
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(onFilter = {}, onSearch = {})
}