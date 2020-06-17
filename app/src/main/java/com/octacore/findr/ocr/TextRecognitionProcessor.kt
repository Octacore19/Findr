package com.octacore.findr.ocr

/*import com.octacore.commons.CameraImageGraphic
import com.octacore.commons.FrameMetadata
import com.octacore.commons.GraphicOverlay*/

class TextRecognitionProcessor/*: MLVisionProcessorBase<FirebaseVisionText>()*/ {
    /*private val TAG = TextRecognitionProcessor::class.java.simpleName
    private val detector = FirebaseVision.getInstance().onDeviceTextRecognizer

    override fun stop() {
        try {
            detector.close()
        } catch (err: Exception){
            Log.e(TAG, "Exception thrown while trying to close Text Detector: $err")
        }
    }
    override fun detectInImage(image: FirebaseVisionImage): Task<FirebaseVisionText> {
        return detector.processImage(image)
    }

    override fun onSuccess(
        originalCameraImage: Bitmap?,
        results: FirebaseVisionText,
        frameMetadata: FrameMetadata,
        graphicOverlay: GraphicOverlay
    ) {
        graphicOverlay.clear()
        originalCameraImage.let { image ->
            val imageGraphic = CameraImageGraphic(graphicOverlay, image)
            graphicOverlay.add(imageGraphic)
        }
        val blocks = results.textBlocks
        for (i in blocks.indices) {
            val lines = blocks[i].lines
            for (j in lines.indices) {
                val elements = lines[j].elements
                for (k in elements.indices) {
                    val textGraphic = TextGraphic(graphicOverlay, elements[k])
                    graphicOverlay.add(textGraphic)
                }
            }
        }
        graphicOverlay.postInvalidate()
    }

    override fun onFailure(e: Exception) {
        Log.w(TAG, "Text detection failed.$e")
    }*/
}