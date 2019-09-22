package com.example.reddit_news.model


class RedditChildrenResponse {
    val data: RedditNewsDataResponse?=null
}

class RedditNewsResponse{
    val data: RedditDataResponse?=null

}


class RedditDataResponse{
    val children: List<RedditChildrenResponse>? = null
    val after: String?=null
    val before: String?=null
}


class RedditNewsDataResponse {
    val author: String?=null
    val title: String? = null
    val num_comments: Int?=0
    val created: Long?=0
    val thumbnail: String? = null
    val thumbnail_url: String? = null
    val url: String?=null
    val secure_media: SecureMedia?=null
    val secure_media_embed: SecureMediaEmbed?=null
}

class SecureMediaEmbed {
    val media_domain_url : String? = null

}

class SecureMedia {
    val oembed : SecureMediaData? =null
}

class SecureMediaData {
    val author_name :String? = null
    val thumbnail_url :String? = null
    val title :String?=null
    val height :Int?=0
    val width :Int?=0
}
