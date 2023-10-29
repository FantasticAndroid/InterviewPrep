package com.offline.first.designpatterns.structural.facade

import java.io.File

interface IFacade {
    fun convert(fileName:String, format:String) : File
}