package com.unixtrong.compose.search.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.unixtrong.compose.search.data.sampleData
import com.unixtrong.compose.search.utils.debug

private const val TAG = "ResultList"

@Composable
fun ResultList(keyword: String) {
    LazyColumn {
        val list = if (keyword.isEmpty()) {
            sampleData
        } else {
            sampleData.filter { it.contains(keyword, true) }
        }
        items(list) {
            debug(TAG, "item: $it")
            Text(
                text = it,
                fontSize = 30.sp
            )
        }
    }
}