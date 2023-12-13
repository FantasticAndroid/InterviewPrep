package com.offline.first.designpatterns.creational.prototype

import android.util.Log
import com.offline.first.designpatterns.creational.prototype.com.theatre.MovieDetail

private const val TAG = "PrototypeImpl"

object PrototypeImpl {

    fun applyPrototypeImpl() {
        // Let to Get Movie name "Partner" run in multiple theatres

        val partnerMovieMumbai = MovieDetail(movieName = "Partner", movieType = "Comedy", "Mumbai")
        Log.d(
            TAG,
            "Movie: ${partnerMovieMumbai.movieName}, theatreLocation: ${partnerMovieMumbai.theatreLocation}"
        )

        val partnerMovieDelhi = partnerMovieMumbai.getClone("Delhi")
        Log.d(
            TAG,
            "Movie: ${partnerMovieDelhi.movieName}, theatreLocation: ${partnerMovieDelhi.theatreLocation}"
        )

        val partnerMovieIndore = partnerMovieMumbai.getClone("Indore")
        Log.d(
            TAG,
            "Movie: ${partnerMovieIndore.movieName}, theatreLocation: ${partnerMovieIndore.theatreLocation}"
        )
    }
}