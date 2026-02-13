package com.legacydefender.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.legacydefender.R
import com.legacydefender.root.RootManager
import com.legacydefender.scanner.ProcScanner

class MainActivity : AppCompatActivity() {

    private lateinit var statusText: TextView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusText = findViewById(R.id.statusText)
        resultText = findViewById(R.id.resultText)

        // Kiểm tra root
        val hasRoot = RootManager.hasRoot()
        statusText.text = if (hasRoot) "✅ Root available" else "❌ No root"

        // Thử quét process nếu có root
        if (hasRoot) {
            val processList = ProcScanner.scanProcesses()
            resultText.text = "Processes:\n" + processList.joinToString("\n")
        } else {
            resultText.text = "Limited mode: cannot scan processes"
        }
    }
}
