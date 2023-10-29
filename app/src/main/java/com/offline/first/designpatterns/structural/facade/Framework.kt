package com.offline.first.designpatterns.structural.facade

import java.net.URI

/* These are some of the classes of a complex 3rd-party video
 conversion framework. We don't control that code, therefore
 can't simplify it.*/

class VideoFile(fileName: String)
// ...

abstract class SourceCodec

class OggCompressionCodec : SourceCodec()
// ...

class MPEG4CompressionCodec : SourceCodec()
// ...

object CodecFactory {
    fun extract(file: VideoFile): SourceCodec {
        return OggCompressionCodec()
    }
}
// ...

object BitrateReader {
    fun read(fileName: String, sourceCodec: SourceCodec): StringBuffer {
        return StringBuffer(fileName)
    }

    fun convert(buffer: StringBuffer, destinationCodec: SourceCodec): URI {
        return URI(buffer.toString())
    }
}
// ...

class AudioMixer {
    fun fix(result: URI): URI {
        return result
    }
}
// ...