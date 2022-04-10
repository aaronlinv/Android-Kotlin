package com.al.kotlin01helloworld

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
data class Poem(
    var title: String,
    var author: String,
    var contents: List<String>
)