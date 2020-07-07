package info.xlkn.paws

// Keep track of data classes / Model Objects

data class Feed(val total: Int, val total_pages: Int, val results: List<Results>)

data class Results(
              val id: String,
              val created_at: String,
              val updated_at: String?,
              val promoted_at: String?,
              val width: Int,
              val height: Int,
              val colour: String?,
              val description: String?,
              val alt_description: String?,
              val urls: Urls,
              val links: Links,
              val user: User)

data class Urls(val raw: String,
           val full: String,
           val regular: String,
           val small: String,
           val thumb: String)

data class Links(val self: String,
                 val html: String,
                 val photos: String?,
                 val likes: String?,
                 val portfolio: String?,
                 val download: String?,
                 val download_location: String?)

data class User(val id: String,
                val username: String,
                val name: String,
                val portfolio_url: String?,
                val bio: String?,
                val location: String?,
                val total_likes: Int,
                val total_photos: Int,
                val total_collection: Int,
                val profile_image: Urls,
                val links: Links)




