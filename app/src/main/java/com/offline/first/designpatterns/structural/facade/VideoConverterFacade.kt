package com.offline.first.designpatterns.structural.facade

import java.io.File
import java.net.URI

class VideoConverterFacade : IFacade{

    override fun convert(fileName:String, format:String) : File{

        val file = VideoFile(fileName)
        val sourceCodec : SourceCodec = CodecFactory.extract(file)
        val destinationCodec = if (format == "mp4")
            MPEG4CompressionCodec()
        else
            OggCompressionCodec()

        val buffer = BitrateReader.read(fileName, sourceCodec)
        var result : URI = BitrateReader.convert(buffer, destinationCodec)
        result = AudioMixer().fix(result)
        return File(result)
    }
}