package com.example.instacopy.fragments

import android.util.Log
import com.example.instacopy.Post
import com.parse.ParseQuery
import com.parse.ParseUser

class ProfileFragment : FeedFragment() {
    override fun queryPosts() {
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        query.include(Post.KEY_USER)
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser())
        query.addDescendingOrder("createdAt")
        query.limit = 20
        query.findInBackground { posts, e ->
            if (e != null) {
                Log.e(TAG, "some problem")
            } else {
                if (posts != null) {
                    for (post in posts) {
                        Log.i(
                            TAG,
                            "Successful query ${post.getDescription()} by ${post.getUser()
                                ?.fetchIfNeeded()?.username
                            }"
                        )
                    }

                    allPosts.addAll(posts)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}