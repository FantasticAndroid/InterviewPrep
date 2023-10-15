package com.offline.first.designpatterns.structural.facade

object FacadeImpl {

    fun applyFacadeImpl(){

        val facade = VideoConverterFacade()
        val file = facade.convert("videoFile.ogg", ".mp4")
        file.exists()
    }
}