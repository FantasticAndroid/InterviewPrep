package com.offline.first.designpatterns.creational.prototype.com.theatre

interface IPrototype {
    fun getClone(theatreLocation: String) : MovieDetail
}