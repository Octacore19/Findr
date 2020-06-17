package com.octacore.findr.views

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.octacore.commons.StillImage
import com.octacore.findr.R
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {
    private val TAG = CameraActivity::class.java.simpleName
    private val image by lazy { StillImage(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        if (intent != null){
            startCameraIntentForResult()
        }
    }

    private fun startCameraIntentForResult() {
        // Clean up last time's image
        val imageUri: Uri
        previewPane.setImageBitmap(null)

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureIntent.resolveActivity(packageManager)?.let {
            val values = ContentValues()
            values.put(MediaStore.Images.Media.TITLE, "New Picture")
            values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera")
            imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)!!
            Log.i(TAG, "Uri from intent: $imageUri")
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(takePictureIntent, 110)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 110 && resultCode == Activity.RESULT_OK){
            if (data != null){
                val imageUri = data.getStringExtra(MediaStore.EXTRA_OUTPUT)
                Log.i(TAG, "Image URI: $imageUri")
//                image.tryReloadAndDetectInImage(Uri.parse(imageUri), R.id.previewOverlay, R.id.previewPane)
                val intent = Intent()
                intent.putExtra("data", imageUri)
                setResult(100, intent)
                finish()
            }
        }
    }
}
