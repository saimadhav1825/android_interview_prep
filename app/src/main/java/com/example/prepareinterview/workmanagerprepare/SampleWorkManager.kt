package com.example.prepareinterview.workmanagerprepare

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters

class SampleWorkManager(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    val TAG = "SampleWorkManager"

    companion object {
        val KEY_COUNT = "key_count"
    }

    override fun doWork(): Result {
        val out = inputData.getString(KEY_COUNT)
        return try {
            out?.forEach {
                Log.d(TAG, "Work Manger $it")
            }
            Result.success(getDataFromWorkResult())
        } catch (e: Exception) {
            Result.failure()
        }
    }

    private fun getDataFromWorkResult(): Data {
        return Data.Builder().putInt(KEY_COUNT, 1).build()
    }
}