package com.offline.first.designpatterns.creational.prototype.com.theatre

class MovieDetail(
    val movieName: String,
    val movieType: String, val theatreLocation: String
) : IPrototype {

    override fun getClone(theatreLocation: String): MovieDetail {
        return MovieDetail(this.movieName, this.movieType, theatreLocation)
    }
}
